package pers.freezee.shellrunner;

import com.alibaba.fastjson.JSONObject;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.util.ResourceUtils;
import pers.freezee.shellrunner.entity.CommandEntity;
import pers.freezee.shellrunner.singleton.BladeCommand;
import pers.freezee.shellrunner.utils.FileUtil;
import pers.freezee.shellrunner.utils.ShellCommand;

import java.io.FileNotFoundException;
import java.util.Arrays;
import java.util.LinkedList;
import java.util.List;

@RunWith(SpringRunner.class)
@SpringBootTest
public class ShellRunnerApplicationTests {

    @Autowired
    ShellCommand shellCommand;

    @Test
    public void contextLoads() {

    }

    /**
     * 打印chaos-blade全部命令
     */
    @Test
    public void writeCommand() {
        JSONObject jsonObject = new JSONObject();
        String shell = "/home/sofar/go/src/github.com/chaosblade-io/chaosblade/target/chaosblade-0.0.1/blade";
        readCommand(shell, jsonObject);
        System.out.println(jsonObject.toJSONString());
    }

    /**
     * 递归方法,逐层读取命令
     *
     * @param shell      命令参数
     * @param jsonObject 对象引用
     */
    private void readCommand(String shell, JSONObject jsonObject) {

        if (shell.endsWith("--help")) {
            shell = shell.replaceAll("--help", "").trim();
        }
        shellCommand.runCommand(shell + " --help");
        List<String> result = new LinkedList<>();
        result.addAll(Arrays.asList(shellCommand.getResponseString().split("OUTPUT>")));
        //连续调用两次shellCommand会出现空指针..此处强制系统休眠0.1秒.
        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        result.addAll(Arrays.asList(shellCommand.getErrorString().split("ERROR>")));


        boolean store = false;
        for (int i = 0; i < result.size(); i++) {
            if (store) {
                if (result.get(i).contains("Flags:")) {
                    store = false;
                    continue;
                }
                if (result.get(i).length() < 5) {
                    continue;
                } else {
                    System.out.println(result.get(i));
                    JSONObject childJson = new JSONObject();
                    childJson.put("children", new JSONObject());
                    childJson.put("desc", result.get(i).trim().substring(result.get(i).trim().indexOf(" ")).trim());
                    String key = result.get(i).trim().substring(0, result.get(i).trim().indexOf(" "));
                    jsonObject.put(key, childJson);
                    readCommand(shell + " " + result.get(i).trim().substring(0, result.get(i).trim().indexOf(" ")) + " --help", jsonObject.getJSONObject(key).getJSONObject("children"));
                }
            } else {
                if (result.get(i).contains("Available Commands:")) {
                    store = true;
                }
            }
        }
    }

    /**
     * 读取文件测试
     */
    @Test
    public void fileReadTest() {
        String result = "";
        try {
            FileUtil.readFile(ResourceUtils.getFile("classpath:command.json"));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        System.out.println(result);
    }

}
