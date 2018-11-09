package cn.com.leadu.fms.system.validator.systpltype.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysTplType;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author wubaoliang
 * @ClassName: SysTplTypeVo
 * @Description: 模板类型管理删除时载体及验证
 * @date 2018-03-12
 */
@Data
public class SysTplTypeDeleteListVo extends BaseVo<SysTplType> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 类型ID
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> tplTypeIds;

}