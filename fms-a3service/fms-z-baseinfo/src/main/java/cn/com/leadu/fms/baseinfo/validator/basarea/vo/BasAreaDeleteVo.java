package cn.com.leadu.fms.baseinfo.validator.basarea.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasArea;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author niehaibing
 * @ClassName: BasAreaVo
 * @Description: 省市县信息维护删除时载体及验证
 * @date 2018-03-15
 */
@Data
public class BasAreaDeleteVo extends BaseVo<BasArea> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 区域ID
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String areaId;

}