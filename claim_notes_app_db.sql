--indexes needed

drop table claim_notes;
drop table claims;
drop table reps;

create table reps(
rep_id decimal(12) primary key not null,
first_name varchar (64) not null,
last_name varchar (64) not null
);

create table claims(
claim_id decimal(12) primary key not null,
rep_id decimal(12)not null,
foreign key (rep_id) references reps (rep_id)
);

create table note_categories(
category_id decimal (12) primary key,
category_name varchar(64) not null
);

create table claim_notes(
note_id decimal(12) primary key not null,
rep_id decimal(12) not null,
claim_id decimal(12) not null,
category_id decimal(12) not null,
created_at varchar(64) not null,
content varchar(1064) not null,
is_editable boolean not null,
foreign key (rep_id) references reps (rep_id),
foreign key (claim_id) references claims (claim_id),
foreign key (category_id) references note_categories (category_id)
);

insert into note_categories (category_id, category_name) values (1, 'Contact Information');
insert into note_categories (category_id, category_name) values (2, 'Coverage');
insert into note_categories (category_id, category_name) values (3,'Damages');
insert into note_categories (category_id, category_name) values (4,'File Intervention');
insert into note_categories (category_id, category_name) values (5,'File Review');
insert into note_categories (category_id, category_name) values (6,'Injury Evaluation');
insert into note_categories (category_id, category_name) values (7, 'Liability');
insert into note_categories (category_id, category_name) values (8,'PIP');
insert into note_categories (category_id, category_name) values (9,'To Do');

