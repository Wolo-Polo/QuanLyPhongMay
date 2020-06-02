/* 
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
/**
 * Author:  Truong
 * Created: Jun 1, 2020
 */

create database QuanLyPhongMay;
use QuanLyPhongMay;


create table phanmem(
	maphanmem nchar(20) not null primary key,
    tenphanmem nvarchar(50) not null,
    cauhinh nvarchar(20),
    ghichu nvarchar(255)
);

create table monhoc(
	mamonhoc nchar(20) not null primary key,
    tenmonhoc nvarchar(50),
    maphanmem nchar(20) not null,
    ghichu nvarchar(255),
	
    constraint fk_monhoc_phanmem foreign key (maphanmem) references phanmem(maphanmem)
);


create table phongmay(
	maphongmay nchar(20) not null primary key,
    vitri nvarchar(50),
    tinhtrang nvarchar(20),
    ghichu nvarchar(255)
);

create table may(
	mamay nchar(20) not null primary key,
	cauhinh nvarchar(20),
    tinhtrang nvarchar(20),
	maphongmay nchar(20) not null,
    ghichu nvarchar(255),

	constraint fk_may_phongmay foreign key (maphongmay) references phongmay(maphongmay) 
);

create table giaovien(
	magiaovien nchar(20) not null primary key,
    tengiaovien nvarchar(50),
    hocvi nvarchar(20),
    ngaycong int,
	ghichu nvarchar(255)
);

create table lichtruc(
	maphongmay nchar(20) not null,
    magiaovien nchar(20) not null,
    ngaytruc date, 
    ghichu nvarchar(255),
    
    constraint pk_lichtruc primary key (maphongmay, magiaovien, ngaytruc),
    constraint fk_lichtruc_phongmay foreign key (maphongmay) references phongmay(maphongmay),
    constraint fk_lichtruc_giaovien foreign key (magiaovien) references giaovien(magiaovien)
);

insert into phanmem values ('PM01', 'Photoshop', 'Cao', ''),
	('PM02', 'NetBeans', 'Trung binh', '');

insert into monhoc values ('MH01', 'Java', 'PM02', ''),
	('MH02', N'Đồ họa ứng dụng', 'PM01', '');
    
insert into phongmay values ('PM8', N'tầng 9 nhà A1', N'Không sử dụng', ''),
	('PM7', N'tầng 8 nhà A1', N'Không sử dụng', '');

insert into may values ('M01PM8', 'Cao', 'Tot', 'PM8', ''),
	('M02PM8', 'Cao', 'Tot', 'PM8', ''),
    ('M03PM8', 'Cao', 'Tot', 'PM8', ''),
    ('M04PM8', 'Cao', 'Tot', 'PM8', ''),
    ('M01PM7', 'Cao', 'Tot', 'PM7', ''),
    ('M02PM7', 'Cao', 'Tot', 'PM7', '');
    
insert into giaovien values('GV01', N'Nguyễn Văn An', N'Thạc sĩ', 0, ''),
	('GV02', N'Nguyễn Thị Bình', N'Tiến sĩ', 0, ''),
    ('GV03', N'Trần Văn Trung', N'Thạc sĩ', 1, N'Buổi trực đầu');
    
insert into lichtruc values('PM7', 'GV03', '2020-06-04', '');