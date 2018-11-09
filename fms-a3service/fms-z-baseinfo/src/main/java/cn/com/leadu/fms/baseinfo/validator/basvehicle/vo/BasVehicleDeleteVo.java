package cn.com.leadu.fms.baseinfo.validator.basvehicle.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasVehicle;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author niehaibing
 * @ClassName: BasVehicleVo
 * @Description: 车辆信息维护删除时载体及验证
 * @date 2018-03-20
 */
@Data
public class BasVehicleDeleteVo extends BaseVo<BasVehicle> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 车型信息ID
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String vehicleId;

}