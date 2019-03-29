package pers.freezee.shellrunner;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Description :
 * @Author: 王东杰
 * @Date: Created in 2019/3/29 16:58
 */
@Controller
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/test")
    public String runShell() {
        return "success";
    }
}
