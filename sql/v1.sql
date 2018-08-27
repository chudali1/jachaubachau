create table symptoms(
	s_id int primary key auto_increment ,
	s_name varchar(100) not null);
	

--------------------------------------------------------------------------------------------------------------------

create table desease(
	d_id int primary key auto_increment,
	d_name varchar(100) not null);
	
	d
----------------------------------------------------------------------------------------------------------------------
create table symptoms_deseases(
	id int primary key auto_increment, 
	sid int ,
	did int );
------------------------------------------------------------------------------------------------------------------------

alter table symptoms_deseases add foreign key (sid) references symptoms(s_id);
alter table symptoms_deseases add foreign key (did) references desease(d_id);
