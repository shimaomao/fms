package cn.com.leadu.fms.riskmgmt.validator.pycreditdriver.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditDriver;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditDriverVo
 * @Description: 驾驶证核查删除时载体及验证
 * @date 2018-06-04
 */
@Data
public class PycreditDriverDeleteListVo extends BaseVo<PycreditDriver> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 驾驶证核查id
     * @author liujinge
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> pycreditDriverIds;

}