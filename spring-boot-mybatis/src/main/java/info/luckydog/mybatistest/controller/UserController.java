package info.luckydog.mybatistest.controller;

import info.luckydog.mybatistest.entity.User;
import info.luckydog.mybatistest.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @GetMapping("list")
    public List<User> userList() {
        return userService.getUserList();
    }

    @GetMapping("/{id}")
    public User user(@PathVariable("id") Long id) {
        return userService.getUserById(id);
    }

    @PostMapping("new")
    public int addUser(@RequestBody User user) {
        return userService.addUser(user);
    }

    @PutMapping("full")
    public int updateUser(@RequestBody User user) {
        return userService.updateUser(user);
    }

    @PutMapping("selective")
    public int updateUserSelective(@RequestBody User user) {
        return userService.updateUserSelective(user);
    }
}
