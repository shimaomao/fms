package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.vehicledisposal.VehicleDisposalVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.service.VehicleDisposalService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wangxue
 * @ClassName: VehicleDisposalController
 * @Description: 车辆处置相关接口
 */
@RestController
@RequestMapping("vehicle_disposal")
public class VehicleDisposalController {

    /**
     * @Fields  : 车辆处置service
     */
    @Autowired
    private VehicleDisposalService vehicleDisposalService;

    /**
     * @Title:
     * @Description: 分页查询车辆处置信息
     * @param vehicleDisposalVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @RequestMapping(value = "findVehicleDisposalVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findVehicleDisposalVosByPage(VehicleDisposalVo vehicleDisposalVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(vehicleDisposalService.findVehicleDisposalVosByPage(vehicleDisposalVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据vehicleDisposalId获取车辆处置信息Vo
     * @param vehicleDisposalId
     * @return
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @RequestMapping(value = "findVehicleDisposalVoByVehicleDisposalId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findVehicleDisposalVoByVehicleDisposalId(String vehicleDisposalId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(vehicleDisposalService.findVehicleDisposalVoByVehicleDisposalId(vehicleDisposalId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据处置任务号，获取车辆处置信息Vo
     * @param disposalTaskNo 处置任务号
     * @return
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @RequestMapping(value = "findVehicleDisposalVoByDisposalTaskNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findVehicleDisposalVoByDisposalTaskNo(String disposalTaskNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(vehicleDisposalService.findVehicleDisposalVoByDisposalTaskNo(disposalTaskNo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据合同号和处置类型，获取当前正在处理中的处置任务号
     * @param contNo 合同编号
     * @param disposalStatus 车俩处置方式
     * @return
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @RequestMapping(value = "findDisposalTaskNoByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findDisposalTaskNoByContNo(String contNo, String disposalStatus){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(vehicleDisposalService.findDisposalTaskNoByContNo(contNo, disposalStatus)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  车辆处置申请提交
     * @param vehicleDisposalVo 处置信息
     * @return
     * @throws
     * @author wangxue
     * @date 2018-9-12 10:44:08
     */
    @RequestMapping(value = "submitVehicleDisposalApply", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> submitVehicleDisposalApply(@RequestBody VehicleDisposalVo vehicleDisposalVo, @AuthUserInfo SysUser sysUser) {
        vehicleDisposalService.submitVehicleDisposalApply(vehicleDisposalVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

}
