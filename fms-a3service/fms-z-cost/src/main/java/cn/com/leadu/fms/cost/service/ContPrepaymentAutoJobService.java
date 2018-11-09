package cn.com.leadu.fms.cost.service;


import cn.com.leadu.fms.pojo.cost.vo.contprepayment.ContPrepaymentVo;
import org.springframework.stereotype.Service;

/**
 * @program: fms
 * @description: 提前还款自动任务service
 * @author: yangyiquan
 * @create: 2018-10-24 16:32
 **/
public interface ContPrepaymentAutoJobService {

    /**
    * @Description: 提前还款自动作废
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/10/24 16:37
    */
    void autoCancelPrepayment();

    /**
    * @Description: 提前还款手动作废
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/10/30 17:58
    */
    void manualCancelPrepayment(ContPrepaymentVo contPrepaymentVo);
}