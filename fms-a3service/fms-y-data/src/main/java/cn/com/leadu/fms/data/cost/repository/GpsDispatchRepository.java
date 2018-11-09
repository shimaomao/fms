package cn.com.leadu.fms.data.cost.repository;

import cn.com.leadu.fms.pojo.cost.entity.GpsDispatch;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.cost.vo.gpsdispatch.GpsDispatchVo;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: GpsDispatchRepository
 * @Description: 派单信息Repository层
 * @date 2018-05-25
 */
public interface GpsDispatchRepository {

	/**
	 * @Title:
	 * @Description: 新增派单信息
	 * @param gpsDispatch
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:58
	 */
	int insertData(GpsDispatch gpsDispatch);

	/**
	 * @Title:
	 * @Description: 批量保存派单信息
	 * @param gpsDispatchs
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:58
	 */
	int insertDataList(List<GpsDispatch> gpsDispatchs);

	/**
	 * @Title:
	 * @Description: 修改派单信息
	 * @param gpsDispatch
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:58
	 */
	int updateByPrimaryKeyData(GpsDispatch gpsDispatch);

	/**
	 * @Title:
	 * @Description: 批量修改派单信息
	 * @param gpsDispatchs
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:58
	 */
	int updateByPrimaryKeyDataList(List<GpsDispatch> gpsDispatchs);

	/**
	 * @Title:
	 * @Description: 动态修改派单信息
	 * @param gpsDispatch
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:58
	 */
	int updateByPrimaryKeySelectiveData(GpsDispatch gpsDispatch);

	/**
	 * @Title:
	 * @Description: 批量动态修改派单信息
	 * @param gpsDispatchs
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:58
	 */
	int updateByPrimaryKeySelectiveDataList(List<GpsDispatch> gpsDispatchs);

	/**
	 * @Title:
	 * @Description: 根据条件修改派单信息
	 * @param gpsDispatch
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:58
	 */
	int updateByExampleData(GpsDispatch gpsDispatch, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改派单信息
	 * @param gpsDispatch
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:58
	 */
	int updateByExampleSelectiveData(GpsDispatch gpsDispatch, Example example);

	/**
	 * @Title:
	 * @Description: 根据dispatchId删除派单信息
	 * @param gpsDispatch
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:58
	 */
	int deleteData(GpsDispatch gpsDispatch);

	/**
	 * @Title:
	 * @Description: 根据dispatchId集合批量删除派单信息
	 * @param dispatchIds
	 * @param gpsDispatch
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:58
	 */
	int deleteDataList(List dispatchIds, GpsDispatch gpsDispatch);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除派单信息
	 * @param example
	 * @param gpsDispatch
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:58
	 */
	int deleteExampleData(Example example, GpsDispatch gpsDispatch);

	/**
	 * @Title:
	 * @Description: 查询全部派单信息
	 * @return List<GpsDispatch>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:58
	 */
	List<GpsDispatch> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个派单信息
	 * @param example
	 * @return GpsDispatch
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:58
	 */
	GpsDispatch selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询派单信息
	 * @param example
	 * @return List<GpsDispatch>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:58
	 */
	List<GpsDispatch> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过dispatchId查询派单信息
	 * @param dispatchId
	 * @return GpsDispatch
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:58
	 */
	GpsDispatch selectByPrimaryKey(Object dispatchId);

	/**
	 * @Title:
	 * @Description: 分页查询派单信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<GpsDispatch>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:58
	 */
	PageInfoExtend<GpsDispatch> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询派单信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:58
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 动态修改派单信息,并进行排他
	 * @param gpsDispatch
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(GpsDispatch gpsDispatch,boolean exclusive);

	/**
	 * @Title:
	 * @Description:   根据合同id查询派单信息详情
	 * @param gpsDispatchVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/28 04:44:13
	 */
	GpsDispatchVo selectGpsDispatchVo(GpsDispatchVo gpsDispatchVo);

}
