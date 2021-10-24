package org.joker.template.generate.mybatis;

import org.joker.template.generate.jdbc.Table;
import org.joker.template.generate.util.NameCaseUtil;

import java.util.List;

public class MybatisJavaModel {

    private String packageName;
    private Table table;

    public MybatisJavaModel(String packageName, Table table) {
        this.packageName = packageName;
        this.table = table;
    }

    public String getJavaBeanFileName() {
        return getJavaBeanName() + ".java";
    }

    public String getPackageName() {
        return packageName;
    }

    public String getJavaBeanName() {
        String tableName = table.getTableName();
        return NameCaseUtil.underlineToCamelUpperCase(tableName);
    }

    public String getMybatisMapperFileName() {
        return getJavaBeanName() + "Mapper.java";
    }

    public String getMybatisMapperName() {
        return getJavaBeanName() + "Mapper";
    }

    public String getMybatisMapperXmlFileName() {
        return getJavaBeanName() + "Mapper.xml";
    }

    public String getTableName() {
        return table.getTableName();
    }

    public List<MybatisFieldModel> getFieldList() {
        return table.getColumnList().stream()
                .map(MybatisFieldModel::new)
                .toList();
    }

}
