package cn.com.leadu.fms.data.finance.repository;

import cn.com.leadu.fms.pojo.finance.entity.ContReceiptExam;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: ContReceiptExamRepository
 * @Description: 财务勾稽信息Repository层
 * @date 2018-06-05
 */
public interface ContReceiptExamRepository {

	/**
	 * @Title:
	 * @Description: 新增财务勾稽信息
	 * @param contReceiptExam
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-5 14:42:43
	 */
	int insertData(ContReceiptExam contReceiptExam);

	/**
	 * @Title:
	 * @Description: 批量保存财务勾稽信息
	 * @param contReceiptExams
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-5 14:42:43
	 */
	int insertDataList(List<ContReceiptExam> contReceiptExams);

	/**
	 * @Title:
	 * @Description: 修改财务勾稽信息
	 * @param contReceiptExam
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-5 14:42:43
	 */
	int updateByPrimaryKeyData(ContReceiptExam contReceiptExam);

	/**
	 * @Title:
	 * @Description: 批量修改财务勾稽信息
	 * @param contReceiptExams
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-5 14:42:43
	 */
	int updateByPrimaryKeyDataList(List<ContReceiptExam> contReceiptExams);

	/**
	 * @Title:
	 * @Description: 动态修改财务勾稽信息
	 * @param contReceiptExam
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-5 14:42:43
	 */
	int updateByPrimaryKeySelectiveData(ContReceiptExam contReceiptExam);

	/**
	 * @Title:
	 * @Description: 批量动态修改财务勾稽信息
	 * @param contReceiptExams
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-5 14:42:43
	 */
	int updateByPrimaryKeySelectiveDataList(List<ContReceiptExam> contReceiptExams);

	/**
	 * @Title:
	 * @Description: 根据条件修改财务勾稽信息
	 * @param contReceiptExam
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-5 14:42:43
	 */
	int updateByExampleData(ContReceiptExam contReceiptExam, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改财务勾稽信息
	 * @param contReceiptExam
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-5 14:42:43
	 */
	int updateByExampleSelectiveData(ContReceiptExam contReceiptExam, Example example);

	/**
	 * @Title:
	 * @Description: 根据contReceiptExamId删除财务勾稽信息
	 * @param contReceiptExam
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-5 14:42:43
	 */
	int deleteData(ContReceiptExam contReceiptExam);

	/**
	 * @Title:
	 * @Description: 根据contReceiptExamId集合批量删除财务勾稽信息
	 * @param contReceiptExamIds
	 * @param contReceiptExam
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-5 14:42:43
	 */
	int deleteDataList(List contReceiptExamIds,ContReceiptExam contReceiptExam);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除财务勾稽信息
	 * @param example
	 * @param contReceiptExam
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-5 14:42:43
	 */
	int deleteExampleData(Example example,ContReceiptExam contReceiptExam);

	/**
	 * @Title:
	 * @Description: 查询全部财务勾稽信息
	 * @return List<ContReceiptExam>
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-5 14:42:43
	 */
	List<ContReceiptExam> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个财务勾稽信息
	 * @param example
	 * @return ContReceiptExam
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-5 14:42:43
	 */
	ContReceiptExam selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询财务勾稽信息
	 * @param example
	 * @return List<ContReceiptExam>
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-5 14:42:43
	 */
	List<ContReceiptExam> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过contReceiptExamId查询财务勾稽信息
	 * @param contReceiptExamId
	 * @return ContReceiptExam
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-5 14:42:43
	 */
	ContReceiptExam selectByPrimaryKey(Object contReceiptExamId);

	/**
	 * @Title:
	 * @Description: 分页查询财务勾稽信息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ContReceiptExam>
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-5 14:42:43
	 */
	PageInfoExtend<ContReceiptExam> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询财务勾稽信息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-5 14:42:43
	 */
	PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 修改财务勾稽信息
	 * @param contReceiptExam,并进行排他
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-5 14:42:43
	 */
	int updateByPrimaryKeyData(ContReceiptExam contReceiptExam,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量修改财务勾稽信息,并进行排他
	 * @param contReceiptExams
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-5 14:42:43
	 */
	int updateByPrimaryKeyDataList(List<ContReceiptExam> contReceiptExams,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据主键动态修改财务勾稽信息,并进行排他
	 * @param contReceiptExam
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-25 11:13:59
	 */
	int updateByPrimaryKeySelectiveData(ContReceiptExam contReceiptExam,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 批量动态修改财务勾稽信息,并进行排他
	 * @param contReceiptExams
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-5 14:42:43
	 */
	int updateByPrimaryKeySelectiveDataList(List<ContReceiptExam> contReceiptExams,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件修改财务勾稽信息,并进行排他
	 * @param contReceiptExam
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-5 14:42:43
	 */
	int updateByExampleData(ContReceiptExam contReceiptExam, Example example,boolean exclusive);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改财务勾稽信息,并进行排他
	 * @param contReceiptExam
	 * @param example
	 * @param exclusive
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-6-5 14:42:43
	 */
	int updateByExampleSelectiveData(ContReceiptExam contReceiptExam, Example example,boolean exclusive);

}
