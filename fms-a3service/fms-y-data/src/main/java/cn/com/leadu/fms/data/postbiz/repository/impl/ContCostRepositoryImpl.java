package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.data.postbiz.dao.ContCostDao;
import cn.com.leadu.fms.data.postbiz.repository.ContCostRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.ContCost;
import cn.com.leadu.fms.common.vo.PageQuery;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author wangxue
 * @ClassName: ContCostRepositoryImpl
 * @Description: 客户费用Repository 实现层
 */
@Repository
public class ContCostRepositoryImpl extends AbstractBaseRepository<ContCostDao, ContCost> implements ContCostRepository {

    /**
     * @Title:
     * @Description: 新增客户费用
     * @param contCost
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-18 16:31:47
     */
    @Override
    public int insertData(ContCost contCost) {
        return super.insert(contCost);
    }

    /**
     * @Title:
     * @Description: 批量保存客户费用
     * @param contCosts
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-18 16:31:47
     */
    @Override
    public int insertDataList(List<ContCost> contCosts){
        return super.insertListByJdbcTemplate(contCosts);
    }

    /**
     * @Title:
     * @Description: 修改客户费用
     * @param contCost
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-18 16:31:47
     */
    @Override
    public int updateByPrimaryKeyData(ContCost contCost) {
        return super.updateByPrimaryKey(contCost);
    }

    /**
     * @Title:
     * @Description: 批量修改客户费用
     * @param contCosts
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-18 16:31:47
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ContCost> contCosts){
        return super.updateListByPrimaryKey(contCosts);
    }

    /**
     * @Title:
     * @Description: 动态修改客户费用
     * @param contCost
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-18 16:31:47
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ContCost contCost) {
        return super.updateByPrimaryKeySelective(contCost);
    }

    /**
     * @Title:
     * @Description: 批量动态修改客户费用
     * @param contCosts
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-18 16:31:47
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<ContCost> contCosts) {
        return super.updateListByPrimaryKeySelective(contCosts);
    }

    /**
     * @Title:
     * @Description: 根据条件修改客户费用
     * @param contCost
     * @param example
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-18 16:31:47
     */
    @Override
    public int updateByExampleData(ContCost contCost, Example example) {
        return super.updateByExample(contCost,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改客户费用
     * @param contCost
     * @param example
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-18 16:31:47
     */
    @Override
    public int updateByExampleSelectiveData(ContCost contCost, Example example){
        return super.updateByExampleSelective(contCost,example);
    }
    
    /**
     * @Title:
     * @Description: 根据contCostId删除客户费用
     * @param contCost
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-18 16:31:47
     */
    @Override
    public int deleteData(ContCost contCost) {
        return super.delete(contCost);
    }

    /**
     * @Title:
     * @Description: 根据contCostId集合批量删除客户费用
     * @param contCost
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-18 16:31:47
     */
    @Override
    public int deleteDataList(List contCostIds,ContCost contCost){
        return super.deleteByIds(contCostIds,contCost);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除客户费用
     * @param example
     * @param contCost
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-18 16:31:47
     */
    @Override
    public int deleteExampleData(Example example,ContCost contCost){
        return super.deleteByExample(example,contCost);
    }

    /**
     * @Title:
     * @Description: 查询全部客户费用
     * @return List<ContCost>
     * @throws
     * @author wangxue
     * @date 2018-9-18 16:31:47
     */
    @Override
    public List<ContCost> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个客户费用
     * @param example
     * @return ContCost
     * @throws
     * @author wangxue
     * @date 2018-9-18 16:31:47
     */
    @Override
    public ContCost selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询客户费用
     * @param example
     * @return List<ContCost>
     * @throws
     * @author wangxue
     * @date 2018-9-18 16:31:47
     */
    @Override
    public List<ContCost> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过contCostId查询客户费用
     * @param contCostId
     * @return ContCost
     * @throws
     * @author wangxue
     * @date 2018-9-18 16:31:47
     */
    @Override
    public ContCost selectByPrimaryKey(Object contCostId) {
        return super.selectByPrimaryKey(contCostId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询客户费用
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ContCost>
     * @throws
     * @author wangxue
     * @date 2018-9-18 16:31:47
     */
    @Override
    public PageInfoExtend<ContCost> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询客户费用vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author wangxue
     * @date 2018-9-18 16:31:47
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改客户费用
     * @param contCost,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-18 16:31:47
     */
    @Override
    public int updateByPrimaryKeyData(ContCost contCost,boolean exclusive) {
        return super.updateByPrimaryKey(contCost,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改客户费用,并进行排他
     * @param contCosts
     * @param exclusive
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-18 16:31:47
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ContCost> contCosts,boolean exclusive){
        return super.updateListByPrimaryKey(contCosts,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改客户费用,并进行排他
     * @param contCost
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ContCost contCost,boolean exclusive) {
        return super.updateByPrimaryKeySelective(contCost,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改客户费用,并进行排他
     * @param contCosts
     * @param exclusive
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-18 16:31:47
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<ContCost> contCosts,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(contCosts,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改客户费用,并进行排他
     * @param contCost
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-18 16:31:47
     */
    @Override
    public int updateByExampleData(ContCost contCost, Example example,boolean exclusive) {
        return super.updateByExample(contCost,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改客户费用,并进行排他
     * @param contCost
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author wangxue
     * @date 2018-9-18 16:31:47
     */
    @Override
    public int updateByExampleSelectiveData(ContCost contCost, Example example,boolean exclusive){
        return super.updateByExampleSelective(contCost,example,exclusive);
    }

    /**
     * @Title:
     * @Description:  根据合同号,获取对应款项的金额合计
     * @param contNo 合同编号
     * @param costItem 款项
     * @throws
     * @author wangxue
     * @date 2018-9-18 16:12:19
     */
    @Override
    public BigDecimal selectSumCostAmountByContNo(String contNo, String costItem) {
        return baseDao.selectSumCostAmountByContNo(contNo, costItem);
    }
}
