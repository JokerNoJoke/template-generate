package org.joker.template.generate.mybatis;

import org.apache.commons.lang3.StringUtils;

public class MybatisConfig {

    private String tableSchema = "";
    private String tableName = "";
    private String rootPackage = "";
    private String entityPackage = "entity";
    private String entityClass = "";
    private String mapperPackage = "mapper";
    private String mapperClass = "";
    private boolean generateInsert = false;
    private boolean generateInsertSelective = false;
    private boolean generateUpdateByPrimaryKey = false;
    private boolean generateUpdateByPrimaryKeySelective = false;
    private boolean generateDeleteByPrimaryKey = false;
    private boolean generateDeleteInPrimaryKey = false;
    private boolean generateSelectByPrimaryKey = false;
    private boolean generateSelectInPrimaryKey = false;
    private boolean generateSelectByEntity = false;

    public String getTableSchema() {
        return tableSchema;
    }

    public void setTableSchema(String tableSchema) {
        this.tableSchema = tableSchema;
    }

    public String getTableName() {
        return tableName;
    }

    public void setTableName(String tableName) {
        this.tableName = tableName;
    }

    public String getRootPackage() {
        return rootPackage;
    }

    public void setRootPackage(String rootPackage) {
        this.rootPackage = rootPackage;
    }

    public String getEntityPackage() {
        if (StringUtils.isBlank(rootPackage)) {
            return entityPackage;
        } else {
            return String.format("%s.%s", rootPackage, entityPackage);
        }
    }

    public void setEntityPackage(String entityPackage) {
        this.entityPackage = entityPackage;
    }

    public String getEntityClass() {
        return entityClass;
    }

    public void setEntityClass(String entityClass) {
        this.entityClass = entityClass;
    }

    public String getMapperPackage() {
        if (StringUtils.isBlank(rootPackage)) {
            return mapperPackage;
        } else {
            return String.format("%s.%s", rootPackage, mapperPackage);
        }
    }

    public void setMapperPackage(String mapperPackage) {
        this.mapperPackage = mapperPackage;
    }

    public String getMapperClass() {
        return mapperClass;
    }

    public void setMapperClass(String mapperClass) {
        this.mapperClass = mapperClass;
    }

    public boolean isGenerateInsert() {
        return generateInsert;
    }

    public void setGenerateInsert(boolean generateInsert) {
        this.generateInsert = generateInsert;
    }

    public boolean isGenerateInsertSelective() {
        return generateInsertSelective;
    }

    public void setGenerateInsertSelective(boolean generateInsertSelective) {
        this.generateInsertSelective = generateInsertSelective;
    }

    public boolean isGenerateUpdateByPrimaryKey() {
        return generateUpdateByPrimaryKey;
    }

    public void setGenerateUpdateByPrimaryKey(boolean generateUpdateByPrimaryKey) {
        this.generateUpdateByPrimaryKey = generateUpdateByPrimaryKey;
    }

    public boolean isGenerateUpdateByPrimaryKeySelective() {
        return generateUpdateByPrimaryKeySelective;
    }

    public void setGenerateUpdateByPrimaryKeySelective(boolean generateUpdateByPrimaryKeySelective) {
        this.generateUpdateByPrimaryKeySelective = generateUpdateByPrimaryKeySelective;
    }

    public boolean isGenerateDeleteByPrimaryKey() {
        return generateDeleteByPrimaryKey;
    }

    public void setGenerateDeleteByPrimaryKey(boolean generateDeleteByPrimaryKey) {
        this.generateDeleteByPrimaryKey = generateDeleteByPrimaryKey;
    }

    public boolean isGenerateDeleteInPrimaryKey() {
        return generateDeleteInPrimaryKey;
    }

    public void setGenerateDeleteInPrimaryKey(boolean generateDeleteInPrimaryKey) {
        this.generateDeleteInPrimaryKey = generateDeleteInPrimaryKey;
    }

    public boolean isGenerateSelectByPrimaryKey() {
        return generateSelectByPrimaryKey;
    }

    public void setGenerateSelectByPrimaryKey(boolean generateSelectByPrimaryKey) {
        this.generateSelectByPrimaryKey = generateSelectByPrimaryKey;
    }

    public boolean isGenerateSelectInPrimaryKey() {
        return generateSelectInPrimaryKey;
    }

    public void setGenerateSelectInPrimaryKey(boolean generateSelectInPrimaryKey) {
        this.generateSelectInPrimaryKey = generateSelectInPrimaryKey;
    }

    public boolean isGenerateSelectByEntity() {
        return generateSelectByEntity;
    }

    public void setGenerateSelectByEntity(boolean generateSelectByEntity) {
        this.generateSelectByEntity = generateSelectByEntity;
    }

}
