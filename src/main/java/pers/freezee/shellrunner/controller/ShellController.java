package pers.freezee.shellrunner.controller;

import com.alibaba.fastjson.JSONObject;
import freemarker.template.utility.DateUtil;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;
import pers.freezee.shellrunner.singleton.BladeCommand;
import pers.freezee.shellrunner.singleton.CommandExample;
import pers.freezee.shellrunner.singleton.CommandHistory;
import pers.freezee.shellrunner.utils.ShellCommand;

import java.text.SimpleDateFormat;
import java.util.*;

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
        String originShell = shell;
        modelAndView.addObject("shell", shell);
        if (StringUtils.isEmpty(shell)) {
            modelAndView.addObject("messageList", new ArrayList<>());
            modelAndView.addObject("commandList", JSONObject.toJSONString(BladeCommand.getInstance().getCommandList("blade")));
            modelAndView.addObject("history",CommandHistory.getInstance().getHistory());
            modelAndView.addObject("example", CommandExample.getInstance().getExample());
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

        CommandHistory.getInstance().setHistory(setHistory(originShell,result));
        modelAndView.addObject("history",CommandHistory.getInstance().getHistory());
        modelAndView.addObject("example", CommandExample.getInstance().getExample());

        return modelAndView;
    }

    private String setHistory(String shell, List<String> result) {
        String history = CommandHistory.getInstance().getHistory();
        CommandHistory.getInstance().getShellList().add(shell);
        StringBuilder builder = new StringBuilder();
        builder.append(history);
        builder.append("<br>******************************************<br>");
        builder.append(new SimpleDateFormat("YYYY-MM-dd HH:mm:ss").format(new Date())+"<br>");
        builder.append("命令: "+shell+"<br>");
        builder.append("输出: <br>");
        if(result.size()>0){
            for (int i = 0; i < result.size(); i++) {
                builder.append(result.get(i));
                builder.append("<br>");
            }
        }
        builder.append("******************************************<br>");
        return builder.toString();
    }

}
