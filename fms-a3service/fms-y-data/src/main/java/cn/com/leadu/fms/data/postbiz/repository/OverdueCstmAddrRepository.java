package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstmAddr;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: OverdueCstmAddrRepository
 * @Description: 逾期客户地址信息Repository层
 * @date 2018-05-17
 */
public interface OverdueCstmAddrRepository {

	/**
	 * @Title:
	 * @Description: 新增逾期客户地址信息
	 * @param overdueCstmAddr
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 14:48:57
	 */
	int insertData(OverdueCstmAddr overdueCstmAddr);

	/**
	 * @Title:
	 * @Description: 批量保存逾期客户地址信息
	 * @param overdueCstmAddrs
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 14:48:57
	 */
	int insertDataList(List<OverdueCstmAddr> overdueCstmAddrs);

	/**
	 * @Title:
	 * @Description: 修改逾期客户地址信息
	 * @param overdueCstmAddr
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 14:48:57
	 */
	int updateByPrimaryKeyData(OverdueCstmAddr overdueCstmAddr);

	/**
	 * @Title:
	 * @Description: 批量修改逾期客户地址信息
	 * @param overdueCstmAddrs
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 14:48:57
	 */
	int updateByPrimaryKeyDataList(List<OverdueCstmAddr> overdueCstmAddrs);

	/**
	 * @Title:
	 * @Description: 动态修改逾期客户地址信息
	 * @param overdueCstmAddr
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 14:48:57
	 */
	int updateByPrimaryKeySelectiveData(OverdueCstmAddr overdueCstmAddr);

	/**
	 * @Title:
	 * @Description: 批量动态修改逾期客户地址信息
	 * @param overdueCstmAddrs
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 14:48:57
	 */
	int updateByPrimaryKeySelectiveDataList(List<OverdueCstmAddr> overdueCstmAddrs);

	/**
	 * @Title:
	 * @Description: 根据条件修改逾期客户地址信息
	 * @param overdueCstmAddr
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 14:48:57
	 */
	int updateByExampleData(OverdueCstmAddr overdueCstmAddr, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改逾期客户地址信息
	 * @param overdueCstmAddr
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 14:48:57
	 */
	int updateByExampleSelectiveData(OverdueCstmAddr overdueCstmAddr, Example example);

	/**
	 * @Title:
	 * @Description: 根据overdueCstmAddrId删除逾期客户地址信息
	 * @param overdueCstmAddr
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 14:48:57
	 */
	int deleteData(OverdueCstmAddr overdueCstmAddr);

	/**
	 * @Title:
	 * @Description: 根据overdueCstmAddrId集合批量删除逾期客户地址信息
	 * @param overdueCstmAddrIds
	 * @param overdueCstmAddr
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 14:48:57
	 */
	int deleteDataList(List overdueCstmAddrIds, OverdueCstmAddr overdueCstmAddr);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除逾期客户地址信息
	 * @param example
	 * @param overdueCstmAddr
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 14:48:57
	 */
	int deleteExampleData(Example example, OverdueCstmAddr overdueCstmAddr);

	/**
	 * @Title:
	 * @Description: 查询全部逾期客户地址信息
	 * @return List<OverdueCstmAddr>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 14:48:57
	 */
	List<OverdueCstmAddr> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个逾期客户地址信息
	 * @param example
	 * @return OverdueCstmAddr
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 14:48:57
	 */
	OverdueCstmAddr selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询逾期客户地址信息
	 * @param example
	 * @return List<OverdueCstmAddr>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 14:48:57
	 */
	List<OverdueCstmAddr> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过overdueCstmAddrId查询逾期客户地址信息
	 * @param overdueCstmAddrId
	 * @return OverdueCstmAddr
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 14:48:57
	 */
	OverdueCstmAddr selectByPrimaryKey(Object overdueCstmAddrId);

	/**
	 * @Title:
	 * @Description: 分页查询逾期客户地址信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<OverdueCstmAddr>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 14:48:57
	 */
	PageInfoExtend<OverdueCstmAddr> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询逾期客户地址信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 14:48:57
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
