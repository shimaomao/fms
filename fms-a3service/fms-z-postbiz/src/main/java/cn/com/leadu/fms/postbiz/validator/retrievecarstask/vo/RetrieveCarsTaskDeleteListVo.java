package cn.com.leadu.fms.postbiz.validator.retrievecarstask.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.RetrieveCarsTask;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: RetrieveCarsTaskVo
 * @Description: 收车任务删除时载体及验证
 */
@Data
public class RetrieveCarsTaskDeleteListVo extends BaseVo<RetrieveCarsTask> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 收车任务id
     * @author ningyangyang
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> retrieveCarIds;

}