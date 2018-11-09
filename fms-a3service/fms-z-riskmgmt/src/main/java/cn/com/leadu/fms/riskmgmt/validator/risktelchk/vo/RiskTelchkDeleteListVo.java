package cn.com.leadu.fms.riskmgmt.validator.risktelchk.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskTelchk;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskTelchkVo
 * @Description: 风控电核信息删除时载体及验证
 * @date 2018-06-04
 */
@Data
public class RiskTelchkDeleteListVo extends BaseVo<RiskTelchk> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 风控电核id
     * @author liujinge
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> riskTelchkIds;

}