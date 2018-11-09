<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first> 
<#assign tableNameNew = table.tableNameNew>
<#assign tableNameNewLowerCase = table.tableNameNewLowerCase>
package ${basepackage}.data.${servername}.dao;

import ${basepackage}.${dataname}.base.config.BaseDao;
import ${basepackage}.pojo.${servername}.entity.${table.tableNameNew!className};

/**
 * @author ${username}
 * @ClassName: ${tableNameNew!className}Dao
 * @Description: ${servicename}dao层
 */
public interface ${tableNameNew!className}Dao extends BaseDao<${tableNameNew!className}> {

}