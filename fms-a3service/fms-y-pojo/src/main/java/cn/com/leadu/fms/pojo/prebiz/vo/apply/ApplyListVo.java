package cn.com.leadu.fms.pojo.prebiz.vo.apply;/**
 * Created by yyq on 2018/5/3.
 */

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.Apply;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @program: fms
 * @description: 申请一览查询
 * @author: yangyiquan
 * @create: 2018-05-03 16:37
 **/
@Data
public class ApplyListVo extends PageQuery<Apply> {
    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 订单ID
     */
    private String applyId;

    /**
     * @Fields  : 订单编号
     */
    private String applyNo;
    /**
     * @Fields  : 申请类型
     */
    private String applyType;

    /**
     * @Fields  : 订单状态
     */
    private String bizStatus;

    /**
     * @Fields  : 订单提出账号
     */
    private String applyUser;

    /**
     * @Fields  : 订单提出机构代码
     */
    private String applyGroup;

    /**
     * @Fields  : 订单提出机构全称
     */
    private String applyGroupName;

    /**
     * @Fields  : 企业类型1
     * @author ningyangyang
     */
    private String companyType1;

    /**
     * @Fields  : 企业类型2
     * @author ningyangyang
     */
    private String companyType2;

    /**
     * @Fields  : 订单创建日期
     */
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    private Date applyCreatDate;

    /**
     * @Fields  : 订单首次提交日期
     */
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    private Date applyFirsbtDate;

    /**
     * @Fields  : 订单提交日期
     */
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    private Date applySubmitDate;

    /**
     * @Fields  : 审批通过日期
     */
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    private Date applyPassDate;

    /**
     * @Fields  : 当前节点账号
     */
    private String presentUser;

    /**
     * @Fields  : 申请id
     */
    private List<String> applyIds;

    /**
     * @Fields  :出租人
     */
    private String groupName;

    /**
     * @Fields  :出租人区域
     */
    private String groupDistrict;

    /******************************    融资信息    *****************************/
    /**
     * @Fields  : 产品名称代码
     */
    private String product;
    /**
     * @Fields  : 产品名称
     */
    private String productName;
    /**
     * @Fields  : 牌照属性
     */
    private String licenseAttr;
    /**
     * @Fields  : 融资期限
     */
    private String finPeriodType;
    /**
     * @Fields  : 手续费收取方式
     */
    private String chargePayMode;
    /**
     * @Fields  : 手续费比例
     */
    private String chargeRate;
    /**
     * @Fields  : 手续费
     */
    private String charge;
    /**
     * @Fields  : 首付比例
     */
    private String initPerc;
    /**
     * @Fields  : 首付金额
     */
    private String initAmount;
    /**
     * @Fields  : 投资总额
     */
    private String investTotal;
    /**
     * @Fields  : 融资金额
     */
    private String finTotal;
    /**
     * @Fields  : 合同租金
     */
    private String rent;
    /**
     * @Fields  : 保证金费用
     */
    private String deposit;
    /**
     * @Fields  : 车辆类型
     */
    private String vehicleForm;

    /******************************    客户个人/企业基本信息    *****************/
    /**
     * @Fields  : 客户姓名
     */
    private String name;
    /**
     * @Fields  : 客户证件号码
     */
    private String certifNo;
    /**
     * @Fields  : 个人标志
     */
    private String personFlag;
    /**
     * @Fields  : 企业标志
     */
    private String companyFlag;

    /**
     * @Fields  : 当前用户
     */
    private String sysUser;

    /**
     * @Fields  : 当前用户所属机构
     */
    private List<String> sysUserGroup;

    /**
     * @Fields  : 车型名称
     */
    private String vehicleName;

    /**
     * @Fields  : 担保人
     */
    private String guarantee;


    /**
     * @Fields  : 提出起始时间
     */
    private String submitStartTime;

    /**
     * @Fields  : 提出结束时间
     */
    private String submitEndTime;

    /**
     * @Fields  : 审批起始时间
     */
    private String approveStartTime;

    /**
     * @Fields  : 审批结束时间
     */
    private String approveEndTime;

    /**
     * @Fields  : 风控审批结果
     * @author yanfengbo
     */
    private String windcontrApprovalStatus;

    /**
     * @Fields  : 终审审批结果
     * @author yanfengbo
     */
    private String finalApprovalStatus;

    /**
     * @Fields  : 业务经理名称
     * @author yanfengbo
     */
    private String applyUserName;

    /**
     * @Fields  : 当前节点用户名称
     * @author yanfengbo
     */
    private String presentUserName;

    /**
     * @Fields  : 风控初审派单(风控初审人员)
     * @author yanfengbo
     */
    private String approveUser;

    /**
     * @Fields  : 订单状态大类
     * @author huzongcheng
     */
    private String applyStatus;

    /**
     * @Fields  : 订单状态集合
     * @author huzongcheng
     */
    private List<String> statusList;


}
