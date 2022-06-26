    <update id="updateByPrimaryKey">
        update ${table.tableName}
        <set>
<#list columns as column>
    <#if column.isPrimaryKey>
        <#continue>
    </#if>
            ${column.columnName} = ${"#\{"+fields[column?index].fieldName+"}"},
</#list>
        </set>
        where ${columns[0].columnName} = ${"#\{"+fields[0].fieldName+"}"}
    </update>