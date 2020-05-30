package info.luckydog.springboot.paramvalid.controller;

import info.luckydog.springboot.paramvalid.model.ResultDTO;
import info.luckydog.springboot.paramvalid.model.UserDTO;
import info.luckydog.springboot.paramvalid.validator.group.Update;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;
import javax.validation.constraints.NotNull;

/**
 * UserController
 *
 * @author eric
 * @since 2019/12/19
 */
@RestController
@RequestMapping("user")
@Validated
public class UserController {

    /**
     * 用户注册
     * 测试 @Validated 参数校验
     *
     * @param userDTO
     * @return ResultDTO
     */
    @PostMapping("")
    public ResultDTO userRegister(@RequestBody @Validated UserDTO userDTO) {
        return ResultDTO.success();
    }

    /**
     * 用户更新
     * 测试 @validated(Update.class) 分组参数校验
     *
     * @param userDTO
     * @return ResultDTO
     */
    @PutMapping("")
    public ResultDTO userUpdate(@RequestBody @Validated(Update.class) UserDTO userDTO) {
        return ResultDTO.success();
    }

    /**
     * 用户更新
     * 测试单个参数的校验，@Validated 需作用在 Controller 类上面
     *
     * @param userId
     * @return ResultDTO
     */
    @DeleteMapping("")
    public ResultDTO userDelete(@RequestParam("userId") @NotNull(message = "用户ID不能为空") Long userId) {
        return ResultDTO.success();
    }

    @GetMapping("receive")
    public void receiveRedirect(HttpServletRequest request) {
        System.out.println("request params: " + request.getQueryString());
    }
}
