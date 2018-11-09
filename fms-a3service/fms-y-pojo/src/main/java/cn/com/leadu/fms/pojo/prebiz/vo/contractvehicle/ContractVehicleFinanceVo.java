package cn.com.leadu.fms.pojo.prebiz.vo.contractvehicle;/**
 * Created by yyq on 2018/5/21.
 */

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.ContractVehicle;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @program: fms
 * @description: 合同融资车辆信息载体
 * @author: yangyiquan
 * @create: 2018-05-21 16:33
 **/
@Data
public class ContractVehicleFinanceVo  extends PageQuery<ContractVehicle> {
    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 合同编号
     */
    private String contNo;

    /**
     * @Fields  : 订单编号
     */
    private String applyNo;

    /**
     * @Fields  : 店面
     */
    private String applyGroupName;

    /**
     * @Fields  : 合同状态
     */
    private String bizStatus;

    /**
     * @Fields  : 车架号
     */
    private String vinNo;

    /**
     * @Fields  : 发动机号
     */
    private String engineNo;

    /**
     * @Fields  : 车牌号
     */
    private String vehicleLicenseNo;

    /**
     * @Fields  : 生成合同日期
     */
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    private Date contractDate;

    /**
     * @Fields  : 合同打印日期
     */
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    private Date contractPrintDate;

    /**
     * @Fields  : 合同生效日期
     */
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    private Date contractValidDate;

    /************************    合同融资车辆信息    ***********************/
    /**
     * @Fields  : 车辆类型
     */
    private String vehicleForm;
    /**
     * @Fields  : 车辆品牌
     */
    private String vehBrandCode;
    /**
     * @Fields  : 车辆品牌名称
     */
    private String vehBrandCodeName;
    /**
     * @Fields  : 车型
     */
    private String vehicleCode;
    /**
     * @Fields  : 车型名称
     */
    private String vehicleCodeName;

    /**
     * @Fields  : 登记日期
     */
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    private String registDate;


    /******************************    合同融资信息    *****************************/

    /**
     * @Fields  : 牌照属性
     */
    private String licenseAttr;

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

    /******************************    保险信息    *****************/

    /**
     * @Fields  : 保险公司
     */
    private String insCompName;
    /**
     * @Fields  : 商业保单号
     */
    private String insPolicyNo;
}
