package cn.com.leadu.fms.product.validator.product.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.product.entity.Product;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author niehaibing
 * @ClassName: testVo
 * @Description: 产品方案管理删除时载体及验证
 * @date 2018-03-23
 */
@Data
public class ProductDeleteListVo extends BaseVo<Product> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 产品方案ID
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> productIds;

    private List<String> products;

}