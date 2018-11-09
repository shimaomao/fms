<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign isExistDateType = table.isExistDateType>
<#assign isExistDecimalType = table.isExistDecimalType>
<#assign tableNameNewLowerCaseAll = table.tableNameNewLowerCaseAll>
package ${basepackage}.pojo.${servername}.vo.${tableNameNewLowerCaseAll};

import ${basepackage}.common.vo.PageQuery;
import ${basepackage}.pojo.${servername}.entity.${tableNameNew!className};
import lombok.Data;
import java.util.List;
<#if isExistDateType>
import java.util.Date;
</#if>
<#if isExistDecimalType>
import java.math.BigDecimal;
</#if>

/**
 * @author ${username}
 * @ClassName: ${tableNameNew!className}Vo
 * @Description: ${servicename}载体
 */
@Data
public class ${table.tableNameNew!className}Vo extends PageQuery<${table.tableNameNew!className}> {

	private static final long serialVersionUID = 1L;

	<#list table.columns as column>
	<#if column.isPk>
	/**
	 * @Fields  : ${column.remarks}
	 * @author ${username}
	 */
	private ${column.simpleJavaType} ${column.columnNameFirstLower};

	<#else>
	<#if column.columnNameFirstLower!="createTime" && column.columnNameFirstLower!="creator" && column.columnNameFirstLower!="updateTime" && column.columnNameFirstLower!="updater" && column.columnNameFirstLower!="delFlag">
	/**
	 * @Fields  : ${column.remarks}
	 * @author ${username}
	 */
	private ${column.simpleJavaType} ${column.columnNameFirstLower};

	</#if>
	</#if>
	</#list>
	<#list table.columns as column>
	<#if column.isPk>
	/**
	 * @Fields  : ${column.remarks}
	 * @author ${username}
	 */
	private List<${column.simpleJavaType}> ${column.columnNameFirstLower}s;

	</#if>
	</#list>
}