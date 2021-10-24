package org.joker.template.generate.jdbc;

public interface DataModelResolver {

    Table resolver(String tableSchema, String tableName);

}
