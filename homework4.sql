DROP DATABASE IF EXISTS Homework4;
CREATE DATABASE IF NOT EXISTS Homework4;
CREATE TABLE IF NOT EXISTS Homework4.patron
(
first_name VARCHAR(25) NOT NULL,
last_name VARCHAR(25) NOT NULL,
email_address VARCHAR(40) NOT NULL,
CONSTRAINT patron_pk PRIMARY KEY (email_address)
);

CREATE TABLE IF NOT EXISTS Homework4.book
(
checkout_id INT(10) auto_increment NOT NULL,
book_title VARCHAR(40) NOT NULL,
due_date DATE NOT NULL,
overdue VARCHAR(10),
CONSTRAINT book_pk PRIMARY KEY (checkout_id)
);

CREATE TABLE IF NOT EXISTS Homework4.reference
(
email_address VARCHAR(40) NOT NULL,
checkout_id INT(10) auto_increment NOT NULL,
CONSTRAINT reference_fk_patron
	FOREIGN KEY (email_address)
    REFERENCES Homework4.patron (email_address),
CONSTRAINT reference_fk_book
	FOREIGN KEY (checkout_id)
    REFERENCES Homework4.book (checkout_id)
);

INSERT INTO Homework4.patron(first_name, last_name, email_address)
VALUES ('Dave','Powell','dpowell2@elon.edu');
INSERT INTO Homework4.patron(first_name, last_name, email_address)
VALUES ('Shannon','Duvall','sduvall2@elon.edu');
INSERT INTO Homework4.patron(first_name, last_name, email_address)
VALUES ('Joel','Hollingsworth','jhollingsworth@elon.edu');
INSERT INTO Homework4.patron(first_name, last_name, email_address)
VALUES ('Dom','Vernazza','dvernazza@elon.edu');
INSERT INTO Homework4.book(book_title, due_date, overdue)
Values ('Java Servlets and JSP','2016-11-15','');
INSERT INTO Homework4.book(book_title, due_date, overdue)
Values ('Game Programming','2015-10-12','');
INSERT INTO Homework4.book(book_title, due_date, overdue)
Values ('Operating Systems','2016-11-30','');
INSERT INTO Homework4.book(book_title, due_date, overdue)
Values ('Please Work','2016-10-15','');
INSERT INTO Homework4.reference(email_address)
Values ('dpowell2@elon.edu');
INSERT INTO Homework4.reference(email_address)
Values ('sduvall2@elon.edu');
INSERT INTO Homework4.reference(email_address)
Values ('jhollingsworth@elon.edu');
INSERT INTO Homework4.reference(email_address)
Values ('dvernazza@elon.edu');

SELECT
	concat(first_name, " ", last_name) AS 'Patron Name',
    Homework4.reference.email_address AS 'Email Address',
	book_title AS 'Book Title',
    due_date AS 'Due Date',
    CASE
    WHEN DATE(now()) > DATE(due_date)
		THEN 'Overdue'
	Else overdue
    END AS 'Overdue'
FROM Homework4.reference
JOIN Homework4.patron ON reference.email_address = patron.email_address
JOIN Homework4.book ON reference.checkout_id = book.checkout_id
;
    







