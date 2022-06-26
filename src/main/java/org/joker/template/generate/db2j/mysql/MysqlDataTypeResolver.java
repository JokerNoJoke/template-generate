package org.joker.template.generate.db2j.mysql;

import org.joker.template.generate.db2j.DataType;
import org.joker.template.generate.db2j.DataTypeResolver;

public class MysqlDataTypeResolver implements DataTypeResolver {

    @Override
    public DataType resolver(String dataType) {
        if (dataType == null) {
            throw new RuntimeException("mysql java type resolver -> dataType is NULL");
        }
        switch (dataType.toUpperCase()) {
            case "TINYINT":
                return new DataType("", "Integer");
            case "INT":
                return new DataType("", "Integer");
            case "BIGINT":
                return new DataType("", "Long");
            case "DECIMAL":
                return new DataType("java.math.BigDecimal", "BigDecimal");
            case "CHAR":
                return new DataType("", "String");
            case "VARCHAR":
                return new DataType("", "String");
            case "DATE":
                return new DataType("java.time.LocalDate", "LocalDate");
            case "DATETIME":
                return new DataType("java.time.LocalDateTime", "LocalDateTime");
            default:
                throw new RuntimeException("mysql data type resolver -> unknown dataType: " + dataType);
        }
    }

}
