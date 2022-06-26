package org.joker.template.generate.db2j;

import org.apache.commons.lang3.StringUtils;

public class DataType {

    private String packageName;
    private String className;

    public DataType(String packageName, String className) {
        this.packageName = packageName;
        this.className = className;
    }

    public String getPackageName() {
        return packageName;
    }

    public String getClassName() {
        return className;
    }

    public String getClassFullName() {
        if (StringUtils.isBlank(packageName)) {
            return className;
        } else {
            return String.format("%s.%s", packageName, className);
        }
    }

}
