/*함수(FUNCTION)********************************************                                          
CREATE OR REPLACE FUNCTION FUNCTION1 
(
  PARAM1 IN VARCHAR2 --파라미터 (옵션)
) RETURN VARCHAR2 --리턴 데이터 타입 선언(필수)
AS 

BEGIN
  RETURN NULL; --리턴값(필수)  
END;
-----------------------------------------------------------
-- 리턴 데이터 타입 선언 필요(필수)
RETURN 데이터 유형

-- 프로그램 마지막(혹은 중간)에 값 리턴하는 RETURN문이 필요(필수)
RETURN 리턴값;
**********************************************************/
-- BOOKID로 책제목 확인하는 함수(파라미터: BOOKID / RETURN값: BOOKNAME)
create or replace FUNCTION GET_BOOKNAME (
    IN_ID IN NUMBER
) RETURN VARCHAR2 --리턴데이터 타입
    
AS
    V_BOOKNAME BOOK.BOOKNAME%TYPE;
BEGIN

    SELECT BOOKNAME 
    INTO V_BOOKNAME 
    FROM BOOK
    WHERE BOOKID = IN_ID;
    RETURN V_BOOKNAME;
END;
--------------------------------------------------------------------------------
-- 함수의 사용(SELECT, WHERE 절에서 사용)
-- 동작여부 확인
SELECT GET_BOOKNAME(BOOK.BOOKID) FROM BOOK;

-- SELECT 절에서 함수 사용
SELECT BOOKID, BOOKNAME, GET_BOOKNAME(BOOKID) --출판된 책
FROM BOOK
;
-----------
SELECT O.*, GET_BOOKNAME(BOOKID) --판매된 책
FROM ORDERS O
;
-----------
-- WHERE 절에서 함수 사용
SELECT O.*
    ,GET_BOOKNAME(O.BOOKID) AS BOOKNAME
FROM ORDERS O
WHERE GET_BOOKNAME(O.BOOKID) LIKE '%축구%'
;
--==============================================================================
--(실습) 고객ID 값을 받아서 고객명을 돌려주는 함수 작성(CUSTOMER 테이블 사용)
-- 함수명 : GET_CUSTNAME
-- GET_CUSTNAME 함수 사용해서 고객명 검색 여부 확인해보기
-------------------
CREATE OR REPLACE FUNCTION GET_CUSTNAME(    -- 함수명
    IN_ID NUMBER                            -- 파라미터 명, 타입
) RETURN VARCHAR2                           -- 리턴값의 타입
AS
    V_CUSTNAME CUSTOMER.NAME%TYPE;          -- 리턴값(변수)의 크기
BEGIN
    SELECT NAME                             -- 조회할 컬럼
    INTO V_CUSTNAME                         -- 컬럼을 집어넣을 변수        
    FROM CUSTOMER                           -- 조회할 테이블    
    WHERE IN_ID = CUSTID;                   -- 조건절(공통인자)
    RETURN V_CUSTNAME;                      -- 리턴값 (컬럼 값을 집어넣은 변수)    
END;

SELECT GET_CUSTNAME(1) FROM DUAL;

-- ORDERS 테이블 데이터 조회
---- GET_BOOKNAME, GET_CUSTNAME 함수사용 주문(판매)정보와 책제목, 고객명 조회

SELECT  O.ORDERID,
        O.CUSTID,
        GET_CUSTNAME(O.CUSTID) AS CUST_NAME, --(SELECT NAME FROM CUSTOMER WHERE CUSTID = O.CUSTID) 서브쿼리 방법
        O.BOOKID,
        GET_BOOKNAME(O.BOOKID) AS BOOK_NAME, --(SELECT BOOKNAME FROM BOOK WHERE BOOKID = O.BOOKID) 서브쿼리 방법
        O.SALEPRICE,
        O.ORDERDATE
FROM ORDERS O
ORDER BY O.CUSTID
;
-- ORDERS 테이블에 맞게 BOOKID와 CUSTID 순서대로 대입하여 함수값을 리턴

-- 조인방법으로? (데이터가 많아지면 속도차이 발생하기 때문에 서브쿼리보다 JOIN문을 사용하자.)
SELECT O.*,
        B.BOOKNAME,
        C.NAME
FROM ORDERS O, BOOK B, CUSTOMER C
WHERE O.BOOKID = B.BOOKID
    AND O.CUSTID = C.CUSTID
;
--==============================================================================
-- 커서???? 뭐가 될래








