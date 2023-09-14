--테이블 조인(JOIN) : 2개 이상의 테이블 데이터를 연결해서 하나의 테이블인 것 처럼 사용
SELECT * FROM CUSTOMER WHERE CUSTID = 1;
SELECT * FROM ORDERS WHERE CUSTID = 1;

--CUSTOMER, ORDERS 테이블 데이터 동시에 조회(검색)
--(주의) 조인 하다보면 겹치는 이름 중 하나가 바뀔 수 있다.
--      SELECT절에 동일컬럼명 2개가 올 수 없다.
-->     별칭 사용해서 다른이름으로 변경 처리
SELECT * 
FROM CUSTOMER, ORDERS--조인테이블
WHERE CUSTOMER.CUSTID = ORDERS.CUSTID--조인조건 : JOIN할 때 서로 유의미한 데이터
--여기까지는 JOIN만 한 것.
 AND CUSTOMER.NAME = '박지성' --선택조건(찾을조건)
; 
--2개 테이블 정보를 하나인 것처럼 본다.
------------------------------------
--주로 JOIN문을 사용할 땐 테이블 별칭을 사용한다.
--> 테이블 별칭 (ALIAS) 사용 : 테이블 명을 간단하게 사용하기 위한 목적
--(주의) 테이블 별칭 사용시 반드시 별칭을 적용해야한다.
SELECT *
FROM CUSTOMER C, ORDERS O --조인테이블에 대한 별칭(ALIAS)사용
--> CUSTOMER 사라지고 C만 남음, ORDERS사라지고 O만 남음
--별칭을 사용하겠다 한 순간 별칭만 사용 가능하다.
WHERE C.CUSTID = O.CUSTID -- 조인조건
AND C.NAME = '박지성' --선택조건(찾을조건)
--유니크한 컬럼명은 어디에있는지는 생략해도 된다.
-- AND NAME = '박지성' -->가능
;

--표준 조인 쿼리문
SELECT * 
    FROM CUSTOMER C INNER JOIN ORDERS O --조인테이블 정의
    --교집합 : INNER JOIN / JOIN
        ON C.CUSTID = O.CUSTID --조인조건
 WHERE C.NAME = '박지성' --선택조건(찾을조건)
 ;
 ------------------------------
 -- 판매된 책 목록 확인 (BOOK, ORDERS)
 SELECT * FROM BOOK;
 SELECT * FROM ORDERS;
 --출판한 책 중 판매된 책 목록 (미디어로 끝나는 출판사)
 SELECT O.ORDERID, O.BOOKID,--양쪽 테이블에 똑같은 이름이 있으면 어디에 있는지 명시해야한다.
        B.BOOKID AS B_BOOKID, 
        --SQL 상에서 임의로 바꿔준 이름 충돌 가능성 때문에 미리 바꿔준 것
        --현재는 DEVELOPER가 알아서 바꿔줬지만 오류 가능성을 품고있다.
        --두 곳에서 이름은 같은 상태이기 때문에 어디에 있는 컬럼인지 명시해야한다.
        B.BOOKNAME, B.PUBLISHER, B.PRICE, O.SALEPRICE, O.ORDERDATE
        --(주의) 동일한 컬럼명이 2번 사용될 수 없다. 별칭처리해라! AS 사용
-- SELECT *
 FROM BOOK B, ORDERS O --조인테이블
 --유의미하게 연결할 수 있는건 BOOKID라는 정보
 WHERE B.BOOKID = O.BOOKID --조인조건
 AND B.PUBLISHER LIKE '%미디어' --미디어로 끝나는 출판사
--AND B.PUBLISHER = '굿스포츠'
ORDER BY B.PUBLISHER, B.BOOKNAME 
;
 
 
 --(문제해결) 테이블 조인을 통해서 요청한 데이터 찾기
--실습 : '야구를 부탁해'라는 책이 팔린 내역을 확인(책제목, 판매금액, 판매일자)
--실습 : '야구를 부탁해'라는 책이 몇 권이 팔렸는지 확인
------
--실습 : '추신수'가 구입한 책값과 구입일자를 확인(책값, 구입일자)
--실습 : '추신수'가 구입한 합계금액을 확인
--실습 : 박지성, 추신수가 구입한 내역을 확인(이름, 구입(판매)금액, 구입(판매)일자)
--=================================
--실습 : '야구를 부탁해'라는 책이 팔린 내역을 확인(책제목, 판매금액, 판매일자)
SELECT *
FROM ORDERS O, BOOK B
WHERE O.BOOKID = B.BOOKID 
AND B.BOOKNAME = '야구를 부탁해'
;
SELECT B.BOOKNAME, O.SALEPRICE, O.ORDERDATE -- 읽어올 컬럼
FROM BOOK B, ORDERS O --조인할 테이블
WHERE B.BOOKID = O.BOOKID --WHERE절 중에서도 조인 조건
AND B.BOOKNAME = '야구를 부탁해' --이 정보를 주세요!!!!!!!
;
--실습 : '야구를 부탁해'라는 책이 몇 권이 팔렸는지 확인
SELECT COUNT (*)
FROM ORDERS O, BOOK B
WHERE O.BOOKID = B.BOOKID
AND B.BOOKNAME = '야구를 부탁해' //새로해보기
;
--------------------
--실습 : '추신수'가 구입한 책값과 구입일자를 확인(책값, 구입일자)
SELECT *
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID
AND C.NAME = '추신수'
;

SELECT C.NAME, O.ORDERDATE, O.SALEPRICE
FROM CUSTOMER C, ORDERS O 
WHERE C.CUSTID = O.CUSTID --조인조건
AND C.NAME = '추신수'
;

--실습 : '추신수'가 구입한 합계금액을 확인
SELECT SUM(O.SALEPRICE) 
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID
;

--실습 : 박지성, 추신수가 구입한 내역을 확인(이름, 구입(판매)금액, 구입(판매)일자)
SELECT C.NAME, O.SALEPRICE, O.ORDERDATE
FROM CUSTOMER C, ORDERS O 
WHERE C.CUSTID = O.CUSTID --조인조건
  AND (C.NAME = '박지성' OR C.NAME = '추신수') 
--AND C.NAME IN ('박지성', '추신수') --위의 데이터와 같다.
--AND 조건으로 묶으면 안된다. 왜냐? 박지성이면서 추신수인 사람은 없으니까
;
--========================================
--3개 테이블 조인하기 : CUSTOMER, BOOK, ORDERS
-- 고객명, 책 제목, 판매가격, 판매일자, 출판사명
--SELECT * FROM BOOK;
--SELECT * FROM CUSTOMER;
--SELECT * FROM ORDERS; 
SELECT C.NAME, B.BOOKNAME, O.SALEPRICE, O.ORDERDATE, B.PUBLISHER
FROM ORDERS O, BOOK B, CUSTOMER C -- 조인 대상 테이블
--이렇게만하면 유의미하게 연결되지않는다.
WHERE O.BOOKID = B.BOOKID --조인 조건
  AND O.CUSTID = C.CUSTID --조인 조건
  ;
--유의미하게 연결 완료.  
--3개 테이블을 조인하면 
--조인 조건은 N-1개 혹은 그 이상
-- 조인조건 : B=O, O=C
-------
SELECT *
  FROM ORDERS O INNER JOIN BOOK B --조인테이블
    ON O.BOOKID = B.BOOKID --조인조건
    INNER JOIN CUSTOMER C --조인테이블
    ON O.CUSTID = C.CUSTID --조인조건
WHERE C.NAME = '추신수' --찾을(검색)조건
; --ORDERS테이블 기준으로 JOIN
=======================================================
---------------------------
--(실습) BOOK, CUSTOMER, ORDERS 테이블 데이터를 조회
--1.장미란이 구입한 책제목, 출판사, 구입가격, 구입일자
--2.장미란이 구입한 책 중에 2014-01-01 ~ 2014-07-08까지 구입한 내역
        -->날짜 비교로 해라
--3.'야구를 부탁해'라는 책을 구입한 사람과 구입일자를 확인
--4.추신수, 장미란이 구입한 책제목, 구입금액, 구입일자 확인
---- (정렬 : 고객명, 구입일자 순으로)
--5.추신수가 구입한 책갯수, 합계금액, 평균값, 가장 큰금액, 가장 작은금액
--------------------------------
--1.장미란이 구입한 책제목, 출판사, 구입가격, 구입일자
SELECT B.BOOKNAME, B.PUBLISHER, O.SALEPRICE, O.ORDERDATE
  FROM BOOK B, CUSTOMER C, ORDERS O
 WHERE B.BOOKID = O.BOOKID 
    AND O.CUSTID = C.CUSTID
    AND C.NAME = '장미란'
;
--2.장미란이 구입한 책 중에 2014-01-01 ~ 2014-07-08까지 구입한 내역
SELECT ORDERDATE 
--O.ORDERDATE (BETWEEN '(TO_DATE('2014/01/01', 'YYYYMMDD'))'
--                 AND '(TO_DATE('2014/07/08', 'YYYYMMDD'))'
--(ORDERDATE >= 2014/01/01) AND (ORDERDATE <= 2014/07/08)
--BETWEEN '2014/01/01' AND 2014/07/08
--ORDERDATE (BETWEEN '20140101' AND '20140708')
--O.ORDERDATE (BETWEEN '(TO_DATE('20140101', 'YYYYMMDD'))'
--                 AND '(TO_DATE('20140708', 'YYYYMMDD'))'

  FROM BOOK B, CUSTOMER C, ORDERS O
 WHERE B.BOOKID = O.BOOKID 
    AND O.CUSTID = C.CUSTID
    AND C.NAME = '장미란'-- 장미란이 구입한 책이고~
    AND ORDERDATE BETWEEN TO_DATE('2014/01/01') AND TO_DATE('2014/07/08')
    --타입을 일치시켜서 비교해야 안정적으로 비교할 수 있다.
ORDER BY ORDERDATE
;
-----------시분초까지
SELECT ORDERDATE, TO_CHAR(ORDERDATE, 'YYYY-MM-DD HH24:MI:SS')
FROM ORDERS
;

--3.'야구를 부탁해'라는 책을 구입한 사람과 구입일자를 확인
SELECT C.NAME, O.ORDERDATE
  FROM BOOK B, CUSTOMER C, ORDERS O
 WHERE B.BOOKID = O.BOOKID 
   AND O.CUSTID = C.CUSTID
   AND B.BOOKNAME = '야구를 부탁해'
   ;
   
--4.추신수, 장미란이 구입한 책제목, 구입금액, 구입일자 확인
---- (정렬 : 고객명, 구입일자 순으로)
SELECT C.NAME, B.BOOKNAME, O.SALEPRICE, O.ORDERDATE
  FROM BOOK B, CUSTOMER C, ORDERS O
 WHERE B.BOOKID = O.BOOKID 
   AND O.CUSTID = C.CUSTID
   AND (C.NAME = '추신수' OR C.NAME = '장미란')
-- AND C.NAME IN('추신수', '장미란)
ORDER BY NAME, ORDERDATE
;

--5.추신수가 구입한 책갯수, 합계금액, 평균값, 가장 큰금액, 가장 작은금액
SELECT COUNT(O.BOOKID), SUM(O.SALEPRICE), 
       ROUND(AVG(O.SALEPRICE)), MAX(O.SALEPRICE), MIN(O.SALEPRICE) 
  FROM BOOK B, CUSTOMER C, ORDERS O
 WHERE B.BOOKID = O.BOOKID 
   AND O.CUSTID = C.CUSTID
   AND C.NAME = '추신수'
   ;
   ---------
-- GROUP BY
SELECT C.NAME, 
       COUNT(*) AS CNT, 
       SUM(O.SALEPRICE) SUM_PRICE, 
       ROUND(AVG(O.SALEPRICE)) AVG_PRICE, 
       MAX(O.SALEPRICE) MAX_PRICE, 
       MIN(O.SALEPRICE) MIN_PRICE
FROM ORDERS O, CUSTOMER C
WHERE O.CUSTID = C.CUSTID --조인조건
--AND C.NAME IN ('추신수', '장미란')
GROUP BY C.NAME
;


   
   