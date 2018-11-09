package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.contQualification.ContQualificationVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author yangyiquan
 * @ClassName: ContractController
 * @Description: 合同资管审批rpc
 * @date 2018-05-24
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ContQualificationRpc {
    /** 
    * @Description:  合同资管审批通过
    * @param:
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/24 15:56
    */ 
    @RequestMapping(value = "api/prebiz/cont_qualification/approve",method = RequestMethod.POST)
    ResponseEntity<RestResponse> approve(@RequestBody ContQualificationVo contQualificationVo);

    /** 
    * @Description:  合同资管审批退回
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/24 15:58
    */ 
    @RequestMapping(value = "api/prebiz/cont_qualification/sendBack",method = RequestMethod.POST)
    ResponseEntity<RestResponse> sendBack(@RequestBody ContQualificationVo contQualificationVo);
}
