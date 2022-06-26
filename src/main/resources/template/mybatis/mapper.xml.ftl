<?xml version="1.0" encoding="UTF-8"?>
<!DOCTYPE mapper PUBLIC "-//mybatis.org//DTD Mapper 3.0//EN" "http://mybatis.org/dtd/mybatis-3-mapper.dtd">

<mapper namespace="${mapper.classFullName}">
    <resultMap id="BaseResultMap" type="${entity.classFullName}">
<#list columns as column>
    <#if column.isPrimaryKey>
        <id column="${column.columnName}" property="${fields[column?index].fieldName}"/>
    <#else>
        <result column="${column.columnName}" property="${fields[column?index].fieldName}"/>
    </#if>
</#list>
    </resultMap>

<#if config.generateInsert>
<#include "./xml/insert.ftl"><#nt>

</#if>
<#if config.generateInsertSelective>
<#include "./xml/insertSelective.ftl"><#nt>

</#if>
<#if config.generateUpdateByPrimaryKey>
<#include "./xml/updateByPrimaryKey.ftl"><#nt>

</#if>
<#if config.generateUpdateByPrimaryKeySelective>
<#include "./xml/updateByPrimaryKeySelective.ftl"><#nt>

</#if>
<#if config.generateDeleteByPrimaryKey>
<#include "./xml/deleteByPrimaryKey.ftl"><#nt>

</#if>
<#if config.generateDeleteInPrimaryKey>
<#include "./xml/deleteInPrimaryKey.ftl"><#nt>

</#if>
<#if config.generateSelectByPrimaryKey>
<#include "./xml/selectByPrimaryKey.ftl"><#nt>

</#if>
<#if config.generateSelectInPrimaryKey>
<#include "./xml/selectInPrimaryKey.ftl"><#nt>

</#if>
<#if config.generateSelectByEntity>
<#include "./xml/selectByEntity.ftl"><#nt>

</#if>
</mapper>