package cn.com.leadu.fms.data.baseinfo.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasArea;
import cn.com.leadu.fms.pojo.baseinfo.vo.basarea.BasAreaVo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author niehaibing
 * @ClassName: BasAreaRepository
 * @Description: 省市县信息维护Repository层
 * @date 2018-03-15
 */
public interface BasAreaRepository {

	/**
	 * @Title:
	 * @Description: 新增省市县信息维护
	 * @param basArea
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-15 11:09:30
	 */
	int insertData(BasArea basArea);

	/**
	 * @Title:
	 * @Description: 批量保存省市县信息维护
	 * @param basAreas
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-15 11:09:30
	 */
	int insertDataList(List<BasArea> basAreas);

	/**
	 * @Title:
	 * @Description: 修改省市县信息维护
	 * @param basArea
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-15 11:09:30
	 */
	int updateByPrimaryKeyData(BasArea basArea);

	/**
	 * @Title:
	 * @Description: 批量修改省市县信息维护
	 * @param basAreas
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-15 11:09:30
	 */
	int updateByPrimaryKeyDataList(List<BasArea> basAreas);

	/**
	 * @Title:
	 * @Description: 动态修改省市县信息维护
	 * @param basArea
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-15 11:09:30
	 */
	int updateByPrimaryKeySelectiveData(BasArea basArea);

	/**
	 * @Title:
	 * @Description: 批量动态修改省市县信息维护
	 * @param basAreas
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-15 11:09:30
	 */
	int updateByPrimaryKeySelectiveDataList(List<BasArea> basAreas);

	/**
	 * @Title:
	 * @Description: 根据条件修改省市县信息维护
	 * @param basArea
	 * @param example
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-15 11:09:30
	 */
	int updateByExampleData(BasArea basArea, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改省市县信息维护
	 * @param basArea
	 * @param example
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-15 11:09:30
	 */
	int updateByExampleSelectiveData(BasArea basArea, Example example);

	/**
	 * @Title:
	 * @Description: 根据areaId删除省市县信息维护
	 * @param basArea
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-15 11:09:30
	 */
	int deleteData(BasArea basArea);

	/**
	 * @Title:
	 * @Description: 根据areaId集合批量删除省市县信息维护
	 * @param areaIds
	 * @param basArea
	 * @return int
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-15 11:09:30
	 */
	int deleteDataList(List areaIds, BasArea basArea);

	/**
	 * @Title:
	 * @Description: 查询全部省市县信息维护
	 * @return List<BasArea>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-15 11:09:30
	 */
	List<BasArea> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个省市县信息维护
	 * @param example
	 * @return BasArea
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-15 11:09:30
	 */
	BasArea selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询省市县信息维护
	 * @param example
	 * @return List<BasArea>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-15 11:09:30
	 */
	List<BasArea> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过areaId查询省市县信息维护
	 * @param areaId
	 * @return BasArea
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-15 11:09:30
	 */
	BasArea selectByPrimaryKey(Object areaId);

	/**
	 * @Title:
	 * @Description: 分页查询省市县信息维护
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<BasArea>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-15 11:09:30
	 */

	PageInfoExtend<BasArea> selectListByExamplePage(Example example, PageQuery pageQuery);
	/**
	 * @Title:
	 * @Description: 通过areaId查询省市县信息维护
	 * @param areaId
	 * @return BasArea
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-15 11:09:30
	 */
	 BasAreaVo selectBasAreaVosByAreaId(String areaId);
	/**
	 * @Title:
	 * @Description: 分页查询省市县信息维护vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend<BasArea>
	 * @throws
	 * @author niehaibing
	 * @date 2018-3-15 11:09:30
	 */
	PageInfoExtend<BasAreaVo> selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	BasAreaVo selectBaseAreaVoById(Object id);
}
