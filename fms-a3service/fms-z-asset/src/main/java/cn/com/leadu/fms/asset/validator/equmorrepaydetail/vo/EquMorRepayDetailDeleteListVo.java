package cn.com.leadu.fms.asset.validator.equmorrepaydetail.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.asset.entity.EquMorRepayDetail;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author qinmuqiao
 * @ClassName: EquMorRepayDetailVo
 * @Description: 资方抵押还款计划删除时载体及验证
 */
@Data
public class EquMorRepayDetailDeleteListVo extends BaseVo<EquMorRepayDetail> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 资方抵押还款计划表明细id
     * @author qinmuqiao
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> equMorRepayDetailIds;

}