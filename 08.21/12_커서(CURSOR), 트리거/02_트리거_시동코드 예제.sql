SELECT * FROM BOOK ORDER BY BOOKID DESC;
SELECT * FROM BOOK_LOG; --오 재밌따!?
--------------------------------------------------------------------------------
-- INSERT 트리거 동작 여부 확인
INSERT INTO BOOK VALUES (30, 'DB의 이해', 'ITBOOK', 25000);

ROLLBACK; --입력취소하면 트리거에 의해 입력된 LOG 데이터도 함께 취소처리.

INSERT INTO BOOK VALUES (13, '민기는배고파', 'SMK', 950000);
INSERT INTO BOOK VALUES (14, '민기는피곤하당께', 'SMK', 450000);
INSERT INTO BOOK VALUES (15, '민기는 파스타 먹을거랑게', 'SMK', 15000);
COMMIT;
--------------------------------------------------------------------------------
-- UPDATE 트리거 동작 확인
SELECT * FROM BOOK ORDER BY BOOKID DESC;
SELECT * FROM BOOK_LOG;
UPDATE BOOK
    SET BOOKNAME = '신민기 인생살이' || BOOKNAME   -- 책 제목 앞에 붙여서 Update
    , PRICE = PRICE + 1000                      -- 가격도 수정 
WHERE BOOKNAME LIKE '신민기%'                    -- 책 고르기
;
--------------------------------------------------------------------------------
-- DELETE 트리거 동작 확인
SELECT * FROM BOOK ORDER BY BOOKID DESC;
SELECT * FROM BOOK_LOG;

DELETE FROM BOOK
WHERE BOOKNAME = '민기는피곤하당께'
;
DELETE FROM BOOK; -- integrity constraint
ROLLBACK;
--------------------------------------------------------------------------------    





