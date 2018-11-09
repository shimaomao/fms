package cn.com.leadu.fms.data.system.repository.impl;

import cn.com.leadu.fms.data.system.dao.NumGenerateDao;
import cn.com.leadu.fms.data.system.repository.NumGenerateRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.system.entity.NumGenerate;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: NumGenerateRepositoryImpl
 * @Description: 业务编号管理Repository 实现层
 * @date 2018-03-26
 */
@Repository
public class NumGenerateRepositoryImpl extends AbstractBaseRepository<NumGenerateDao, NumGenerate> implements NumGenerateRepository {

    /**
     * @Title:
     * @Description: 新增业务编号管理
     * @param numGenerate
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-26 14:53:41
     */
    @Override
    public int insertData(NumGenerate numGenerate) {
        return super.insert(numGenerate);
    }

    /**
     * @Title:
     * @Description: 批量保存业务编号管理
     * @param numGenerates
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-26 14:53:41
     */
    @Override
    public int insertDataList(List<NumGenerate> numGenerates){
        return super.insertListByJdbcTemplate(numGenerates);
    }

    /**
     * @Title:
     * @Description: 修改业务编号管理
     * @param numGenerate
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-26 14:53:41
     */
    @Override
    public int updateByPrimaryKeyData(NumGenerate numGenerate) {
        return super.updateByPrimaryKey(numGenerate);
    }

    /**
     * @Title:
     * @Description: 批量修改业务编号管理
     * @param numGenerates
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-26 14:53:41
     */
    @Override
    public int updateByPrimaryKeyDataList(List<NumGenerate> numGenerates){
        return super.updateListByPrimaryKey(numGenerates);
    }

    /**
     * @Title:
     * @Description: 动态修改业务编号管理
     * @param numGenerate
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-26 14:53:41
     */
    @Override
    public int updateByPrimaryKeySelectiveData(NumGenerate numGenerate) {
        return super.updateByPrimaryKeySelective(numGenerate);
    }

    /**
     * @Title:
     * @Description: 批量动态修改业务编号管理
     * @param numGenerates
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-26 14:53:41
     */
    public int updateByPrimaryKeySelectiveDataList(List<NumGenerate> numGenerates) {
        return super.updateListByPrimaryKeySelective(numGenerates);
    }

    /**
     * @Title:
     * @Description: 根据条件修改业务编号管理
     * @param numGenerate
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-26 14:53:41
     */
    @Override
    public int updateByExampleData(NumGenerate numGenerate, Example example) {
        return super.updateByExample(numGenerate,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改业务编号管理
     * @param numGenerate
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-26 14:53:41
     */
    @Override
    public int updateByExampleSelectiveData(NumGenerate numGenerate, Example example){
        return super.updateByExampleSelective(numGenerate,example);
    }
    
    /**
     * @Title:
     * @Description: 根据numGenerateId删除业务编号管理
     * @param numGenerate
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-26 14:53:41
     */
    @Override
    public int deleteData(NumGenerate numGenerate) {
        return super.delete(numGenerate);
    }

    /**
     * @Title:
     * @Description: 根据numGenerateId集合批量删除业务编号管理
     * @param numGenerate
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-26 14:53:41
     */
    public int deleteDataList(List numGenerateIds,NumGenerate numGenerate){
        return super.deleteByIds(numGenerateIds,numGenerate);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除业务编号管理
     * @param example
     * @param numGenerate
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-26 14:53:41
     */
    public int deleteExampleData(Example example,NumGenerate numGenerate){
        return super.deleteByExample(example,numGenerate);
    }

    /**
     * @Title:
     * @Description: 查询全部业务编号管理
     * @return List<NumGenerate>
     * @throws
     * @author liujinge
     * @date 2018-3-26 14:53:41
     */
    @Override
    public List<NumGenerate> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个业务编号管理
     * @param example
     * @return NumGenerate
     * @throws
     * @author liujinge
     * @date 2018-3-26 14:53:41
     */
    @Override
    public NumGenerate selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询业务编号管理
     * @param example
     * @return List<NumGenerate>
     * @throws
     * @author liujinge
     * @date 2018-3-26 14:53:41
     */
    @Override
    public List<NumGenerate> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过numGenerateId查询业务编号管理
     * @param numGenerateId
     * @return NumGenerate
     * @throws
     * @author liujinge
     * @date 2018-3-26 14:53:41
     */
    @Override
    public NumGenerate selectByPrimaryKey(Object numGenerateId) {
        return super.selectByPrimaryKey(numGenerateId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询业务编号管理
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<NumGenerate>
     * @throws
     * @author liujinge
     * @date 2018-3-26 14:53:41
     */
    @Override
    public PageInfoExtend<NumGenerate> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询业务编号管理vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<NumGenerate>
     * @throws
     * @author liujinge
     * @date 2018-3-26 14:53:41
     */
    public PageInfoExtend<NumGenerate> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }
    /**
     * @Title:
     * @Description: 取得当前号并Lock该行
     * @param numType
     * @return NumGenerate
     * @throws
     * @author liujinge
     * @date 2018-3-26 14:53:41
     */
    @Override
    public NumGenerate selectByNumTypeLock(String numType, String generateDate) {
        return baseDao.selectByNumTypeLock(numType, generateDate);
    }

}
