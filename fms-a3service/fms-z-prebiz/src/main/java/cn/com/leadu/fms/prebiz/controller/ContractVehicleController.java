package cn.com.leadu.fms.prebiz.controller;/**
 * Created by yyq on 2018/5/21.
 */

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.prebiz.service.ContractVehicleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @program: fms
 * @description:合同车辆信息
 * @author: yangyiquan
 * @create: 2018-05-21 17:08
 **/
@RestController
@RequestMapping("contract_vehicle")
public class ContractVehicleController {
    /**
     * @Fields  : 合同车辆业务层service
     */
    @Autowired
    private ContractVehicleService contractVehicleService;

    /**
     * @Description: 查询合同车辆信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/14 16:33
     */
    @RequestMapping(value = "findContractVehicleFinanceVoByContNo" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContractVehicleFinanceVoByContNo(String contNo ){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contractVehicleService.findContractVehicleFinanceVoByContNo(contNo)),
                HttpStatus.OK);
    }
}
