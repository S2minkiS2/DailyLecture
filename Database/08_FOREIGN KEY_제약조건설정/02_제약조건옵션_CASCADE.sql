/* 제약조건 옵션
CASCADE : 부모테이블(PARENT)의 제약조건을 비활성화 시키면서 --부모테이블 : 제약조건의 참조관계
          참조하고 있는 자녀테이블(CHILD)의 제약조건까지 비활성화
----------
ON DELETE CASCADE
  테이블간의 관계에서 부모테이블 데이터를 삭제시 
  자녀테이블 데이터도 함께 삭제 처리
***************/
--자녀테이블에서 참조하고 있는 상태에서는 부모테이블 컬럼 PK 비활성화 할 수 없음
ALTER TABLE DEPT DISABLE PRIMARY KEY; 
--참조되어지는 컬럼은 유니크해야한다.

--방법1 : 직접 자녀테이블 참조키를 모두 삭제 또는 비활성화 후 부모테이블 비활성화
--(개인실습)DEPT:PRIMARY KEY, EMP01, EMP02, EMP03:FOREIGN KEY 활성화
--방법2 : 부모테이블 제약조건 비활성화하면서 CASCADE 옵션을 사용한다
ALTER TABLE DEPT DISABLE PRIMARY KEY CASCADE; 
--PRIMARY KEY DISABLE 할테니까 혹시 참조하고 있는거 있으면 같이 DISABLE해라~
--====================================
/* 제약조건 옵션 : ON DELETE CASCADE
  테이블간의 관계에서 부모테이블 데이터를 삭제시 
  자녀테이블 데이터도 함께 삭제 처리 
  ************************/
CREATE TABLE C_MAIN (
    MAIN_PK NUMBER PRIMARY KEY, 
    MAIN_DATA VARCHAR2(30)
);

CREATE TABLE C_SUB (
    SUB_PK NUMBER PRIMARY KEY,
    SUB_DATA VARCHAR2(30),
    SUB_FK NUMBER, 
    
    CONSTRAINT C_SUB_FK FOREIGN KEY (SUB_FK)
    REFERENCES C_MAIN (MAIN_PK) ON DELETE CASCADE
                            --참조하고 있는거 있으면 부모테이블 삭제할 때 일괄 삭제하겠다
);

INSERT INTO C_MAIN VALUES(1111, '1번 메인 데이터');
INSERT INTO C_MAIN VALUES(2222, '2번 메인 데이터');
INSERT INTO C_MAIN VALUES(3333, '3번 메인 데이터');
COMMIT;

INSERT INTO C_SUB VALUES (1, '1번 SUB', 1111);
INSERT INTO C_SUB VALUES (2, '2번 SUB', 2222);
INSERT INTO C_SUB VALUES (3, '3번 SUB', 3333);
INSERT INTO C_SUB VALUES (4, '4번 SUB', 3333);
COMMIT;
-------------------------
SELECT * FROM C_MAIN;
SELECT * FROM C_SUB;
----------------
--메인 테이블 데이터 삭제
DELETE FROM C_MAIN WHERE MAIN_PK = 1111;
DELETE FROM C_MAIN WHERE MAIN_PK = 3333;
ROLLBACK;
--=====================
-- 부모테이블 삭제시 자녀테이블이 있으면 삭제가 불가
-- 부모테이블 삭제하려면 :
----> 방법1. 자녀테이블 참조 제약조건을 삭제 후 부모테이블 삭제처리
----> 방법2. CASCADE CONSTRAINTS 옵션 적용해서 삭제 처리
---- CASCADE CONSTRAINTS : 자녀테이블은 남아있고 메인테이블만 삭제
----> 자녀테이블을 지우는게 아니라 제약 조건을 지우는 것 

DROP TABLE DEPT2; --자녀테이블 없어서 그냥 삭제됨
DROP TABLE C_MAIN; --자녀(참조)테이블 있어서 삭제 안됨 
DROP TABLE C_MAIN CASCADE CONSTRAINTS;

--====================================

