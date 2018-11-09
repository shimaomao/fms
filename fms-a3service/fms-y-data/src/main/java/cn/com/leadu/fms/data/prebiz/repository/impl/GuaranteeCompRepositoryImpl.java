package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.GuaranteeCompDao;
import cn.com.leadu.fms.data.prebiz.repository.GuaranteeCompRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.GuaranteeComp;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: GuaranteeCompRepositoryImpl
 * @Description: 担保企业信息Repository 实现层
 * @date 2018-03-30
 */
@Repository
public class GuaranteeCompRepositoryImpl extends AbstractBaseRepository<GuaranteeCompDao, GuaranteeComp> implements GuaranteeCompRepository {

    /**
     * @Title:
     * @Description: 新增担保企业信息
     * @param guaranteeComp
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @Override
    public int insertData(GuaranteeComp guaranteeComp) {
        return super.insert(guaranteeComp);
    }

    /**
     * @Title:
     * @Description: 批量保存担保企业信息
     * @param guaranteeComps
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @Override
    public int insertDataList(List<GuaranteeComp> guaranteeComps){
        return super.insertListByJdbcTemplate(guaranteeComps);
    }

    /**
     * @Title:
     * @Description: 修改担保企业信息
     * @param guaranteeComp
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @Override
    public int updateByPrimaryKeyData(GuaranteeComp guaranteeComp) {
        return super.updateByPrimaryKey(guaranteeComp);
    }

    /**
     * @Title:
     * @Description: 批量修改担保企业信息
     * @param guaranteeComps
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @Override
    public int updateByPrimaryKeyDataList(List<GuaranteeComp> guaranteeComps){
        return super.insertListByJdbcTemplate(guaranteeComps);
    }

    /**
     * @Title:
     * @Description: 动态修改担保企业信息
     * @param guaranteeComp
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @Override
    public int updateByPrimaryKeySelectiveData(GuaranteeComp guaranteeComp) {
        return super.updateByPrimaryKeySelective(guaranteeComp);
    }

    /**
     * @Title:
     * @Description: 批量动态修改担保企业信息
     * @param guaranteeComps
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    public int updateByPrimaryKeySelectiveDataList(List<GuaranteeComp> guaranteeComps) {
        return super.updateListByPrimaryKeySelective(guaranteeComps);
    }

    /**
     * @Title:
     * @Description: 根据条件修改担保企业信息
     * @param guaranteeComp
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @Override
    public int updateByExampleData(GuaranteeComp guaranteeComp, Example example) {
        return super.updateByExample(guaranteeComp,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改担保企业信息
     * @param guaranteeComp
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @Override
    public int updateByExampleSelectiveData(GuaranteeComp guaranteeComp, Example example){
        return super.updateByExampleSelective(guaranteeComp,example);
    }
    
    /**
     * @Title:
     * @Description: 根据guarCompId删除担保企业信息
     * @param guaranteeComp
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @Override
    public int deleteData(GuaranteeComp guaranteeComp) {
        return super.delete(guaranteeComp);
    }

    /**
     * @Title:
     * @Description: 根据guarCompId集合批量删除担保企业信息
     * @param guaranteeComp
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    public int deleteDataList(List guarCompIds,GuaranteeComp guaranteeComp){
        return super.deleteByIds(guarCompIds,guaranteeComp);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除担保企业信息
     * @param example
     * @param guaranteeComp
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    public int deleteExampleData(Example example,GuaranteeComp guaranteeComp){
        return super.deleteByExample(example,guaranteeComp);
    }

    /**
     * @Title:
     * @Description: 查询全部担保企业信息
     * @return List<GuaranteeComp>
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @Override
    public List<GuaranteeComp> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个担保企业信息
     * @param example
     * @return GuaranteeComp
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @Override
    public GuaranteeComp selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询担保企业信息
     * @param example
     * @return List<GuaranteeComp>
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @Override
    public List<GuaranteeComp> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过guarCompId查询担保企业信息
     * @param guarCompId
     * @return GuaranteeComp
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @Override
    public GuaranteeComp selectByPrimaryKey(Object guarCompId) {
        return super.selectByPrimaryKey(guarCompId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询担保企业信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<GuaranteeComp>
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @Override
    public PageInfoExtend<GuaranteeComp> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询担保企业信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<GuaranteeComp>
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    public PageInfoExtend<GuaranteeComp> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
