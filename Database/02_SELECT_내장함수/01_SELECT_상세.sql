/* ===================
SELECT * | [ DISTINCT ] {컬럼명, 컬럼명, ...} --항목선택
  FROM 테이블명
[WHERE 조건절] --데이터를 걸러내는것
[GROUP BY {컬럼명, ....}
    [HAVING 조건] ] --GROUP BY 절에 대한 조건
[ORDER BY {컬럼명 [ASC | DESC], ....}] 

--ASC : 오름차순(기본/생략가능)
--DESC : 내림차순
===================== */
-- 비교 : >, <, >=,<=, =, <>같지않다, !=
-- 논리 : AND, OR, NOT
-- IN, NOT IN
-- BETWEEN a AND b , NOT BETWEEN a AND b //  a부터 b까지
-- LIKE : %(퍼센트), _(언더바) // 부분일치
---------------------------------
SELECT * FROM BOOK;
SELECT * FROM CUSTOMER;
SELECT * FROM ORDERS;
------------------------
SELECT * FROM BOOK ORDER BY BOOKNAME; 
--기본 오름차순(ASC생략) BOOKNAME으로 정렬한다.
SELECT * FROM BOOK ORDER BY BOOKNAME DESC;
-- 출판사 기준 오름차순(또는 내림차순)
SELECT * FROM BOOK ORDER BY PUBLISHER;
SELECT * FROM BOOK ORDER BY PUBLISHER DESC; -- 내림차순

---- 출판사 기준 오름차순, 책 제목 오름차순
SELECT * FROM BOOK ORDER BY PUBLISHER, BOOKNAME;

-- 출판사 기준 오름차순, 가격이 큰 것부터 (내림차순)
SELECT * FROM BOOK ORDER BY PUBLISHER, PRICE DESC;
-----------------
--논리 : AND, OR, NOT (키워드 그대로 사용 논리연산)
-- 출판사 대한미디어, 금액이 30000원 이상인 책(검색)
SELECT *
FROM BOOK
WHERE PUBLISHER '대한미디어' AND PRICE >= 30000;
--AND : 두개 조건 다 만족.
select * 
 from BOOK
 where PUBLISHER = '대한미디어' and PRICE >= 30000
 ; -- 모양과 가독성을 보고 알아서 선택, 대소문자 상관x
 
 --------------
 -- OR : 출판사 대한미디어 또는 이상미디어 출판한 책 목록
 SELECT *
 FROM BOOK
 WHERE PUBLISHER = '대한미디어' OR PUBLISHER = '이상미디어'
 ;
 
 --NOT : 출판사 굿스포츠를 제외하고 나머지 전체
SELECT * FROM BOOK WHERE NOT PUBLISHER = '굿스포츠';
SELECT * FROM BOOK WHERE PUBLISHER <> '굿스포츠'; --같지않다<>
SELECT * FROM BOOK WHERE PUBLISHER != '굿스포츠'; != 같지않음
 ------------------------------
 --(실습)출판사가 굿스포츠, 대한미디어 출판사가 아닌 도서 목록
SELECT * FROM BOOK WHERE NOT (PUBLISHER = '굿스포츠' OR PUBLISHER = '대한미디어');
SELECT * FROM BOOK WHERE PUBLISHER <> '굿스포츠' AND PUBLISHER <> '대한미디어';

--(실습) 나무수, 대한미디어, 삼성당에서 출판한 도서 목록
SELECT * 
FROM BOOK 
WHERE PUBLISHER = '나무수' 
OR PUBLISHER = '대한미디어' 
OR PUBLISHER = '삼성당'; --AND가 아니라 OR임. 또는
--=====================
--IN : 안에 있냐?(OR문 단순화)
SELECT * 
FROM BOOK 
WHERE PUBLISHER IN ('나무수', '대한미디어', '삼성당');
--------------------------------------

--(실습) 나무수, 대한미디어, 삼성당에서 출판한 도서가 아닌 것
SELECT * FROM BOOK 
WHERE PUBLISHER <> '나무수'
AND PUBLISHER <> '대한미디어'
AND PUBLISHER <> '삼성당';
--IN
SELECT * FROM BOOK 
WHERE PUBLISHER NOT IN ('나무수', '대한미디어', '삼성당')
;
--==========================
-- 같다(=), 크다(>), 작다(<), 크거나같다(>=), 작거나같다(<=)
-- 같지않다(다르다) : <>, !=
------------------------------
-- (실습)출판된 책 중에 8000원 이상이고, 22000원 이하인 책 목록 (가격순정렬)
-- AND 사용
SELECT * FROM BOOK WHERE PRICE >= 8000 AND PRICE <= 22000 ORDER BY PRICE;
-- BETWEEN 값1(부터) AND 값2(까지) : 값1부터 값2까지 형태로 사용(경계값포함)
SELECT * FROM BOOK
WHERE PRICE BETWEEN 8000 AND 22000 --8000부터 22000까지냐?
ORDER BY PRICE
;

--(실습)출판된 책 중에 8000원 보다 작거나, 22000원 보다 큰 책 (가격순정렬)
-- OR 사용
SELECT * FROM BOOK WHERE PRICE < 8000 OR PRICE > 22000 ORDER BY PRICE;
-- BETWEEN 사용 
SELECT * FROM BOOK 
WHERE PRICE NOT BETWEEN 8000 AND 22000 --8000~22000이 아닌것
ORDER BY PRICE
;

--=========================
-- 책 제목이 '야구' ~ '올림픽'(책제목 오름차순 정렬)
SELECT * FROM BOOK 
WHERE BOOKNAME >= '야구' AND BOOKNAME <='올림픽'
ORDER BY BOOKNAME
; --야구보다 같거나 큰 책, 올림픽보다 작거나 같은것 
-- 따라서 올림픽이야기는 올림픽보다 큰 값이므로 선택이 안됐다.
--BETWEEN사용
 SELECT * FROM BOOK 
WHERE BOOKNAME BETWEEN '야구' AND '올림픽'
ORDER BY BOOKNAME
;
-------
-- (실습 BETWEEN) 출판사 나무수 ~ 삼성당 출판사 책 (출판사명 오름차순 정렬)
SELECT * FROM BOOK 
WHERE PUBLISHER BETWEEN '나무수' AND '삼성당'
ORDER BY PUBLISHER
;

-- (실습 IN) 대한미디어, 이상미디어 출판한 책 목록(출판사명, 책 제목 정렬)
SELECT * FROM BOOK 
WHERE PUBLISHER IN ('대한미디어', '이상미디어')
ORDER BY PUBLISHER, BOOKNAME
;

-- LIKE : %, _ 부호와 함께 사용
-- % (퍼센트) : 전체(모든것)를 의미(0,1,N)
-- _ (언더바) : 문자 1개에 대하여 모든 것을 의미(1개의 문자 반드시 있어야 함)
-----------------------
SELECT * FROM BOOK
WHERE PUBLISHER LIKE '대한미디어'
; -- LIKE조건을 썼는데 %나 _를 안쓰면 EQUALS와 같다.

SELECT * FROM BOOK
WHERE PUBLISHER LIKE '%미디어'
; --출판사명이 <미디어>로 끝나는 출판사

--야구로 시작하는 책 조회
SELECT * FROM BOOK
WHERE BOOKNAME LIKE '야구%'
; --<야구>로 시작하는 책 제목 찾기

-- 책 제목에 <단계>라는 단어가 있는 책 목록 
SELECT * FROM BOOK
WHERE BOOKNAME LIKE '%단계%' --단계로 시작, 단계로 끝, 중간에 단계 모두 해당
;

--(실습) 책 제목에 '구' 문자가 있는 목록
SELECT * FROM BOOK
WHERE BOOKNAME LIKE '%구%'
;

--(실습) 책 제목 중 2,3번째 글자가 <구의>인 책 목록(언더바적용)
SELECT * FROM BOOK
WHERE BOOKNAME LIKE '_구의%'
;

--(실습) 책 제목에 '를' 문자가 3번째 위치에 있는 책 조회(언더바 적용)
SELECT * FROM BOOK
WHERE BOOKNAME LIKE '__를%'
;
