package info.luckydog.springboot.aopweblog.model;

import info.luckydog.springboot.aopweblog.enums.ReturnEnum;
import lombok.AllArgsConstructor;
import lombok.Data;

/**
 * ResultDTO
 *
 * @author eric
 * @since 2019/12/19
 */
@Data
@AllArgsConstructor
public class ResultDTO<T> {

    private int code;
    private String msg;
    private T data;

    public static ResultDTO success() {
        return new ResultDTO<>(ReturnEnum.SUCCESS);
    }

    public static ResultDTO failure() {
        return new ResultDTO<>(ReturnEnum.FAILURE);
    }

    public ResultDTO(ReturnEnum returnEnum) {
        this.code = returnEnum.getCode();
        this.msg = returnEnum.getMsg();
    }

    public ResultDTO(T data) {
        this.code = ReturnEnum.SUCCESS.getCode();
        this.msg = ReturnEnum.SUCCESS.getMsg();
        this.data = data;
    }

}
