package cn.com.leadu.fms.baseinfo.validator.basfilegroup.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasFileGroup;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: BasFileGroupVo
 * @Description: 附件组删除时载体及验证
 */
@Data
public class BasFileGroupDeleteListVo extends BaseVo<BasFileGroup> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 附件组id
     * @author ningyangyang
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> basFileGroupIds;

}