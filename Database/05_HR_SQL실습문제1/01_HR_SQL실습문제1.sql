/* ** 실습문제 : HR유저(DB)에서 요구사항 해결 **********
--1) 사번(employee_id)이 100인 직원 정보 전체 보기
--2) 월급(salary)이 15000 이상인 직원의 모든 정보 보기
--3) 월급이 15000 이상인 사원의 사번, 이름(LAST_NAME), 입사일(hire_date), 월급여 정보 보기
--4) 월급이 10000 이하인 사원의 사번, 이름(LAST_NAME), 입사일, 월급여 정보 보기
---- (급여가 많은 사람부터)
--5) 이름(first_name)이 john인 사원의 모든 정보 조회
--6) 이름(first_name)이 john인 사원은 몇 명인가?
--7) 2008년에 입사한 사원의 사번, 성명('first_name last_name'), 월급여 정보 조회
---- 성명 출력예) 'Steven King'
--8) 월급여가 20000~30000 구간인 직원 사번, 성명(last_name first_name), 월급여 정보 조회
--9) 관리자ID(MANAGER_ID)가 없는 사람 정보 조회
--10) 직종(job_id)코드 'IT_PROG'에서 가장 많은 월급여는 얼마
---------------------------------
--11) 직종별 최대 월급여 검색
--12) 직종별 최대 월급여 검색하고, 최대 월급여가 10000이상인 직종 조회
--13) 직종별 평균급여 이상인 직원 조회
*****************************/

--1) 사번(employee_id)이 100인 직원 정보 전체 보기
SELECT *
FROM EMPLOYEES
WHERE EMPLOYEE_ID = 100
;

--2) 월급(salary)이 15000 이상인 직원의 모든 정보 보기
SELECT *
FROM EMPLOYEES
WHERE SALARY >= 15000
;

--3) 월급이 15000 이상인 사원의 사번, 이름(LAST_NAME), 입사일(hire_date), 월급여 정보 보기
SELECT EMPLOYEE_ID, LAST_NAME, HIRE_DATE, SALARY
FROM EMPLOYEES
WHERE SALARY >= 15000
;

--4) 월급이 10000 이하인 사원의 사번, 이름(LAST_NAME), 입사일, 월급여 정보 보기
---- (급여가 많은 사람부터)
SELECT EMPLOYEE_ID, LAST_NAME, HIRE_DATE, SALARY
FROM EMPLOYEES
WHERE SALARY <= 10000
ORDER BY SALARY DESC
;

--5) 이름(first_name)이 john인 사원의 모든 정보 조회
SELECT *
FROM EMPLOYEES
WHERE FIRST_NAME = INITCAP('JOHN') 
--데이터가 표준화 된 경우 입력값을 동일한 형태로
;

--6) 이름(first_name)이 john인 사원은 몇 명인가?
--SQL이 대소문자를 구분하진 않지만 문자열에선 대소문자 구분함
-- john, JOHN, John...
SELECT COUNT(*)
FROM EMPLOYEES
WHERE FIRST_NAME = INITCAP('JOHN')
; 

--7) 2008년에 입사한 사원의 사번, 성명('first_name last_name'), 월급여 정보 조회
SELECT EMPLOYEE_ID, FIRST_NAME ||' '||LAST_NAME AS NAME, SALARY
FROM EMPLOYEES                      --CONCAT 사용 가능
WHERE HIRE_DATE >= TO_DATE('2008/01/01', 'YYYY/MM/DD') 
    AND HIRE_DATE <= TO_DATE('2008/12/31','YYYY/MM/DD')
;
---- 성명 출력예) 'Steven King'

--8) 월급여가 20000~30000 구간인 직원 사번, 성명(last_name first_name), 월급여 정보 조회
SELECT EMPLOYEE_ID, FIRST_NAME||' '|| LAST_NAME, SALARY
FROM EMPLOYEES
WHERE SALARY BETWEEN 20000 AND 30000
;
SELECT FIRST_NAME FROM EMPLOYEES WHERE SALARY BETWEEN 20000 AND 30000
UNION
SELECT LAST_NAME FROM EMPLOYEES WHERE SALARY BETWEEN 20000 AND 30000;


--9) 관리자ID(MANAGER_ID)가 없는 사람 정보 조회
SELECT *
FROM EMPLOYEES 
WHERE MANAGER_ID IS NULL
;

--10) 직종(job_id)코드 'IT_PROG'에서 가장 많은 월급여는 얼마
SELECT MAX(SALARY)
FROM EMPLOYEES
WHERE JOB_ID = 'IT_PROG'
;
---------------------------------
--11) 직종별 최대 월급여 검색
SELECT JOB_ID, MAX(SALARY)
FROM EMPLOYEES
GROUP BY JOB_ID
;


--12) 직종별 최대 월급여 검색하고, 최대 월급여가 10000이상인 직종 조회
SELECT JOB_ID, MAX(SALARY)
FROM EMPLOYEES
GROUP BY JOB_ID
HAVING MAX(SALARY) >= 10000
ORDER BY MAX(SALARY)
;

--13) 직종별 평균급여 이상인 직원 조회
--직종별 평균급여를 구하고 그 데이터와 EMPLOYEES를 JOIN~!
SELECT E.EMPLOYEE_ID, E.FIRST_NAME, E.LAST_NAME, E.JOB_ID, E.SALARY
       , J.JOB_ID AS J_JOB_ID, J.SALAVG
FROM EMPLOYEES E, 
    (SELECT JOB_ID, AVG(SALARY) AS SALAVG 
     FROM EMPLOYEES
     GROUP BY JOB_ID) J --직종별 평균급여 테이블
            --서브쿼리 : 가상테이블(인라인 뷰)
WHERE E.JOB_ID = J.JOB_ID --조인조건
  AND E.SALARY >= J.SALAVG --검색(선택)조건
;
--JOIN에 의미를 둔 서브쿼리 방식

--------
--상관서브쿼리 방식으로 찾기 --메인쿼리 데이터를 갖다 사용하는.
SELECT *
FROM EMPLOYEES E
WHERE SALARY >= (SELECT AVG(SALARY) FROM EMPLOYEES WHERE JOB_ID = E.JOB_ID) 
                    --회사평균급여 넣어줌
 
;







 //서브쿼리 다루기, GROUP BY 용도 알기 복습! 뷰, 인덱스
