-- SQL에서 한 줄 주석 부호 (--)
--HTP 포트 변경 : 8080 -> 8090
SELECT DBMS_XDB.getHttpPort() FROM dual;
SELECT DBMS_XDB.GETHttpPort() FROM dual;
-- 대소문자 구분 없다.

-- HTTP 포트 8090으로 변경
exec dbms_xdb.setHttpPort(8090);


SELECT DBMS_XDB.GETHttpPort() FROM dual;