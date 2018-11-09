package cn.com.leadu.fms.postbiz.validator.carcollectcomp.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.CarCollectComp;
import lombok.Data;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author yanfengbo
 * @ClassName: CarCollectCompVo
 * @Description: 收车机构维护删除时载体及验证
 * @date 2018-05-22
 */
@Data
public class CarCollectCompDeleteVo extends BaseVo<CarCollectComp> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 收车机构ID
     * @author yanfengbo
     */
    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String carCollectCompId;

}