package cn.com.leadu.fms.riskmgmt.validator.pycreditcardcheck.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCardCheck;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author yangyiquan
 * @ClassName: PycreditCardCheckVo
 * @Description: 卡核查及交易删除时载体及验证
 * @date 2018-06-14
 */
@Data
public class PycreditCardCheckDeleteVo extends BaseVo<PycreditCardCheck> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 卡核查及交易id
     * @author yangyiquan
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String pycreditCardCheckId;

}