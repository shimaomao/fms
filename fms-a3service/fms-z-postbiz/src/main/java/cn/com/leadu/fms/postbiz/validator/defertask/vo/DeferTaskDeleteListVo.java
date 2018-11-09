package cn.com.leadu.fms.postbiz.validator.defertask.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.DeferTask;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: DeferTaskVo
 * @Description: 合同展期删除时载体及验证
 */
@Data
public class DeferTaskDeleteListVo extends BaseVo<DeferTask> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 展期任务id
     * @author ningyangyang
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> deferTaskIds;

}