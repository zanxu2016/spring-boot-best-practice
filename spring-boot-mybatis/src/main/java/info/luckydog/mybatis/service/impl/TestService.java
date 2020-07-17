package info.luckydog.mybatis.service.impl;

import info.luckydog.mybatis.entity.User;
import info.luckydog.mybatis.service.UserService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
@Slf4j
public class TestService {
    @Autowired
    private UserService userService;

    @Autowired
    private TestService testService;

    @Transactional
    public void testTransactional() {
        methodA();
//        testService.methodA();
    }

//    @Transactional
    public void methodA() {
        System.out.println("aaa");
        methodB();
    }

    //    @Transactional
    public void methodB() {
        System.out.println("bbb");
        User user = new User();
        user.setId(2L);
        user.setRemark("111111");
        userService.updateUserSelective(user);
        int a = 1 / 0;
    }
}
