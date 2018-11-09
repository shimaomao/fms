package cn.com.leadu.fms.system.validator.sysresource.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysResource;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysResourceDeleteListVo
 * @Description:
 * @date 2018/2/24
 */
@Data
public class SysResourceDeleteListVo extends BaseVo<SysResource> {

    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> ids;

}
