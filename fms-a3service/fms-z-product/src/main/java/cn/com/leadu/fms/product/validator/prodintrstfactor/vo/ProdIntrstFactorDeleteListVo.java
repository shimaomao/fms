package cn.com.leadu.fms.product.validator.prodintrstfactor.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.product.entity.ProdIntrstFactor;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author niehaibing
 * @ClassName: ProdIntrstFactorVo
 * @Description: 产品利率删除时载体及验证
 * @date 2018-03-27
 */
@Data
public class ProdIntrstFactorDeleteListVo extends BaseVo<ProdIntrstFactor> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 产品利率因子ID
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> prodIntrstFactorIds;

}