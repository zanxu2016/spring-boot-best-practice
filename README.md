## spring boot 最佳实践

### spring-boot-mybatis 模块
mysql
建表SQL
```sql
# 创建用户表
CREATE TABLE `user` (
  `id` bigint(20) NOT NULL AUTO_INCREMENT COMMENT '主键',
  `name` varchar(64) DEFAULT NULL COMMENT '用户名',
  `pwd` varchar(32) NOT NULL DEFAULT '' COMMENT '密码',
  `age` tinyint(4) NOT NULL DEFAULT '0' COMMENT '年龄',
  `gender` tinyint(4) NOT NULL DEFAULT '0' COMMENT '性别：0-女；1-男',
  `remark` varchar(10) DEFAULT NULL COMMENT '备注',
  PRIMARY KEY (`id`)
) ENGINE=InnoDB DEFAULT CHARSET=utf8;

# 初始化数据
INSERT INTO `user`(name, pwd, age, gender, remark) VALUES ('tom', '11111', 16, 1, 'test');
INSERT INTO `user`(name, pwd, age, gender, remark) VALUES ('tim', '22222', 17, 1, 'full');
INSERT INTO `user`(name, pwd, age, gender, remark) VALUES ('tonny', '333333', 18, 1, 'full');
INSERT INTO `user`(name, pwd, age, gender, remark) VALUES ('jim', '444444', 19, 1, 'full');
INSERT INTO `user`(name, pwd, age, gender, remark) VALUES ('john', '5555555', 20, 1, 'full');
INSERT INTO `user`(name, pwd, age, gender, remark) VALUES ('jonny', '666666', 21, 1, 'full');
INSERT INTO `user`(name, pwd, age, gender, remark) VALUES ('mary', '777777', 22, 0, 'full');
INSERT INTO `user`(name, pwd, age, gender, remark) VALUES ('lily', '888888', 23, 0, 'new');

```
