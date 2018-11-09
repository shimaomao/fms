package cn.com.leadu.fms.pojo.postbiz.vo.licenseidx;

import cn.com.leadu.fms.common.entity.Entity;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * Created by admin on 2018/9/30.
 */@Data
public class ReportStatisticsListVo extends PageQuery<Contract> implements Entity {
    /**
     * @Fields  : 承租人
     * @author cstm_name
     */
    private String cstmName;

    /**
     * @Fields  : 车型
     * @author vehicle_name
     */
    private String vehicleName;

    /**
     * @Fields  : 标签价
     * @author guide_price
     */
    private BigDecimal guidePrice;

    /**
     * @Fields  : 成交价
     * @author fin_amount
     */
    private BigDecimal finAmount;

    /**
     * @Fields  : 申请金额
     * @author invest_total
     */
    private BigDecimal investTotal;

    /**
     * @Fields  : 首付
     * @author init_amount
     */
    private BigDecimal initAmount;

    /**
     * @Fields  : 保证金
     * @author deposit
     */
    private BigDecimal deposit;

    /**
     * @Fields  : 融资额
     * @author fin_total
     */
    private BigDecimal finTotal;

    /**
     * @Fields  : 尾款
     * @author final_amount
     */
    private BigDecimal finalAmount;

    /**
     * @Fields  : 回购价
     * @author back_purchase
     */
    private BigDecimal backPurchase;

    /**
     * @Fields  : 年供
     * @author annual_supply_amount
     */
    private BigDecimal annualSupplyAmount;

    /**
     * @Fields  : 租赁期限
     * @author fin_period_type
     */
    private BigDecimal finPeriodType;

    /**
     * @Fields  : 起租日
     * @author lease_term_start_date
     */
    private String leaseTermStartDate;

    /**
     * @Fields  : 止租日
     * @author lease_term_end_date
     */
    private String leaseTermEndDate;

    /**
     * @Fields  : 产品类型
     * @author product_name
     */
    private String productName;

    /**
     * @Fields  : 客户类型
     * @author company_type1
     */
    private String companyType1;

    /**
     * @Fields  : 利率
     * @author intrst_rate
     */
    private BigDecimal intrstRate;

    /**
     * @Fields  : IRR
     * @author irr
     */
    private BigDecimal irr;

    /**
     * @Fields  : 经销商名称
     * @author sales_name
     */
    private String salesName;

    /**
     * @Fields  : 业务经理
     * @author apply_user
     */
    private String applyUser;

    /**
     * @Fields  : 申请日期
     * @author apply_firsbt_date
     */
    private String applyFirsbtDate;

    /**
     * @Fields  : 放款日期
     * @author contract_valid_date
     */
    private String contractValidDate;

    /**
     * @Fields  : 区域
     * @author group_district
     */
    private String groupDistrict;

    /**
     * @Fields  : 合同生效日期查询
     */
    private String contractSerachDate;

    /**
     * @Fields  : 融资项目代码
     */
    private String finItem;

    /**
     * @Fields  : 静态收益率
     */
    private String staticRateOfReturn;
}
