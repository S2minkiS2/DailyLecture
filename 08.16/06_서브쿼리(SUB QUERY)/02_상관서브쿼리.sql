/* 상호연관 서브쿼리 (상관서브쿼리)
- 메인쿼리 값을 서브쿼리가 사용하고, 서브쿼리의 결과값을 메인쿼리가 사용
- 메인쿼리와 서브쿼리가 서로 조인된 형태로 동작
**************/
-- SELECT 절에 사용된 상관 서브 쿼리
SELECT O.ORDERID, O.CUSTID,
        (SELECT NAME FROM CUSTOMER WHERE CUSTID = O.CUSTID) AS CUST_NAME,
        O.BOOKID,
        (SELECT BOOKNAME FROM BOOK WHERE BOOKID = O.BOOKID) AS BOOK_NAME
    FROM ORDERS O
;
---- 출판사별 평균 도서 가격보다 비싼 도서목록을 구하시오
SELECT * FROM BOOK ORDER BY PUBLISHER, PRICE;
SELECT PUBLISHER, AVG(PRICE) FROM BOOK B GROUP BY PUBLISHER;

SELECT * 
    FROM BOOK B 
    WHERE PRICE > (SELECT AVG(PRICE) FROM BOOK WHERE PUBLISHER = B.PUBLISHER);

--=-=-=-=-=-=-=   WHERE PUBLISHER = B.PUBLISHER); 이거 중요하다 -=-=-=-=-=-=-=-=-=-=
----- 조인문
-- 출판사별 평균 도서 가격
SELECT PUBLISHER, AVG(PRICE) AS AVG_PRICE
    FROM BOOK
    GROUP BY PUBLISHER
;

-- BOOK + 추판사별 평균도서
SELECT *
    FROM BOOK B,
        (SELECT PUBLISHER, AVG(PRICE) AS AVG_PRICE
         FROM BOOK
         GROUP BY PUBLISHER) A
WHERE B.PUBLISHER = A.PUBLISHER -- 조인조건
    AND B.PRICE > A.AVG_PRICE --검색(선택)조건
;
--=============================================