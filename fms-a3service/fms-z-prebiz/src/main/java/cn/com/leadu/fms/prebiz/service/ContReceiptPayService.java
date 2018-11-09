package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.pojo.prebiz.entity.ContRepaySked;
import cn.com.leadu.fms.pojo.prebiz.vo.contReceiptPay.ContReceiptPayVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contrequestpay.ContRequestPayVo;

import java.util.Date;
import java.util.List;

/**
 * @program: fms
 * @description: 合同请款收款相关service
 * @author: yangyiquan
 * @create: 2018-06-12 21:13
 **/
public interface ContReceiptPayService {
    /**
     * @Description: 根据合同编号查询合同待付款信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/13 10:27
     */
    ContReceiptPayVo findContReceiptPayVoByContNo(String contNo);

    /** 
    * @Description: 暂存合同待付款信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/13 17:29
    */ 
    void saveContCharge(ContReceiptPayVo contReceiptPayVo);

    /** 
    * @Description: 财务确认收款提交
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/13 17:39
    */ 
    void submitContCharge(ContReceiptPayVo contReceiptPayVo);

    /** 
    * @Description: 财务确认收款退回
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/13 18:03
    */ 
    void backContCharge(ContReceiptPayVo contReceiptPayVo);

    /**
     * @Description: 根据合同号查询合同请款信息,包括付款信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/15 16:05
     */
    ContRequestPayVo findContRequestPayWithContPayByContNo(String contNo);

    /** 
    * @Description: 打印
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/19 11:43
    */ 
    String printContMakeVoucher(String contNo);

    /** 
    * @Description: 暂存
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/19 16:54
    */ 
    void saveMakeVoucherCommon(ContRequestPayVo contRequestPayVo);

    /** 
    * @Description: 贷前合同财务制单
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/14 17:50
    */ 
    void submitContMakeVoucher(ContRequestPayVo contRequestPayVo);

    /** 
    * @Description: 财务付款确认 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/15 16:40
    */ 
    void submitContPayment(ContRequestPayVo contRequestPayVo);

    /** 
    * @Description: 财务付款退回
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/15 16:40
    */ 
    void backContPayment(ContRequestPayVo contRequestPayVo);

    /** 
    * @Description: 构造还款计划表并返回,repayDate为null时还款日默认为当日
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/10 16:20
    */ 
    List<ContRepaySked> getContRepaySked(String contNo);


}
