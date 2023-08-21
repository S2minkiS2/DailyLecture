/* ********* 역할(롤 ROLE) ***********
역할(롤, ROLE) : DB 객체 및 시스템에 대한 권한을 모아둔 집합을 의미
역할 생성 : CREATE ROLE 역할이름
역할 제거 : DROP ROLE 역할이름
역할에 권한 부여 : GRANT 권한 [ON 객체] TO 역할이름
역할의 권한 회수 : REVOKE 권한 [ON 객체] FROM 역할이름
사용자에게 역할 부여 : GRANT 역할이름 TO 사용자

-- 마치 역할을 객체, 클래스처럼 인식

<역할 생성부터 사용자 추가까지의 단계>
CREATE ROLE - 역할생성
GRANT - 만들어진 역할에 권한 부여
GRANT - 사용자에게 역할 부여
-->>역할 제거할 경우 반대로 수행
DROP ROLE - 역할 삭제(사용자에게 부여된 역할에 대한 권한 역시 제거됨)
***************************************/

--사용자 계정에서 검색 역할(롤) 조회
SELECT * 
FROM USER_ROLE_PRIVS;

--관리자 계정 -system
SELECT * 
FROM DBA_SYS_PRIVS 
WHERE GRANTEE IN ('CONNECT', 'RESOURCE') 
ORDER BY GRANTEE, PRIVILEGE;
----------------------------------------------
-- (system) 롤(Role) 생성 : PROGRAMMER 라는 롤 생성
CREATE ROLE PROGRAMMER;

-- (system) PROGRAMMER 에게 권한 부여 테이블, 뷰(VIEW) 생성 권한 부여
GRANT CREATE ANY TABLE, CREATE ANY VIEW TO PROGRAMMER;
-- 다른 유저에도 테이블과 뷰를 만들수 있는 권한 (~ANY~)을 PROGRAMMER 롤에 부여
----------------------------------------------------------------------------------
--(system) MDGUEST 유저에게 PROGRAMMER 롤을 부여 := 테이블과 뷰를 만들수 있는 권한
CREATE USER MDGUEST IDENTIFIED BY mdguest
DEFAULT TABLESPACE "USERS" --"USERS"
TEMPORARY TABLESPACE "TEMP"; --"TEMP"
-- 롤 부여 : CONNECT, RESOURCE
GRANT CONNECT, RESOURCE TO MDGUEST;
-- 뷰 생성 권한 부여 
GRANT CREATE VIEW TO MDGUEST;
-----------------------------------------------------------------------------------

-- PROGRAMMER 역할을 MDGUEST에게 부여
GRANT PROGRAMMER TO MDGUEST;

--(MDGUEST유저) 테이블 생성 테스트 MADANG.BBB 만들기
SELECT * FROM USER_ROLE_PRIVS; --보유한 롤 확인
CREATE TABLE MADANG.BBB (BBB NUMBER); --MDGUEST, 마당유저 모두 재접속 해야 적용됨
CREATE TABLE MYSTUDY.BBB (BBB NUMBER); --테이블 생성 성공...?

--(system)(롤)권한 회수
REVOKE  PROGRAMMER FROM MDGUEST;

--(system)롤 삭제
DROP ROLE PROGRAMMER;




