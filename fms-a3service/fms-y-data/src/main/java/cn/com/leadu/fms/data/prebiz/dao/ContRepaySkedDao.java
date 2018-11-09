package cn.com.leadu.fms.data.prebiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedApplyNo;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedGetPhoneNumVo;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedInfoVo;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import cn.com.leadu.fms.pojo.finance.vo.countdistributeoverdue.OverdueDataVo;

import cn.com.leadu.fms.pojo.postbiz.vo.monthlyoverdue.MonthlyOverdueVo;
import cn.com.leadu.fms.pojo.postbiz.vo.monthlyrent.MonthlyRentVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepaySked;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContractVo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContRepaySkedDao
 * @Description: 客户还款计划表dao层
 * @date 2018-04-10
 */
public interface ContRepaySkedDao extends BaseDao<ContRepaySked> {


    /**
     * @Description: 获取待勾稽租金一览
     * @param:contRepaySkedVo
     * @return:
     * @Author: lijunjun
     * @Date: 2018/5/3 17:32
     */
    List<ContRepaySkedVo> selectContRepaySkedsByPage(@Param("contRepaySkedVo") ContRepaySkedVo contRepaySkedVo);


    /**
     * @Description: 获取待勾稽租金一览
     * @param:contRepaySkedVo
     * @return:
     * @Author: lijunjun
     * @Date: 2018/5/3 17:32
     */
    List<ContRepaySkedVo> selectContRepaySkedClaimeByPage(@Param("contRepaySkedVo") ContRepaySkedVo contRepaySkedVo);


    /**
     * @Description: 获取待勾稽租金一览
     * @param:contRepaySkedVo
     * @return:
     * @Author: lijunjun
     * @Date: 2018/5/3 17:32
     */
    List<ContRepaySkedVo> selectContRepaySkedClaimesByPage(@Param("contRepaySkedVo") ContRepaySkedVo contRepaySkedVo);

    /**
     * @Description: 查询勾稽明细信息
     * @param:contRepaySkedVo
     * @return:
     * @Author: lijunjun
     * @Date: 2018/5/3 17:32
     */
    List<ContRepaySkedVo> selectContReceiptDetailsByPage(@Param("contRepaySkedVo") ContRepaySkedVo contRepaySkedVo);

    /** 
    * @Description: 查询逾期租金合计
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/14 11:05
     * @param contRepaySkedVo
    */ 
    BigDecimal selectContRepaySkedOverdueRentSum(@Param("contRepaySkedVo") ContRepaySkedVo contRepaySkedVo);

    /**
     * @Description:根据合同号查找合同数量
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/14 11:05
     * @param contNo
     */
    Integer selectContRepaySkeCountByContNo(@Param("contNo") String contNo);

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
     * @Date: 2018/5/22 11:05
     * @param
     */
    BigDecimal selectRestPrincipalAmountByContNo(@Param("contNo") String contNo);

    /**
     * @Description:根据合同号查找合同已还期数
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/23 11:05
     * @param contNo
     */
    Integer selectAlreadyRepaySkeCountByContNo(@Param("contNo") String contNo);

    /**
     * @Description: 根据申请号查找一条数据
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/23 11:05
     * @param
     */
    ContRepaySkedApplyNo selectContRepaySkedByApplyNo(@Param("applyNo") String applyNo);


    /**
     * @Description: 根据申请编号查找合同还款计划表未还款剩余本金
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/22 11:05
     * @param
     */
    BigDecimal selectRestPrincipalAmountByApplyNo(@Param("applyNo") String applyNo);

    /** 
    * @Description: 计算剩余租金, 根据合同编号和扣款状态不成功的
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/15 14:37
    */ 
    BigDecimal selectContRepaySkedRentSum(@Param("contRepaySkedVo")ContRepaySkedVo contRepaySkedVo);

    /**
     * @Description: 查找即将到还款日期的数据
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/7/12 16:07
     */
    List<ContRepaySkedVo> selectOnceOverdueSked(@Param("contRepaySkedVo") ContRepaySkedVo contRepaySkedVo);

    /**
     * @Description: 分页查询销售还款计划表数据
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/8/7 16:07
     */
    List<ContRepaySkedVo> selectContRepaySkedDetailByPage(@Param("contRepaySkedVo") ContRepaySkedVo contRepaySkedVo);

    /**
     * @Description: 结清车辆租金明细表(导出用)
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/8/7 16:07
     */
    List<ContRepaySkedVo> selectContRepaySkedSettleEndExport(@Param("contRepaySkedVo") ContRepaySkedVo contRepaySkedVo);

    /**
     * @Description: 未收租金明细表(导出用)
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/8/7 16:07
     */
    List<ContRepaySkedVo> selectContRepaySkedUnpaidRentExport(@Param("contRepaySkedVo") ContRepaySkedVo contRepaySkedVo);

    /**
     * @Title:
     * @Description: 根据contReceiptExamId获取ContRepaySkedVo
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    List<ContRepaySkedVo> selectContReceiptDetailByContReceiptExamId(@Param("contReceiptExamIdList")List<String> contReceiptExamIdList);

    /**
     * @Title:
     * @Description: 从销售还款计划表中获取全部的逾期数据
     * @param  repayStatusList 还款状态集合
     * @return OverdueDataVo
     * @throws
     * @author wangxue
     * @date
     */
    List<OverdueDataVo> selectOverdueDataVoGroupByContNo(@Param("repayStatusList") List<String> repayStatusList);

    /**
     * @Title:
     * @Description: 获取逾期的数据的手机号
     * @return OverdueDataVo
     * @throws
     * @author qinmuqiao
     * @date
     */
    List<ContRepaySkedGetPhoneNumVo> findContOverdueSkedPhoneNumByApplyNoes(@Param("applyNoList") List<String> applyNoList);


    /**
     * @Title:
     * @Description: 获取逾期的数据发送短信
     * @return OverdueDataVo
     * @throws
     * @author qinmuqiao
     * @date
     */
    List<ContRepaySkedVo> selecContOverdueSkedMessageSend(@Param("contRepaySkedVo") ContRepaySkedVo contRepaySkedVo,@Param("maxDays") Integer maxDays,@Param("minDays") Integer minDays);


    /**
     * @Title:
     * @Description: 获取当日到期的数据发送短信
     * @return OverdueDataVo
     * @throws
     * @author qinmuqiao
     * @date
     */
    List<ContRepaySkedVo> selecContDueDateSkedMessageSend(@Param("contRepaySkedVo") ContRepaySkedVo contRepaySkedVo);





    /**
     * @Title:
     * @Description: 获取累计逾期金额合计以及客户数
     * @return MonthlyRentVo
     * @throws
     * @author wangxue
     */
    MonthlyRentVo selectOverdueSumRentAndCount(@Param("contRepaySkedVo") ContRepaySkedVo contRepaySkedVo);

    /**
     * @Title:
     * @Description: 根据查询月份，获取当月的金额合计和合同个数
     * @return MonthlyRentVo
     * @throws
     * @author wangxue
     */
    MonthlyRentVo selectSumRentAndCountByMonth(@Param("contRepaySkedVo") ContRepaySkedVo contRepaySkedVo);

    /**
     * @Title:
     * @Description: 获取逾期客户的剩余未还本金合计
     * @return monthlyOverdueVo 查询参数
     * @return BigDecimal
     * @throws
     * @author wangxue
     */
    BigDecimal selectOverdueSumPrincipalByCompanyType(@Param("monthlyOverdueVo") MonthlyOverdueVo monthlyOverdueVo);

    /**
     * @Title:
     * @Description: 获取客户的剩余未还本金合计
     * @return companyTypeList 申请类型1
     * @return BigDecimal
     * @throws
     * @author wangxue
     */
    BigDecimal selectSumPrincipalByCompanyType(@Param("companyTypeList") List<String> companyTypeList);

    /**
     * 根据申请编号获取所有需要发送短信的联系人
     * @Param applyNoList
     */
    List<ContRepaySkedGetPhoneNumVo> getAllContactNosByApplyNo(@Param("applyNoList")  List<String> applyNoList);

    /**
     * 根据合同编号查找需要归还的最新一期信息
     * @param contNo
     * @return ContRepaySkedVo
     */
    ContRepaySkedVo selectContRepaySkedToBePay(@Param("contNo") String contNo);

    /**
    * @Description: 获取凭证核算代码
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/11/6 16:52
    */
    ContractVo selectContractVoFinassCodesByRecAcountNo(@Param("groupCode") String groupCode, @Param("recAcountNo") String recAcountNo);
}