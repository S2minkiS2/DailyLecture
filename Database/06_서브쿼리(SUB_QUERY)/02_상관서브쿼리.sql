/*상호연관 서브쿼리(상관서브쿼리)
- 메인쿼리의 값을 서브쿼리가 사용하고, 서브쿼리의 결과값을 메인쿼리가 사용
- 메인쿼리와 서브쿼리가 서로 조인된 형태로 동작
*************************/
-- SELECT 절에 사용된 상관 서브 쿼리 
            --+ 서브쿼리를 단독으로 실행시킬 순 없다.
SELECT * FROM ORDERS;
SELECT O.ORDERID, O.CUSTID,
       (SELECT NAME FROM CUSTOMER WHERE CUSTID = O.CUSTID) AS CUST_NAME,
       O.BOOKID,
       (SELECT BOOKNAME FROM BOOK WHERE BOOKID = O.BOOKID) AS BOOK_NAME
  FROM ORDERS O
;
----각각의 출판사별 평균 도서 가격보다 비싼 도서 목록을 구하시오
SELECT * FROM BOOK ORDER BY PUBLISHER, PRICE;
SELECT AVG(PRICE) FROM BOOK WHERE PUBLISHER = '굿스포츠';
--출판사별로 평균을 낸다. 그리고 그것보다 큰지?
--각각의 출판사별 평균도서가격 구하기
SELECT *
  FROM BOOK B
 WHERE PRICE > (SELECT AVG(PRICE) FROM BOOK WHERE PUBLISHER = B.PUBLISHER)
                                        --지금 처리중인 B에있는 데이터
;
-- 조인문(JOIN문)
----출판사별 평균 도서 가격
SELECT PUBLISHER, AVG(PRICE) AVG_PRICE
  FROM BOOK
GROUP BY PUBLISHER
;
-- BOOK + 출판사별 평균가격 JOIN
SELECT *
  FROM BOOK B, 
   (SELECT PUBLISHER, AVG(PRICE) AVG_PRICE
    FROM BOOK
    GROUP BY PUBLISHER)A
WHERE B.PUBLISHER = A.PUBLISHER --조인조건
  AND B.PRICE > A.AVG_PRICE --검색(선택)조건
  ;

--================================
-- EXISTS : 존재여부 확인시 사용(있으면 TRUE)
-- NOT EXISTS : 없으면 TRUE
SELECT *
FROM CUSTOMER
WHERE CUSTID IN (SELECT DISTINCT CUSTID FROM ORDERS)
;
--====> EXIST 적용 : 데이터가 있으면 선택
SELECT * FROM CUSTOMER;
SELECT * FROM ORDERS;

SELECT *
FROM CUSTOMER C
WHERE EXISTS (SELECT CUSTID FROM ORDERS 
            --SELECT절에 올 것은 값이 선택만 되어지면 된다. 상수값이든 뭐든..
              WHERE CUSTID = C.CUSTID);
              
--====> NOT EXIST 적용 : 데이터가 없으면 선택
SELECT *
FROM CUSTOMER C
WHERE NOT EXISTS (SELECT ORDERID FROM ORDERS 
            --SELECT절에 올 것은 값이 선택만 되어지면 된다. 상수값이든 뭐든..
              WHERE CUSTID = C.CUSTID);
              
--=====================================

