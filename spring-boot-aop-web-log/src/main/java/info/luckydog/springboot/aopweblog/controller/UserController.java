package info.luckydog.springboot.aopweblog.controller;

import info.luckydog.springboot.aopweblog.aspect.WebLog;
import info.luckydog.springboot.aopweblog.model.ResultDTO;
import info.luckydog.springboot.aopweblog.model.UserDTO;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * UserController
 *
 * @author eric
 * @since 2019/12/19
 */
@RestController
@RequestMapping("user")
@Slf4j
public class UserController {

    @PostMapping("login")
    @WebLog(description = "请求用户登录接口")
    public ResultDTO login(@RequestBody UserDTO userDTO) {
        log.info("user login...");
        return ResultDTO.success();
    }

    @GetMapping("test")
    public ResultDTO test(@ModelAttribute UserDTO userDTO) {
        log.info("user test, request params: {}", userDTO);
        return new ResultDTO<>(userDTO);
    }

    @GetMapping("send")
    public void sendRedirect(HttpServletRequest request, HttpServletResponse response) {
        System.out.println("request params: " + request.getQueryString());

        String redirectUrl = "http://localhost:8002/user/receive?test=111";

        try {
            response.sendRedirect(redirectUrl);
        } catch (IOException e) {
            e.printStackTrace();
        }

    }
}
