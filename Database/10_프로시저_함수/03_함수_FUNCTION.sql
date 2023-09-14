/* 함수 (FUNCTION) *******************
--함수 사용은 되돌려받은 값을 사용하는 것이 목적이다.
CREATE OR REPLACE FUNCTION FUNCTION1 (
    PARAM1 IN VARCHAR2 --파라미터(옵션)
)   RETURN VARCHAR2 --리턴 데이터 타입 선언(필수)
AS
BEGIN
  RETURN NULL; --리턴값 (필수)
END FUNCTION1;
----------------------------------
--함수를 확인할 때는 리턴값 확인을 위해 SELECT문장에서 사용해보기

-- 리턴 데이터 타입 선언 필요
RETURN 데이터유형

-- 프로그램 마지막(중간)에 값 리턴하는 RETURN문 필요(필수)
-- 끝날 때는 반드시 RETURN문을 사용해야함. 중간에 나올 수도 있음 BUT 필수
RETURN 문 필수. RETURN문 없이 끝낼 순 없다. 

RETURN 리턴값;
*************************/
-- BOOKID로 책 제목 확인 함수(파라미터 값 : BOOKID, RETURN값 : BOOKNAME,)

CREATE OR REPLACE FUNCTION GET_BOOKNAME (
    IN_ID IN NUMBER
) RETURN VARCHAR2 --리턴 데이터 타입(필수)
AS
BEGIN
   RETURN '테스트';

END;
--숫자를 하나 전달 받고 '테스트'를 리턴하는 함수

---------------------------------------
create or replace FUNCTION GET_BOOKNAME (
    IN_ID IN NUMBER -- 전달 받는 파라미터 // 이름 IN 타입
) RETURN VARCHAR2 --리턴 데이터 타입(필수)  
AS --변수 선언 영역 // 필요한 변수는 여기 다 선언해야함
V_BOOKNAME BOOK.BOOKNAME%TYPE; --타입은 BOOK에 있는 BOOKNAME과 같다
BEGIN
    SELECT BOOKNAME
    INTO V_BOOKNAME
    FROM BOOK
    WHERE BOOKID = IN_ID;
    RETURN V_BOOKNAME;

END;
------------------------
--함수의 사용 (SELECT, WHERE 절에서 사용)
--동작 여부 확인용
SELECT GET_BOOKNAME(3) FROM DUAL;
-- SELECT 절에서 사용
SELECT BOOKID, BOOKNAME, GET_BOOKNAME(BOOKID)
FROM BOOK;
------------------

--==========================
--(실습) 고객ID 값을 받아서 고객명을 돌려주는 함수 작성(CUSTOMER 테이블 사용)
-- 함수명 : GET_CUSTNAME
-- GET_CUSTNAME 함수 사용해서 고객명 검색 여부 확인해보기
-------------------
-- ORDERS 테이블 데이터 조회
---- GET_BOOKNAME, GET_CUSTNAME 함수사용 주문(판매)정보와 책제목, 고객명 조회

CREATE OR REPLACE FUNCTION GET_CUSTNAME (
    IN_CUSTID IN NUMBER --파라미터값 (입력받아서 IN해야함)
) RETURN VARCHAR2
AS --변수 선언 영역 // 필요한 변수는 여기 다 선언해야함
V_NAME CUSTOMER.NAME%TYPE; --타입은 CUSTOMER에 있는 NAME과 같다
BEGIN -- 실행할 문장
    SELECT NAME --복잡한 SELECT문장이면 바로작성X 미리 확인해야한다
    INTO V_NAME --SELECT한 값을 변수에 저장
    FROM CUSTOMER
    WHERE CUSTID = IN_CUSTID; --CUSTID는 입력받은 CUSTID값
    RETURN V_NAME; --리턴할 값은 변수에 저장된 값이다.
END;
-----------------------------
--GET_CUSTNAME 함수 사용해서 고객명 검색 여부 확인해보기
SELECT GET_CUSTNAME(3) FROM DUAL;

-- ORDERS 테이블 데이터 조회
---- GET_BOOKNAME, GET_CUSTNAME 함수사용 주문(판매)정보와 
---- 책제목, 고객명 조회


SELECT O.*  --얘는 왜 안돼??//함수에 데이터 다 달라붙어있었음
     , GET_BOOKNAME(O.BOOKID) AS BOOK_NAME 
     , GET_CUSTNAME(O.CUSTID) AS CUST_NAME
FROM ORDERS O
;
-----------------
SELECT O.* --함수 사용
     , (SELECT BOOKNAME FROM BOOK WHERE BOOKID = 1) AS BOOK_NAME
     , GET_CUSTNAME(O.CUSTID) AS CUST_NAME
FROM ORDERS O
;
----------
SELECT O.* --서브쿼리 사용
     , (SELECT BOOKNAME FROM BOOK WHERE BOOKID = O.BOOKID) AS BOOK_NAME
     , (SELECT NAME FROM CUSTOMER WHERE CUSTID = O.CUSTID) AS CUST_NAME
FROM ORDERS O
;
--------------
SELECT O.* --테이블 데이터만 사용
     , B.BOOKNAME
     , C.NAME
FROM ORDERS O, BOOK B, CUSTOMER C
WHERE O.BOOKID = B.BOOKID
AND O.CUSTID = C.CUSTID
;








