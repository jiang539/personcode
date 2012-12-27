create table me_temp_tesp_big_data(
       id    number,
       name  varchar2(20),
       c1    varchar2(50),
       c2    varchar2(50),
       c3    varchar2(50),
       c4    varchar2(50),
       c5    varchar2(50),
       c6    varchar2(50),
       c7    varchar2(50),
       c8    varchar2(50),
       c9    varchar2(50),
       c0    varchar2(50)
);

create table account (
    userid varchar2(80) not null,
    email varchar2(80) not null,
    firstname varchar2(80) not null,
    lastname varchar2(80) not null,
    status varchar2(2)  null,
    addr1 varchar2(80) not null,
    addr2 varchar2(40) null,
    city varchar2(80) not  null,
    state varchar2(80) not null,
    zip varchar2(20) not null,
    country varchar2(20) not null,
    phone varchar2(80) not null
);