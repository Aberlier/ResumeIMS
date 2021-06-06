-- 新增2张表
CREATE TABLE `g_block_list`  (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `ip` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '黑名单ip',
  `request_uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '请求URI',
  `request_method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'ALL' COMMENT '请求方法\n如果为ALL则表示对所有方法生效',
  `limit_start` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '限制时间起',
  `limit_end` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '限制时间止',
  `status` bit(1) NULL DEFAULT b'1' COMMENT '状态',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `create_user` bigint(20) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `update_user` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  FULLTEXT INDEX `FU_PATH`(`limit_start`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '黑名单\n' ROW_FORMAT = Dynamic;

CREATE TABLE `g_rate_limiter`  (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `count` int(10) NULL DEFAULT 0 COMMENT '次数',
  `request_uri` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '请求URI',
  `request_method` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'ALL' COMMENT '请求方法\n如果为ALL则表示对所有方法生效',
  `limit_start` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '限制时间起',
  `limit_end` varchar(8) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '' COMMENT '限制时间止',
  `status` bit(1) NULL DEFAULT b'1' COMMENT '状态',
  `interval_sec` bigint(20) NULL DEFAULT 0 COMMENT '时间窗口',
  `create_time` datetime(0) NULL DEFAULT NULL,
  `create_user` bigint(20) NULL DEFAULT NULL,
  `update_time` datetime(0) NULL DEFAULT NULL,
  `update_user` bigint(20) NULL DEFAULT NULL,
  PRIMARY KEY (`id`) USING BTREE,
  FULLTEXT INDEX `FU_PATH`(`limit_start`)
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '限流' ROW_FORMAT = Dynamic;

-- 新增1个一级菜单，2个2级 菜单
INSERT INTO `c_auth_menu`(`id`, `label`, `describe_`, `is_public`, `path`, `component`, `is_enable`, `sort_value`, `icon`, `group_`, `parent_id`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (1291625710699413504, '网关管理', '', b'0', '/gateway', 'changqing/gateway/Index', b'1', 10, 'el-icon-odometer', '', 0, 3, '2020-08-07 14:42:21', 3, '2020-08-07 14:42:21');
INSERT INTO `c_auth_menu`(`id`, `label`, `describe_`, `is_public`, `path`, `component`, `is_enable`, `sort_value`, `icon`, `group_`, `parent_id`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (1291625997229096960, '限流规则', '', b'0', '/gateway/ratelimiter', 'changqing/gateway/ratelimiter/Index', b'1', 1, '', '', 1291625710699413504, 3, '2020-08-07 14:43:30', 3, '2020-08-07 14:57:56');
INSERT INTO `c_auth_menu`(`id`, `label`, `describe_`, `is_public`, `path`, `component`, `is_enable`, `sort_value`, `icon`, `group_`, `parent_id`, `create_user`, `create_time`, `update_user`, `update_time`) VALUES (1291626135842455552, '阻止访问', '', b'0', '/gateway/blocklist', 'changqing/gateway/blocklist/Index', b'1', 2, '', '', 1291625710699413504, 3, '2020-08-07 14:44:03', 3, '2020-08-07 14:44:03');
-- 菜单授权给超管
INSERT INTO `c_auth_role_authority`(`id`, `authority_id`, `authority_type`, `role_id`, `create_time`, `create_user`) VALUES (1291627753803612165, 1291626135842455552, 'MENU', 100, '2020-08-07 14:50:28', 3);
INSERT INTO `c_auth_role_authority`(`id`, `authority_id`, `authority_type`, `role_id`, `create_time`, `create_user`) VALUES (1291627753853943808, 1291625710699413504, 'MENU', 100, '2020-08-07 14:50:28', 3);
INSERT INTO `c_auth_role_authority`(`id`, `authority_id`, `authority_type`, `role_id`, `create_time`, `create_user`) VALUES (1291627753862332417, 1291625997229096960, 'MENU', 100, '2020-08-07 14:50:28', 3);
