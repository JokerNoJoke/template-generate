package org.joker.template.generate.db2j;

import java.util.List;

public class DataModel {

    private Table table;
    private List<Column> columns;

    public Table getTable() {
        return table;
    }

    public void setTable(Table table) {
        this.table = table;
    }

    public List<Column> getColumns() {
        return columns;
    }

    public void setColumns(List<Column> columns) {
        this.columns = columns;
    }

}
