-- 菜单 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('教材信息', '3', '1', 'book', 'system/book/index', 1, 'C', '0', '0', 'system:book:list', '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '教材信息菜单');

-- 按钮父菜单ID
SELECT @parentId := LAST_INSERT_ID();

-- 按钮 SQL
insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('教材信息查询', @parentId, '1',  '#', '', 1,  'F', '0',  '0', 'system:book:query',        '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('教材信息新增', @parentId, '2',  '#', '', 1,  'F', '0',  '0', 'system:book:add',          '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('教材信息修改', @parentId, '3',  '#', '', 1,  'F', '0',  '0', 'system:book:edit',         '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('教材信息删除', @parentId, '4',  '#', '', 1,  'F', '0',  '0', 'system:book:remove',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');

insert into sys_menu (menu_name, parent_id, order_num, path, component, is_frame, menu_type, visible, status, perms, icon, create_by, create_time, update_by, update_time, remark)
values('教材信息导出', @parentId, '5',  '#', '', 1,  'F', '0',  '0', 'system:book:export',       '#', 'admin', '2018-03-01', 'ry', '2018-03-01', '');