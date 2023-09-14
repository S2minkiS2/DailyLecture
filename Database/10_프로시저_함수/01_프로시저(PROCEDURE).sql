--PL/SQL 프로시저(PROCEDURE) - 오라클

--SYSTEM 유저에서 
SET SERVEROUTPUT ON; --서버쪽 출력화면을 볼 수 있게 설정

DECLARE --변수선언
    V_EMPID NUMBER(10);
    V_NAME VARCHAR2(30);
BEGIN --실행문 작성영역(시작)
    V_EMPID := 100; --치환문(대입문) 부호(콜론이퀄 :=)
    V_NAME := '홍길동';
    
    --화면출력
    DBMS_OUTPUT.PUT_LINE('HELLO PROCEDURE');
    DBMS_OUTPUT.PUT_LINE(V_EMPID || ':' || V_NAME);
END; --실행문 작성영역(끝)
----------------------
-- BOOK 테이블 데이터를 화면 출력
DECLARE --변수선언 영역
    V_BOOKID NUMBER(2);
    V_BOOKNAME VARCHAR2(40);
    V_PUBLISHER VARCHAR2(40);
    V_PRICE NUMBER(8);
BEGIN --실행문 작성영역 --이걸 사용하려면 컬럼값을 변수에 저장해야함
    SELECT BOOKID, BOOKNAME, PUBLISHER, PRICE
    INTO V_BOOKID, V_BOOKNAME, V_PUBLISHER, V_PRICE
    --컬럼값을 변수에 넣어야 사용할 수 있다.
    --1개의 데이터만 처리 가능
    --SELECT ~ INTO ~ FROM 형태로 DB데이터 선택하고 INTO절 변수에 저장
    FROM BOOK
    WHERE BOOKID = 3;
    
    DBMS_OUTPUT.PUT_LINE(V_BOOKID || ',' || V_BOOKNAME
     || ',' ||  V_PUBLISHER  || ',' ||  V_PRICE);
END;
--===========================
/* 저장프로시저 (STORED PROCEDURE)
매개변수(파라미터, PARAMETER) 사용 가능

매개변수의 유형
- IN : 입력을 받기만 하는 변수 형태 (기본값)
- OUT : 출력만 하는 변수 형태
        (이 변수로는 값을 전달받을 수 없고, 
        프로시저 실행 후 이 변수에 저장된 값을 호출한 곳으로 전달)
- IN OUT : 입력도 받고, 값을 변수를 통해 호출한 곳으로 전달(출력)
****************************/
CREATE OR REPLACE PROCEDURE BOOK_DISP --프로시저 선언부 
--매개변수 선언 영역 :() 안에 작성, 타입만 지정, 여러개면 구분문자 콤마(,) 사용
(
    IN_BOOKID IN NUMBER --데이터를 전달받는 IN 타입에 NUMBER타입
)

AS --변수선언 영역 (AS 또는 IS~ BEGIN문 사이)
    V_BOOKID NUMBER(2);
    V_BOOKNAME VARCHAR2(40);
    V_PUBLISHER VARCHAR2(40);
    V_PRICE NUMBER(8);
BEGIN --실행문 작성영역 
    SELECT BOOKID, BOOKNAME, PUBLISHER, PRICE
    INTO V_BOOKID, V_BOOKNAME, V_PUBLISHER, V_PRICE
    --컬럼값을 변수에 넣어야 사용할 수 있다.
    --1개의 데이터만 처리 가능
    --SELECT ~ INTO ~ FROM 형태로 DB데이터 선택하고 INTO절 변수에 저장
    FROM BOOK
    WHERE BOOKID = IN_BOOKID ; --숫자값 대신 매개변수
    
    DBMS_OUTPUT.PUT_LINE(V_BOOKID || ',' || V_BOOKNAME
     || ',' ||  V_PUBLISHER  || ',' ||  V_PRICE);
END;

-------------
--프로시저 실행 : EXECUTE 프로시저명
EXECUTE BOOK_DISP(3);
EXEC BOOK_DISP(10);

--프로시저 삭제 
DROP PROCEDURE BOOK_DISP


--=======================
/* (실습) 프로시저 작성하고 실행하기

고객테이블(CUSTOMER)에 있는 데이터 조회 프로시저 작성
- 프로시저명 : CUSTOMER_DISP
- 입력받는 값 : 고객ID
- 처리 : 입력받은 고객ID에 해당하는 데이터를 찾아서 화면 출력
- 출력항목 : 고객ID, 고객명, 주소, 전화번호

*************************/

CREATE OR REPLACE PROCEDURE CUSTOMER_DISP --프로시저 선언
(   --매개변수 선언부
IN_CUSTOMER_ID IN VARCHAR2 
) 
AS -- 변수선언 --실행문 작성 영역에서 필요한 변수는 다 선언해야함.

V_CUSTID CUSTOMER.CUSTID%TYPE ;
-->> CUSTOMER에 있는 CUSTID와 데이터 타입을 똑같이 써라
V_NAME CUSTOMER.NAME%TYPE;
V_ADDRESS CUSTOMER.ADDRESS%TYPE;
V_PHONE CUSTOMER.PHONE%TYPE;

--V_CUSTID VARCHAR2(10); 
--V_NAME VARCHAR2(20);
--V_ADDRESS VARCHAR2(100);
--V_PHONE NUMBER(15);

BEGIN --실행문
SELECT CUSTID, NAME, ADDRESS, PHONE
INTO V_CUSTID, V_NAME, V_ADDRESS, V_PHONE
FROM CUSTOMER
WHERE CUSTID = IN_CUSTOMER_ID
;

DBMS_OUTPUT.PUT_LINE(V_CUSTID ||','|| V_NAME  ||','||
                     V_ADDRESS  ||','|| V_PHONE );

END CUSTOMER_DISP;













