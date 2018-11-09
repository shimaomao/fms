package cn.com.leadu.fms.system.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.SysTpl;
import cn.com.leadu.fms.pojo.system.vo.systpl.SysTplVo;
import cn.com.leadu.fms.system.validator.systpl.vo.SysTplDeleteListVo;
import cn.com.leadu.fms.system.validator.systpl.vo.SysTplModifyVo;
import cn.com.leadu.fms.system.validator.systpl.vo.SysTplSaveVo;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

/**
 * @author wubaoliang
 * @ClassName: SysTplService
 * @Description: 模板管理业务层
 * @date 2018-03-12
 */
public interface SysTplService {

	/**
	 * @Title:
	 * @Description: 分页查询模板管理
	 * @param sysTplVo
	 * @return PageInfoExtend<SysTpl>
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 15:16:19
	 */
	PageInfoExtend<SysTplVo> findSysTplVosByPage(SysTplVo sysTplVo);

	/**
	 * @Title:
	 * @Description: 保存模板管理
	 * @param sysTplSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 15:16:19
	 */
    void saveSysTpl(SysTplSaveVo sysTplSaveVo);


	/**
	 * @Title:
	 * @Description: 修改模板管理
	 * @param sysTplModifyVo
	 * @return
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 15:16:19
	 */
	void modifySysTpl(SysTplModifyVo sysTplModifyVo);

	/**
	 * @Title:
	 * @Description:  通过tplId集合删除模板管理
	 * @param sysTplDeleteListVo
	 * @return
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 15:16:19
	 */
	void deleteSysTplsByTplIds(SysTplDeleteListVo sysTplDeleteListVo);

	/**
	 * @Title:
	 * @Description:  根据tplId获取模板管理
	 * @param tplId
	 * @return SysTplVo
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-12 15:16:19
	 */
	SysTplVo findSysTplVoByTplId(String tplId);

	/**
	 * @Title:
	 * @Description:  根据tplName获取模板信息
	 * @param tplName
	 * @return SysTpl
	 * @throws
	 * @author wubaoliang
	 * @date 2018-3-16 15:16:19
	 */
	SysTpl findSysTplByTplName(String tplName);

	/**
	 * @Title:
	 * @Description:  根据tplName获取模板信息
	 * @param sysTplVo
	 * @return SysTpl
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-16 15:16:19
	 */
	List<SysTpl> findSysTplListByBasFileTypeList(SysTplVo sysTplVo);

    void importdatas();
}
