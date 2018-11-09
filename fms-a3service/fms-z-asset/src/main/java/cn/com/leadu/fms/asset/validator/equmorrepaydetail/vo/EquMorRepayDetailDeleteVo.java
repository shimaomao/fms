package cn.com.leadu.fms.asset.validator.equmorrepaydetail.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.asset.entity.EquMorRepayDetail;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author qinmuqiao
 * @ClassName: EquMorRepayDetailVo
 * @Description: 资方抵押还款计划删除时载体及验证
 */
@Data
public class EquMorRepayDetailDeleteVo extends BaseVo<EquMorRepayDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 资方抵押还款计划表明细id
     * @author qinmuqiao
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String equMorRepayDetailId;

}