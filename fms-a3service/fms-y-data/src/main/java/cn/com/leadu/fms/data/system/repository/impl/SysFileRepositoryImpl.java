package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.system.dao.SysFileDao;
import cn.com.leadu.fms.data.system.repository.SysFileRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.system.entity.SysFile;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * SysFile
 * @author code-generator 
 */
@Repository
public class SysFileRepositoryImpl extends AbstractBaseRepository<SysFileDao, SysFile> implements SysFileRepository {

    /**
	 * 新增
	 *@param :SysFile
	 *@Return:java.lang.String
	*/
    @Override
    public int insertData(SysFile sysFile) {
        return super.insert(sysFile);
    }

    /**
     *批量保存
     *@param: List<SysFile>
     *@Return:java.util.List<cn.com.leadu.fms.entity.SysFile>
     */
    @Override
    public int insertDataList(List<SysFile> sysFiles){
        return super.insertListByJdbcTemplate(sysFiles);
    }

    /**
     *单个修改
     *@param: SysFile
     *@Return:void
     */
    @Override
    public int updateByPrimaryKeyData(SysFile sysFile) {
        return super.updateByPrimaryKey(sysFile);
    }

    /**
     *批量更新
     *@param: SysFile
     *@Return:void
     */
    @Override
    public int updateByPrimaryKeyDataList(List<SysFile> sysFiles){
        return super.insertListByJdbcTemplate(sysFiles);
    }

    /**
     *动态修改
     *@param: SysFile
     *@Return:void
     */
    @Override
    public int updateByPrimaryKeySelectiveData(SysFile sysFile) {
        return super.updateByPrimaryKeySelective(sysFile);
    }

    /**
     *批量动态修改
     *@param: SysFile
     *@Return:void
     */
    public int updateByPrimaryKeySelectiveDataList(List<SysFile> sysFiles) {
        return super.updateListByPrimaryKeySelective(sysFiles);
    }

    /**
     *根据条件修改
     *@param: SysFile,Example
     *@Return:void
     */
    @Override
    public int updateByExampleData(SysFile sysFile, Example example) {
        return super.updateByExample(sysFile,example);
    }
    
    /**
     *根据条件动态修改
     *@param: SysFile,Example
     *@Return:void
     */
    @Override
    public int updateByExampleSelectiveData(SysFile sysFile, Example example){
        return super.updateByExampleSelective(sysFile,example);
    }
    
    /**
     *根据ID删除
     *@param: String
     *@Return:void
     */
    @Override
    public int deleteData(SysFile sysFile) {
        return super.delete(sysFile);
    }

    /**
     *根据ID集合批量删除
     *@param: String
     *@Return:void
     */
    public int deleteDataList(List ids,SysFile sysFile){
        return super.deleteByIds(ids,sysFile);
    }

    /**
     *全部查询
     *@param:void
     *@Return:java.util.List
     */
    @Override
    public List<SysFile> selectAll() {
        return super.selectAll();
    }
    
    /**
     *通过条件单个查询
     *@param: Example
     *@Return:cn.com.leadu.fms.entity.SysFile
     */
    @Override
    public SysFile selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     *通过条件批量查询
     *@param: Example
     *@Return:java.util.List<cn.com.leadu.fms.entity.SysFile>
     */
    @Override
    public List<SysFile> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     *通过ID查询
     *@param: String
     *@Return:cn.com.leadu.fms.entity.SysFile
     */
    @Override
    public SysFile selectByPrimaryKey(Object id) {
        return super.selectByPrimaryKey(id);
    }
    
    /**
     *分页查询
     *@param: PageQuery
     *@Return:void
     */
    @Override
    public PageInfoExtend<SysFile> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     *分页查询vo
     *@param: PageQuery
     *@Return:void
     */
    public PageInfoExtend<SysFile> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
