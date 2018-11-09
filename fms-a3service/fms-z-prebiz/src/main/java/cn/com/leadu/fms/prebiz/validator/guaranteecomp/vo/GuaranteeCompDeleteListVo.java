package cn.com.leadu.fms.prebiz.validator.guaranteecomp.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.GuaranteeComp;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: GuaranteeCompVo
 * @Description: 担保企业信息删除时载体及验证
 * @date 2018-03-30
 */
@Data
public class GuaranteeCompDeleteListVo extends BaseVo<GuaranteeComp> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 担保企业id
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> guarCompIds;

}