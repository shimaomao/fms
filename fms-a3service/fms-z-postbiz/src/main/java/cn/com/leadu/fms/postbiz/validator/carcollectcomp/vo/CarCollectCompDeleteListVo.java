package cn.com.leadu.fms.postbiz.validator.carcollectcomp.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.postbiz.entity.CarCollectComp;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: CarCollectCompVo
 * @Description: 收车机构维护删除时载体及验证
 * @date 2018-05-22
 */
@Data
public class CarCollectCompDeleteListVo extends BaseVo<CarCollectComp> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 收车机构ID
     * @author yanfengbo
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> carCollectCompIds;

}