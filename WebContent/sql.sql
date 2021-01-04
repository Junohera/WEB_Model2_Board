DROP TABLE BOARD PURGE;
CREATE TABLE BOARD(
    NUM NUMBER(5) PRIMARY KEY,
    PASS VARCHAR2(30),
    USERID VARCHAR2(30),
    EMAIL VARCHAR2(30),
    TITLE VARCHAR2(100),
    CONTENT VARCHAR2(1000),
    READCOUNT NUMBER(4) DEFAULT 0,
    WRITEDATE DATE DEFAULT SYSDATE
);

CREATE SEQUENCE BOARD_SEQ START WITH 1 INCREMENT BY 1;
SELECT * FROM MEMBER;
UPDATE MEMBER
SET
    PWD = 1234
WHERE USERID='test';
DELETE FROM MEMBER
WHERE USERID='test';
SELECT * FROM BOARD;

NUM
USERID
EMAIL
PASS
TITLE
CONTENT

INSERT INTO BOARD (
    NUM
    , USERID
    , EMAIL
    , PASS
    , TITLE
    , CONTENT
) VALUES (
    BOARD_SEQ.NEXTVAL
    , 'somi'
    , 'abcd@naver.com'
    , '1234'
    , '첫 방문'
    , '반갑습니다.'
);

INSERT INTO BOARD (
    NUM
    , USERID
    , EMAIL
    , PASS
    , TITLE
    , CONTENT
) VALUES (
    BOARD_SEQ.NEXTVAL
    , 'juno'
    , 'abcd@naver.com'
    , '1234'
    , '12월 31일'
    , '넌 아직 그곳에 있을까...'
);

INSERT INTO BOARD (
    NUM
    , USERID
    , EMAIL
    , PASS
    , TITLE
    , CONTENT
) VALUES (
    BOARD_SEQ.NEXTVAL
    , 'light'
    , 'abcd@naver.com'
    , '1234'
    , '빛이 되어줘'
    , '여느날처럼 ...'
);

INSERT INTO BOARD (
    NUM
    , USERID
    , EMAIL
    , PASS
    , TITLE
    , CONTENT
) VALUES (
    BOARD_SEQ.NEXTVAL
    , 'sang12'
    , 'abcd@naver.com'
    , '1234'
    , '2020년 겨울'
    , '날씨 춥다.'
);

SELECT * FROM member;
SELECT * FROM board;

UPDATE member
SET
    pwd = '1234'
WHERE userid = 'juno';

DELETE FROM BOARD
WHERE num = 10;

SELECT * FROM board;

INSERT INTO BOARD(NUM, USERID, EMAIL, PASS, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 'somi', 'abcd@gmail.com', '1234', '맛집 탐방 후기', '맛집이라고하기엔 ㄷㄷ');
INSERT INTO BOARD(NUM, USERID, EMAIL, PASS, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 'somi', 'abcd@gmail.com', '1234', '코로나19', '사회적 거리두기 2.5단계 - 모두 거리두기에 동참해주세요.');
INSERT INTO BOARD(NUM, USERID, EMAIL, PASS, TITLE, CONTENT) VALUES (BOARD_SEQ.NEXTVAL, 'somi', 'abcd@gmail.com', '1234', 'test', 'test');