/*
컬럼의 기본 데이타 타입(문자열, 숫자, 날짜)
- VARCHAR2(n) : 문자열 가변길이  (Variable)
- CHAR(n) : 문자열 고정길이
- NUMBER(p, s) : 숫자타입 p:전체길이, s:소수점이하 자리수
    예) (5,2) : 정수부 3자리, 소수부 2자리 - 전체 5자리
- DATE : 날짜형 년,월,일 시간 값 저장

문자열 처리 : UTF-8 형태로 저장
- 숫자, 알파벳 문자, 특수문자 : 1 byte 처리(키보드 자판 글자들)
- 한글 : 3 byte 처리
====================*/
CREATE TABLE TEST (
    NUM NUMBER(5, 2), --숫자타입 전체자리수 5: 정수부3, 소수부2
    STR1 CHAR(10), --고정길이 문자열 10Byte
    STR2 VARCHAR2(10), --가변길이 문자열
    DATE1 DATE --날짜데이터 : 년월일시분초
);
SELECT * FROM TEST;
INSERT INTO TEST VALUES (100.454, 'ABC', 'ABC', SYSDATE);
INSERT INTO TEST VALUES (100.455, 'ABC', 'ABC', SYSDATE); --소수점 반올림
INSERT INTO TEST VALUES (100.456, 'ABC', 'ABC', SYSDATE); --소수점 반올림
COMMIT;

-- 오류발생: 정수부 3자리 저장 가능한데, 4자리 저장 시도
INSERT INTO TEST VALUES (1234.456, 'ABC', 'ABC', SYSDATE);

INSERT INTO TEST VALUES (100.456, 'ABCDE', 'ABCDE', SYSDATE);
COMMIT;
--문자열 붙이기 부호 (||) 사용
SELECT '-'||STR1 ||'-', '-'||STR2 ||'-' FROM TEST;
SELECT STR1, LENGTHB(STR1), STR2, LENGTHB(STR2) FROM TEST;
------------------------------------
--CHAR 타입 값 비교
SELECT * FROM TEST WHERE STR1 = STR2; -- 조회된 데이터 없음
SELECT * FROM TEST WHERE STR1 = 'ABC'; -- 오라클에서는 조회됨
SELECT * FROM TEST WHERE STR1 = 'ABC       '; -- 모든 DB에서 조회됨
SELECT * FROM TEST WHERE STR1 = 'ABC  '; --오라클에서는 조회됨
------------------------------------
-- 숫자 타입
SELECT * FROM TEST WHERE NUM = 100.45; -- NUMBER vs NUMBER
SELECT * FROM TEST WHERE NUM = '100.45'; -- 오라클 조회됨/ NUMBER vs 문자
SELECT * FROM TEST WHERE NUM = '100.45AAAA';--ORA-01722: invalid number
------------------------------------
INSERT INTO TEST (STR1, STR2) VALUES ('1234567890', '1234567890');
SELECT * FROM TEST WHERE STR1 = STR2;
SELECT '-'||STR1 ||'-', '-'||STR2 ||'-' FROM TEST;
SELECT STR1, LENGTHB(STR1), STR2, LENGTHB(STR2) FROM TEST;
------------------------------------
-- 날짜 타입
SELECT * FROM TEST;
SELECT DATE1, To_CHAR(DATE1, 'YYYY-MM-DD HH24:MI:SS') FROM TEST;
SELECT DATE1, To_CHAR(DATE1, 'YYYY/MM/DD HH24:MI:SS') FROM TEST;
SELECT DATE1, To_CHAR(DATE1, 'YYYY.MM.DD HH24:MI:SS') FROM TEST;
-- '20230808112035' : 2023년 08월 08일 11시 20분 35초
-- '20230808112035' : 2023-08월-08 11:20:35

------------------------------------
-- 한글데이터 처리(UTF-8) : ASCII 코드 1 byte, 한글 1글자 3byte 사용
SELECT * FROM TEST;
INSERT INTO TEST (STR1, STR2) VALUES ('ABCDEFGHIJ', 'ABCDEFGHIJ');
INSERT INTO TEST (STR1, STR2) VALUES ('ABCDEFGHIJ', '신민기'); --한글 3글자*3 = 9Byte
INSERT INTO TEST (STR1, STR2) VALUES ('ABCDEFGHIJ', '돼지불백'); --actual: 12, maximum: 10
--==================================

/* *** NULL (널)의 특성 *****
-- NULL(널) : 데이터가 없는 상태
-- NULL 은 비교처리가 안됨 : =, <>, !=, >, <, >=, <= 비교처리 의미없음 - 결과 NULL
-- NULL 과의 연산결과는 항상 NULL(연산 의미 없음)
-- NULL 값에 대한 조회(검색)은 IS NULL, IS NOT NULL 키워드로 처리
--------------------------*/
SELECT * FROM TEST;
SELECT * FROM TEST WHERE NUM = NULL; -- 조회안됨(비교연산 의미없음)
SELECT * FROM TEST WHERE NUM IS NULL;

SELECT * FROM TEST WHERE NUM <> NULL; -- 조회안됨(비교연산 의미없음)
SELECT * FROM TEST WHERE NUM <> 100;
SELECT * FROM TEST WHERE NUM IS NOT NULL; -- IS NOT NULL 사용 검색할 것
---------------------------------
-- NULL 과의 연산 결과 --> 항상 NULL (연산 의미 없음)
SELECT * FROM DUAL; -- DUAL 테이블, 일명 DUMMY 테이블(오라클 제공)
SELECT 100 + 200, 111 + 222 FROM DUAL;
SELECT 100 + NULL, 100 - NULL, 100 * NULL, 100 / NULL FROM DUAL;

SELECT * FROM TEST;
SELECT NUM, NUM + 100 FROM TEST;
SELECT NUM, NVL(NUM, 0), NVL(NUM, 0) + 100 FROM TEST;
---------------------------------
-- 정렬시 NULL
SELECT * FROM TEST ORDER BY STR2; -- 기본 오름차순 정렬, ASC 키워드 생략 가능
SELECT * FROM TEST ORDER BY STR2 DESC; -- 내림차순 정렬, DESC 키워드

-- 정렬시 오라클! 에서는 NULL 값을 가장 큰 값으로 처리 (맨 마지막 출력)
SELECT * FROM TEST ORDER BY NUM;
SELECT * FROM TEST ORDER BY NUM DESC;
SELECT * FROM TEST ORDER BY NUM NULLS FIRST; -- NULL값을 맨 앞에
SELECT * FROM TEST ORDER BY NUM NULLS LAST;-- NULL값을 맨 뒤에
---------------------------------
INSERT INTO TEST (NUM, STR1, STR2) VALUES (200, '', NULL);
SELECT * FROM TEST WHERE STR1 = ''; --빈문자열은 NULL이므로, 데이터 조회가 안된다.
SELECT * FROM TEST;

--==============================
/* (실습) 테이블(TABLE) 만들기(테이블명: TEST2)
    NO : 숫자타입 5자리, PRIMARY KEY 선언
    ID : 문자타입 10자리(영문10자리), 값이 반드시 존재(NULL 허용안함)
    NAME : 한글 10자리 저장 가능하도록 설정, 값이 반드시 존재
    EMAIL : 영문, 숫자, 특수문자 포함 30자리
    ADDRESS : 한글 100자
    INNUM : 숫자타입 정수부 7자리, 소수부 3자리(1234567.123)
    REGDATE : 날짜타입
*********************/
CREATE TABLE TEST2 (
    NO NUMBER(5) PRIMARY KEY,
    ID VARCHAR2(10) NOT NULL,
    NAME VARCHAR2(30) NOT NULL,
    EMAIL VARCHAR2(40),
    ADDRESS VARCHAR2(300),
    INNUM NUMBER(10, 3),
    REGDATE DATE
);
SELECT * FROM TEST2;

INSERT INTO TEST2 VALUES (12346, 'SHIN', '신민기', 'shinseogyong@gmail.com', 
    '경기도 용인시 문현로326 신안아파트', 0102736.6119, SYSDATE);

SELECT REGDATE, To_CHAR(REGDATE, 'YYYY.MM.DD HH24:MI:SS') FROM TEST2;

SELECT '-'|| ID||'-', '-'|| NAME||'-' FROM TEST2;
SELECT ID, LENGTHB(ID), NAME, LENGTHB(NAME) FROM TEST2;

ALTER TABLE TEST2 
ADD (PHONE VARCHAR2(30) );
COMMIT;
------------------------
-- (복제)특정 테이블의 테이블구조와 데이터를 함께 복사
CREATE TABLE TEST3
AS
SELECT * FROM TEST2;

SELECT *FROM TEST3;
------------------------
SELECT *FROM TEST2;
SELECT *FROM TEST3;
--======================
--특정 테이블의 특정 컬럼과 특정 데이터만 복사하면서 테이블 생성
CREATE TABLE TEST4
AS
SELECT NO, ID, NAME, EMAIL FROM TEST2 WHERE ID = 'SHIN';

SELECT * FROM TEST4;
--=========================
-- 특정 테이블 구조만 복사 (데이터는 복사하지 않음)
CREATE TABLE TEST5
AS
SELECT *FROM TEST2 WHERE 1 = 2;

