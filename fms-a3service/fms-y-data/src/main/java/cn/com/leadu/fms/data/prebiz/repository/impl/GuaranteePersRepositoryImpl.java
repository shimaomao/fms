package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.GuaranteePersDao;
import cn.com.leadu.fms.data.prebiz.repository.GuaranteePersRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.GuaranteePers;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: GuaranteePersRepositoryImpl
 * @Description: 担保个人信息Repository 实现层
 * @date 2018-03-30
 */
@Repository
public class GuaranteePersRepositoryImpl extends AbstractBaseRepository<GuaranteePersDao, GuaranteePers> implements GuaranteePersRepository {

    /**
     * @Title:
     * @Description: 新增担保个人信息
     * @param guaranteePers
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:12
     */
    @Override
    public int insertData(GuaranteePers guaranteePers) {
        return super.insert(guaranteePers);
    }

    /**
     * @Title:
     * @Description: 批量保存担保个人信息
     * @param guaranteePerss
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:12
     */
    @Override
    public int insertDataList(List<GuaranteePers> guaranteePerss){
        return super.insertListByJdbcTemplate(guaranteePerss);
    }

    /**
     * @Title:
     * @Description: 修改担保个人信息
     * @param guaranteePers
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:12
     */
    @Override
    public int updateByPrimaryKeyData(GuaranteePers guaranteePers) {
        return super.updateByPrimaryKey(guaranteePers);
    }

    /**
     * @Title:
     * @Description: 批量修改担保个人信息
     * @param guaranteePerss
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:12
     */
    @Override
    public int updateByPrimaryKeyDataList(List<GuaranteePers> guaranteePerss){
        return super.insertListByJdbcTemplate(guaranteePerss);
    }

    /**
     * @Title:
     * @Description: 动态修改担保个人信息
     * @param guaranteePers
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:12
     */
    @Override
    public int updateByPrimaryKeySelectiveData(GuaranteePers guaranteePers) {
        return super.updateByPrimaryKeySelective(guaranteePers);
    }

    /**
     * @Title:
     * @Description: 批量动态修改担保个人信息
     * @param guaranteePerss
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:12
     */
    public int updateByPrimaryKeySelectiveDataList(List<GuaranteePers> guaranteePerss) {
        return super.updateListByPrimaryKeySelective(guaranteePerss);
    }

    /**
     * @Title:
     * @Description: 根据条件修改担保个人信息
     * @param guaranteePers
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:12
     */
    @Override
    public int updateByExampleData(GuaranteePers guaranteePers, Example example) {
        return super.updateByExample(guaranteePers,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改担保个人信息
     * @param guaranteePers
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:12
     */
    @Override
    public int updateByExampleSelectiveData(GuaranteePers guaranteePers, Example example){
        return super.updateByExampleSelective(guaranteePers,example);
    }
    
    /**
     * @Title:
     * @Description: 根据guarPersId删除担保个人信息
     * @param guaranteePers
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:12
     */
    @Override
    public int deleteData(GuaranteePers guaranteePers) {
        return super.delete(guaranteePers);
    }

    /**
     * @Title:
     * @Description: 根据guarPersId集合批量删除担保个人信息
     * @param guaranteePers
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:12
     */
    public int deleteDataList(List guarPersIds,GuaranteePers guaranteePers){
        return super.deleteByIds(guarPersIds,guaranteePers);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除担保个人信息
     * @param example
     * @param guaranteePers
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:12
     */
    public int deleteExampleData(Example example,GuaranteePers guaranteePers){
        return super.deleteByExample(example,guaranteePers);
    }

    /**
     * @Title:
     * @Description: 查询全部担保个人信息
     * @return List<GuaranteePers>
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:12
     */
    @Override
    public List<GuaranteePers> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个担保个人信息
     * @param example
     * @return GuaranteePers
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:12
     */
    @Override
    public GuaranteePers selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询担保个人信息
     * @param example
     * @return List<GuaranteePers>
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:12
     */
    @Override
    public List<GuaranteePers> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过guarPersId查询担保个人信息
     * @param guarPersId
     * @return GuaranteePers
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:12
     */
    @Override
    public GuaranteePers selectByPrimaryKey(Object guarPersId) {
        return super.selectByPrimaryKey(guarPersId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询担保个人信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<GuaranteePers>
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:12
     */
    @Override
    public PageInfoExtend<GuaranteePers> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询担保个人信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<GuaranteePers>
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:12
     */
    public PageInfoExtend<GuaranteePers> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
