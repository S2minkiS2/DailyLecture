--(번외) 고객 중 한 권도 구입 안 한 사람은 누구??
----고객테이블에는 있는데, 주문(판메)테이블에 없는 사람
-----------
--(방법1) MINUS : 차집합 처리
SELECT CUSTID FROM CUSTOMER --1,2,3,4,5
MINUS
SELECT CUSTID FROM ORDERS; --1,1,2,3,4,1,...
 --저기서 SELECT 된 데이터 빼기 여기서 SELECT된 데이터

------
--방법1) 서브쿼리(부분쿼리- 쿼리 내에 쿼리가 있다)
SELECT *
FROM CUSTOMER
WHERE CUSTID NOT IN (SELECT CUSTID FROM ORDERS)
;

----
--(방법3) 외부조인(OUTER JOIN)
--고객 중 한번도 구입 내역이 없는 고객 명단 구하기
SELECT C.CUSTID, C.NAME, C.ADDRESS, C.PHONE
FROM CUSTOMER C, ORDERS O
--지금까지 양쪽에 있는 데이터를 찾았었지만
--CUSTOMER에는 있고 ORDERS에는 없는 데이터를 찾아야함
WHERE C.CUSTID = O.CUSTID(+) 
--JOIN조건(LEFT OUTER JOIN) 
--왼쪽 기준으로 오른쪽에 부족한 부분 표시 (+)부호 사용
AND O.ORDERID IS NULL --찾을(검색, 선택)조건
;
--더 많은 값이 왼쪽에 있으면 LEFTOUTERJOIN 
--오른쪽이 기준이 되면 RIGHTOUTERJOIN

--표준 SQL(LEFT OUTER JOIN)
--고객 중 한번도 구입 내역이 없는 고객 명단 구하기
SELECT C.CUSTID, C.NAME, C.ADDRESS, C.PHONE
    --O에 있는 데이터 사용 안하는 이유 : 어차피 전부 NULL임
FROM CUSTOMER C LEFT OUTER JOIN ORDERS O
    ON C.CUSTID = O.CUSTID
WHERE O.ORDERID IS NULL
;
--RIGHT OUTER JOIN
SELECT C.CUSTID, C.NAME, C.ADDRESS, C.PHONE
    --O에 있는 데이터 사용 안하는 이유 : 어차피 전부 NULL임
FROM  ORDERS O RIGHT OUTER JOIN CUSTOMER C --우측기준
    ON C.CUSTID = O.CUSTID
WHERE O.ORDERID IS NULL
;

--외부조인(우측기준) RIGHT OUTER JOIN
SELECT C.CUSTID, C.NAME, C.ADDRESS, C.PHONE
    --O에 있는 데이터 사용 안하는 이유 : 어차피 전부 NULL임
FROM  ORDERS O , CUSTOMER C
WHERE O.CUSTID(+) = C.CUSTID -- +부호가 부족한 부분에 가서 붙는다
--기준 테이블이 우측에 있다 : RIGHT OUTER JOIN
AND O.ORDERID IS NULL
;
-------------------------
--조인(JOIN, INNER JOIN, 내부조인) : 조인테이블 모두에 존재하는 데이터 검색
--외부조인 (OUTER JOIN) : 어느 한 쪽 테이블에만 존재하는 데이터 검색
-------------------------
CREATE TABLE DEPT (
    ID VARCHAR2(10) PRIMARY KEY,
    NAME VARCHAR2(30)
);
INSERT INTO DEPT VALUES ('10', '총무부');
INSERT INTO DEPT VALUES ('20', '급여부');
INSERT INTO DEPT VALUES ('30', 'IT부');
COMMIT;
------------
CREATE TABLE DEPT1 (
    ID VARCHAR2(10) PRIMARY KEY,
    NAME VARCHAR2(30)
);
INSERT INTO DEPT1 VALUES ('10', '총무부');
INSERT INTO DEPT1 VALUES ('20', '급여부');
COMMIT;
---------
CREATE TABLE DEPT2 (
    ID VARCHAR2(10) PRIMARY KEY,
    NAME VARCHAR2(30)
);
INSERT INTO DEPT2 VALUES ('20', '급여부');
INSERT INTO DEPT2 VALUES ('30', 'IT부');
COMMIT;
--=====================
SELECT * FROM DEPT;
SELECT * FROM DEPT1;
SELECT * FROM DEPT2;
-- LEFT OUTER JOIN : 좌측 테이블 기준(모두 표시)
SELECT * 
FROM DEPT D, DEPT1 D1
WHERE D.ID = D1.ID(+) 
; 
--RIGHT OUTER JOIN : 우측 테이블 기준(우측 테이블 데이터 모두 표시)
SELECT *
FROM DEPT2 D2, DEPT D
WHERE D2.ID(+) = D.ID
;
--FULL OUTER JOIN(표준SQL)
SELECT *
FROM DEPT1 D1 FULL OUTER JOIN DEPT2 D2
    ON D1.ID = D2.ID
ORDER BY D1.ID
;
-------------------
--(실습) DEPT1, DEPT2 테이블 사용해서
--1. DEPT1에는 있고, DEPT2에는 없는 데이터를 찾아라 (LEFT OUTER JOIN)
--2. DEPT2에는 있고, DEPT1에는 없는 데이터를 찾아라 (RIGHT OUTER JOIN)
------------------
--1.
SELECT D1.*--NULL값은 필요없으므로 D1에만 있는 모든값 보기
FROM DEPT1 D1, DEPT2 D2 --조인테이블
WHERE D1.ID = D2.ID(+) --조인 조건 : 왼쪽이 기준
AND D2.ID IS NULL --D2에는 없는 것 찾기 조건
;
--표준SQL문
SELECT D1.*
FROM DEPT1 D1 LEFT OUTER JOIN DEPT2 D2 --조인테이블 + 조인방식
    ON D1.ID = D2.ID
WHERE D2.ID IS NULL 
;

--2.
SELECT D2.* --NULL값은 필요없으므로 D2에만 있는 모든값 보기
FROM DEPT1 D1, DEPT2 D2
WHERE D1.ID(+) = D2.ID 
AND D1.ID IS NULL
;
--표준SQL문
SELECT D2.*
FROM DEPT1 D1 RIGHT OUTER JOIN DEPT2 D2
    ON D1.ID = D2.ID
WHERE D1.ID IS NULL
;