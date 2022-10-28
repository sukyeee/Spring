CREATE TABLE student (
  student_id int NOT NULL AUTO_INCREMENT,
  student_nm varchar(45) DEFAULT NULL,
  email varchar(45) DEFAULT NULL,
  phone varchar(45) DEFAULT NULL,
  PRIMARY KEY (student_id)
) ;

SELECT * FROM my_db.student;

insert into student (student_id, student_nm, email, phone )
		values ( 0, 'sk', 'sk@sk.com', '010-1234-5678'  );
        
select * from board.board order by board_id desc;
select * from board.users;

select * from board.board_file;