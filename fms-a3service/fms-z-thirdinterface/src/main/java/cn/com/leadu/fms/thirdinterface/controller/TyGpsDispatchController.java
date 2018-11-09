package cn.com.leadu.fms.thirdinterface.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.thirdinterface.vo.tygpsdispatch.TyGpsDispatchVo;
import cn.com.leadu.fms.thirdinterface.service.TyGpsDispatchService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author qiaomengnan
 * @ClassName: GpsDispatchController
 * @Description: gps第三方派单接口
 * @date 2018/7/4
 */
@RestController
@RequestMapping("ty_gps_dispatch")
public class TyGpsDispatchController {

    @Autowired
    private TyGpsDispatchService tyGpsDispatchService;

    /**
     * @Title:  
     * @Description:   gps天易派单
     * @param tyGpsDispatchVo
     * @return 
     * @throws 
     * @author qiaomengnan 
     * @date 2018/07/04 03:20:03
     */
    @RequestMapping(value = "sendGpsDispatch" ,method = RequestMethod.POST)
    public ResponseEntity<RestResponse> sendGpsDispatch(@Valid @RequestBody TyGpsDispatchVo tyGpsDispatchVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(
                        tyGpsDispatchService.sendGpsDispatch(tyGpsDispatchVo)
                ),
                HttpStatus.OK);
        
    }

    /**
     * @Title:
     * @Description:  gps天易查单
     * @param applyNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/04 03:23:14
     */
    @RequestMapping(value = "findGpsDisPatch" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findGpsDisPatch(String applyNo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(
                        tyGpsDispatchService.findGpsDisPatch(applyNo)
                ),
                HttpStatus.OK);
    }

}
