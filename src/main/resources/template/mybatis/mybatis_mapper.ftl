package ${packageName};

import java.util.List;

public interface ${mybatisMapperName} {

    int insert(${javaBeanName} record);

    int updateByPrimaryKey(${javaBeanName} record);

    int updateByPrimaryKeySelective(${javaBeanName} record);

    int deleteByPrimaryKey(${fieldList[0].javaType} ${fieldList[0].fieldName});

    int deleteInPrimaryKey(${fieldList[0].javaType}... ${fieldList[0].fieldName+"s"});

    ${javaBeanName} selectByPrimaryKey(${fieldList[0].javaType} ${fieldList[0].fieldName});

    List<${javaBeanName}> selectInPrimaryKey(${fieldList[0].javaType}... ${fieldList[0].fieldName+"s"});

}
