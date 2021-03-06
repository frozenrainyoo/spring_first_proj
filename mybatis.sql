create table board (
	mId int primary key auto_increment,
	mWriter char(100),
	mContent char(255)
);

drop table board;


select * from board order by mId desc;

select * from board;




http://www.mkyong.com/spring-security/spring-security-form-login-using-database/

drop table user_roles;
drop table users;

CREATE  TABLE users (
  username VARCHAR(45) NOT NULL ,
  password VARCHAR(60) NOT NULL ,
  enabled TINYINT NOT NULL DEFAULT 1 ,
  PRIMARY KEY (username));
  
CREATE TABLE user_roles (
  user_role_id int(11) NOT NULL AUTO_INCREMENT,
  username varchar(45) NOT NULL,
  role varchar(45) NOT NULL,
  PRIMARY KEY (user_role_id),
  UNIQUE KEY uni_username_role (role,username),
  KEY fk_username_idx (username),
  CONSTRAINT fk_username FOREIGN KEY (username) REFERENCES users (username));

  
INSERT INTO users(username,password,enabled)
VALUES ('mkyong','123456', true);
INSERT INTO users(username,password,enabled)
VALUES ('alex','123456', true);
INSERT INTO users(username,password,enabled)
VALUES ('dwyoo','123456', true);

INSERT INTO user_roles (username, role)
VALUES ('mkyong', 'ROLE_USER');
INSERT INTO user_roles (username, role)
VALUES ('mkyong', 'ROLE_ADMIN');
INSERT INTO user_roles (username, role)
VALUES ('alex', 'ROLE_USER');
INSERT INTO user_roles (username, role)
VALUES ('dwyoo', 'ROLE_USER');
INSERT INTO user_roles (username, role)
VALUES ('dwyoo', 'ROLE_ADMIN');

select * from users;


