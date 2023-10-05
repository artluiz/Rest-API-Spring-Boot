CREATE TABLE usuario(
id bigint not null auto_increment,
login varchar(50) not null,
senha varchar(100) not null,

primary key (id)
);