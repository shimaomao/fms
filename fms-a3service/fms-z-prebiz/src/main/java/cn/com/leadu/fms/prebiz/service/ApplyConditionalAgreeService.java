package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.pojo.prebiz.entity.ApplyFinance;
import cn.com.leadu.fms.pojo.prebiz.vo.applyConditionalAgree.ApplyConditionalAgreeVo;
import cn.com.leadu.fms.pojo.prebiz.vo.quotationdevice.QuotationDeviceVo;

/**
 * @author yangyiquan
 * @ClassName: applyConditionalAgreeService
 * @Description: 申请有条件同意审批业务层
 * @date 2018-06-22
 */
public interface ApplyConditionalAgreeService {
    /** 
    * @Description: 获取有条件同意申请融资信息，构造有条件同意默认定金，首付，尾付
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/22 12:03
    */ 
    ApplyFinance findApplyFinanceByApplyNo(String applyNo);

    /** 
    * @Description: 获取有条件同意vo
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/4 14:05
    */ 
    ApplyConditionalAgreeVo findApplyConditionalAgreeVoByApplyNo(String applyNo);

    /** 
    * @Description: 是否有条件同意审批通用操作
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/22 15:36
    */ 
    void approve(ApplyConditionalAgreeVo applyConditionalAgreeVo);

    /** 
    * @Description:  录入员是否同意操作
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/22 17:49
    */ 
    void agreeOrNot(ApplyConditionalAgreeVo applyConditionalAgreeVo);

    /** 
    * @Description: 万量报价器计算
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/27 18:11
    */ 
    QuotationDeviceVo quotationCalculation(ApplyFinance applyFinance);
}
