package org.joker.template.generate.java;

public class JavaType {

    private String importPackage;
    private String typeName;

    public JavaType(String importPackage, String typeName) {
        this.importPackage = importPackage;
        this.typeName = typeName;
    }

    public String getImportPackage() {
        return importPackage;
    }

    public void setImportPackage(String importPackage) {
        this.importPackage = importPackage;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

}
