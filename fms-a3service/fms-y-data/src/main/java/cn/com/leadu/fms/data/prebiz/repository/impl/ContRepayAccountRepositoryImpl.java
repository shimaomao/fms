package cn.com.leadu.fms.data.prebiz.repository.impl;

import cn.com.leadu.fms.data.prebiz.dao.ContRepayAccountDao;
import cn.com.leadu.fms.data.prebiz.repository.ContRepayAccountRepository;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepayAccount;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.vo.contrepayaccount.ContRepayAccountListVo;
import org.springframework.stereotype.Repository;
import tk.mybatis.mapper.entity.Example;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContRepayAccountRepositoryImpl
 * @Description: 融资合同还款信息Repository 实现层
 * @date 2018-03-23
 */
@Repository
public class ContRepayAccountRepositoryImpl extends AbstractBaseRepository<ContRepayAccountDao, ContRepayAccount> implements ContRepayAccountRepository {

    /**
     * @Title:
     * @Description: 新增融资合同还款信息
     * @param contRepayAccount
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:15
     */
    @Override
    public int insertData(ContRepayAccount contRepayAccount) {
        return super.insert(contRepayAccount);
    }

    /**
     * @Title:
     * @Description: 批量保存融资合同还款信息
     * @param contRepayAccounts
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:15
     */
    @Override
    public int insertDataList(List<ContRepayAccount> contRepayAccounts){
        return super.insertListByJdbcTemplate(contRepayAccounts);
    }

    /**
     * @Title:
     * @Description: 修改融资合同还款信息
     * @param contRepayAccount
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:15
     */
    @Override
    public int updateByPrimaryKeyData(ContRepayAccount contRepayAccount) {
        return super.updateByPrimaryKey(contRepayAccount);
    }

    /**
     * @Title:
     * @Description: 批量修改融资合同还款信息
     * @param contRepayAccounts
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:15
     */
    @Override
    public int updateByPrimaryKeyDataList(List<ContRepayAccount> contRepayAccounts){
        return super.insertListByJdbcTemplate(contRepayAccounts);
    }

    /**
     * @Title:
     * @Description: 动态修改融资合同还款信息
     * @param contRepayAccount
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:15
     */
    @Override
    public int updateByPrimaryKeySelectiveData(ContRepayAccount contRepayAccount) {
        return super.updateByPrimaryKeySelective(contRepayAccount);
    }

    /**
     * @Title:
     * @Description: 批量动态修改融资合同还款信息
     * @param contRepayAccounts
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:15
     */
    public int updateByPrimaryKeySelectiveDataList(List<ContRepayAccount> contRepayAccounts) {
        return super.updateListByPrimaryKeySelective(contRepayAccounts);
    }

    /**
     * @Title:
     * @Description: 根据条件修改融资合同还款信息
     * @param contRepayAccount
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:15
     */
    @Override
    public int updateByExampleData(ContRepayAccount contRepayAccount, Example example) {
        return super.updateByExample(contRepayAccount,example);
    }
    
    /**
     * @Title:
     * @Description: 根据条件动态修改融资合同还款信息
     * @param contRepayAccount
     * @param example
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:15
     */
    @Override
    public int updateByExampleSelectiveData(ContRepayAccount contRepayAccount, Example example){
        return super.updateByExampleSelective(contRepayAccount,example);
    }
    
    /**
     * @Title:
     * @Description: 根据repayAccId删除融资合同还款信息
     * @param contRepayAccount
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:15
     */
    @Override
    public int deleteData(ContRepayAccount contRepayAccount) {
        return super.delete(contRepayAccount);
    }

    /**
     * @Title:
     * @Description: 根据repayAccId集合批量删除融资合同还款信息
     * @param contRepayAccount
     * @return int
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:15
     */
    public int deleteDataList(List repayAccIds,ContRepayAccount contRepayAccount){
        return super.deleteByIds(repayAccIds,contRepayAccount);
    }

    /**
     * @Title:
     * @Description: 查询全部融资合同还款信息
     * @return List<ContRepayAccount>
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:15
     */
    @Override
    public List<ContRepayAccount> selectAll() {
        return super.selectAll();
    }
    
    /**
     * @Title:
     * @Description: 通过条件查询一个融资合同还款信息
     * @param example
     * @return ContRepayAccount
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:15
     */
    @Override
    public ContRepayAccount selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过条件批量查询融资合同还款信息
     * @param example
     * @return List<ContRepayAccount>
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:15
     */
    @Override
    public List<ContRepayAccount> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }
    
    /**
     * @Title:
     * @Description: 通过repayAccId查询融资合同还款信息
     * @param repayAccId
     * @return ContRepayAccount
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:15
     */
    @Override
    public ContRepayAccount selectByPrimaryKey(Object repayAccId) {
        return super.selectByPrimaryKey(repayAccId);
    }
    
    /**
     * @Title:
     * @Description: 分页查询融资合同还款信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<ContRepayAccount>
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:15
     */
    @Override
    public PageInfoExtend<ContRepayAccount> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询融资合同还款信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend<ContRepayAccountListVo>
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:15
     */
    public PageInfoExtend<ContRepayAccountListVo> selectListVoByPage(String methodName, Object param, PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

}
