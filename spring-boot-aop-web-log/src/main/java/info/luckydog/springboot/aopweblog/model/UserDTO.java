package info.luckydog.springboot.aopweblog.model;

import lombok.Data;

import java.util.List;

/**
 * UserDTO
 *
 * @author eric
 * @since 2019/12/19
 */
@Data
public class UserDTO {
    private String name;
    private String pwd;
    private List<Long> id;
}
