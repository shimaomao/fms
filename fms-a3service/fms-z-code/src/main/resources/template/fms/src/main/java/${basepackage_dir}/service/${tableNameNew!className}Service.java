<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign tableNameNew = table.tableNameNew>
<#assign tableNameNewLowerCase = table.tableNameNewLowerCase>
<#assign tableNameNewLowerCaseAll = table.tableNameNewLowerCaseAll>
<#assign pkColumn = table.firstPkColumnName>
<#assign pkColumnFirstLower = table.firstPkColumnNameFirstLower>
package ${basepackage}.${servername}.service;

import ${basepackage}.pojo.${servername}.entity.${tableNameNew!className};
import ${basepackage}.pojo.${servername}.vo.${tableNameNewLowerCaseAll}.${tableNameNew!className}Vo;
import ${basepackage}.${servername}.validator.${tableNameNewLowerCaseAll}.vo.${tableNameNew!className}SaveVo;
import ${basepackage}.${servername}.validator.${tableNameNewLowerCaseAll}.vo.${tableNameNew!className}ModifyVo;
import ${basepackage}.${servername}.validator.${tableNameNewLowerCaseAll}.vo.${tableNameNew!className}DeleteVo;
import ${basepackage}.${servername}.validator.${tableNameNewLowerCaseAll}.vo.${tableNameNew!className}DeleteListVo;
import ${basepackage}.data.base.vo.PageInfoExtend;

/**
 * @author ${username}
 * @ClassName: ${tableNameNew!className}Service
 * @Description: ${servicename}业务层
 */
public interface ${tableNameNew!className}Service {

	/**
	 * @Title:
	 * @Description: 分页查询${servicename}
	 * @param ${tableNameNewLowerCase!classNameLower}Vo
	 * @return PageInfoExtend<${tableNameNew!className}>
	 * @throws
	 * @author ${username}
	 * @date ${.now}
	 */
	PageInfoExtend<${tableNameNew!className}> find${tableNameNew!className}sByPage(${tableNameNew!className}Vo ${tableNameNewLowerCase!classNameLower}Vo);

	/**
	 * @Title:
	 * @Description: 保存${servicename}
	 * @param ${tableNameNewLowerCase!classNameLower}SaveVo
	 * @return java.lang.String
	 * @throws
	 * @author ${username}
	 * @date ${.now}
	 */
    void save${tableNameNew!className}(${tableNameNew!className}SaveVo ${tableNameNewLowerCase!classNameLower}SaveVo);


	/**
	 * @Title:
	 * @Description: 修改${servicename}
	 * @param ${tableNameNewLowerCase!classNameLower}ModifyVo
	 * @return
	 * @throws
	 * @author ${username}
	 * @date ${.now}
	 */
	void modify${tableNameNew!className}(${tableNameNew!className}ModifyVo ${tableNameNewLowerCase!classNameLower}ModifyVo);

	/**
	 * @Title:
	 * @Description:  通过${pkColumnFirstLower}删除${servicename}
	 * @param ${tableNameNewLowerCase!classNameLower}DeleteVo
	 * @return
	 * @throws
	 * @author ${username}
	 * @date ${.now}
	 */
	void delete${tableNameNew!className}(${tableNameNew!className}DeleteVo ${tableNameNewLowerCase!classNameLower}DeleteVo);


	/**
	 * @Title:
	 * @Description:  通过${pkColumnFirstLower}集合删除${servicename}
	 * @param ${tableNameNewLowerCase!classNameLower}DeleteListVo
	 * @return
	 * @throws
	 * @author ${username}
	 * @date ${.now}
	 */
	void delete${tableNameNew!className}sBy${pkColumn}s(${tableNameNew!className}DeleteListVo ${tableNameNewLowerCase!classNameLower}DeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据${pkColumnFirstLower}获取${servicename}
	 * @param ${pkColumnFirstLower}
	 * @return ${tableNameNew!className}
	 * @throws
	 * @author ${username}
	 * @date ${.now}
	 */
	${tableNameNew!className} find${tableNameNew!className}By${pkColumn}(String ${pkColumnFirstLower});

}
