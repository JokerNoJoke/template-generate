    <insert id="insertSelective" useGeneratedKeys="true" keyColumn="id" keyProperty="id">
        insert into ${table.tableName}
        <trim prefix="(" suffix=")" suffixOverrides=",">
<#list columns as column>
            <if test="${fields[column?index].fieldName} != null">
                ${column.columnName},
            </if>
</#list>
        </trim>
        <trim prefix="values (" suffix=")" suffixOverrides=",">
<#list fields as field>
            <if test="${field.fieldName} != null">
                ${"#\{"+field.fieldName+"}"},
            </if>
</#list>
        </trim>
    </insert>