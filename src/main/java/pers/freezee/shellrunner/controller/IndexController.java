package pers.freezee.shellrunner.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.ModelAndView;
import pers.freezee.shellrunner.singleton.BladeCommand;
import pers.freezee.shellrunner.singleton.CommandExample;
import pers.freezee.shellrunner.singleton.CommandHistory;

import java.util.ArrayList;

/**
 * @Description : 首页
 * @Author: 王东杰
 * @Date: Created in 2019/3/29 17:26
 */
@Controller
@RequestMapping("/")
public class IndexController {
    @RequestMapping("/index")
    public String index() {
        return "index";
    }


    @RequestMapping({"/","/command"})
    public ModelAndView command() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("command");
        modelAndView.addObject("messageList", new ArrayList<>());
        modelAndView.addObject("shell", "");
        modelAndView.addObject("commandList", JSONObject.toJSONString(BladeCommand.getInstance().getCommandList("blade")));
        modelAndView.addObject("history", CommandHistory.getInstance().getHistory());
        modelAndView.addObject("example", CommandExample.getInstance().getExample());
        return modelAndView;
    }

    @RequestMapping("/easy")
    public ModelAndView easy() {
        ModelAndView modelAndView = new ModelAndView();
        modelAndView.setViewName("easy");
        modelAndView.addObject("messageList", new ArrayList<>());
        modelAndView.addObject("shell", "");
        modelAndView.addObject("commandList", JSONObject.toJSONString(BladeCommand.getInstance().getCommandList("blade")));
        modelAndView.addObject("history", CommandHistory.getInstance().getHistory());
        modelAndView.addObject("example", CommandExample.getInstance().getExample());
        return modelAndView;
    }

}
