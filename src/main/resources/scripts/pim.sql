alter table ocorrencia drop foreign key FK8vyx5i6two7max2jhlodwew57
alter table ocorrencia drop foreign key FK9so2e1nw8vikagax8yhtqxtnp
drop table if exists ocorrencia
drop table if exists usuario
drop table if exists veiculo
create table ocorrencia (id bigint not null auto_increment, descricao varchar(255), fim datetime(6), inicio datetime(6) not null, titulo varchar(255) not null, usuario_id bigint, veiculo_id bigint, primary key (id)) engine=InnoDB
create table usuario (id bigint not null auto_increment, cep varchar(255), complemento varchar(255), cpf varchar(255) not null, email varchar(255) not null, logradouro varchar(255), nome varchar(255) not null, senha varchar(255) not null, telefone varchar(255), tipo varchar(255) not null, primary key (id)) engine=InnoDB
create table veiculo (id bigint not null auto_increment, ano integer not null, inativo bit not null, marca varchar(255) not null, modelo varchar(255) not null, placa varchar(255) not null, tipo varchar(255) not null, primary key (id)) engine=InnoDB
alter table usuario add constraint UK_692bsnqxa8m9fmx7m1yc6hsui unique (cpf)
alter table usuario add constraint UK_5171l57faosmj8myawaucatdw unique (email)
alter table veiculo add constraint UK_luoyk9d8idgi0wif7bxtefsr5 unique (placa)
alter table ocorrencia add constraint FK8vyx5i6two7max2jhlodwew57 foreign key (usuario_id) references usuario (id)
alter table ocorrencia add constraint FK9so2e1nw8vikagax8yhtqxtnp foreign key (veiculo_id) references veiculo (id)
