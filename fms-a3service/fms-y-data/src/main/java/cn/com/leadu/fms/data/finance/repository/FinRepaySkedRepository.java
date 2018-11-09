package cn.com.leadu.fms.data.finance.repository;

import cn.com.leadu.fms.pojo.finance.entity.FinRepaySked;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.apache.ibatis.annotations.Param;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: FinRepaySkedRepository
 * @Description: 财务还款计划Repository层
 * @date 2018-05-12
 */
public interface FinRepaySkedRepository {

	/**
	 * @Title:
	 * @Description: 新增财务还款计划
	 * @param finRepaySked
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 16:40:57
	 */
	int insertData(FinRepaySked finRepaySked);

	/**
	 * @Title:
	 * @Description: 批量保存财务还款计划
	 * @param finRepaySkeds
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 16:40:57
	 */
	int insertDataList(List<FinRepaySked> finRepaySkeds);

	/**
	 * @Title:
	 * @Description: 修改财务还款计划
	 * @param finRepaySked
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 16:40:57
	 */
	int updateByPrimaryKeyData(FinRepaySked finRepaySked);

	/**
	 * @Title:
	 * @Description: 批量修改财务还款计划
	 * @param finRepaySkeds
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 16:40:57
	 */
	int updateByPrimaryKeyDataList(List<FinRepaySked> finRepaySkeds);

	/**
	 * @Title:
	 * @Description: 动态修改财务还款计划
	 * @param finRepaySked
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 16:40:57
	 */
	int updateByPrimaryKeySelectiveData(FinRepaySked finRepaySked);

	/**
	 * @Title:
	 * @Description: 批量动态修改财务还款计划
	 * @param finRepaySkeds
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 16:40:57
	 */
	int updateByPrimaryKeySelectiveDataList(List<FinRepaySked> finRepaySkeds);

	/**
	 * @Title:
	 * @Description: 根据条件修改财务还款计划
	 * @param finRepaySked
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 16:40:57
	 */
	int updateByExampleData(FinRepaySked finRepaySked, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改财务还款计划
	 * @param finRepaySked
	 * @param example
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 16:40:57
	 */
	int updateByExampleSelectiveData(FinRepaySked finRepaySked, Example example);

	/**
	 * @Title:
	 * @Description: 根据finRepaySkedId删除财务还款计划
	 * @param finRepaySked
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 16:40:57
	 */
	int deleteData(FinRepaySked finRepaySked);

	/**
	 * @Title:
	 * @Description: 根据finRepaySkedId集合批量删除财务还款计划
	 * @param finRepaySkedIds
	 * @param finRepaySked
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 16:40:57
	 */
	int deleteDataList(List finRepaySkedIds, FinRepaySked finRepaySked);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除财务还款计划
	 * @param example
	 * @param finRepaySked
	 * @return int
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 16:40:57
	 */
	int deleteExampleData(Example example, FinRepaySked finRepaySked);

	/**
	 * @Title:
	 * @Description: 查询全部财务还款计划
	 * @return List<FinRepaySked>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 16:40:57
	 */
	List<FinRepaySked> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个财务还款计划
	 * @param example
	 * @return FinRepaySked
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 16:40:57
	 */
	FinRepaySked selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询财务还款计划
	 * @param example
	 * @return List<FinRepaySked>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 16:40:57
	 */
	List<FinRepaySked> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过finRepaySkedId查询财务还款计划
	 * @param finRepaySkedId
	 * @return FinRepaySked
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 16:40:57
	 */
	FinRepaySked selectByPrimaryKey(Object finRepaySkedId);

	/**
	 * @Title:
	 * @Description: 分页查询财务还款计划
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<FinRepaySked>
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 16:40:57
	 */
	PageInfoExtend<FinRepaySked> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询财务还款计划vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author lijunjun
	 * @date 2018-5-12 16:40:57
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Description: 查找财务还款计划表未还款剩余本金
	 * @param:
	 * @return:
	 * @Author: ningyangyang
	 * @Date: 2018/5/22 11:05
	 * @param
	 */
	BigDecimal selectRestPrincipalAmountByContNo(String contNo);

	/**
	 * @Description: 根据申请编号查找财务还款计划表未还款剩余本金
	 * @param:
	 * @return:
	 * @Author: ningyangyang
	 * @Date: 2018/5/24 11:05
	 * @param
	 */
	BigDecimal selectRestPrincipalAmountByApplyNo(String contNo);
}
