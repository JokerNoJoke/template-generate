package org.joker.template.generate;

import org.joker.template.generate.mybatis.MybatisConfig;
import org.joker.template.generate.mybatis.MybatisGenerate;

public class Main {

    public static void main(String[] args) throws Exception {
        MybatisConfig mybatisConfig = new MybatisConfig();
        mybatisConfig.setTableSchema("test");
        mybatisConfig.setTableName("test");
        mybatisConfig.setRootPackage("com.example.demo.mybatis");
        mybatisConfig.setEntityPackage("entity");
        // mybatisConfig.setEntityClass("EntityClass");
        mybatisConfig.setMapperPackage("mapper");
        // mybatisConfig.setMapperClass("MapperClass");
        // mybatisConfig.setGenerateInsert(true);
        mybatisConfig.setGenerateInsertSelective(true);
        // mybatisConfig.setGenerateUpdateByPrimaryKey(true);
        mybatisConfig.setGenerateUpdateByPrimaryKeySelective(true);
        // mybatisConfig.setGenerateDeleteByPrimaryKey(true);
        // mybatisConfig.setGenerateDeleteInPrimaryKey(true);
        mybatisConfig.setGenerateSelectByPrimaryKey(true);
        // mybatisConfig.setGenerateSelectInPrimaryKey(true);
        mybatisConfig.setGenerateSelectByEntity(true);
        new MybatisGenerate().generate(mybatisConfig);
    }

}
