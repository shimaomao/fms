package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.pojo.postbiz.entity.VehMaintain;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.postbiz.vo.vehmaintain.VehMaintainVo;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qinmuqiao
 * @ClassName: VehMaintainRepository
 * @Description: 车辆维修记录Repository层
 */
public interface VehMaintainRepository {

	/**
	 * @Title:
	 * @Description: 新增车辆维修记录
	 * @param vehMaintain
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:06
	 */
	int insertData(VehMaintain vehMaintain);

	/**
	 * @Title:
	 * @Description: 批量保存车辆维修记录
	 * @param vehMaintains
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:06
	 */
	int insertDataList(List<VehMaintain> vehMaintains);

	/**
	 * @Title:
	 * @Description: 修改车辆维修记录
	 * @param vehMaintain
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:06
	 */
	int updateByPrimaryKeyData(VehMaintain vehMaintain);

	/**
	 * @Title:
	 * @Description: 批量修改车辆维修记录
	 * @param vehMaintains
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:06
	 */
	int updateByPrimaryKeyDataList(List<VehMaintain> vehMaintains);

	/**
	 * @Title:
	 * @Description: 动态修改车辆维修记录
	 * @param vehMaintain
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:06
	 */
	int updateByPrimaryKeySelectiveData(VehMaintain vehMaintain);

	/**
	 * @Title:
	 * @Description: 批量动态修改车辆维修记录
	 * @param vehMaintains
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:06
	 */
	int updateByPrimaryKeySelectiveDataList(List<VehMaintain> vehMaintains);

	/**
	 * @Title:
	 * @Description: 根据条件修改车辆维修记录
	 * @param vehMaintain
	 * @param example
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:06
	 */
	int updateByExampleData(VehMaintain vehMaintain, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改车辆维修记录
	 * @param vehMaintain
	 * @param example
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:06
	 */
	int updateByExampleSelectiveData(VehMaintain vehMaintain, Example example);

	/**
	 * @Title:
	 * @Description: 根据vehMaintainId删除车辆维修记录
	 * @param vehMaintain
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:06
	 */
	int deleteData(VehMaintain vehMaintain);

	/**
	 * @Title:
	 * @Description: 根据vehMaintainId集合批量删除车辆维修记录
	 * @param vehMaintainIds
	 * @param vehMaintain
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:06
	 */
	int deleteDataList(List vehMaintainIds,VehMaintain vehMaintain);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除车辆维修记录
	 * @param example
	 * @param vehMaintain
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:06
	 */
	int deleteExampleData(Example example,VehMaintain vehMaintain);

	/**
	 * @Title:
	 * @Description: 查询全部车辆维修记录
	 * @return List<VehMaintain>
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:06
	 */
	List<VehMaintain> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个车辆维修记录
	 * @param example
	 * @return VehMaintain
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:06
	 */
	VehMaintain selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询车辆维修记录
	 * @param example
	 * @return List<VehMaintain>
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:06
	 */
	List<VehMaintain> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过vehMaintainId查询车辆维修记录
	 * @param vehMaintainId
	 * @return VehMaintain
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:06
	 */
	VehMaintain selectByPrimaryKey(Object vehMaintainId);

	/**
	 * @Title:
	 * @Description: 分页查询车辆维修记录
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<VehMaintain>
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:06
	 */
	PageInfoExtend<VehMaintain> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询车辆维修记录vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:06
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改车辆维修记录
	 * @param vehMaintain,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:06
	 */
	int updateByPrimaryKeyData(VehMaintain vehMaintain,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改车辆维修记录,并进行排他
	 * @param vehMaintains
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:06
	 */
	int updateByPrimaryKeyDataList(List<VehMaintain> vehMaintains,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改车辆维修记录,并进行排他
	 * @param vehMaintain
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(VehMaintain vehMaintain,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改车辆维修记录,并进行排他
	 * @param vehMaintains
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:06
	 */
	int updateByPrimaryKeySelectiveDataList(List<VehMaintain> vehMaintains,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改车辆维修记录,并进行排他
	 * @param vehMaintain
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:06
	 */
	int updateByExampleData(VehMaintain vehMaintain, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改车辆维修记录,并进行排他
	 * @param vehMaintain
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:06
	 */
	int updateByExampleSelectiveData(VehMaintain vehMaintain, Example example,boolean exclusive);


	/**
	 * @Title:
	 * @Description: 根据Id查询车辆详情的Vo
	 * @param vehMaintainId
	 * @return int
	 * @throws
	 * @author qinmuqiao
	 * @date 2018-9-15 9:53:06
	 */
	VehMaintainVo selectVehMaintainVoByVehMaintainId(String vehMaintainId);


}
