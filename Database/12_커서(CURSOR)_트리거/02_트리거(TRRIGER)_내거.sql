/********** 트리거(TRIGGER) ******************
트리거(TRIGGER) : 특정 이벤트나 DDL, DML 문장이 실행되었을 때,
   자동적으로 어떤 일련의 동작(Operation)이나 처리를 수행하도록 하는
   데이타베이스 객체의 하나 --이벤트를 발생시키면 자동으로 실행되는 것
  -일반적으로 임의의 테이블에 데이타를 입력(추가)(INSERT), 수정(UPDATE), 삭제(DELETE) 할 때,
    다른 연관 관계에 있는 테이블의 데이타를 자동적으로 조작할 경우에 사용

CREATE [OR REPLACE] TRIGGER 트리거명
  BEFORE [OR AFTER] --전처리/후처리?
  UPDATE [OR DELETE OR INSERT] ON 테이블명 --언제동작하냐 무슨작업할떄? 
  [FOR EACH ROW] -- 데이터 컨별로 실행(옵션) 한번만 처리?건바이건 처리?
DECLARE --AS가 아닌 DECLARE : 
  변수선언부;
BEGIN
  프로그램 로직 구현부;
END;  
-------------------------------
<트리거 적용시기 지정>
BEFORE : 데이터 처리가 수행되기 전 수행(INSERT, UPDATE, DELETE 문 실행전)
AFTER : 데이터 처리가 수행된 후 수행(INSERT, UPDATE, DELETE 문 실행후)

이벤트 형태 지정 : INSERT, UPDATE, DELETE
이벤트 발생 테이블 지정 : ON 테이블명

<처리형태 지정>
FOR EACH ROW : 데이타 처리시 건건이 트리거 실행. 이 옵션이 없으면 
  기본값인 문장 레벨 트리거로 실행되며 수행전, 후에 한번씩만 트리거 실행

DECLARE : 변수 선언 시 사용 키워드
--------------------
<컬럼값 사용> 데이터 개별 처리를 할 때 예전데이터, 
             새로운 데이터에 접근해서 사용이 가능함.
:OLD.컬럼명 : SQL 반영 전의 컬럼 데이타를 의미 
    변경 전 : INSERT X UPDATE O DELETE O 
:NEW.컬럼명 : SQL 반영 후의 컬럼 데이타를 의미
    변경 후 : INSERT O UPDATE O DELETE X
---------------------
<트리거 삭제, 활성, 비활성>
- 삭제 : DROP TRIGGER 트리거명;
- 활성 : ALTER TRIGGER 트리거명 enable;
- 비활성 : ALTER TRIGGER 트리거명 disable;
*****************************************************/
--트리거가 동작이 되면 INSERT된 데이터가 로그테이블에 로그(흔적)이 남는다.
--BOOK테이블에 대한 작업 로그(LOG이력)를 남길 테이블 작성
CREATE TABLE BOOK_LOG (
    BOOKID NUMBER(5), 
    BOOKNAME VARCHAR2(200),
    PUBLISHER VARCHAR2(200), 
    PRICE VARCHAR2(20), 
    LOGDATE DATE DEFAULT SYSDATE, 
    JOB_GUBUN VARCHAR2(10)
); 
-- 트리거 작성 (흔적을 남길)
-- BOOK 테이블에 데이터가 입력(INSERT)되면 BOOK_LOG 테이블에 이력(LOG)남기기
-- 트리거명 : AFTER_INSERT_BOOK 
CREATE OR REPLACE TRIGGER AFTER_INSERT_BOOK
    -- 트리거는 파라미터 없음
    -- 동작 시점이 있음
    AFTER  INSERT ON BOOK --BOOK테이블에 INSERT된 후에 동작을 한다
    FOR EACH ROW -- 개별데이터 : 명령문 단위가 아닌 데이터(ROW)별로
DECLARE
BEGIN
    --입력에 대한 이력 남기기
    INSERT INTO BOOK_LOG
           (BOOKID, BOOKNAME, PUBLISHER, PRICE, 
            LOGDATE, job_gubun)
    VALUES (:NEW.BOOKID, :NEW.BOOKNAME, :NEW.PUBLISHER, :NEW.PRICE,
            SYSDATE, 'INSERT');

END;
--------------------------
SELECT * FROM BOOK ORDER BY BOOKID DESC;
SELECT * FROM BOOK_LOG;
-- INSERT 트리거 동작 여부 확인
INSERT INTO BOOK VALUES (30, '데이터베이스의 이해', 'ITBOOK', 25000);
ROLLBACK; --입력취소하면 트리거에 의해 입력된 LOG데이터도 함께 취소처리

--다시입력
INSERT INTO BOOK VALUES (30, '데이터베이스의 이해', 'ITBOOK', 25000);
COMMIT; --입력작업 확정
INSERT INTO BOOK VALUES (31, '데이터베이스의 이해2', 'ITBOOK', 30000);
COMMIT;

--==========================
-- UPDATE 트리거 작성 : AFTER_UPDATE_BOOK
--==========================
-- UPDATE 트리거 작성 : AFTER_UPDATE_BOOK
CREATE OR REPLACE TRIGGER AFTER_UPDATE_BOOK 
AFTER UPDATE ON BOOK 
FOR EACH ROW 
BEGIN
  -- 수정 로그 남기기 (업데이트문)
  -- 업데이트 되면 북로그에 흔적을 남겨라 
  -- 수정하면 수정한 건 별로~
  INSERT INTO BOOK_LOG
        (BOOKID, BOOKNAME, PUBLISHER, PRICE, JOB_GUBUN)
    -- 수정이니까 OLD 데이터도 있고 NEW 데이터도 있음
    VALUES (:OLD.BOOKID,
            :OLD.BOOKNAME || '->' || :NEW.BOOKNAME,
            :OLD.PUBLISHER || '->' || :NEW.PUBLISHER,
            :OLD.PRICE || '->' || :NEW.PRICE,
            'UPDATE');
END;
------------------------
--UPDATE 트리거 동작 확인(테스트)
-- UPDATE 트리거 동작 확인(테스트)
SELECT * FROM BOOK ORDER BY BOOKID DESC;
SELECT * FROM BOOK_LOG;

SELECT * FROM BOOK WHERE BOOKNAME LIKE '%데이터베이스%';
UPDATE BOOK
   SET BOOKNAME = '오라클 ' || BOOKNAME
     , PUBLISHER = 'IT_BOOK'
     , PRICE = PRICE + 10000 --이 연산결과가 적용 숫자연산. 
                     --일괄 금액 변경보다 이렇게 하면 10000씩 증가된 값 적용 가능 
 WHERE BOOKNAME LIKE '%데이터베이스%'
;
COMMIT;
--------------------------













