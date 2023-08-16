-- INSERT, UPDATE, DELETE 내에서의 서브쿼리 사용
/* 
■ INSERT 문
INSERT INTO 테이블명
       (컬럼명1, 컬럼명2, ..., 컬럼명n)
VALUES (값1, 값2, ... , 값n);  

■ UPDATE문
UPDATE 테이블명
   SET 컬럼명1 = 값1, 컬럼명2 = 값2, ..., 컬럼명n = 값n
[WHERE 대상조건 ]

■ DELETE 문
DELETE FROM 테이블명
[WHERE 대상조건 ];
***************************************************/
/* 
■ INSERT 문
*/
SELECT * FROM BOOK;
INSERT INTO BOOK 
    (BOOKID, BOOKNAME, PUBLISHER, PRICE)
VALUES (30, '자바를 잡아라', 'ITBOOK', 30000);
COMMIT;
INSERT INTO BOOK 
    (BOOKID, PUBLISHER, BOOKNAME, PRICE)
VALUES (31, 'ITBOOK', '자바를 잡아라(개정)', 35000);
------
SELECT * FROM BOOK ORDER BY BOOKID DESC;
INSERT INTO BOOK
VALUES (32, '자바 그만 잡을래', 'ITBOOK', 40000);

INSERT INTO BOOK
VALUES (33, '나를 한번 자바봐', '', 45000); --빈문자열 NULL처리.(NULL 명시적 입력해도 같음)
COMMIT;

INSERT INTO BOOK
    (BOOKID, BOOKNAME, PRICE) --값을 대입할 컬럼을 적어주고
VALUES (34, '마지막으로 자바봐', 45000); --값 없는 컬럼은 자동 NULL 처리

SELECT * FROM BOOK ORDER BY BOOKID DESC;

SELECT NVL(MAX(BOOKID), 0) +1 FROM BOOK; -- MAX값 데이터가 없을 때 (NULL일 때) 0으로 하겠다. 

INSERT INTO BOOK
    (BOOKID, BOOKNAME, PRICE) --값을 대입할 컬럼을 적어주고
VALUES ((SELECT NVL(MAX(BOOKID), 0) +1 FROM BOOK), '찐막 자바', 6000);

-----------------------------------------------
-- 일괄입력 : 테이블의 데이터를 이용해서 여러 데이터를 한번에 입력처리
---- IMPORTED_BOOK =====> BOOK 일괄입력
INSERT INTO BOOK
SELECT * FROM IMPORTED_BOOK; 

--일괄입력 몰라도 됌. 복습 안해

--============================================================================
/*
■ UPDATE문
UPDATE 테이블명
   SET 컬럼명1 = 값1, 컬럼명2 = 값2, ..., 컬럼명n = 값n
[WHERE 대상조건 ]
*/
SELECT * FROM CUSTOMER WHERE NAME = '박세리';
-- 박세리 주소 수정 : 대한민국 대전 -> 대한민국 부산

UPDATE CUSTOMER
    SET ADDRESS = '대한민국 부산'
WHERE NAME = '박세리'
;
-- 박세리 주소, 전화번호 : '대전', '010-3765-8531'
UPDATE CUSTOMER
    SET ADDRESS = '대전',
        PHONE = '010-3765-8531'
WHERE NAME = '박세리'
;
-- 박세리 주소 수정 : 김연아와 동일하게 변경

SELECT ADDRESS FROM CUSTOMER WHERE NAME = '김연아';
UPDATE CUSTOMER
    SET ADDRESS = (SELECT ADDRESS FROM CUSTOMER WHERE NAME = '김연아')
WHERE NAME = '박세리'
;
SELECT * FROM CUSTOMER;

/*
■ DELETE 문
DELETE FROM 테이블명
[WHERE 대상조건 ];
*/
-- 책 제목이 자바로 시작하고 출판사가 ITBOOK인 데이터 삭제

SELECT * FROM BOOK WHERE BOOKNAME LIKE '자바%' AND PUBLISHER = 'ITBOOK';
DELETE FROM BOOK 
    WHERE BOOKNAME LIKE '자바%' AND PUBLISHER = 'ITBOOK';
SELECT * FROM BOOK;
COMMIT;
-- 책ID가 30보다 크거나 같은 데이터 삭제
SELECT * FROM BOOK WHERE BOOKID >= 30;
DELETE FROM BOOK
    WHERE BOOKID >= 30;

