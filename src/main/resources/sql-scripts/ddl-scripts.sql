CREATE TABLE CUSTOMER(
    ID_CUSTOMER NUMERIC(6) NOT NULL PRIMARY KEY,
    NAME VARCHAR(64) NOT NULL,
    FIRST_NAME VARCHAR(64) NOT NULL,
    SECOND_NAME VARCHAR(64) NOT NULL,
    BUSINESS_NAME VARCHAR(64) NOT NULL,
    PHONE VARCHAR(32) NOT NULL,
    ADDRESS VARCHAR(128) NOT NULL,
    RFC VARCHAR(32) NOT NULL,
    STATUS CHAR(1) DEFAULT '1' NOT NULL
);

CREATE SEQUENCE SEQ_CUSTOMER;

INSERT INTO CUSTOMER(ID_CUSTOMER, NAME, FIRST_NAME, SECOND_NAME, BUSINESS_NAME, PHONE, ADDRESS, RFC, STATUS)
VALUES (SEQ_CUSTOMER.NEXTVAL, 'Limhi', 'Navarro', 'Aviles', 'Limhi SA de CV', '5534848438', 'Dolores Guerrero 210 A CTM Culhuacan Seccion 8 CDMX','NAAL951222TT9', 1);

-- COMMIT;

SELECT * FROM CUSTOMER;

-- |||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||||

CREATE TABLE ARTICLE(
    ID_ARTICLE NUMERIC(6) NOT NULL PRIMARY KEY,
    TRADEMARK VARCHAR(32) NOT NULL,
    DESCRIPTION VARCHAR(128) NOT NULL,
    PRICE NUMERIC(6,2) NOT NULL,
    STOCK NUMERIC(6,2) NOT NULL,
    STATUS CHAR(1) DEFAULT '1' NOT NULL
);

CREATE SEQUENCE SEQ_ARTICLE;

INSERT INTO ARTICLE(ID_ARTICLE, TRADEMARK, DESCRIPTION, PRICE, STOCK) VALUES(SEQ_ARTICLE.NEXTVAL, 'Logitech', 'Teclado mecanico', 2000.99, 20);
INSERT INTO ARTICLE(ID_ARTICLE, TRADEMARK, DESCRIPTION, PRICE, STOCK) VALUES(SEQ_ARTICLE.NEXTVAL, 'Logitech', 'Mouse gamer', 700.99, 20);
INSERT INTO ARTICLE(ID_ARTICLE, TRADEMARK, DESCRIPTION, PRICE, STOCK) VALUES(SEQ_ARTICLE.NEXTVAL, 'Logitech', 'Bocinas G560', 2500.99, 20);
INSERT INTO ARTICLE(ID_ARTICLE, TRADEMARK, DESCRIPTION, PRICE, STOCK) VALUES(SEQ_ARTICLE.NEXTVAL, 'Logitech', 'Teclado', 200.99, 20);
INSERT INTO ARTICLE(ID_ARTICLE, TRADEMARK, DESCRIPTION, PRICE, STOCK) VALUES(SEQ_ARTICLE.NEXTVAL, 'Logitech', 'Mouse', 200.99, 20);
INSERT INTO ARTICLE(ID_ARTICLE, TRADEMARK, DESCRIPTION, PRICE, STOCK) VALUES(SEQ_ARTICLE.NEXTVAL, 'BenQ', 'Monitor 24', 7500.99, 20);
INSERT INTO ARTICLE(ID_ARTICLE, TRADEMARK, DESCRIPTION, PRICE, STOCK) VALUES(SEQ_ARTICLE.NEXTVAL, 'BenQ', 'Monitor 26 HDRi', 9500.99, 20);

-- COMMIT;

SELECT * FROM ARTICLE;
