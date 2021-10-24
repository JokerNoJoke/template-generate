package org.joker.template.generate.jdbc;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public abstract class AbstractDataModelResolver implements DataModelResolver {

    private volatile JdbcTemplate jdbcTemplate;

    protected JdbcTemplate getJdbcTemplate() {
        if (jdbcTemplate == null) {
            synchronized (AbstractDataModelResolver.class) {
                if (jdbcTemplate == null) {
                    SingleConnectionDataSource dataSource = new SingleConnectionDataSource();
                    dataSource.setDriverClassName(JdbcProperties.getDriverClassName());
                    dataSource.setUrl(JdbcProperties.getUrl());
                    dataSource.setUsername(JdbcProperties.getUsername());
                    dataSource.setPassword(JdbcProperties.getPassword());
                    return new JdbcTemplate(dataSource);
                }
            }
        }
        return jdbcTemplate;
    }

}
