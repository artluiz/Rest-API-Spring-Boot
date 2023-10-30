CREATE TABLE produto (
id bigint not null auto_increment,
nome varchar(50) not null,
plataforma varchar(20) not null,
quantidade int (20) not null,
genero varchar(50) not null, 
lançamento varchar (15) not null,
empresa varchar(50) not null,

primary key (id)
);