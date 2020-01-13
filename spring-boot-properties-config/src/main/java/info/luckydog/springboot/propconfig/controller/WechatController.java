package info.luckydog.springboot.propconfig.controller;

import info.luckydog.springboot.propconfig.config.WechatConfig;
import info.luckydog.springboot.propconfig.config.WechatValueConfig;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

/**
 * WechatController
 *
 * @author eric
 * @since 2020/1/7
 */
@RestController
@Slf4j
public class WechatController {

    @Autowired
    private WechatConfig wechatConfig;

    @Autowired
    private WechatValueConfig wechatValueConfig;

    @GetMapping("props")
    public Object getProps(@RequestParam(value = "id", defaultValue = "0") String id) {
        log.info("getProps, id: {}", id);
        switch (id) {
            case "1":
                return wechatConfig;
            case "2":
                return wechatValueConfig;
            default:
                return null;
        }
    }
}
