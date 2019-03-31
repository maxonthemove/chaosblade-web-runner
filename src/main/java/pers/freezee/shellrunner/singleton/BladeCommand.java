package pers.freezee.shellrunner.singleton;

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
    }
}
