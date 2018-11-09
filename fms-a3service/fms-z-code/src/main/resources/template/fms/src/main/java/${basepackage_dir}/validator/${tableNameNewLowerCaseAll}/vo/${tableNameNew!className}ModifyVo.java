<#include "/java_copyright.include">
<#assign className = table.className>   
<#assign classNameLower = className?uncap_first>
<#assign tableNameNewLowerCaseAll = table.tableNameNewLowerCaseAll>
<#assign isExistDateType = table.isExistDateType>
<#assign isExistDecimalType = table.isExistDecimalType>
package ${basepackage}.${servername}.validator.${tableNameNewLowerCaseAll}.vo;

import ${basepackage}.common.vo.BaseVo;
import ${basepackage}.pojo.${servername}.entity.${table.tableNameNew!className};
import lombok.Data;
import ${basepackage}.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;
<#if isExistDateType>
import java.util.Date;
</#if>
<#if isExistDecimalType>
import java.math.BigDecimal;
</#if>

/**
 * @author ${username}
 * @ClassName: ${tableNameNew!className}Vo
 * @Description: ${servicename}修改时载体及验证
 */
@Data
public class ${table.tableNameNew!className}ModifyVo extends BaseVo<${table.tableNameNew!className}> {

	private static final long serialVersionUID = 1L;

	<#list table.columns as column>
	<#if column.isPk>
	/**
	 * @Fields  : ${column.remarks}
	 * @author ${username}
	 */
	@NotBlank(message = ValidatorConstants.ID_NOT_NULL)
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