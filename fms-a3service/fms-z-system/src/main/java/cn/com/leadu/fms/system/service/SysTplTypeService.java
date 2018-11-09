package cn.com.leadu.fms.system.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.entity.SysTplType;
import cn.com.leadu.fms.pojo.system.vo.systpltype.SysTplTypeVo;
import cn.com.leadu.fms.system.validator.systpltype.vo.SysTplTypeDeleteListVo;
import cn.com.leadu.fms.system.validator.systpltype.vo.SysTplTypeModifyVo;
import cn.com.leadu.fms.system.validator.systpltype.vo.SysTplTypeSaveVo;
import org.springframework.http.ResponseEntity;

import java.util.List;

/**
 * @author wubaoliang
 * @ClassName: SysTplTypeService
 * @Description: 模板类型管理业务层
 * @date 2018-03-12
 */
public interface SysTplTypeService {

	/**
	 * @Title:
	 * @Description: 分页查询模板类型管理
	 * @param sysTplTypeVo
	 * @return PageInfoExtend<SysTplType>
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:38:41
	 */
	PageInfoExtend<SysTplType> findSysTplTypesByPage(SysTplTypeVo sysTplTypeVo);

	/**
	 * @Title:
	 * @Description: 保存模板类型管理
	 * @param sysTplTypeSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:38:41
	 */
    void saveSysTplType(SysTplTypeSaveVo sysTplTypeSaveVo);


	/**
	 * @Title:
	 * @Description: 修改模板类型管理
	 * @param sysTplTypeModifyVo
	 * @return
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:38:41
	 */
	void modifySysTplType(SysTplTypeModifyVo sysTplTypeModifyVo);

	/**
	 * @Title:
	 * @Description:  通过tplTypeId集合删除模板类型管理
	 * @param sysTplTypeDeleteListVo
	 * @return
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:38:41
	 */
	ResponseEntity<RestResponse> deleteSysTplTypesByTplTypeIds(SysTplTypeDeleteListVo sysTplTypeDeleteListVo);

	/**
	 * @Title:
	 * @Description:  根据tplTypeId获取模板类型信息Vo
	 * @param tplTypeId
	 * @return SysTplType
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 14:38:41
	 */
	SysTplTypeVo findSysTplTypeVoByTplTypeId(String tplTypeId);

	/**
	 * @Title:
	 * @Description:  根据tplTypeKey获取模板类型信息
	 * @param tplTypeKey
	 * @return SysTplType
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-15 14:38:41
	 */
	SysTplType findSysTplTypeByTplTypeKey(String tplTypeKey);

	/**
	 * @Title:
	 * @Description:  根据tplName获取模板信息
	 * @param sysTplType
	 * @return SysTpl
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-16 15:16:19
	 */
	List<SysTplType> findSysTplTypeListByBasFileTypeList(SysTplTypeVo sysTplType);


}
