package info.luckydog.mybatis.entity;

import io.github.yedaxia.apidocs.Ignore;
import lombok.Data;

/**
 * 用户信息
 */
@Data
public class User {
    private Long id;// 用户ID
    private String name;// 用户名称
    @Ignore
    private String pwd;// 用户密码
    private Integer age;// 用户年龄
    private Integer gender;// 用户性别
    private String remark;// 备注信息
}
