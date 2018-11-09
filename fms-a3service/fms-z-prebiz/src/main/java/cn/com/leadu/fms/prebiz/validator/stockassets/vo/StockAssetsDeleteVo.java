package cn.com.leadu.fms.prebiz.validator.stockassets.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.StockAssets;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author ningyangyang
 * @ClassName: StockAssetsVo
 * @Description: 股份资产删除时载体及验证
 * @date 2018-05-28
 */
@Data
public class StockAssetsDeleteVo extends BaseVo<StockAssets> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 股份资产ID
     * @author ningyangyang
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String stockAssetsId;

}