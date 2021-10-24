package org.joker.template.generate.mybatis;

import freemarker.template.TemplateException;
import org.joker.template.generate.jdbc.DataModelResolverAdapter;
import org.joker.template.generate.jdbc.Table;
import org.joker.template.generate.util.FileUtil;
import org.joker.template.generate.util.TemplateUtil;

import java.io.IOException;

public class MybatisGenerate {

    private static final DataModelResolverAdapter DATA_MODEL_RESOLVER_ADAPTER = new DataModelResolverAdapter();

    public static void process(String packageName, String tableSchema, String tableName) throws TemplateException, IOException {
        Table table = DATA_MODEL_RESOLVER_ADAPTER.resolver(tableSchema, tableName);
        MybatisJavaModel mybatisJavaModel = new MybatisJavaModel(packageName, table);
        TemplateUtil.process("mybatis/java_bean.ftl", mybatisJavaModel, FileUtil.getWriter(mybatisJavaModel.getJavaBeanFileName()));
        TemplateUtil.process("mybatis/mybatis_mapper.ftl", mybatisJavaModel, FileUtil.getWriter(mybatisJavaModel.getMybatisMapperFileName()));
        TemplateUtil.process("mybatis/mybatis_mapper_xml.ftl", mybatisJavaModel, FileUtil.getWriter(mybatisJavaModel.getMybatisMapperXmlFileName()));
    }

}
