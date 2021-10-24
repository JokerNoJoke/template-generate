package org.joker.template.generate.jdbc.resolver;

import org.joker.template.generate.jdbc.AbstractDataModelResolver;
import org.joker.template.generate.jdbc.Column;
import org.joker.template.generate.jdbc.Table;

import java.util.List;

public class MysqlDataModelResolver extends AbstractDataModelResolver {

    private static final String SQL_FORMAT = """
            select *
            from information_schema.COLUMNS
            where TABLE_SCHEMA = '%s'
              and TABLE_NAME = '%s'
            order by ORDINAL_POSITION;
            """;

    @Override
    public Table resolver(String tableSchema, String tableName) {
        String sql = String.format(SQL_FORMAT, tableSchema, tableName);
        Table table = new Table();
        table.setTableSchema(tableSchema);
        table.setTableName(tableName);
        List<Column> columnList = super.getJdbcTemplate().query(sql, (rs, rowNum) -> {
            Column column = new Column();
            column.setOrdinalPosition(rs.getString("ORDINAL_POSITION"));
            column.setColumnName(rs.getString("COLUMN_NAME"));
            column.setDataType(rs.getString("DATA_TYPE"));
            column.setNumericPrecision(rs.getString("NUMERIC_PRECISION"));
            column.setNumericScale(rs.getString("NUMERIC_SCALE"));
            column.setCharacterOctetLength(rs.getString("CHARACTER_OCTET_LENGTH"));
            column.setCharacterMaximumLength(rs.getString("CHARACTER_MAXIMUM_LENGTH"));
            column.setIsNullable("YES".equalsIgnoreCase(rs.getString("IS_NULLABLE")));
            column.setColumnDefault(rs.getString("COLUMN_DEFAULT"));
            column.setColumnComment(rs.getString("COLUMN_COMMENT"));
            column.setIsPrimaryKey("PRI".equalsIgnoreCase(rs.getString("COLUMN_KEY")));
            column.setIsAutoIncrement("auto_increment".equalsIgnoreCase(rs.getString("EXTRA")));
            return column;
        });
        table.setColumnList(columnList);
        return table;
    }

}
