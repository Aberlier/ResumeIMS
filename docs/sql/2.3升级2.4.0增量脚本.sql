SET FOREIGN_KEY_CHECKS=0;

ALTER TABLE `c_auth_user` MODIFY COLUMN `nation` varchar(20) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '民族\n@InjectionField(api = DICTIONARY_ITEM_CLASS, method = DICTIONARY_ITEM_METHOD, dictType = DictionaryType.NATION) RemoteData<String, String>\n' AFTER `avatar`;

ALTER TABLE `m_order` ADD COLUMN `education` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学历\n@InjectionField(api = \"orderServiceImpl\", method = DICTIONARY_ITEM_METHOD, dictType = DictionaryType.EDUCATION) RemoteData<String, String>' AFTER `name`;

ALTER TABLE `m_order` ADD COLUMN `nation` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '民族\n@InjectionField(api = DICTIONARY_ITEM_FEIGN_CLASS, method = DICTIONARY_ITEM_METHOD, dictType = DictionaryType.NATION) RemoteData<String, String>\n' AFTER `education`;

ALTER TABLE `m_order` ADD COLUMN `org_id` bigint(20) NULL DEFAULT NULL COMMENT '组织ID\n#c_core_org\n@InjectionField(api = ORG_ID_FEIGN_CLASS, method = ORG_ID_NAME_METHOD) RemoteData<Long, String>' AFTER `nation`;

ALTER TABLE `m_product` MODIFY COLUMN `type3` varchar(255) CHARACTER SET utf8mb4 COLLATE utf8mb4_general_ci NULL DEFAULT NULL COMMENT '学历\n@InjectionField(api = DICTIONARY_ITEM_FEIGN_CLASS, method = DICTIONARY_ITEM_METHOD, dictType = DictionaryType.EDUCATION) RemoteData<String, String>\n' AFTER `type2`;

DROP TABLE `c_auth_system_api`;

SET FOREIGN_KEY_CHECKS=1;
