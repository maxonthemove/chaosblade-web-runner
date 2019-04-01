package pers.freezee.shellrunner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;

/**
 * @Description : 首页
 * @Author: 王东杰
 * @Date: Created in 2019/3/29 17:26
 */
@Controller
public class IndexController {
    @RequestMapping("/")
    public String index() {
//        return "index";
        return "guide";
    }



}
