package cn.com.leadu.fms.system.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.entity.SysWidgetAttribute;
import cn.com.leadu.fms.pojo.system.vo.syswidgetattribute.SysWidgetAttributeTreeVo;
import cn.com.leadu.fms.pojo.system.vo.syswidgetattribute.SysWidgetAttributeVo;
import cn.com.leadu.fms.system.validator.syswidgetattribute.vo.SysWidgetAttributeDeleteListVo;
import cn.com.leadu.fms.system.validator.syswidgetattribute.vo.SysWidgetAttributeModifyVo;
import cn.com.leadu.fms.system.validator.syswidgetattribute.vo.SysWidgetAttributeSaveVo;
import org.springframework.http.ResponseEntity;

import java.util.Map;

/**
 * @author wangxue
 * @ClassName: SysWidgetAttributeService
 * @Description: 项目权限管理业务层
 * @date 2018-03-09
 */
public interface SysWidgetAttributeService {

	/**
	 * @Title:
	 * @Description: 保存项目权限管理
	 * @param sysWidgetAttributeSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 11:07:18
	 */
	ResponseEntity<RestResponse> saveSysWidgetAttribute(SysWidgetAttributeSaveVo sysWidgetAttributeSaveVo);


	/**
	 * @Title:
	 * @Description: 修改项目权限管理
	 * @param sysWidgetAttributeModifyVo
	 * @return
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 11:07:18
	 */
	void modifySysWidgetAttribute(SysWidgetAttributeModifyVo sysWidgetAttributeModifyVo);

	/**
	 * @Title:
	 * @Description:  通过widgetConId集合删除项目权限管理
	 * @param sysWidgetAttributeDeleteListVo
	 * @return
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 11:07:18
	 */
	void deleteSysWidgetAttributeByWidgetConIds(SysWidgetAttributeDeleteListVo sysWidgetAttributeDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据widgetConId获取项目权限管理
	 * @param widgetConId
	 * @return SysWidgetAttribute
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 11:07:18
	 */
	SysWidgetAttribute findSysWidgetAttributeByWidgetConId(String widgetConId);

	/**
	 * @Title:
	 * @Description: 根据画面标识ID，分页查询项目权限vo
	 * @param sysWidgetAttributeVo
	 * @return PageInfoExtend<SysWidgetAttribute>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 11:07:18
	 */
	PageInfoExtend<SysWidgetAttributeVo> findSysWidgetAttributeVoByPage(SysWidgetAttributeVo sysWidgetAttributeVo);

	/**
	 * @Title:
	 * @Description:   查出所有项目权限数据并以树的形式返回
	 * @return
	 * @throws
	 * @author wangxue
	 * @date 2018-3-9 11:07:17
	 */
	Map<String, SysWidgetAttributeTreeVo> findSysWidgetAttributeVoByTree();

	/**
	 * @Title:
	 * @Description:  重置redis中保存的画面项目权限
	 * @param
	 * @return
	 * @throws
	 * @author wangxue
	 * @date 2018-3-10 13:37:18
	 */
	Map<String, SysWidgetAttributeTreeVo> resetSysWidgetAttributeVoByTreeToRedis();

}
