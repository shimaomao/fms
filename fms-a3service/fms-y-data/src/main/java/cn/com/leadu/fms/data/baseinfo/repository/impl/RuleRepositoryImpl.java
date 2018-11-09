package cn.com.leadu.fms.data.baseinfo.repository.impl;

import cn.com.leadu.fms.data.baseinfo.dao.RuleDao;
import cn.com.leadu.fms.data.baseinfo.repository.RuleRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.baseinfo.entity.Rule;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.baseinfo.vo.rule.RuleVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: RuleRepositoryImpl
 * @Description: 规则引擎Repository 实现层
 * @date 2018-05-17
 */
@Repository
public class RuleRepositoryImpl extends AbstractBaseRepository<RuleDao, Rule> implements RuleRepository {

    /**
     * @Title:
     * @Description: 新增规则引擎
     * @param rule
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:26
     */
    @Override
    public int insertData(Rule rule) {
        return super.insert(rule);
    }

    /**
     * @Title:
     * @Description: 批量保存规则引擎
     * @param rules
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:26
     */
    @Override
    public int insertDataList(List<Rule> rules){
        return super.insertListByJdbcTemplate(rules);
    }

    /**
     * @Title:
     * @Description: 修改规则引擎
     * @param rule
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:26
     */
    @Override
    public int updateByPrimaryKeyData(Rule rule) {
        return super.updateByPrimaryKey(rule);
    }

    /**
     * @Title:
     * @Description: 批量修改规则引擎
     * @param rules
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:26
     */
    @Override
    public int updateByPrimaryKeyDataList(List<Rule> rules){
        return super.updateListByPrimaryKey(rules);
    }

    /**
     * @Title:
     * @Description: 动态修改规则引擎
     * @param rule
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:26
     */
    @Override
    public int updateByPrimaryKeySelectiveData(Rule rule) {
        return super.updateByPrimaryKeySelective(rule);
    }

    /**
     * @Title:
     * @Description: 批量动态修改规则引擎
     * @param rules
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:26
     */
    public int updateByPrimaryKeySelectiveDataList(List<Rule> rules) {
        return super.updateListByPrimaryKeySelective(rules);
    }

    /**
     * @Title:
     * @Description: 根据条件修改规则引擎
     * @param rule
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:26
     */
    @Override
    public int updateByExampleData(Rule rule, Example example) {
        return super.updateByExample(rule,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改规则引擎
     * @param rule
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:26
     */
    @Override
    public int updateByExampleSelectiveData(Rule rule, Example example){
        return super.updateByExampleSelective(rule,example);
    }
    
    /**
     * @Title:
     * @Description: 根据ruleId删除规则引擎
     * @param rule
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:26
     */
    @Override
    public int deleteData(Rule rule) {
        return super.delete(rule);
    }

    /**
     * @Title:
     * @Description: 根据ruleId集合批量删除规则引擎
     * @param rule
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:26
     */
    public int deleteDataList(List ruleIds,Rule rule){
        return super.deleteByIds(ruleIds,rule);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除规则引擎
     * @param example
     * @param rule
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:26
     */
    public int deleteExampleData(Example example,Rule rule){
        return super.deleteByExample(example,rule);
    }

    /**
     * @Title:
     * @Description: 查询全部规则引擎
     * @return List<Rule>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:26
     */
    @Override
    public List<Rule> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个规则引擎
     * @param example
     * @return Rule
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:26
     */
    @Override
    public Rule selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询规则引擎
     * @param example
     * @return List<Rule>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:26
     */
    @Override
    public List<Rule> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过ruleId查询规则引擎
     * @param ruleId
     * @return Rule
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:26
     */
    @Override
    public Rule selectByPrimaryKey(Object ruleId) {
        return super.selectByPrimaryKey(ruleId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询规则引擎
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<Rule>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:26
     */
    @Override
    public PageInfoExtend<Rule> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询规则引擎vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:26
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description:   查询ruleVo，并根据时间倒序
     * @param ruleVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/23 12:28:09
     */
    public List<RuleVo> selectRuleVos(RuleVo ruleVo){
        return baseDao.selectRuleVos(ruleVo);
    }

    /**
     * @Title:
     * @Description:   根据条件单个查询ruleVo
     * @param ruleVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/24 11:29:19
     */
    public RuleVo selectRuleVo(RuleVo ruleVo){
        return baseDao.selectRuleVo(ruleVo);
    }

}
