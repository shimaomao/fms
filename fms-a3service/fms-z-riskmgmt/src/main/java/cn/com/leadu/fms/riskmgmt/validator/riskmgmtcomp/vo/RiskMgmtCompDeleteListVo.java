package cn.com.leadu.fms.riskmgmt.validator.riskmgmtcomp.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskMgmtComp;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskMgmtCompVo
 * @Description: 风控企业信息删除时载体及验证
 * @date 2018-06-04
 */
@Data
public class RiskMgmtCompDeleteListVo extends BaseVo<RiskMgmtComp> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 风控企业信息id
     * @author liujinge
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> riskMgmtCompIds;

}