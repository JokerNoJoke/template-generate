package org.joker.template.generate.mybatis;

import java.util.List;

import org.joker.template.generate.db2j.Class;
import org.joker.template.generate.db2j.Column;
import org.joker.template.generate.db2j.Field;
import org.joker.template.generate.db2j.Table;

public class MybaitsDataModel {

    private MybatisConfig config;
    private Table table;
    private List<Column> columns;
    private Class entity;
    private Class mapper;
    private List<Field> fields;

    public MybatisConfig getConfig() {
        return config;
    }

    public void setConfig(MybatisConfig config) {
        this.config = config;
    }

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

    public Class getEntity() {
        return entity;
    }

    public void setEntity(Class entity) {
        this.entity = entity;
    }

    public Class getMapper() {
        return mapper;
    }

    public void setMapper(Class mapper) {
        this.mapper = mapper;
    }

    public List<Field> getFields() {
        return fields;
    }

    public void setFields(List<Field> fields) {
        this.fields = fields;
    }

}
