package cn.com.leadu.fms.data.riskmgmt.repository;

import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditAddr;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditAnti;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditAddrRepository
 * @Description: 地址核验Repository层
 * @date 2018-06-04
 */
public interface PycreditAddrRepository {

	/**
	 * @Title:
	 * @Description: 新增地址核验
	 * @param pycreditAddr
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:28
	 */
	int insertData(PycreditAddr pycreditAddr);

	/**
	 * @Title:
	 * @Description: 批量保存地址核验
	 * @param pycreditAddrs
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:28
	 */
	int insertDataList(List<PycreditAddr> pycreditAddrs);

	/**
	 * @Title:
	 * @Description: 修改地址核验
	 * @param pycreditAddr
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:28
	 */
	int updateByPrimaryKeyData(PycreditAddr pycreditAddr);

	/**
	 * @Title:
	 * @Description: 批量修改地址核验
	 * @param pycreditAddrs
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:28
	 */
	int updateByPrimaryKeyDataList(List<PycreditAddr> pycreditAddrs);

	/**
	 * @Title:
	 * @Description: 动态修改地址核验
	 * @param pycreditAddr
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:28
	 */
	int updateByPrimaryKeySelectiveData(PycreditAddr pycreditAddr);

	/**
	 * @Title:
	 * @Description: 批量动态修改地址核验
	 * @param pycreditAddrs
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:28
	 */
	int updateByPrimaryKeySelectiveDataList(List<PycreditAddr> pycreditAddrs);

	/**
	 * @Title:
	 * @Description: 根据条件修改地址核验
	 * @param pycreditAddr
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:28
	 */
	int updateByExampleData(PycreditAddr pycreditAddr, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改地址核验
	 * @param pycreditAddr
	 * @param example
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:28
	 */
	int updateByExampleSelectiveData(PycreditAddr pycreditAddr, Example example);

	/**
	 * @Title:
	 * @Description: 根据pycreditAddrId删除地址核验
	 * @param pycreditAddr
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:28
	 */
	int deleteData(PycreditAddr pycreditAddr);

	/**
	 * @Title:
	 * @Description: 根据pycreditAddrId集合批量删除地址核验
	 * @param pycreditAddrIds
	 * @param pycreditAddr
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:28
	 */
	int deleteDataList(List pycreditAddrIds,PycreditAddr pycreditAddr);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除地址核验
	 * @param example
	 * @param pycreditAddr
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:28
	 */
	int deleteExampleData(Example example,PycreditAddr pycreditAddr);

	/**
	 * @Title:
	 * @Description: 查询全部地址核验
	 * @return List<PycreditAddr>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:28
	 */
	List<PycreditAddr> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个地址核验
	 * @param example
	 * @return PycreditAddr
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:28
	 */
	PycreditAddr selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询地址核验
	 * @param example
	 * @return List<PycreditAddr>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:28
	 */
	List<PycreditAddr> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过pycreditAddrId查询地址核验
	 * @param pycreditAddrId
	 * @return PycreditAddr
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:28
	 */
	PycreditAddr selectByPrimaryKey(Object pycreditAddrId);

	/**
	 * @Title:
	 * @Description: 分页查询地址核验
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<PycreditAddr>
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:28
	 */
	PageInfoExtend<PycreditAddr> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询地址核验vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:28
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改地址核验
	 * @param pycreditAddr,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:28
	 */
	int updateByPrimaryKeyData(PycreditAddr pycreditAddr,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改地址核验,并进行排他
	 * @param pycreditAddrs
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:28
	 */
	int updateByPrimaryKeyDataList(List<PycreditAddr> pycreditAddrs,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改地址核验,并进行排他
	 * @param pycreditAddr
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(PycreditAddr pycreditAddr,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改地址核验,并进行排他
	 * @param pycreditAddrs
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:28
	 */
	int updateByPrimaryKeySelectiveDataList(List<PycreditAddr> pycreditAddrs,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改地址核验,并进行排他
	 * @param pycreditAddr
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:28
	 */
	int updateByExampleData(PycreditAddr pycreditAddr, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改地址核验,并进行排他
	 * @param pycreditAddr
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author liujinge
	 * @date 2018-6-4 15:09:28
	 */
	int updateByExampleSelectiveData(PycreditAddr pycreditAddr, Example example,boolean exclusive);
	/**
	 * @Title:
	 * @Description: 根据条件动态修改地址核验,并进行排他
	 * @param documentNo
	 * @return String
	 * @throws
	 * @author yanggang
	 * @date 2018-6-22 15:08:52
	 */
	List<PycreditAddr> selectPycreditAddrList(String documentNo, int ceilingNumber);

	/** 
	* @Description: 查询最近一条查询记录
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/7/6 11:39
	*/ 
    PycreditAddr selectLastPycreditAddrByDocumentNo(String documentNo);
}
