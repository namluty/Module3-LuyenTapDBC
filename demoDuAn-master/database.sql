create database webbanhang;

use webbanhang;
create table khachhang(
    id int auto_increment primary key,
    ten varchar(255) not null ,
    diachi varchar(255) not null
);

create table sanpham(
    id int auto_increment primary key ,
    tensanpham varchar(255) not null ,
    dongia int not null ,
    soluong int not null
);

create table giohang(
    id int auto_increment primary key ,
    idkh int not null ,
    idsp int not null ,
    soluongmua int not null ,
    foreign key (idkh) references khachhang(id),
    foreign key (idsp) references sanpham(id)
);

create table hoadon(
    id int auto_increment primary key ,
    idkh int not null,
    foreign key (idkh) references khachhang(id)
);

select * from sanpham;
insert into sanpham(tensanpham,dongia,soluong) value (?,?,?);
update sanpham set soluong = soluong - ? where id = ?;

select sanpham.id, sanpham.tensanpham, sanpham.dongia, sanpham.soluong, giohang.soluongmua
from giohang join sanpham on sanpham.id = giohang.idsp where idkh = ?;