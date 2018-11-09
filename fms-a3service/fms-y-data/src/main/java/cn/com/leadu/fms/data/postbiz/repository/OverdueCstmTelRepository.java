package cn.com.leadu.fms.data.postbiz.repository;

import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstmTel;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: OverdueCstmTelRepository
 * @Description: 逾期客户电话信息Repository层
 * @date 2018-05-17
 */
public interface OverdueCstmTelRepository {

	/**
	 * @Title:
	 * @Description: 新增逾期客户电话信息
	 * @param overdueCstmTel
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 10:37:53
	 */
	int insertData(OverdueCstmTel overdueCstmTel);

	/**
	 * @Title:
	 * @Description: 批量保存逾期客户电话信息
	 * @param overdueCstmTels
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 10:37:53
	 */
	int insertDataList(List<OverdueCstmTel> overdueCstmTels);

	/**
	 * @Title:
	 * @Description: 修改逾期客户电话信息
	 * @param overdueCstmTel
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 10:37:53
	 */
	int updateByPrimaryKeyData(OverdueCstmTel overdueCstmTel);

	/**
	 * @Title:
	 * @Description: 批量修改逾期客户电话信息
	 * @param overdueCstmTels
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 10:37:53
	 */
	int updateByPrimaryKeyDataList(List<OverdueCstmTel> overdueCstmTels);

	/**
	 * @Title:
	 * @Description: 动态修改逾期客户电话信息
	 * @param overdueCstmTel
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 10:37:53
	 */
	int updateByPrimaryKeySelectiveData(OverdueCstmTel overdueCstmTel);

	/**
	 * @Title:
	 * @Description: 批量动态修改逾期客户电话信息
	 * @param overdueCstmTels
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 10:37:53
	 */
	int updateByPrimaryKeySelectiveDataList(List<OverdueCstmTel> overdueCstmTels);

	/**
	 * @Title:
	 * @Description: 根据条件修改逾期客户电话信息
	 * @param overdueCstmTel
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 10:37:53
	 */
	int updateByExampleData(OverdueCstmTel overdueCstmTel, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改逾期客户电话信息
	 * @param overdueCstmTel
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 10:37:53
	 */
	int updateByExampleSelectiveData(OverdueCstmTel overdueCstmTel, Example example);

	/**
	 * @Title:
	 * @Description: 根据overdueCstmTelId删除逾期客户电话信息
	 * @param overdueCstmTel
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 10:37:53
	 */
	int deleteData(OverdueCstmTel overdueCstmTel);

	/**
	 * @Title:
	 * @Description: 根据overdueCstmTelId集合批量删除逾期客户电话信息
	 * @param overdueCstmTelIds
	 * @param overdueCstmTel
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 10:37:53
	 */
	int deleteDataList(List overdueCstmTelIds, OverdueCstmTel overdueCstmTel);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除逾期客户电话信息
	 * @param example
	 * @param overdueCstmTel
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 10:37:53
	 */
	int deleteExampleData(Example example, OverdueCstmTel overdueCstmTel);

	/**
	 * @Title:
	 * @Description: 查询全部逾期客户电话信息
	 * @return List<OverdueCstmTel>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 10:37:53
	 */
	List<OverdueCstmTel> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个逾期客户电话信息
	 * @param example
	 * @return OverdueCstmTel
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 10:37:53
	 */
	OverdueCstmTel selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询逾期客户电话信息
	 * @param example
	 * @return List<OverdueCstmTel>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 10:37:53
	 */
	List<OverdueCstmTel> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过overdueCstmTelId查询逾期客户电话信息
	 * @param overdueCstmTelId
	 * @return OverdueCstmTel
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 10:37:53
	 */
	OverdueCstmTel selectByPrimaryKey(Object overdueCstmTelId);

	/**
	 * @Title:
	 * @Description: 分页查询逾期客户电话信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<OverdueCstmTel>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 10:37:53
	 */
	PageInfoExtend<OverdueCstmTel> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询逾期客户电话信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-17 10:37:53
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
