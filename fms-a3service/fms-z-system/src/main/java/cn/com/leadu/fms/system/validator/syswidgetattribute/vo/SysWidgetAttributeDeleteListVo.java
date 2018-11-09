package cn.com.leadu.fms.system.validator.syswidgetattribute.vo;

import cn.com.leadu.fms.common.constant.ValidatorConstants;
import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysWidgetAttribute;
import lombok.Data;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: SysWidgetAttributeVo
 * @Description: 项目权限管理删除时载体及验证
 * @date 2018-03-09
 */
@Data
public class SysWidgetAttributeDeleteListVo extends BaseVo<SysWidgetAttribute> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 权限管理ID
     */
    @Size(min = 1,message = ValidatorConstants.DELETE_MESSAGE)
    private List<String> widgetConIds;

}