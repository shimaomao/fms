package cn.com.leadu.fms.webclient.prebiz.controller;/**
 * Created by yyq on 2018/5/24.
 */

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.contQualification.ContQualificationVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.ContQualificationRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: fms
 * @description: 合同资管审批controller
 * @author: yangyiquan
 * @create: 2018-05-24 15:53
 **/
@RestController
@RequestMapping("cont_qualification")
public class ContQualificationController {
    /**
     * @Fields  : 合同资管审批rpc
     */
    @Autowired
    private ContQualificationRpc contQualificationRpc;

    /** 
    * @Description:合同资管审批通过
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/24 16:00
    */ 
    @RequestMapping(value = "approve",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> approval(@RequestBody ContQualificationVo contQualificationVo){
        return contQualificationRpc.approve(contQualificationVo);
    }

    /** 
    * @Description: 合同资管审批退回 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/24 16:02
    */ 
    @RequestMapping(value = "sendBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> sendBack(@RequestBody ContQualificationVo contQualificationVo){
        return contQualificationRpc.sendBack(contQualificationVo);
    }
}
