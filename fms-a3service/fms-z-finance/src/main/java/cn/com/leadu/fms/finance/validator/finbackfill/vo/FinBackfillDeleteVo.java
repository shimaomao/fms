package cn.com.leadu.fms.finance.validator.finbackfill.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.finance.entity.FinBackfill;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author lijunjun
 * @ClassName: FinBackfillVo
 * @Description: 融资回填删除时载体及验证
 * @date 2018-05-11
 */
@Data
public class FinBackfillDeleteVo extends BaseVo<FinBackfill> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 融资回填ID
     * @author lijunjun
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String filBackfillId;

}