package pers.freezee.shellrunner.singleton;

import pers.freezee.shellrunner.utils.ClassPathResourceReader;

public class CommandExample {
    private static CommandExample ourInstance = new CommandExample();

    public static CommandExample getInstance() {
        return ourInstance;
    }


    private String example;


    private CommandExample() {
        String path = "command-example";
        this.example = new ClassPathResourceReader(path).getContent().replaceAll("\n","<br>");
    }

    public String getExample() {
        return example;
    }

}
