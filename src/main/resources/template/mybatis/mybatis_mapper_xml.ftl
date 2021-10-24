<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="${packageName+"."+mybatisMapperName}">
    <resultMap id="BaseResultMap" type="${packageName+"."+javaBeanName}">
<#list fieldList as item>
    <#if item.isPrimaryKey>
        <id column="${item.columnName}" jdbcType="${item.columnType}" property="${item.fieldName}"/>
    <#else>
        <result column="${item.columnName}" jdbcType="${item.columnType}" property="${item.fieldName}"/>
    </#if>
</#list>
    </resultMap>

    <insert id="insert" useGeneratedKeys="true" keyColumn="id" keyProperty="id">
        insert into ${tableName} (
            <#nt><#rt>
<#list fieldList as item>
            ${item.columnName}<#sep>, <#t>
</#list><#nt>
        )
        values (
            <#nt><#rt>
<#list fieldList as item>
            ${"#\{"+item.fieldName+"}"}<#sep>, <#t>
</#list><#nt>
        )
    </insert>

    <update id="updateByPrimaryKey">
        update ${tableName}
<#list fieldList as item>
    <#if item?is_first>
        <#continue>
    <#elseif item?index == 1>
        set ${item.columnName} = ${"#\{"+item.fieldName+"}"}<#sep>,</#sep>
    <#else>
            ${item.columnName} = ${"#\{"+item.fieldName+"}"}<#sep>,</#sep>
    </#if>
</#list>
        where ${fieldList[0].columnName} = ${"#\{"+fieldList[0].fieldName+"}"}
    </update>

    <update id="updateByPrimaryKeySelective">
        update ${tableName}
        <set>
<#list fieldList as item>
    <#if item?is_first>
        <#continue>
    </#if>
            <if test="${item.fieldName} != null">
                ${item.columnName} = ${"#\{"+item.fieldName+"}"},
            </if>
</#list>
        </set>
        where ${fieldList[0].columnName} = ${"#\{"+fieldList[0].fieldName+"}"}
    </update>

    <delete id="deleteByPrimaryKey">
        delete
        from ${tableName}
        where ${fieldList[0].columnName} = ${"#\{"+fieldList[0].fieldName+"}"}
    </delete>

    <delete id="deleteInPrimaryKey">
        delete
        from ${tableName}
        where
        <if test="${fieldList[0].fieldName+"s"} == null or ${fieldList[0].fieldName+"s"}.length == 0">
            1 = 2
        </if>
        <if test="${fieldList[0].fieldName+"s"} != null and ${fieldList[0].fieldName+"s"}.length > 0">
            ${fieldList[0].columnName} in
            <foreach collection="${fieldList[0].fieldName+"s"}" item="${fieldList[0].fieldName}" open="(" close=")" separator=",">
                ${"#\{"+fieldList[0].fieldName+"}"}
            </foreach>
        </if>
    </delete>

    <select id="selectByPrimaryKey" resultMap="BaseResultMap">
        select *
        from ${tableName}
        where ${fieldList[0].columnName} = ${"#\{"+fieldList[0].fieldName+"}"}
    </select>

    <select id="selectInPrimaryKey" resultMap="BaseResultMap">
        select *
        from ${tableName}
        where
        <if test="${fieldList[0].fieldName+"s"} == null or ${fieldList[0].fieldName+"s"}.length == 0">
            1 = 2
        </if>
        <if test="${fieldList[0].fieldName+"s"} != null and ${fieldList[0].fieldName+"s"}.length > 0">
            ${fieldList[0].columnName} in
            <foreach collection="${fieldList[0].fieldName+"s"}" item="${fieldList[0].fieldName}" open="(" close=")" separator=",">
                ${"#\{"+fieldList[0].fieldName+"}"}
            </foreach>
        </if>
    </select>
</mapper>