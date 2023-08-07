-- DB관리자(DBA) / 개발자 / 일반 사용자(client) 
-- SYSTEM 유저에서 USER 생성 
-- USER SQL
ALTER USER "MYSTUDY"
DEFAULT TABLESPACE "USERS"
TEMPORARY TABLESPACE "TEMP"
ACCOUNT UNLOCK ;

-- QUOTAS

-- ROLES
GRANT "CONNECT" TO "MYSTUDY";
GRANT "RESOURCE" TO "MYSTUDY";
------------------------------------------

-- SYSTEM PRIVILEGES

