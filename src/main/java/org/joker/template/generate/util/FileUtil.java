package org.joker.template.generate.util;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;

public class FileUtil {

    private static final String PROJECT_DIR = System.getProperty("user.dir");

    private static final String OUT_FOLDER = "/out/";

    public static Writer getWriter(String subPath) throws IOException {
        File file = new File(PROJECT_DIR + OUT_FOLDER + subPath);
        if (!file.getParentFile().exists()) {
            file.getParentFile().mkdirs();
        }
        if (file.exists()) {
            file.delete();
            file.createNewFile();
        }
        FileOutputStream fileOutputStream = new FileOutputStream(file);
        return new OutputStreamWriter(fileOutputStream, "UTF-8");
    }

}
