CREATE TABLE board_file (
  FILE_ID int NOT NULL AUTO_INCREMENT,
  BOARD_ID int NOT NULL,
  FILE_NAME varchar(500) NOT NULL,
  FILE_SIZE int NOT NULL,
  FILE_CONTENT_TYPE varchar(500) NOT NULL,
  FILE_URL varchar(500) NOT NULL,
  REG_DT datetime DEFAULT CURRENT_TIMESTAMP,
  PRIMARY KEY (FILE_ID),
  KEY BOARD_FILE_FK_idx (BOARD_ID),
  CONSTRAINT BOARD_FILE_FK FOREIGN KEY (BOARD_ID) REFERENCES board (BOARD_ID)
) ;

CREATE TABLE board_user_read (
  board_id int NOT NULL,
  user_seq int NOT NULL,
  KEY BOARD_USER_READ_FK_02_idx (user_seq),
  KEY BOARD_USER_READ_FK_01_idx (board_id),
  CONSTRAINT BOARD_USER_READ_FK_01 FOREIGN KEY (board_id) REFERENCES board (BOARD_ID),
  CONSTRAINT BOARD_USER_READ_FK_02 FOREIGN KEY (user_seq) REFERENCES users (USER_SEQ)
) ;

select * from users;
select * from board;

			select b.board_id, b.user_seq, u.user_name, u.user_profile_image_url, 
				   b.title, b.content, b.reg_dt, b.read_count
	              from BOARD b, USERS u 
	        	 where b.user_seq = u.user_seq 
	        	   and b.board_id = 1;
                   