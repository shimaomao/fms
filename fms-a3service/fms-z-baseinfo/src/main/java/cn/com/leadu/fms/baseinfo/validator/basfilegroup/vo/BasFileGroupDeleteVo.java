package cn.com.leadu.fms.baseinfo.validator.basfilegroup.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasFileGroup;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author ningyangyang
 * @ClassName: BasFileGroupVo
 * @Description: 附件组删除时载体及验证
 */
@Data
public class BasFileGroupDeleteVo extends BaseVo<BasFileGroup> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 附件组id
     * @author ningyangyang
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String basFileGroupId;

}