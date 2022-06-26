    <select id="selectByPrimaryKey" resultMap="BaseResultMap">
        select *
        from ${table.tableName}
        where ${columns[0].columnName} = ${"#\{"+fields[0].fieldName+"}"}
    </select>