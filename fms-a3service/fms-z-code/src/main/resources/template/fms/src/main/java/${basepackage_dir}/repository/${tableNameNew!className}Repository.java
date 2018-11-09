<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign tableNameNew = table.tableNameNew>
<#assign tableNameNewLowerCase = table.tableNameNewLowerCase>
<#assign tableNameNewLowerCaseAll = table.tableNameNewLowerCaseAll>
<#assign pkColumn = table.firstPkColumnName>
<#assign pkColumnFirstLower = table.firstPkColumnNameFirstLower>
package ${basepackage}.data.${servername}.repository;

import ${basepackage}.pojo.${servername}.entity.${tableNameNew!className};
import ${basepackage}.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import ${basepackage}.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ${username}
 * @ClassName: ${tableNameNew!className}Repository
 * @Description: ${servicename}Repository层
 */
public interface ${tableNameNew!className}Repository {

	/**
	 * @Title:
	 * @Description: 新增${servicename}
	 * @param ${tableNameNewLowerCase!classNameLower}
	 * @return int
	 * @throws
	 * @author ${username}
	 * @date ${.now}
	 */
	int insertData(${tableNameNew!className} ${tableNameNewLowerCase!classNameLower});

	/**
	 * @Title:
	 * @Description: 批量保存${servicename}
	 * @param ${tableNameNewLowerCase!classNameLower}s
	 * @return int
	 * @throws
	 * @author ${username}
	 * @date ${.now}
	 */
	int insertDataList(List<${tableNameNew!className}> ${tableNameNewLowerCase!classNameLower}s);

	/**
	 * @Title:
	 * @Description: 修改${servicename}
	 * @param ${tableNameNewLowerCase!classNameLower}
	 * @return int
	 * @throws
	 * @author ${username}
	 * @date ${.now}
	 */
	int updateByPrimaryKeyData(${tableNameNew!className} ${tableNameNewLowerCase!classNameLower});

	/**
	 * @Title:
	 * @Description: 批量修改${servicename}
	 * @param ${tableNameNewLowerCase!classNameLower}s
	 * @return int
	 * @throws
	 * @author ${username}
	 * @date ${.now}
	 */
	int updateByPrimaryKeyDataList(List<${tableNameNew!className}> ${tableNameNewLowerCase!classNameLower}s);

	/**
	 * @Title:
	 * @Description: 动态修改${servicename}
	 * @param ${tableNameNewLowerCase!classNameLower}
	 * @return int
	 * @throws
	 * @author ${username}
	 * @date ${.now}
	 */
	int updateByPrimaryKeySelectiveData(${tableNameNew!className} ${tableNameNewLowerCase!classNameLower});

	/**
	 * @Title:
	 * @Description: 批量动态修改${servicename}
	 * @param ${tableNameNewLowerCase!classNameLower}s
	 * @return int
	 * @throws
	 * @author ${username}
	 * @date ${.now}
	 */
	int updateByPrimaryKeySelectiveDataList(List<${tableNameNew!className}> ${tableNameNewLowerCase!classNameLower}s);

	/**
	 * @Title:
	 * @Description: 根据条件修改${servicename}
	 * @param ${tableNameNewLowerCase!classNameLower}
	 * @param example
	 * @return int
	 * @throws
	 * @author ${username}
	 * @date ${.now}
	 */
	int updateByExampleData(${tableNameNew!className} ${tableNameNewLowerCase!classNameLower}, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改${servicename}
	 * @param ${tableNameNewLowerCase!classNameLower}
	 * @param example
	 * @return int
	 * @throws
	 * @author ${username}
	 * @date ${.now}
	 */
	int updateByExampleSelectiveData(${tableNameNew!className} ${tableNameNewLowerCase!classNameLower}, Example example);

	/**
	 * @Title:
	 * @Description: 根据${pkColumnFirstLower}删除${servicename}
	 * @param ${tableNameNewLowerCase!classNameLower}
	 * @return int
	 * @throws
	 * @author ${username}
	 * @date ${.now}
	 */
	int deleteData(${tableNameNew!className} ${tableNameNewLowerCase!classNameLower});

	/**
	 * @Title:
	 * @Description: 根据${pkColumnFirstLower}集合批量删除${servicename}
	 * @param ${pkColumnFirstLower}s
	 * @param ${tableNameNewLowerCase!classNameLower}
	 * @return int
	 * @throws
	 * @author ${username}
	 * @date ${.now}
	 */
	int deleteDataList(List ${pkColumnFirstLower}s,${tableNameNew!className} ${tableNameNewLowerCase!classNameLower});

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除${servicename}
	 * @param example
	 * @param ${tableNameNewLowerCase!classNameLower}
	 * @return int
	 * @throws
	 * @author ${username}
	 * @date ${.now}
	 */
	int deleteExampleData(Example example,${tableNameNew!className} ${tableNameNewLowerCase!classNameLower});

	/**
	 * @Title:
	 * @Description: 查询全部${servicename}
	 * @return List<${tableNameNew!className}>
	 * @throws
	 * @author ${username}
	 * @date ${.now}
	 */
	List<${tableNameNew!className}> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个${servicename}
	 * @param example
	 * @return ${tableNameNew!className}
	 * @throws
	 * @author ${username}
	 * @date ${.now}
	 */
	${tableNameNew!className} selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询${servicename}
	 * @param example
	 * @return List<${tableNameNew!className}>
	 * @throws
	 * @author ${username}
	 * @date ${.now}
	 */
	List<${tableNameNew!className}> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过${pkColumnFirstLower}查询${servicename}
	 * @param ${pkColumnFirstLower}
	 * @return ${tableNameNew!className}
	 * @throws
	 * @author ${username}
	 * @date ${.now}
	 */
	${tableNameNew!className} selectByPrimaryKey(Object ${pkColumnFirstLower});

	/**
	 * @Title:
	 * @Description: 分页查询${servicename}
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<${tableNameNew!className}>
	 * @throws
	 * @author ${username}
	 * @date ${.now}
	 */
	PageInfoExtend<${tableNameNew!className}> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询${servicename}vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author ${username}
	 * @date ${.now}
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改${servicename}
	 * @param ${tableNameNewLowerCase!classNameLower},并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ${username}
	 * @date ${.now}
	 */
	int updateByPrimaryKeyData(${tableNameNew!className} ${tableNameNewLowerCase!classNameLower},boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改${servicename},并进行排他
	 * @param ${tableNameNewLowerCase!classNameLower}s
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ${username}
	 * @date ${.now}
	 */
	int updateByPrimaryKeyDataList(List<${tableNameNew!className}> ${tableNameNewLowerCase!classNameLower}s,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改${servicename},并进行排他
	 * @param ${tableNameNewLowerCase!classNameLower}
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(${tableNameNew!className} ${tableNameNewLowerCase!classNameLower},boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改${servicename},并进行排他
	 * @param ${tableNameNewLowerCase!classNameLower}s
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ${username}
	 * @date ${.now}
	 */
	int updateByPrimaryKeySelectiveDataList(List<${tableNameNew!className}> ${tableNameNewLowerCase!classNameLower}s,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改${servicename},并进行排他
	 * @param ${tableNameNewLowerCase!classNameLower}
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ${username}
	 * @date ${.now}
	 */
	int updateByExampleData(${tableNameNew!className} ${tableNameNewLowerCase!classNameLower}, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改${servicename},并进行排他
	 * @param ${tableNameNewLowerCase!classNameLower}
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author ${username}
	 * @date ${.now}
	 */
	int updateByExampleSelectiveData(${tableNameNew!className} ${tableNameNewLowerCase!classNameLower}, Example example,boolean exclusive);

}
