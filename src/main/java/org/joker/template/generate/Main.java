package org.joker.template.generate;

import freemarker.template.TemplateException;
import org.joker.template.generate.mybatis.MybatisGenerate;

import java.io.IOException;

public class Main {

    public static void main(String[] args) throws TemplateException, IOException {
        MybatisGenerate.process("com.xxx", "xxx", "xxx");
    }

}
