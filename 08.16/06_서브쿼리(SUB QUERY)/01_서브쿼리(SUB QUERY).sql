-- 서브쿼리 (SUB QUERY) : SQL문 내부에 있는 SQL문을 가리킨다. 좀더 섬세한 조건을 쓰기 위해서.
-- SQL(SELECT, INSERT, UPDATE, DELETE)문 내에 있는 쿼리문
--------------------------------------
SELECT O.ORDERID, O.SALEPRICE, O.ORDERDATE,
        O.CUSTID, C.NAME,
        O.BOOKID,
        (SELECT BOOKNAME FROM BOOK WHERE BOOKID = O.BOOKID) AS BOOKNAME -- 스칼라 서브쿼리(Scalar Subquery)
FROM ORDERS O,
    (SELECT * FROM CUSTOMER WHERE NAME IN ('장미란','추신수')) C -- 인라인 뷰(Inline View)
WHERE O.CUSTID = C.CUSTID
    AND SALEPRICE > (SELECT AVG(SALEPRICE) FROM ORDERS) -- 중첩 서브쿼리(Nested Subquery)
;
--==================================== 서브쿼리보다는 조인 사용을 권장합니다. 속도문제 등 유발

-- 박지성이 구입한 내역을 검색
SELECT * FROM ORDERS; -- 구입내역
SELECT CUSTID FROM CUSTOMER WHERE NAME = '박지성'; -- 박지성의 CUSTID : 1
SELECT * FROM ORDERS WHERE CUSTID = 1;

-- 서브쿼리 사용시
SELECT * FROM ORDERS WHERE CUSTID = (SELECT CUSTID FROM CUSTOMER WHERE NAME = '박지성')
;
-- 조인문 처리 
SELECT C.NAME, O.*
FROM ORDERS O, CUSTOMER C --조인테이블
WHERE O.CUSTID = C.CUSTID --조인조건
    AND C.NAME = '박지성' --선택조건
;
---------------------- 
-- WHERE 절에서 서브쿼리 사용시 서브쿼리 조회 결과가 2건 이상인 경우 IN 사용
SELECT * FROM ORDERS 
WHERE CUSTID IN (SELECT CUSTID FROM CUSTOMER 
                                        WHERE NAME IN('박지성', '김연아')); --두사람 검색이므로 CUSTID도 두값 출력.
----------------------
--(서브쿼리) 책중 정가가 가장 비싼 도서의 이름을 구하시오
SELECT MAX(PRICE) FROM BOOK; -- 3500 : 가장 비싼 책의 정가
SELECT * FROM BOOK WHERE PRICE = 35000;

-- 서브쿼리를 WHERE 절에 사용
SELECT * FROM BOOK 
WHERE PRICE = (SELECT MAX(PRICE) FROM BOOK);

-- 서브쿼리를 FROM 절에 사용(테이블조인)
SELECT * FROM BOOK B, (SELECT MAX(PRICE) AS MAX_PRICE FROM BOOK) M
WHERE B.PRICE = M.MAX_PRICE -- 찾을 조건
;

----------------------
-- 박지성, 김연아 구입내역 (서브쿼리 - FROM절)
---- CUSTOMER, ORDERS JOIN
SELECT * FROM ORDERS O, (SELECT * FROM CUSTOMER WHERE NAME IN ('박지성', '김연아')) C
WHERE O.CUSTID = C.CUSTID
;

SELECT O.ORDERID, O.SALEPRICE, O.ORDERDATE,
        O.CUSTID, C.NAME,
        O.BOOKID,
        (SELECT BOOKNAME FROM BOOK WHERE BOOKID = O.BOOKID) AS BOOKNAME -- 스칼라 서브쿼리(Scalar Subquery)
FROM ORDERS O,
    (SELECT * FROM CUSTOMER WHERE NAME IN ('박지성','김연아')) C -- 인라인 뷰(Inline View)
WHERE O.CUSTID = C.CUSTID
;

-----------------------------
-- SELECT 절에 서브쿼리 사용
SELECT ORDERID, CUSTID, BOOKID, 
    (SELECT NAME FROM CUSTOMER WHERE CUSTID = ORDERS.CUSTID) CUST_NAME,
    (SELECT BOOKNAME FROM BOOK WHERE BOOKID = ORDERS.BOOKID) BOOK_NAME,
    SALEPRICE, ORDERDATE
    FROM ORDERS 
;
-----------------------------
-- 박지성이 구매한 책 목록
SELECT * 
    FROM BOOK
    WHERE BOOKID IN (SELECT BOOKID 
                     FROM ORDERS
                     WHERE CUSTID IN (SELECT CUSTID 
                                      FROM CUSTOMER
                                      WHERE NAME IN ('박지성'))
                    );
--============================
--(실습) 서브쿼리 이용
--1. 한 번이라도 구매한 내역이 있는 사람
SELECT * FROM CUSTOMER C WHERE C.CUSTID IN (SELECT CUSTID FROM ORDERS);

SELECT NAME FROM CUSTOMER C
    WHERE CUSTID IN (SELECT C.CUSTID FROM CUSTOMER C INNER JOIN ORDERS O ON C.CUSTID = O.CUSTID)
;


---- (또는 한 번도 구매하지 않은 사람)
SELECT * FROM CUSTOMER C WHERE C.CUSTID NOT IN (SELECT CUSTID FROM ORDERS);

SELECT NAME FROM CUSTOMER C
    WHERE CUSTID IN (SELECT C.CUSTID FROM CUSTOMER C LEFT OUTER JOIN ORDERS O ON C.CUSTID = O.CUSTID
                        WHERE O.CUSTID IS NULL)
;

--2. 20000원 이상되는 책을 구입한 고객 명단 조회
SELECT CUSTID FROM ORDERS WHERE SALEPRICE >= 20000;
SELECT NAME FROM CUSTOMER WHERE CUSTID IN (1, 4);
SELECT * FROM CUSTOMER WHERE CUSTID IN (SELECT CUSTID FROM ORDERS WHERE SALEPRICE >= 20000);

SELECT * FROM CUSTOMER C INNER JOIN (SELECT * FROM ORDERS WHERE SALEPRICE >= 20000) O
    ON C.CUSTID = O.CUSTID;

-- 3-1. '대한미디어' 출판사의 책을 구매한 고객이름 조회
SELECT * FROM BOOK WHERE PUBLISHER IN ('대한미디어');
SELECT * FROM ORDERS WHERE BOOKID IN (3, 4);
SELECT * FROM CUSTOMER WHERE CUSTID = 1;
SELECT C.* 
    FROM CUSTOMER C
    WHERE C.CUSTID IN (SELECT CUSTID 
                     FROM ORDERS 
                     WHERE BOOKID IN (SELECT BOOKID
                                      FROM BOOK
                                      WHERE PUBLISHER IN ('대한미디어')  
                                     )
                    )
;
-- 3-2. 조인문
SELECT C.*
    FROM CUSTOMER C
        JOIN ORDERS O ON C.CUSTID = O.CUSTID
        JOIN BOOK B ON O.BOOKID = B.BOOKID
WHERE B.PUBLISHER = '대한미디어';

--4. 전체 책가격 평균보다 비싼 책의 목록 조회
SELECT AVG(PRICE) FROM BOOK; --14450
SELECT * FROM BOOK B WHERE B.PRICE >= (SELECT AVG(PRICE) FROM BOOK);


