create database OrderManagement
go
use OrderManagement
go

create table "user" (
	 id int identity(1,1) primary key  not null,
	 fullname nvarchar(255) not null,
     username nvarchar(255) not null,
     "password" nvarchar(255) not null,
     phone nvarchar(255) not null,
     level_id int,
	 timework nvarchar(255) not null,
	 status bit,
     created_at date,
)
go

create table category(
	id int primary key identity(1,1) not null,
	parent_name nvarchar(255) not null,
	name nvarchar(255) not null
)
go

create table product (
	id nvarchar(255) primary key not null,
	name nvarchar(255) not null,
	cat_id int FOREIGN KEY REFERENCES category(id) not null,
	image nvarchar(255),
	price float not null,
	discount float,
	sale_price float
)
go

create table "order" (
	id int primary key not null,
	total_money float not null,
	cus_pay float not null,
	cus_receive float not null,
	cashier nvarchar(255) not null,
	created_at datetime default current_timestamp
)
go

create table order_details (
	order_id int foreign key references "order"(id) not null,
	pro_id nvarchar(255) not null,
	pro_name nvarchar(255) not null,
	quantity int not null,
	price float not null
)
go


create table banner (
	id int primary key identity(1,1) not null,
	name nvarchar(255) not null,
	image nvarchar(255) not null,
	created_at date
)

/* create proc for TABLE PRODUCT */
create proc product_select
as
begin
	select * from product
end
go



create proc product_selectById(@id nvarchar(255))
as
begin
	select * from product where id=@id
end
go



create proc product_selectByName(@name nvarchar(255))
as
begin
	select * from product where name like '%' + @name + '%'
end
go


create proc product_add(@id nvarchar(255),
						@name nvarchar(255),
						@cat_id int,
						@image nvarchar(255),
						@price float,
						@sale_price float
)	
as
begin
	insert into product(id, name, cat_id, image, price, sale_price) values(@id, @name, @cat_id, @image, @price, @sale_price)
end
go


create proc product_delete(@id nvarchar(255))
as
begin
	delete from product where id=@id
end
go


create proc product_update(@id nvarchar(255),
							@name nvarchar(255),
							@cat_id int,
							@image nvarchar(255),
							@price float,
							@sale_price float
)	
as
begin
	update product set name=@name, cat_id=@cat_id, image=@image, price=@price, sale_price=@sale_price where id=@id
end
go


create proc product_updateDiscount(@cat_id int,
									@discount int)
as
begin
	update product set discount = @discount where cat_id = @cat_id
end
go



create proc product_updateSalePrice(@cat_id int)
as
begin
	update product set sale_price = price - price*(discount/100) where cat_id = @cat_id
end
go



 create proc selectListFoods
 as
 begin
	select pro.id, pro.name, pro.cat_id, pro.image,  pro.price, pro.discount , pro.sale_price
	from category cat, product pro
	where cat.parent_name = 'Foods' and
		  cat.id = pro.cat_id
 end
 go


 create proc selectListDrinks
 as
 begin
	select pro.id, pro.name, pro.cat_id, pro.image,  pro.price, pro.discount ,pro.sale_price
	from category cat, product pro
	where cat.parent_name = 'Drinks' and
		  cat.id = pro.cat_id
 end
 go





/* create proc for TABLE CATEGORY */
create proc category_select
as
begin
	select * from category
end
go


create proc category_add(@parent_name nvarchar(255),
						@name nvarchar(255))
as
begin
	insert into category(parent_name, name) values (@parent_name, @name)
end
go


create proc category_delete(@id int)
as
begin
	delete from category where id=@id
end
go


create proc category_update(@id int,
							@parent_name nvarchar(255),
							@name nvarchar(255)
)	
as
begin
	update category set name=@name, parent_name=@parent_name where id=@id
end
go

create proc category_selectByName(@name nvarchar(255))
as
begin
	select * from category where name like '%' + @name + '%'
end
go

create proc category_viewListDrinks
as
begin
	select * from category where parent_name = 'Drinks'
end
go


create proc category_viewListFoods
as
begin
	select * from category where parent_name = 'Foods'
end
go




/* create proc for TABLE USER */

create proc user_select
as 
begin
	select * from "user"
end
go


create proc user_add(@username nvarchar(255),
					@fullname nvarchar(255),
					@password nvarchar(255),
					@phoneNumber nvarchar(255),
					@level_id int,	
					@timework nvarchar(255),	
					@status bit,			
					@created_at date)
as
begin
	insert into "user"(username, fullname, phone, level_id, password, timework, status, created_at) values (@username, @fullname, @phoneNumber, @level_id, @password, @timework, @status, @created_at)
end
go 



create proc user_update(@id int,
						@username nvarchar(255),
						@fullname nvarchar(255),
						@phoneNumber nvarchar(255),
						@level_id int,
						@timework nvarchar(255))
as
begin
	update "user" set username=@username, fullname=@fullname, phone=@phoneNumber, level_id=@level_id, timework=@timework where id=@id
end
go


create proc user_selectByUsername(@username nvarchar(255))
as
begin
	select * from "user" where username=@username
end
go


create proc user_selectByFullName(@fullname nvarchar(255))
as
begin
	select * from "user" where fullname like '%' + @fullname + '%'
end
go


/* create proc for TABLE ORDER */

create proc order_add(@id nvarchar(255),
						@total_money float,
						@cus_pay float,
						@cus_receive float,
						@cashier nvarchar(255),
						@created_at datetime
)
as	
begin
	insert into "order"(id, total_money, cus_pay, cus_receive, cashier, created_at) values (@id, @total_money, @cus_pay, @cus_receive, @cashier, @created_at)
end
go


create proc order_selectAll
as
begin
	select  * from "order" 
end
go


create proc order_selectById(@id nvarchar(255))
as
begin
	select * from "order" where id like '%' + @id + '%'
end
go



create proc order_deleteById(@orderID int)
as
begin
	delete from "order" where id=@orderID
end
go


create proc order_selectByCashier(@cashier nvarchar(255))
as
begin
	select * from "order" where cashier like '%' + @cashier + '%'
end
go



/* create proc for TABLE ORDER DETAILS */
create proc orderDetails_add(@order_id int,
							@pro_id nvarchar(255),
							@pro_name nvarchar(255),
							@quantity int,
							@price float
)
as	
begin
	insert into order_details(order_id, pro_id, pro_name, quantity, price) values(@order_id, @pro_id, @pro_name, @quantity, @price)
end
go


create proc orderDetails_delete(@orderID int)
as
begin
	delete from order_details where order_id=@orderID
end
go


create proc orderDetails_selectByID(@orderID int)
as
begin
	select * from order_details where order_id=@orderID
end
go


create proc orderDetails_selectAll
as
begin
	select * from order_details
end
go







