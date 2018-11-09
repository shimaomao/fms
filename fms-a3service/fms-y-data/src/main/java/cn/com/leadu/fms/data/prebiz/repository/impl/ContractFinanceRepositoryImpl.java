package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.ContractFinanceDao;
import cn.com.leadu.fms.data.prebiz.repository.ContractFinanceRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.ContractFinance;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.vo.contReceiptPay.ContReceiptPayVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractfinance.ContractFinanceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contrequestpay.ContRequestPayVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContractFinanceRepositoryImpl
 * @Description: 合同融资信息Repository 实现层
 * @date 2018-03-23
 */
@Repository
public class ContractFinanceRepositoryImpl extends AbstractBaseRepository<ContractFinanceDao, ContractFinance> implements ContractFinanceRepository {

    /**
     * @Title:
     * @Description: 新增合同融资信息
     * @param contractFinance
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:10
     */
    @Override
    public int insertData(ContractFinance contractFinance) {
        return super.insert(contractFinance);
    }

    /**
     * @Title:
     * @Description: 批量保存合同融资信息
     * @param contractFinances
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:10
     */
    @Override
    public int insertDataList(List<ContractFinance> contractFinances){
        return super.insertListByJdbcTemplate(contractFinances);
    }

    /**
     * @Title:
     * @Description: 修改合同融资信息
     * @param contractFinance
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:10
     */
    @Override
    public int updateByPrimaryKeyData(ContractFinance contractFinance) {
        return super.updateByPrimaryKey(contractFinance);
    }

    /**
     * @Title:
     * @Description: 批量修改合同融资信息
     * @param contractFinances
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:10
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ContractFinance> contractFinances){
        return super.insertListByJdbcTemplate(contractFinances);
    }

    /**
     * @Title:
     * @Description: 动态修改合同融资信息
     * @param contractFinance
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:10
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ContractFinance contractFinance) {
        return super.updateByPrimaryKeySelective(contractFinance);
    }

    /**
     * @Title:
     * @Description: 批量动态修改合同融资信息
     * @param contractFinances
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:10
     */
    public int updateByPrimaryKeySelectiveDataList(List<ContractFinance> contractFinances) {
        return super.updateListByPrimaryKeySelective(contractFinances);
    }

    /**
     * @Title:
     * @Description: 根据条件修改合同融资信息
     * @param contractFinance
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:10
     */
    @Override
    public int updateByExampleData(ContractFinance contractFinance, Example example) {
        return super.updateByExample(contractFinance,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改合同融资信息
     * @param contractFinance
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:10
     */
    @Override
    public int updateByExampleSelectiveData(ContractFinance contractFinance, Example example){
        return super.updateByExampleSelective(contractFinance,example);
    }
    
    /**
     * @Title:
     * @Description: 根据contFinId删除合同融资信息
     * @param contractFinance
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:10
     */
    @Override
    public int deleteData(ContractFinance contractFinance) {
        return super.delete(contractFinance);
    }

    /**
     * @Title:
     * @Description: 根据contFinId集合批量删除合同融资信息
     * @param contractFinance
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:10
     */
    public int deleteDataList(List contFinIds,ContractFinance contractFinance){
        return super.deleteByIds(contFinIds,contractFinance);
    }

    /**
     * @Title:
     * @Description: 查询全部合同融资信息
     * @return List<ContractFinance>
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:10
     */
    @Override
    public List<ContractFinance> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个合同融资信息
     * @param example
     * @return ContractFinance
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:10
     */
    @Override
    public ContractFinance selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }


    /**
     * @Title:
     * @Description: 通过条件批量查询合同融资信息
     * @param example
     * @return List<ContractFinance>
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:10
     */
    @Override
    public List<ContractFinance> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过contFinId查询合同融资信息
     * @param contFinId
     * @return ContractFinance
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:10
     */
    @Override
    public ContractFinance selectByPrimaryKey(Object contFinId) {
        return super.selectByPrimaryKey(contFinId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询合同融资信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ContractFinance>
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:10
     */
    @Override
    public PageInfoExtend<ContractFinance> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询合同融资信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<ContractFinance>
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:10
     */
    public PageInfoExtend<ContractFinance> selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询合同融资信息vo
     * @param contNo
     * @return PageInfoExtend<ContractFinance>
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:46:10
     */
    public ContractFinanceVo selectContractFinanceVoByContNo(String contNo){
        return baseDao.selectContractFinanceVoByContNo(contNo);
    }

    /**
     * @param contNo
     * @Description: 通过合同编号查询合同请款时合同融资相关信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/9 15:01
     */
    @Override
    public ContRequestPayVo selectContractRequestFinanceByContNo(String contNo) {
        return baseDao.selectContractRequestFinanceByContNo(contNo);
    }

    /**
     * @param contNo
     * @Description: 通过合同编号查询合同确认收款时合同融资相关信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/13 11:34
     */
    @Override
    public ContReceiptPayVo selectContReceiptPayFinanceByContNo(String contNo) {
        return baseDao.selectContReceiptPayFinanceByContNo(contNo);
    }

}
