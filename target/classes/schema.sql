create table User (
	id varchar(20) unique not null,
	name varchar(60) unique not null,
	pwd varchar(20) not null
);

create table Book (
	id int not null primary key auto_increment,
	title varchar(255) not null,
	description text not null,
	isbn varchar(20)
);

create table Reservation (
	id int not null primary key auto_increment,
	uid varchar(20),
	bid int,
	rsvd_from datetime not null,
	rsvd_to datetime not null,
	foreign key(uid) references User(id),
	foreign key(bid) references Book(id)
);
