package pers.freezee.shellrunner;

import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;
import pers.freezee.shellrunner.singleton.BladeCommand;
import pers.freezee.shellrunner.singleton.CommandExample;
import pers.freezee.shellrunner.singleton.CommandHistory;

/**
 * @Description : 服务启动前加载 单例
 * @Author: 王东杰
 * @Date: Created in 2019/3/29 17:45
 */
@Component
public class ReadBladeCommandRunner implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        BladeCommand.getInstance();
        CommandHistory.getInstance();
        CommandExample.getInstance();
    }
}
