package cn.com.leadu.fms.postbiz.validator.collectiontask.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.CollectionTask;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author lijunjun
 * @ClassName: CollectionTaskVo
 * @Description: 催收任务删除时载体及验证
 */
@Data
public class CollectionTaskDeleteVo extends BaseVo<CollectionTask> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 催收任务id
     * @author lijunjun
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String collectionTaskId;

}