package cn.com.leadu.fms.product.validator.prodintrst.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.product.entity.ProdIntrst;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author niehaibing
 * @ClassName: ProdIntrstVo
 * @Description: 产品利率删除时载体及验证
 * @date 2018-03-27
 */
@Data
public class ProdIntrstDeleteListVo extends BaseVo<ProdIntrst> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 产品利率ID
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> prodIntrstIds;

}