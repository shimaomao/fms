package cn.com.leadu.fms.system.validator.syscodetype.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysCodeType;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author huchenghao
 * @ClassName: SysCodeTypeVo
 * @Description: 字典数据类型删除时载体及验证
 * @date 2018-03-08
 */
@Data
public class SysCodeTypeDeleteListVo extends BaseVo<SysCodeType> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> codeTypeIds;

}