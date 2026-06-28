CREATE DATABASE DB;
USE DB;

CREATE TABLE PERSON (
    SocNum      int primary key,
    FirstName   varchar(40),
    LastName    varchar(40),
    PostCode    varchar(10),
    Place       varchar(50),
    Street      varchar(50),
    HouseNumber int
);

CREATE TABLE PHONE_NUMBER (
    PhoneNumber int primary key
);

CREATE TABLE PHONE_NUMBER_BELONGS_TO_PERSON (
    PhoneNumber int not null,
    SocNum      int not null,
    primary key (PhoneNumber, SocNum),
    foreign key (PhoneNumber) references PHONE_NUMBER(PhoneNumber),
    foreign key (SocNum) references PERSON(SocNum)
);

CREATE TABLE EMPLOYEE (
    SocNum int primary key,
    EmpNum int not null unique,
    foreign key (SocNum) references PERSON(SocNum)
);

CREATE TABLE BANK_ACCOUNT (
    BankNum    int not null,
    AccountNum int not null,
    Balance    int check ( Balance >= 0 ),
    primary key (BankNum, AccountNum)
);

CREATE TABLE BANK_ACCOUNT_BELONGS_TO_EMPLOYEE (
    BankNum    int not null,
    AccountNum int not null,
    SocNum     int not null,
    primary key (BankNum, AccountNum, SocNum),
    foreign key (BankNum, AccountNum) references BANK_ACCOUNT(BankNum, AccountNum),
    foreign key (SocNum) references EMPLOYEE(SocNum)
);