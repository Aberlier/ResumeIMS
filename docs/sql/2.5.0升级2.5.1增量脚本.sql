-- changqing_base_0000 库

ALTER TABLE `c_auth_user` ADD COLUMN `readonly` bit(1) NOT NULL DEFAULT b'0' COMMENT '是否内置' AFTER `station_id`;

ALTER TABLE `c_auth_user` MODIFY COLUMN `education` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学历\n@InjectionField(api = DICTIONARY_ITEM_CLASS, method = DICTIONARY_ITEM_METHOD, dictType = DictionaryType.EDUCATION) RemoteData<String, String>' AFTER `nation`;

ALTER TABLE `c_auth_user` MODIFY COLUMN `position_status` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '职位状态\n@InjectionField(api = DICTIONARY_ITEM_CLASS, method = DICTIONARY_ITEM_METHOD, dictType = DictionaryType.POSITION_STATUS) RemoteData<String, String>' AFTER `education`;

ALTER TABLE `c_core_org` ADD COLUMN `type_` char(2) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT '01' COMMENT '类型\n@InjectionField(api = DICTIONARY_ITEM_CLASS, method = DICTIONARY_ITEM_METHOD, dictType = DictionaryType.ORG_TYPE)' AFTER `label`;

DROP TABLE IF EXISTS `g_block_list`;
DROP TABLE IF EXISTS `g_rate_limiter`;
DROP TABLE IF EXISTS `m_order`;
DROP TABLE IF EXISTS `m_product`;

-- 新增了changqing_extend_0000 库，直接
CREATE DATABASE IF NOT EXISTS `changqing_extend_0000` CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;

-- changqing_defaults 库

CREATE TABLE `changqing_defaults`.`d_datasource_config`  (
  `id` bigint(20) NOT NULL COMMENT '主键ID',
  `name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '名称',
  `username` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '账号',
  `password` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '密码',
  `url` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL DEFAULT '' COMMENT '链接',
  `driver_class_name` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NOT NULL COMMENT '驱动',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
  `update_time` datetime(0) NULL DEFAULT NULL COMMENT '修改时间',
  `update_user` bigint(20) NULL DEFAULT NULL COMMENT '修改人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '数据源' ROW_FORMAT = Dynamic;

ALTER TABLE `changqing_defaults`.`d_tenant` ADD COLUMN `connect_type` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '链接类型\n#TenantConnectTypeEnum{LOCAL:本地;REMOTE:远程}' AFTER `type`;

ALTER TABLE `changqing_defaults`.`d_tenant` MODIFY COLUMN `status` varchar(10) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT 'NORMAL' COMMENT '状态\n#{NORMAL:正常;WAIT_INIT:待初始化;FORBIDDEN:禁用;WAITING:待审核;REFUSE:拒绝;DELETE:已删除}' AFTER `connect_type`;

CREATE TABLE `changqing_defaults`.`d_tenant_datasource_config`  (
  `id` bigint(20) NOT NULL COMMENT 'ID',
  `tenant_id` bigint(20) NULL DEFAULT NULL COMMENT '租户id',
  `datasource_config_id` bigint(20) NULL DEFAULT NULL COMMENT '数据源id',
  `application` varchar(100) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '服务',
  `create_time` datetime(0) NULL DEFAULT NULL COMMENT '创建时间',
  `create_user` bigint(20) NULL DEFAULT NULL COMMENT '创建人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE = InnoDB CHARACTER SET = utf8mb4 COLLATE = utf8mb4_general_ci COMMENT = '租户数据源关系' ROW_FORMAT = Dynamic;

UPDATE d_tenant set connect_type = 'LOCAL';
