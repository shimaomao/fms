package cn.com.leadu.fms.postbiz.service;

import cn.com.leadu.fms.pojo.postbiz.entity.CarCollectComp;
import cn.com.leadu.fms.pojo.postbiz.vo.carcollectcomp.CarCollectCompVo;
import cn.com.leadu.fms.postbiz.validator.carcollectcomp.vo.CarCollectCompSaveVo;
import cn.com.leadu.fms.postbiz.validator.carcollectcomp.vo.CarCollectCompModifyVo;
import cn.com.leadu.fms.postbiz.validator.carcollectcomp.vo.CarCollectCompDeleteVo;
import cn.com.leadu.fms.postbiz.validator.carcollectcomp.vo.CarCollectCompDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

/**
 * @author yanfengbo
 * @ClassName: CarCollectCompService
 * @Description: 收车机构维护业务层
 * @date 2018-05-22
 */
public interface CarCollectCompService {

	/**
	 * @Title:
	 * @Description: 分页查询收车机构维护
	 * @param carCollectCompVo
	 * @return PageInfoExtend<CarCollectComp>
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-22 10:04:12
	 */
	PageInfoExtend<CarCollectComp> findCarCollectCompsByPage(CarCollectCompVo carCollectCompVo);

	/**
	 * @Title:
	 * @Description: 保存收车机构维护
	 * @param carCollectCompSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-22 10:04:12
	 */
    void saveCarCollectComp(CarCollectCompSaveVo carCollectCompSaveVo);


	/**
	 * @Title:
	 * @Description: 修改收车机构维护
	 * @param carCollectCompModifyVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-22 10:04:12
	 */
	void modifyCarCollectComp(CarCollectCompModifyVo carCollectCompModifyVo);

	/**
	 * @Title:
	 * @Description:  通过carCollectCompId删除收车机构维护
	 * @param carCollectCompDeleteVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-22 10:04:12
	 */
	void deleteCarCollectComp(CarCollectCompDeleteVo carCollectCompDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过carCollectCompId集合删除收车机构维护
	 * @param carCollectCompDeleteListVo
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-22 10:04:12
	 */
	void deleteCarCollectCompsByCarCollectCompIds(CarCollectCompDeleteListVo carCollectCompDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据carCollectCompId获取收车机构维护
	 * @param carCollectCompId
	 * @return CarCollectComp
	 * @throws
	 * @author yanfengbo
	 * @date 2018-5-22 10:04:12
	 */
	CarCollectCompVo findCarCollectCompByCarCollectCompId(String carCollectCompId);

	/**
	 * @Title:
	 * @Description: 通过carCollectCompCode获取收车机构维护
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	CarCollectComp findCarCollectCompByCarCollectCompCode(String carCollectCompCode);

}
