/*------------------------------
컬럼의 기본 데이타 타입(문자열, 숫자, 날짜)
- VARCHAR2(n) : 문자열 가변길이
- CHAR(n) : 문자열 고정길이
- NUMBER(p, s) : 숫자타입 p:전체길이, s:소수점이하 자리수
    예) (5,2) : 정수부 3자리, 소수부 2자리 - 전체 5자리
- DATE : 날짜형 년,월,일 시간 값 저장

문자열 처리 : UTF-8 형태로 저장
- 숫자, 알파벳 문자, 특수문자 : 1 byte 처리(키보드 자판 글자들)
- 한글 : 3 byte 처리
--------------------------------*/
CREATE TABLE TEST (
    NUM NUMBER(5, 2), --숫자타입 전체자리수 5 : 정수부3, 소수부2
    STR1 CHAR(10), --고정길이 문자열 
    STR2 VARCHAR2(10), -- 가변길이 문자열
    DATE1 DATE --날짜데이터 : 년월일시분초
    --DATE는 키워드라 DATE는 이름안됨
);
SELECT * FROM TEST;
INSERT INTO TEST VALUES (100.454, 'ABC', 'ABC', SYSDATE);
INSERT INTO TEST VALUES (100.455, 'ABC', 'ABC', SYSDATE);
COMMIT; --셋째자리는 반올림되어 처리된다

-- 오류발생 : 정수부 3자리 저장 가능한데, 4자리 저장 시도
INSERT INTO TEST VALUES (1234.456, 'ABC', 'ABC', SYSDATE);

-- 문자열에 숫자를 넣으면 입력 가능
INSERT INTO TEST VALUES (100.456, 'ABCDE', 'ABCDE', SYSDATE);
COMMIT;

-- 문자열 붙이기는 || 세로바 두개 
SELECT '-'||STR1||'-', '-'||STR2||'-' FROM TEST;

--내장함수, 리턴값이 있는 메소드
--LENGTH는 길이,크기 --LENGTHB는 바이트크기
SELECT STR1, LENGTHB(STR1) , STR2, LENGTHB(STR2) FROM TEST;
-----------------------------------------
SELECT * FROM TEST WHERE STR1 = STR2; --조회된 데이터 없음
--STR1은 ABC에 SPACE가 있고 
--STR2는 ABC만 있다. 따라서 다른 데이터이다.

SELECT * FROM TEST WHERE STR1 = 'ABC'; --오라클에서는 조회됨
-------------
-- 숫자 타입
SELECT * FROM TEST WHERE NUM = 100.45; -- NUMBER BS NUMBER
SELECT * FROM TEST WHERE NUM = '100.45'; --오라클 조회됨 NUMBER VS 문자

----------------
INSERT INTO TEST (STR1, STR2) VALUES ('1234567890', '1234567890');
SELECT * FROM TEST WHERE STR1 = STR2;
SELECT STR1, LENGTHB(STR1) , STR2, LENGTHB(STR2) FROM TEST;

--==================================
SELECT * FROM TEST;
SELECT DATE1, TO_CHAR(DATE1, 'YYYY-MM-DD HH24:MI:SS') FROM TEST;
SELECT DATE1, TO_CHAR(DATE1, 'YYYY/MM/DD HH24:MI:SS') FROM TEST;
SELECT DATE1, TO_CHAR(DATE1, 'YYYY.MM.DD HH24:MI:SS') FROM TEST;
-- '20230808112035' : 2023년 08월 08일 11시 20분 35초
-- '20230808112035' : 2023-08-08 11:20:35
-- 시스템데이터를 문자열로 형변환해서
-- 문자열로 데이터를 갖고있어도 됨. 효율 생각해서 사용~
--===================================
--한글데이터 처리 (UTF-8) ASCII 코드 1BYTE, 한글 1글자 3BTYE 사용
SELECT * FROM TEST;
INSERT INTO TEST (STR1, STR2) VALUES ('ABCDEFGHIJ', 'ABCDEFGHIJ');
INSERT INTO TEST (STR1, STR2) VALUES ('ABCDEFGHIJ', '홍길동'); --한글3글자 *3
INSERT INTO TEST (STR1, STR2) VALUES ('ABCDEFGHIJ', '대한민국'); --한글4글자 *3

/* *** NULL(널)의 특성 ***
----------------------------
-- NULL : 데이터가 없는 상태
-- NULL은 비교처리가 안됨 : =, <>, !=, >, >=, <= 비교처리 의미 없음 - 결과가 NULL
-- NULL 과의 연산결과는 항상 NULL(연산 의미 없음)
-- NULL 값에 대한 조회(검색)는 IS NULL, IS NOT NULL 키워드로 처리
--------------------------*/
SELECT * FROM TEST;
SELECT * FROM TEST WHERE NUM = NULL; -- 조회안됨
SELECT * FROM TEST WHERE NUM IS NULL; -- IS NULLL 사용 검색할 것 
SELECT * FROM TEST WHERE NUM <> NULL; -- 조회안됨 (비교연산 의미없음, 하지말것)
SELECT * FROM TEST WHERE NUM IS NOT NULL; -- IS NOT NULL 사용 검색할 것
-------------------------
--NULL과의 연산결과 --> 항상 NULL 이다.
SELECT * FROM DUAL; -- NUAL 테이블 일명 DUMMY 테이블 (오라클 제공)
SELECT 100 + 200, 111 + 222 FROM DUAL; --DUAL이라는 범위테이블
SELECT 100 + NULL, 100 - NULL, 100 * NULL, 100 / NULL FROM DUAL;

SELECT * FROM TEST;
SELECT NUM, NUM + 100 FROM TEST;
SELECT NUM, NVL(NUM, 0), NVL(NUM, 0) + 100 FROM TEST;
---------------------------
--정렬시 NULL
SELECT * FROM TEST; 
--보이는게 입력된 순서가 아닐 수도 있음 ADD로는 순차적, 하지만 이걸 지웠다가 넣었다가 하면 달라질 수 있다.
--그냥 조회하면 DB저장형태로. 
-- 하지만 ORDER BY를 통해 순서 정렬해서 가져올 수 있다~
SELECT * FROM TEST ORDER BY STR2; --기본 오름차순 정렬, ASC(오름차순) 키워드 생략가능
SELECT * FROM TEST ORDER BY STR2 DESC; --내림차순 정렬, 디센딩DESC

--정렬시 오라클에서는 NULL 값을 가장 큰 값으로 처리 (맨 마지막 출력)
-- NULL 값 조회 순서 변경 : NULLS FIRST, NULLS LAST
SELECT * FROM TEST ORDER BY NUM;
SELECT * FROM TEST ORDER BY NUM DESC; 
SELECT * FROM TEST ORDER BY NUM NULLS FIRST; --NULL 값을 맨앞에
SELECT * FROM TEST ORDER BY NUM NULLS LAST; --NULL값을 맨뒤에
----------------------
INSERT INTO TEST (NUM, STR1, STR2) VALUES (200, '', NULL);
SELECT * FROM TEST WHERE STR1 = ''; -- 데이터 조회 안됨

--============================
/* (실습) 테이블(TABLE) 만들기(테이블명: TEST2)
    NO : 숫자타입 5자리, PRIMARY KEY 선언
    ID : 문자타입 10자리(영문10자리), 값이 반드시 존재(NULL 허용안함) //NOTNULL
    NAME : 한글 10자리 저장 가능하도록 설정, 값이 반드시 존재
    EMAIL : 영문, 숫자, 특수문자 포함 30자리
    ADDRESS : 한글 100자
    INNUM : 숫자타입 정수부 7자리, 소수부 3자리(1234567.123)
    REGDATE : 날짜타입
*********************/
CREATE TABLE TEST2(
    NO NUMBER(5) PRIMARY KEY,
    ID VARCHAR2(10) NOT NULL,
    NAME VARCHAR2(30) NOT NULL, 
    EMAIL VARCHAR2(30), 
    ADDRESS VARCHAR2(300), 
    INNUM NUMBER(10, 3), --첫번째 숫자는 전체자릿수
    REGDATE DATE
    );
    
    
    DROP TABLE TEST2;
   
    SELECT * FROM TEST2 ;
    
    INSERT INTO TEST2 
    VALUES (
    12344,
    'ABCDEFGHIJ',
    '최유정정이',
    'TOP0321@NAVER.COM',
    '경기도용인시어쩌구저쩌구에버랜드앞',
    1234567.123,
    SYSDATE --날짜삽입은 SYSDATE
    );
    
    INSERT INTO TEST2 (NO, ID, NAME)
    VALUES (23002, 'TEST3', '홍길동');
    ----------------
    --특정 테이블의 테이블구조와 데이터를 함께 복사
    CREATE TABLE TEST4
    AS 
    SELECT * FROM TEST2;
    SELECT * FROM TEST2;
    SELECT * FROM TEST4;
    --==================================
    --특정 테이블의 특정 컬럼과 특정 데이터만 복사하면서 테이블 생성
    CREATE TABLE TEST5
    AS
    SELECT NO, ID, NAME, EMAIL FROM TEST2 WHERE ID = 'ABCDEFGHIJ';
    --=========================
    -- 특정 테이블 구조만 복사 (데이터는 복사하지 않음)
    --SELECT * FROM TEST2 WHERE  1 = 1; --모두 선택 TRUE
    --SELECT * FROM TEST2 WHERE  1 = 2; --하나도 선택 안할래 FALSE
    
    CREATE TABLE TEST6
    AS
    SELECT * FROM TEST2 WHERE 1 = 2;

    --=================
    SELECT * FROM TEST2;
    DELETE FROM TEST2 WHERE ID = 'TEST3'; --TEST3만 삭제
    DELETE FROM TEST2; --테이블 전체 데이터 삭제 ?????
    ROLLBACK; --취소 가능 (DELETE 명령 사용시)
    
    --TRUNCATE 명령문 : 테이블 전체 데이터 삭제 (ROLLBACK으로 복구 안됨)
    TRUNCATE TABLE TEST2; --잘려나가서 복구가 되진 않는다.
    SELECT * FROM TEST2; --구조 그대로, 데이터만 삭제
   
    
    