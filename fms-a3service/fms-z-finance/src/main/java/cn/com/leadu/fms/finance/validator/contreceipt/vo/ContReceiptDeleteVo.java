package cn.com.leadu.fms.finance.validator.contreceipt.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.finance.entity.ContReceipt;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author lijunjun
 * @ClassName: ContReceiptVo
 * @Description: 黑名单删除时载体及验证
 * @date 2018-05-07
 */
@Data
public class ContReceiptDeleteVo extends BaseVo<ContReceipt> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 财务收款Id
     * @author lijunjun
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String contReceiptId;

}