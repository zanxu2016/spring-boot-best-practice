package info.luckydog.mybatistest.service.impl;

import info.luckydog.mybatistest.entity.User;
import info.luckydog.mybatistest.mapper.UserMapper;
import info.luckydog.mybatistest.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Slf4j
public class UserServiceImpl implements UserService {

    @Autowired
    private UserMapper userMapper;

    @Override
    public List<User> getUserList() {
        log.info("getUserList...");
        return userMapper.getUserList();
    }

    @Override
    public User getUserById(Long id) {
        return userMapper.getUserById(id);
    }

    @Override
    public int addUser(User user) {
        return userMapper.addUser(user);
    }

    @Override
    public int updateUser(User user) {
        return userMapper.updateUser(user);
    }

    @Override
    public int updateUserSelective(User user) {
        return userMapper.updateUserSelective(user);
    }
}
