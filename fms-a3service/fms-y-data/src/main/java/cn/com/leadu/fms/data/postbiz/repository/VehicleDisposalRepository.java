package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.postbiz.entity.VehicleDisposal;
import cn.com.leadu.fms.pojo.postbiz.vo.capitalasstes.SecCarInfoVo;
import cn.com.leadu.fms.pojo.postbiz.vo.vehicledisposal.DisposalContVo;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: VehicleDisposalRepository
 * @Description: 车辆处置Repository层
 */
public interface VehicleDisposalRepository {

	/**
	 * @Title:
	 * @Description: 新增车辆处置
	 * @param vehicleDisposal
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
	int insertData(VehicleDisposal vehicleDisposal);

	/**
	 * @Title:
	 * @Description: 批量保存车辆处置
	 * @param vehicleDisposals
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
	int insertDataList(List<VehicleDisposal> vehicleDisposals);

	/**
	 * @Title:
	 * @Description: 修改车辆处置
	 * @param vehicleDisposal
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
	int updateByPrimaryKeyData(VehicleDisposal vehicleDisposal);

	/**
	 * @Title:
	 * @Description: 批量修改车辆处置
	 * @param vehicleDisposals
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
	int updateByPrimaryKeyDataList(List<VehicleDisposal> vehicleDisposals);

	/**
	 * @Title:
	 * @Description: 动态修改车辆处置
	 * @param vehicleDisposal
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
	int updateByPrimaryKeySelectiveData(VehicleDisposal vehicleDisposal);

	/**
	 * @Title:
	 * @Description: 批量动态修改车辆处置
	 * @param vehicleDisposals
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
	int updateByPrimaryKeySelectiveDataList(List<VehicleDisposal> vehicleDisposals);

	/**
	 * @Title:
	 * @Description: 根据条件修改车辆处置
	 * @param vehicleDisposal
	 * @param example
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
	int updateByExampleData(VehicleDisposal vehicleDisposal, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改车辆处置
	 * @param vehicleDisposal
	 * @param example
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
	int updateByExampleSelectiveData(VehicleDisposal vehicleDisposal, Example example);

	/**
	 * @Title:
	 * @Description: 根据vehicleDisposalId删除车辆处置
	 * @param vehicleDisposal
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
	int deleteData(VehicleDisposal vehicleDisposal);

	/**
	 * @Title:
	 * @Description: 根据vehicleDisposalId集合批量删除车辆处置
	 * @param vehicleDisposalIds
	 * @param vehicleDisposal
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
	int deleteDataList(List vehicleDisposalIds, VehicleDisposal vehicleDisposal);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除车辆处置
	 * @param example
	 * @param vehicleDisposal
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
	int deleteExampleData(Example example, VehicleDisposal vehicleDisposal);

	/**
	 * @Title:
	 * @Description: 查询全部车辆处置
	 * @return List<VehicleDisposal>
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
	List<VehicleDisposal> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个车辆处置
	 * @param example
	 * @return VehicleDisposal
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
	VehicleDisposal selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询车辆处置
	 * @param example
	 * @return List<VehicleDisposal>
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
	List<VehicleDisposal> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过vehicleDisposalId查询车辆处置
	 * @param vehicleDisposalId
	 * @return VehicleDisposal
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
	VehicleDisposal selectByPrimaryKey(Object vehicleDisposalId);

	/**
	 * @Title:
	 * @Description: 分页查询车辆处置
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<VehicleDisposal>
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
	PageInfoExtend<VehicleDisposal> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询车辆处置vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改车辆处置
	 * @param vehicleDisposal,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
	int updateByPrimaryKeyData(VehicleDisposal vehicleDisposal, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改车辆处置,并进行排他
	 * @param vehicleDisposals
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
	int updateByPrimaryKeyDataList(List<VehicleDisposal> vehicleDisposals, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改车辆处置,并进行排他
	 * @param vehicleDisposal
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(VehicleDisposal vehicleDisposal, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改车辆处置,并进行排他
	 * @param vehicleDisposals
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
	int updateByPrimaryKeySelectiveDataList(List<VehicleDisposal> vehicleDisposals, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改车辆处置,并进行排他
	 * @param vehicleDisposal
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
	int updateByExampleData(VehicleDisposal vehicleDisposal, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改车辆处置,并进行排他
	 * @param vehicleDisposal
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
	int updateByExampleSelectiveData(VehicleDisposal vehicleDisposal, Example example, boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据合同编号，获取合同客户信息
	 * @param contNo 合同编号
	 * @return DisposalContVo
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
	DisposalContVo selectDisposalContVoByContNo(String contNo);

	/**
	 * @Title:
	 * @Description: 根据合同编号处置状态，获取最新收车数据的收车费用
	 * @param contNo 合同编号
	 * @param vehicleDisposalStatus 车辆处置状态
	 * @return BigDecimal
	 * @throws
	 * @author wangxue
	 * @date 2018-9-12 10:44:08
	 */
	BigDecimal selectRecoveryChargeByContNo(String contNo, String vehicleDisposalStatus);

	/**
	 * @Title:
	 * @Description: 根据处置任务号，查询构建二手车库存表需要的数据源
	 * @param taskNo 处置任务号
	 * @return SecCarInfoVo
	 * @throws
	 * @author huzongcheng
	 */
	SecCarInfoVo selectSecCarInfoByTaskNo(String taskNo);

}
