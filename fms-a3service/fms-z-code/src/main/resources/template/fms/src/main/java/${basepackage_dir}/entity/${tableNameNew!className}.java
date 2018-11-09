<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign isExistDateType = table.isExistDateType>
<#assign isExistDecimalType = table.isExistDecimalType>
package ${basepackage}.pojo.${servername}.entity;

import ${basepackage}.common.entity.BaseEntity;
import ${basepackage}.common.tkmapper.IdGenerator;
import lombok.Data;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
<#if isExistDateType>
import java.util.Date;
</#if>
<#if isExistDecimalType>
import java.math.BigDecimal;
</#if>

/**
 * @author ${username}
 * @ClassName: ${tableNameNew!className}
 * @Description: ${servicename}实体
 */
@Data
public class ${table.tableNameNew!className} extends BaseEntity<${table.tableNameNew!className}> {

	private static final long serialVersionUID = 1L;

	<#list table.columns as column>
	<#if column.isPk>
	/**
	 * @Fields  : ${column.remarks}
	 * @author ${username}
	 */
	@Id   
	<#if column.javaType=="String">
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	<#else>
	@GeneratedValue(strategy = GenerationType.IDENTITY,generator = IdGenerator.ID_GENERATOR)
	</#if>
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
}