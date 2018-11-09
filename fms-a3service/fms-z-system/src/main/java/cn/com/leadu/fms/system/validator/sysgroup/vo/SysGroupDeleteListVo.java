package cn.com.leadu.fms.system.validator.sysgroup.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysGroup;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: SysGroupVo
 * @Description: 用户组管理删除时载体及验证
 * @date 2018-03-10
 */
@Data
public class SysGroupDeleteListVo extends BaseVo<SysGroup> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 用户组ID
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> groupIds;

}