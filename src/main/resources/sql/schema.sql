DROP TABLE IF EXISTS book;
DROP TABLE IF EXISTS user;
DROP TABLE IF EXISTS borrow_history;

CREATE TABLE book
(
    id bigint NOT NULL AUTO_INCREMENT,
    isbn char(11) NOT NULL,
    title varchar(200) NOT NULL,
    authors varchar(100) NOT NULL,
    publisher varchar(100) NOT NULL,
    translators varchar(100),
    price int,
    info varchar(500),
    publication_date dateTime,
    created_date dateTime NOT NULL,
    modified_date dateTime,
    status varchar(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE user
(
    id bigint NOT NULL AUTO_INCREMENT,
    name varchar(30) NOT NULL,
    login_id varchar(50) NOT NULL,
    password varchar(60) NOT NULL,
    phone_number character(11) NOT NULL,
    created_date dateTime NOT NULL,
    modified_date dateTime,
    status varchar(100) NOT NULL,
    PRIMARY KEY (id)
);

CREATE TABLE borrow_history
(
    id bigint NOT NULL AUTO_INCREMENT,
    book_id bigint NOT NULL,
    user_id bigint NOT NULL,
    borrow_date dateTime NOT NULL,
    due_date dateTime NOT NULL,
    return_date dateTime,
    created_date dateTime NOT NULL,
    modified_date dateTime,
    status varchar(100) NOT NULL,
    PRIMARY KEY (id)
);



