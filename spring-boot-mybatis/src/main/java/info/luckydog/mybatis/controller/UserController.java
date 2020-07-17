package info.luckydog.mybatis.controller;

import info.luckydog.mybatis.entity.User;
import info.luckydog.mybatis.service.UserService;
import info.luckydog.mybatis.service.impl.TestService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/*
 * 用户接口
 */
@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private TestService testService;

    /**
     * 用户列表
     *
     * @return List<User>
     */
    @GetMapping("list")
    public List<User> userList() {
        return userService.getUserList();
    }

    /**
     * 查询指定用户
     *
     * @param id 用户ID
     * @return User
     */
    @GetMapping("/{id}")
    public User user(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    /**
     * 创建用户
     *
     * @param user 需创建的用户
     * @return int 创建结果
     */
    @PostMapping("new")
    public int addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    /**
     * 更新用户
     *
     * @param user 需更新的用户
     * @return int 更新结果
     */
    @PutMapping("full")
    public int updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    /**
     * 更新用户部分信息
     *
     * @param user 用户信息
     * @return int 更新结果
     */
    @PutMapping("selective")
    public int updateUserSelective(@RequestBody User user) {
        return userService.updateUserSelective(user);
    }

    @GetMapping("test")
    public void updateUserSelectiveTest() {
        testService.testTransactional();
    }
}
