package cn.com.leadu.fms.baseinfo.validator.basmsg.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasMsg;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author wubaoliang
 * @ClassName: BasMsgVo
 * @Description: 短信发送管理删除时载体及验证
 * @date 2018-03-09
 */
@Data
public class BasMsgDeleteVo extends BaseVo<BasMsg> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 短信发送ID
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String msgId;

}