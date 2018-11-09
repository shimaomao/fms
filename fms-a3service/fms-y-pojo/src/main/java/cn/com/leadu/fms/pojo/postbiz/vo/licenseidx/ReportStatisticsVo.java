package cn.com.leadu.fms.pojo.postbiz.vo.licenseidx;

import cn.com.leadu.fms.common.entity.Entity;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.LicenseIdx;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by admin on 2018/9/26.
 */@Data
public class ReportStatisticsVo extends PageQuery<Contract> implements Entity {

    /**
     * @Fields  : 用户组代码
     * @author belong_group
     */
    private String belongGroup;

    /**
     * @Fields  : 区域
     * @author group_district
     */
    private String groupDistrict;

    /**
     * @Fields  : 经销商试乘试驾车/救援车
     * @author driving_vehicle
     */
    private BigDecimal drivingVehicle;

    /**
     * @Fields  : 经销商代步车
     * @author step_car
     */
    private BigDecimal stepCar;

    /**
     * @Fields  : 经销商员工购车
     * @author employees_car
     */
    private BigDecimal employeesCar;

    /**
     * @Fields  : 零售客户标准（新车且回租以外且摩托车以外）企业
     * @author customer_enterprise
     */
    private BigDecimal customerEnterprise;

    /**
     * @Fields  : 零售客户标准（新车且回租以外且摩托车以外）个人
     * @author customer_person
     */
    private BigDecimal customerPerson;

    /**
     * @Fields  : 零售客户回租（新车且摩托车以外）
     * @author customer_leaseback
     */
    private BigDecimal customerLeaseback;

    /**
     * @Fields  : 零售客户二手车（摩托车以外）
     * @author customers_handcar
     */
    private BigDecimal customersHandCar;

    /**
     * @Fields  : 零售客户摩托车
     * @author customer_motorcycle
     */
    private BigDecimal customerMotorcycle;

    /**
     * @Fields  : 经销商合计
     * @author distributor_total
     */
    private BigDecimal distributorTotal;

    /**
     * @Fields  : 零售客户合计
     * @author totalRetail_customers
     */
    private BigDecimal totalRetailCustomers;

    /**
     * @Fields  : 本月合计
     * @author month_sum
     */
    private BigDecimal monthSum;

    /**
     * @Fields  : 合同生效日期查询
     */
    private String contractSerachDate;

    /**
     * @Fields  : 总融资额
     * @author fin_total
     */
    private BigDecimal finTotal;

}
