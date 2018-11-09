package cn.com.leadu.fms.webclient.prebiz.controller;/**
 * Created by yyq on 2018/5/21.
 */

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.webclient.prebiz.rpc.ContractVehicleRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: fms
 * @description:合同车辆信息controller
 * @author: yangyiquan
 * @create: 2018-05-21 17:17
 **/
@RestController
@RequestMapping("contract_vehicle")
public class ContractVehicleController {

    /**
     * @Fields  : 合同车辆信息rpc
     */
    @Autowired
    private ContractVehicleRpc contractVehicleRpc;

    /**
     * @Description: 查询合同车辆信息
     * @param:contNo
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/14 16:33
     */
    @RequestMapping(value = "findContractVehicleFinanceVoByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContractVehicleFinanceVoByContNo(String contNo){
        return contractVehicleRpc.findContractVehicleFinanceVoByContNo(contNo);
    }
}
