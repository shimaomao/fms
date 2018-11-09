package cn.com.leadu.fms.product.validator.productcatg.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.product.entity.ProductCatg;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author niehaibing
 * @ClassName: ProductCatgVo
 * @Description: 产品大类管理删除时载体及验证
 * @date 2018-03-21
 */
@Data
public class ProductCatgDeleteListVo extends BaseVo<ProductCatg> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 产品大类ID
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> productCatgIds;

}