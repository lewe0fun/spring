CREATE TABLE Person(person_id int primary key generated by default as identity,person_name varchar(100),person_age int);


select person.person_id,person_name,age,item_id from Person
join Item on item.person_id=person.person_id
join Passport on passport.person_id=person.person_id;



select person.person_id,person_name,age,item_id from Person join Passport on passport.person_id=person.person_id;



insert into Person (person_id, person_name, age) values (1,'test person',37);

select * from Person;


CREATE TABLE Person(
person_id int primary key generated by default as identity,
person_name varchar(100) not null,
age int check (age<100)
);

CREATE TABLE Item(
item_id int primary key generated by default as identity,
person_id int REFERENCES Person(person_id) on delete set null,
item_name varchar(100) not null
);

INSERT INTO Person (person_name, person_age)
VALUES
('Tom B. Erichsen', 21),
('Per Olsen', 15),
('Finn Egan',19);

INSERT INTO Item (person_id, item_name)
VALUES
(1,'xbox360'),
(1,'ps3'),
(2,'mimax2'),
(3,'samsung C100'),
(3,'nokia 3230'),
(3,'todhiba g900');

CREATE TABLE Passport(
person_id int PRIMARY KEY REFERENCES Person(person_id) ON DELETE CASCADE,
passport_number int NOT NULL
);
