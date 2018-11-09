package cn.com.leadu.fms.pojo.postbiz.vo.licenseidx;

import cn.com.leadu.fms.common.entity.Entity;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.entity.LicenseIdx;
import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by admin on 2018/9/28.
 */@Data
public class BusinessStatisticsVo extends PageQuery<LicenseIdx> implements Entity {

    /**
     * @Fields  : 本月合计
     * @author monthly_number
     */
    private BigDecimal monthlyNumber;

    /**
     * @Fields  : 累计台数
     * @author cumulative_number
     */
    private BigDecimal cumulativeNumber;

    /**
     * @Fields  : 总融资额
     * @author fin_total
     */
    private BigDecimal finTotal;

    /**
     * @Fields  : 累计融资额
     * @author accumulated_total
     */
    private BigDecimal accumulatedTotal;

    /**
     * @Fields  : 单台融资额
     * @author averagefin_total
     */
    private BigDecimal averagefinTotal;

    /**
     * @Fields  : IRR
     * @author average_irr
     */
    private BigDecimal averageIrr;

    /**
     * @Fields  : 经销商台数
     * @author distributors_vehicle
     */
    private BigDecimal distributorsVehicle;

    /**
     * @Fields  : 经销商融资额
     * @author distributors_fintotal
     */
    private BigDecimal distributorsFintotal;

    /**
     * @Fields  : 业务客户台数
     * @author enterprise_vehicle
     */
    private BigDecimal enterpriseVehicle;

    /**
     * @Fields  : 业务融资额
     * @author enterprise_fintotal
     */
    private BigDecimal enterpriseFintotal;

    /**
     * @Fields  : 零售客户合计
     * @author personal_vehicle
     */
    private BigDecimal personalVehicle;

    /**
     * @Fields  : 零售客户融资额
     * @author personal_fintotal
     */
    private BigDecimal personalFintotal;

    /**
     * @Fields  : 合同生效日期
     */
    private String contractSerachDate;

    /**
     * @Fields  : 月份
     */
    private String effectivedateMonth;

    /**
     * @Fields  : 合同生效日期 (年份查询)
     */
    private String yearInquiries;

}
