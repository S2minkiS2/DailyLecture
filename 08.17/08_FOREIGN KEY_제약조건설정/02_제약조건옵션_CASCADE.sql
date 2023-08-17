/* 제약조건 옵션
CASCADE : 부모테이블(PARENT) 의 제약조건을 비활성화 시키면서
    참조하고 있는 자녀테이블(CHILD)의 제약조건까지 비활성화
---------------
ON DELETE CASCADE
    테이블간의 관계에서 부모테이블 데이터 삭제시 
    자녀테이블 데이터도 함꼐 삭제 처리
************************************/
--자녀테이블에서 참조하고 있는 상태에서는 부모테이블 컬럼 PK 비활성화 할 수 없음
--ORA-02297: cannot disable constraint (MADANG.SYS_C007026) - dependencies exist
ALTER TABLE DEPT DISABLE PRIMARY KEY;

--방법1 of 2 : 직접 자녀테이블 참조키 모두 삭제 또는 비활성화 후 부모테이블 비활성화

--DEPT:PK, EMP01, EMP02, EMP03:FK 활성화 

--방법2 of 2 : 부모테이블 제약조건 비활성화하면서 CASCADE 옵션을 사용한다.
ALTER TABLE DEPT DISABLE PRIMARY KEY CASCADE;
--==============================================================================
/* 
제약조건 옵션 : ON DELETE CASCADE
테이블간의 관계에서 부모테이블 데이터 삭제시 
자녀테이블 데이터도 함꼐 삭제 처리
********************************************/

CREATE TABLE C_MAIN (
    MAIN_PK NUMBER PRIMARY KEY,
    MAIN_DATA VARCHAR2 (30)
);
CREATE TABLE C_SUB(
    SUB_PK NUMBER PRIMARY KEY,
    SUB_DATA VARCHAR2 (30),
    SUB_FK NUMBER,
    
    CONSTRAINT C_SUB_FK FOREIGN KEY (SUB_FK)
    REFERENCES C_MAIN(MAIN_PK) ON DELETE CASCADE --부모테이블이 삭제될 떄 같이 삭제되겠다. 라는 서명
    --회원이 삭제되면 게시글을 삭제하겠다 혹은 게시글은 삭제되지 않게하겠다. 라는 것을 결정할 때 써먹음
);

INSERT INTO C_MAIN VALUES (1111, '1번 메인 데이터');
INSERT INTO C_MAIN VALUES (2222, '2번 메인 데이터');
INSERT INTO C_MAIN VALUES (3333, '3번 메인 데이터');
COMMIT;

INSERT INTO C_SUB VALUES (1, '1번 SUB', 1111);
INSERT INTO C_SUB VALUES (2, '2번 SUB', 2222);
INSERT INTO C_SUB VALUES (3, '3번 SUB', 3333);
INSERT INTO C_SUB VALUES (4, '4번 SUB', 3333);

SELECT * FROM C_MAIN;
SELECT * FROM C_SUB;
--================================
--메인 테이블 데이터 삭제
DELETE FROM C_MAIN WHERE MAIN_PK = 1111; -- MAIN의 PK 1111이 삭제되자, SUB의 1111도 자동 삭제되었다.bcz CASCADE
DELETE FROM C_MAIN WHERE MAIN_PK = 3333; -- MAIN 3333을 참조하던 SUB PK 3 과 4도 자동 삭제되었다.
--===================================
--부모 테이블 삭제시 자녀테이블 있으면 삭제 불가
--부모테이블 삭제하려면? (DISALBE 불가함)
--방법 1 : 자녀테이블 참조 제약조건을 삭제 후 부모테이블 삭제 처리
--방법 2 : CASCADE CONSTRAINTS 옵션 적용해서 삭제 처리 (자녀테이블 참조키 자동 삭제)
DROP TABLE C_MAIN; --참조테이블(자녀테이블) 있는 경우 삭제 안됨
DROP TABLE C_MAIN CASCADE CONSTRAINTS;
