    <delete id="deleteInPrimaryKey">
        delete
        from ${table.tableName}
        where 
        <choose>
            <when test="${fields[0].fieldName+"s"} != null and ${fields[0].fieldName+"s"}.lenght > 0">
                ${columns[0].columnName} in
                <foreach collection="${fields[0].fieldName+"s"}" item="${fields[0].fieldName}" open="(" close=")" separator=",">
                    ${"#\{"+fields[0].fieldName+"}"}
                </foreach>
            </when>
            <otherwise>
                1 = 2
            </otherwise>
        </choose>
    </delete>