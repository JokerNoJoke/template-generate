package org.joker.template.generate.mybatis;

import org.joker.template.generate.java.JavaTypeResolverAdapter;
import org.joker.template.generate.jdbc.Column;
import org.joker.template.generate.util.NameCaseUtil;

public class MybatisFieldModel {

    private static final JavaTypeResolverAdapter JAVA_TYPE_RESOLVER_ADAPTER = new JavaTypeResolverAdapter();
    private static final String GET_STRING = "get";
    private static final String SET_STRING = "set";

    private Column column;

    public MybatisFieldModel(Column column) {
        this.column = column;
    }

    public String getJavaType() {
        String dataType = column.getDataType();
        return JAVA_TYPE_RESOLVER_ADAPTER.resolver(dataType).getTypeName();
    }

    public String getFieldName() {
        String columnName = column.getColumnName();
        return NameCaseUtil.underlineToCamelLowerCase(columnName);
    }

    public String getComment() {
        return column.getColumnComment().trim();
    }

    public String getFieldGetterName() {
        String columnName = column.getColumnName();
        return GET_STRING + NameCaseUtil.underlineToCamelUpperCase(columnName);
    }

    public String getFieldSetterName() {
        String columnName = column.getColumnName();
        return SET_STRING + NameCaseUtil.underlineToCamelUpperCase(columnName);
    }

    public boolean getIsPrimaryKey() {
        return column.getIsPrimaryKey();
    }

    public String getColumnName() {
        return column.getColumnName();
    }

    public String getColumnType() {
        return column.getDataType().toUpperCase();
    }

}
