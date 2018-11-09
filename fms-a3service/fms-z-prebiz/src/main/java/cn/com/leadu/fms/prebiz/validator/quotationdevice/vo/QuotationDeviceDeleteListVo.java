package cn.com.leadu.fms.prebiz.validator.quotationdevice.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.prebiz.entity.QuotationDevice;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: QuotationDeviceVo
 * @Description: 报价器信息删除时载体及验证
 * @date 2018-05-23
 */
@Data
public class QuotationDeviceDeleteListVo extends BaseVo<QuotationDevice> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 报价器ID
     * @author lijunjun
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> quotationDeviceIds;

}