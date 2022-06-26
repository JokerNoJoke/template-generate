    <select id="selectByEntity" resultMap="BaseResultMap">
        select *
        from ${table.tableName}
        <where>
<#list columns as column>
            <if test="${fields[column?index].fieldName} != null">
                and ${column.columnName} = ${"#\{"+fields[column?index].fieldName+"}"}
            </if>
</#list>
        </where>
    </select>