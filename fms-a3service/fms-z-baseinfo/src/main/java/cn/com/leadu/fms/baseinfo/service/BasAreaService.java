package cn.com.leadu.fms.baseinfo.service;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasArea;
import cn.com.leadu.fms.pojo.baseinfo.vo.basarea.BasAreaTreeVo;
import cn.com.leadu.fms.pojo.baseinfo.vo.basarea.BasAreaVo;
import cn.com.leadu.fms.baseinfo.validator.basarea.vo.BasAreaDeleteListVo;
import cn.com.leadu.fms.baseinfo.validator.basarea.vo.BasAreaDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.basarea.vo.BasAreaModifyVo;
import cn.com.leadu.fms.baseinfo.validator.basarea.vo.BasAreaSaveVo;

import java.util.Map;

/**
 * @author niehaibing
 * @ClassName: BasAreaService
 * @Description: 省市县信息维护业务层
 * @date 2018-03-15
 */
public interface BasAreaService {

	/**
	 * @Title:
	 * @Description: 分页查询省市县信息维护
	 * @param basAreaVo
	 * @return PageInfoExtend<BasArea>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-15 16:20:27
	 */
	PageInfoExtend<BasAreaVo> findBasAreasByPage(BasAreaVo basAreaVo);

	/**
	 * @Title:
	 * @Description: 保存省市县信息维护
	 * @param basAreaSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-15 16:20:27
	 */
    void saveBasArea(BasAreaSaveVo basAreaSaveVo);


	/**
	 * @Title:
	 * @Description: 修改省市县信息维护
	 * @param basAreaModifyVo
	 * @return
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-15 16:20:27
	 */
	void modifyBasArea(BasAreaModifyVo basAreaModifyVo);

	/**
	 * @Title:
	 * @Description:  通过areaId删除省市县信息维护
	 * @param basAreaDeleteVo
	 * @return
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-15 16:20:27
	 */
	void deleteBasArea(BasAreaDeleteVo basAreaDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过areaId集合删除省市县信息维护
	 * @param basAreaDeleteListVo
	 * @return
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-15 16:20:27
	 */
	void deleteBasAreasByAreaIds(BasAreaDeleteListVo basAreaDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据areaId获取省市县信息维护
	 * @param areaId
	 * @return BasArea
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-15 16:20:27
	 */
	BasAreaVo findBasAreaByAreaId(String areaId);


	/**
	 * @Title:
	 * @Description: 返回省市树状
	 * @param:
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/7/24 0024 23:44
	 */
	Map<String,Object> findBasAreas();

	/**
	 * @Title:
	 * @Description: 初始化省市到redis中
	 * @param:
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/7/24 0024 23:45
	 */
	Map<String,Object> initBasAreas();

	/**
	 * @Title:
	 * @Description: 查询省市版本值
	 * @param:
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/7/24 0024 23:45
	 */
	Integer findBasAreaValuesVersion();


	/**
	 * @Title:
	 * @Description:  获取所有省市县
	 * @param
	 * @return BasArea
	 * @throws
	 * @author huchenghao
	 * @date 2018-3-15 16:20:27
	 */
	Map<String,BasAreaTreeVo> findBasAreaByTree();

	/**
	 * findBasAreaByAreaCode
	 */
	BasArea findBasAreaByAreaCode(String areaCode);

}
