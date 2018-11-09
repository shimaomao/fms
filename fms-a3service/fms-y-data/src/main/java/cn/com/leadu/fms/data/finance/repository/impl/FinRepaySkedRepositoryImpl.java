package cn.com.leadu.fms.data.finance.repository.impl;

import cn.com.leadu.fms.data.finance.dao.FinRepaySkedDao;
import cn.com.leadu.fms.data.finance.repository.FinRepaySkedRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.finance.entity.FinRepaySked;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: FinRepaySkedRepositoryImpl
 * @Description: 财务还款计划Repository 实现层
 * @date 2018-05-12
 */
@Repository
public class FinRepaySkedRepositoryImpl extends AbstractBaseRepository<FinRepaySkedDao, FinRepaySked> implements FinRepaySkedRepository {

    /**
     * @Title:
     * @Description: 新增财务还款计划
     * @param finRepaySked
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @Override
    public int insertData(FinRepaySked finRepaySked) {
        return super.insert(finRepaySked);
    }

    /**
     * @Title:
     * @Description: 批量保存财务还款计划
     * @param finRepaySkeds
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @Override
    public int insertDataList(List<FinRepaySked> finRepaySkeds){
        return super.insertListByJdbcTemplate(finRepaySkeds);
    }

    /**
     * @Title:
     * @Description: 修改财务还款计划
     * @param finRepaySked
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @Override
    public int updateByPrimaryKeyData(FinRepaySked finRepaySked) {
        return super.updateByPrimaryKey(finRepaySked);
    }

    /**
     * @Title:
     * @Description: 批量修改财务还款计划
     * @param finRepaySkeds
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @Override
    public int updateByPrimaryKeyDataList(List<FinRepaySked> finRepaySkeds){
        return super.updateListByPrimaryKey(finRepaySkeds);
    }

    /**
     * @Title:
     * @Description: 动态修改财务还款计划
     * @param finRepaySked
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @Override
    public int updateByPrimaryKeySelectiveData(FinRepaySked finRepaySked) {
        return super.updateByPrimaryKeySelective(finRepaySked);
    }

    /**
     * @Title:
     * @Description: 批量动态修改财务还款计划
     * @param finRepaySkeds
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    public int updateByPrimaryKeySelectiveDataList(List<FinRepaySked> finRepaySkeds) {
        return super.updateListByPrimaryKeySelective(finRepaySkeds);
    }

    /**
     * @Title:
     * @Description: 根据条件修改财务还款计划
     * @param finRepaySked
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @Override
    public int updateByExampleData(FinRepaySked finRepaySked, Example example) {
        return super.updateByExample(finRepaySked,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改财务还款计划
     * @param finRepaySked
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @Override
    public int updateByExampleSelectiveData(FinRepaySked finRepaySked, Example example){
        return super.updateByExampleSelective(finRepaySked,example);
    }
    
    /**
     * @Title:
     * @Description: 根据finRepaySkedId删除财务还款计划
     * @param finRepaySked
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @Override
    public int deleteData(FinRepaySked finRepaySked) {
        return super.delete(finRepaySked);
    }

    /**
     * @Title:
     * @Description: 根据finRepaySkedId集合批量删除财务还款计划
     * @param finRepaySked
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    public int deleteDataList(List finRepaySkedIds,FinRepaySked finRepaySked){
        return super.deleteByIds(finRepaySkedIds,finRepaySked);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除财务还款计划
     * @param example
     * @param finRepaySked
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    public int deleteExampleData(Example example,FinRepaySked finRepaySked){
        return super.deleteByExample(example,finRepaySked);
    }

    /**
     * @Title:
     * @Description: 查询全部财务还款计划
     * @return List<FinRepaySked>
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @Override
    public List<FinRepaySked> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个财务还款计划
     * @param example
     * @return FinRepaySked
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @Override
    public FinRepaySked selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询财务还款计划
     * @param example
     * @return List<FinRepaySked>
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @Override
    public List<FinRepaySked> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过finRepaySkedId查询财务还款计划
     * @param finRepaySkedId
     * @return FinRepaySked
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @Override
    public FinRepaySked selectByPrimaryKey(Object finRepaySkedId) {
        return super.selectByPrimaryKey(finRepaySkedId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询财务还款计划
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<FinRepaySked>
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @Override
    public PageInfoExtend<FinRepaySked> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询财务还款计划vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Description: 查找财务还款计划表未还款剩余本金
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/22 11:05
     * @param
     */
    @Override
    public BigDecimal selectRestPrincipalAmountByContNo(String contNo) {
        return baseDao.selectRestPrincipalAmountByContNo(contNo);
    }

    /**
     * @Description: 根据申请编号查找财务还款计划表未还款剩余本金
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/24 11:05
     * @param
     */
    @Override
    public BigDecimal selectRestPrincipalAmountByApplyNo(String contNo) {
        return baseDao.selectRestPrincipalAmountByApplyNo(contNo);
    }

}
