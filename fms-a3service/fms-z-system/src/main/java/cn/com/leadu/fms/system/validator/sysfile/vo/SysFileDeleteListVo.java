package cn.com.leadu.fms.system.validator.sysfile.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysFile;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysFileVo
 * @Description: 菜单删除时载体及验证
 * @date 2018-03-01
 */
@Data
public class SysFileDeleteListVo extends BaseVo<SysFile> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> ids;

}