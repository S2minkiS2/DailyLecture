-- 다음 내장 함수의 결과를 적으시오.
SELECT ABS(-15) FROM DUAL; --절대값
SELECT CEIL(15.7) FROM DUAL; -- 16 : 천장값
SELECT COS(3.14159) FROM DUAL; -- 3.14159의 코사인값 반환
SELECT FLOOR(15.7) FROM DUAL; -- 15 : 바닥값
SELECT LOG(10,100) FROM DUAL; -- 2 :??
SELECT MOD(11, 4) FROM DUAL; -- 3 : 나머지값
SELECT POWER (3, 2) FROM DUAL; -- 9 : 3의 2승
SELECT ROUND (15.7) FROM DUAL; -- 16 : 소수점 첫번째자리 반올림해서 출력
SELECT SIGN (-15) FROM DUAL; -- -1 : 부호값 반환
SELECT TRUNC (15.7) FROM DUAL; --15 : 소수점 아래 잘라서 버리기
SELECT CHR(67) FROM DUAL; -- C : 오라클 문자의 아스키코드 변환
SELECT CONCAT('HAPPY ', 'Birthday') FROM DUAL;
-- HAPPY Birthday : 문자열 이어붙이기
SELECT LOWER ('Birthday') FROM DUAL; -- birthday : 소문자로 전부 바꾸기
SELECT LPAD('Page 1', 15, '*.') FROM DUAL ;
-- *.*.*.*.*Page 1 : 크기 15가 될때까지 왼쪽으로 *.채우기
SELECT LTRIM('Page 1', 'ae') FROM DUAL; 
-- Page 1 : 왼쪽에 제거할 문자가 없을 때까지 'ae'제거. 하지만 ae라는 문자열은 없었음.
SELECT REPLACE('JACK', 'J', 'BL') FROM DUAL; -- BLACK : J의 자리에 BL 대입
SELECT RPAD ('Page 1', 15, '*.') FROM DUAL;
-- Page 1*.*.*.*.* : 크기 15가 될때까지 오른쪽으로 *.채우기
SELECT RTRIM('Page 1', 'ae') FROM DUAL; 
-- Page 1 : 오른쪽에 제거할 문자가 없을 때까지 'ae'제거. 하지만 ae라는 문자열은 없었음.

SELECT SUBSTR('ABCDEFG', 3, 4) FROM DUAL; -- CDEF : 세번째 문자부터 4개 출력
SELECT TRIM (LEADING 0 FROM '00AA00') FROM DUAL; --AA00 : 시작부분에서 0 제거
SELECT UPPER('Birthday') FROM DUAL; -- BIRTHDAY : 대문자로 변환
SELECT ASCII('A') FROM DUAL; -- 65 : ASCII 코드로 변환
SELECT INSTR('CORPORATE FLOOR','OR', 3, 2) FROM DUAL; 
-- 14 : 3번째 문자부터 'OR' 문자검색, 2번째로 찾아지는 위치값
SELECT LENGTH('Birthday') FROM DUAL; -- 8 : 문자길이
SELECT ADD_MONTHS('14/05/21', 1) FROM DUAL; -- 0014/06/21 : 1개월을 더한 값
SELECT LAST_DAY(SYSDATE) FROM DUAL; -- 2023/08/31 : 이번달의 마지막날
SELECT NEXT_DAY(SYSDATE, '화') FROM DUAL; --2023/08/15 : 다음 화요일은 언제인가요?
SELECT ROUND(SYSDATE) FROM DUAL; --2023/08/10 : 날짜값 반올림
SELECT SYSDATE FROM DUAL; -- 2023/08/09 : 시스템 상 오늘 날짜
SELECT TO_CHAR(SYSDATE) FROM DUAL; --2023/08/09 : 시스템상 날짜를 문자열로 변환
SELECT TO_CHAR(123) FROM DUAL; -- 123 : 숫자 123을 문자열로 변환
SELECT TO_DATE('12 05 2014', 'DD MM YYYY') FROM DUAL;
-- 문자열 '12 05 2014'를 날짜 2014/05/12로 변환
SELECT TO_NUMBER('12.3') FROM DUAL; -- 12.3 : 문자열 12.3을 숫자로 변환
SELECT DECODE(1,1,'aa','bb') FROM DUAL; -- aa ??????
SELECT NULLIF(123,345) FROM DUAL; -- 123 : 2개 값이 같으면 NULL반환, 다르면 첫번째 값(123)을 반환
SELECT NVL(NULL,123) FROM DUAL; -- 123 : NULL일 때 123을 넣어줌

