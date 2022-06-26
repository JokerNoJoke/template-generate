    <delete id="deleteByPrimaryKey">
        delete
        from ${table.tableName}
        where ${columns[0].columnName} = ${"#\{"+fields[0].fieldName+"}"}
    </delete>