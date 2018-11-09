package cn.com.leadu.fms.pojo.postbiz.vo.overduecstm;

import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import cn.com.leadu.fms.pojo.prebiz.vo.guaranteecomp.GuaranteeCompVo;
import cn.com.leadu.fms.pojo.prebiz.vo.guaranteepers.GuaranteePersVo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * Created by root on 2018/9/25.
 */
@Data
public class CollectionLetterVo {

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
     * @Fields  : 合同编号
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
     * @Fields  : 当前逾期总额
     * @author lijunjun
     */
    private BigDecimal overdueSum;

    /**
     * 还款计划表数据
     */
    private List<ContRepaySkedVo> contRepaySkedVoList;

    /**
     * 担保个人List
     */
    private List<GuaranteePersVo> guaranteePersVoList;

    /**
     * 担保企业List
     */
    private List<GuaranteeCompVo> guaranteeCompVoList;

    /**
     * 申请编号
     */
    private String applyType;

    /**
     * 区分是上门催收还是逾期客户一览
     */
    private String flag;
}
