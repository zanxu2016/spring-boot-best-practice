package info.luckydog.springboot.mapstruct.model.support;

import info.luckydog.springboot.mapstruct.model.User;
import info.luckydog.springboot.mapstruct.model.UserDto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.MappingTarget;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

/**
 * UserMapper
 *
 * @author eric
 * @since 2020/1/13
 */
//@Mapper(componentModel = "spring")// 实现类上添加@Component注解，可通过@Autowired注解注入使用
@Mapper
public interface UserMapper {

    // 默认使用方式 componentModel = "default"
    UserMapper INSTANCE = Mappers.getMapper(UserMapper.class);

    @Mappings({
            @Mapping(target = "userId", source = "id"),
            @Mapping(target = "password", ignore = true),
            @Mapping(target = "idNo", source = "idCard"),
            @Mapping(target = "gender", expression = "java(info.luckydog.springboot.mapstruct.enums.GenderEnum.getGenderName(user.getGender()))"),
            @Mapping(target = "birthDate", dateFormat = "yyyy-MM-dd"),
            @Mapping(target = "salary", numberFormat = "$#.00"),
    })
    UserDto fromUser(User user);

    void updateUserDtoFromUser(User user, @MappingTarget UserDto userDto);
}
