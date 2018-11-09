package cn.com.leadu.fms.cost.validator.gpsdispatch.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.cost.entity.GpsDispatch;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: GpsDispatchVo
 * @Description: 派单信息删除时载体及验证
 * @date 2018-05-25
 */
@Data
public class GpsDispatchDeleteListVo extends BaseVo<GpsDispatch> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 派单信息id
     * @author qiaomengnan
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> dispatchIds;

}