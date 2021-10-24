package org.joker.template.generate.java;

import org.joker.template.generate.java.resolver.MysqlJavaTypeResolver;
import org.joker.template.generate.jdbc.JdbcProperties;

public class JavaTypeResolverAdapter implements JavaTypeResolver {

    private MysqlJavaTypeResolver mysqlJavaTypeResolver = new MysqlJavaTypeResolver();

    @Override
    public JavaType resolver(String dataType) {
        String driverClassName = JdbcProperties.getDriverClassName();
        if (driverClassName.contains("mysql")) {
            return mysqlJavaTypeResolver.resolver(dataType);
        }
        throw new RuntimeException("java type resolver adapter -> unknown database: " + driverClassName);
    }

}
