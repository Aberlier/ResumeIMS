-- 本脚本仅仅适用于 SCHEMA 和 DATASOURCE 模式， 若您决定使用 COLUMN 模式。请勿执行此脚本！！！
-- 本脚本仅仅适用于 SCHEMA 和 DATASOURCE 模式， 若您决定使用 COLUMN 模式。请勿执行此脚本！！！
-- 本脚本仅仅适用于 SCHEMA 和 DATASOURCE 模式， 若您决定使用 COLUMN 模式。请勿执行此脚本！！！
-- COLUMN 模式，新创建一个库后， 直接执行 changqing_column.sql + changqing_defaults.sql 重新建表

-- changqing_defaults
ALTER TABLE `changqing_defaults`.`d_tenant` DROP COLUMN `password_expire`;

ALTER TABLE `changqing_defaults`.`d_tenant` DROP COLUMN `is_multiple_login`;

ALTER TABLE `changqing_defaults`.`d_tenant` DROP COLUMN `password_error_num`;

ALTER TABLE `changqing_defaults`.`d_tenant` DROP COLUMN `password_error_lock_time`;

-- changqing_base_0000
ALTER TABLE `changqing_base_0000`.`c_auth_application` DROP INDEX `UN_APP_KEY`;

ALTER TABLE `changqing_base_0000`.`c_auth_application` ADD COLUMN `client_id` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端ID' AFTER `id`;

ALTER TABLE `changqing_base_0000`.`c_auth_application` ADD COLUMN `client_secret` varchar(32) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端密码' AFTER `client_id`;

ALTER TABLE `changqing_base_0000`.`c_auth_application` DROP COLUMN `tenant_code`;

ALTER TABLE `changqing_base_0000`.`c_auth_application` DROP COLUMN `app_key`;

ALTER TABLE `changqing_base_0000`.`c_auth_application` DROP COLUMN `app_secret`;

ALTER TABLE `changqing_base_0000`.`c_auth_application` ADD INDEX `UN_APP_KEY`(`client_id`) USING BTREE;

ALTER TABLE `changqing_base_0000`.`c_auth_menu` DROP COLUMN `tenant_code`;

ALTER TABLE `changqing_base_0000`.`c_auth_resource` DROP INDEX `UN_CODE`;

ALTER TABLE `changqing_base_0000`.`c_auth_resource` DROP COLUMN `tenant_code`;

ALTER TABLE `changqing_base_0000`.`c_auth_resource` ADD UNIQUE INDEX `UN_CODE`(`code`) USING BTREE COMMENT '编码唯一';

ALTER TABLE `changqing_base_0000`.`c_auth_role` DROP INDEX `UN_CODE`;

ALTER TABLE `changqing_base_0000`.`c_auth_role` DROP COLUMN `tenant_code`;

ALTER TABLE `changqing_base_0000`.`c_auth_role` ADD UNIQUE INDEX `UN_CODE`(`code`) USING BTREE;

ALTER TABLE `changqing_base_0000`.`c_auth_role_authority` DROP COLUMN `tenant_code`;

ALTER TABLE `changqing_base_0000`.`c_auth_role_org` DROP COLUMN `tenant_code`;

ALTER TABLE `changqing_base_0000`.`c_auth_system_api` DROP INDEX `UNX_CODE`;

ALTER TABLE `changqing_base_0000`.`c_auth_system_api` ADD COLUMN `permission` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '权限' AFTER `code`;

ALTER TABLE `changqing_base_0000`.`c_auth_system_api` MODIFY COLUMN `code` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '编码' AFTER `id`;

ALTER TABLE `changqing_base_0000`.`c_auth_system_api` DROP COLUMN `tenant_code`;

ALTER TABLE `changqing_base_0000`.`c_auth_system_api` ADD UNIQUE INDEX `UNX_CODE`(`code`) USING BTREE;

ALTER TABLE `changqing_base_0000`.`c_auth_user` DROP INDEX `UN_ACCOUNT`;

ALTER TABLE `changqing_base_0000`.`c_auth_user` DROP COLUMN `tenant_code`;

ALTER TABLE `changqing_base_0000`.`c_auth_user` ADD UNIQUE INDEX `UN_ACCOUNT`(`account`) USING BTREE;

ALTER TABLE `changqing_base_0000`.`c_auth_user_role` DROP COLUMN `tenant_code`;

CREATE TABLE `changqing_base_0000`.`c_auth_user_token`  (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `login_ip` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录IP',
  `location` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '登录地点',
  `client_id` varchar(24) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '客户端Key',
  `token` text CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL COMMENT 'token',
  `name` varchar(50) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '姓名',
  `expire_time` datetime(0) NULL DEFAULT NULL COMMENT '过期时间',
  `account` varchar(30) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '账号',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `create_user` bigint(20) NULL DEFAULT NULL COMMENT '登录人ID',
  `update_time` datetime(0) NULL DEFAULT NULL,
  `update_user` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = 'token' ROW_FORMAT = Dynamic;

ALTER TABLE `changqing_base_0000`.`c_common_area` DROP INDEX `UN_CODE`;

ALTER TABLE `changqing_base_0000`.`c_common_area` DROP COLUMN `tenant_code`;

ALTER TABLE `changqing_base_0000`.`c_common_area` ADD UNIQUE INDEX `UN_CODE`(`code`) USING BTREE;

ALTER TABLE `changqing_base_0000`.`c_common_dictionary` DROP COLUMN `tenant_code`;

ALTER TABLE `changqing_base_0000`.`c_common_dictionary_item` DROP COLUMN `tenant_code`;

ALTER TABLE `changqing_base_0000`.`c_common_login_log` DROP COLUMN `tenant_code`;

ALTER TABLE `changqing_base_0000`.`c_common_opt_log` DROP COLUMN `tenant_code`;

ALTER TABLE `changqing_base_0000`.`c_common_parameter` DROP INDEX `UN_KEY`;

ALTER TABLE `changqing_base_0000`.`c_common_parameter` MODIFY COLUMN `describe_` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '描述' AFTER `value`;

ALTER TABLE `changqing_base_0000`.`c_common_parameter` DROP COLUMN `tenant_code`;

ALTER TABLE `changqing_base_0000`.`c_common_parameter` ADD UNIQUE INDEX `UN_KEY`(`key_`) USING BTREE;

ALTER TABLE `changqing_base_0000`.`c_core_org` DROP COLUMN `tenant_code`;

ALTER TABLE `changqing_base_0000`.`c_core_station` DROP COLUMN `tenant_code`;

ALTER TABLE `changqing_base_0000`.`f_attachment` DROP COLUMN `tenant_code`;

ALTER TABLE `changqing_base_0000`.`f_file` DROP COLUMN `tenant_code`;

ALTER TABLE `changqing_base_0000`.`m_order` DROP COLUMN `tenant_code`;

ALTER TABLE `changqing_base_0000`.`m_product` DROP COLUMN `tenant_code`;

ALTER TABLE `changqing_base_0000`.`mail_provider` DROP COLUMN `tenant_code`;

ALTER TABLE `changqing_base_0000`.`mail_send_status` DROP COLUMN `tenant_code`;

ALTER TABLE `changqing_base_0000`.`mail_task` DROP COLUMN `tenant_code`;

ALTER TABLE `changqing_base_0000`.`msgs_center_info` DROP COLUMN `tenant_code`;

ALTER TABLE `changqing_base_0000`.`msgs_center_info_receive` DROP COLUMN `tenant_code`;

ALTER TABLE `changqing_base_0000`.`sms_send_status` DROP COLUMN `tenant_code`;

ALTER TABLE `changqing_base_0000`.`sms_task` DROP COLUMN `tenant_code`;

ALTER TABLE `changqing_base_0000`.`sms_template` DROP INDEX `UN_CODE`;

ALTER TABLE `changqing_base_0000`.`sms_template` DROP COLUMN `tenant_code`;

ALTER TABLE `changqing_base_0000`.`sms_template` ADD UNIQUE INDEX `UN_CODE`(`custom_code`) USING BTREE;

DROP TABLE `changqing_base_0000`.`c_auth_application_system_api`;

-- 数据
INSERT INTO `changqing_base_0000`.`c_auth_application`(`id`, `client_id`, `client_secret`, `website`, `name`, `icon`, `app_type`, `describe_`, `status`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (1, 'changqing_ui', 'changqing_ui_secret', 'http://tangyh.top:10000/changqing-ui/', 'SaaS微服务管理后台', '', 'PC', '内置', b'1', 1, '2020-04-02 15:05:14', 1, '2020-04-02 15:05:17');
INSERT INTO `changqing_base_0000`.`c_auth_application`(`id`, `client_id`, `client_secret`, `website`, `name`, `icon`, `app_type`, `describe_`, `status`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (2, 'changqing_admin_ui', 'changqing_admin_ui_secret', 'http://tangyh.top:180/changqing-admin-ui/', 'SaaS微服务超级管理后台', '', 'PC', '内置', b'1', 1, '2020-04-02 15:05:22', 1, '2020-04-02 15:05:19');

INSERT INTO `changqing_base_0000`.`c_common_parameter`(`id`, `key_`, `name`, `value`, `describe_`, `status_`, `readonly_`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (1, 'LOGIN_POLICY', '登录策略', 'MANY', 'ONLY_ONE:一个用户只能登录一次; MANY:用户可以任意登录; ONLY_ONE_CLIENT:一个用户在一个应用只能登录一次', b'1', b'1', 1, '2020-04-02 21:56:19', 3, '2020-04-03 01:12:32');

INSERT INTO `changqing_base_0000`.`c_auth_resource`(`id`, `code`, `name`, `menu_id`, `describe_`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (643444685339100198, 'resource:view', '查看', 603976297063910529, '', 3, '2020-04-05 19:02:42', 3, '2020-04-05 19:02:46');
INSERT INTO `changqing_base_0000`.`c_auth_resource`(`id`, `code`, `name`, `menu_id`, `describe_`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (1237035586045345792, 'parameter:import', '导入', 1225042542827929600, '', 3, '2020-03-09 23:20:41', 3, '2020-03-09 23:20:41');
INSERT INTO `changqing_base_0000`.`c_auth_resource`(`id`, `code`, `name`, `menu_id`, `describe_`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (1237035798587506688, 'msgs:import', '导入', 605080023753294753, '', 3, '2020-03-09 23:21:32', 3, '2020-03-09 23:21:32');
INSERT INTO `changqing_base_0000`.`c_auth_resource`(`id`, `code`, `name`, `menu_id`, `describe_`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (1246066924136169472, 'parameter:view', '查看', 1225042542827929600, '', 3, '2020-04-03 21:28:00', 3, '2020-04-03 21:28:00');
INSERT INTO `changqing_base_0000`.`c_auth_resource`(`id`, `code`, `name`, `menu_id`, `describe_`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (1246067318035841024, 'loginLog:view', '查看', 645215230518909025, '', 3, '2020-04-03 21:29:34', 3, '2020-04-03 21:29:34');
DELETE FROM `changqing_base_0000`.`c_auth_resource` WHERE `id` = 648846610591122721;
DELETE FROM `changqing_base_0000`.`c_auth_resource` WHERE `id` = 1225042887989788672;

INSERT INTO `changqing_base_0000`.`c_auth_role_authority`(`id`, `authority_id`, `authority_type`, `role_id`, `create_time`, `create_user`) VALUES (643444685339100198, 643444685339100198, 'RESOURCE', 100, '2020-04-05 19:03:08', 3);
INSERT INTO `changqing_base_0000`.`c_auth_role_authority`(`id`, `authority_id`, `authority_type`, `role_id`, `create_time`, `create_user`) VALUES (1246067572667842561, 1246067318035841024, 'RESOURCE', 100, '2020-04-03 21:30:35', 3);
INSERT INTO `changqing_base_0000`.`c_auth_role_authority`(`id`, `authority_id`, `authority_type`, `role_id`, `create_time`, `create_user`) VALUES (1246067572722368512, 1246066924136169472, 'RESOURCE', 100, '2020-04-03 21:30:35', 3);
INSERT INTO `changqing_base_0000`.`c_auth_role_authority`(`id`, `authority_id`, `authority_type`, `role_id`, `create_time`, `create_user`) VALUES (1246067572734951424, 1237035586045345792, 'RESOURCE', 100, '2020-04-03 21:30:35', 3);
INSERT INTO `changqing_base_0000`.`c_auth_role_authority`(`id`, `authority_id`, `authority_type`, `role_id`, `create_time`, `create_user`) VALUES (1246067572776894465, 1237035798587506688, 'RESOURCE', 100, '2020-04-03 21:30:35', 3);
DELETE FROM `changqing_base_0000`.`c_auth_role_authority` WHERE `id` = 1225984437787820033;
DELETE FROM `changqing_base_0000`.`c_auth_role_authority` WHERE `id` = 1225984437741682689;






