package cn.com.leadu.fms.system.validator.sysresource.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysResource;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

/**
 * @author qiaomengnan
 * @ClassName: SysResourceDeleteVo
 * @Description:
 * @date 2018/2/24
 */
@Data
public class SysResourceDeleteVo extends BaseVo<SysResource> {

    @NotBlank(message = ValidatorConstants.DELETE_MESSAGE)
    private String id;

}
