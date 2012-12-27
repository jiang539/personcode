-- % mysql -u root -p
-- password: *****
-- mysql> CREATE DATABASE IF NOT EXISTS term default charset utf8 COLLATE utf8_general_ci; 
-- create database if not exists term default charset utf8 collate utf8_general_ci;

-- 用户表
create table user( 
	id				varchar(48) not null primary key,
	name			varchar(50) not null , 
	password		varchar(40) not null,
	sex				varchar(2),
	email			varchar(50),
	phone			varchar(15),
	address			varchar(254) comment '住址',
	active			integer default 1,
	state			integer default 1
) comment = '用户信息表';
alter table user add constraint unq_user_name unique(name);

-- 角色表
create table role(
	id				varchar(48) not null primary key,
	name			varchar(50) not null,
	parentId		varchar(48),
	type			varchar(30),
	memo			varchar(100)
) comment = '角色信息表';
alter table role add constraint unq_role_name unique(name);
alter table role add constraint fk_role_parentId foreign key (parentId) references role(id);

-- 资源表
create table resources(
	id				varchar(48) not null primary key,
	name			varchar(50) not null,
	path			varchar(200) not null,
	parentId		varchar(48), 
	type			varchar(30) comment '资源类型', 
	state			varchar(10),
	memo			varchar(100)
) comment = '资源信息表';
alter table resources add constraint unq_resources_name unique(name);
alter table resources add constraint fk_resources_parentId foreign key (parentId) references resources(id);

-- 用户,角色 关联表
create table userRole(
	id				varchar(48) not null primary key,
	userId			varchar(48) not null,
	roleId			varchar(48) not null,
	state			integer default 1
) comment = '用户,角色 关联信息表';
alter table userRole add constraint fk_userRole_userId foreign key ( userId ) references user(id);
alter table userRole add constraint fk_userRole_roleId foreign key ( roleId ) references role(id);

-- 用户,资源 关联表
create table userResources(
	id				varchar(48) not null primary key,
	userId			varchar(48) not null,
	resourcesId		varchar(48) not null,
	state			integer default 1
) comment = '用户,资源 关联信息表';
alter table userResources add constraint fk_userResources_userId foreign key (userId) references user(id);
alter table userResources add constraint fk_userResources_resourcesId foreign key (resourcesId) references resources(id);

-- 角色,资源 关联表
create table roleResources(
	id				varchar(48) not null primary key,
	roleId			varchar(48) not null,
	resourcesId		varchar(48) not null,
	state			integer default 1
) comment = '角色,资源 关联信息表';
alter table roleResources add constraint fk_roleResources_roleId foreign key (roleId) references role(id);
alter table roleResources add constraint fk_roleResources_resourcesId foreign key (resourcesId) references resources(id);

-- 系统默认值
create table defaultValue(
	id				varchar(48) not null primary key,
	name			varchar(50) not null,
	value			varchar(255) not null
) comment = '用户信息表';
alter table defaultValue add constraint unq_defaultValue_name unique ( name );

-- 厂商信息表
create table company(
	id				varchar(48) not null primary key,
	name			varchar(50) comment  '厂商名称',
	phone			varchar(20) comment  '联系电话',
	linkman			varchar(20) comment  '联系人',
	email			varchar(50),
	address			varchar(254) comment '住址',
	type			varchar(5) comment'厂商类型,区分供货商与销售商',
	state			integer default 1
) comment  '厂商信息表';

-- 商品信息表
create table shangPin(
	id				varchar(48) not null primary key,
	name			varchar(50) not null comment '商品名称',
	type			varchar(50) comment '商品类型',
	companyId		varchar(48) comment '供货厂商信息',
	memo			varchar(254)
) comment  '商品信息表';
alter table shangPin add constraint fk_shangPin_companyId foreign key (companyId) references company(id);

-- 入库管理
create table ruKu(
	id				varchar(48) not null primary key,
	shangPinId		varchar(48) not null comment '入库商品',
	price			double comment '入库价格',
	amount			integer comment '入库数量',
	date			datetime comment '入库时间',
	userId			varchar(48) comment '经手人'
) comment  '入库信息表';
alter table ruKu add constraint fk_ruKu_shangPinId foreign key (shangPinId) references shangPin(id);
alter table ruKu add constraint fk_ruKu_userId foreign key (userId) references user(id);

-- 出库管理
-- 第二次付款时,页面的数据显示问题
create table chuKu(
	id				varchar(48) not null primary key,
	shangPinId		varchar(48) not null comment '出库商品',
	price			double comment '出库价格',
	amount			integer comment '出库数量' ,
	payment			double comment '实付金额',
	date			datetime  comment '出库日期',
	userId			varchar(48) comment '经手人'
) comment  '出库信息表';
alter table chuKu add constraint fk_chuKu_shangPinId foreign key (shangPinId) references shangPin(id);
alter table chuKu add constraint fk_chuKu_userId foreign key (userId) references user(id);


-- 初始化数据
insert into user(id,name,password) values('admin','管理员','f1f3f0f9da5da5ad43894a2e4a8210c3');
