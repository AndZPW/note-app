create database if not exists note_service;

use note_service;

create table notes(
                      notes_id int not null primary key ,
                      user_id int not null,
                      title varchar(255),
                      content varchar(2100) not null

);