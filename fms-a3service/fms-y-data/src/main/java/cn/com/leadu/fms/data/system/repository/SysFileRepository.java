package cn.com.leadu.fms.data.system.repository;

import cn.com.leadu.fms.pojo.system.entity.SysFile;
import cn.com.leadu.fms.pojo.system.vo.sysfile.SysFileVo;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * SysFile
 * @author code-generator 
 */
public interface SysFileRepository {

	/**
	 * 新增
	 *@param :SysFile
	 *@Return:java.lang.String
	*/
    int insertData(SysFile sysFile);

    /**
     *批量保存
     *@param: List<SysFile>
     *@Return:java.util.List<cn.com.leadu.fms.entity.SysFile>
     */
    int insertDataList(List<SysFile> sysFiles);
    
    /**
     *单个修改
     *@param: SysFile
     *@Return:void
     */
    int updateByPrimaryKeyData(SysFile sysFile);

	/**
	 *批量更新
	 *@param: SysFile
	 *@Return:void
	 */
    int updateByPrimaryKeyDataList(List<SysFile> sysFiles);
   
    /**
     *动态修改
     *@param: SysFile
     *@Return:void
     */
    int updateByPrimaryKeySelectiveData(SysFile sysFile);

	/**
	 *批量动态修改
	 *@param: SysFile
	 *@Return:void
	 */
	int updateByPrimaryKeySelectiveDataList(List<SysFile> sysFiles);
    
    /**
     *根据条件修改
     *@param: SysFile,Example
     *@Return:void
     */
    int updateByExampleData(SysFile sysFile, Example example);

    /**
     *根据条件动态修改
     *@param: SysFile,Example
     *@Return:void
     */
    int updateByExampleSelectiveData(SysFile sysFile, Example example);
    
    /**
     *根据ID删除
     *@param: String
     *@Return:void
     */
    int deleteData(SysFile sysFile);


	/**
	 *根据ID集合批量删除
	 *@param: String
	 *@Return:void
	 */
	int deleteDataList(List ids, SysFile sysFile);
    
    /**
     *全部查询
     *@param:void
     *@Return:java.util.List
     */
    List<SysFile> selectAll();
    
    /**
     *通过条件单个查询
     *@param: Example
     *@Return:cn.com.leadu.fms.entity.SysFile
     */
    SysFile selectOneByExample(Example example);
    
    /**
     *通过条件批量查询
     *@param: Example
     *@Return:java.util.List<cn.com.leadu.fms.entity.SysFile>
     */
    List<SysFile> selectListByExample(Example example);
    
    /**
     *通过ID查询
     *@param: String
     *@Return:cn.com.leadu.fms.entity.SysFile
     */
    SysFile selectByPrimaryKey(Object id);
        
    /**
     *分页查询
     *@param: PageQuery
     *@Return:void
     */
    PageInfoExtend<SysFile> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 *分页查询vo
	 *@param: PageQuery
	 *@Return:void
	 */
    PageInfoExtend<SysFile> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
