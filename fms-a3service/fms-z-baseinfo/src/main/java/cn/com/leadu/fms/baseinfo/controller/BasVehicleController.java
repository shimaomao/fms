package cn.com.leadu.fms.baseinfo.controller;

import cn.com.leadu.fms.baseinfo.service.BasVehicleService;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.baseinfo.vo.basvehicle.BasVehicleVo;
import cn.com.leadu.fms.baseinfo.validator.basvehicle.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @author niehaibing
 * @ClassName: BasVehicleController
 * @Description: 车辆信息维护相关接口
 * @date 2018-03-20
 */
@RestController
@RequestMapping("bas_vehicle")
public class BasVehicleController {

    /**
     * @Fields  : 车辆信息维护service
     */
    @Autowired
    private BasVehicleService basVehicleService;

    /**
     * @Title:
     * @Description: 分页查询车辆信息维护信息
     * @param basVehicleVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-20 14:26:01
     */
    @RequestMapping(value = "findBasVehiclesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasVehiclesByPage(BasVehicleVo basVehicleVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(basVehicleService.findBasVehiclesByPage(basVehicleVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存车辆信息维护
     * @param basVehicleSaveVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-20 14:26:01
     */
    @RequestMapping(value = "saveBasVehicle",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBasVehicle(@Valid @RequestBody BasVehicleSaveVo basVehicleSaveVo){
        basVehicleService.saveBasVehicle(basVehicleSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改车辆信息维护
     * @param basVehicleModifyVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-20 14:26:01
     */
    @RequestMapping(value = "modifyBasVehicle",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyBasVehicle(@Valid @RequestBody BasVehicleModifyVo basVehicleModifyVo){
        basVehicleService.modifyBasVehicle(basVehicleModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除车辆信息维护
     * @param basVehicleDeleteVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-20 14:26:01
     */
    @RequestMapping(value = "deleteBasVehicle",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBasVehicle(@Valid @RequestBody BasVehicleDeleteVo basVehicleDeleteVo){
        basVehicleService.deleteBasVehicle(basVehicleDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据vehicleId集合删除车辆信息维护
     * @param basVehicleDeleteListVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-20 14:26:01
     */
    @RequestMapping(value = "deleteBasVehiclesByVehicleIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBasVehiclesByVehicleIds(@Valid @RequestBody BasVehicleDeleteListVo basVehicleDeleteListVo){
        basVehicleService.deleteBasVehiclesByVehicleIds(basVehicleDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据vehicleId获取车辆信息维护
     * @param vehicleId
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-20 14:26:01
     */
    @RequestMapping(value = "findBasVehicleByVehicleId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasVehicleByVehicleId(String vehicleId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(basVehicleService.findBasVehicleByVehicleId(vehicleId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 分页查询车辆信息Vo
     * @param basVehicleVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-30 17:33:19
     */
    @RequestMapping(value = "findBasVehiclesVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasVehiclesVosByPage(BasVehicleVo basVehicleVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(basVehicleService.findBasVehiclesVosByPage(basVehicleVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 分页查询车辆信息Vo
     * @param basVehicleVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-30 17:33:19
     */
    @RequestMapping(value = "findBasVehicleLevelsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasVehicleLevelsByPage(BasVehicleVo basVehicleVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(basVehicleService.findBasVehicleLevelsByPage(basVehicleVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据车辆型号取得相关信息
     * @param vehicleCode
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-30 17:33:19
     */
    @RequestMapping(value = "findBasVehicleVoByVehicleCode" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasVehicleVoByVehicleCode(String vehicleCode){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(basVehicleService.findBasVehicleVoByVehicleCode(vehicleCode)),
                HttpStatus.OK);
    }
}
