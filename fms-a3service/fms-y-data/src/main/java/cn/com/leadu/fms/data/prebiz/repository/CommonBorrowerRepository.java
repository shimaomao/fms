package cn.com.leadu.fms.data.prebiz.repository;

import cn.com.leadu.fms.pojo.prebiz.entity.CommonBorrower;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: CommonBorrowerRepository
 * @Description: 共同借款人Repository层
 * @date 2018-05-25
 */
public interface CommonBorrowerRepository {

	/**
	 * @Title:
	 * @Description: 新增共同借款人
	 * @param commonBorrower
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-25 15:37:14
	 */
	int insertData(CommonBorrower commonBorrower);

	/**
	 * @Title:
	 * @Description: 批量保存共同借款人
	 * @param commonBorrowers
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-25 15:37:14
	 */
	int insertDataList(List<CommonBorrower> commonBorrowers);

	/**
	 * @Title:
	 * @Description: 修改共同借款人
	 * @param commonBorrower
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-25 15:37:14
	 */
	int updateByPrimaryKeyData(CommonBorrower commonBorrower);

	/**
	 * @Title:
	 * @Description: 批量修改共同借款人
	 * @param commonBorrowers
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-25 15:37:14
	 */
	int updateByPrimaryKeyDataList(List<CommonBorrower> commonBorrowers);

	/**
	 * @Title:
	 * @Description: 动态修改共同借款人
	 * @param commonBorrower
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-25 15:37:14
	 */
	int updateByPrimaryKeySelectiveData(CommonBorrower commonBorrower);

	/**
	 * @Title:
	 * @Description: 批量动态修改共同借款人
	 * @param commonBorrowers
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-25 15:37:14
	 */
	int updateByPrimaryKeySelectiveDataList(List<CommonBorrower> commonBorrowers);

	/**
	 * @Title:
	 * @Description: 根据条件修改共同借款人
	 * @param commonBorrower
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-25 15:37:14
	 */
	int updateByExampleData(CommonBorrower commonBorrower, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改共同借款人
	 * @param commonBorrower
	 * @param example
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-25 15:37:14
	 */
	int updateByExampleSelectiveData(CommonBorrower commonBorrower, Example example);

	/**
	 * @Title:
	 * @Description: 根据comBorrowerId删除共同借款人
	 * @param commonBorrower
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-25 15:37:14
	 */
	int deleteData(CommonBorrower commonBorrower);

	/**
	 * @Title:
	 * @Description: 根据comBorrowerId集合批量删除共同借款人
	 * @param comBorrowerIds
	 * @param commonBorrower
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-25 15:37:14
	 */
	int deleteDataList(List comBorrowerIds, CommonBorrower commonBorrower);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除共同借款人
	 * @param example
	 * @param commonBorrower
	 * @return int
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-25 15:37:14
	 */
	int deleteExampleData(Example example, CommonBorrower commonBorrower);

	/**
	 * @Title:
	 * @Description: 查询全部共同借款人
	 * @return List<CommonBorrower>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-25 15:37:14
	 */
	List<CommonBorrower> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个共同借款人
	 * @param example
	 * @return CommonBorrower
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-25 15:37:14
	 */
	CommonBorrower selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询共同借款人
	 * @param example
	 * @return List<CommonBorrower>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-25 15:37:14
	 */
	List<CommonBorrower> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过comBorrowerId查询共同借款人
	 * @param comBorrowerId
	 * @return CommonBorrower
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-25 15:37:14
	 */
	CommonBorrower selectByPrimaryKey(Object comBorrowerId);

	/**
	 * @Title:
	 * @Description: 分页查询共同借款人
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<CommonBorrower>
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-25 15:37:14
	 */
	PageInfoExtend<CommonBorrower> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询共同借款人vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author ningyangyang
	 * @date 2018-5-25 15:37:14
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
