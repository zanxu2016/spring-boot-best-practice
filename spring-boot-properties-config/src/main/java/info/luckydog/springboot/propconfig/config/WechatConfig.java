package info.luckydog.springboot.propconfig.config;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * WechatConfig
 *
 * Component + ConfigurationProperties(prefix) 注解
 *
 * @author eric
 * @since 2020/1/7
 */

@Component
@ConfigurationProperties(prefix = "wechat")
@Data
public class WechatConfig {

    // 变量名与yml文件中的参数名一致即可
    private YxrProps yuxiaoer;
    private BuerzuProps buerzu;
    private String contextUrl;
    private String woaRouteUrl;
    private String wxaRouteUrl;
    private String authorizeUrl;

    @Data
    public static class YxrProps {
        private String appId;
        private String appSecret;
        private String token;
        private String encrypt;
        private String aesKey;
        private String redirectUri;
    }

    @Data
    public static class BuerzuProps {
        private String name;
        private String wechatId;
        private String appId;
        private String appSecret;
        private String token;
        private String encrypt;
        private String aesKey;
        private String redirectUri;
    }
}

