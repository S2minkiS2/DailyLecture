/* ===================
SELECT * | [ DISTINCT ] {컬럼명, 컬럼명, ...}
  FROM 테이블명
[WHERE 조건절]
[GROUP BY {컬럼명, ....}
    [HAVING 조건] ] --GROUP BY 절에 대한 조건
[ORDER BY {컬럼명 [ASC | DESC], ....}] 

--ASC : 오름차순(기본/생략가능)
--DESC : 내림차순
===================== */
-- 비교 : >, <, >=, <=, =, <>, (!=)
-- 논리연산 : AND, OR, NOT
-- IN, NOT IN
-- BETWEEN a AND b, NOT BETWEEN a AND b
-- LIKE : %, _ (under bar) 
----------------------------------------------
SELECT * FROM BOOK;
SELECT * FROM CUSTOMER;
SELECT * FROM ORDERS;
SELECT * FROM IMPORTED_BOOK;
----------------------------------------------
SELECT * FROM BOOK ORDER BY BOOKNAME; -- 기본 오름차순 ASC
SELECT * FROM BOOK ORDER BY BOOKNAME DESC; -- 내림차순
-- 출판사 기준 오름차순(또는 내림차순), 책제목 오름차순(내림차순)
SELECT * FROM BOOK ORDER BY PUBLISHER, BOOKNAME;
-- 풀찬사 기준 오름차순, 가격이 큰 것 부터(내림차순)
SELECT * FROM BOOK ORDER BY PUBLISHER, PRICE DESC;
----------------------------------------------------------------------
-- 논리 : AND, OR, NOT
-- 출판사 대한미디어, 금액이 30,000원 이상인 책
SELECT * FROM BOOK WHERE PUBLISHER = '대한미디어' and PRICE >= 30000;
-------------------------------------------------------------
-- OR : 출판사 대한미디어 또는 이상미디어
SELECT * FROM BOOK WHERE PUBLISHER = '대한미디어' OR  PUBLISHER = '이사미디어';

-- NOT (<>) : 출판사 굿스포츠 제외하고 나머지 전체
SELECT * FROM BOOK WHERE PUBLISHER <> '굿스포츠'; -- <> 같지않다
SELECT * FROM BOOK WHERE PUBLISHER != '굿스포츠'; -- != 같지않다
---------------------------------------------------------------
-- (실습 )출판사가 굿스포츠, 대한미디어 출판사가 아닌 도서 목록
SELECT * FROM BOOK 
WHERE PUBLISHER <> '대한미디어' AND PUBLISHER <> '굿스포츠';
                    
-- IN : 안에 있냐?
-- (실습) 나무수, 대한미디어, 삼성당에서 출판한 도서 목록
SELECT * FROM BOOK 
WHERE PUBLISHER = '나무수' OR PUBLISHER = '대한미디어' OR PUBLISHER = '삼성당';

SELECT * FROM BOOK 
WHERE PUBLISHER IN ('나무수', '대한미디어', '삼성당');

-- (실습) 나무수, 대한미디어, 삼성당에서 출판한 도서가 아닌 것
SELECT * FROM BOOK 
WHERE PUBLISHER <> '나무수' AND PUBLISHER <> '대한미디어' AND PUBLISHER <> '삼성당';

SELECT * FROM BOOK 
WHERE PUBLISHER NOT IN ('나무수', '대한미디어', '삼성당');
--==================================
-- 같지않다(다르다) : <>, !=

-- BETWEEN 값1(부터) AND 값2(까지) 
-- (실습) 출판된 책중에 8,000원 이상이고 22,000이하인 책
SELECT * FROM BOOK 
WHERE PRICE BETWEEN 8000 AND 22000
ORDER BY PRICE;

-- (실습) 출판된 책중에 8,000원 보다 작거나, 22,000 보다 큰 책
SELECT * FROM BOOK 
WHERE PRICE < 8000 OR PRICE > 22000
ORDER BY PRICE DESC;

SELECT * FROM BOOK 
WHERE PRICE NOT BETWEEN 8000 AND 22000
ORDER BY PRICE DESC;

DESC CUSTOMER;

--===============================================
-- 책 제목이 '야구' ~ '올림픽' (책제목 오름차순 정렬)
SELECT * FROM BOOK
WHERE BOOKNAME BETWEEN  '야구' AND '올림픽'
ORDER BY BOOKNAME DESC;
------------------------------
-- (실습 BETWEEN)출판사 나무수 ~ 삼성당 출판사 책(출판사명 오름차순)
SELECT * FROM BOOK
WHERE PUBLISHER BETWEEN '나무수' AND '삼성당'
ORDER BY PUBLISHER;


-- (실습 IN) 대한미디어, 이상미디어 출판한 책 목록(출판사명, 첵제목 정렬)
SELECT * FROM BOOK
WHERE PUBLISHER IN ('대한미디어', '이상미디어')
ORDER BY PUBLISHER, BOOKNAME;

--============================================================
-- LIKE : %, _ 부호와 함꼐 사용
-- % : 전체(모든것)를 의미(0,1,N)
-- _ : 문자 1개에 대하여 모든 것을 의미(최소 1개의 문자가 반드시 있어야 함)
-----------------------------------------
SELECT * FROM BOOK;
SELECT * FROM BOOK
WHERE PUBLISHER LIKE '%미디어' -- 출판사명이 <미디어>로 끝나는 출판사
;
-- '야구~'로 시작하는 책 조회
SELECT * FROM BOOK
WHERE BOOKNAME LIKE '야구%' -- <야구>로 시작하는 ~
;
-- 책 제목에 <단계>라는 단어가 있는 책 목록
SELECT * FROM BOOK
WHERE BOOKNAME LIKE '%단계%' -- 단계로 시작, 단계로 끝, 중간에 단계 모두 해당.
;

--(실습) 책 제목에 '구' 문자가 있는 책 목록
SELECT * FROM BOOK
WHERE BOOKNAME LIKE '%구%'
;

--(실습) 책 제목 중 2,3번째 글자가 <구의>인 책 목록(언더바 적용)
SELECT * FROM BOOK
WHERE BOOKNAME LIKE '_구의%'
;

--(실습) 책 제목에 '를' 문자가 3번째 위치에 있는 책 조회(언더바 적용)
SELECT * FROM BOOK
WHERE BOOKNAME LIKE '__를%'
;
-----------------------------------------