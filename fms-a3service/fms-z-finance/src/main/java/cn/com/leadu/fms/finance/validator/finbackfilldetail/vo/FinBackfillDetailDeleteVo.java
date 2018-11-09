package cn.com.leadu.fms.finance.validator.finbackfilldetail.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.finance.entity.FinBackfillDetail;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author lijunjun
 * @ClassName: FinBackfillDetailVo
 * @Description: 融资回填明细删除时载体及验证
 * @date 2018-05-12
 */
@Data
public class FinBackfillDetailDeleteVo extends BaseVo<FinBackfillDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 融资回填明细ID
     * @author lijunjun
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String finBackfillDetailId;

}