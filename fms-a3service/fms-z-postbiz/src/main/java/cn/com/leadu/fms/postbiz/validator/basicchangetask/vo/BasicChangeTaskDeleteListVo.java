package cn.com.leadu.fms.postbiz.validator.basicchangetask.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.BasicChangeTask;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: BasicChangeTaskVo
 * @Description: 基本信息变更任务删除时载体及验证
 * @date 2018-08-31
 */
@Data
public class BasicChangeTaskDeleteListVo extends BaseVo<BasicChangeTask> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 变更任务id
     * @author lijunjun
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> personChangeTaskIds;

}