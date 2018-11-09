package cn.com.leadu.fms.system.validator.sysparam.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysParam;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: SysParamVo
 * @Description: 系统常量表删除时载体及验证
 * @date 2018-03-09
 */
@Data
public class SysParamDeleteListVo extends BaseVo<SysParam> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 参数主键id
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> paramKeyIds;

}