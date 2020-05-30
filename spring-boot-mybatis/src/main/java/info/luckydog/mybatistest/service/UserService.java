package info.luckydog.mybatistest.service;

import info.luckydog.mybatistest.entity.User;

import java.util.List;

public interface UserService {
    List<User> getUserList();

    User getUserById(Long id);

    int addUser(User user);

    int updateUser(User user);

    int updateUserSelective(User user);


}
