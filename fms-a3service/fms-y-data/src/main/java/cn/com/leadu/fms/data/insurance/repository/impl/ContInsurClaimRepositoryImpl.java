package cn.com.leadu.fms.data.insurance.repository.impl;

import cn.com.leadu.fms.data.insurance.dao.ContInsurClaimDao;
import cn.com.leadu.fms.data.insurance.repository.ContInsurClaimRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.insurance.entity.ContInsurClaim;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.insurance.vo.continsurclaim.ContInsurClaimVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author yanfengbo
 * @ClassName: ContInsurClaimRepositoryImpl
 * @Description: 保险理赔Repository 实现层
 * @date 2018-05-14
 */
@Repository
public class ContInsurClaimRepositoryImpl extends AbstractBaseRepository<ContInsurClaimDao, ContInsurClaim> implements ContInsurClaimRepository {

    /**
     * @Title:
     * @Description: 新增保险理赔
     * @param contInsurClaim
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    @Override
    public int insertData(ContInsurClaim contInsurClaim) {
        return super.insert(contInsurClaim);
    }

    /**
     * @Title:
     * @Description: 批量保存保险理赔
     * @param contInsurClaims
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    @Override
    public int insertDataList(List<ContInsurClaim> contInsurClaims){
        return super.insertListByJdbcTemplate(contInsurClaims);
    }

    /**
     * @Title:
     * @Description: 修改保险理赔
     * @param contInsurClaim
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    @Override
    public int updateByPrimaryKeyData(ContInsurClaim contInsurClaim) {
        return super.updateByPrimaryKey(contInsurClaim);
    }

    /**
     * @Title:
     * @Description: 批量修改保险理赔
     * @param contInsurClaims
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ContInsurClaim> contInsurClaims){
        return super.updateListByPrimaryKey(contInsurClaims);
    }

    /**
     * @Title:
     * @Description: 动态修改保险理赔
     * @param contInsurClaim
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ContInsurClaim contInsurClaim) {
        return super.updateByPrimaryKeySelective(contInsurClaim);
    }

    /**
     * @Title:
     * @Description: 批量动态修改保险理赔
     * @param contInsurClaims
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    public int updateByPrimaryKeySelectiveDataList(List<ContInsurClaim> contInsurClaims) {
        return super.updateListByPrimaryKeySelective(contInsurClaims);
    }

    /**
     * @Title:
     * @Description: 根据条件修改保险理赔
     * @param contInsurClaim
     * @param example
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    @Override
    public int updateByExampleData(ContInsurClaim contInsurClaim, Example example) {
        return super.updateByExample(contInsurClaim,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改保险理赔
     * @param contInsurClaim
     * @param example
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    @Override
    public int updateByExampleSelectiveData(ContInsurClaim contInsurClaim, Example example){
        return super.updateByExampleSelective(contInsurClaim,example);
    }
    
    /**
     * @Title:
     * @Description: 根据contInsurClaimId删除保险理赔
     * @param contInsurClaim
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    @Override
    public int deleteData(ContInsurClaim contInsurClaim) {
        return super.delete(contInsurClaim);
    }

    /**
     * @Title:
     * @Description: 根据contInsurClaimId集合批量删除保险理赔
     * @param contInsurClaim
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    public int deleteDataList(List contInsurClaimIds,ContInsurClaim contInsurClaim){
        return super.deleteByIds(contInsurClaimIds,contInsurClaim);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除保险理赔
     * @param example
     * @param contInsurClaim
     * @return int
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    public int deleteExampleData(Example example,ContInsurClaim contInsurClaim){
        return super.deleteByExample(example,contInsurClaim);
    }

    /**
     * @Title:
     * @Description: 查询全部保险理赔
     * @return List<ContInsurClaim>
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    @Override
    public List<ContInsurClaim> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个保险理赔
     * @param example
     * @return ContInsurClaim
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    @Override
    public ContInsurClaim selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询保险理赔
     * @param example
     * @return List<ContInsurClaim>
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    @Override
    public List<ContInsurClaim> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过contInsurClaimId查询保险理赔
     * @param contInsurClaimId
     * @return ContInsurClaim
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    @Override
    public ContInsurClaim selectByPrimaryKey(Object contInsurClaimId) {
        return super.selectByPrimaryKey(contInsurClaimId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询保险理赔
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ContInsurClaim>
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    @Override
    public PageInfoExtend<ContInsurClaim> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询保险理赔vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:21
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 根据保险信息id查询合同车辆保险信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public ContInsurClaimVo selectContInsuranceByContVehinsId(String contVehinsId){
        return baseDao.selectContInsuranceByContVehinsId(contVehinsId);
    }

    /**
     * @Title:
     * @Description: 根据contInsurClaimId和contVehinsId查询保险理赔表和合同车辆信息表
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public ContInsurClaimVo selectContInsurClaimAndContInsurance(String contInsurClaimId,String contVehinsId){
        return baseDao.selectContInsurClaimAndContInsurance(contInsurClaimId,contVehinsId);
    }

    /**
     * @Title:
     * @Description: 保险理赔状态为退回时查询一条明细
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public ContInsurClaimVo selectDetailedByReturn(String contInsurClaimId){
        return baseDao.selectDetailedByReturn(contInsurClaimId);
    }

    /**
     * @Title:
     * @Description: 根据保险理赔任务号和业务类型查询财务付款表
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    public ContPay selectContPayByContInsurClaimNo(String bizCode,String paymentType){
        return baseDao.selectContPayByContInsurClaimNo(bizCode,paymentType);

    }

}
