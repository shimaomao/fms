package cn.com.leadu.fms.baseinfo.service.impl;

import cn.com.leadu.fms.baseinfo.service.RuleItemService;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.baseinfo.repository.RuleItemRepository;
import cn.com.leadu.fms.pojo.baseinfo.entity.RuleItem;
import cn.com.leadu.fms.pojo.baseinfo.vo.ruleitem.RuleItemVo;
import cn.com.leadu.fms.baseinfo.validator.ruleitem.vo.RuleItemSaveVo;
import cn.com.leadu.fms.baseinfo.validator.ruleitem.vo.RuleItemModifyVo;
import cn.com.leadu.fms.baseinfo.validator.ruleitem.vo.RuleItemDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.ruleitem.vo.RuleItemDeleteListVo;
import org.springframework.stereotype.Service;
import org.springframework.beans.factory.annotation.Autowired;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: RuleItemService
 * @Description: 规则引擎项目管理业务实现层
 * @date 2018-05-17
 */
@Service
public class RuleItemServiceImpl implements RuleItemService {

    /**
     * @Fields  : 规则引擎项目管理repository
     */
    @Autowired
    private RuleItemRepository ruleItemRepository;

    /**
     * @Title:
     * @Description: 分页查询规则引擎项目管理
     * @param ruleItemVo
     * @return PageInfoExtend<RuleItem>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    public PageInfoExtend<RuleItem> findRuleItemsByPage(RuleItemVo ruleItemVo){
        Example example = SqlUtil.newExample(RuleItem.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        PageInfoExtend<RuleItem> pageInfo = ruleItemRepository.selectListByExamplePage(example,ruleItemVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存规则引擎项目管理
     * @param ruleItemSaveVo
     * @return java.lang.String
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    public void saveRuleItem(RuleItemSaveVo ruleItemSaveVo){
        ruleItemRepository.insertData(ruleItemSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改规则引擎项目管理
     * @param ruleItemModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    public void modifyRuleItem(RuleItemModifyVo ruleItemModifyVo){
        ruleItemRepository.updateByPrimaryKeySelectiveData(ruleItemModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过ruleItemId删除规则引擎项目管理
     * @param ruleItemDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    public void deleteRuleItem(RuleItemDeleteVo ruleItemDeleteVo){
        ruleItemRepository.deleteData(ruleItemDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过ruleItemId集合删除规则引擎项目管理
     * @param ruleItemDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    public void deleteRuleItemsByRuleItemIds(RuleItemDeleteListVo ruleItemDeleteListVo){
        ruleItemRepository.deleteDataList(ruleItemDeleteListVo.getRuleItemIds(),ruleItemDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据ruleItemId获取规则引擎项目管理
     * @param ruleItemId
     * @return RuleItem
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    public RuleItem findRuleItemByRuleItemId(String ruleItemId){
        return ruleItemRepository.selectByPrimaryKey(ruleItemId);
    }

    /**
     * @Title:
     * @Description:   查询出所有项目，通过时间倒序
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/17 05:49:49
     */
    public List<RuleItem> findRuleItemsByAll(){
        Example example = SqlUtil.newExample(RuleItem.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        return ruleItemRepository.selectListByExample(example);
    }

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
    public List<RuleItem> findRuleItemsByRuleTypeAndItemType(String ruleType ,String itemType){
        Example example = SqlUtil.newExample(RuleItem.class);
        SqlUtil.setOrderByCreateTimeDesc(example);
        example.createCriteria().andEqualTo("ruleType",ruleType)
                .andEqualTo("itemType",itemType);
        return ruleItemRepository.selectListByExample(example);
    }

}
