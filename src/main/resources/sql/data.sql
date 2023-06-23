INSERT INTO book
    (isbn, title, authors, publisher, translators, price, publication_date, info, thumbnail, status)
VALUES
    ('01234567890', '제목1', '저자1, 저자2', '출판사1', '번역가1', 11111,  DATE_SUB(NOW(), INTERVAL 1 YEAR), '책소개', '책표지', 'available');
INSERT INTO book
    (isbn, title, authors, publisher, translators, price, publication_date, info, thumbnail, status)
VALUES
    ('01234567890', '제목2', '저자1, 저자2', '출판사1', '번역가1', 22222, DATE_SUB(NOW(), INTERVAL 1 DAY), '책소개', '책표지', 'available');
INSERT INTO book
    (isbn, title, authors, publisher, translators, price, publication_date, info, thumbnail, status)
VALUES
    ('01234567890', '제목3', '저자1, 저자2', '출판사1', '번역가1', 33333, DATE_SUB(NOW(), INTERVAL 1 MONTH), '책소개', '책표지', 'available');

INSERT INTO user
    (name, login_id, password, phone_number, auth, status)
VALUES
    ('name', 'admin', 'admin', '01234567890', 'admin', 'available');
INSERT INTO user
    (name, login_id, password, phone_number, status)
VALUES
    ('name', 'id1111', 'pw1111', '01234567890', 'available');
INSERT INTO user
    (name, login_id, password, phone_number, status)
VALUES
    ('name', 'id2222', 'pw2222', '01234567890', 'available');
INSERT INTO user
(name, login_id, password, phone_number, status)
VALUES
    ('name', 'id3333', 'pw3333', '01234567890', 'available');

INSERT INTO borrow_histoy
(book_id, user_id, due_date, status)
VALUES
    (1, 3, DATE_ADD(NOW(), INTERVAL 5 DAY), 'on_borrow');
INSERT INTO borrow_histoy
(book_id, user_id, due_date, status)
VALUES
    (2, 2, DATE_ADD(NOW(), INTERVAL 5 DAY), 'on_borrow');
INSERT INTO borrow_histoy
(book_id, user_id, due_date, status)
VALUES
    (3, 2, DATE_ADD(NOW(), INTERVAL 5 DAY), 'on_borrow');
INSERT INTO borrow_histoy
(book_id, user_id, due_date, status)
VALUES
    (1, 1, DATE_ADD(NOW(), INTERVAL 5 DAY), 'on_borrow');
INSERT INTO borrow_histoy
(book_id, user_id, due_date, status)
VALUES
    (3, 1, DATE_ADD(NOW(), INTERVAL 5 DAY), 'on_borrow');

