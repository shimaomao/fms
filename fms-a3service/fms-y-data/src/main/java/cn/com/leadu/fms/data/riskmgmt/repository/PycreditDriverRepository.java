package cn.com.leadu.fms.data.riskmgmt.repository;

import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpRisk;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditDriver;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditDriverRepository
 * @Description: 驾驶证核查Repository层
 * @date 2018-06-04
 */
public interface PycreditDriverRepository {

	/**
	 * @Title:
	 * @Description: 新增驾驶证核查
	 * @param pycreditDriver
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:44
	 */
	int insertData(PycreditDriver pycreditDriver);

	/**
	 * @Title:
	 * @Description: 批量保存驾驶证核查
	 * @param pycreditDrivers
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:44
	 */
	int insertDataList(List<PycreditDriver> pycreditDrivers);

	/**
	 * @Title:
	 * @Description: 修改驾驶证核查
	 * @param pycreditDriver
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:44
	 */
	int updateByPrimaryKeyData(PycreditDriver pycreditDriver);

	/**
	 * @Title:
	 * @Description: 批量修改驾驶证核查
	 * @param pycreditDrivers
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:44
	 */
	int updateByPrimaryKeyDataList(List<PycreditDriver> pycreditDrivers);

	/**
	 * @Title:
	 * @Description: 动态修改驾驶证核查
	 * @param pycreditDriver
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:44
	 */
	int updateByPrimaryKeySelectiveData(PycreditDriver pycreditDriver);

	/**
	 * @Title:
	 * @Description: 批量动态修改驾驶证核查
	 * @param pycreditDrivers
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:44
	 */
	int updateByPrimaryKeySelectiveDataList(List<PycreditDriver> pycreditDrivers);

	/**
	 * @Title:
	 * @Description: 根据条件修改驾驶证核查
	 * @param pycreditDriver
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:44
	 */
	int updateByExampleData(PycreditDriver pycreditDriver, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改驾驶证核查
	 * @param pycreditDriver
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:44
	 */
	int updateByExampleSelectiveData(PycreditDriver pycreditDriver, Example example);

	/**
	 * @Title:
	 * @Description: 根据pycreditDriverId删除驾驶证核查
	 * @param pycreditDriver
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:44
	 */
	int deleteData(PycreditDriver pycreditDriver);

	/**
	 * @Title:
	 * @Description: 根据pycreditDriverId集合批量删除驾驶证核查
	 * @param pycreditDriverIds
	 * @param pycreditDriver
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:44
	 */
	int deleteDataList(List pycreditDriverIds,PycreditDriver pycreditDriver);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除驾驶证核查
	 * @param example
	 * @param pycreditDriver
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:44
	 */
	int deleteExampleData(Example example,PycreditDriver pycreditDriver);

	/**
	 * @Title:
	 * @Description: 查询全部驾驶证核查
	 * @return List<PycreditDriver>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:44
	 */
	List<PycreditDriver> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个驾驶证核查
	 * @param example
	 * @return PycreditDriver
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:44
	 */
	PycreditDriver selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询驾驶证核查
	 * @param example
	 * @return List<PycreditDriver>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:44
	 */
	List<PycreditDriver> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过pycreditDriverId查询驾驶证核查
	 * @param pycreditDriverId
	 * @return PycreditDriver
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:44
	 */
	PycreditDriver selectByPrimaryKey(Object pycreditDriverId);

	/**
	 * @Title:
	 * @Description: 分页查询驾驶证核查
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<PycreditDriver>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:44
	 */
	PageInfoExtend<PycreditDriver> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询驾驶证核查vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:44
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改驾驶证核查
	 * @param pycreditDriver,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:44
	 */
	int updateByPrimaryKeyData(PycreditDriver pycreditDriver,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改驾驶证核查,并进行排他
	 * @param pycreditDrivers
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:44
	 */
	int updateByPrimaryKeyDataList(List<PycreditDriver> pycreditDrivers,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改驾驶证核查,并进行排他
	 * @param pycreditDriver
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(PycreditDriver pycreditDriver,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改驾驶证核查,并进行排他
	 * @param pycreditDrivers
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:44
	 */
	int updateByPrimaryKeySelectiveDataList(List<PycreditDriver> pycreditDrivers,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改驾驶证核查,并进行排他
	 * @param pycreditDriver
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:44
	 */
	int updateByExampleData(PycreditDriver pycreditDriver, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改驾驶证核查,并进行排他
	 * @param pycreditDriver
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:10:44
	 */
	int updateByExampleSelectiveData(PycreditDriver pycreditDriver, Example example,boolean exclusive);
	/**
	 * @Title:
	 * @Description: 根据条件动态修驾驶证核查,并进行排他
	 * @param documentNo
	 * @return String
	 * @throws
	 * @author yanggang
	 * @date 2018-6-22 15:08:52
	 */
	List<PycreditDriver> selectPycreditDriverList(String documentNo, int ceilingNumber);

	/** 
	* @Description:  查询最近一条驾驶证核查实体
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/7/6 14:34
	*/ 
    PycreditDriver selectLastPycreditDriverByDocumentNo(String documentNo);
}
