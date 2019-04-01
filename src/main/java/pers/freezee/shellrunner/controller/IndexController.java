package pers.freezee.shellrunner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

/**
 * @Description :
 * @Author: 王东杰
 * @Date: Created in 2019/3/29 17:26
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
        return "index";
    }

}
