package pers.freezee.shellrunner.utils;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.stream.Collectors;

import org.springframework.core.io.ClassPathResource;

public final class ClassPathResourceReader {
    /**
     * path:文件路径
     *
     * @since JDK 1.8
     */
    private final String path;

    /**
     * content:文件内容
     *
     * @since JDK 1.6
     */
    private String content;

    public ClassPathResourceReader(String path) {
        this.path = path;
    }

    public String getContent() {
        if (content == null) {
            try {
                ClassPathResource resource = new ClassPathResource(path);
                BufferedReader reader = new BufferedReader(new InputStreamReader(resource.getInputStream()));
                content = reader.lines().collect(Collectors.joining("\n"));
                reader.close();
            } catch (IOException ex) {
                throw new RuntimeException(ex);
            }
        }
        return content;
    }
}