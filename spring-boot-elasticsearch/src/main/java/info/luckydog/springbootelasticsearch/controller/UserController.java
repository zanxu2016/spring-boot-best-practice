package info.luckydog.springbootelasticsearch.controller;

import info.luckydog.springbootelasticsearch.dao.UserRepository;
import info.luckydog.springbootelasticsearch.entity.User;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/user")
@Slf4j
public class UserController {

    @Autowired
    private UserRepository userRepository;

    @PostMapping("")
    public User save1(@RequestBody User user) {
        log.info("user save1...");
        return userRepository.save(user);
    }

    @GetMapping("")
    public Iterable<User> findAll1() {
        return userRepository.findAll();
    }

    @GetMapping("/{name}")
    public User findOne1(@PathVariable String name) {
        return userRepository.findByName(name);
    }
}
