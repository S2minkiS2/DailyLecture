SELECT ABS(-15) FROM DUAL; --15
SELECT CEIL(15.7) FROM DUAL; --16
SELECT COS(3.14159) FROM DUAL; -- -0.99999999999647923060461239250850048324
SELECT FLOOR(15.7) FROM DUAL; --15
SELECT LOG(10,100) FROM DUAL; --2
SELECT MOD(11,4) FROM DUAL; --3
SELECT POWER(3,2) FROM DUAL; --9
SELECT ROUND(15.7) FROM DUAL; --16
SELECT SIGN(-15) FROM DUAL; -- -1
SELECT TRUNC(15.7) FROM DUAL; -- 15
SELECT CHR(65) FROM DUAL; --A
SELECT CONCAT('HAPPY ','BIRTHDAY') FROM DUAL;
SELECT LOWER('BIRTHday') FROM DUAL;
SELECT LPAD('page 1', 15, '*.') FROM DUAL;
SELECT LTRIM('page 1', 'ae') FROM DUAL;
SELECT REPLACE('신민기 조금 착해', '조금', '너무') FROM DUAL;
SELECT RPAD('page 1', 15, '*.') FROM DUAL;
SELECT RTRIM('page 1', 'ae') FROM DUAL;
SELECT SUBSTR('ABCDEFG', 3, 4) FROM DUAL; -- CDEF
SELECT UPPER('hppynewyear') FROM DUAL;
SELECT ASCII('A') FROM DUAL; --아스키 코드로 변환
SELECT INSTR('CORPORATE FLOOR', 'OR', 3, 2) FROM DUAL;
-- INSTR(대상, 찾는문자, 시작위치, nth)
SELECT LENGTH('Birthday') FROM DUAL;
SELECT ADD_MONTHS('14-05-21', 1) FROM DUAL; --0014/06/21
--ADD_MONTHS(날짜, 개월수)
SELECT LAST_DAY(SYSDATE) FROM DUAL; --2023/08/31
SELECT NEXT_DAY(SYSDATE, '일') FROM DUAL; --2023/08/13
SELECT SYSDATE FROM DUAL;
SELECT TO_CHAR(SYSDATE, 'YYYY-MM-DD(Day)') FROM DUAL;
SELECT TO_CHAR(123) FROM DUAL;
SELECT TO_DATE('12 05 2014', 'DD MM YYYY') FROM DUAL;
SELECT TO_NUMBER('12.3') FROM DUAL;
--===========================================================
SELECT TRIM(LEADING 0 FROM '00AA00') FROM DUAL;
-- AA00
SELECT ROUND(SYSDATE) FROM DUAL;
-- 2023/08/10
SELECT DECODE(1,1,'aa','bb') FROM DUAL;
-- aa
SELECT NULLIF(123, 345) FROM DUAL;
-- 123
SELECT NVL(NULL, 123) FROM DUAL;
-- 123
/*
1. `SELECT TRIM(LEADING 0 FROM '00AA00') FROM DUAL;`
   - 이 쿼리는 문자열 '00AA00'에서 왼쪽에 있는 0을 모두 제거하는 역할을 합니다.
   - 결과는 'AA00'이 됩니다.

2. `SELECT ROUND(SYSDATE) FROM DUAL;`
   - 이 쿼리는 현재 날짜와 시간을 가져와서 가장 가까운 정수로 반올림합니다.
   - 예를 들어, 만약 현재 날짜가 '2023-08-09 15:30:00' 이라면 결과는 '2023-08-09'가 될 것입니다.

3. `SELECT DECODE(1,1,'aa','bb') FROM DUAL;`
   - DECODE 함수는 조건을 평가하고 조건에 따라 값을 반환합니다.
   - 이 경우, 조건은 1과 1이 같은지 비교하고, 같다면 'aa'를 반환하고 아니라면 'bb'를 반환합니다.
   - 결과는 'aa'가 됩니다.

4. `SELECT NULLIF(123, 345) FROM DUAL;`
   - NULLIF 함수는 두 개의 값이 같으면 NULL을 반환하고, 다르면 첫 번째 값을 반환합니다.
   - 여기서는 123과 345가 다르므로 123이 결과로 반환됩니다.

5. `SELECT NVL(NULL, 123) FROM DUAL;`
   - NVL 함수는 첫 번째 값이 NULL인 경우 두 번째 값을 반환합니다.
   - 첫 번째 값이 NULL이므로 두 번째 값인 123이 결과로 반환됩니다.
*/