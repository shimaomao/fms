package cn.com.leadu.fms.data.baseinfo.repository.impl;

import cn.com.leadu.fms.data.baseinfo.dao.RuleItemDao;
import cn.com.leadu.fms.data.baseinfo.repository.RuleItemRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.baseinfo.entity.RuleItem;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: RuleItemRepositoryImpl
 * @Description: 规则引擎项目管理Repository 实现层
 * @date 2018-05-17
 */
@Repository
public class RuleItemRepositoryImpl extends AbstractBaseRepository<RuleItemDao, RuleItem> implements RuleItemRepository {

    /**
     * @Title:
     * @Description: 新增规则引擎项目管理
     * @param ruleItem
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    @Override
    public int insertData(RuleItem ruleItem) {
        return super.insert(ruleItem);
    }

    /**
     * @Title:
     * @Description: 批量保存规则引擎项目管理
     * @param ruleItems
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    @Override
    public int insertDataList(List<RuleItem> ruleItems){
        return super.insertListByJdbcTemplate(ruleItems);
    }

    /**
     * @Title:
     * @Description: 修改规则引擎项目管理
     * @param ruleItem
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    @Override
    public int updateByPrimaryKeyData(RuleItem ruleItem) {
        return super.updateByPrimaryKey(ruleItem);
    }

    /**
     * @Title:
     * @Description: 批量修改规则引擎项目管理
     * @param ruleItems
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    @Override
    public int updateByPrimaryKeyDataList(List<RuleItem> ruleItems){
        return super.updateListByPrimaryKey(ruleItems);
    }

    /**
     * @Title:
     * @Description: 动态修改规则引擎项目管理
     * @param ruleItem
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    @Override
    public int updateByPrimaryKeySelectiveData(RuleItem ruleItem) {
        return super.updateByPrimaryKeySelective(ruleItem);
    }

    /**
     * @Title:
     * @Description: 批量动态修改规则引擎项目管理
     * @param ruleItems
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    public int updateByPrimaryKeySelectiveDataList(List<RuleItem> ruleItems) {
        return super.updateListByPrimaryKeySelective(ruleItems);
    }

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
    @Override
    public int updateByExampleData(RuleItem ruleItem, Example example) {
        return super.updateByExample(ruleItem,example);
    }
    
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
    @Override
    public int updateByExampleSelectiveData(RuleItem ruleItem, Example example){
        return super.updateByExampleSelective(ruleItem,example);
    }
    
    /**
     * @Title:
     * @Description: 根据ruleItemId删除规则引擎项目管理
     * @param ruleItem
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    @Override
    public int deleteData(RuleItem ruleItem) {
        return super.delete(ruleItem);
    }

    /**
     * @Title:
     * @Description: 根据ruleItemId集合批量删除规则引擎项目管理
     * @param ruleItem
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    public int deleteDataList(List ruleItemIds,RuleItem ruleItem){
        return super.deleteByIds(ruleItemIds,ruleItem);
    }

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
    public int deleteExampleData(Example example,RuleItem ruleItem){
        return super.deleteByExample(example,ruleItem);
    }

    /**
     * @Title:
     * @Description: 查询全部规则引擎项目管理
     * @return List<RuleItem>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    @Override
    public List<RuleItem> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个规则引擎项目管理
     * @param example
     * @return RuleItem
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    @Override
    public RuleItem selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询规则引擎项目管理
     * @param example
     * @return List<RuleItem>
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    @Override
    public List<RuleItem> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过ruleItemId查询规则引擎项目管理
     * @param ruleItemId
     * @return RuleItem
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    @Override
    public RuleItem selectByPrimaryKey(Object ruleItemId) {
        return super.selectByPrimaryKey(ruleItemId);
    }
    
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
    @Override
    public PageInfoExtend<RuleItem> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

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
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
