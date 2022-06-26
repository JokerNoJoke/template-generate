package org.joker.template.generate.db2j.mysql;

import java.util.List;
import java.util.logging.Logger;

import org.joker.template.generate.db2j.Column;
import org.joker.template.generate.db2j.DataModel;
import org.joker.template.generate.db2j.DataModelResolver;
import org.joker.template.generate.db2j.JdbcUtil;
import org.joker.template.generate.db2j.Table;

public class MysqlDataModelResolver implements DataModelResolver {

    private static final Logger LOGGER = Logger.getLogger(MysqlDataModelResolver.class.getName());

    private static final String SELECT_TABLES_SQL = """
            SELECT * FROM information_schema.TABLES
            WHERE TABLE_SCHEMA = '%s' AND TABLE_NAME = '%s';
            """;

    private static final String SELECT_COLUMNS_SQL = """
            SELECT * FROM information_schema.COLUMNS
            WHERE TABLE_SCHEMA = '%s' AND TABLE_NAME = '%s'
            ORDER BY ORDINAL_POSITION;
            """;

    @Override
    public DataModel resolver(String tableSchema, String tableName) {
        DataModel dataModel = new DataModel();
        LOGGER.info("SELECT TABLES ...");
        String selectTablesSql = String.format(SELECT_TABLES_SQL, tableSchema, tableName);
        Table table = JdbcUtil.getJdbcTemplate().queryForObject(selectTablesSql, (rs, rowNum) -> {
            Table t = new Table();
            t.setTableSchema(rs.getString("TABLE_SCHEMA"));
            t.setTableName(rs.getString("TABLE_NAME"));
            t.setTableComment(rs.getString("TABLE_COMMENT"));
            return t;
        });
        dataModel.setTable(table);
        LOGGER.info("SELECT COLUMNS ...");
        String selectColumnsSql = String.format(SELECT_COLUMNS_SQL, tableSchema, tableName);
        List<Column> columns = JdbcUtil.getJdbcTemplate().query(selectColumnsSql, (rs, rowNum) -> {
            Column c = new Column();
            c.setOrdinalPosition(rs.getString("ORDINAL_POSITION"));
            c.setColumnName(rs.getString("COLUMN_NAME"));
            c.setDataType(rs.getString("DATA_TYPE"));
            c.setNumericPrecision(rs.getString("NUMERIC_PRECISION"));
            c.setNumericScale(rs.getString("NUMERIC_SCALE"));
            c.setCharacterOctetLength(rs.getString("CHARACTER_OCTET_LENGTH"));
            c.setCharacterMaximumLength(rs.getString("CHARACTER_MAXIMUM_LENGTH"));
            c.setIsNullable("YES".equalsIgnoreCase(rs.getString("IS_NULLABLE")));
            c.setColumnDefault(rs.getString("COLUMN_DEFAULT"));
            c.setIsPrimaryKey("PRI".equalsIgnoreCase(rs.getString("COLUMN_KEY")));
            c.setIsAutoIncrement("auto_increment".equalsIgnoreCase(rs.getString("EXTRA")));
            c.setColumnComment(rs.getString("COLUMN_COMMENT"));
            return c;
        });
        dataModel.setColumns(columns);
        return dataModel;
    }

}
