package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.RationalityPurchaseDao;
import cn.com.leadu.fms.data.prebiz.repository.RationalityPurchaseRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.RationalityPurchase;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: RationalityPurchaseRepositoryImpl
 * @Description: 购买合理性Repository 实现层
 * @date 2018-05-29
 */
@Repository
public class RationalityPurchaseRepositoryImpl extends AbstractBaseRepository<RationalityPurchaseDao, RationalityPurchase> implements RationalityPurchaseRepository {

    /**
     * @Title:
     * @Description: 新增购买合理性
     * @param rationalityPurchase
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-29 9:52:53
     */
    @Override
    public int insertData(RationalityPurchase rationalityPurchase) {
        return super.insert(rationalityPurchase);
    }

    /**
     * @Title:
     * @Description: 批量保存购买合理性
     * @param rationalityPurchases
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-29 9:52:53
     */
    @Override
    public int insertDataList(List<RationalityPurchase> rationalityPurchases){
        return super.insertListByJdbcTemplate(rationalityPurchases);
    }

    /**
     * @Title:
     * @Description: 修改购买合理性
     * @param rationalityPurchase
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-29 9:52:53
     */
    @Override
    public int updateByPrimaryKeyData(RationalityPurchase rationalityPurchase) {
        return super.updateByPrimaryKey(rationalityPurchase);
    }

    /**
     * @Title:
     * @Description: 批量修改购买合理性
     * @param rationalityPurchases
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-29 9:52:53
     */
    @Override
    public int updateByPrimaryKeyDataList(List<RationalityPurchase> rationalityPurchases){
        return super.updateListByPrimaryKey(rationalityPurchases);
    }

    /**
     * @Title:
     * @Description: 动态修改购买合理性
     * @param rationalityPurchase
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-29 9:52:53
     */
    @Override
    public int updateByPrimaryKeySelectiveData(RationalityPurchase rationalityPurchase) {
        return super.updateByPrimaryKeySelective(rationalityPurchase);
    }

    /**
     * @Title:
     * @Description: 批量动态修改购买合理性
     * @param rationalityPurchases
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-29 9:52:53
     */
    public int updateByPrimaryKeySelectiveDataList(List<RationalityPurchase> rationalityPurchases) {
        return super.updateListByPrimaryKeySelective(rationalityPurchases);
    }

    /**
     * @Title:
     * @Description: 根据条件修改购买合理性
     * @param rationalityPurchase
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-29 9:52:53
     */
    @Override
    public int updateByExampleData(RationalityPurchase rationalityPurchase, Example example) {
        return super.updateByExample(rationalityPurchase,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改购买合理性
     * @param rationalityPurchase
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-29 9:52:53
     */
    @Override
    public int updateByExampleSelectiveData(RationalityPurchase rationalityPurchase, Example example){
        return super.updateByExampleSelective(rationalityPurchase,example);
    }
    
    /**
     * @Title:
     * @Description: 根据buyCarId删除购买合理性
     * @param rationalityPurchase
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-29 9:52:53
     */
    @Override
    public int deleteData(RationalityPurchase rationalityPurchase) {
        return super.delete(rationalityPurchase);
    }

    /**
     * @Title:
     * @Description: 根据buyCarId集合批量删除购买合理性
     * @param rationalityPurchase
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-29 9:52:53
     */
    public int deleteDataList(List buyCarIds,RationalityPurchase rationalityPurchase){
        return super.deleteByIds(buyCarIds,rationalityPurchase);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除购买合理性
     * @param example
     * @param rationalityPurchase
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-5-29 9:52:53
     */
    public int deleteExampleData(Example example,RationalityPurchase rationalityPurchase){
        return super.deleteByExample(example,rationalityPurchase);
    }

    /**
     * @Title:
     * @Description: 查询全部购买合理性
     * @return List<RationalityPurchase>
     * @throws
     * @author ningyangyang
     * @date 2018-5-29 9:52:53
     */
    @Override
    public List<RationalityPurchase> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个购买合理性
     * @param example
     * @return RationalityPurchase
     * @throws
     * @author ningyangyang
     * @date 2018-5-29 9:52:53
     */
    @Override
    public RationalityPurchase selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询购买合理性
     * @param example
     * @return List<RationalityPurchase>
     * @throws
     * @author ningyangyang
     * @date 2018-5-29 9:52:53
     */
    @Override
    public List<RationalityPurchase> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过buyCarId查询购买合理性
     * @param buyCarId
     * @return RationalityPurchase
     * @throws
     * @author ningyangyang
     * @date 2018-5-29 9:52:53
     */
    @Override
    public RationalityPurchase selectByPrimaryKey(Object buyCarId) {
        return super.selectByPrimaryKey(buyCarId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询购买合理性
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<RationalityPurchase>
     * @throws
     * @author ningyangyang
     * @date 2018-5-29 9:52:53
     */
    @Override
    public PageInfoExtend<RationalityPurchase> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询购买合理性vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author ningyangyang
     * @date 2018-5-29 9:52:53
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
