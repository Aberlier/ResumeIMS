CREATE DATABASE IF NOT EXISTS `changqing_activiti` CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci;
use changqing_activiti;

-- 直接执行 changqing_activiti.sql 文件


use changqing_extend_0000;
-- ----------------------------
-- Table structure for b_biz_item
-- ----------------------------
DROP TABLE IF EXISTS `b_biz_item`;
CREATE TABLE `b_biz_item` (
  `id` bigint(32) NOT NULL,
  `item_name` varchar(64) DEFAULT NULL COMMENT '事项名称',
  `item_content` varchar(64) DEFAULT NULL COMMENT '事项内容',
  `item_remake` varchar(255) DEFAULT NULL COMMENT '事项备注',
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` bigint(20) DEFAULT '0' COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` bigint(20) DEFAULT '0' COMMENT '更新人',
  `tenant_code` varchar(32) DEFAULT NULL COMMENT '租户code',
  `task_id` varchar(64) DEFAULT NULL COMMENT '任务外键',
  `inst_id` varchar(64) DEFAULT NULL COMMENT '流程实例外键',
  `module` varchar(255) DEFAULT NULL COMMENT '模块名',
  `biz_id` bigint(32) DEFAULT NULL COMMENT '业务id',
  `result` bit(2) DEFAULT NULL COMMENT '审批结果',
  `item_user` bigint(20) DEFAULT NULL COMMENT '事项待办人',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4;

-- ----------------------------
-- Table structure for b_biz_leave
-- ----------------------------
DROP TABLE IF EXISTS `b_biz_leave`;
CREATE TABLE `b_biz_leave` (
  `id` bigint(20) NOT NULL,
  `name_` varchar(32) DEFAULT NULL COMMENT '请假人员',
  `start_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '请假时间',
  `end_time` datetime DEFAULT NULL ON UPDATE CURRENT_TIMESTAMP COMMENT '结束时间',
  `when_long` varchar(255) DEFAULT NULL COMMENT '请假时长',
  `type` varchar(8) DEFAULT '' COMMENT '请假类型',
  `reason` varchar(255) DEFAULT NULL COMMENT '请假事由',
  `user_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` bigint(20) DEFAULT '0' COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` bigint(20) DEFAULT '0' COMMENT '更新人',
  `tenant_code` varchar(32) DEFAULT NULL COMMENT '租户code',
  `inst_id` varchar(64) DEFAULT NULL COMMENT '流程实例外键',
  `is_delete` bit(1) DEFAULT b'0' COMMENT '删除标识',
  `is_over` bit(1) DEFAULT b'0' COMMENT '流程是否结束',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='请假流程';

-- ----------------------------
-- Table structure for b_biz_reimbursement
-- ----------------------------
DROP TABLE IF EXISTS `b_biz_reimbursement`;
CREATE TABLE `b_biz_reimbursement` (
  `id` bigint(20) NOT NULL,
  `name_` varchar(32) DEFAULT NULL COMMENT '报销人员',
  `type` varchar(8) DEFAULT '' COMMENT '报销类型',
  `reason` varchar(255) DEFAULT NULL COMMENT '报销说明',
  `number` float(8,0) DEFAULT NULL,
  `user_id` bigint(20) DEFAULT NULL,
  `create_time` datetime DEFAULT NULL COMMENT '创建时间',
  `create_user` bigint(20) DEFAULT '0' COMMENT '创建人',
  `update_time` datetime DEFAULT NULL COMMENT '更新时间',
  `update_user` bigint(20) DEFAULT '0' COMMENT '更新人',
  `tenant_code` varchar(32) DEFAULT NULL COMMENT '租户code',
  `inst_id` varchar(64) DEFAULT NULL COMMENT '流程实例外键',
  `is_delete` bit(1) DEFAULT b'0' COMMENT '删除标识',
  `is_over` bit(1) DEFAULT b'0' COMMENT '流程是否结束',
  PRIMARY KEY (`id`) USING BTREE
) ENGINE=InnoDB DEFAULT CHARSET=utf8mb4 COMMENT='报销流程';
