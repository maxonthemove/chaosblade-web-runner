package pers.freezee.shellrunner.singleton;

import com.alibaba.fastjson.JSONObject;
import org.springframework.util.ResourceUtils;
import pers.freezee.shellrunner.entity.CommandEntity;
import pers.freezee.shellrunner.utils.FileUtil;

import java.io.FileNotFoundException;
import java.util.LinkedList;
import java.util.List;

/**
 * @Description : 读取 chaosblade 指令
 * @Author: 王东杰
 * @Date: Created in 2019/3/29 17:47
 */
public class BladeCommand {

    private static BladeCommand ourInstance = new BladeCommand();

    public static BladeCommand getInstance() {
        return ourInstance;
    }

    private BladeCommand() {
        setCommand();
    }

    private CommandEntity commandEntity;

    public CommandEntity getCommandEntity() {
        return this.commandEntity;
    }

    private void setCommand() {
        String path = "classpath:command.json";
        String result = "";
        try {
            result = FileUtil.readFile(ResourceUtils.getFile(path));
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }
        JSONObject jsonObject = JSONObject.parseObject(result);
        CommandEntity entity = new CommandEntity();
        entity.setDesc("chaos-balde");
        entity.setKey("blade");
        entity.setChildren(new LinkedList<CommandEntity>());
        entity.setChildren(setEntityList(jsonObject, entity.getChildren()));
        this.commandEntity = entity;
        System.out.println(this.commandEntity);

    }

    private List<CommandEntity> setEntityList(JSONObject jsonObject, List<CommandEntity> list) {

        for (String key : jsonObject.keySet()) {
            CommandEntity commandEntity = new CommandEntity();
            commandEntity.setKey(key);
            commandEntity.setDesc(jsonObject.getJSONObject(key).getString("desc"));
            if (null != jsonObject.getJSONObject(key).getJSONObject("children")) {
                commandEntity.setChildren(new LinkedList<CommandEntity>());
                commandEntity.setChildren(setEntityList(jsonObject.getJSONObject(key).getJSONObject("children"), commandEntity.getChildren()));
            }
            list.add(commandEntity);
        }
        return list;
    }
}
