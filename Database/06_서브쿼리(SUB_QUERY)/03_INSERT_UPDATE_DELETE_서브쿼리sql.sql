-- INSERT, UPDATE, DELETE 내에서의 서브쿼리 사용
/*
■ INSERT 문
INSERT INTO 테이블명
       (컬럼명1, 컬럼명2, ..., 컬럼명n)
VALUES (값1, 값2, ... , 값n);  

■ UPDATE문
UPDATE 테이블명
   SET 컬럼명1 = 값1, 컬럼명2 = 값2, ..., 컬럼명n = 값n
[WHERE 대상조건 ]--옵션이지만 항상 사용한단 생각으로 접근

■ DELETE 문
DELETE FROM 테이블명
[WHERE 대상조건 ];
*****************************/

/*■ INSERT 문
INSERT INTO 테이블명
       (컬럼명1, 컬럼명2, ..., 컬럼명n) 
       --컬럼 생략 가능하나 컬럼을 적지 않으면 순서대로 매칭
VALUES (값1, 값2, ... , 값n);  
--===========================*/
SELECT * FROM BOOK;
INSERT INTO BOOK
        (BOOKID, BOOKNAME, PUBLISHER, PRICE)
VALUES (30, '자바란 무엇인가?', 'ITBOOK', 30000);
COMMIT; --커밋 전까지 동일 세션에선 실행되나 프로그램상에서 셀렉했을 때 데이터가 나오지 않는다.
INSERT INTO BOOK
        (BOOKID, PUBLISHER, BOOKNAME, PRICE)
VALUES (31, 'ITBOOK', '자바란 무엇인가?(개정판)', 35000);
COMMIT;
-----
SELECT * FROM BOOK ORDER BY BOOKID DESC;
INSERT INTO BOOK
VALUES (32, '자바란 무엇인가?(개정3판)', 'ITBOOK', 35000);
COMMIT;
-----------아래 두 경우 NULL값이 들어간다.
INSERT INTO BOOK
VALUES (33, '자바란 무엇인가?(개정4판)', '', 35000);
COMMIT;                     --없더라도 항목을 NULL값이라도 줘야함
INSERT INTO BOOK
       (BOOKID, BOOKNAME, PRICE)
VALUES (34, '자바란 무엇인가?(개정5판)', 35000);
COMMIT;
----
SELECT * FROM BOOK ORDER BY BOOKID DESC;
SELECT NVL(MAX(BOOKID), 0) + 1 FROM BOOK;
INSERT INTO BOOK
       (BOOKID, BOOKNAME, PRICE)
VALUES (35, '자바란 무엇인가?(개정6판)', 35000);
COMMIT;
------------------
--일괄입력 : 테이블의 데이터를 이용해서 여러 데이터를 한번에 입력처리
----IMPORTED_BOOK===> BOOK테이블로 일괄 입력
INSERT INTO BOOK
SELECT * FROM IMPORTED_BOOK; --SELECT문장으로 만든 데이터가 BOOK테이블에 들어간다
SELECT * FROM BOOK ORDER BY BOOKID DESC;
--=======================

/*
■ UPDATE문
UPDATE 테이블명
   SET 컬럼명1 = 값1, 컬럼명2 = 값2, ..., 컬럼명n = 값n
[WHERE 대상조건 ]--옵션이지만 항상 사용한단 생각으로 접근
--===========================*/
SELECT * FROM CUSTOMER;
--박세리 주소 수정 : 대한민국 대전 --> 대한민국 부산
SELECT * FROM CUSTOMER WHERE NAME = '박세리';
UPDATE CUSTOMER 
   SET ADDRESS = '대한민국 부산'
 WHERE NAME = '박세리'
;
COMMIT;

--박세리 주소, 전화번호 : '대전', '010-1111-1111'
UPDATE CUSTOMER
   SET ADDRESS = '대전', 
         PHONE = '010-1111-1111'
 WHERE NAME = '박세리'
;
COMMIT;
----------------
--박세리 주소 수정 : 김연아와 동일하게 변경
SELECT ADDRESS FROM CUSTOMER WHERE NAME = '김연아';
UPDATE CUSTOMER 
   SET ADDRESS = (SELECT ADDRESS FROM CUSTOMER WHERE NAME = '김연아')
--                      데이터가 두개가 오면 안된다. IN 사용 XX! 1개 혹은 0개만 허용     
 WHERE NAME = '박세리' 
;
SELECT * FROM CUSTOMER WHERE NAME = '박세리';
----

SELECT * FROM CUSTOMER WHERE NAME = '추신수';
UPDATE CUSTOMER 
   SET ADDRESS = (SELECT ADDRESS FROM CUSTOMER WHERE NAME = '추신수'),
         PHONE = (SELECT PHONE FROM CUSTOMER WHERE NAME = '추신수')
 WHERE NAME = '박세리' 
;

/*
■ DELETE 문
DELETE FROM 테이블명
[WHERE 대상조건 ];
*/
-- 책 제목이 자바로 시작하고 출판사가 ITBOOK인 데이터 삭제
SELECT *
  FROM BOOK
 WHERE BOOKNAME LIKE '자바%' AND PUBLISHER = 'ITBOOK'
;
--DELETE FROM BOOK 
--      WHERE BOOKNAME LIKE '자바%' AND PUBLISHER = 'ITBOOK'
--      ;
COMMIT;

-- 책 ID가 30보다 크거나 같은 것을 삭제
SELECT *
  FROM BOOK
 WHERE BOOKID >= 30;
--DELETE FROM BOOK
-- WHERE BOOKID >= 30;
COMMIT;
 