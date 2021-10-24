package ${packageName};

import java.io.Serializable;

public class ${javaBeanName} implements Serializable {

<#list fieldList as item>
    <#if item.comment?length gt 0>
    /**
     * ${item.comment}
     */
    </#if>
    private ${item.javaType} ${item.fieldName};
</#list>
<#list fieldList as item>

    public ${item.javaType} ${item.fieldGetterName}() {
        return ${item.fieldName};
    }

    public void ${item.fieldSetterName}(${item.javaType} ${item.fieldName}) {
        this.${item.fieldName} = ${item.fieldName};
    }
</#list>

}
