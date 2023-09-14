/* 시퀀스(SEQUENCE) ******
SEQUENCE : DB에서 제공하는 자동채번 객체
생성 : CREATE SEQUENCE 시퀀스명;
삭제 : DROP SEQUENCE 시퀀스명; 

시퀀스명.NEXTVAL : 시퀀스 번호(값) 생성
시퀀스명.CURRVAL : 현재 시퀀스값 확인(NEXTVAL 한 번 이상 실행 후)
**************************/
CREATE SEQUENCE SEQUENCE1;

CREATE SEQUENCE  "MADANG"."SEQUENCE1"  
MINVALUE 1 MAXVALUE 9999999999999999999999999999 
INCREMENT BY 1 START WITH 1 CACHE 20 NOORDER  NOCYCLE ;
---------------
-- NEXTVAL 한번 채번하면 시작값이 1
SELECT SEQUENCE1.NEXTVAL FROM DUAL;
-- CURRVAL 하면 현재값을 볼 수 있음
SELECT SEQUENCE1.CURRVAL FROM DUAL;
--------------------------
-- BOOK 테이블에 INSERT 작업, BOOKID 최대값 + 1 
INSERT INTO BOOK
        (BOOKID, BOOKNAME, PUBLISHER, PRICE)
VALUES ((SELECT NVL(MAX(BOOKID), 0) + 1 FROM BOOK), 
        'MAX(BOOKID) + 1 값', 'TEST', 20000);
SELECT * FROM BOOK ORDER BY BOOKID DESC;
-------------------동시 접속자가 많으면 튕길 수 있음 : BOOKID가 PK, 중복값은 안됨
-- SEQUENCE 사용
-- 기존에 데이터가 있으면 그 데이터보다 최소 하나 많게. 
-- 시퀀스 사용 (시작번호 50, NOCACHE)
CREATE SEQUENCE SEQ_BOOK INCREMENT BY 1 START WITH 50 NOCACHE;
--------------

-- SELECT SEQ_BOOK.NEXTVAL FROM DUAL;
-- BOOK 테이블에 시퀀스 사용해서 입력처리
INSERT INTO BOOK
        (BOOKID, BOOKNAME, PUBLISHER, PRICE)
        VALUES (SEQ_BOOK.NEXTVAL, 'SEQ_BOOK.NEXTVAL 사용', 'TEST' , 20000);
------------
        SELECT * FROM BOOK ORDER BY BOOKID DESC;
--=========================
