package info.luckydog.springboot.propconfig.config;

import lombok.Data;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * WechatValueConfig
 *
 * Component + Value 注解
 * ${xxx.yyy.zzz}
 *
 * @author eric
 * @since 2020/1/9
 */
@Component
@Data
public class WechatValueConfig {

    @Value("${wechat.yuxiaoer.appId}")
    private String yxrAppId;
}
