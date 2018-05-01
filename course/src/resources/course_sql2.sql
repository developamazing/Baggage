select * from C##.loan;

select * from courses;

insert into  SYS.COURSES values( 1 ,1, 'java', 1, 'month' );

insert into SYS.MODULES values ( 1 , 1, 'module-1', 'Ass-1', 'month');


insert into MODULES2 values ( 1 , 1, 'module-1', 'Ass-1', 'month');

select * from MODULES2;

CREATE TABLE MODULES2(
MODULEID INT NOT NULL,
COURSEID2 INT NOT NULL,
MODULENAME VARCHAR2(20),
MODULEASSIGNMENT VARCHAR2(20),
MODULEDURATION VARCHAR2(20),
PRIMARY KEY (MODULEID),
FOREIGN KEY (COURSEID2) REFERENCES COURSES(COURSEID)
)

drop  table MODULES2;

create table COURSE (
COURSEID INT NOT NULL,
TECHID INT NOT NULL,
COURSENAME VARCHAR2(30),
COURSEBATCHES INT,
COURSEDURATION VARCHAR2(20)
)

insert into course values( 1,1, 'java', 1, 'month');
insert into course values( 1,2, 'front-end', 1, 'month');
insert into course values( 1,3, 'db', 1, 'month');
insert into course values( 1,4, 'cloud', 1, 'month');

select * from course;