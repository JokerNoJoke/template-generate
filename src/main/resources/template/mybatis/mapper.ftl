package ${mapper.packageName};

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ${mapper.className} {

<#if config.generateInsert>
    int insert(${entity.className} record);

</#if>
<#if config.generateInsertSelective>
    int insertSelective(${entity.className} record);

</#if>
<#if config.generateUpdateByPrimaryKey>
    int updateByPrimaryKey(${entity.className} record);

</#if>
<#if config.generateUpdateByPrimaryKeySelective>
    int updateByPrimaryKeySelective(${entity.className} record);

</#if>
<#if config.generateDeleteByPrimaryKey>
    int deleteByPrimaryKey(${fields[0].type.className} ${fields[0].fieldName});

</#if>
<#if config.generateDeleteInPrimaryKey>
    int deleteInPrimaryKey(${fields[0].type.className}... ${fields[0].fieldName+"s"});

</#if>
<#if config.generateSelectByPrimaryKey>
    ${entity.className} selectByPrimaryKey(${fields[0].type.className} ${fields[0].fieldName});

</#if>
<#if config.generateSelectInPrimaryKey>
    List<${entity.className}> selectInPrimaryKey(${fields[0].type.className}... ${fields[0].fieldName+"s"});

</#if>
<#if config.generateSelectByEntity>
    List<${entity.className}> selectByEntity(${entity.className} record);

</#if>
}
