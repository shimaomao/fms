package cn.com.leadu.fms.data.baseinfo.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.baseinfo.dao.RuleConsequenceDao;
import cn.com.leadu.fms.data.baseinfo.repository.RuleConsequenceRepository;
import cn.com.leadu.fms.pojo.baseinfo.entity.RuleConsequence;
import cn.com.leadu.fms.pojo.baseinfo.vo.ruleconsequence.RuleConsequenceVo;
import org.apache.ibatis.annotations.Param;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: RuleConsequenceRepositoryImpl
 * @Description: 规则引擎结果Repository 实现层
 * @date 2018-05-17
 */
@Repository
public class RuleConsequenceRepositoryImpl extends AbstractBaseRepository<RuleConsequenceDao, RuleConsequence> implements RuleConsequenceRepository {

    /**
     * @Title:
     * @Description: 新增规则引擎结果
     * @param ruleConsequence
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:10
     */
    @Override
    public int insertData(RuleConsequence ruleConsequence) {
        return super.insert(ruleConsequence);
    }

    /**
     * @Title:
     * @Description: 批量保存规则引擎结果
     * @param ruleConsequences
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:10
     */
    @Override
    public int insertDataList(List<RuleConsequence> ruleConsequences){
        return super.insertListByJdbcTemplate(ruleConsequences);
    }

    /**
     * @Title:
     * @Description: 修改规则引擎结果
     * @param ruleConsequence
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:10
     */
    @Override
    public int updateByPrimaryKeyData(RuleConsequence ruleConsequence) {
        return super.updateByPrimaryKey(ruleConsequence);
    }

    /**
     * @Title:
     * @Description: 批量修改规则引擎结果
     * @param ruleConsequences
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:10
     */
    @Override
    public int updateByPrimaryKeyDataList(List<RuleConsequence> ruleConsequences){
        return super.updateListByPrimaryKey(ruleConsequences);
    }

    /**
     * @Title:
     * @Description: 动态修改规则引擎结果
     * @param ruleConsequence
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:10
     */
    @Override
    public int updateByPrimaryKeySelectiveData(RuleConsequence ruleConsequence) {
        return super.updateByPrimaryKeySelective(ruleConsequence);
    }

    /**
     * @Title:
     * @Description: 批量动态修改规则引擎结果
     * @param ruleConsequences
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:10
     */
    public int updateByPrimaryKeySelectiveDataList(List<RuleConsequence> ruleConsequences) {
        return super.updateListByPrimaryKeySelective(ruleConsequences);
    }

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
    @Override
    public int updateByExampleData(RuleConsequence ruleConsequence, Example example) {
        return super.updateByExample(ruleConsequence,example);
    }
    
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
    @Override
    public int updateByExampleSelectiveData(RuleConsequence ruleConsequence, Example example){
        return super.updateByExampleSelective(ruleConsequence,example);
    }
    
    /**
     * @Title:
     * @Description: 根据ruleConseqId删除规则引擎结果
     * @param ruleConsequence
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:10
     */
    @Override
    public int deleteData(RuleConsequence ruleConsequence) {
        return super.delete(ruleConsequence);
    }

    /**
     * @Title:
     * @Description: 根据ruleConseqId集合批量删除规则引擎结果
     * @param ruleConsequence
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:10
     */
    public int deleteDataList(List ruleConseqIds,RuleConsequence ruleConsequence){
        return super.deleteByIds(ruleConseqIds,ruleConsequence);
    }

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
    public int deleteExampleData(Example example,RuleConsequence ruleConsequence){
        return super.deleteByExample(example,ruleConsequence);
    }

    /**
     * @Title:
     * @Description: 查询全部规则引擎结果
     * @return List<RuleConsequence>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:10
     */
    @Override
    public List<RuleConsequence> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个规则引擎结果
     * @param example
     * @return RuleConsequence
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:10
     */
    @Override
    public RuleConsequence selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询规则引擎结果
     * @param example
     * @return List<RuleConsequence>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:10
     */
    @Override
    public List<RuleConsequence> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过ruleConseqId查询规则引擎结果
     * @param ruleConseqId
     * @return RuleConsequence
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:10
     */
    @Override
    public RuleConsequence selectByPrimaryKey(Object ruleConseqId) {
        return super.selectByPrimaryKey(ruleConseqId);
    }
    
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
    @Override
    public PageInfoExtend<RuleConsequence> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

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
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description:   根据规则id查询规则结果列表
     * @param ruleConsequenceVo
     * @return List<RuleConsequenceVo>
     * @throws
     * @author qiaomengnan
     * @date 2018/05/21 12:49:37
     */
    public List<RuleConsequenceVo> selectRuleConsequenceVosByRuleId(RuleConsequenceVo ruleConsequenceVo){
        return baseDao.selectRuleConsequenceVosByRuleId(ruleConsequenceVo);
    }


    /**
     * @Title:
     * @Description:   查询规则结果列表
     * @param ruleConsequenceVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/21 12:41:42
     */
    public List<RuleConsequenceVo> selectRuleConsequenceVos(RuleConsequenceVo ruleConsequenceVo){
        return baseDao.selectRuleConsequenceVos(ruleConsequenceVo);
    }

}
