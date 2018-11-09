<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign tableNameNewLowerCaseAll = table.tableNameNewLowerCaseAll>
package ${basepackage}.${servername}.validator.${tableNameNewLowerCaseAll}.vo;

import ${basepackage}.common.vo.BaseVo;
import ${basepackage}.pojo.${servername}.entity.${table.tableNameNew!className};
import lombok.Data;
import javax.validation.constraints.Size;
import ${basepackage}.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author ${username}
 * @ClassName: ${tableNameNew!className}Vo
 * @Description: ${servicename}删除时载体及验证
 */
@Data
public class ${table.tableNameNew!className}DeleteListVo extends BaseVo<${table.tableNameNew!className}> {

    private static final long serialVersionUID = 1L;

    <#list table.columns as column>
    <#if column.isPk>
    /**
     * @Fields  : ${column.remarks}
     * @author ${username}
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<${column.simpleJavaType}> ${column.columnNameFirstLower}s;

    </#if>
    </#list>
}