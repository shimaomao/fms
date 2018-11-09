package cn.com.leadu.fms.data.finance.repository.impl;

import cn.com.leadu.fms.data.finance.dao.ContOverdueDao;
import cn.com.leadu.fms.data.finance.repository.ContOverdueRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.finance.entity.ContOverdue;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.vo.contoverdue.ContOverdueVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: ContOverdueRepositoryImpl
 * @Description: 还款逾期罚息Repository 实现层
 * @date 2018-05-08
 */
@Repository
public class ContOverdueRepositoryImpl extends AbstractBaseRepository<ContOverdueDao, ContOverdue> implements ContOverdueRepository {

    /**
     * @Title:
     * @Description: 新增还款逾期罚息
     * @param contOverdue
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @Override
    public int insertData(ContOverdue contOverdue) {
        return super.insert(contOverdue);
    }

    /**
     * @Title:
     * @Description: 批量保存还款逾期罚息
     * @param contOverdues
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @Override
    public int insertDataList(List<ContOverdue> contOverdues){
        return super.insertListByJdbcTemplate(contOverdues);
    }

    /**
     * @Title:
     * @Description: 修改还款逾期罚息
     * @param contOverdue
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @Override
    public int updateByPrimaryKeyData(ContOverdue contOverdue) {
        return super.updateByPrimaryKey(contOverdue);
    }

    /**
     * @Title:
     * @Description: 批量修改还款逾期罚息
     * @param contOverdues
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ContOverdue> contOverdues){
        return super.updateListByPrimaryKey(contOverdues);
    }

    /**
     * @Title:
     * @Description: 动态修改还款逾期罚息
     * @param contOverdue
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ContOverdue contOverdue) {
        return super.updateByPrimaryKeySelective(contOverdue);
    }

    /**
     * @Title:
     * @Description: 批量动态修改还款逾期罚息
     * @param contOverdues
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    public int updateByPrimaryKeySelectiveDataList(List<ContOverdue> contOverdues) {
        return super.updateListByPrimaryKeySelective(contOverdues);
    }

    /**
     * @Title:
     * @Description: 根据条件修改还款逾期罚息
     * @param contOverdue
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @Override
    public int updateByExampleData(ContOverdue contOverdue, Example example) {
        return super.updateByExample(contOverdue,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改还款逾期罚息
     * @param contOverdue
     * @param example
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @Override
    public int updateByExampleSelectiveData(ContOverdue contOverdue, Example example){
        return super.updateByExampleSelective(contOverdue,example);
    }
    
    /**
     * @Title:
     * @Description: 根据contOverdueId删除还款逾期罚息
     * @param contOverdue
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @Override
    public int deleteData(ContOverdue contOverdue) {
        return super.delete(contOverdue);
    }

    /**
     * @Title:
     * @Description: 根据contOverdueId集合批量删除还款逾期罚息
     * @param contOverdue
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    public int deleteDataList(List contOverdueIds,ContOverdue contOverdue){
        return super.deleteByIds(contOverdueIds,contOverdue);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除还款逾期罚息
     * @param example
     * @param contOverdue
     * @return int
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    public int deleteExampleData(Example example,ContOverdue contOverdue){
        return super.deleteByExample(example,contOverdue);
    }

    /**
     * @Title:
     * @Description: 查询全部还款逾期罚息
     * @return List<ContOverdue>
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @Override
    public List<ContOverdue> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个还款逾期罚息
     * @param example
     * @return ContOverdue
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @Override
    public ContOverdue selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询还款逾期罚息
     * @param example
     * @return List<ContOverdue>
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @Override
    public List<ContOverdue> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过contOverdueId查询还款逾期罚息
     * @param contOverdueId
     * @return ContOverdue
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @Override
    public ContOverdue selectByPrimaryKey(Object contOverdueId) {
        return super.selectByPrimaryKey(contOverdueId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询还款逾期罚息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ContOverdue>
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @Override
    public PageInfoExtend<ContOverdue> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询还款逾期罚息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @param contOverdueVo
     * @Description: 查询逾期罚息表中，扣款状态<>成功 的剩余罚息金额合计
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/14 14:51
     */
    @Override
    public BigDecimal selectOverdueInterestSum(ContOverdueVo contOverdueVo) {
        return baseDao.selectOverdueInterestSum(contOverdueVo);
    }

    /**
     * @Description:  查询罚息表中未还款数量
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/15 14:54
     */
    @Override
    public Integer selectCountOverDueByContNo(String contNo) {
        return baseDao.selectCountOverDueByContNo(contNo);
    }

    /**
     * @Description: 根据合同号查找总罚息
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/15 14:54
     */
    @Override
    public BigDecimal selectContOverdueAmountByContNo(String contNo) {
        return baseDao.selectContOverdueAmountByContNo(contNo);
    }
    /**
     * @Description: 根据申请号查找总罚息
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/15 14:54
     */
    @Override
    public BigDecimal selectContOverdueAmountByApplyNo(String applyNo) {
        return baseDao.selectContOverdueAmountByApplyNo(applyNo);
    }

    /**
     * @Title:
     * @Description: 根据合同号关联查询逾期罚息表和还款计划表
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public List<ContOverdueVo> selectContOverdueByCont(String contNo){
        return baseDao.selectContOverdueByCont(contNo);
    }
}
