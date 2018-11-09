package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.applymanageapprove.ApplyManageApproveVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @program: fms
 * @description: 总经理审核
 * @author: yangyiquan
 * @create: 2018-06-30 16:34
 **/
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ApplyManageApproveRpc {
    /** 
    * @Description:  总经理审核通过
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/30 16:43
    */ 
    @RequestMapping(value = "api/prebiz/apply_manage_approve/approval",method = RequestMethod.POST)
    ResponseEntity<RestResponse> approval(@RequestBody ApplyManageApproveVo applyManageApproveVo);

    /** 
    * @Description: 总经理审核退回 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/30 16:43
    */ 
    @RequestMapping(value = "api/prebiz/apply_manage_approve/sendBack",method = RequestMethod.POST)
    ResponseEntity<RestResponse> sendBack(@RequestBody ApplyManageApproveVo applyManageApproveVo);

    /**
    * @Description: 退回风控经理
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/27 12:04
    */
    @RequestMapping(value = "api/prebiz/apply_manage_approve/backToDiragree",method = RequestMethod.POST)
    ResponseEntity<RestResponse> backToDiragree(@RequestBody ApplyManageApproveVo applyManageApproveVo);
}
