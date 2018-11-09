package cn.com.leadu.fms.data.finance.repository;

import cn.com.leadu.fms.pojo.finance.entity.ContOverdue;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.vo.contoverdue.ContOverdueVo;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: ContOverdueRepository
 * @Description: 还款逾期罚息Repository层
 * @date 2018-05-08
 */
public interface ContOverdueRepository {

	/**
	 * @Title:
	 * @Description: 新增还款逾期罚息
	 * @param contOverdue
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 14:55:31
	 */
	int insertData(ContOverdue contOverdue);

	/**
	 * @Title:
	 * @Description: 批量保存还款逾期罚息
	 * @param contOverdues
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 14:55:31
	 */
	int insertDataList(List<ContOverdue> contOverdues);

	/**
	 * @Title:
	 * @Description: 修改还款逾期罚息
	 * @param contOverdue
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 14:55:31
	 */
	int updateByPrimaryKeyData(ContOverdue contOverdue);

	/**
	 * @Title:
	 * @Description: 批量修改还款逾期罚息
	 * @param contOverdues
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 14:55:31
	 */
	int updateByPrimaryKeyDataList(List<ContOverdue> contOverdues);

	/**
	 * @Title:
	 * @Description: 动态修改还款逾期罚息
	 * @param contOverdue
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 14:55:31
	 */
	int updateByPrimaryKeySelectiveData(ContOverdue contOverdue);

	/**
	 * @Title:
	 * @Description: 批量动态修改还款逾期罚息
	 * @param contOverdues
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 14:55:31
	 */
	int updateByPrimaryKeySelectiveDataList(List<ContOverdue> contOverdues);

	/**
	 * @Title:
	 * @Description: 根据条件修改还款逾期罚息
	 * @param contOverdue
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 14:55:31
	 */
	int updateByExampleData(ContOverdue contOverdue, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改还款逾期罚息
	 * @param contOverdue
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 14:55:31
	 */
	int updateByExampleSelectiveData(ContOverdue contOverdue, Example example);

	/**
	 * @Title:
	 * @Description: 根据contOverdueId删除还款逾期罚息
	 * @param contOverdue
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 14:55:31
	 */
	int deleteData(ContOverdue contOverdue);

	/**
	 * @Title:
	 * @Description: 根据contOverdueId集合批量删除还款逾期罚息
	 * @param contOverdueIds
	 * @param contOverdue
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 14:55:31
	 */
	int deleteDataList(List contOverdueIds, ContOverdue contOverdue);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除还款逾期罚息
	 * @param example
	 * @param contOverdue
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 14:55:31
	 */
	int deleteExampleData(Example example, ContOverdue contOverdue);

	/**
	 * @Title:
	 * @Description: 查询全部还款逾期罚息
	 * @return List<ContOverdue>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 14:55:31
	 */
	List<ContOverdue> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个还款逾期罚息
	 * @param example
	 * @return ContOverdue
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 14:55:31
	 */
	ContOverdue selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询还款逾期罚息
	 * @param example
	 * @return List<ContOverdue>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 14:55:31
	 */
	List<ContOverdue> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过contOverdueId查询还款逾期罚息
	 * @param contOverdueId
	 * @return ContOverdue
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 14:55:31
	 */
	ContOverdue selectByPrimaryKey(Object contOverdueId);

	/**
	 * @Title:
	 * @Description: 分页查询还款逾期罚息
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<ContOverdue>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 14:55:31
	 */
	PageInfoExtend<ContOverdue> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询还款逾期罚息vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-8 14:55:31
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/** 
	* @Description: 查询逾期罚息表中，扣款状态<>成功 的剩余罚息金额合计
	* @param:  
	* @return:  
	* @Author: yangyiquan
	* @Date: 2018/5/14 14:51
	*/ 
	BigDecimal selectOverdueInterestSum(ContOverdueVo contOverdueVo);

	/**
	 * @Description:  查询罚息表中未还款数量
	 * @param:
	 * @return:
	 * @Author: ningyangyang
	 * @Date: 2018/5/15 14:54
	 */
	Integer selectCountOverDueByContNo( String contNo);

	/**
	 * @Description: 根据合同号查找总罚息
	 * @param:
	 * @return:
	 * @Author: ningyangyang
	 * @Date: 2018/5/15 14:54
	 */
	BigDecimal selectContOverdueAmountByContNo(String contNo);

	/**
	 * @Description: 根据申请号查找总罚息
	 * @param:
	 * @return:
	 * @Author: ningyangyang
	 * @Date: 2018/5/15 14:54
	 */
	BigDecimal selectContOverdueAmountByApplyNo(String applyNo);

	/**
	 * @Title:
	 * @Description: 根据合同号关联查询逾期罚息表和还款计划表
	 * @param
	 * @return
	 * @throws
	 * @author yanfengbo
	 * @date
	 */
	List<ContOverdueVo> selectContOverdueByCont(String contNo);
}
