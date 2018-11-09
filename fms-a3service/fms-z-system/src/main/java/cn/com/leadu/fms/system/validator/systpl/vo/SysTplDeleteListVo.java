package cn.com.leadu.fms.system.validator.systpl.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysTpl;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author wubaoliang
 * @ClassName: SysTplVo
 * @Description: 模板管理删除时载体及验证
 * @date 2018-03-12
 */
@Data
public class SysTplDeleteListVo extends BaseVo<SysTpl> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 模板ID
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> tplIds;

}