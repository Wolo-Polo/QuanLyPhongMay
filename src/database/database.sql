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
    ngaycong int default 0,
	ghichu nvarchar(255)
);

create table lichtruc(
    magiaovien nchar(20) not null,
    ngaytruc date, 
    ghichu nvarchar(255),
    
    constraint primary key (magiaovien, ngaytruc),
    constraint fk_lichtruc_giaovien foreign key (magiaovien) references giaovien(magiaovien)
);

create table monhoc(
	mamonhoc nchar(20) not null primary key,
    tenmonhoc nvarchar(50),
    tenphanmem nchar(20),
    yeucaucauhinh nvarchar(20),
    ghichu nvarchar(255)
);

create table lichsudung(
	maphongmay nchar(20) not null,
	magiaovien nchar(20) not null,
    mamonhoc nchar(20) not null,
    batdau datetime,
    ketthuc datetime,
    ghichu nvarchar(255),
    
    constraint primary key(maphongmay, magiaovien, mamonhoc, batdau, ketthuc),
    constraint fk_lichsudung_phongmay foreign key(maphongmay) references phongmay(maphongmay),
    constraint fk_lichsudung_giaovien foreign key(magiaovien) references giaovien(magiaovien),
    constraint fk_lichsudung_monhoc foreign key(mamonhoc) references monhoc(mamonhoc)
);

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
    
insert into lichtruc values('GV03', '2020-06-04', N'Buổi trực đầu tiên');

insert into monhoc values ('MH01', 'Java', 'NetBeans', N'Trung bình', ''),
	('MH02', N'Đồ họa ứng dụng', 'Photoshop', 'Cao', '');
    
insert lichsudung values ('PM8', 'GV01', 'MH01', '2020-06-02 07:00:00', '2020-06-02 11:00:00', 'Buổi sử dụng phòng máy đầu tiên');
insert lichsudung values ('PM7', 'GV02', 'MH02', '2020-06-02 13:00:00', '2020-06-02 16:00:00', 'Buổi sử dụng phòng máy đầu tiên');

CREATE TRIGGER `trigger_delete_phongmay_update_may` BEFORE DELETE ON `phongmay`
 FOR EACH ROW UPDATE may set maphongmay='PM0' WHERE maphongmay=OLD.maphongmay
CREATE TRIGGER `trigger_delete_phongmay_delete_lichsudung` BEFORE DELETE ON `phongmay`
 FOR EACH ROW DELETE from lichsudung WHERE maphongmay=OLD.maphongmay