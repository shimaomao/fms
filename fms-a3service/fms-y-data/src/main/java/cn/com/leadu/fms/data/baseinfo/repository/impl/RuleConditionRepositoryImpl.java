package cn.com.leadu.fms.data.baseinfo.repository.impl;

import cn.com.leadu.fms.data.baseinfo.dao.RuleConditionDao;
import cn.com.leadu.fms.data.baseinfo.repository.RuleConditionRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.baseinfo.entity.RuleCondition;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.baseinfo.vo.rulecondition.RuleConditionVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: RuleConditionRepositoryImpl
 * @Description: 规则引擎条件Repository 实现层
 * @date 2018-05-17
 */
@Repository
public class RuleConditionRepositoryImpl extends AbstractBaseRepository<RuleConditionDao, RuleCondition> implements RuleConditionRepository {

    /**
     * @Title:
     * @Description: 新增规则引擎条件
     * @param ruleCondition
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    @Override
    public int insertData(RuleCondition ruleCondition) {
        return super.insert(ruleCondition);
    }

    /**
     * @Title:
     * @Description: 批量保存规则引擎条件
     * @param ruleConditions
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    @Override
    public int insertDataList(List<RuleCondition> ruleConditions){
        return super.insertListByJdbcTemplate(ruleConditions);
    }

    /**
     * @Title:
     * @Description: 修改规则引擎条件
     * @param ruleCondition
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    @Override
    public int updateByPrimaryKeyData(RuleCondition ruleCondition) {
        return super.updateByPrimaryKey(ruleCondition);
    }

    /**
     * @Title:
     * @Description: 批量修改规则引擎条件
     * @param ruleConditions
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    @Override
    public int updateByPrimaryKeyDataList(List<RuleCondition> ruleConditions){
        return super.updateListByPrimaryKey(ruleConditions);
    }

    /**
     * @Title:
     * @Description: 动态修改规则引擎条件
     * @param ruleCondition
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    @Override
    public int updateByPrimaryKeySelectiveData(RuleCondition ruleCondition) {
        return super.updateByPrimaryKeySelective(ruleCondition);
    }

    /**
     * @Title:
     * @Description: 批量动态修改规则引擎条件
     * @param ruleConditions
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    public int updateByPrimaryKeySelectiveDataList(List<RuleCondition> ruleConditions) {
        return super.updateListByPrimaryKeySelective(ruleConditions);
    }

    /**
     * @Title:
     * @Description: 根据条件修改规则引擎条件
     * @param ruleCondition
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    @Override
    public int updateByExampleData(RuleCondition ruleCondition, Example example) {
        return super.updateByExample(ruleCondition,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改规则引擎条件
     * @param ruleCondition
     * @param example
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    @Override
    public int updateByExampleSelectiveData(RuleCondition ruleCondition, Example example){
        return super.updateByExampleSelective(ruleCondition,example);
    }
    
    /**
     * @Title:
     * @Description: 根据ruleCondId删除规则引擎条件
     * @param ruleCondition
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    @Override
    public int deleteData(RuleCondition ruleCondition) {
        return super.delete(ruleCondition);
    }

    /**
     * @Title:
     * @Description: 根据ruleCondId集合批量删除规则引擎条件
     * @param ruleCondition
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    public int deleteDataList(List ruleCondIds,RuleCondition ruleCondition){
        return super.deleteByIds(ruleCondIds,ruleCondition);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除规则引擎条件
     * @param example
     * @param ruleCondition
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    public int deleteExampleData(Example example,RuleCondition ruleCondition){
        return super.deleteByExample(example,ruleCondition);
    }

    /**
     * @Title:
     * @Description: 查询全部规则引擎条件
     * @return List<RuleCondition>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    @Override
    public List<RuleCondition> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个规则引擎条件
     * @param example
     * @return RuleCondition
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    @Override
    public RuleCondition selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询规则引擎条件
     * @param example
     * @return List<RuleCondition>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    @Override
    public List<RuleCondition> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过ruleCondId查询规则引擎条件
     * @param ruleCondId
     * @return RuleCondition
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    @Override
    public RuleCondition selectByPrimaryKey(Object ruleCondId) {
        return super.selectByPrimaryKey(ruleCondId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询规则引擎条件
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<RuleCondition>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    @Override
    public PageInfoExtend<RuleCondition> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询规则引擎条件vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description:   根据规则id查询规则条件列表
     * @param ruleConditionVo
     * @return List<RuleConditionVo>
     * @throws
     * @author qiaomengnan
     * @date 2018/05/21 12:41:42
     */
    public List<RuleConditionVo> selectRuleConditionVosByRuleId(RuleConditionVo ruleConditionVo){
        return baseDao.selectRuleConditionVosByRuleId(ruleConditionVo);
    }

    /**
     * @Title:
     * @Description:   查询规则条件列表
     * @param ruleConditionVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/21 12:41:42
     */
    public List<RuleConditionVo> selectRuleConditionVos(RuleConditionVo ruleConditionVo){
        return baseDao.selectRuleConditionVos(ruleConditionVo);
    }



}
