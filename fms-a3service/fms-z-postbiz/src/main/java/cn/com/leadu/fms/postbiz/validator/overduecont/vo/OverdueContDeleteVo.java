package cn.com.leadu.fms.postbiz.validator.overduecont.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCont;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author lijunjun
 * @ClassName: OverdueContVo
 * @Description: 逾期合同信息删除时载体及验证
 * @date 2018-05-16
 */
@Data
public class OverdueContDeleteVo extends BaseVo<OverdueCont> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 逾期合同ID
     * @author lijunjun
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String overdueContId;

}