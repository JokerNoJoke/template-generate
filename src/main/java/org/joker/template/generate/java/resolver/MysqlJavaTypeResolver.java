package org.joker.template.generate.java.resolver;

import org.joker.template.generate.java.JavaType;
import org.joker.template.generate.java.JavaTypeResolver;

public class MysqlJavaTypeResolver implements JavaTypeResolver {

    @Override
    public JavaType resolver(String dataType) {
        if (dataType == null) {
            throw new RuntimeException("mysql java type resolver -> dataType is NULL");
        }
        switch (dataType.toUpperCase()) {
            case "TINYINT":
                return new JavaType("", "Boolean");
            case "INT":
                return new JavaType("", "Integer");
            case "BIGINT":
                return new JavaType("", "Long");
            case "DECIMAL":
                return new JavaType("java.math.BigDecimal", "BigDecimal");
            case "CHAR":
                return new JavaType("", "Character");
            case "VARCHAR":
                return new JavaType("", "String");
            case "DATE":
                return new JavaType("java.time.LocalDate", "LocalDate");
            case "DATETIME":
                return new JavaType("java.time.LocalDateTime", "LocalDateTime");
            default:
                throw new RuntimeException("mysql java type resolver -> unknown dataType: " + dataType);
        }
    }

}
