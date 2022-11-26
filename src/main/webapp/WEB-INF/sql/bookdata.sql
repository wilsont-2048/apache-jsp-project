drop table if exists books;

create table books (
    bookid integer auto_increment primary key,
    bookname varchar(255),
    bookgenre varchar(255),
    bookvotes int
);

insert into books (bookname, bookgenre, bookvotes) values ('A Game of Thrones', 'Fantasy', 10);
insert into books (bookname, bookgenre, bookvotes) values ('Flash Boys', 'Nonfiction', 8);
insert into books (bookname, bookgenre, bookvotes) values ('Mistborn: The Final Empire', 'Fantasy', 5);