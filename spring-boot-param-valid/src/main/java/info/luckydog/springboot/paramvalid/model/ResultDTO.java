package info.luckydog.springboot.paramvalid.model;

import info.luckydog.springboot.paramvalid.enums.ReturnEnum;
import lombok.Data;

/**
 * ResultDTO
 *
 * @author eric
 * @since 2019/12/19
 */
@Data
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

    public static ResultDTO failure(String errorMsg) {
        return new ResultDTO<>(ReturnEnum.FAILURE.getCode(), errorMsg);
    }

    public ResultDTO(ReturnEnum returnEnum) {
        this.code = returnEnum.getCode();
        this.msg = returnEnum.getMsg();
    }

    public ResultDTO(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public ResultDTO(T data) {
        this.code = ReturnEnum.SUCCESS.getCode();
        this.msg = ReturnEnum.SUCCESS.getMsg();
        this.data = data;
    }

}
