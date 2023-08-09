/* 내장함수 : 오라클 DBMS에서 제공하는 함수(FUNCTION)_미리 만든 편의제공
그룹함수 : 하나 이상의 행을 그룹으로 묶어서 연산
COUNT(*) : 데이터 갯수 조회(전체 컬럼에 대하여)
COUNT(컬럼명) : 데이터 갯수 조회(지정된 컬럼만 대상으로)_ NULL제외
SUM(컬럼명) : 합계값 구하기
AVG(컬럼명) : 평균값 구하기
MAX(컬럼명) : 최대값 구하기
MIN(컬럼명) : 최소값 구하기
******************************/
SELECT * FROM BOOK;
SELECT COUNT(*) FROM BOOK; -- 테이블 데이터 건수 확인
SELECT COUNT(PHONE) FROM CUSTOMER; -- 4건 조회 : NULL 값 제외
-- '대한미디어', '이상미디어' 출판사들의 도서 갯수
SELECT COUNT(*) FROM BOOK WHERE PUBLISHER IN ('대한미디어', '이상미디어');
-------
-- PHONE 컬럼 값이 NULL인 데이터 건수?
SELECT COUNT(*) FROM CUSTOMER WHERE PHONE IS NULL; -- NULL은 비교연산자 안돼요.
-- PHONE 컬럼 값이 NULL이 아닌 데이터 건수?
SELECT COUNT(*) FROM CUSTOMER WHERE PHONE IS NOT NULL;
--------------------------------
-- SUM
SELECT * FROM BOOK;
SELECT SUM(PRICE) FROM BOOK;
--대한미디어, 이상미디어 출판사의 모든 책의 금액합계
SELECT SUM(PRICE) FROM BOOK WHERE PUBLISHER IN  ('대한미디어', '이상미디어');
--대한미디어, 이상미디어 출판사의 모든 책의 금액 평균 값
SELECT AVG(PRICE) FROM BOOK WHERE PUBLISHER IN ('대한미디어', '이상미디어');
--대한미디어, 이상미디어 출판사의 모든 책중에 최고가, 최저가
SELECT MAX(PRICE), MIN(PRICE) FROM BOOK WHERE PUBLISHER IN ('굿스포츠');
--단어 '야구'가 들어간 모든 책의 금액합계
SELECT SUM(PRICE) FROM BOOK WHERE BOOKNAME LIKE  ('%야구%');

--(실습) 책제목에 대하여  MIN, MAX 값은 무엇인지 확인
SELECT MAX(BOOKNAME), MIN(BOOKNAME) FROM BOOK;
-------
--(실습) 출판된 책의 갯수(권수), 합계금액, 평균 금액, 가장 삐싼책, 가장 싼책
SELECT COUNT(*) AS 총_권수
, SUM(PRICE) AS 합계금액
, AVG(PRICE) AS 평균금액
, MAX(PRICE) AS 가장_고가
, MIN(PRICE) AS 가장_저가
FROM BOOK;
SELECT * FROM BOOK ORDER BY BOOKNAME DESC;

--(실습문제)
--1. 출판된 책 전체 조회(정렬: 출판사, 금액순)
--2. 굿스포츠에서 출판한 책을 책 제목 순으로 조회
--3. 출판된 책 중 10000원 이상인 책(가격순-큰금액부터)
--4. 박지성의 총 구매액(CUSTID = 1)
--5. 박지성이 구매한 도서의 수
--6. 성이 '김'씨인 고객의 이름과 주소
--7. 성이 '박'이고 이름이 '성'으로 끝나는 고객의 이름과 주소
--8. 책 제목 '야구' 부터 '축구' 까지를 검색하기(책제목으로 정렬)
---- (단, '역도' 관련도서는 제외)

SELECT * FROM BOOK;
SELECT * FROM BOOK ORDER BY PUBLISHER, PRICE;
SELECT * FROM BOOK WHERE PUBLISHER IN ('굿스포츠') ORDER BY BOOKNAME;
SELECT * FROM BOOK WHERE PRICE >= 10000 ORDER BY PRICE DESC;

SELECT SUM(SALEPRICE) 구매도서금액 FROM ORDERS 
WHERE CUSTID = (SELECT CUSTID FROM CUSTOMER WHERE NAME = '박지성');

SELECT '박지성' AS NAME, COUNT(*) AS 구매도서갯수 FROM ORDERS WHERE CUSTID = 1;

SELECT NAME, ADDRESS FROM CUSTOMER WHERE NAME LIKE '김%'; 
SELECT NAME, ADDRESS FROM CUSTOMER WHERE NAME LIKE '박%성';

SELECT * FROM BOOK WHERE BOOKNAME BETWEEN '야구' AND '축구'
--AND BOOKNAME NOT IN ('역도 단계별기술') ORDER BY BOOKNAME;     // IN 구문은 정확한 데이터 명을 필요로 한다.
AND BOOKNAME NOT LIKE '%역도%' ORDER BY BOOKNAME;




