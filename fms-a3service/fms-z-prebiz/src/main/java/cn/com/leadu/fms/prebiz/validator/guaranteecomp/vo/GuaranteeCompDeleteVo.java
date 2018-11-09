package cn.com.leadu.fms.prebiz.validator.guaranteecomp.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.GuaranteeComp;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author ningyangyang
 * @ClassName: GuaranteeCompVo
 * @Description: 担保企业信息删除时载体及验证
 * @date 2018-03-30
 */
@Data
public class GuaranteeCompDeleteVo extends BaseVo<GuaranteeComp> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 担保企业id
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String guarCompId;

}