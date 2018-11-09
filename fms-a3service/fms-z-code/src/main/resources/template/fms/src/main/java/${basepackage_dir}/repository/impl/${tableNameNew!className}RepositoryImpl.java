<#include "/java_copyright.include">
<#assign className = table.className>
<#assign classNameLower = className?uncap_first>
<#assign tableNameNew = table.tableNameNew>
<#assign tableNameNewLowerCase = table.tableNameNewLowerCase>
<#assign tableNameNewLowerCaseAll = table.tableNameNewLowerCaseAll>
<#assign pkColumn = table.firstPkColumnName>
<#assign pkColumnFirstLower = table.firstPkColumnNameFirstLower>
package ${basepackage}.data.${servername}.repository.impl;

import ${basepackage}.data.${servername}.dao.${tableNameNew!className}Dao;
import ${basepackage}.data.${servername}.repository.${tableNameNew!className}Repository;
import ${basepackage}.data.base.repository.AbstractBaseRepository;
import ${basepackage}.pojo.${servername}.entity.${tableNameNew!className};
import ${basepackage}.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import ${basepackage}.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ${username}
 * @ClassName: ${tableNameNew!className}RepositoryImpl
 * @Description: ${servicename}Repository 实现层
 */
@Repository
public class ${tableNameNew!className}RepositoryImpl extends AbstractBaseRepository<${tableNameNew!className}Dao, ${tableNameNew!className}> implements ${tableNameNew!className}Repository {

    /**
     * @Title:
     * @Description: 新增${servicename}
     * @param ${tableNameNewLowerCase!classNameLower}
     * @return int
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    @Override
    public int insertData(${tableNameNew!className} ${tableNameNewLowerCase!classNameLower}) {
        return super.insert(${tableNameNewLowerCase!classNameLower});
    }

    /**
     * @Title:
     * @Description: 批量保存${servicename}
     * @param ${tableNameNewLowerCase!classNameLower}s
     * @return int
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    @Override
    public int insertDataList(List<${tableNameNew!className}> ${tableNameNewLowerCase!classNameLower}s){
        return super.insertListByJdbcTemplate(${tableNameNewLowerCase!classNameLower}s);
    }

    /**
     * @Title:
     * @Description: 修改${servicename}
     * @param ${tableNameNewLowerCase!classNameLower}
     * @return int
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    @Override
    public int updateByPrimaryKeyData(${tableNameNew!className} ${tableNameNewLowerCase!classNameLower}) {
        return super.updateByPrimaryKey(${tableNameNewLowerCase!classNameLower});
    }

    /**
     * @Title:
     * @Description: 批量修改${servicename}
     * @param ${tableNameNewLowerCase!classNameLower}s
     * @return int
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    @Override
    public int updateByPrimaryKeyDataList(List<${tableNameNew!className}> ${tableNameNewLowerCase!classNameLower}s){
        return super.updateListByPrimaryKey(${tableNameNewLowerCase!classNameLower}s);
    }

    /**
     * @Title:
     * @Description: 动态修改${servicename}
     * @param ${tableNameNewLowerCase!classNameLower}
     * @return int
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    @Override
    public int updateByPrimaryKeySelectiveData(${tableNameNew!className} ${tableNameNewLowerCase!classNameLower}) {
        return super.updateByPrimaryKeySelective(${tableNameNewLowerCase!classNameLower});
    }

    /**
     * @Title:
     * @Description: 批量动态修改${servicename}
     * @param ${tableNameNewLowerCase!classNameLower}s
     * @return int
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<${tableNameNew!className}> ${tableNameNewLowerCase!classNameLower}s) {
        return super.updateListByPrimaryKeySelective(${tableNameNewLowerCase!classNameLower}s);
    }

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
    @Override
    public int updateByExampleData(${tableNameNew!className} ${tableNameNewLowerCase!classNameLower}, Example example) {
        return super.updateByExample(${tableNameNewLowerCase!classNameLower},example);
    }
    
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
    @Override
    public int updateByExampleSelectiveData(${tableNameNew!className} ${tableNameNewLowerCase!classNameLower}, Example example){
        return super.updateByExampleSelective(${tableNameNewLowerCase!classNameLower},example);
    }
    
    /**
     * @Title:
     * @Description: 根据${pkColumnFirstLower}删除${servicename}
     * @param ${tableNameNewLowerCase!classNameLower}
     * @return int
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    @Override
    public int deleteData(${tableNameNew!className} ${tableNameNewLowerCase!classNameLower}) {
        return super.delete(${tableNameNewLowerCase!classNameLower});
    }

    /**
     * @Title:
     * @Description: 根据${pkColumnFirstLower}集合批量删除${servicename}
     * @param ${tableNameNewLowerCase!classNameLower}
     * @return int
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    @Override
    public int deleteDataList(List ${pkColumnFirstLower}s,${tableNameNew!className} ${tableNameNewLowerCase!classNameLower}){
        return super.deleteByIds(${pkColumnFirstLower}s,${tableNameNewLowerCase!classNameLower});
    }

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
    @Override
    public int deleteExampleData(Example example,${tableNameNew!className} ${tableNameNewLowerCase!classNameLower}){
        return super.deleteByExample(example,${tableNameNewLowerCase!classNameLower});
    }

    /**
     * @Title:
     * @Description: 查询全部${servicename}
     * @return List<${tableNameNew!className}>
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    @Override
    public List<${tableNameNew!className}> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个${servicename}
     * @param example
     * @return ${tableNameNew!className}
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    @Override
    public ${tableNameNew!className} selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询${servicename}
     * @param example
     * @return List<${tableNameNew!className}>
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    @Override
    public List<${tableNameNew!className}> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过${pkColumnFirstLower}查询${servicename}
     * @param ${pkColumnFirstLower}
     * @return ${tableNameNew!className}
     * @throws
     * @author ${username}
     * @date ${.now}
     */
    @Override
    public ${tableNameNew!className} selectByPrimaryKey(Object ${pkColumnFirstLower}) {
        return super.selectByPrimaryKey(${pkColumnFirstLower});
    }
    
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
    @Override
    public PageInfoExtend<${tableNameNew!className}> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

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
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

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
    @Override
    public int updateByPrimaryKeyData(${tableNameNew!className} ${tableNameNewLowerCase!classNameLower},boolean exclusive) {
        return super.updateByPrimaryKey(${tableNameNewLowerCase!classNameLower},exclusive);
    }

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
    @Override
    public int updateByPrimaryKeyDataList(List<${tableNameNew!className}> ${tableNameNewLowerCase!classNameLower}s,boolean exclusive){
        return super.updateListByPrimaryKey(${tableNameNewLowerCase!classNameLower}s,exclusive);
    }

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
    @Override
    public int updateByPrimaryKeySelectiveData(${tableNameNew!className} ${tableNameNewLowerCase!classNameLower},boolean exclusive) {
        return super.updateByPrimaryKeySelective(${tableNameNewLowerCase!classNameLower},exclusive);
    }

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
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<${tableNameNew!className}> ${tableNameNewLowerCase!classNameLower}s,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(${tableNameNewLowerCase!classNameLower}s,exclusive);
    }

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
    @Override
    public int updateByExampleData(${tableNameNew!className} ${tableNameNewLowerCase!classNameLower}, Example example,boolean exclusive) {
        return super.updateByExample(${tableNameNewLowerCase!classNameLower},example,exclusive);
    }

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
    @Override
    public int updateByExampleSelectiveData(${tableNameNew!className} ${tableNameNewLowerCase!classNameLower}, Example example,boolean exclusive){
        return super.updateByExampleSelective(${tableNameNewLowerCase!classNameLower},example,exclusive);
    }

}
