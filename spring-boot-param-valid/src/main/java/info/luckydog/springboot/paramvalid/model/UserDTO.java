package info.luckydog.springboot.paramvalid.model;

import info.luckydog.springboot.paramvalid.annotation.IdCard;
import info.luckydog.springboot.paramvalid.validator.group.Create;
import info.luckydog.springboot.paramvalid.validator.group.Update;
import lombok.Data;

import javax.validation.constraints.*;

/**
 * UserDTO
 *
 * @author eric
 * @since 2019/12/19
 */
@Data
public class UserDTO {

    // 创建用户分组，与接口中 @Validated(Create.class) 对应
    @NotBlank(message = "用户名不能为空", groups = Create.class)
    @NotNull(message = "用户名不能为空", groups = Create.class)
    private String userName;

    @NotBlank(message = "手机号码不能为空")
    @NotNull(message = "手机号码不能为空")
    @Pattern(regexp = "^[1][3,4,5,6,7,8,9][0-9]{9}$", message = "手机号格式有误")
    @Max(value = 11, message = "手机号只能为{max}位")
    @Min(value = 11, message = "手机号只能为{min}位")
    private String mobilePhone;

    @NotNull(message = "性别不能为空")
    private Integer gender;

    @NotNull(message = "年龄不能为空")
    private Integer age;

    @NotBlank(message = "电子邮箱不能为空", groups = Update.class)
    @NotNull(message = "电子邮箱不能为空", groups = Update.class)
    @Email(message = "邮箱格式错误", groups = Update.class)
    private String email;

    @NotNull(message = "身份证不能为空")
    @NotBlank(message = "身份证不能为空")
    @IdCard(message = "身份证不合法")
    private String idNo;
}
