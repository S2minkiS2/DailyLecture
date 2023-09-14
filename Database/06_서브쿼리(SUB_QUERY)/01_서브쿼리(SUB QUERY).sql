--서브(SUB QUERY) : SQL문 내부에 있는 SQL문
-- SQL(SELECT, INSERT, UPDATE, DELETE)문 내에 있는 쿼리문
-----------------------
SELECT O.ORDERID, O.SALEPRICE, O.ORDERDATE,
       O.CUSTID, C.NAME,
       O.BOOKID,
       (SELECT BOOKNAME FROM BOOK WHERE BOOKID = O.BOOKID) AS BOOKNAME
       --스칼라 서브쿼리(SCALAR SUBQUERY) 데이터 하나 와야함 
       --SELECT절에 있는 서브쿼리엔 값 하나만 와야한다.
FROM ORDERS O, 
     (SELECT * FROM CUSTOMER WHERE NAME IN('장미란', '추신수')) C 
     --인라인 뷰(INLINE VIEW) (FROM절에 오는 서브쿼리)
     --장미란, 추신수만 대상
WHERE O.CUSTID = C.CUSTID
  AND SALEPRICE > (SELECT AVG(SALEPRICE) FROM ORDERS) --중첩서브쿼리
        --ORDERS테이블의 판매된 금액 평균보다 많은 것 
;
--박지성이 구입한 내역을 검색
SELECT * FROM ORDERS; --구입내역
SELECT CUSTID FROM CUSTOMER WHERE NAME = '박지성'; --CUSTID : 1
SELECT * FROM ORDERS
WHERE CUSTID = 1
;
--서브쿼리방식 //하나만 사용가능한데
SELECT * FROM ORDERS
WHERE CUSTID = (SELECT CUSTID FROM CUSTOMER WHERE NAME = '박지성')
;

--조인문 처리 //그 테이블의 모든 데이터를 사용 가능
SELECT C.NAME, O.*
  FROM ORDERS O, CUSTOMER C --조인테이블
 WHERE O.CUSTID = C.CUSTID --조인조건
   AND C.NAME = '박지성' --선택조건
;
------------------
--WHERE 절에서 서브쿼리 사용시 서브쿼리 조회 결과가 2건 이상인 경우 IN사용
SELECT * FROM ORDERS
WHERE CUSTID IN(SELECT CUSTID FROM CUSTOMER 
                WHERE NAME IN ('박지성', '김연아'))
                --데이터가 여러개면 =이 아니라 IN사용 
; 
---------------------
--(서브쿼리) 책 중 정가가 가장 비싼 도서의 이름을 구하시오
SELECT * 
FROM BOOK
WHERE PRICE = (SELECT MAX(PRICE) FROM BOOK)--35000
;
--SELECT MAX(PRICE) FROM BOOK; --35000:가장 비싼 책 금액
--------------------
-- 서브쿼리를 FROM 절에 사용 (테이블조인)
SELECT * 
FROM BOOK B, 
    (SELECT MAX(PRICE) AS MAX_PRICE FROM BOOK) M
--값이 하나이기 때문에 조인조건 없이 합칠 수 있다.
WHERE M.MAX_PRICE = B.PRICE --찾을조건
;
---------
--박지성, 김연아 구입내역 (서브쿼리 - FROM절)
SELECT O.CUSTID, N.NAME, O.ORDERID, O.BOOKID, O.SALEPRICE, O.ORDERDATE
FROM ORDERS O, (SELECT * FROM CUSTOMER WHERE NAME IN ('박지성', '김연아')) N
WHERE O.CUSTID = N.CUSTID --조인해줘야 데이터가 전부 안나옴
;
---------------
-- SELECT 절에 서브쿼리 사용
SELECT *
FROM ORDERS;

SELECT ORDERID, CUSTID, BOOKID,
        (SELECT NAME FROM CUSTOMER WHERE CUSTID = O.CUSTID) CUST_NAME,
        --ORDERS테이블에 있는 CUSTID와 같은것*****
        (SELECT BOOKNAME FROM BOOK WHERE BOOKID = O.BOOKID) BOOK_NAME,
        --ORDERS테이블에 있는 BOOKID와 같은것*****
        SALEPRICE, ORDERDATE
FROM ORDERS O
;
-----------
--박지성이 구매한 책 목록
--책 목록, 판매된 이력 있는 책, 구매를 누가했나? 
SELECT *
FROM BOOK
WHERE BOOKID IN (SELECT BOOKID
                 FROM ORDERS 
                 WHERE CUSTID IN (SELECT CUSTID 
                                    FROM CUSTOMER
                                    WHERE NAME IN '박지성'
                                  )
                 )
;
--=====================================
--(실습) 서브쿼리 이용
--1. 한 번이라도 구매한 내역이 있는 사람
---- (또는 한 번도 구매하지 않은 사람)
--2. 20000원 이상되는 책을 구입한 고객 명단 조회
--3. '대한미디어' 출판사의 책을 구매한 고객이름 조회
--4. 전체 책가격 평균보다 비싼 책의 목록 조회
--======================================

--1. 한 번이라도 구매한 내역이 있는 사람
---- (또는 한 번도 구매하지 않은 사람)
SELECT *
FROM CUSTOMER
WHERE (CUSTID IN (SELECT CUSTID FROM ORDERS))
;

--한번이라도 구매한 내역이 있는 사람의 CUSTID
SELECT *
FROM CUSTOMER
WHERE (CUSTID IN (1,2,3,4))
;
--ORDERS에서 결과물이 CUSTID가 1,2,3,4이려면?
--책을 산 사람?
SELECT CUSTID
FROM ORDERS
;

--========================================
--2. 20000원 이상되는 책을 구입한 고객 명단 조회
SELECT N.SALEPRICE, C.* --CUSTID와 일치하는 NAME
FROM CUSTOMER C, (SELECT SALEPRICE, CUSTID FROM ORDERS WHERE SALEPRICE >= 20000) N
WHERE C.CUSTID = N.CUSTID
--ORDERS에 있는 데이터 -> SALEPRICE >= 20000 구입한 CUSTID
;
--=====================================
--3. '대한미디어' 출판사의 책을 구매한 고객이름 조회
SELECT *
FROM CUSTOMER
WHERE CUSTID IN (SELECT CUSTID
                 FROM ORDERS
                  WHERE BOOKID IN (SELECT BOOKID 
                                   FROM BOOK
                                   WHERE PUBLISHER IN ('대한미디어')))
;
--대한미디어의 BOOKID는?
SELECT BOOKID 
FROM BOOK
WHERE PUBLISHER IN ('대한미디어'); --3,4
--그 BOOKID와 일치하는 책을 구매한 CUSTOMER ID는? 
SELECT CUSTID
FROM ORDERS
WHERE BOOKID IN (3,4); --1
--그 ID를 가진 고객이름은?
SELECT NAME
FROM CUSTOMER
WHERE CUSTID IN (1); --박지성

--==================================
--4. 전체 책가격 평균보다 비싼 책의 목록 조회
SELECT *
FROM BOOK B, (SELECT * 
            FROM ORDERS
            WHERE SALEPRICE >= (SELECT AVG(SALEPRICE)
                                FROM ORDERS)) A
WHERE B.BOOKID = A.BOOKID
;

--전체 책 가격의 평균
SELECT AVG(SALEPRICE)
FROM ORDERS;
--평균보다 비싼 책 판매기록
SELECT * 
FROM ORDERS
WHERE SALEPRICE >= (SELECT AVG(SALEPRICE)
        FROM ORDERS) ;     
--전체 책 가격의 평균보다 비싼 책의 정보
--BOOKID가 ORDERS의 BOOKID와 같은 책
SELECT *
FROM BOOK B, (SELECT * 
            FROM ORDERS
            WHERE SALEPRICE >= (SELECT AVG(SALEPRICE)
                                FROM ORDERS)) A
WHERE B.BOOKID = A.BOOKID;

--=====================================
--(실습) 조인 이용
--1. 한 번이라도 구매한 내역이 있는 사람
---- (또는 한 번도 구매하지 않은 사람)
--2. 20000원 이상되는 책을 구입한 고객 명단 조회
--3. '대한미디어' 출판사의 책을 구매한 고객이름 조회
--4. 전체 책가격 평균보다 비싼 책의 목록 조회
--======================================

--1. 한 번이라도 구매한 내역이 있는 사람*****
---- (또는 한 번도 구매하지 않은 사람)
--LEFT OUTER JOIN // ORDERID = NONE인 사람
SELECT *
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID(+)
AND O.ORDERID IS NULL
;

--2. 20000원 이상되는 책을 구입한 고객 명단 조회
SELECT *
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID
AND O.SALEPRICE >= 20000
;

--3. '대한미디어' 출판사의 책을 구매한 고객이름 조회
SELECT *
FROM CUSTOMER C, ORDERS O, BOOK B
WHERE C.CUSTID = O.CUSTID
  AND O.BOOKID = B.BOOKID
  AND B.PUBLISHER IN '대한미디어'
;

--4. 전체 책가격 평균보다 비싼 책의 목록 조회
SELECT BOOKNAME, AVG(PRICE)
FROM BOOK B
WHERE B.PRICE > AVG(PRICE)
;

SELECT PRICE, A.AVG_PRICE
  FROM BOOK B, 
   (SELECT *, AVG(PRICE) AVG_PRICE
    FROM BOOK)A --전체 책 가격의 평균
WHERE B.PUBLISHER = A.PUBLISHER --조인조건
  AND B.PRICE > A.AVG_PRICE
  ;


