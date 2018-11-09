package cn.com.leadu.fms.postbiz.validator.invoicechange.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceChange;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: InvoiceChangeVo
 * @Description: 开票信息变更删除时载体及验证
 * @date 2018-08-29
 */
@Data
public class InvoiceChangeDeleteListVo extends BaseVo<InvoiceChange> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 开票信息变更id
     * @author lijunjun
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> invoiceChangeIds;

}