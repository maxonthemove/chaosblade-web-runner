package pers.freezee.shellrunner.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pers.freezee.shellrunner.singleton.BladeCommand;
import pers.freezee.shellrunner.utils.ShellCommand;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description : main component
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
        modelAndView.setViewName("index");
        shell = shell.trim();
        modelAndView.addObject("shell", shell);
        if (StringUtils.isEmpty(shell)) {
            modelAndView.addObject("messageList", new ArrayList<>());
            modelAndView.addObject("commandList", JSONObject.toJSONString(BladeCommand.getInstance().getCommandList("blade")));
            return modelAndView;
        }

        modelAndView.addObject("commandList", JSONObject.toJSONString(BladeCommand.getInstance().getCommandList(shell)));
        ShellCommand shellCommand = new ShellCommand();

        //设置blade命令的具体地址
        if (shell.startsWith("blade")) {
            shell = shell.replace("blade", bladePath);
        } else if (shell.startsWith("./blade")) {
            shell = shell.replace("./blade", bladePath);
        }
        shellCommand.runCommand(shell);
        List<String> result = new LinkedList<>();
        try {
            Thread.sleep(100);
            result.addAll(Arrays.asList(shellCommand.getResponseString().split("OUTPUT>")));
            Thread.sleep(100);
            result.addAll(Arrays.asList(shellCommand.getErrorString().split("ERROR>")));
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        modelAndView.addObject("messageList", result);

        return modelAndView;
    }


}
