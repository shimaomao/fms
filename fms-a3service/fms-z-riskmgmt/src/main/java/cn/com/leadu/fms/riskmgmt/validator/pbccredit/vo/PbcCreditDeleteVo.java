package cn.com.leadu.fms.riskmgmt.validator.pbccredit.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PbcCredit;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author liujinge
 * @ClassName: PbcCreditVo
 * @Description: 个人人行征信信息删除时载体及验证
 * @date 2018-06-04
 */
@Data
public class PbcCreditDeleteVo extends BaseVo<PbcCredit> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 个人人行征信信息id
     * @author liujinge
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String pbcCreditId;

}