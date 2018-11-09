package cn.com.leadu.fms.data.prebiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.prebiz.entity.ContractFinance;
import cn.com.leadu.fms.pojo.prebiz.vo.contReceiptPay.ContReceiptPayVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractfinance.ContractFinanceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contrequestpay.ContRequestPayVo;
import org.apache.ibatis.annotations.Param;

/**
 * @author huchenghao
 * @ClassName: ContractFinanceDao
 * @Description: 合同融资信息dao层
 * @date 2018-03-23
 */
public interface ContractFinanceDao extends BaseDao<ContractFinance> {

    /**
     * @Title:
     * @Description: 根据合同号 获取融资信息
     * @param contNo 订单编号
     * @return ContractFinanceVo
     * @throws
     * @author huchenghao
     * @date 2018-3-30 17:39:58
     */
    ContractFinanceVo selectContractFinanceVoByContNo(@Param("contNo")String contNo);

    /** 
    * @Description: 通过合同编号查询合同请款时合同融资相关信息 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/9 15:02
    */ 
    ContRequestPayVo selectContractRequestFinanceByContNo(@Param("contNo")String contNo);

    /** 
    * @Description: 通过合同编号查询合同确认收款时合同融资相关信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/13 11:36
    */ 
    ContReceiptPayVo selectContReceiptPayFinanceByContNo(@Param("contNo")String contNo);
}