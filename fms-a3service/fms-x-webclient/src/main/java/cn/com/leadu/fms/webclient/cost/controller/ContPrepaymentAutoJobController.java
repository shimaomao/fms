package cn.com.leadu.fms.webclient.cost.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.cost.vo.contprepayment.ContPrepaymentVo;
import cn.com.leadu.fms.webclient.cost.rpc.ContPrepaymentAutoJobRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: fms
 * @description: 提前还款自动作业Controller
 * @author: yangyiquan
 * @create: 2018-10-26 10:53
 **/
@RestController
@RequestMapping("prepayment_auto_job")
public class ContPrepaymentAutoJobController {

    /**
     * @Field: 提前还款审批rpc
     */
    @Autowired
    private ContPrepaymentAutoJobRpc contPrepaymentAutoJobRpc;

    /**
    * @Description: 提前还款自动作废
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/10/26 11:08
    */
    @RequestMapping(value = "autoCancelPrepayment" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> autoCancelPrepayment(){
        return contPrepaymentAutoJobRpc.autoCancelPrepayment();
    }

    /**
     * @Description: 提前还款手动作废
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/10/26 11:08
     */
    @RequestMapping(value = "manualCancelPrepayment" ,method = RequestMethod.POST)
    public ResponseEntity<RestResponse> manualCancelPrepayment(@RequestBody ContPrepaymentVo contPrepaymentVo){
        return contPrepaymentAutoJobRpc.manualCancelPrepayment(contPrepaymentVo);
    }
}