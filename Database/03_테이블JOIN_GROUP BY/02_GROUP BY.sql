/* =====================
SELECT * | [ DISTINCT ] {컬럼명, 컬럼명, ...} --항목선택
  FROM 테이블명
[WHERE 조건절] --데이터를 걸러내는것
[GROUP BY {컬럼명, ....}
    [HAVING 조건] ] --GROUP BY 절에 대한 조건
[ORDER BY {컬럼명 [ASC | DESC], ....}] 
=======================*/
-- GROUP BY : 데이터를 그룹핑해서 처리할 경우 사용
-- GROUP BY 문을 사용하면 SELECT 항목에 사용할 수 있는 데이터가 제한됨
---- 사용가능 : GROUP BY 절에 사용된 컬럼 또는 
----         : 그룹함수 (CLUNT, SUM, AVG, MAX, MIN) 사용가능
----         : 상수값 사용가능(문자열, 숫자, 날짜 값)
----------------------------
--HAVING 절은 단독으로 사용할 수 없고, 반드시 GROUP BY 절과 함께 사용(종속절)
--HAVING 절 : 그루핑 데이터에서 찾을 조건 (검색조건) 설정할 때.
           -- GROUP BY 절에 의해서 만들어진 데이터에서 검색(선택)조건 부여
--=========================
--출판사 별 출판한 책 개수 구하기
SELECT PUBLISHER, COUNT(*), SUM(PRICE), AVG(PRICE), MIN(PRICE), MAX(PRICE)
--SELECT절에 모든 컬럼명을 쓸 수 없다. GROUP BY 절에 온 컬럼명, 그룹함수, 상수값
FROM BOOK
GROUP BY PUBLISHER   
;
-- 구매 고객별로 구매금액 합계를 구하시오
SELECT CUSTID, SUM(SALEPRICE)
  FROM ORDERS
GROUP BY CUSTID
;
----이름도 원하면 이름을 갖고있는 테이블과 JOIN을 해야함
----이름표시 : 이름으로 그룹핑
SELECT '이름', C.NAME, SUM(O.SALEPRICE) AS SUM_PRICE
  FROM ORDERS O, CUSTOMER C  --테이블
 WHERE C.CUSTID = O.CUSTID --제한, 선택조건
 GROUP BY C.NAME --이름으로 그룹핑 - GROUP BY
 ORDER BY SUM(O.SALEPRICE) DESC --정렬 (금액합계를 많이 구입한 순으로)
 -- 위치번호 사용 가능 
 -- = ORDER BY 2 DESC // 2 = SUM(O.SALEPRICE)
 -- 별칭 사용가능
 -- = ORDER BY SUM_PRICE
;

--주문(판매) 테이블의 고객별 데이터 조회 (건수, 합계, 평균, 최소, 최대금액)
SELECT CUSTID,
       COUNT(*), SUM(SALEPRICE), 
       TRUNC(AVG(SALEPRICE)), MIN(SALEPRICE), MAX(SALEPRICE)
FROM ORDERS
GROUP BY CUSTID

;
-- 고객별 데이터 중 박지성, 추신수 조회 (건수, 합계, 평균, 최소, 최대금액)
SELECT C.NAME, COUNT(*), SUM(SALEPRICE), 
                 TRUNC(AVG(SALEPRICE)), MIN(SALEPRICE), MAX(SALEPRICE)
FROM ORDERS O, CUSTOMER C
WHERE O.CUSTID = C.CUSTID
AND C.NAME IN ('박지성', '추신수')
GROUP BY C.NAME
;
------------------------------
--(실습) 고객명 기준으로 고객별 데이터 조회 (건수, 합계, 평균, 최소, 최대금액)
---- 추신수, 장미란 고객 2명만 조회
SELECT C.NAME, COUNT(*), SUM(SALEPRICE), AVG(SALEPRICE), MIN(SALEPRICE), MAX(SALEPRICE)
FROM ORDERS O, CUSTOMER C
WHERE O.CUSTID = C.CUSTID
AND C.NAME IN ('박지성', '추신수')
GROUP BY C.NAME
;
--표준SQL형식
SELECT C.NAME, COUNT(*), SUM(SALEPRICE), AVG(SALEPRICE), MIN(SALEPRICE), MAX(SALEPRICE)
FROM ORDERS O INNER JOIN CUSTOMER C --조인테이블 정의
    --교집합 : INNER JOIN / JOIN
    ON C.CUSTID = O.CUSTID --조인조건
 WHERE C.NAME IN ('박지성', '추신수')  --선택조건(찾을조건)
 GROUP BY C.NAME
 ;
 ----------------
 --3건이상 구입한 고객 조회
SELECT C.NAME
FROM CUSTOMER C, ORDERS O
WHERE C.CUSTID = O.CUSTID
GROUP BY C.NAME
HAVING COUNT(*) >= 3
;
-------------
-- 구매한 책 중에 20000원 이상인 책을 구입한 사람의 통계 데이터
SELECT C.NAME, COUNT(*), SUM(SALEPRICE),
        TRUNC(AVG(SALEPRICE)), MIN(SALEPRICE), MAX(SALEPRICE)
FROM  ORDERS O, CUSTOMER C
WHERE C.CUSTID = O.CUSTID
GROUP BY C.NAME 
--HAVING SALEPRICE >= 20000  =>이건 데이터가 없음.
HAVING MAX(O.SALEPRICE)>=20000 --2만원 이상 책을 1권이라도 구입한 사람
;

SELECT C.NAME, COUNT(*), SUM(SALEPRICE),
        TRUNC(AVG(SALEPRICE)), MIN(SALEPRICE), MAX(SALEPRICE)
FROM ORDERS O, CUSTOMER C
WHERE C.CUSTID = O.CUSTID
  AND SALEPRICE >= 20000 -- 2만원 이상 책들만 대상으로 
GROUP BY C.NAME
;

--(실습) 필요시 조인(JOIN)과 GROUP BY ~ HAVING 구문을 사용해서 처리
--1. 고객이 주문한 도서의 총판매건수, 판매액, 평균값, 최저가, 최고가 구하기
--2. 고객별로 주문한 도서의 총수량, 총판매액 구하기
--3. 고객의 이름과 고객이 주문한 도서의 판매가격을 검색
--4. 고객별로 주문한 모든 도서의 총 판매액을 구하고, 고객명으로 정렬
--5. 고객별로 주문한 건수, 합계금액, 평균금액을 구하고(3권 보다 적게 구입한 사람 검색)
--(번외) 고객 중 한 권도 구입 안 한 사람은 누구??

---------------------------
--1. 고객이 주문한 도서의 총판매건수, 판매액, 평균값, 최저가, 최고가 구하기
----(AS 별칭 사용시 주의) 빈칸, 특수문자 사용시 쌍따옴표("")로 묶어서 표기(한글사용자제)
----복합어 사용시 언더바_사용  EX) TOTAL_COUNT
SELECT COUNT(*), SUM(SALEPRICE), AVG(SALEPRICE), 
MIN(SALEPRICE), MAX(SALEPRICE)
FROM ORDERS
;

--2. 고객별로 주문한 도서의 총수량, 총판매액 구하기
SELECT NAME, COUNT(*), SUM(SALEPRICE)
FROM ORDERS O, CUSTOMER C
WHERE O.CUSTID = C.CUSTID
GROUP BY NAME
;

--3. 고객의 이름과 고객이 주문한 도서의 판매가격을 검색
SELECT NAME, SALEPRICE
FROM CUSTOMER C, ORDERS O
WHERE O.CUSTID = C.CUSTID
;

--4. 고객별로 주문한 모든 도서의 총 판매액을 구하고, 고객명으로 정렬
SELECT NAME, SUM(SALEPRICE)
FROM CUSTOMER C, ORDERS O
WHERE O.CUSTID = C.CUSTID
GROUP BY NAME
ORDER BY NAME
;

--5. 고객별로 주문한 건수, 합계금액, 평균금액을 구하고(3권 보다 적게 구입한 사람 검색)
SELECT NAME, COUNT(*), SUM(O.SALEPRICE) AS SUM_PRICE, ROUND(AVG(O.SALEPRICE))
FROM CUSTOMER C, ORDERS O
WHERE O.CUSTID = C.CUSTID
GROUP BY NAME
HAVING COUNT(*) < 3
ORDER BY SUM_PRICE DESC --컬럼별칭사용
;

--(번외) 고객 중 한 권도 구입 안 한 사람은 누구??
--SELECT NAME
--FROM CUSTOMER C, ORDERS O 
--WHERE O.CUSTID = C.CUSTID
--GROUP BY NAME
--HAVING COUNT(*) = 0 
--;

SELECT CUSTID FROM CUSTOMER;
SELECT DISTINCT CUSTID FROM ORDERS ORDER BY CUSTID;
--더 많은 값이 왼쪽에 있으면 LEFTOUTERJOIN 
--오른쪽이 기준이 되면 RIGHTOUTERJOIN
