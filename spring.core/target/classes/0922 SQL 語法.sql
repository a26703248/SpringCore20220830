create database web;
use web;
create table if not exists emp (
	eid int not null auto_increment, -- 序號(主鍵自動給號)
    ename nvarchar(30) not null unique, -- 姓名
    age int, -- 年齡
    createtime timestamp default current_timestamp, -- 建檔時間
    primary key(eid) -- 主鍵設定
);

create table if not exists job (
	jid int not null auto_increment, -- 序號(主鍵自動給號)
    jname nvarchar(30) not null, -- 工作名稱
    eid int, -- 員工(uid)
    foreign key(eid) references emp(eid), -- 外鍵約束
    primary key(jid) -- 主鍵設定
);

-- 建立初始數據
insert into emp(ename, age) values ('A01', 21);
insert into emp(ename, age) values ('A02', 22);
insert into emp(ename, age) values ('A03', 23);
insert into emp(ename, age) values ('A04', 24);
insert into emp(ename, age) values ('A05', 25);
insert into emp(ename, age) values ('A06', 26);
insert into emp(ename, age) values ('A07', 27);
insert into emp(ename, age) values ('A08', 28);
insert into emp(ename, age) values ('A09', 29);
insert into emp(ename, age) values ('A10', 30);
insert into emp(ename, age) values ('A11', 31);
insert into emp(ename, age) values ('A12', 32);
insert into emp(ename, age) values ('A13', 33);
insert into job(jname, eid) values ('report', 1);
insert into job(jname, eid) values ('coding', 3);
insert into job(jname, eid) values ('jobA', 3);
insert into job(jname, eid) values ('jobB', 4);
insert into job(jname, eid) values ('jobC', 7);
insert into job(jname, eid) values ('jobD', 12);
insert into job(jname, eid) values ('jobE', 13);
insert into job(jname, eid) values ('jobF', 1);
insert into job(jname, eid) values ('jobG', 1);
insert into job(jname, eid) values ('jobH', 3);
insert into job(jname, eid) values ('jobI', 12);
insert into job(jname, eid) values ('jobJ', 7);
insert into job(jname, eid) values ('jobK', 4);
insert into job(jname, eid) values ('jobL', 3);
insert into job(jname) values ('jobM');

select * from emp;
select * from job;