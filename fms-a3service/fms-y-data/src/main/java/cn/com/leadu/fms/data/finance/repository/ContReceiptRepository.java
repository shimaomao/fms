package cn.com.leadu.fms.data.finance.repository;

import cn.com.leadu.fms.pojo.finance.entity.ContReceipt;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: ContReceiptRepository
 * @Description: 黑名单Repository层
 * @date 2018-05-07
 */
public interface ContReceiptRepository {

	/**
	 * @Title:
	 * @Description: 新增黑名单
	 * @param contReceipt
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-7 18:04:31
	 */
	int insertData(ContReceipt contReceipt);

	/**
	 * @Title:
	 * @Description: 批量保存黑名单
	 * @param contReceipts
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-7 18:04:31
	 */
	int insertDataList(List<ContReceipt> contReceipts);

	/**
	 * @Title:
	 * @Description: 修改黑名单
	 * @param contReceipt
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-7 18:04:31
	 */
	int updateByPrimaryKeyData(ContReceipt contReceipt);

	/**
	 * @Title:
	 * @Description: 批量修改黑名单
	 * @param contReceipts
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-7 18:04:31
	 */
	int updateByPrimaryKeyDataList(List<ContReceipt> contReceipts);

	/**
	 * @Title:
	 * @Description: 动态修改黑名单
	 * @param contReceipt
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-7 18:04:31
	 */
	int updateByPrimaryKeySelectiveData(ContReceipt contReceipt);

	/**
	 * @Title:
	 * @Description: 批量动态修改黑名单
	 * @param contReceipts
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-7 18:04:31
	 */
	int updateByPrimaryKeySelectiveDataList(List<ContReceipt> contReceipts);

	/**
	 * @Title:
	 * @Description: 根据条件修改黑名单
	 * @param contReceipt
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-7 18:04:31
	 */
	int updateByExampleData(ContReceipt contReceipt, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改黑名单
	 * @param contReceipt
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-7 18:04:31
	 */
	int updateByExampleSelectiveData(ContReceipt contReceipt, Example example);

	/**
	 * @Title:
	 * @Description: 根据contReceiptId删除黑名单
	 * @param contReceipt
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-7 18:04:31
	 */
	int deleteData(ContReceipt contReceipt);

	/**
	 * @Title:
	 * @Description: 根据contReceiptId集合批量删除黑名单
	 * @param contReceiptIds
	 * @param contReceipt
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-7 18:04:31
	 */
	int deleteDataList(List contReceiptIds, ContReceipt contReceipt);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除黑名单
	 * @param example
	 * @param contReceipt
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-7 18:04:31
	 */
	int deleteExampleData(Example example, ContReceipt contReceipt);

	/**
	 * @Title:
	 * @Description: 查询全部黑名单
	 * @return List<ContReceipt>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-7 18:04:31
	 */
	List<ContReceipt> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个黑名单
	 * @param example
	 * @return ContReceipt
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-7 18:04:31
	 */
	ContReceipt selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询黑名单
	 * @param example
	 * @return List<ContReceipt>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-7 18:04:31
	 */
	List<ContReceipt> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过contReceiptId查询黑名单
	 * @param contReceiptId
	 * @return ContReceipt
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-7 18:04:31
	 */
	ContReceipt selectByPrimaryKey(Object contReceiptId);

	/**
	 * @Title:
	 * @Description: 分页查询黑名单
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ContReceipt>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-7 18:04:31
	 */
	PageInfoExtend<ContReceipt> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询黑名单vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-7 18:04:31
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);
}
