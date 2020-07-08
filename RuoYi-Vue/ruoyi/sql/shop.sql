-- ----------------------------
-- 1、书本教材book
-- ----------------------------
drop table if exists book;
create table book(
	book_id    bigint(20)    not null auto_increment comment '书本ID',
	code      varchar(200)    not null comment '书本编号',
	name     varchar(200)    not null comment '书本名称',
	price       float(6,2)        not null comment '书本价格',
	grade      varchar(200)    not null comment '使用年级',
	del_flag    char(1)     default '0'       comment '删除标志（0代表存在 2代表删除）',
  	login_ip     varchar(50)     default ''    comment '最后登陆IP',
  	login_date        datetime                      comment '最后登陆时间',
  	create_by         varchar(64)     default ''   comment '创建者',
  	create_time       datetime                        comment '创建时间',
  	update_by         varchar(64)     default ''    comment '更新者',
  	update_time       datetime                           comment '更新时间',
  	remark            varchar(500)    default null    comment '备注',
  	primary key (book_id)
) engine=innodb auto_increment=100 comment = '教材信息表';

commit;