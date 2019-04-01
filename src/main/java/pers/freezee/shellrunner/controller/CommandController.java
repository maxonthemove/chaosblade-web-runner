package pers.freezee.shellrunner.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import pers.freezee.shellrunner.singleton.BladeCommand;

@RestController
@RequestMapping("/")
public class CommandController {

    @RequestMapping("/getCommand")
    public Object getCommandEntity() {
        return BladeCommand.getInstance().getCommandEntity();
    }
}
