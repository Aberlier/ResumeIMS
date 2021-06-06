Linux 和 Mac 可用：
modify_file_name.sh: 修改文件名或者文件夹中包含changqing的
modify_content.sh： 修改文件中包含changqing字符串的

修改包名执行顺序：
1. 修改modify_file_name.sh中 PROJECT_PATH 为changqing-commons-plus的绝对路径
2. 修改modify_file_name.sh中 OLD_PROJECT_NAME为 github，NEW_PROJECT_NAME 为公司名
    建议： 全小写字母，不要出现大写字母、下划线、减号等字符
3. 执行modify_file_name.sh脚本 (执行后，会将文件夹中 github，改成公司名)
4. 修改modify_file_name.sh中 OLD_PROJECT_NAME为 changqing，NEW_PROJECT_NAME 为项目名
5. 执行modify_file_name.sh脚本 (执行后，会将文件夹中 changqing，改成项目名)
6. 修改modify_file_name.sh中 PROJECT_PATH 为changqing-cloud-plus的绝对路径
7. 重复2、3、4、5步骤
8. changqing-generator-plus 和 changqing-boot-plus 同理

修改文件中内容执行顺序：
1. 修改modify_content.sh中 PROJECT_PATH 为changqing-commons-plus的绝对路径
2. 修改modify_content.sh中 NEW_PACKAGE_STR 为 com.公司.项目 （注意，公司和项目要和modify_file_name.sh文件中的保持一致， com不建议修改）
3. 执行modify_content.sh脚本
4. 修改modify_content.sh中 PROJECT_PATH 为changqing-cloud-plus的绝对路径
5. 执行modify_content.sh脚本  （步骤2的参数请保持一致）
7. changqing-generator-plus 和 changqing-boot-plus 同理

最后：
1. 将文件夹 changqing-commons-plus 改成 你想要的名字
2. 将文件夹 changqing-cloud-plus 改成 你想要的名字
3. 将文件夹 changqing-boot-plus 改成 你想要的名字
4. 将文件夹 changqing-generator-plus 改成 你想要的名字
5. 将 c_auth_application 表中的clientId、clientSecret字段中 changqing 改为 项目名 （只改前缀）

全平台可用：
ModifyFileName.java：修改文件名或者文件夹中包含changqing的
ModifyContent.java：修改文件中包含changqing字符串的


先执行 ModifyFileName ，后执行ModifyContent。 执行前，认真阅读脚本中的内容。
ModifyFileName.java和ModifyContent.java请先复制其他项目后执行。
