package cn.com.leadu.fms.pojo.finance.vo.countdistributeoverdue;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCont;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wangxue
 * @ClassName: OverdueContDataVo
 * @Description: 逾期合同数据载体（定时任务用）
 * @date 2018-05-16
 */
@Data
public class OverdueDataVo extends PageQuery<OverdueCont> {
    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 逾期合同ID
     * @author wangxue
     */
    private String overdueContId;

    /**
     * @Fields  : 逾期客户ID
     * @author wangxue
     */
    private String overdueCstmId;

    /**
     * @Fields  : 申请编号
     * @author wangxue
     */
    private String applyNo;

    /**
     * @Fields  : 合同编号
     * @author wangxue
     */
    private String contNo;

    /**
     * @Fields  : 车辆类型
     * @author wangxue
     */
    private String vehicleForm;

    /**
     * @Fields  : 合同生成日期
     * @author wangxue
     */
    private Date contractDate;

    /**
     * @Fields  : 合同生效日期
     * @author wangxue
     */
    private Date contractValidDate;

    /**
     * @Fields  : 订单提出机构代码
     * @author wangxue
     */
    private String applyGroup;

    /**
     * @Fields  : 初登日期
     * @author wangxue
     */
    private Date firstOverdueDate;

    /**
     * @Fields  : 首期租金
     * @author wangxue
     */
    private BigDecimal rent;

    /**
     * @Fields  : 车架号
     * @author wangxue
     */
    private String vinNo;

    /**
     * @Fields  : 发动机号
     * @author wangxue
     */
    private String engineNo;

    /**
     * @Fields  : 车牌号
     * @author wangxue
     */
    private String vehicleLicenseNo;

    /**
     * @Fields  : 品牌
     * @author wangxue
     */
    private String vehBrandCode;

    /**
     * @Fields  : 车型
     * @author wangxue
     */
    private String vehicleCode;

    /**
     * @Fields  : 车辆配置描述
     * @author wangxue
     */
    private String vehicleComment;

    /**
     * @Fields  : 颜色
     * @author wangxue
     */
    private String color;

    /**
     * @Fields  : 归档状态
     * @author wangxue
     */
    private String origFileStatus;

    /**
     * @Fields  : 归档期限
     * @author wangxue
     */
    private Date origDeadline;

    /**
     * @Fields  : 当前逾期天数
     * @author wangxue
     */
    private Integer overdueDays;

    /**
     * @Fields  : 当前逾期期数
     * @author wangxue
     */
    private Integer overduePeriods;

    /**
     * @Fields  : 当前逾期本金
     * @author wangxue
     */
    private BigDecimal overduePrincipal;

    /**
     * @Fields  : 当前逾期租金
     * @author wangxue
     */
    private BigDecimal overdueRent;

    /**
     * @Fields  : 当前逾期罚息
     * @author wangxue
     */
    private BigDecimal overdueAmount;

    /**
     * @Fields  : 当前逾期总额
     * @author wangxue
     */
    private BigDecimal overdueSum;

    /**
     * @Fields  : 当前销售未还剩余本金
     * @author wangxue
     */
    private BigDecimal restPrincipal;

    /**
     * @Fields  : 当前财务未还剩余本金
     * @author wangxue
     */
    private BigDecimal finRestPrincipal;

    /**
     * @Fields  : 融资期限
     * @author wangxue
     */
    private String finPeriodType;

    /**
     * @Fields  : 已还期数
     * @author wangxue
     */
    private Integer repayPeriods;

    /**
     * @Fields  : 历史最高逾期天数
     * @author wangxue
     */
    private Integer overdueDaysHis;

    /**
     * @Fields  : 逾期次数
     * @author wangxue
     */
    private Integer overdueTimes;

    /**
     * @Fields  : 当前是否逾期
     * @author wangxue
     */
    private String overdueFlag;

    /**
     * @Fields  : 车辆处置评估金额
     * @author wangxue
     */
    private BigDecimal evaluatePrice;

    /**
     * @Fields  : 车辆处置金额
     * @author wangxue
     */
    private BigDecimal disposePrice;

    /**
     * @Fields  : 最小计划还款日期（逾期开始日期）
     * @author wangxue
     */
    private Date minRepayDate;

    /**
     * @Fields  : 申请类型
     * @author wangxue
     */
    private String applyType;

    /**
     * @Fields  : 客户姓名
     * @author wangxue
     */
    private String cstmName;

    /**
     * @Fields  : 证件类型
     * @author wangxue
     */
    private String certifType;

    /**
     * @Fields  : 证件号码
     * @author wangxue
     */
    private String certifNo;

    /**
     * @Fields  : 性别
     * @author wangxue
     */
    private String sex;



}
