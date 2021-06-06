-- changqing_defaults 库

DROP TABLE IF EXISTS WORKER_NODE;
CREATE TABLE WORKER_NODE
(
ID BIGINT NOT NULL AUTO_INCREMENT COMMENT 'auto increment id',
HOST_NAME VARCHAR(64) NOT NULL COMMENT '主机名',
PORT VARCHAR(64) NOT NULL COMMENT '端口',
TYPE INT NOT NULL COMMENT '节点类型: ACTUAL 或者 CONTAINER',
LAUNCH_DATE DATE NOT NULL COMMENT '上线日期',
MODIFIED TIMESTAMP  NOT NULL NULL COMMENT '修改时间',
CREATED TIMESTAMP  NOT NULL NULL COMMENT '创建时间',
PRIMARY KEY(ID)
)
 COMMENT='DB WorkerID Assigner for UID Generator',ENGINE = INNODB;

-- changqing_base_0000
INSERT INTO `c_auth_menu` VALUES (4769114505659394, '多级菜单', '演示专用', b'1', '/nested', 'Layout', b'1', 13, 'nested', '', 0, 3, '2020-09-27 20:30:26', 3, '2020-09-27 20:32:34');
INSERT INTO `c_auth_menu` VALUES (4769114505659399, '菜单1', '', b'1', '/nested/menu1', 'Layout', b'1', 1, 'bug', '', 4769114505659394, 3, '2020-09-27 20:31:17', 3, '2020-09-27 20:40:11');
INSERT INTO `c_auth_menu` VALUES (4769114505659475, '菜单2', '', b'1', '/nested/menu2', 'changqing/nested/menu2/index', b'1', 2, 'el-icon-eleme', '', 4769114505659394, 3, '2020-09-27 20:39:57', 3, '2020-09-27 20:41:13');
INSERT INTO `c_auth_menu` VALUES (4769114505659482, '菜单1-1', '', b'1', '/nested/menu1/menu1-1', 'changqing/nested/menu1/menu1-1/index', b'1', 1, '', '', 4769114505659399, 3, '2020-09-27 20:41:04', 3, '2020-09-27 20:41:04');
INSERT INTO `c_auth_menu` VALUES (4769114505659489, '菜单1-2', '', b'1', '/nested/menu1/menu1-2', 'Layout', b'1', 2, '', '', 4769114505659399, 3, '2020-09-27 20:41:39', 3, '2020-09-27 20:42:04');
INSERT INTO `c_auth_menu` VALUES (4769114505659500, '菜单1-3', '', b'1', '/nested/menu1/menu1-3', 'changqing/nested/menu1/menu1-3/index', b'1', 3, '', '', 4769114505659399, 3, '2020-09-27 20:42:33', 3, '2020-09-27 20:42:33');
INSERT INTO `c_auth_menu` VALUES (4769114505659504, '菜单1-2-1', '', b'1', '/nested/menu1/menu1-2/menu1-2-1', 'changqing/nested/menu1/menu1-2/menu1-2-1/index', b'1', 1, '', '', 4769114505659489, 3, '2020-09-27 20:43:11', 3, '2020-09-27 20:43:11');
INSERT INTO `c_auth_menu` VALUES (4769114505659507, '菜单1-2-2', '', b'1', '/nested/menu1/menu1-2/menu1-2-2', 'changqing/nested/menu1/menu1-2/menu1-2-2/index', b'1', 2, '', '', 4769114505659489, 3, '2020-09-27 20:43:34', 3, '2020-09-27 20:43:34');
INSERT INTO `c_auth_menu` VALUES (1303978131115212800, '流程管理', '', b'0', '/activiti', 'changqing/activiti/Index', b'1', 11, 'el-icon-set-up', '', 0, 3, '2020-09-10 16:46:28', 3, '2020-09-10 16:52:17');
INSERT INTO `c_auth_menu` VALUES (1303979491734847488, '模型管理', '', b'0', '/activiti/modelManager', 'changqing/activiti/modelManager/Index', b'1', 1, 'el-icon-ship', '', 1303978131115212800, 3, '2020-09-10 16:51:52', 3, '2020-09-10 16:51:52');
INSERT INTO `c_auth_menu` VALUES (1303980213637480448, '流程部署', '', b'0', '/activiti/deploymentManager', 'changqing/activiti/deploymentManager/Index', b'1', 2, 'el-icon-place', '', 1303978131115212800, 3, '2020-09-10 16:54:44', 3, '2020-09-10 17:09:21');
INSERT INTO `c_auth_menu` VALUES (1303980518802456576, '请假流程', '', b'0', '/activiti/leave', 'changqing/activiti/leave/Index', b'1', 3, 'el-icon-date', '', 1303978131115212800, 3, '2020-09-10 16:55:57', 3, '2020-09-10 17:09:38');
INSERT INTO `c_auth_menu` VALUES (1303980730522533888, '报销流程', '', b'0', '/activiti/reimbursement', 'changqing/activiti/reimbursement/Index', b'1', 4, 'el-icon-coin', '', 1303978131115212800, 3, '2020-09-10 16:56:48', 3, '2020-09-10 17:10:03');
INSERT INTO `c_auth_menu` VALUES (1303981611234099200, '请假管理', '', b'0', '/activiti/leave/instantManager', 'changqing/activiti/leave/instantManager/Index', b'1', 1, 'el-icon-edit', '', 1303980518802456576, 3, '2020-09-10 17:00:18', 3, '2020-09-10 17:00:18');
INSERT INTO `c_auth_menu` VALUES (1303981798207782912, '请假任务', '', b'0', '/activiti/leave/ruTask', 'changqing/activiti/leave/ruTask/Index', b'1', 2, 'skill', '', 1303980518802456576, 3, '2020-09-10 17:01:02', 3, '2020-09-26 23:18:14');
INSERT INTO `c_auth_menu` VALUES (1303982140681093120, '报销管理', '', b'0', '/activiti/reimbursement/instantManager', 'changqing/activiti/reimbursement/instantManager/Index', b'1', 0, 'el-icon-edit', '', 1303980730522533888, 3, '2020-09-10 17:02:24', 3, '2020-09-10 17:02:24');
INSERT INTO `c_auth_menu` VALUES (1303982265327419392, '报销任务', '', b'0', '/activiti/reimbursement/ruTask', 'changqing/activiti/reimbursement/ruTask/Index', b'1', 2, 'el-icon-tickets', '', 1303980730522533888, 3, '2020-09-10 17:02:54', 3, '2020-09-10 17:02:54');


INSERT INTO `c_auth_role_authority` VALUES (1304359528610922498, 1303978131115212800, 'MENU', 100, '2020-09-11 18:02:00', 3);
INSERT INTO `c_auth_role_authority` VALUES (1304359528610922497, 1303979491734847488, 'MENU', 100, '2020-09-11 18:02:00', 3);
INSERT INTO `c_auth_role_authority` VALUES (1304359528585756673, 1303980213637480448, 'MENU', 100, '2020-09-11 18:02:00', 3);
INSERT INTO `c_auth_role_authority` VALUES (1304359528589950976, 1303980518802456576, 'MENU', 100, '2020-09-11 18:02:00', 3);
INSERT INTO `c_auth_role_authority` VALUES (1304359528627699712, 1303980730522533888, 'MENU', 100, '2020-09-11 18:02:00', 3);
INSERT INTO `c_auth_role_authority` VALUES (1304359528585756675, 1303981611234099200, 'MENU', 100, '2020-09-11 18:02:00', 3);
INSERT INTO `c_auth_role_authority` VALUES (1304359528631894018, 1303981798207782912, 'MENU', 100, '2020-09-11 18:02:00', 3);
INSERT INTO `c_auth_role_authority` VALUES (1304359528585756674, 1303982140681093120, 'MENU', 100, '2020-09-11 18:02:00', 3);
INSERT INTO `c_auth_role_authority` VALUES (1304359528615116801, 1303982265327419392, 'MENU', 100, '2020-09-11 18:02:00', 3);
