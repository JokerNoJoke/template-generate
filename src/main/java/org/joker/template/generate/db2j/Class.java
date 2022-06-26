package org.joker.template.generate.db2j;

import org.apache.commons.lang3.StringUtils;

public class Class {

    private String packageName;
    private String className;
    private String classComment;

    public String getPackageName() {
        return packageName;
    }

    public void setPackageName(String packageName) {
        this.packageName = packageName;
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

    public void setClassName(String className) {
        this.className = className;
    }

    public String getClassComment() {
        return classComment;
    }

    public void setClassComment(String classComment) {
        this.classComment = classComment;
    }

}
