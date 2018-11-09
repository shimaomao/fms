package cn.com.leadu.fms.prebiz.service;

import cn.com.leadu.fms.pojo.prebiz.vo.contQualification.ContQualificationVo;

/**
 * @author yangyiquan
 * @ClassName: ContQualificationService
 * @Description: 合同资管审批核查
 * @date 2018-03-23
 */
public interface ContQualificationService {

    /** 
    * @Description: 合同资管审批通过 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/24 16:06
    */ 
    void approve(ContQualificationVo contQualificationVo);

    /** 
    * @Description: 合同资管审批退回
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/24 16:07
    */ 
    void sendBack(ContQualificationVo contQualificationVo);
}
