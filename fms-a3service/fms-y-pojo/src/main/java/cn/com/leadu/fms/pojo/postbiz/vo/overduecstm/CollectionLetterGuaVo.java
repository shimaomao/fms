package cn.com.leadu.fms.pojo.postbiz.vo.overduecstm;

import lombok.Data;

import java.math.BigDecimal;

/**
 * Created by root on 2018/9/25.
 */
@Data
public class CollectionLetterGuaVo {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 担保人姓名
     * @author lijunjun
     */
    private String guaranteeName;

    /**
     * @Fields  : 担保函编号
     * @author lijunjun
     */
    private String guaranteeNo;

    /**
     * @Fields  : 客户姓名
     * @author lijunjun
     */
    private String cstmName;

    /**
     * @Fields  : 出租机构代码
     * @author lijunjun
     */
    private String belongGroup;

    /**
     * @Fields  : 出租人
     * @author lijunjun
     */
    private String groupName;

    /**
     * @Fields  : 合同编号
     * @author lijunjun
     */
    private String contNo;

    /**
     * @Fields  : 车辆类型
     * @author lijunjun
     */
    private String vehicleForm;

    /**
     * @Fields  : 车牌号
     * @author lijunjun
     */
    private String vehicleLicenseNo;

    /**
     * @Fields  : 还款日
     * @author lijunjun
     */
    private String repayDay;

    /**
     * @Fields  : 当前逾期总额
     * @author lijunjun
     */
    private BigDecimal overdueSum;
}
