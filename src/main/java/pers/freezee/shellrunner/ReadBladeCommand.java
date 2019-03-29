package pers.freezee.shellrunner;

import org.springframework.boot.CommandLineRunner;
import pers.freezee.shellrunner.singleton.BladeCommand;

/**
 * @Description :
 * @Author: 王东杰
 * @Date: Created in 2019/3/29 17:45
 */
public class ReadBladeCommand implements CommandLineRunner {
    @Override
    public void run(String... args) throws Exception {
        BladeCommand.getInstance();
    }
}
