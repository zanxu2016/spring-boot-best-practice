package info.luckydog.springboot.mapstruct.enums;

import java.util.Arrays;
import java.util.Optional;

/**
 * GenderEnum
 *
 * @author eric
 * @since 2020/1/13
 */
public enum GenderEnum {
    FEMALE(0, "女"),
    MALE(1, "男"),
    ;
    private int code;
    private String name;

    GenderEnum() {
    }

    GenderEnum(int code, String name) {
        this.code = code;
        this.name = name;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public static String getGenderName(int code) {
        Optional<GenderEnum> genderEnum = Arrays
                .stream(GenderEnum.values())
                .filter(item -> item.code == code)
                .findFirst();
        return genderEnum.isPresent() ? genderEnum.get().getName() : "未知";
    }
}
