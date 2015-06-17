create database projeto_8BPM;

use projeto_8BPM;

create table policiais(
id int primary key auto_increment,
nome varchar(75) not null,
matricula varchar(10) unique not null
);

create table dependentes(
id_dependentes int primary key auto_increment,
conjuge varchar(75),
filhos varchar(800),
filiacao varchar(200) not null,
codigo int,

foreign key (codigo) references policiais (id)

);

select * from policiais;
select * from dependentes;