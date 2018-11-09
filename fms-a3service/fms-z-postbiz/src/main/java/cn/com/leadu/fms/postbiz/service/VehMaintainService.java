package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.pojo.postbiz.vo.vehmaintain.VehMaintainVo;
import cn.com.leadu.fms.postbiz.validator.vehmaintain.vo.VehMaintainModifyVo;
import cn.com.leadu.fms.postbiz.validator.vehmaintain.vo.VehMaintainSaveVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import javax.servlet.http.HttpServletResponse;

/**
 * @author qinmuqiao
 * @ClassName: VehMaintainService
 * @Description: 车辆维修记录业务层
 */
public interface VehMaintainService {

	/**
	 * @Title:
	 * @Description: 分页查询车辆维修记录
	 * @param vehMaintainVo
	 * @return PageInfoExtend<VehMaintain>
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:07
	 */
	PageInfoExtend<VehMaintainVo> findVehMaintainsVosByPage(VehMaintainVo vehMaintainVo);

	/**
	 * @Title:
	 * @Description: 保存车辆维修记录
	 * @param vehMaintainSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:07
	 */
    void saveVehMaintain(VehMaintainSaveVo vehMaintainSaveVo);

	/**
	 * @Title:
	 * @Description: 修改车辆维修记录
	 * @param vehMaintainModifyVo
	 * @return java.lang.String
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:07
	 */
	void modifyVehMaintain(VehMaintainModifyVo vehMaintainModifyVo);

	/**
	 * @Title:
	 * @Description:  根据vehMaintainId获取车辆维修记录
	 * @param vehMaintainId
	 * @return VehMaintain
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:07
	 */
	VehMaintainVo findVehMaintainVoByVehMaintainId(String vehMaintainId);

	/**
	 * @Title:
	 * @Description:  excel导入数据
	 * @param filePath
	 * @return VehMaintain
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:07
	 */
	void importVehMaintainsByExcel(String filePath);


	/**
	 * @Title:
	 * @Description:  下载维修记录模版
	 * @return VehMaintain
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:07
	 */
	void exportVehMaintainModalExcel(HttpServletResponse httpServletResponse);


}
