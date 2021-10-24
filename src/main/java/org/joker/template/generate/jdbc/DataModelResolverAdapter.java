package org.joker.template.generate.jdbc;

import org.joker.template.generate.jdbc.resolver.MysqlDataModelResolver;

public class DataModelResolverAdapter implements DataModelResolver {

    private MysqlDataModelResolver mysqlDataModelHandler = new MysqlDataModelResolver();

    @Override
    public Table resolver(String tableSchema, String tableName) {
        String driverClassName = JdbcProperties.getDriverClassName();
        if (driverClassName.contains("mysql")) {
            return mysqlDataModelHandler.resolver(tableSchema, tableName);
        }
        throw new RuntimeException("data model resolver adapter -> unknown database: " + driverClassName);
    }

}
