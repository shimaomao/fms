package cn.com.leadu.fms.pojo.system.vo.syswidgetattribute;

import cn.com.leadu.fms.pojo.system.entity.SysWidgetAttribute;
import lombok.Data;

import java.util.Map;

/**
 * @author wangxue
 * @ClassName: SysWidgetAttributeVo
 * @Description: 项目权限树
 * @date 2018-03-08
 */
@Data
public class SysWidgetAttributeTreeVo {

    /**
     * @Fields  : 画面ID
     */
    private String frmWidgetId;

    /**
     * @Fields  : 画面名称
     */
    private String frmWidgetName;

    /**
     * @Fields  : 画面项目权限
     */
    private Map<String, SysWidgetAttribute> eleWidgetMap;
}
