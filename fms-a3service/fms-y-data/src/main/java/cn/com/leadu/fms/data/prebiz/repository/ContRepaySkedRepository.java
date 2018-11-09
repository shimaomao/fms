package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedApplyNo;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedGetPhoneNumVo;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedInfoVo;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import cn.com.leadu.fms.pojo.finance.vo.countdistributeoverdue.OverdueDataVo;
import cn.com.leadu.fms.pojo.postbiz.vo.monthlyoverdue.MonthlyOverdueVo;
import cn.com.leadu.fms.pojo.postbiz.vo.monthlyrent.MonthlyRentVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepaySked;
import java.math.BigDecimal;
import java.util.List;

import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContractVo;
import tk.mybatis.mapper.entity.Example;

/**
 * @author liujinge
 * @ClassName: ContRepaySkedRepository
 * @Description: 客户还款计划表Repository层
 * @date 2018-04-10
 */
public interface ContRepaySkedRepository {

	/**
	 * @Title:
	 * @Description: 新增客户还款计划表
	 * @param contRepaySked
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-10 17:19:05
	 */
	int insertData(ContRepaySked contRepaySked);

	/**
	 * @Title:
	 * @Description: 批量保存客户还款计划表
	 * @param contRepaySkeds
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-10 17:19:05
	 */
	int insertDataList(List<ContRepaySked> contRepaySkeds);

	/**
	 * @Title:
	 * @Description: 修改客户还款计划表
	 * @param contRepaySked
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-10 17:19:05
	 */
	int updateByPrimaryKeyData(ContRepaySked contRepaySked);

	/**
	 * @Title:
	 * @Description: 批量修改客户还款计划表
	 * @param contRepaySkeds
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-10 17:19:05
	 */
	int updateByPrimaryKeyDataList(List<ContRepaySked> contRepaySkeds);

	/**
	 * @Title:
	 * @Description: 动态修改客户还款计划表
	 * @param contRepaySked
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-10 17:19:05
	 */
	int updateByPrimaryKeySelectiveData(ContRepaySked contRepaySked);

	/**
	 * @Title:
	 * @Description: 批量动态修改客户还款计划表
	 * @param contRepaySkeds
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-10 17:19:05
	 */
	int updateByPrimaryKeySelectiveDataList(List<ContRepaySked> contRepaySkeds);

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
	int updateByExampleData(ContRepaySked contRepaySked, Example example);

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
	int updateByExampleSelectiveData(ContRepaySked contRepaySked, Example example);

	/**
	 * @Title:
	 * @Description: 根据repaySkedId删除客户还款计划表
	 * @param contRepaySked
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-10 17:19:05
	 */
	int deleteData(ContRepaySked contRepaySked);

	/**
	 * @Title:
	 * @Description: 根据repaySkedId集合批量删除客户还款计划表
	 * @param repaySkedIds
	 * @param contRepaySked
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-4-10 17:19:05
	 */
	int deleteDataList(List repaySkedIds, ContRepaySked contRepaySked);

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
	int deleteExampleData(Example example, ContRepaySked contRepaySked);

	/**
	 * @Title:
	 * @Description: 查询全部客户还款计划表
	 * @return List<ContRepaySked>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-10 17:19:05
	 */
	List<ContRepaySked> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个客户还款计划表
	 * @param example
	 * @return ContRepaySked
	 * @throws
	 * @author liujinge
	 * @date 2018-4-10 17:19:05
	 */
	ContRepaySked selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询客户还款计划表
	 * @param example
	 * @return List<ContRepaySked>
	 * @throws
	 * @author liujinge
	 * @date 2018-4-10 17:19:05
	 */
	List<ContRepaySked> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过repaySkedId查询客户还款计划表
	 * @param repaySkedId
	 * @return ContRepaySked
	 * @throws
	 * @author liujinge
	 * @date 2018-4-10 17:19:05
	 */
	ContRepaySked selectByPrimaryKey(Object repaySkedId);

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
	PageInfoExtend<ContRepaySked> selectListByExamplePage(Example example, PageQuery pageQuery);

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
	PageInfoExtend<ContRepaySkedVo> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/** 
	* @Description: 查询逾期租金合计
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/5/14 11:03
	*/
	BigDecimal selectContRepaySkedOverdueRentSum(ContRepaySkedVo contRepaySkedVo);


	/**
	 * @Description:根据合同号查找合同数量
	 * @param:
	 * @return:
	 * @Author: ningyangyang
	 * @Date: 2018/5/14 11:05
	 * @param contNo
	 */
	Integer selectContRepaySkeCountByContNo(String contNo);


	/**
	 * @Description: 查找合同还款计划表明细
	 * @param:
	 * @return:
	 * @Author: ningyangyang
	 * @Date: 2018/5/22 11:05
	 * @param
	 */
	List<ContRepaySkedInfoVo> selectContRepaySkedGroupByContNo();

	/**
	 * @Description: 查找合同还款计划表未还款剩余本金
	 * @param:
	 * @return:
	 * @Author: ningyangyang
	 * @Date: 2018/5/23 11:05
	 * @param
	 */
	BigDecimal selectRestPrincipalAmountByContNo(String contNo);

	/**
	 * @Description:根据合同号查找合同已还期数
	 * @param:
	 * @return:
	 * @Author: ningyangyang
	 * @Date: 2018/5/23 11:05
	 * @param contNo
	 */
	Integer selectAlreadyRepaySkeCountByContNo(String contNo);

	/**
	 * @Description: 根据申请号查找一条数据
	 * @param:
	 * @return:
	 * @Author: ningyangyang
	 * @Date: 2018/5/23 11:05
	 * @param
	 */
	ContRepaySkedApplyNo selectContRepaySkedByApplyNo( String applyNo);

	/**
	 * @Description: 根据申请编号查找合同还款计划表未还款剩余本金
	 * @param:
	 * @return:
	 * @Author: ningyangyang
	 * @Date: 2018/5/22 11:05
	 * @param
	 */
	BigDecimal selectRestPrincipalAmountByApplyNo( String applyNo);

	/** 
	* @Description: 计算剩余租金,根据合同编号和扣款状态不成功的
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/6/15 14:44
	*/ 
    BigDecimal selectContRepaySkedRentSum(ContRepaySkedVo contRepaySkedVo);

	/**
	 * @Description: 查找即将到还款日期的数据
	 * @param:
	 * @return:
	 * @Author: ningyangyang
	 * @Date: 2018/7/12 14:44
	 */
	List<ContRepaySkedVo> selectOnceOverdueSked(ContRepaySkedVo contRepaySkedVo);

	/**
	 * @Title:
	 * @Description: 根据contReceiptExamId获取ContRepaySkedVo
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	List<ContRepaySkedVo> selectContReceiptDetailByContReceiptExamId(List<String> contReceiptExamIdList);

	/**
	 * @Title:
	 * @Description: 从销售还款计划表中获取全部的逾期数据
	 * @param  repayStatusList 还款状态集合
	 * @return List<OverdueDataVo>
	 * @throws
	 * @author wangxue
	 * @date
	 */
	List<OverdueDataVo> selectOverdueDataVoGroupByContNo(List<String> repayStatusList);

	/**
	 * @Title:
	 * @Description: 逾期数据发送短信
	 * @return OverdueDataVo
	 * @throws
	 * @author qinmuqiao
	 * @date
	 */
	List<ContRepaySkedVo> selecContOverdueSkedMessageSend(ContRepaySkedVo contRepaySkedVo,Integer maxDays,Integer minDays);


	/**
	 * @Title:
	 * @Description: 获取当日到期的数据发送短信
	 * @return OverdueDataVo
	 * @throws
	 * @author qinmuqiao
	 * @date
	 */
	List<ContRepaySkedVo> selecContDueDateSkedMessageSend(ContRepaySkedVo contRepaySkedVo);

	/**
	 * @Title:
	 * @Description: 获取逾期的数据的手机号
	 * @return OverdueDataVo
	 * @throws
	 * @author qinmuqiao
	 * @date
	 */
	List<ContRepaySkedGetPhoneNumVo> findContOverdueSkedPhoneNumByApplyNoes(List<String> applyNoList);

	/**
	 * @Title:
	 * @Description: 获取累计逾期金额合计以及客户数
	 * @return MonthlyOverdueVo
	 * @throws
	 * @author wangxue
	 * @date
	 */
	MonthlyRentVo selectOverdueSumRentAndCount(ContRepaySkedVo contRepaySkedVo);

	/**
	 * @Title:
	 * @Description: 根据查询月份，获取当月的金额合计和合同个数
	 * @return MonthlyOverdueVo
	 * @throws
	 * @author wangxue
	 * @date
	 */
	MonthlyRentVo selectSumRentAndCountByMonth(ContRepaySkedVo contRepaySkedVo);

	/**
	 * @Title:
	 * @Description: 获取逾期客户的剩余未还本金合计
	 * @return monthlyOverdueVo 查询参数
	 * @return BigDecimal
	 * @throws
	 * @author wangxue
	 */
	BigDecimal selectOverdueSumPrincipalByCompanyType(MonthlyOverdueVo monthlyOverdueVo);

	/**
	 * @Title:
	 * @Description: 获取客户的剩余未还本金合计
	 * @return companyTypeList 申请类型1
	 * @return BigDecimal
	 * @throws
	 * @author wangxue
	 */
	BigDecimal selectSumPrincipalByCompanyType(List<String> companyTypeList);

	/**
	 * 根据申请编号获取所有需要发送短信的联系人
	 * @param applyNoList
	 * @return
	 */
	List<ContRepaySkedGetPhoneNumVo> getAllContactNosByApplyNo(List<String> applyNoList);

	/**
	 * 根据合同编号查找需要归还的最新一期信息
	 * @param contNo
	 * @return ContRepaySkedVo
	 */
	ContRepaySkedVo selectContRepaySkedToBePay(String contNo);

	/**
	* @Description: 获取凭证核算代码
	* @param: 
	* @return: 
	* @Author: yangyiquan
	* @Date: 2018/11/6 16:51
	*/
    ContractVo selectContractVoFinassCodesByRecAcountNo(String groupCode, String recAcountNo);
}
