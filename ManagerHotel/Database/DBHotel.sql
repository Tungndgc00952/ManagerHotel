USE master
GO
IF EXISTS(SELECT * FROM sys.databases WHERE name='ManagerHotel')
	DROP DATABASE ManagerHotel
GO
CREATE DATABASE ManagerHotel
GO
USE ManagerHotel
GO
DROP TABLE Accounts
GO
CREATE TABLE Accounts
(
	A_NameUser nvarchar(50) primary key ,
	A_PassWord nvarchar(50),
	id_Staff nvarchar(50),
	office nvarchar(50)
)
GO
CREATE TABLE Staff
(
	id nvarchar(50) primary key,
	name nvarchar(50) ,
	sex nvarchar(50),
	phoneNumber int,
	mail nvarchar(50) ,
	office nvarchar(50),
	
)
GO
CREATE TABLE Client
(
	name nvarchar(50),
	Age int,
	gender nvarchar(50),
	Address nvarchar(50),
	Phone nvarchar(50),
	DateIn nvarchar(50),
	DateOut nvarchar(50),
	CMND int primary key	
)
GO
-- nhap vao gia tri client 
INSERT INTO Client(CMND,name,Age,gender,Address,phone,DateIn) VALUES(123456789,'thuy1',28,'Male','fsdgdsfsdfsd',098899797,'20015/12/20');
INSERT INTO Client(CMND,name,Age,gender,Address,phone,DateIn) VALUES(223456788,'thuy2',28,'Male','fsdgdsfsdfsd',098899787,'20015/12/24');
CREATE TABLE Room
(
	NoRoom nvarchar(50) primary key,
	kindRoom nvarchar(50),
	price float,
	priceCurrent float,
	R_status nvarchar(50),	
)
GO

/* them mot cot vao bang Room
ALTER TABLE Room
	ADD priceCurrent float
	
ALTER TABLE Room
	ADD priceCurrent nvarchar(50)
	
*/	

-- nhap vao gia tri phong 
INSERT INTO Room(NoRoom,price) VALUES('103',1000);
INSERT INTO Room(NoRoom,price) VALUES('104',1000);
INSERT INTO Room(NoRoom,price) VALUES('105',1000);
CREATE TABLE Services
(
	name nvarchar(50) primary key,
	price float,
	priceCurrent float,	
)
GO

-- nhap gia tri bang services
INSERT INTO Services(name,price) VALUES('Massage',1500);
INSERT INTO Services(name,price) VALUES('Coffe',1500);
INSERT INTO Services(name,price) VALUES('Giat Do',1500);
-- bang order
DROP TABLE Orders
GO
CREATE TABLE Orders
(
  id int identity(1,1) primary key ,
  CMNDClient int Constraint FK_O_Client Foreign key References Client(CMND),
  nameAccount nvarchar(50) Constraint FK_O_Account Foreign key References Accounts(A_NameUser),
  dateIn nvarchar(50),
  dateOut nvarchar(50),
  numberRoom nvarchar(50) Foreign key References Room(noRoom),
  priceRoom float,
  priceSevice float,
  totalPrice float,
  ocheck nvarchar(15)
)
GO
/* them mot cot vao bang order
ALTER TABLE Orders
	ADD ocheck nvarchar(15)
*/
-- nhap vao gia tri bang order
INSERT INTO Orders(CMNDClient,nameAccount,dateIn,dateOut) VALUES(123456789,'admin','2013-06-21','2013-06-23');
INSERT INTO Orders(CMNDClient,nameAccount,dateIn,dateOut) VALUES (123456789,'admin','2013-06-21','2013-06-23');
INSERT INTO Orders(CMNDClient,nameAccount,dateIn,dateOut) VALUES (123456789,'admin','2013-06-21','2013-06-23');
Select * from Orders;
Select * from Orders where CMNDClient like 'thuy1';
go
DROP TABLE OrderServices
GO
CREATE TABLE OrderServices
(
	id int identity(000001,1) primary key,
	nameService nvarchar(50) Foreign key References Services(name),
	idOrder int Constraint FK_OS_O Foreign key References Orders(id),	
	quantity int,
	price float,	
)
GO
Select * from OrderServices where idOrder like 1;
Select * from OrderServices
-- nhap vao gia tri bang orderservice
Insert into OrderServices(nameService,idOrder,price,quantity) values('Massage',1,12000,5);
Insert into OrderServices(nameService,idOrder,price,quantity) values('Coffe',1,12000,4);
Insert into OrderServices(nameService,idOrder,price,quantity) values('Massage',2,12000,3);
-- nhap vao gia tri bang staff 
INSERT INTO Staff VALUES('A01','thuy','Femal',01696167935,'thuynx@fpt.edu.vn','Manager');
Select * from Staff
-- nhap vao gia tri cho bang account
INSERT INTO Accounts(A_NameUser,A_PassWord) VALUES('Admin','123456');
-- hien thi gia tri 2 cot cua bang
Select * from Accounts where A_NameUser='admin' and A_PassWord='123456';
