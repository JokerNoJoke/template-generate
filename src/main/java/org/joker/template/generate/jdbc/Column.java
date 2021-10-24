package org.joker.template.generate.jdbc;

public class Column {

    private String ordinalPosition;
    private String columnName;
    private String dataType;
    private String numericPrecision;
    private String numericScale;
    private String characterOctetLength;
    private String characterMaximumLength;
    private Boolean isNullable;
    private String columnDefault;
    private String columnComment;
    private Boolean isPrimaryKey;
    private Boolean isAutoIncrement;

    public String getOrdinalPosition() {
        return ordinalPosition;
    }

    public void setOrdinalPosition(String ordinalPosition) {
        this.ordinalPosition = ordinalPosition;
    }

    public String getColumnName() {
        return columnName;
    }

    public void setColumnName(String columnName) {
        this.columnName = columnName;
    }

    public String getDataType() {
        return dataType;
    }

    public void setDataType(String dataType) {
        this.dataType = dataType;
    }

    public String getNumericPrecision() {
        return numericPrecision;
    }

    public void setNumericPrecision(String numericPrecision) {
        this.numericPrecision = numericPrecision;
    }

    public String getNumericScale() {
        return numericScale;
    }

    public void setNumericScale(String numericScale) {
        this.numericScale = numericScale;
    }

    public String getCharacterOctetLength() {
        return characterOctetLength;
    }

    public void setCharacterOctetLength(String characterOctetLength) {
        this.characterOctetLength = characterOctetLength;
    }

    public String getCharacterMaximumLength() {
        return characterMaximumLength;
    }

    public void setCharacterMaximumLength(String characterMaximumLength) {
        this.characterMaximumLength = characterMaximumLength;
    }

    public Boolean getIsNullable() {
        return isNullable;
    }

    public void setIsNullable(Boolean isNullable) {
        this.isNullable = isNullable;
    }

    public String getColumnDefault() {
        return columnDefault;
    }

    public void setColumnDefault(String columnDefault) {
        this.columnDefault = columnDefault;
    }

    public String getColumnComment() {
        return columnComment;
    }

    public void setColumnComment(String columnComment) {
        this.columnComment = columnComment;
    }

    public Boolean getIsPrimaryKey() {
        return isPrimaryKey;
    }

    public void setIsPrimaryKey(Boolean isPrimaryKey) {
        this.isPrimaryKey = isPrimaryKey;
    }

    public Boolean getIsAutoIncrement() {
        return isAutoIncrement;
    }

    public void setIsAutoIncrement(Boolean isAutoIncrement) {
        this.isAutoIncrement = isAutoIncrement;
    }

    @Override
    public String toString() {
        return "Column{" +
                "ordinalPosition='" + ordinalPosition + '\'' +
                ", columnName='" + columnName + '\'' +
                ", dataType='" + dataType + '\'' +
                ", numericPrecision='" + numericPrecision + '\'' +
                ", numericScale='" + numericScale + '\'' +
                ", characterOctetLength='" + characterOctetLength + '\'' +
                ", characterMaximumLength='" + characterMaximumLength + '\'' +
                ", isNullable=" + isNullable +
                ", columnDefault='" + columnDefault + '\'' +
                ", columnComment='" + columnComment + '\'' +
                ", isPrimaryKey=" + isPrimaryKey +
                ", isAutoIncrement=" + isAutoIncrement +
                '}';
    }

}
