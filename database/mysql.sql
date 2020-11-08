/*
    mystore数据库
*/


create table user(
    id int primary key auto_increment,
    username varchar(9),
    password varchar(10),
    gender boolean,
    age int,
    money int
);
create table category(
    name varchar(20) primary key
);
insert into category values ('日用');
insert into category values ('食品');
insert into category values ('电器');
create table commodity(
    id int primary key auto_increment,
    name varchar(10),
    category varchar(10),
    price int,
    constraint fk_com_cate foreign key(category) references category(name)
);
insert into commodity(name, category, price) values('洗洁精','日用', 10);
insert into commodity(name, category, price)  values('大米','食品', 10);
insert into commodity(name, category, price)  values('电饭锅','电器', 10);

create table shop(
    id int primary key auto_increment,
    user_id int ,
    commodity_id int,
    constraint fk_sh_us foreign key (user_id) references user(id),
    constraint fk_sh_co foreign key (commodity_id) references commodity(id)
);

select * from shop
		group by commodity_id;

create table record(
    id int primary key auto_increment,
    user_id int ,
    commodity_id int,
    constraint fk_re_us foreign key (user_id) references user(id),
    constraint fk_re_co foreign key (commodity_id) references commodity(id)
);

create table admin(
    id int primary key auto_increment,
    username varchar(10),
    password varchar(18)
);
insert into admin(username, password) VALUES ('admin', '123456');