-- tx 交易資料表
-- book (書籍資料), stock (庫存資料), wallet (客戶雲端錢包)
-- 建立 book (書籍資料) 表
create table if not exists book(
	bid integer not null auto_increment,
	bname varchar(20) not null,
	price integer default 0,
	ct timestamp default current_timestamp,
	primary key (bid)
); 

-- 建立 stock (庫存資料) 表
create table if not exists stock(
	sid integer not null auto_increment,
	bid integer not null, -- book 的 bid
	amount integer default 0,
	primary key (sid),
	foreign key(bid) references book(bid) -- 外鍵關聯
);

-- 建立 wallet (客戶雲端錢包) 表
create table if not exists wallet(
	wid integer not null auto_increment,
	wname varchar(20) not null,
	money integer default 0,
	primary key (wid)
);