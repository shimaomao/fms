package cn.com.leadu.fms.system.validator.sysgrouplevel.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysGroupLevel;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: SysGroupLevelVo
 * @Description: 用户组层级删除时载体及验证
 * @date 2018-03-08
 */
@Data
public class SysGroupLevelDeleteListVo extends BaseVo<SysGroupLevel> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 层级ID集合
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> groupLevIds;

}