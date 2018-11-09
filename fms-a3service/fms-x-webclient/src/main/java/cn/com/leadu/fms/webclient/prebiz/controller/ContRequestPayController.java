package cn.com.leadu.fms.webclient.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.continsurance.ContInsuranceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contrequestpay.ContRequestPayVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.ContRequestPayRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huchenghao
 * @ClassName: ContRequestPayController
 * @Description: controller
 * @date 2018-03-15
 */
@RestController
@RequestMapping("cont_request_pay")
public class ContRequestPayController {

    /**
     * @Fields  : rpc
     */
    @Autowired
    private ContRequestPayRpc contRequestPayRpc;

    /**
     * @Title:
     * @Description: 提交
     * @param contRequestPayVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-26 16:20:27
     */
    @RequestMapping(value = "submitContRequestPay",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> submitContRequestPay(@RequestBody ContRequestPayVo contRequestPayVo){
        return contRequestPayRpc.submitContRequestPay(contRequestPayVo);
    }

    /**
     * @Title:
     * @Description: 退回
     * @param contRequestPayVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-26 16:20:27
     */
    @RequestMapping(value = "sendBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> sendBack(@RequestBody ContRequestPayVo contRequestPayVo){
        return contRequestPayRpc.sendBack(contRequestPayVo);
    }

    /**
     * @Title:
     * @Description: 保存
     * @param contRequestPayVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-26 16:20:27
     */
    @RequestMapping(value = "saveContRequestPay",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContRequestPay(@RequestBody ContRequestPayVo contRequestPayVo){
        return contRequestPayRpc.saveContRequestPay(contRequestPayVo);
    }


    /**
     * @Title:
     * @Description: 根据合同号查询车辆保险信息
     * @param contNo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-26 16:20:27
     */
    @RequestMapping(value = "findContRequestPayByContNo",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRequestPayByContNo(String contNo){
        return contRequestPayRpc.findContRequestPayByContNo(contNo);
    }


}
