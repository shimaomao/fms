package cn.com.leadu.fms.data.finance.repository.impl;

import cn.com.leadu.fms.data.finance.dao.ContChargeDao;
import cn.com.leadu.fms.data.finance.repository.ContChargeRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.finance.entity.ContCharge;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.finance.vo.contcharge.ContChargeReceiptVo;
import cn.com.leadu.fms.pojo.finance.vo.contcharge.ContChargeVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: ContChargeRepositoryImpl
 * @Description: 财务待收款Repository 实现层
 * @date 2018-06-01
 */
@Repository
public class ContChargeRepositoryImpl extends AbstractBaseRepository<ContChargeDao, ContCharge> implements ContChargeRepository {

    /**
     * @Title:
     * @Description: 新增财务待收款
     * @param contCharge
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-1 9:55:46
     */
    @Override
    public int insertData(ContCharge contCharge) {
        return super.insert(contCharge);
    }

    /**
     * @Title:
     * @Description: 批量保存财务待收款
     * @param contCharges
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-1 9:55:46
     */
    @Override
    public int insertDataList(List<ContCharge> contCharges){
        return super.insertListByJdbcTemplate(contCharges);
    }

    /**
     * @Title:
     * @Description: 修改财务待收款
     * @param contCharge
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-1 9:55:46
     */
    @Override
    public int updateByPrimaryKeyData(ContCharge contCharge) {
        return super.updateByPrimaryKey(contCharge);
    }

    /**
     * @Title:
     * @Description: 批量修改财务待收款
     * @param contCharges
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-1 9:55:46
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ContCharge> contCharges){
        return super.updateListByPrimaryKey(contCharges);
    }

    /**
     * @Title:
     * @Description: 动态修改财务待收款
     * @param contCharge
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-1 9:55:46
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ContCharge contCharge) {
        return super.updateByPrimaryKeySelective(contCharge);
    }

    /**
     * @Title:
     * @Description: 批量动态修改财务待收款
     * @param contCharges
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-1 9:55:46
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<ContCharge> contCharges) {
        return super.updateListByPrimaryKeySelective(contCharges);
    }

    /**
     * @Title:
     * @Description: 根据条件修改财务待收款
     * @param contCharge
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-1 9:55:46
     */
    @Override
    public int updateByExampleData(ContCharge contCharge, Example example) {
        return super.updateByExample(contCharge,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改财务待收款
     * @param contCharge
     * @param example
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-1 9:55:46
     */
    @Override
    public int updateByExampleSelectiveData(ContCharge contCharge, Example example){
        return super.updateByExampleSelective(contCharge,example);
    }
    
    /**
     * @Title:
     * @Description: 根据contChargeId删除财务待收款
     * @param contCharge
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-1 9:55:46
     */
    @Override
    public int deleteData(ContCharge contCharge) {
        return super.delete(contCharge);
    }

    /**
     * @Title:
     * @Description: 根据contChargeId集合批量删除财务待收款
     * @param contCharge
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-1 9:55:46
     */
    @Override
    public int deleteDataList(List contChargeIds,ContCharge contCharge){
        return super.deleteByIds(contChargeIds,contCharge);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除财务待收款
     * @param example
     * @param contCharge
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-1 9:55:46
     */
    @Override
    public int deleteExampleData(Example example,ContCharge contCharge){
        return super.deleteByExample(example,contCharge);
    }

    /**
     * @Title:
     * @Description: 查询全部财务待收款
     * @return List<ContCharge>
     * @throws
     * @author ningyangyang
     * @date 2018-6-1 9:55:46
     */
    @Override
    public List<ContCharge> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个财务待收款
     * @param example
     * @return ContCharge
     * @throws
     * @author ningyangyang
     * @date 2018-6-1 9:55:46
     */
    @Override
    public ContCharge selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询财务待收款
     * @param example
     * @return List<ContCharge>
     * @throws
     * @author ningyangyang
     * @date 2018-6-1 9:55:46
     */
    @Override
    public List<ContCharge> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过contChargeId查询财务待收款
     * @param contChargeId
     * @return ContCharge
     * @throws
     * @author ningyangyang
     * @date 2018-6-1 9:55:46
     */
    @Override
    public ContCharge selectByPrimaryKey(Object contChargeId) {
        return super.selectByPrimaryKey(contChargeId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询财务待收款
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ContCharge>
     * @throws
     * @author ningyangyang
     * @date 2018-6-1 9:55:46
     */
    @Override
    public PageInfoExtend<ContCharge> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询财务待收款vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author ningyangyang
     * @date 2018-6-1 9:55:46
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改财务待收款
     * @param contCharge,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-1 9:55:46
     */
    @Override
    public int updateByPrimaryKeyData(ContCharge contCharge,boolean exclusive) {
        return super.updateByPrimaryKey(contCharge,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改财务待收款,并进行排他
     * @param contCharges
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-1 9:55:46
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ContCharge> contCharges,boolean exclusive){
        return super.updateListByPrimaryKey(contCharges,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改财务待收款,并进行排他
     * @param contCharge
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ContCharge contCharge,boolean exclusive) {
        return super.updateByPrimaryKeySelective(contCharge,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改财务待收款,并进行排他
     * @param contCharges
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-1 9:55:46
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<ContCharge> contCharges,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(contCharges,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改财务待收款,并进行排他
     * @param contCharge
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-1 9:55:46
     */
    @Override
    public int updateByExampleData(ContCharge contCharge, Example example,boolean exclusive) {
        return super.updateByExample(contCharge,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改财务待收款,并进行排他
     * @param contCharge
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author ningyangyang
     * @date 2018-6-1 9:55:46
     */
    @Override
    public int updateByExampleSelectiveData(ContCharge contCharge, Example example,boolean exclusive){
        return super.updateByExampleSelective(contCharge,example,exclusive);
    }

    /**
     * @param chargeBizId
     * @param chargeBizType
     * @Description: 根据业务类型和业务号查询待收款数据和收款数据
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/7/28 11:03
     */
    @Override
    public List<ContChargeReceiptVo> selectContChargeAndReceiptByBizIdAndBizType(String chargeBizId, String chargeBizType,String chargeFund) {
        return baseDao.selectContChargeAndReceiptByBizIdAndBizType(chargeBizId,chargeBizType,chargeFund);
    }

}
