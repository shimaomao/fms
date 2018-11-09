package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.entity.ContInsurance;
import cn.com.leadu.fms.pojo.prebiz.vo.continsurance.ContInsuranceVo;
import cn.com.leadu.fms.prebiz.service.ContInsuranceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @description: 车辆保险Controller
 * @author:ningyangyang
 * @since:2018/5/14
 */
@RestController
@RequestMapping("cont_insurance")
public class ContInsuranceController {

    /**
     * @Fields  : 车辆保险信息service
     */
    @Autowired
    private ContInsuranceService contInsuranceService;

    /**
     * @Title:
     * @Description: 查询车辆保险信息
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 10:14:21
     */
    @RequestMapping(value = "findContInsurance" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContInsurance(ContInsurance contInsurance){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contInsuranceService.findContInsurance(contInsurance)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 通过contVehinsId查询合同车辆保险信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "findContInsuranceByPrimaryKey", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysParamByParamKey(String contVehinsId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contInsuranceService.findContInsuranceByPrimaryKey(contVehinsId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据状态查询车辆保险信息
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 10:14:21
     */
    @RequestMapping(value = "findContInsuranceByStatus" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContInsuranceByStatus(ContInsuranceVo contInsurance){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contInsuranceService.findContInsuranceByStatus(contInsurance)),
                HttpStatus.OK);
    }
}
