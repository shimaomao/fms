package cn.com.leadu.fms.prebiz.service;/**
 * Created by yyq on 2018/6/30.
 */

import cn.com.leadu.fms.pojo.prebiz.vo.applymanageapprove.ApplyManageApproveVo;
import org.springframework.transaction.annotation.Transactional;

/**
 * @program: fms
 * @description: 总经理审核
 * @author: yangyiquan
 * @create: 2018-06-30 15:28
 **/
public interface ApplyManageApproveService {

    /** 
    * @Description: 总经理审核通过
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/30 15:37
    */ 
    void approval(ApplyManageApproveVo applyManageApproveVo);

    /** 
    * @Description:  总经理审核退回
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/30 15:51
    */ 
    void sendBack(ApplyManageApproveVo applyManageApproveVo);

    /**
    * @Description: 退回到主管复核
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/27 12:01
    */
    void backToDiragree(ApplyManageApproveVo applyManageApproveVo);
}
