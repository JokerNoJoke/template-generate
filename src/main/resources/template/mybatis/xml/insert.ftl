    <insert id="insert" useGeneratedKeys="true" keyColumn="id" keyProperty="id">
        insert into ${table.tableName} (
            <#nt><#rt>
<#list columns as column>
            ${column.columnName}<#sep>, <#t>
</#list><#nt>
        )
        values (
            <#nt><#rt>
<#list fields as field>
            ${"#\{"+field.fieldName+"}"}<#sep>, <#t>
</#list><#nt>
        )
    </insert>