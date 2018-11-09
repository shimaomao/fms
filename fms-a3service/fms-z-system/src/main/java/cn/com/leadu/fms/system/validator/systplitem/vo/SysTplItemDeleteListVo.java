package cn.com.leadu.fms.system.validator.systplitem.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysTplItem;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author wubaoliang
 * @ClassName: SysTplItemVo
 * @Description: 模板可设项目管理删除时载体及验证
 * @date 2018-03-12
 */
@Data
public class SysTplItemDeleteListVo extends BaseVo<SysTplItem> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 模板项目ID
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> tplItemIds;

}