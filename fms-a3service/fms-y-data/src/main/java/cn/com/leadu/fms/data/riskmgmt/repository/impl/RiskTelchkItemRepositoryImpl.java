package cn.com.leadu.fms.data.riskmgmt.repository.impl;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.riskmgmt.dao.RiskTelchkItemDao;
import cn.com.leadu.fms.data.riskmgmt.repository.RiskTelchkItemRepository;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskTelchkItem;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskTelchkItemRepositoryImpl
 * @Description: 风控电核项目表Repository 实现层
 * @date 2018-06-04
 */
@Repository
public class RiskTelchkItemRepositoryImpl extends AbstractBaseRepository<RiskTelchkItemDao, RiskTelchkItem> implements RiskTelchkItemRepository {

    /**
     * @Title:
     * @Description: 新增风控电核项目表
     * @param riskTelchkItem
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:07
     */
    @Override
    public int insertData(RiskTelchkItem riskTelchkItem) {
        return super.insert(riskTelchkItem);
    }

    /**
     * @Title:
     * @Description: 批量保存风控电核项目表
     * @param riskTelchkItems
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:07
     */
    @Override
    public int insertDataList(List<RiskTelchkItem> riskTelchkItems){
        return super.insertListByJdbcTemplate(riskTelchkItems);
    }

    /**
     * @Title:
     * @Description: 修改风控电核项目表
     * @param riskTelchkItem
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:07
     */
    @Override
    public int updateByPrimaryKeyData(RiskTelchkItem riskTelchkItem) {
        return super.updateByPrimaryKey(riskTelchkItem);
    }

    /**
     * @Title:
     * @Description: 批量修改风控电核项目表
     * @param riskTelchkItems
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:07
     */
    @Override
    public int updateByPrimaryKeyDataList(List<RiskTelchkItem> riskTelchkItems){
        return super.updateListByPrimaryKey(riskTelchkItems);
    }

    /**
     * @Title:
     * @Description: 动态修改风控电核项目表
     * @param riskTelchkItem
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:07
     */
    @Override
    public int updateByPrimaryKeySelectiveData(RiskTelchkItem riskTelchkItem) {
        return super.updateByPrimaryKeySelective(riskTelchkItem);
    }

    /**
     * @Title:
     * @Description: 批量动态修改风控电核项目表
     * @param riskTelchkItems
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:07
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<RiskTelchkItem> riskTelchkItems) {
        return super.updateListByPrimaryKeySelective(riskTelchkItems);
    }

    /**
     * @Title:
     * @Description: 根据条件修改风控电核项目表
     * @param riskTelchkItem
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:07
     */
    @Override
    public int updateByExampleData(RiskTelchkItem riskTelchkItem, Example example) {
        return super.updateByExample(riskTelchkItem,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改风控电核项目表
     * @param riskTelchkItem
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:07
     */
    @Override
    public int updateByExampleSelectiveData(RiskTelchkItem riskTelchkItem, Example example){
        return super.updateByExampleSelective(riskTelchkItem,example);
    }
    
    /**
     * @Title:
     * @Description: 根据telchkItemId删除风控电核项目表
     * @param riskTelchkItem
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:07
     */
    @Override
    public int deleteData(RiskTelchkItem riskTelchkItem) {
        return super.delete(riskTelchkItem);
    }

    /**
     * @Title:
     * @Description: 根据telchkItemId集合批量删除风控电核项目表
     * @param riskTelchkItem
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:07
     */
    @Override
    public int deleteDataList(List telchkItemIds,RiskTelchkItem riskTelchkItem){
        return super.deleteByIds(telchkItemIds,riskTelchkItem);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除风控电核项目表
     * @param example
     * @param riskTelchkItem
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:07
     */
    @Override
    public int deleteExampleData(Example example,RiskTelchkItem riskTelchkItem){
        return super.deleteByExample(example,riskTelchkItem);
    }

    /**
     * @Title:
     * @Description: 查询全部风控电核项目表
     * @return List<RiskTelchkItem>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:07
     */
    @Override
    public List<RiskTelchkItem> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个风控电核项目表
     * @param example
     * @return RiskTelchkItem
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:07
     */
    @Override
    public RiskTelchkItem selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询风控电核项目表
     * @param example
     * @return List<RiskTelchkItem>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:07
     */
    @Override
    public List<RiskTelchkItem> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过telchkItemId查询风控电核项目表
     * @param telchkItemId
     * @return RiskTelchkItem
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:07
     */
    @Override
    public RiskTelchkItem selectByPrimaryKey(Object telchkItemId) {
        return super.selectByPrimaryKey(telchkItemId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询风控电核项目表
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<RiskTelchkItem>
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:07
     */
    @Override
    public PageInfoExtend<RiskTelchkItem> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询风控电核项目表vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:07
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改风控电核项目表
     * @param riskTelchkItem,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:07
     */
    @Override
    public int updateByPrimaryKeyData(RiskTelchkItem riskTelchkItem,boolean exclusive) {
        return super.updateByPrimaryKey(riskTelchkItem,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改风控电核项目表,并进行排他
     * @param riskTelchkItems
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:07
     */
    @Override
    public int updateByPrimaryKeyDataList(List<RiskTelchkItem> riskTelchkItems,boolean exclusive){
        return super.updateListByPrimaryKey(riskTelchkItems,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改风控电核项目表,并进行排他
     * @param riskTelchkItem
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(RiskTelchkItem riskTelchkItem,boolean exclusive) {
        return super.updateByPrimaryKeySelective(riskTelchkItem,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改风控电核项目表,并进行排他
     * @param riskTelchkItems
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:07
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<RiskTelchkItem> riskTelchkItems,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(riskTelchkItems,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改风控电核项目表,并进行排他
     * @param riskTelchkItem
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:07
     */
    @Override
    public int updateByExampleData(RiskTelchkItem riskTelchkItem, Example example,boolean exclusive) {
        return super.updateByExample(riskTelchkItem,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改风控电核项目表,并进行排他
     * @param riskTelchkItem
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:03:07
     */
    @Override
    public int updateByExampleSelectiveData(RiskTelchkItem riskTelchkItem, Example example,boolean exclusive){
        return super.updateByExampleSelective(riskTelchkItem,example,exclusive);
    }

}
