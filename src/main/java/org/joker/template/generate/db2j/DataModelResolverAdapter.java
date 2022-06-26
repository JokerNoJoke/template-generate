package org.joker.template.generate.db2j;

import org.joker.template.generate.db2j.mysql.MysqlDataModelResolver;

public class DataModelResolverAdapter implements DataModelResolver {

    private MysqlDataModelResolver mysqlDataModelHandler = new MysqlDataModelResolver();

    @Override
    public DataModel resolver(String tableSchema, String tableName) {
        String driverClassName = JdbcProperties.getDriverClassName();
        if (driverClassName.contains("mysql")) {
            return mysqlDataModelHandler.resolver(tableSchema, tableName);
        }
        throw new RuntimeException("data model resolver adapter -> unknown database: " + driverClassName);
    }

}
