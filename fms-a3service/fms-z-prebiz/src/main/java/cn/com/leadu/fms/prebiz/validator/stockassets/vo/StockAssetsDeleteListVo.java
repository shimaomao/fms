package cn.com.leadu.fms.prebiz.validator.stockassets.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.StockAssets;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: StockAssetsVo
 * @Description: 股份资产删除时载体及验证
 * @date 2018-05-28
 */
@Data
public class StockAssetsDeleteListVo extends BaseVo<StockAssets> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 股份资产ID
     * @author ningyangyang
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> stockAssetsIds;

}