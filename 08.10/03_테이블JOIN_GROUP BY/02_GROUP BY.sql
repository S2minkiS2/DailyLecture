/* ===================
SELECT * | [ DISTINCT ] {컬럼명, 컬럼명, ...}
  FROM 테이블명
[WHERE 조건절]
[GROUP BY {컬럼명, ....}
    [HAVING 조건] ] --GROUP BY 절에 대한 조건
[ORDER BY {컬럼명 [ASC | DESC], ....}] 
===================== */
-- GROUP BY : 데이터를 그룹핑해서 처리할 경우 사용
-- GROUP BY 문을 사용하면 SELECT 항목에 사용할 수 있는 데이터가 제한됨
---- GROUP BY 절에 사용된 컬럼 또는 그룹함수(COUNT, SUM, AVG, MAX, MIN) 사용가능
---- 상수값 사용가능(하나의 문자열, 숫자, 날짜 값)
-------------------------------------
-- HAVING 절은 단독 사용 불가, MUST be with GROUP BY.
-- HAVING 절 : GROUP BY 절에 의해서 만들어진 데이터에서 검색(선택)조건 부여 
--=====================
-- 출판사별 출판한 책 개수 구하기
SELECT PUBLISHER AS "출판사별", COUNT(*) AS "출판 권수",
        SUM(PRICE), AVG(PRICE), MAX(PRICE), MIN(PRICE)
FROM BOOK
GROUP BY PUBLISHER
;
-- 구매 고객별로 구매금액 합계를 구하시오
SELECT CUSTID, SUM(SALEPRICE)
FROM ORDERS
GROUP BY CUSTID
;
---- 이름표시 : 이름으로 그룹핑
SELECT C.NAME, SUM(O.SALEPRICE) AS SUM_PRICE
FROM ORDERS O INNER JOIN CUSTOMER C
ON C.CUSTID = O.CUSTID
GROUP BY C.NAME
ORDER BY 2 DESC -- SELECT 에서 SUM(O.SALEPRICE)이 2번째 인자이므로.
;
----
--주문(판매) 테이블의 고객별 데이터 조회(건수, 합계, 평균, 최소, 최대금액)
SELECT CUSTID, 
        COUNT(*),
        SUM(SALEPRICE),
        TRUNC(AVG(SALEPRICE)),
        MAX(SALEPRICE),
        MIN(SALEPRICE)
FROM ORDERS
GROUP BY CUSTID
;
--박지성 추신수 데이터
SELECT C.NAME, 
        COUNT(*),
        SUM(SALEPRICE),
        TRUNC(AVG(SALEPRICE)),
        MAX(SALEPRICE),
        MIN(SALEPRICE)
FROM ORDERS O INNER JOIN CUSTOMER C
ON O.CUSTID = C.CUSTID
WHERE C.NAME IN ('박지성', '추신수')
GROUP BY C.NAME 
;
--------------------------------------
--(실습) 그룹바이를 써서 고객명 기준으로 고객별 데이터 조회(건수, 합계, 펴균, 최소, 최대)
----- 추신수, 장미란 고객 2명만 조회(검색)

SELECT C.NAME,
        COUNT(*) AS 건수,
        SUM(SALEPRICE) AS 합계,
        TRUNC(AVG(SALEPRICE)) AS 평균,
        MAX(SALEPRICE) AS 최대,
        MIN(SALEPRICE) AS 최소
FROM ORDERS O INNER JOIN CUSTOMER C
ON O.CUSTID = C.CUSTID
WHERE C.NAME IN ('추신수', '장미란') -- 그룹핑된 데이터에서 찾기(검색/걸러내기)
GROUP BY C.NAME
;
SELECT C.NAME,
        COUNT(*) AS 건수,
        SUM(SALEPRICE) AS 합계,
        TRUNC(AVG(SALEPRICE)) AS 평균,
        MAX(SALEPRICE) AS 최대,
        MIN(SALEPRICE) AS 최소
FROM ORDERS O, CUSTOMER C
WHERE O.CUSTID = C.CUSTID
AND C.NAME IN ('추신수', '장미란')
GROUP BY C.NAME
;
--------------------------------------------------------------------------------
-- HAVING 절은 단독 사용 불가, MUST be with GROUP BY.
-- HAVING 절 : GROUP BY 절에 의해서 만들어진 데이터에서 검색(선택)조건 부여 
----------------------------------------------------------------------
-- 3건 이상 구입한 고객 조회
SELECT C.NAME,
        COUNT(*) AS 건수,
        SUM(SALEPRICE) AS 합계,
        TRUNC(AVG(SALEPRICE)) AS 평균,
        MAX(SALEPRICE) AS 최대,
        MIN(SALEPRICE) AS 최소
FROM ORDERS O INNER JOIN CUSTOMER C
ON O.CUSTID = C.CUSTID
WHERE C.NAME IN ('추신수', '장미란') -- 그룹핑된 데이터에서 찾기(검색/걸러내기)
GROUP BY C.NAME
    HAVING COUNT(*) >= 3
;
----------------------------------------------------------------------
-- 3건 이상 구입한 고객 조회 (이름, 구입수량)
SELECT C.NAME, 
        COUNT(*) AS "구입수량"
FROM ORDERS O INNER JOIN CUSTOMER C
ON O.CUSTID = C.CUSTID
GROUP BY C.NAME
    HAVING COUNT(*) >= 3
;
----------------------------------------------------------------------
-- 구매한 책중에 20000원 이상인 책을 한권이라도 구입한 사람의 통계 데이터
SELECT C.NAME,
        COUNT(*) AS 건수,
        SUM(SALEPRICE) AS 합계,
        TRUNC(AVG(SALEPRICE)) AS 평균,
        MAX(SALEPRICE) AS 최대,
        MIN(SALEPRICE) AS 최소
FROM CUSTOMER C INNER JOIN ORDERS O
ON C.CUSTID = O.CUSTID
WHERE O.SALEPRICE >= 20000              --WHERE 절에 조건 : 20000원 이상 책들만 대상으로
GROUP BY C.NAME;
------------------------------
SELECT C.NAME,
        COUNT(*) AS 건수,
        SUM(O.SALEPRICE) AS 합계,
        TRUNC(AVG(O.SALEPRICE)) AS 평균,
        MAX(O.SALEPRICE) AS 최대,
        MIN(O.SALEPRICE) AS 최소
FROM CUSTOMER C INNER JOIN ORDERS O
ON C.CUSTID = O.CUSTID
GROUP BY C.NAME
    HAVING MAX(SALEPRICE) >= 20000;     --HAVING 절에 조건 : 건수 여러개 출력

