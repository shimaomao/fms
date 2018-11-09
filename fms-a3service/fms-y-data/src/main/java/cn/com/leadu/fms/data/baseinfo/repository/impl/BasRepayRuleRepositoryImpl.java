package cn.com.leadu.fms.data.baseinfo.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.baseinfo.dao.BasRepayRuleDao;
import cn.com.leadu.fms.data.baseinfo.repository.BasRepayRuleRepository;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasRepayRule;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author huchenghao
 * @ClassName: BasRepayRuleRepositoryImpl
 * @Description: 还款日规则Repository 实现层
 * @date 2018-03-16
 */
@Repository
public class BasRepayRuleRepositoryImpl extends AbstractBaseRepository<BasRepayRuleDao, BasRepayRule> implements BasRepayRuleRepository {

    /**
     * @Title:
     * @Description: 新增还款日规则
     * @param basRepayRule
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    @Override
    public int insertData(BasRepayRule basRepayRule) {
        return super.insert(basRepayRule);
    }

    /**
     * @Title:
     * @Description: 批量保存还款日规则
     * @param basRepayRules
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    @Override
    public int insertDataList(List<BasRepayRule> basRepayRules){
        return super.insertListByJdbcTemplate(basRepayRules);
    }

    /**
     * @Title:
     * @Description: 修改还款日规则
     * @param basRepayRule
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    @Override
    public int updateByPrimaryKeyData(BasRepayRule basRepayRule) {
        return super.updateByPrimaryKey(basRepayRule);
    }

    /**
     * @Title:
     * @Description: 批量修改还款日规则
     * @param basRepayRules
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    @Override
    public int updateByPrimaryKeyDataList(List<BasRepayRule> basRepayRules){
        return super.updateListByPrimaryKey(basRepayRules);
    }

    /**
     * @Title:
     * @Description: 动态修改还款日规则
     * @param basRepayRule
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    @Override
    public int updateByPrimaryKeySelectiveData(BasRepayRule basRepayRule) {
        return super.updateByPrimaryKeySelective(basRepayRule);
    }

    /**
     * @Title:
     * @Description: 批量动态修改还款日规则
     * @param basRepayRules
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    public int updateByPrimaryKeySelectiveDataList(List<BasRepayRule> basRepayRules) {
        return super.updateListByPrimaryKeySelective(basRepayRules);
    }

    /**
     * @Title:
     * @Description: 根据条件修改还款日规则
     * @param basRepayRule
     * @param example
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    @Override
    public int updateByExampleData(BasRepayRule basRepayRule, Example example) {
        return super.updateByExample(basRepayRule,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改还款日规则
     * @param basRepayRule
     * @param example
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    @Override
    public int updateByExampleSelectiveData(BasRepayRule basRepayRule, Example example){
        return super.updateByExampleSelective(basRepayRule,example);
    }
    
    /**
     * @Title:
     * @Description: 根据ruleId删除还款日规则
     * @param basRepayRule
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    @Override
    public int deleteData(BasRepayRule basRepayRule) {
        return super.delete(basRepayRule);
    }

    /**
     * @Title:
     * @Description: 根据ruleId集合批量删除还款日规则
     * @param basRepayRule
     * @return int
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    public int deleteDataList(List ruleIds,BasRepayRule basRepayRule){
        return super.deleteByIds(ruleIds,basRepayRule);
    }

    /**
     * @Title:
     * @Description: 查询全部还款日规则
     * @return List<BasRepayRule>
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    @Override
    public List<BasRepayRule> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个还款日规则
     * @param example
     * @return BasRepayRule
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    @Override
    public BasRepayRule selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询还款日规则
     * @param example
     * @return List<BasRepayRule>
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    @Override
    public List<BasRepayRule> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过ruleId查询还款日规则
     * @param ruleId
     * @return BasRepayRule
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    @Override
    public BasRepayRule selectByPrimaryKey(Object ruleId) {
        return super.selectByPrimaryKey(ruleId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询还款日规则
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<BasRepayRule>
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    @Override
    public PageInfoExtend<BasRepayRule> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询还款日规则vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<BasRepayRule>
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    public PageInfoExtend<BasRepayRule> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
