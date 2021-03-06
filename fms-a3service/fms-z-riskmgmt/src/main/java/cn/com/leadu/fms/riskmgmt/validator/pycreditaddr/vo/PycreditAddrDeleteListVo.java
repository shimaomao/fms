package cn.com.leadu.fms.riskmgmt.validator.pycreditaddr.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditAddr;
import lombok.Data;
import javax.validation.constraints.Size;
import cn.com.leadu.fms.common.constant.ValidatorConstants;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditAddrVo
 * @Description: 地址核验删除时载体及验证
 * @date 2018-06-04
 */
@Data
public class PycreditAddrDeleteListVo extends BaseVo<PycreditAddr> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 地址核验id
     * @author liujinge
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> pycreditAddrIds;

}