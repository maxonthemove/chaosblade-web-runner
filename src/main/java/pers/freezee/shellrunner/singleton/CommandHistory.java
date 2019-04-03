package pers.freezee.shellrunner.singleton;

import java.util.ArrayList;
import java.util.List;

public class CommandHistory {
    private static CommandHistory ourInstance = new CommandHistory();

    public static CommandHistory getInstance() {
        return ourInstance;
    }

    private List<String> shellList;

    private String history;

    private CommandHistory() {
        this.history = "";
        this.shellList = new ArrayList<>();
    }

    public String getHistory() {
        return history;
    }

    public void setHistory(String history) {
        this.history = history;
    }

    public List<String> getShellList() {
        return shellList;
    }

    public void setShellList(List<String> shellList) {
        this.shellList = shellList;
    }

}
