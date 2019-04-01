package pers.freezee.shellrunner.utils;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

public class FileUtil {
    public static String readFile(File file) {
        StringBuilder stringBuilder = new StringBuilder();
        try (FileReader reader = new FileReader(file);
             BufferedReader br = new BufferedReader(reader) // 建立一个对象，它把文件内容转成计算机能读懂的语言
        ) {
            String line;
            while ((line = br.readLine()) != null) {
                System.out.println(line);
                stringBuilder.append(line);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return stringBuilder.toString();
    }
}
