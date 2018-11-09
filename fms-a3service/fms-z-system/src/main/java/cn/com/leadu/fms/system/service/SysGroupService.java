package cn.com.leadu.fms.system.service;

import cn.com.leadu.fms.common.vo.BootstrapTreeViewNodeVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.SysGroup;
import cn.com.leadu.fms.pojo.system.vo.sysgroup.SysGroupDetailVo;
import cn.com.leadu.fms.pojo.system.vo.sysgroup.SysGroupVo;
import cn.com.leadu.fms.system.validator.sysgroup.vo.SysGroupDeleteListVo;
import cn.com.leadu.fms.system.validator.sysgroup.vo.SysGroupModifyVo;
import cn.com.leadu.fms.system.validator.sysgroup.vo.SysGroupSaveVo;

import java.util.List;

/**
 * @author wangxue
 * @ClassName: SysGroupService
 * @Description: 用户组管理业务层
 * @date 2018-03-10
 */
public interface SysGroupService {

	/**
	 * @Title:
	 * @Description: 分页查询用户组管理信息Vo.
	 * @param sysGroupVo
	 * @return PageInfoExtend<SysGroupVo>
	 * @throws
	 * @author wangxue
	 * @date 2018-3-10 17:39:58
	 */
	PageInfoExtend<SysGroupVo> findSysGroupVosByPage(SysGroupVo sysGroupVo);

	/**
	 * @Title:
	 * @Description: 保存用户组管理
	 * @param sysGroupSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author wangxue
	 * @date 2018-3-10 17:39:58
	 */
    void saveSysGroup(SysGroupSaveVo sysGroupSaveVo);


	/**
	 * @Title:
	 * @Description: 修改用户组管理
	 * @param sysGroupModifyVo
	 * @return
	 * @throws
	 * @author wangxue
	 * @date 2018-3-10 17:39:58
	 */
	void modifySysGroup(SysGroupModifyVo sysGroupModifyVo);

	/**
	 * @Title:
	 * @Description:  通过groupId集合删除用户组管理
	 * @param sysGroupDeleteListVo
	 * @return
	 * @throws
	 * @author wangxue
	 * @date 2018-3-10 17:39:58
	 */
	void deleteSysGroupsByGroupIds(SysGroupDeleteListVo sysGroupDeleteListVo);

	/**
	 * @Title:
	 * @Description:  根据groupId获取用户组信息
	 * @param groupId
	 * @return SysGroup
	 * @throws
	 * @author wangxue
	 * @date 2018-3-10 17:39:58
	 */
	SysGroupDetailVo findSysGroupVoByGroupId(String groupId);

	/**
	 * @Title:
	 * @Description:  根据用户组代码，获取用户组信息
	 * @param groupCode
	 * @return SysGroup
	 * @throws
	 * @author wangxue
	 * @date 2018-3-12 15:31:58
	 */
	SysGroup findSysGroupByGroup(String groupCode);

	/**
	 * @Title:
	 * @Description:    查询用户组树
	 * @return
	 * @throws
	 * @author wangxue
	 * @date 2018/03/13 09:46:15
	 */
	List<BootstrapTreeViewNodeVo> findSysGroupByTree(String parentType, String groupCode);

	/**
	 * @Title:
	 * @Description:   根据groupcode查询
	 * @return
	 * @throws
	 * @author wangxue
	 * @date 2018/03/13 09:46:15
	 */
	SysGroup selectSysGroupVoByGroupCode(String groupCode);

	/**
	 * @Title:
	 * @Description: 根据经销商代码，取得经销商用户组及全部子用户组代码
	 * @param groupCode
	 * @return List<String>
	 * @throws
	 * @author wangxue
	 * @date 2018/03/23 17:46:15
	 */
	List<String> findSysGroupCodeListByGroupCode(String groupCode);


	/**
	 * @Title:
	 * @Description:   得到经销商用户组保存情况
	 * @return String
	 * @throws
	 * @author huchenghao
	 * @date 2018/03/13 09:46:15
	 */
	String getBasPartnerStatus(SysGroupVo sysGroupVo);
	/**
	 * @Title:
	 * @Description:   得到经销商保存情况
	 * @param sysGroupVo
	 * @return Map<String,String>
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-12 15:31:58
	 */
	public PageInfoExtend<SysGroupVo> findSysGroupVoListByPage(SysGroupVo sysGroupVo);

}
