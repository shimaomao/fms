package cn.com.leadu.fms.pojo.postbiz.vo.vehicledisposal;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @author wangxue
 * @ClassName: DisposalContVo
 * @Description: 车辆的合同客户信息你载体
 */
@Data
public class DisposalContVo {
    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 合同编号
     * @author wangxue
     */
    private String contNo;

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
     * @Fields  : 融资额
     * @author wangxue
     */
    private BigDecimal finTotal;

    /**
     * @Fields  : 融资期限
     * @author wangxue
     */
    private BigDecimal finPeriodType;

    /**
     * @Fields  : 出租人
     * @author wangxue
     */
    private String rentPerson;

    /**
     * @Fields  : 承租人
     * @author wangxue
     */
    private String cstmName;

    /**
     * @Fields  : 客户证件号
     * @author wangxue
     */
    private String certifNo;

    /**
     * @Fields  : 车辆行驶证注册日期
     * @author wangxue
     */
    private Date vehicleDrivingLicenseRegisterDate;

    /**
     * @Fields  : 车辆残值
     * @author wangxue
     */
    private BigDecimal residualValue;

}
