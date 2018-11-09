package cn.com.leadu.fms.data.system.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.system.entity.SysWidgetAttribute;
import cn.com.leadu.fms.pojo.system.vo.syswidgetattribute.SysWidgetAttributeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wangxue
 * @ClassName: SysWidgetAttributeDao
 * @Description: 项目权限管理dao层
 * @date 2018-03-09
 */
public interface SysWidgetAttributeDao extends BaseDao<SysWidgetAttribute> {

    /**
     * @Title:
     * @Description:   根据画面标识ID，分页查询项目权限vo
     * @param sysWidgetAttributeVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018/03/09 17:19:43
     */
    List<SysWidgetAttributeVo> selectSysWidgetAttributeVoByPages(@Param("sysWidgetAttributeVo") SysWidgetAttributeVo sysWidgetAttributeVo);

}