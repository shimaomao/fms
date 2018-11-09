package cn.com.leadu.fms.system.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.SysCodeType;
import cn.com.leadu.fms.pojo.system.vo.syscodetype.SysCodeTypeVo;
import cn.com.leadu.fms.system.validator.syscodetype.vo.SysCodeTypeDeleteListVo;
import cn.com.leadu.fms.system.validator.syscodetype.vo.SysCodeTypeDeleteVo;
import cn.com.leadu.fms.system.validator.syscodetype.vo.SysCodeTypeModifyVo;
import cn.com.leadu.fms.system.validator.syscodetype.vo.SysCodeTypeSaveVo;

import java.util.Map;

/**
 * @author huchenghao
 * @ClassName: SysCodeTypeService
 * @Description: 字典数据类型业务层
 * @date 2018-03-08
 */
public interface SysCodeTypeService {

	/**
	 * @Title:
	 * @Description: 保存字典数据类型
	 * @param sysCodeTypeSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-8 15:35:57
	 */
	void saveSysCodeType(SysCodeTypeSaveVo sysCodeTypeSaveVo);


	/**
	 * @Title:
	 * @Description: 修改字典数据类型
	 * @param sysCodeTypeModifyVo
	 * @return
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-8 15:35:57
	 */
	void modifySysCodeType(SysCodeTypeModifyVo sysCodeTypeModifyVo);

	/**
	 * @Title:
	 * @Description:  通过id删除字典数据类型
	 * @param sysCodeTypeDeleteVo
	 * @return
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-8 15:35:57
	 */
	void deleteSysCodeType(SysCodeTypeDeleteVo sysCodeTypeDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过id集合删除字典数据类型
	 * @param sysCodeTypeDeleteListVo
	 * @return
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-8 15:35:57
	 */
	Map<String,Object> deleteSysCodeTypeByIds(SysCodeTypeDeleteListVo sysCodeTypeDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据id字典数据类型
	 * @param codeTypeId
	 * @return SysCodeType
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-8 15:35:57
	 */
	SysCodeType findSysCodeTypeById(String codeTypeId);

	/**
	 * @Title:
	 * @Description:  根据id字典数据类型
	 * @param codeType
	 * @return SysCodeType
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-8 15:35:57
	 */
	SysCodeType findSysCodeTypeByCodeType(String codeType);

	/**
	 * @Title:
	 * @Description: 分页查询字典数据类型
	 * @param sysCodeTypeVo
	 * @return PageInfoExtend<SysCodeType>
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-8 15:35:57
	 */
	PageInfoExtend<SysCodeType> findSysCodeTypesByPage(SysCodeTypeVo sysCodeTypeVo);

}
