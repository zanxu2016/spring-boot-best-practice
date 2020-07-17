package info.luckydog.mybatis.service;

import info.luckydog.mybatis.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();

    User getUserById(Long id);

    int addUser(User user);

    int updateUser(User user);

    int updateUserSelective(User user);


}
