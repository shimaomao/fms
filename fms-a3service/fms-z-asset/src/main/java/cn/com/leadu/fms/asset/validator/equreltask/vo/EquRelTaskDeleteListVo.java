package cn.com.leadu.fms.asset.validator.equreltask.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.asset.entity.EquRelTask;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: EquRelTaskVo
 * @Description: 资方解押任务删除时载体及验证
 * @date 2018-05-30
 */
@Data
public class EquRelTaskDeleteListVo extends BaseVo<EquRelTask> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 资方解押任务id
     * @author qiaomengnan
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> equRelTaskIds;

}