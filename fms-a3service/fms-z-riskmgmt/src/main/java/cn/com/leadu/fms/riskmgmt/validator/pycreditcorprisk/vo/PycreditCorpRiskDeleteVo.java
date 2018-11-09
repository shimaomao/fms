package cn.com.leadu.fms.riskmgmt.validator.pycreditcorprisk.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpRisk;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author liujinge
 * @ClassName: PycreditCorpRiskVo
 * @Description: 企业风险删除时载体及验证
 * @date 2018-06-04
 */
@Data
public class PycreditCorpRiskDeleteVo extends BaseVo<PycreditCorpRisk> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 企业风险id
     * @author liujinge
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String pycreditCorpRiskId;

}