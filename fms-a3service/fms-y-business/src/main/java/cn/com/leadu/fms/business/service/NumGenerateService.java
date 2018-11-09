package cn.com.leadu.fms.business.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.system.entity.NumGenerate;
import cn.com.leadu.fms.pojo.system.vo.numgenerate.NumGenerateVo;

/**
 * @author liujinge
 * @ClassName: NumGenerateService
 * @Description: 业务编号管理业务层
 * @date 2018-03-26
 */
public interface NumGenerateService {

	/**
	 * @Title:
	 * @Description: 分页查询业务编号管理
	 * @param numGenerateVo
	 * @return PageInfoExtend<NumGenerate>
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 14:53:41
	 */
	PageInfoExtend<NumGenerate> findNumGeneratesByPage(NumGenerateVo numGenerateVo);

	/**
	 * @Title:
	 * @Description:  根据numGenerateId获取业务编号管理
	 * @param numGenerateId
	 * @return NumGenerate
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 14:53:41
	 */
	NumGenerate findNumGenerateByNumGenerateId(String numGenerateId);

	/**
	 * @Title:
	 * @Description:  根据numGenerateId获取业务编号管理
	 * @param numType
	 * @return String
	 * @throws
	 * @author liujinge
	 * @date 2018-3-26 14:53:41
	 */
	 String getNumGenerateByNumType(String numType);

}
