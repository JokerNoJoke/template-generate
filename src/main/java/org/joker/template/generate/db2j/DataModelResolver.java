package org.joker.template.generate.db2j;

public interface DataModelResolver {

    DataModel resolver(String tableSchema, String tableName);

}
