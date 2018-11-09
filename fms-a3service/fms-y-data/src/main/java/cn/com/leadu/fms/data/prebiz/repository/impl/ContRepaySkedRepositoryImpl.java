package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.ContRepaySkedDao;
import cn.com.leadu.fms.data.prebiz.repository.ContRepaySkedRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedApplyNo;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedGetPhoneNumVo;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedInfoVo;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import cn.com.leadu.fms.pojo.finance.vo.countdistributeoverdue.OverdueDataVo;
import cn.com.leadu.fms.pojo.postbiz.vo.monthlyoverdue.MonthlyOverdueVo;
import cn.com.leadu.fms.pojo.postbiz.vo.monthlyrent.MonthlyRentVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepaySked;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContractVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContRepaySkedRepositoryImpl
 * @Description: 客户还款计划表Repository 实现层
 * @date 2018-04-10
 */
@Repository
public class ContRepaySkedRepositoryImpl extends AbstractBaseRepository<ContRepaySkedDao, ContRepaySked> implements ContRepaySkedRepository {

    /**
     * @Title:
     * @Description: 新增客户还款计划表
     * @param contRepaySked
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-10 17:19:05
     */
    @Override
    public int insertData(ContRepaySked contRepaySked) {
        return super.insert(contRepaySked);
    }

    /**
     * @Title:
     * @Description: 批量保存客户还款计划表
     * @param contRepaySkeds
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-10 17:19:05
     */
    @Override
    public int insertDataList(List<ContRepaySked> contRepaySkeds){
        return super.insertListByJdbcTemplate(contRepaySkeds);
    }

    /**
     * @Title:
     * @Description: 修改客户还款计划表
     * @param contRepaySked
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-10 17:19:05
     */
    @Override
    public int updateByPrimaryKeyData(ContRepaySked contRepaySked) {
        return super.updateByPrimaryKey(contRepaySked);
    }

    /**
     * @Title:
     * @Description: 批量修改客户还款计划表
     * @param contRepaySkeds
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-10 17:19:05
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ContRepaySked> contRepaySkeds){
        return super.updateListByPrimaryKey(contRepaySkeds);
    }

    /**
     * @Title:
     * @Description: 动态修改客户还款计划表
     * @param contRepaySked
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-10 17:19:05
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ContRepaySked contRepaySked) {
        return super.updateByPrimaryKeySelective(contRepaySked);
    }

    /**
     * @Title:
     * @Description: 批量动态修改客户还款计划表
     * @param contRepaySkeds
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-10 17:19:05
     */
    public int updateByPrimaryKeySelectiveDataList(List<ContRepaySked> contRepaySkeds) {
        return super.updateListByPrimaryKeySelective(contRepaySkeds);
    }

    /**
     * @Title:
     * @Description: 根据条件修改客户还款计划表
     * @param contRepaySked
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-10 17:19:05
     */
    @Override
    public int updateByExampleData(ContRepaySked contRepaySked, Example example) {
        return super.updateByExample(contRepaySked,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改客户还款计划表
     * @param contRepaySked
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-10 17:19:05
     */
    @Override
    public int updateByExampleSelectiveData(ContRepaySked contRepaySked, Example example){
        return super.updateByExampleSelective(contRepaySked,example);
    }
    
    /**
     * @Title:
     * @Description: 根据repaySkedId删除客户还款计划表
     * @param contRepaySked
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-10 17:19:05
     */
    @Override
    public int deleteData(ContRepaySked contRepaySked) {
        return super.delete(contRepaySked);
    }

    /**
     * @Title:
     * @Description: 根据repaySkedId集合批量删除客户还款计划表
     * @param contRepaySked
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-10 17:19:05
     */
    public int deleteDataList(List repaySkedIds,ContRepaySked contRepaySked){
        return super.deleteByIds(repaySkedIds,contRepaySked);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除客户还款计划表
     * @param example
     * @param contRepaySked
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-4-10 17:19:05
     */
    public int deleteExampleData(Example example,ContRepaySked contRepaySked){
        return super.deleteByExample(example,contRepaySked);
    }

    /**
     * @Title:
     * @Description: 查询全部客户还款计划表
     * @return List<ContRepaySked>
     * @throws
     * @author liujinge
     * @date 2018-4-10 17:19:05
     */
    @Override
    public List<ContRepaySked> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个客户还款计划表
     * @param example
     * @return ContRepaySked
     * @throws
     * @author liujinge
     * @date 2018-4-10 17:19:05
     */
    @Override
    public ContRepaySked selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询客户还款计划表
     * @param example
     * @return List<ContRepaySked>
     * @throws
     * @author liujinge
     * @date 2018-4-10 17:19:05
     */
    @Override
    public List<ContRepaySked> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过repaySkedId查询客户还款计划表
     * @param repaySkedId
     * @return ContRepaySked
     * @throws
     * @author liujinge
     * @date 2018-4-10 17:19:05
     */
    @Override
    public ContRepaySked selectByPrimaryKey(Object repaySkedId) {
        return super.selectByPrimaryKey(repaySkedId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询客户还款计划表
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ContRepaySked>
     * @throws
     * @author liujinge
     * @date 2018-4-10 17:19:05
     */
    @Override
    public PageInfoExtend<ContRepaySked> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询客户还款计划表vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<ContRepaySked>
     * @throws
     * @author liujinge
     * @date 2018-4-10 17:19:05
     */
    public PageInfoExtend<ContRepaySkedVo> selectListVoByPage(String methodName, Object param, PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Description: 查询逾期租金合计
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/14 11:03
     */
    @Override
    public BigDecimal selectContRepaySkedOverdueRentSum(ContRepaySkedVo contRepaySkedVo) {
        return baseDao.selectContRepaySkedOverdueRentSum(contRepaySkedVo);
    }

    /**
     * @Description:根据合同号查找合同数量
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/14 11:05
     * @param contNo
     */
    @Override
    public Integer selectContRepaySkeCountByContNo(String contNo) {
        return baseDao.selectContRepaySkeCountByContNo(contNo);
    }

    /**
     * @Description: 查找合同还款计划表明细
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/22 11:05
     * @param
     */
    @Override
    public List<ContRepaySkedInfoVo> selectContRepaySkedGroupByContNo() {
        return baseDao.selectContRepaySkedGroupByContNo();
    }

    /**
     * @Description: 查找合同还款计划表未还款剩余本金
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/23 11:05
     * @param
     */
    @Override
    public BigDecimal selectRestPrincipalAmountByContNo(String contNo) {
        return baseDao.selectRestPrincipalAmountByContNo(contNo);
    }

    /**
     * @Description:根据合同号查找合同已还期数
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/23 11:05
     * @param contNo
     */
    @Override
    public Integer selectAlreadyRepaySkeCountByContNo(String contNo) {
        return baseDao.selectAlreadyRepaySkeCountByContNo(contNo);
    }

    /**
     * @Description: 根据申请号查找一条数据
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/23 11:05
     * @param applyNo
     */
    @Override
    public ContRepaySkedApplyNo selectContRepaySkedByApplyNo(String applyNo) {
        return baseDao.selectContRepaySkedByApplyNo(applyNo);
    }

    /**
     * @Description: 根据申请编号查找合同还款计划表未还款剩余本金
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/22 11:05
     * @param
     */
    @Override
    public BigDecimal selectRestPrincipalAmountByApplyNo(String applyNo) {
        return baseDao.selectRestPrincipalAmountByApplyNo(applyNo);
    }

    /**
     * @param contRepaySkedVo
     * @Description: 计算剩余租金, 根据合同编号和扣款状态不成功的
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/15 14:17
     */
    @Override
    public BigDecimal selectContRepaySkedRentSum(ContRepaySkedVo contRepaySkedVo) {
        return baseDao.selectContRepaySkedRentSum(contRepaySkedVo);
    }

    /**
     * @Description: 查找即将到还款日期的数据
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/7/12 16:07
     */
    @Override
    public List<ContRepaySkedVo> selectOnceOverdueSked(ContRepaySkedVo contRepaySkedVo) {
        return baseDao.selectOnceOverdueSked(contRepaySkedVo);
    }

    /**
     * @Title:
     * @Description: 根据contReceiptExamId获取ContRepaySkedVo
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public List<ContRepaySkedVo> selectContReceiptDetailByContReceiptExamId(List<String> contReceiptExamIdList){
        return baseDao.selectContReceiptDetailByContReceiptExamId(contReceiptExamIdList);
    }

    /**
     * @Title:
     * @Description: 从销售还款计划表中获取全部的逾期数据
     * @param  repayStatusList 还款状态集合
     * @return List<OverdueDataVo>
     * @throws
     * @author wangxue
     * @date
     */
    @Override
    public List<OverdueDataVo> selectOverdueDataVoGroupByContNo(List<String> repayStatusList) {
        return baseDao.selectOverdueDataVoGroupByContNo(repayStatusList);
    }


    /**
     * @Title:
     * @Description: 查询逾期数据
     * @return List<OverdueDataVo>
     * @throws
     * @author qinmuqiao
     * @date
     */
    @Override
    public List<ContRepaySkedVo> selecContOverdueSkedMessageSend(ContRepaySkedVo contRepaySkedVo,Integer maxDays,Integer minDays) {
        return baseDao.selecContOverdueSkedMessageSend(contRepaySkedVo, maxDays, minDays);
    }

    /**
     * @Title:
     * @Description: 获取当日到期的数据发送短信
     * @return OverdueDataVo
     * @throws
     * @author qinmuqiao
     * @date
     */
    @Override
    public List<ContRepaySkedVo> selecContDueDateSkedMessageSend(ContRepaySkedVo contRepaySkedVo){
        return baseDao.selecContDueDateSkedMessageSend(contRepaySkedVo);
    }

    /**
     * @Title:
     * @Description: 获取逾期的数据的手机号
     * @return OverdueDataVo
     * @throws
     * @author qinmuqiao
     * @date
     */
    @Override
    public List<ContRepaySkedGetPhoneNumVo> findContOverdueSkedPhoneNumByApplyNoes(List<String> applyNoList){
        return baseDao.findContOverdueSkedPhoneNumByApplyNoes(applyNoList);
    }


    /**
     * @Title:
     * @Description: 获取累计逾期金额合计以及客户数
     * @return MonthlyOverdueVo
     * @throws
     * @author wangxue
     * @date
     */
    @Override
    public MonthlyRentVo selectOverdueSumRentAndCount(ContRepaySkedVo contRepaySkedVo) {
        return baseDao.selectOverdueSumRentAndCount(contRepaySkedVo);
    }

    /**
     * @Title:
     * @Description: 根据查询月份，获取当月的金额合计和合同个数
     * @return MonthlyOverdueVo
     * @throws
     * @author wangxue
     * @date
     */
    @Override
    public MonthlyRentVo selectSumRentAndCountByMonth(ContRepaySkedVo contRepaySkedVo) {
        return baseDao.selectSumRentAndCountByMonth(contRepaySkedVo);
    }

    /**
     * @Title:
     * @Description: 获取逾期客户的剩余未还本金合计
     * @return monthlyOverdueVo 查询参数
     * @return BigDecimal
     * @throws
     * @author wangxue
     */
    @Override
    public BigDecimal selectOverdueSumPrincipalByCompanyType(MonthlyOverdueVo monthlyOverdueVo) {
        return baseDao.selectOverdueSumPrincipalByCompanyType(monthlyOverdueVo);
    }

    /**
     * @Title:
     * @Description: 获取客户的剩余未还本金合计
     * @return companyTypeList 申请类型1
     * @return BigDecimal
     * @throws
     * @author wangxue
     */
    @Override
    public BigDecimal selectSumPrincipalByCompanyType(List<String> companyTypeList) {
        return baseDao.selectSumPrincipalByCompanyType(companyTypeList);
    }

    /**
     * 根据申请编号获取所有需要发送短信的联系人
     * @Param applyNoList
     */
    @Override
    public List<ContRepaySkedGetPhoneNumVo> getAllContactNosByApplyNo(List<String> applyNoList) {
        return baseDao.getAllContactNosByApplyNo(applyNoList);
    }

    /**
     * 根据合同编号查找需要归还的最新一期信息
     * @param contNo
     * @return ContRepaySkedVo
     */
    @Override
    public ContRepaySkedVo selectContRepaySkedToBePay(String contNo) {
        return baseDao.selectContRepaySkedToBePay(contNo);
    }

    /**
    * @Description: 获取凭证核算代码
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/11/6 16:51
    */
    @Override
    public ContractVo selectContractVoFinassCodesByRecAcountNo(String groupCode, String recAcountNo) {
        return baseDao.selectContractVoFinassCodesByRecAcountNo(groupCode,recAcountNo);
    }
}
