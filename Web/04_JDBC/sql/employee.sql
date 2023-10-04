CREATE TABLE EMPLOYEE (
    SABUN NUMBER(5) PRIMARY KEY,
    NAME VARCHAR2(30),
    REGDATE DATE,
    PAY NUMBER(20)
);

INSERT INTO EMPLOYEE VALUES (1001, 'USER1', SYSDATE - 2, 1000);
INSERT INTO EMPLOYEE VALUES (1002, 'USER2', SYSDATE - 1, 2000);
COMMIT;

SELECT SABUN, NAME, REGDATE, PAY FROM EMPLOYEE;

SELECT COUNT(*) FROM EMPLOYEE;


SELECT NVL (MAX(SABUN),0) + 1 AS SABUN FROM EMPLOYEE;
