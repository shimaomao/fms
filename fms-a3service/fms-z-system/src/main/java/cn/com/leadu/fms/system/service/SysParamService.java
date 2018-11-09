package cn.com.leadu.fms.system.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.SysParam;
import cn.com.leadu.fms.pojo.system.vo.sysparam.SysParamVo;
import cn.com.leadu.fms.system.validator.sysparam.vo.SysParamDeleteListVo;
import cn.com.leadu.fms.system.validator.sysparam.vo.SysParamDeleteVo;
import cn.com.leadu.fms.system.validator.sysparam.vo.SysParamModifyVo;
import cn.com.leadu.fms.system.validator.sysparam.vo.SysParamSaveVo;

import java.util.Map;

/**
 * @author yanfengbo
 * @ClassName: SysParamService
 * @Description: 系统常量表业务层
 * @date 2018-03-09
 */
public interface SysParamService {

	/**
	 * @Title:
	 * @Description: 保存系统常量表
	 * @param sysParamSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-9 11:03:53
	 */
	Map<String,Object> saveSysParam(SysParamSaveVo sysParamSaveVo);


	/**
	 * @Title:
	 * @Description: 修改系统常量表
	 * @param sysParamModifyVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-9 11:03:53
	 */
	Map<String,Object> modifySysParam(SysParamModifyVo sysParamModifyVo);

	/**
	 * @Title:
	 * @Description:  通过paramKeyId删除系统常量表
	 * @param sysParamDeleteVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-9 11:03:53
	 */
	Map<String,Object> deleteSysParam(SysParamDeleteVo sysParamDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过paramKeyId集合删除系统常量表
	 * @param sysParamDeleteListVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-9 11:03:53
	 */
	Map<String,Object> deleteSysParamByParamKeyIds(SysParamDeleteListVo sysParamDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据paramKeyId获取系统常量表
	 * @param paramKeyId
	 * @return SysParam
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-9 11:03:53
	 */
	SysParam findSysParamByParamKeyId(String paramKeyId);


	/**
	 * @Title:
	 * @Description: 分页查询系统常量表
	 * @param sysParamVo
	 * @return PageInfoExtend<SysParam>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-9 11:03:53
	 */
    PageInfoExtend<SysParam> findSysParamByPage(SysParamVo sysParamVo);

	/**
	 * @Title:
	 * @Description:  根据paramKey获取系统常量表
	 * @param paramKey
	 * @return SysParam
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-9 11:03:53
	 */
	SysParam findSysParamByParamKey(String paramKey);

	/**
	 * @Title:
	 * @Description:  根据paramKey获取系统常量表
	 * @param paramKey
	 * @return SysParam
	 * @throws
	 * @author yanfengbo
	 * @date 2018-3-9 11:03:53
	 */
	String findParamValueByParamKey(String paramKey);

	/**
	 * @Title:
	 * @Description:   初始化系统常量值到redis中
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/20 09:19:43
	 */
	Map<String,Object> initSysParamsValue();

	/**
	 * @Title:
	 * @Description:   获取系统常量
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/20 09:31:03
	 */
	Map<String,Object> findSysParamsValue();

	/**
	 * @Title:
	 * @Description:   返回常量版本值
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/06/20 09:49:12
	 */
	Integer findSysParamsValueVersion();

}
