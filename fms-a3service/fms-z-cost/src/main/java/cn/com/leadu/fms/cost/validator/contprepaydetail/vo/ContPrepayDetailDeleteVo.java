package cn.com.leadu.fms.cost.validator.contprepaydetail.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.cost.entity.ContPrepayDetail;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author yangyiquan
 * @ClassName: ContPrepayDetailVo
 * @Description: 提前还款明细删除时载体及验证
 * @date 2018-05-11
 */
@Data
public class ContPrepayDetailDeleteVo extends BaseVo<ContPrepayDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 提前还款明细ID
     * @author yangyiquan
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String contPrepayDetailId;

}