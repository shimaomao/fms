package cn.com.leadu.fms.system.validator.sysgroupparent.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysGroupParent;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author huchenghao
 * @ClassName: SysGroupParentVo
 * @Description: 用户组删除时载体及验证
 * @date 2018-03-29
 */
@Data
public class SysGroupParentDeleteListVo extends BaseVo<SysGroupParent> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 用户组关系ID
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> parentIds;

}