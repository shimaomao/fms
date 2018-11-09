<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign tableNameNew = table.tableNameNew>
<#assign tableNameNewLowerCase = table.tableNameNewLowerCase>
<#assign tableNameNewLowerCaseAll = table.tableNameNewLowerCaseAll>
<#assign pkColumn = table.firstPkColumnName>
<#assign pkColumnFirstLower = table.firstPkColumnNameFirstLower>
package ${basepackage}.${servername}.service.impl;

import ${basepackage}.${servername}.service.${tableNameNew!className}Service;
import ${basepackage}.data.common.util.SqlUtil;
import ${basepackage}.data.${servername}.repository.${tableNameNew!className}Repository;
import ${basepackage}.pojo.${servername}.entity.${tableNameNew!className};
import ${basepackage}.pojo.${servername}.vo.${tableNameNewLowerCaseAll}.${tableNameNew!className}Vo;
import ${basepackage}.${servername}.validator.${tableNameNewLowerCaseAll}.vo.${tableNameNew!className}SaveVo;
import ${basepackage}.${servername}.validator.${tableNameNewLowerCaseAll}.vo.${tableNameNew!className}ModifyVo;
import ${basepackage}.${servername}.validator.${tableNameNewLowerCaseAll}.vo.${tableNameNew!className}DeleteVo;
import ${basepackage}.${servername}.validator.${tableNameNewLowerCaseAll}.vo.${tableNameNew!className}DeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import ${basepackage}.data.base.vo.PageInfoExtend;

/**
 * @author ${username}
 * @ClassName: ${tableNameNew!className}Service
 * @Description: ${servicename}业务实现层
 */
@Service
public class ${tableNameNew!className}ServiceImpl implements ${tableNameNew!className}Service {

    /**
     * @Fields  : ${servicename}repository
     */
    @Autowired
    private ${tableNameNew!className}Repository ${tableNameNewLowerCase!classNameLower}Repository;

    /**
     * @Title:
     * @Description: 分页查询${servicename}
     * @param ${tableNameNewLowerCase!classNameLower}Vo
     * @return PageInfoExtend<${tableNameNew!className}>
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    public PageInfoExtend<${tableNameNew!className}> find${tableNameNew!className}sByPage(${tableNameNew!className}Vo ${tableNameNewLowerCase!classNameLower}Vo){
        Example example = SqlUtil.newExample(${tableNameNew!className}.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<${tableNameNew!className}> pageInfo = ${tableNameNewLowerCase!classNameLower}Repository.selectListByExamplePage(example,${tableNameNewLowerCase!classNameLower}Vo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存${servicename}
     * @param ${tableNameNewLowerCase!classNameLower}SaveVo
     * @return java.lang.String
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    public void save${tableNameNew!className}(${tableNameNew!className}SaveVo ${tableNameNewLowerCase!classNameLower}SaveVo){
        ${tableNameNewLowerCase!classNameLower}Repository.insertData(${tableNameNewLowerCase!classNameLower}SaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改${servicename}
     * @param ${tableNameNewLowerCase!classNameLower}ModifyVo
     * @return
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    public void modify${tableNameNew!className}(${tableNameNew!className}ModifyVo ${tableNameNewLowerCase!classNameLower}ModifyVo){
        ${tableNameNewLowerCase!classNameLower}Repository.updateByPrimaryKeySelectiveData(${tableNameNewLowerCase!classNameLower}ModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过${pkColumnFirstLower}删除${servicename}
     * @param ${tableNameNewLowerCase!classNameLower}DeleteVo
     * @return
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    public void delete${tableNameNew!className}(${tableNameNew!className}DeleteVo ${tableNameNewLowerCase!classNameLower}DeleteVo){
        ${tableNameNewLowerCase!classNameLower}Repository.deleteData(${tableNameNewLowerCase!classNameLower}DeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过${pkColumnFirstLower}集合删除${servicename}
     * @param ${tableNameNewLowerCase!classNameLower}DeleteListVo
     * @return
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    public void delete${tableNameNew!className}sBy${pkColumn}s(${tableNameNew!className}DeleteListVo ${tableNameNewLowerCase!classNameLower}DeleteListVo){
        ${tableNameNewLowerCase!classNameLower}Repository.deleteDataList(${tableNameNewLowerCase!classNameLower}DeleteListVo.get${pkColumn}s(),${tableNameNewLowerCase!classNameLower}DeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据${pkColumnFirstLower}获取${servicename}
     * @param ${pkColumnFirstLower}
     * @return ${tableNameNew!className}
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    public ${tableNameNew!className} find${tableNameNew!className}By${pkColumn}(String ${pkColumnFirstLower}){
        return ${tableNameNewLowerCase!classNameLower}Repository.selectByPrimaryKey(${pkColumnFirstLower});
    }

}
