package info.luckydog.springboot.mapstruct.model;

import info.luckydog.springboot.mapstruct.enums.GenderEnum;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/**
 * User
 *
 * @author eric
 * @since 2020/1/13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class User {
    private Long id;
    private String userName;
    private String password;
    private String phone;
    private String idCard;
    private Integer gender;
    private Integer age;
    private Date birthDate;
    private String email;
    private Double salary;
}
