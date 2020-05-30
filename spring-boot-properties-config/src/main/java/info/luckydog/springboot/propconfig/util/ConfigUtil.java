package info.luckydog.springboot.propconfig.util;

import info.luckydog.springboot.propconfig.config.WechatValueConfig;
import org.springframework.beans.factory.annotation.Autowired;

public class ConfigUtil {

    @Autowired
    private WechatValueConfig config;// 无法注入，因为ConfigUtil不受spring管理

    public String getProps() {
        return config.getYxrAppId();
    }
}
