package org.joker.template.generate.db2j;

import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.datasource.SingleConnectionDataSource;

public final class JdbcUtil {

    private static JdbcTemplate jdbcTemplate;

    public static JdbcTemplate getJdbcTemplate() {
        if (jdbcTemplate == null) {
            synchronized (JdbcUtil.class) {
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
