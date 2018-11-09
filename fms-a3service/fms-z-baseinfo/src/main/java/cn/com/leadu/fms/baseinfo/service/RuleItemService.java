package cn.com.leadu.fms.baseinfo.service;

import cn.com.leadu.fms.pojo.baseinfo.entity.RuleItem;
import cn.com.leadu.fms.pojo.baseinfo.vo.ruleitem.RuleItemVo;
import cn.com.leadu.fms.baseinfo.validator.ruleitem.vo.RuleItemSaveVo;
import cn.com.leadu.fms.baseinfo.validator.ruleitem.vo.RuleItemModifyVo;
import cn.com.leadu.fms.baseinfo.validator.ruleitem.vo.RuleItemDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.ruleitem.vo.RuleItemDeleteListVo;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: RuleItemService
 * @Description: 规则引擎项目管理业务层
 * @date 2018-05-17
 */
public interface RuleItemService {

	/**
	 * @Title:
	 * @Description: 分页查询规则引擎项目管理
	 * @param ruleItemVo
	 * @return PageInfoExtend<RuleItem>
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:37:22
	 */
	PageInfoExtend<RuleItem> findRuleItemsByPage(RuleItemVo ruleItemVo);

	/**
	 * @Title:
	 * @Description: 保存规则引擎项目管理
	 * @param ruleItemSaveVo
	 * @return java.lang.String
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:37:22
	 */
    void saveRuleItem(RuleItemSaveVo ruleItemSaveVo);


	/**
	 * @Title:
	 * @Description: 修改规则引擎项目管理
	 * @param ruleItemModifyVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:37:22
	 */
	void modifyRuleItem(RuleItemModifyVo ruleItemModifyVo);

	/**
	 * @Title:
	 * @Description:  通过ruleItemId删除规则引擎项目管理
	 * @param ruleItemDeleteVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:37:22
	 */
	void deleteRuleItem(RuleItemDeleteVo ruleItemDeleteVo);


	/**
	 * @Title:
	 * @Description:  通过ruleItemId集合删除规则引擎项目管理
	 * @param ruleItemDeleteListVo
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:37:22
	 */
	void deleteRuleItemsByRuleItemIds(RuleItemDeleteListVo ruleItemDeleteListVo);



	/**
	 * @Title:
	 * @Description:  根据ruleItemId获取规则引擎项目管理
	 * @param ruleItemId
	 * @return RuleItem
	 * @throws
	 * @author qiaomengnan
	 * @date 2018-5-17 10:37:22
	 */
	RuleItem findRuleItemByRuleItemId(String ruleItemId);

	/**
	 * @Title:
	 * @Description:   查询出所有项目，通过时间倒序
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/17 05:49:49
	 */
	List<RuleItem> findRuleItemsByAll();

	/**
	 * @Title:
	 * @Description:   根据规则类型和项目属性查询规则项目
	 * @param ruleType
	 * @param itemType
	 * @return
	 * @throws
	 * @author qiaomengnan
	 * @date 2018/05/17 06:36:59
	 */
	List<RuleItem> findRuleItemsByRuleTypeAndItemType(String ruleType ,String itemType);

}
