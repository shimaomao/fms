package cn.com.leadu.fms.data.baseinfo.repository;

import cn.com.leadu.fms.pojo.baseinfo.entity.RuleItem;
import cn.com.leadu.fms.common.vo.PageQuery;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: RuleItemRepository
 * @Description: 规则引擎项目管理Repository层
 * @date 2018-05-17
 */
public interface RuleItemRepository {

	/**
	 * @Title:
	 * @Description: 新增规则引擎项目管理
	 * @param ruleItem
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:37:22
	 */
	int insertData(RuleItem ruleItem);

	/**
	 * @Title:
	 * @Description: 批量保存规则引擎项目管理
	 * @param ruleItems
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:37:22
	 */
	int insertDataList(List<RuleItem> ruleItems);

	/**
	 * @Title:
	 * @Description: 修改规则引擎项目管理
	 * @param ruleItem
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:37:22
	 */
	int updateByPrimaryKeyData(RuleItem ruleItem);

	/**
	 * @Title:
	 * @Description: 批量修改规则引擎项目管理
	 * @param ruleItems
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:37:22
	 */
	int updateByPrimaryKeyDataList(List<RuleItem> ruleItems);

	/**
	 * @Title:
	 * @Description: 动态修改规则引擎项目管理
	 * @param ruleItem
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:37:22
	 */
	int updateByPrimaryKeySelectiveData(RuleItem ruleItem);

	/**
	 * @Title:
	 * @Description: 批量动态修改规则引擎项目管理
	 * @param ruleItems
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:37:22
	 */
	int updateByPrimaryKeySelectiveDataList(List<RuleItem> ruleItems);

	/**
	 * @Title:
	 * @Description: 根据条件修改规则引擎项目管理
	 * @param ruleItem
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:37:22
	 */
	int updateByExampleData(RuleItem ruleItem, Example example);

	/**
	 * @Title:
	 * @Description: 根据条件动态修改规则引擎项目管理
	 * @param ruleItem
	 * @param example
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:37:22
	 */
	int updateByExampleSelectiveData(RuleItem ruleItem, Example example);

	/**
	 * @Title:
	 * @Description: 根据ruleItemId删除规则引擎项目管理
	 * @param ruleItem
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:37:22
	 */
	int deleteData(RuleItem ruleItem);

	/**
	 * @Title:
	 * @Description: 根据ruleItemId集合批量删除规则引擎项目管理
	 * @param ruleItemIds
	 * @param ruleItem
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:37:22
	 */
	int deleteDataList(List ruleItemIds, RuleItem ruleItem);

	/**
	 * @Title:
	 * @Description: 根据自定义条件删除规则引擎项目管理
	 * @param example
	 * @param ruleItem
	 * @return int
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:37:22
	 */
	int deleteExampleData(Example example, RuleItem ruleItem);

	/**
	 * @Title:
	 * @Description: 查询全部规则引擎项目管理
	 * @return List<RuleItem>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:37:22
	 */
	List<RuleItem> selectAll();

	/**
	 * @Title:
	 * @Description: 通过条件查询一个规则引擎项目管理
	 * @param example
	 * @return RuleItem
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:37:22
	 */
	RuleItem selectOneByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过条件批量查询规则引擎项目管理
	 * @param example
	 * @return List<RuleItem>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:37:22
	 */
	List<RuleItem> selectListByExample(Example example);

	/**
	 * @Title:
	 * @Description: 通过ruleItemId查询规则引擎项目管理
	 * @param ruleItemId
	 * @return RuleItem
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:37:22
	 */
	RuleItem selectByPrimaryKey(Object ruleItemId);

	/**
	 * @Title:
	 * @Description: 分页查询规则引擎项目管理
	 * @param example
	 * @param pageQuery
	 * @return PageInfoExtend<RuleItem>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:37:22
	 */
	PageInfoExtend<RuleItem> selectListByExamplePage(Example example, PageQuery pageQuery);

	/**
	 * @Title:
	 * @Description: 分页查询规则引擎项目管理vo
	 * @param methodName
	 * @param param
	 * @param pageQuery
	 * @return PageInfoExtend
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:37:22
	 */
	PageInfoExtend selectListVoByPage(String methodName, Object param, PageQuery pageQuery);

}
