package pers.freezee.shellrunner.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pers.freezee.shellrunner.utils.ShellCommand;

/**
 * @Description :
 * @Author: 王东杰
 * @Date: Created in 2019/3/29 16:58
 */
@Controller
@RequestMapping("/shell")
public class ShellController {

    @RequestMapping(value = "/run",method = RequestMethod.GET)
    public ModelAndView runShell(@RequestParam String shell) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        modelAndView.addObject("shell",shell);
        ShellCommand shellCommand = new ShellCommand();
        shellCommand.runCommand(shell);
        modelAndView.addObject("message",shellCommand.getResponseString());
        return modelAndView;
    }
}
