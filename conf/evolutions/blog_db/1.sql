CREATE TABLE IF NOT EXISTS article (
  id bigint not null auto_increment,
  title varchar(63) not null,
  content varchar(4095) not null,
  thumbnail_url varchar(255) not null,
  date char(10) not null,
  tags varchar(127) not null,
  create_time timestamp not null default current_timestamp,
  update_time timestamp not null default current_timestamp on update current_timestamp,
  primary key(id)
) ENGINE=InnoDB default charset=UTF8;