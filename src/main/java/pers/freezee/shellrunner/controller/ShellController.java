package pers.freezee.shellrunner.controller;

import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pers.freezee.shellrunner.utils.ShellCommand;

import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description :
 * @Author: 王东杰
 * @Date: Created in 2019/3/29 16:58
 */
@Controller
@RequestMapping("/shell")
public class ShellController {

    @Value("${blade.path}")
    private String bladePath;

    @RequestMapping(value = "/run", method = RequestMethod.GET)
    public ModelAndView runShell(@RequestParam String shell) {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("success");
        modelAndView.addObject("shell", shell);
        ShellCommand shellCommand = new ShellCommand();

        //设置blade命令的具体地址
        if (shell.startsWith("blade")) {
            shell = shell.replace("blade", bladePath);
        } else if (shell.startsWith("./blade")) {
            shell = shell.replace("./blade", bladePath);
        }
        shellCommand.runCommand(shell);
        List<String> result = new LinkedList<>();
        result.addAll(Arrays.asList(shellCommand.getResponseString().split("OUTPUT>")));

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        result.addAll(Arrays.asList(shellCommand.getErrorString().split("ERROR>")));
        modelAndView.addObject("messageList", result);

        return modelAndView;
    }
}
