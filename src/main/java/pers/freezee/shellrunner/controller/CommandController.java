package pers.freezee.shellrunner.controller;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pers.freezee.shellrunner.singleton.BladeCommand;
import pers.freezee.shellrunner.singleton.CommandHistory;

@RestController
@RequestMapping("/")
public class CommandController {

    @RequestMapping("/getCommand")
    public String getCommandEntity(@RequestParam String shell) {
        if (StringUtils.isEmpty(shell)) {
            return "[]";
        }
        return JSONObject.toJSONString(BladeCommand.getInstance().getCommandList(shell));
    }

    @RequestMapping("/getShellList")
    public String getShellList() {
        return JSONObject.toJSONString(CommandHistory.getInstance().getShellList());
    }
}
