# --- Created by Ebean DDL
# To stop Ebean DDL generation, remove this comment and start using Evolutions

# --- !Ups

create table curso (
  idcurso                   varchar(255) not null,
  nomecurso                 varchar(255),
  constraint pk_curso primary key (idcurso))
;

create table questao (
  idquestao                 varchar(255) not null,
  tituloquestao             varchar(255),
  enunciadoquestao          varchar(255),
  respostaquestao           varchar(255),
  constraint pk_questao primary key (idquestao))
;




# --- !Downs

SET FOREIGN_KEY_CHECKS=0;

drop table curso;

drop table questao;

SET FOREIGN_KEY_CHECKS=1;

