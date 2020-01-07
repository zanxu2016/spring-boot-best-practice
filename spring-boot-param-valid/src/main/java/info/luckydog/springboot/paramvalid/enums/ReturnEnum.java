package info.luckydog.springboot.paramvalid.enums;

/**
 * ReturnEnum
 *
 * @author eric
 * @since 2019/12/19
 */
public enum ReturnEnum {
    SUCCESS(0, "成功"),
    FAILURE(1, "失败"),
    ;
    private int code;
    private String msg;

    ReturnEnum(int code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
