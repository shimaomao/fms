package cn.com.leadu.fms.system.validator.syscode.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysCode;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author huchenghao
 * @ClassName: SysCodeVo
 * @Description: 字典数数值删除时载体及验证
 * @date 2018-03-09
 */
@Data
public class SysCodeDeleteListVo extends BaseVo<SysCode> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> codeValueIds;

}