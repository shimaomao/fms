package cn.com.leadu.fms.product.validator.finitem.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.product.entity.FinItem;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author niehaibing
 * @ClassName: FinItemVo
 * @Description: 融资项目管理删除时载体及验证
 * @date 2018-03-19
 */
@Data
public class FinItemDeleteVo extends BaseVo<FinItem> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 融资项目ID
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String finItemId;

}