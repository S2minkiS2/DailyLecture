/* ************************
뷰(VIEW) : 하나 또는 둘 이상의 테이블로 부터
   데이터의 부분집합을 테이블인 것처럼 사용하는 객체(가상테이블)
-->> (내부시스템)데이터를 숨기고 읽기 전용으로만 특정 데이터를 보여주고 싶을 때. 
-->> (내부시스템)다이렉트로 접근시키지 않고 데이터를 보여줄 때 VIEW를 제공
-->> (외부시스템)외부에서 접근해서 사용해야할 때도 마찬가지.
-->> (외부시스템)EX)다른 회사와 협업할 때 기본정보만 VIEW를 통해 제공

--뷰(VIEW) 생성문
CREATE [OR REPLACE] VIEW 뷰이름 [(컬럼별칭1, 컬럼별칭2, ..., 컬럼별칭n)]
AS
SELECT 문장
[옵션];

--읽기전용 옵션 : WITH READ ONLY
----> INSERT UPDATE DELETE 못하도록

--뷰(VIEW) 삭제
DROP VIEW 뷰이름;
***************************/
SELECT * FROM BOOK WHERE BOOKNAME LIKE '%축구%'; 
--이 문장을 어디 저장해뒀다가 그때그때 갖다쓰자~
--그걸 DB에 저장해준다. 그것이 VIEW!
--뷰 (VIEW) 만들기 -->
CREATE VIEW VW_BOOK
AS
SELECT * FROM BOOK WHERE BOOKNAME LIKE '%축구%'
WITH READ ONLY
; 
--CREATE OR REPLACE (만들거나 대체해라)
CREATE OR REPLACE VIEW VW_BOOK
AS
SELECT * FROM BOOK WHERE BOOKNAME LIKE '%야구%' 
;
-- 뷰 사용해서 데이터 검색
SELECT * FROM VW_BOOK; --실제로는 이 위치에 위의 SELECT문장이 온다.
SELECT * FROM (SELECT * FROM BOOK WHERE BOOKNAME LIKE '%축구%') --위와 같음
;

SELECT * FROM VW_BOOK
WHERE PUBLISHER = '굿스포츠';

-------------------------
--별칭 사용해서 VIEW 만들기
CREATE OR REPLACE VIEW VW_BOOK2
    (BID, BNAME, PUB, PRICE)
AS 
SELECT BOOKID AS BID, BOOKNAME, PUBLISHER, PRICE
FROM BOOK
WHERE BOOKNAME LIKE '%축구%'
WITH READ ONLY
;

--뷰 삭제 
DROP VIEW VW_BOOK;
----------------------
CREATE OR REPLACE VIEW VW_ORDERS
AS
SELECT O.*, 
       B.BOOKNAME, B.PUBLISHER, B.PRICE, 
       C.NAME, C.ADDRESS, C.PHONE
FROM ORDERS O, BOOK B, CUSTOMER C
WHERE O.BOOKID = B.BOOKID
AND O.CUSTID = C. CUSTID 
WITH READ ONLY
; --이렇게 조인문을 검색하는 일이 아주 빈번하다. 
  -- 이런 정보를 DB에 저장해두면 편하다.
SELECT * FROM VW_ORDERS WHERE NAME = '박지성';
            --TABLE 역할
SELECT * FROM VW_ORDERS WHERE PUBLISHER = '굿스포츠';

--==============================
--(실습) 뷰를 생성, 조회, 삭제
--1. 뷰생성 - 뷰명칭 : VW_ORD_ALL
---- 주문(판매)정보, 책정보, 고객정보 모두 조회할 수 있는 형태 뷰 
--2. 이상미디어에서 출판한 책중 판매된 책제목, 판매금액, 판매일 조회
--3. 이상미디어에서 출판한 책 중에서 추신수, 장미란이 구매한 책 정보 조회
---- 출력항목 : 구입한 사람이름, 책제목, 출판사, 원가(정가), 판매가, 판매일자
---- 정렬 : 구입한 사람이름, 구입일자 최근순
--4. 판매된 책에 대하여 구매자별 건수, 합계금액, 평균금액, 최고가, 최저가 조회
--(최종) 뷰삭제 : VW_ORD_ALL 삭제 처리
--====================================
CREATE OR REPLACE VIEW VW_ORD_ALL
AS 
SELECT O.*, 
       B.BOOKNAME, B.PUBLISHER, B.PRICE, 
       C.NAME, C.ADDRESS, C.PHONE
  FROM BOOK B, CUSTOMER C, ORDERS O
 WHERE B.BOOKID = O.BOOKID
   AND C.CUSTID = O.CUSTID
WITH READ ONLY
;
--2. 이상미디어에서 출판한 책중 판매된 책제목, 판매금액, 판매일 조회
SELECT BOOKNAME, SALEPRICE, ORDERDATE
FROM VW_ORD_ALL
WHERE PUBLISHER = '이상미디어'
;

--3. 이상미디어에서 출판한 책 중에서 추신수, 장미란이 구매한 책 정보 조회
---- 출력항목 : 구입한 사람이름, 책제목, 출판사, 원가(정가), 판매가, 판매일자
---- 정렬 : 구입한 사람이름, 구입일자 최근순
SELECT NAME, BOOKNAME, PUBLISHER, PRICE, SALEPRICE, ORDERDATE
FROM VW_ORD_ALL
WHERE PUBLISHER = '이상미디어' 
  AND NAME IN ('추신수', '장미란')
ORDER BY NAME, ORDERDATE DESC
;
--4. 판매된 책에 대하여 구매자별 건수, 합계금액, 평균금액, 최고가, 최저가 조회
SELECT COUNT(BOOKID), 
         SUM(SALEPRICE), AVG(SALEPRICE), MAX(SALEPRICE), MIN(SALEPRICE)
FROM VW_ORD_ALL
;

--**판매된 책
SELECT BOOKID
FROM VW_ORD_ALL
GROUP BY CUSTID;

