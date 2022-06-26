package org.joker.template.generate.db2j;

import org.joker.template.generate.db2j.mysql.MysqlDataTypeResolver;

public class DataTypeResolverAdapter implements DataTypeResolver {

    private MysqlDataTypeResolver mysqlDataTypeResolver = new MysqlDataTypeResolver();

    @Override
    public DataType resolver(String dataType) {
        String driverClassName = JdbcProperties.getDriverClassName();
        if (driverClassName.contains("mysql")) {
            return mysqlDataTypeResolver.resolver(dataType);
        }
        throw new RuntimeException("data type resolver adapter -> unknown database: " + driverClassName);
    }

}
