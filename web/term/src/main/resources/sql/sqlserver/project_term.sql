
-- 用户表
create table [user]( 
	id				varchar(48) not null primary key,
	name			varchar(50) not null , 
	password		varchar(40) not null,
	sex				varchar(2),
	email			varchar(50),
	phone			varchar(15),
	address			varchar(254),
	state			int default 1,--1:在职;0:离职
	active			int default 1,
	remark			varchar(500),--备注
	createPerson	varchar(50),--创建人
	createTime		datetime,--创建时间
	updatePerson	varchar(50),--更新人
	updateTime		datetime	--更新时间
);
--alter table [user] add constraint unq_user_name unique(name);

-- 角色表
create table role(
	id				varchar(50) primary key,--主键,系统按规则生成
	level			int,--角色层级,最大为17.因为每级为3个字符,主键长度为50
	name			varchar(50),--角色名称
	parentId		varchar(50),--父角色ID
	type			varchar(10) default 1,--1:普通权限组;2:管理员权限组
	departmentId	varchar(48),,--角色的部门限制范围
	isLimit			int,--授权范围.1:禁止向下授权(默认),2:允许向下授权
	sort			int,--排序,仅限于同级别排序
	active			int,--删除状态
	remark			varchar(500),--备注
	createPerson	varchar(50),--创建人
	createTime		datetime,--创建时间
	updatePerson	varchar(50),--更新人
	updateTime		datetime	--更新时间
);
--alter table role add constraint unq_role_name unique(name);
--alter table role add constraint fk_role_parentId foreign key (parentId) references role(id);

-- 资源表
create table resources(
	id				varchar(50) primary key,--主键,由后台编程人员设定.前台人员创建时ID为UUID(大部分都是添加目录)
	name			varchar(50),--URL名称,名称唯一.如:添加用户
	alias			varchar(50),--URL名称的别名.如:添加用户(唯一)-->添加(不唯一,但方便在页面显示)
	level			int,--模块层级
	sort			int,--排序,仅限于相同父节点的模块
	mask			varchar(200),--掩码
	parentId		varchar(50),--父模块ID
	version			varchar(50),--模块版本
	operationType	int,--操作类型:1:查询列表,2:添加,4:修改,8:删除/批量删除,16:查询明细(查看),32:审核,64:导入,128:导出
	pageUrl			varchar(200),--跳转到页面的URL
	submitUrl		varchar(200),--页面表单提交后跳转到的后台逻辑处理的URL操作
	desplay			int,--在首页的权限菜单树中是否显示.1:不显示(默认),2:显示.
	hasCustom		int,--此模块是否请允许有自定义字段,1:不允许(默认),2:允许.
	operationIds	varchar(1000),--对应的操作IDs,","分割
	tableIds		varchar(1000),--对应的table实体的Ids,","分割
	fieldIds		varchar(2000),--对应的被分配的属性的IDs,","分割
	active			int,--删除状态
	remark			varchar(500),--备注
	createPerson	varchar(50),--创建人
	createTime		datetime,--创建时间
	updatePerson	varchar(50),--更新人
	updateTime		datetime	--更新时间	
);
--alter table resources add constraint unq_resources_name unique(name);
--alter table resources add constraint fk_resources_parentId foreign key (parentId) references resources(id);

-- 用户,角色 关联表
create table userRole(
	id				varchar(50) primary key,--主键,UUID
	roleId			varchar(50),--角色ID
	userId			varchar(50),--用户ID
	active			int,--删除状态
	remark			varchar(500),--备注
	createPerson	varchar(50),--创建人
	createTime		datetime,--创建时间
	updatePerson	varchar(50),--更新人
	updateTime		datetime	--更新时间
);
--alter table userRole add constraint fk_userRole_userId foreign key ( userId ) references user(id);
--alter table userRole add constraint fk_userRole_roleId foreign key ( roleId ) references role(id);

-- 角色,资源 关联表
create table roleResources(
	id				varchar(50) primary key,--主键,UUID
	roleId			varchar(50),--角色ID
	resourcesId		varchar(50),--模块ID
	operationIds	varchar(1000),--对应的操作IDs,","分割
	fieldIds		varchar(2000),--对应的被分配的属性的IDs,","分割
	active			int,--删除状态
	remark			varchar(500),--备注
	createPerson	varchar(50),--创建人
	createTime		datetime,--创建时间
	updatePerson	varchar(50),--更新人
	updateTime		datetime	--更新时间
);
--alter table roleResources add constraint fk_roleResources_roleId foreign key (roleId) references role(id);
--alter table roleResources add constraint fk_roleResources_resourcesId foreign key (resourcesId) references resources(id);

-- 部门
create table department(
	id				varchar(48) not null primary key,
	parentId		varchar(48),
	name			varchar(200),
	state			int,--
	level			int,
	mask			varchar(200),
	active			int,--删除状态
	remark			varchar(500),--备注
	createPerson	varchar(50),--创建人
	createTime		datetime,--创建时间
	updatePerson	varchar(50),--更新人
	updateTime		datetime	--更新时间	
);

create table userDepartment(
	id				varchar(48) not null primary key,
	userId			varchar(48),
	departmentID	varchar(48),
	isManager		varchar(2),--Y:是;N:否
	enterTime		datetime,--进入部门时间
	leaveTime		datetime,--离开部门时间
	active			int,--删除状态
	remark			varchar(500),--备注
	createPerson	varchar(50),--创建人
	createTime		datetime,--创建时间
	updatePerson	varchar(50),--更新人
	updateTime		datetime	--更新时间	
);

-- 系统字典管理
create table dictionary(
	id				varchar(48) not null primary key,
	type			int,
	code			varchar(50),
	name			varchar(50),
	value			varchar(255),
	active			int,--删除状态
	remark			varchar(500),--备注
	createPerson	varchar(50),--创建人
	createTime		datetime,--创建时间
	updatePerson	varchar(50),--更新人
	updateTime		datetime	--更新时间	
) ;

-- 用户登陆日志
create table loginLog(
	id				varchar(48) not null primary key,
	userID			varchar(50),
	userName		varchar(50),
	loginTime		datetime,
	ip				varchar(200),
	os				varchar(50),
	explorer		varchar(50),
	explorerVersion	varchar(50)	
);

--用户访问日志
create table accessLog(
	id				varchar(48) not null primary key,
	userId			varchar(50),
	userName		varchar(50),
	accessTime		datetime,
	result			varchar(10),--Y:成功,N:失败
	url				varchar(500),--访问的URL
	title			varchar(200),--URL标题
	failCause		varchar(200)--访问失败的原因
);



