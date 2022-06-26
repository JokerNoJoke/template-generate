    <update id="updateByPrimaryKeySelective">
        update ${table.tableName}
        <set>
<#list columns as column>
    <#if column.isPrimaryKey>
        <#continue>
    </#if>
            <if test="${fields[column?index].fieldName} != null">
                ${column.columnName} = ${"#\{"+fields[column?index].fieldName+"}"},
            </if>
</#list>
        </set>
        where ${columns[0].columnName} = ${"#\{"+fields[0].fieldName+"}"}
    </update>