package ${entity.packageName};

import java.io.Serializable;

<#if entity.classComment?length gt 0>
/**
 * ${entity.classComment}
 */
</#if>
public class ${entity.className} implements Serializable {

<#list fields as field>
    <#if field.fieldComment?length gt 0>
    /**
     * ${field.fieldComment}
     */
    </#if>
    private ${field.type.className} ${field.fieldName};
</#list>
<#list fields as field>

    public ${field.type.className} get${field.fieldName?cap_first}() {
        return ${field.fieldName};
    }

    public void set${field.fieldName?cap_first}(${field.type.className} ${field.fieldName}) {
        this.${field.fieldName} = ${field.fieldName};
    }
</#list>

}
