package cn.com.leadu.fms.pojo.postbiz.vo.overduecstm;

import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by root on 2018/9/25.
 */
@Data
public class LawyerLetterVo {

    private static final long serialVersionUID = 1L;

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
     * @Fields  : 融资期限
     * @author lijunjun
     */
    private String finPeriodType;

    /**
     * @Fields  : 申请类型
     * @author lijunjun
     */
    private String applyType;

    /**
     * @Fields  : 每期租金
     * @author lijunjun
     */
    private BigDecimal rent;

    /**
     * 还款计划表数据
     */
    private List<ContRepaySkedVo> contRepaySkedVoList;

}
