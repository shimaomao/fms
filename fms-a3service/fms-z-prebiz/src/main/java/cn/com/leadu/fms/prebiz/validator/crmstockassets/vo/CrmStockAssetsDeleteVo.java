package cn.com.leadu.fms.prebiz.validator.crmstockassets.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.CrmStockAssets;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author ningyangyang
 * @ClassName: CrmStockAssetsVo
 * @Description: crm股东信息删除时载体及验证
 * @date 2018-08-27
 */
@Data
public class CrmStockAssetsDeleteVo extends BaseVo<CrmStockAssets> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 股份资产ID
     * @author ningyangyang
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String stockAssetsId;

}