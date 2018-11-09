package cn.com.leadu.fms.pojo.postbiz.vo.overduecstm;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.ExcelTypeConstants;
import cn.com.leadu.fms.common.util.DateUtils;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * 逾期客户一览返回Vo
 * Created by root on 2018/9/21.
 */
@Data
@ExcelTitle(value ="逾期客户信息",types = {ExcelTypeConstants.ONE, ExcelTypeConstants.TWO})
public class OverduePostVo {

    private static final long serialVersionUID = 1L;

    /*逾期客户信息*/
    /**
     * @Fields  : 逾期客户ID
     * @author lijunjun
     */
    private String overdueCstmId;

    /**
     * @Fields  : 客户姓名
     * @author lijunjun
     */
    private String cstmName;

    /**
     * @Fields  : 出租人
     * @author lijunjun
     */
    private String groupName;

    /**
     * @Fields  : 证件类型
     * @author lijunjun
     */
    private String certifType;

    /**
     * @Fields  : 证件号码
     * @author lijunjun
     */
    private String certifNo;

    /**
     * @Fields  : 当前逾期天数
     * @author lijunjun
     */
    private String overdueDays;

    /**
     * @Fields  : 当前逾期期数
     * @author lijunjun
     */
    private String overduePeriods;

    /**
     * @Fields  : 当前逾期本金
     * @author lijunjun
     */
    private String overduePrincipal;

    /**
     * @Fields  : 当前逾期租金
     * @author lijunjun
     */
    private String overdueRent;

    /**
     * @Fields  : 当前逾期罚息
     * @author lijunjun
     */
    private String overdueAmount;

    /**
     * @Fields  : 催收类型
     * @author lijunjun
     */
    private String assignmentType;

    /**
     * @Fields  : 分配人员账号
     * @author lijunjun
     */
    private String assignUser;

    /**
     * @Fields  : 任务处理状态
     * @author lijunjun
     */
    private String assignmentSts;

    /*逾期合同信息*/
    /**
     * @Fields  : 逾期合同Id
     * @author lijunjun
     */
    private String overdueContId;
    /**
     * @Fields  : 合同编号
     * @author lijunjun
     */
    private String contNo;

    /**
     * @Fields  : 车架号
     * @author lijunjun
     */
    private String vinNo;

    /**
     * @Fields  : 车辆类型
     * @author lijunjun
     */
    private String vehicleForm;

    /**
     * @Fields  : 合同生效日期
     * @author lijunjun
     */
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    private Date contractValidDate;

    /**
     * @Fields  : 发动机号
     * @author lijunjun
     */
    private String engineNo;

    /**
     * @Fields  : 车牌号
     * @author lijunjun
     */
    private String vehicleLicenseNo;

    /**
     * @Fields  : 品牌
     * @author lijunjun
     */
    private String vehBrandCode;

    /**
     * @Fields  : 车辆品牌名称
     */
    private String vehBrandCodeName;

    /**
     * @Fields  : 车型
     * @author lijunjun
     */
    private String vehicleCode;

    /**
     * @Fields  : 车型名称
     */
    private String vehicleCodeName;

    /**
     * @Fields  : 车辆配置描述
     * @author lijunjun
     */
    private String vehicleComment;

    /**
     * @Fields  : 颜色
     * @author lijunjun
     */
    private String color;

    /**
     * @Fields  : 当前逾期天数
     * @author lijunjun
     */
    private String contOverdueDays;

    /**
     * @Fields  : 当前逾期期数
     * @author lijunjun
     */
    private String contOverduePeriods;

    /**
     * @Fields  : 当前逾期本金
     * @author lijunjun
     */
    private String contOverduePrincipal;

    /**
     * @Fields  : 当前逾期租金
     * @author lijunjun
     */
    private String contOverdueRent;

    /**
     * @Fields  : 当前逾期罚息
     * @author lijunjun
     */
    private String contOverdueAmount;

    /**
     * @Fields  : 当前逾期总额
     * @author lijunjun
     */
    private String contOverdueSum;

    /**
     * @Fields  : 融资期限
     * @author lijunjun
     */
    private String finPeriodType;

    /**
     * @Fields  : 已还期数
     * @author lijunjun
     */
    private String repayPeriods;

    /**
     * @Fields  : 历史最高逾期天数
     * @author lijunjun
     */
    private String overdueDaysHis;

    /**
     * @Fields  : 逾期次数
     * @author lijunjun
     */
    private String overdueTimes;

    /**
     * @Fields  : 当前是否逾期
     * @author lijunjun
     */
    private String overdueFlag;

    /**
     * @Fields  : 申请类型
     * @author lijunjun
     */
    private String applyType;

    /**
     * @Fields  : 逾期客户初登日期
     * @author lijunjun
     */
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    private Date cstmFirstOverdueDate;

    /**
     * @Fields  : 逾期合同初登日期
     * @author lijunjun
     */
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    private Date contFirstOverdueDate;

    @ExcelTitle(value ="客户姓名", sort = 1, types = {ExcelTypeConstants.ONE})
    public String getCstmName(){return this.cstmName;}

    @ExcelTitle(value ="证件号码", sort = 2, types = {ExcelTypeConstants.ONE})
    public String getCertifNo(){return this.certifNo;}

    @ExcelTitle(value ="合同号", sort = 3, types = {ExcelTypeConstants.ONE})
    public String getContNo(){return this.contNo;}

    @ExcelTitle(value ="车架号", sort = 4, types = {ExcelTypeConstants.ONE})
    public String getVinNo(){return this.vinNo;}

    @ExcelTitle(value ="车辆类型", sort = 5, codeType = CommonCodeTypeConstants.VEHICLE_FORM, types = {ExcelTypeConstants.ONE})
    public String getVehicleForm(){return this.vehicleForm;}

    @ExcelTitle(value ="合同生效日期", sort = 6, types = {ExcelTypeConstants.ONE})
    public String getContractValidDateStr(){return DateUtils.dateToStr(this.contractValidDate,DateUtils.formatStr_yyyyMMdd);}

    @ExcelTitle(value ="发动机号", sort = 7, types = {ExcelTypeConstants.ONE})
    public String getEngineNo(){return this.engineNo;}

    @ExcelTitle(value ="车牌号", sort = 8, types = {ExcelTypeConstants.ONE})
    public String getVehicleLicenseNo(){return this.vehicleLicenseNo;}

    @ExcelTitle(value ="品牌", sort = 9, types = {ExcelTypeConstants.ONE})
    public String getVehBrandCodeName(){return this.vehBrandCodeName;}

    @ExcelTitle(value ="车型", sort = 10, types = {ExcelTypeConstants.ONE})
    public String getVehicleCodeName(){return this.vehicleCodeName;}

    @ExcelTitle(value ="车辆配置描述", sort = 11, types = {ExcelTypeConstants.ONE})
    public String getVehicleComment(){return this.vehicleComment;}

    @ExcelTitle(value ="颜色", sort = 12, types = {ExcelTypeConstants.ONE})
    public String getColor(){return this.color;}

    @ExcelTitle(value ="客户当前逾期天数", sort = 13, types = {ExcelTypeConstants.ONE})
    public String getOverdueDays(){return this.overdueDays;}

    @ExcelTitle(value ="客户当前逾期期数", sort = 14, types = {ExcelTypeConstants.ONE})
    public String getOverduePeriods(){return this.overduePeriods;}

    @ExcelTitle(value ="客户当前逾期本金", sort = 15, types = {ExcelTypeConstants.ONE})
    public String getOverduePrincipal(){return this.overduePrincipal;}

    @ExcelTitle(value ="客户当前逾期租金", sort = 16, types = {ExcelTypeConstants.ONE})
    public String getOverdueRent(){return this.overdueRent;}

    @ExcelTitle(value ="客户当前逾期罚息", sort = 17, types = {ExcelTypeConstants.ONE})
    public String getOverdueAmount(){return this.overdueAmount;}

    @ExcelTitle(value ="合同当前逾期天数", sort = 18, types = {ExcelTypeConstants.ONE})
    public String getContOverdueDays(){return this.contOverdueDays;}

    @ExcelTitle(value ="合同当前逾期期数", sort = 19, types = {ExcelTypeConstants.ONE})
    public String getContOverduePeriods(){return this.contOverduePeriods;}

    @ExcelTitle(value ="合同当前逾期本金", sort = 20, types = {ExcelTypeConstants.ONE})
    public String getContOverduePrincipal(){return this.contOverduePrincipal;}

    @ExcelTitle(value ="合同当前逾期租金", sort = 21, types = {ExcelTypeConstants.ONE})
    public String getContOverdueRent(){return this.contOverdueRent;}

    @ExcelTitle(value ="合同当前逾期罚息", sort = 22, types = {ExcelTypeConstants.ONE})
    public String getContOverdueAmount(){return this.contOverdueAmount;}

    @ExcelTitle(value ="当前是否逾期", sort = 23, codeType = CommonCodeTypeConstants.OVERDUE_FLAG, types = {ExcelTypeConstants.ONE})
    public String getOverdueFlag(){return this.overdueFlag;}

    @ExcelTitle(value ="催收类型", sort = 24, codeType = CommonCodeTypeConstants.ASSIGNMENT_TYPE, types = {ExcelTypeConstants.ONE})
    public String getAssignmentType(){return this.assignmentType;}

    @ExcelTitle(value ="分配人员账号", sort = 25, types = {ExcelTypeConstants.ONE})
    public String getAssignUser(){return this.assignUser;}

    @ExcelTitle(value ="任务处理状态", sort = 26, codeType = CommonCodeTypeConstants.ASSIGNMENT_STS, types = {ExcelTypeConstants.ONE})
    public String getAssignmentSts(){return this.assignmentSts;}

}
