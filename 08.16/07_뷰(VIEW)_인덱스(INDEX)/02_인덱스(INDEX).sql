/* *********************************
<인덱스 - INDEX>
테이블에 있는 데이터(로우, 레코드)를 빠르게 찾기 위해 만들어진 데이터 구조
- 자동인덱스 : PRIMARY KEY 선언시 또는 UNIQUE 제약조건 설정시 생성되는 인덱스
- 수동인덱스 : CREATE INDEX 명령문을 사용해서 만드는 인덱스

<인덱스 생성시 고려사항>
-인덱스는 WHERE절에 자주 사용되는 컬럼에 적용
-조인조건에 자주 사용되는 컬럼에 적용
-컬럼의 데이터 분포도가 낮을 때 효율 증가(10~15%)
-단일 테이블에 인덱스가 너무 많아도 속도 저하 문제 발생(테이블당 4~5정도)
-컬럼의 데이터가 변경(입력,수정,삭제)되는 경우가 많으면 인덱스 사용량 검토
--(데이터 입력, 수정, 삭제시 인덱스에 대한 입력, 수정, 삭제 작업 발생)

<인덱스 생성 문법>
CREATE INDEX 인덱스명 ON 테이블명 (컬럼명1[, 컬럼명2, ..., 컬럼명n]);
CREATE [UNIQUE] INDEX ON 테이블명 (컬럼명1 [ASC|DESC], 컬럼명2, .., 컬럼명n);

<인덱스 수정 문법>
ALTER [UNIQUE] INDEX 인덱스명 ON 테이블명 (컬럼명1[, 컬럼명2, ..., 컬럼명n]);

<인덱스 삭제 문법>
DROP INDEX 인덱스명;

<인덱스 재구성 문법>
ALTER INDEX 인덱스명 REBUILD;
ALTER [UNIQUE] INDEX 인덱스명 [ON 테이블명 (컬럼명, ...)] REBUILD;
************************************/
--=====================================================================================
--인덱스 생성 : BOOK 테이블의 출판사(PUBLISHER) 컬럼에 IX_BOOK_PUB 인덱스 만들기
CREATE INDEX IX_BOOK_PUB ON BOOK (PUBLISHER); --ORDER BY PUBLISHER를 사용한 아래 코드의 테이블과 비슷한 모형임
SELECT * FROM BOOK ORDER BY PUBLISHER;

SELECT * FROM BOOK WHERE PUBLISHER = '굿스포츠'; --데이터가 수천수만개일 경우 INDEX가 없다면, 하나하나 순차비교하기 때문에
                                               --속도 면에서 큰 문제가 발생한다.
                                               -- 부분 검색
                                                --F10을 누르면 '계획 설명' 창에서 인덱스 관련정보를 볼 수 있다.
SELECT * FROM BOOK WHERE BOOKNAME = '축구의 이해'; -- 전체 검색

-- 인덱스 생성 : 2개 컬럼 기준
-- BOOK 테이블의 PUBLISHER 와 PRICE 컬럼을 대상으로 IX_BOOK_PUB_PRICE 인덱스 생성
CREATE INDEX IX_BOOK_PUB_PRICE ON BOOK (PUBLISHER, PRICE);
SELECT * FROM BOOK ORDER BY PUBLISHER, PRICE;
SELECT * FROM BOOK WHERE PUBLISHER = '대한미디어' AND PRICE > 30000; --인덱스 사용 : F10
SELECT * FROM BOOK WHERE PUBLISHER = '대한미디어'; --인덱스 사용
SELECT * FROM BOOK WHERE PRICE >= 20000; -- 인덱스 사용 안함(안됨)
SELECT * FROM BOOK WHERE PRICE >= 7000 AND PUBLISHER = '굿스포츠'; --순서가 바뀌어도 인덱스 사용

----------------------------------------------
--(주의) 인덱스가 있음에도 적용되지 않는 경우
---- LIKE 사용시 또는 데이터가 가공된 경우
SELECT * FROM BOOK WHERE PUBLISHER LIKE '대한%'; -- 인덱스 사용
SELECT * FROM BOOK WHERE PUBLISHER LIKE '%미디어'; --인덱스 사용 안됨 (%뒤에 글자가 부분 검색으로 언제 나올지 모르므로.)
SELECT * FROM BOOK WHERE PUBLISHER LIKE '%대한%'; --인덱스 적용 안함

--원본 데이터를 가공(변형)하는 경우(인덱스 적용안됨)
SELECT * FROM BOOK WHERE UPPER(PUBLISHER) = 'PEARSON'; --적용못함
SELECT * FROM BOOK WHERE SUBSTR(PUBLISHER, 1, 2) = '대한'; --적용못함

--인덱스 삭제
DROP INDEX IX_BOOK_PUB;
 
--======================================
/* *** 인덱스 실습 ****************************
마당서점 데이터베이스에서 다음 SQL 문을 수행하고 
데이터베이스가 인덱스를 사용하는 과정을 확인하시오.
(1) 다음 SQL 문을 수행해본다.
	SELECT name FROM Customer WHERE name LIKE '박세리';
(2) 실행 계획을 살펴본다. 실행 계획은 [F10]키를 누른 후 
    [계획 설명]탭을 선택하면 표시된다.
(3) Customer 테이블에 name으로 인덱스(ix_customber_name)를 생성하시오. 
    생성 후 (1)번의 질의를 다시 수행하고 실행 계획을 살펴보시오.
(4) 같은 질의에 대한 두 가지 실행 계획을 비교해보시오.
(5) (3)번에서 생성한 인덱스를 삭제하시오.
******************************************/
SELECT name FROM Customer WHERE name LIKE '박세리';
CREATE INDEX ix_customber_name ON CUSTOMER (NAME);

SELECT NAME FROM CUSTOMER WHERE NAME LIKE '%신수';

DROP INDEX ix_customber_name;


