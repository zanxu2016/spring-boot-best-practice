package info.luckydog.springboot.mapstruct.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

/**
 * UserDto
 *
 * @author eric
 * @since 2020/1/13
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserDto {
    private Long userId;
    private String userName;
    private String password;
    private String phone;
    private String idNo;
    private String gender;
    private Integer age;
    private String birthDate;
    private String email;
    private Double salary;
}
