package cn.com.leadu.fms.data.baseinfo.repository;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.pojo.baseinfo.entity.RuleConsequence;
import cn.com.leadu.fms.pojo.baseinfo.vo.ruleconsequence.RuleConsequenceVo;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: RuleConsequenceRepository
 * @Description: 规则引擎结果Repository层
 * @date 2018-05-17
 */
public interface RuleConsequenceRepository {

	/**
	 * @Title:
	 * @Description: 新增规则引擎结果
	 * @param ruleConsequence
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:36:10
	 */
	int insertData(RuleConsequence ruleConsequence);

	/**
	 * @Title:
	 * @Description: 批量保存规则引擎结果
	 * @param ruleConsequences
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:36:10
	 */
	int insertDataList(List<RuleConsequence> ruleConsequences);

	/**
	 * @Title:
	 * @Description: 修改规则引擎结果
	 * @param ruleConsequence
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:36:10
	 */
	int updateByPrimaryKeyData(RuleConsequence ruleConsequence);

	/**
	 * @Title:
	 * @Description: 批量修改规则引擎结果
	 * @param ruleConsequences
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:36:10
	 */
	int updateByPrimaryKeyDataList(List<RuleConsequence> ruleConsequences);

	/**
	 * @Title:
	 * @Description: 动态修改规则引擎结果
	 * @param ruleConsequence
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:36:10
	 */
	int updateByPrimaryKeySelectiveData(RuleConsequence ruleConsequence);

	/**
	 * @Title:
	 * @Description: 批量动态修改规则引擎结果
	 * @param ruleConsequences
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:36:10
	 */
	int updateByPrimaryKeySelectiveDataList(List<RuleConsequence> ruleConsequences);

	/**
	 * @Title:
	 * @Description: 根据条件修改规则引擎结果
	 * @param ruleConsequence
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:36:10
	 */
	int updateByExampleData(RuleConsequence ruleConsequence, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改规则引擎结果
	 * @param ruleConsequence
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:36:10
	 */
	int updateByExampleSelectiveData(RuleConsequence ruleConsequence, Example example);

	/**
	 * @Title:
	 * @Description: 根据ruleConseqId删除规则引擎结果
	 * @param ruleConsequence
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:36:10
	 */
	int deleteData(RuleConsequence ruleConsequence);

	/**
	 * @Title:
	 * @Description: 根据ruleConseqId集合批量删除规则引擎结果
	 * @param ruleConseqIds
	 * @param ruleConsequence
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:36:10
	 */
	int deleteDataList(List ruleConseqIds, RuleConsequence ruleConsequence);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除规则引擎结果
	 * @param example
	 * @param ruleConsequence
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:36:10
	 */
	int deleteExampleData(Example example, RuleConsequence ruleConsequence);

	/**
	 * @Title:
	 * @Description: 查询全部规则引擎结果
	 * @return List<RuleConsequence>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:36:10
	 */
	List<RuleConsequence> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个规则引擎结果
	 * @param example
	 * @return RuleConsequence
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:36:10
	 */
	RuleConsequence selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询规则引擎结果
	 * @param example
	 * @return List<RuleConsequence>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:36:10
	 */
	List<RuleConsequence> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过ruleConseqId查询规则引擎结果
	 * @param ruleConseqId
	 * @return RuleConsequence
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:36:10
	 */
	RuleConsequence selectByPrimaryKey(Object ruleConseqId);

	/**
	 * @Title:
	 * @Description: 分页查询规则引擎结果
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<RuleConsequence>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:36:10
	 */
	PageInfoExtend<RuleConsequence> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询规则引擎结果vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:36:10
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description:   根据规则id查询规则结果列表
	 * @param ruleConsequenceVo
	 * @return List<RuleConsequenceVo>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/21 12:49:37
	 */
	List<RuleConsequenceVo> selectRuleConsequenceVosByRuleId(RuleConsequenceVo ruleConsequenceVo);

	/**
	 * @Title:
	 * @Description:   查询规则结果列表
	 * @param ruleConsequenceVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/21 12:41:42
	 */
	List<RuleConsequenceVo> selectRuleConsequenceVos(RuleConsequenceVo ruleConsequenceVo);

}
