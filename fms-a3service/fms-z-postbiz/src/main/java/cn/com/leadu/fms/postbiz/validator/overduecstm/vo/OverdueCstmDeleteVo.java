package cn.com.leadu.fms.postbiz.validator.overduecstm.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstm;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author lijunjun
 * @ClassName: OverdueCstmVo
 * @Description: 逾期客户信息删除时载体及验证
 * @date 2018-05-16
 */
@Data
public class OverdueCstmDeleteVo extends BaseVo<OverdueCstm> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 逾期客户ID
     * @author lijunjun
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String overdueCstmId;

}