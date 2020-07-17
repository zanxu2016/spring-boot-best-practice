package info.luckydog.mybatis.mapper;

import info.luckydog.mybatis.entity.User;
import info.luckydog.mybatis.mapper.provider.UpdateUserProvider;
import org.apache.ibatis.annotations.*;

import java.util.List;

@Mapper
public interface UserMapper {

    // ==================xml==================
    // 查询列表
    List<User> getUserList();

    // ==================注解==================
    // 查询
    @Select("select * from user where id = #{id}")
    User getUserById(Long id);

    // 添加
    @Insert("insert into user(name,pwd,age,gender,remark) values(#{name}, #{pwd}, #{age}, #{gender}, #{remark})")
    @Options(useGeneratedKeys = true, keyColumn = "id", keyProperty = "id")
    int addUser(User user);

    // 全量更新
    @Update("update user set name = #{name}, pwd = #{pwd}, age = #{age}, gender = #{gender}, remark = #{remark} where id = #{id}")
    int updateUser(User user);

    // 部分更新
    @UpdateProvider(type = UpdateUserProvider.class, method = "updateByPrimaryKeySelective")
    int updateUserSelective(@Param("user") User user);


}
