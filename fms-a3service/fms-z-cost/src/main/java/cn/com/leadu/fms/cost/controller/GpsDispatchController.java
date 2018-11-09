package cn.com.leadu.fms.cost.controller;

import cn.com.leadu.fms.common.constant.enums.sql.PageFlags;
import cn.com.leadu.fms.cost.service.GpsDispatchService;
import cn.com.leadu.fms.cost.validator.gpsdispatch.vo.GpsDispatchDeleteListVo;
import cn.com.leadu.fms.cost.validator.gpsdispatch.vo.GpsDispatchDeleteVo;
import cn.com.leadu.fms.cost.validator.gpsdispatch.vo.GpsDispatchModifyVo;
import cn.com.leadu.fms.cost.validator.gpsdispatch.vo.GpsDispatchSaveVo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.cost.vo.gpsdispatch.GpsDispatchMonthlyVo;
import cn.com.leadu.fms.pojo.cost.vo.gpsdispatch.GpsDispatchVo;
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
 * @Description: 派单信息相关接口
 * @date 2018-05-25
 */
@RestController
@RequestMapping("gps_dispatch")
public class GpsDispatchController {

    /**
     * @Fields  : 派单信息service
     */
    @Autowired
    private GpsDispatchService gpsDispatchService;

    /**
     * @Title:
     * @Description: 查询派单信息一览
     * @param gpsDispatchVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:58
     */
    @RequestMapping(value = "findGpsDispatchVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findGpsDispatchVosByPage(GpsDispatchVo gpsDispatchVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(gpsDispatchService.findGpsDispatchVosByPage(gpsDispatchVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 暂存派单信息
     * @param gpsDispatchVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:58
     */
    @RequestMapping(value = "storageGpsDispatch",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> storageGpsDispatch(@RequestBody GpsDispatchVo gpsDispatchVo){
        gpsDispatchService.storageGpsDispatch(gpsDispatchVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存派单信息
     * @param gpsDispatchSaveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:58
     */
    @RequestMapping(value = "saveGpsDispatch",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveGpsDispatch(@Valid @RequestBody GpsDispatchSaveVo gpsDispatchSaveVo){
        gpsDispatchService.saveGpsDispatch(gpsDispatchSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改派单信息
     * @param gpsDispatchModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:58
     */
    @RequestMapping(value = "modifyGpsDispatch",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyGpsDispatch(@Valid @RequestBody GpsDispatchModifyVo gpsDispatchModifyVo){
        gpsDispatchService.modifyGpsDispatch(gpsDispatchModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据dispatchId获取派单信息
     * @param dispatchId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:58
     */
    @RequestMapping(value = "findGpsDispatchByDispatchId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findGpsDispatchByDispatchId(String dispatchId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(gpsDispatchService.findGpsDispatchByDispatchId(dispatchId)), HttpStatus.OK);
    }

    /** 
    * @Description: 查询派单月结一览信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/28 15:38
    */ 
    @RequestMapping(value = "findGpsDispatchMonthlysVosListByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findGpsDispatchMonthlysVosListByPage(GpsDispatchMonthlyVo gpsDispatchMonthlyVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(gpsDispatchService.findGpsDispatchMonthlysVosListByPage(gpsDispatchMonthlyVo)),
                HttpStatus.OK);
    }

    /**
     * @Description: 查询派单月结信息,不分页,POST
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/28 15:38
     */
    @RequestMapping(value = "findGpsDispatchMonthlysVos" ,method = RequestMethod.POST)
    public ResponseEntity<RestResponse> findGpsDispatchMonthlysVos(@Valid @RequestBody GpsDispatchMonthlyVo gpsDispatchMonthlyVo){
        gpsDispatchMonthlyVo.setPageFlag(PageFlags.NOT_PAGE.getFlag());//不分页标识
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(gpsDispatchService.findGpsDispatchMonthlysVos(gpsDispatchMonthlyVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据合同id查询派单信息详情
     * @param contNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/28 04:44:13
     */
    @RequestMapping(value = "findGpsDispatchDetailByContNo" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findGpsDispatchDetailByContNo(String contNo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(gpsDispatchService.findGpsDispatchDetailByContNo(contNo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   查询天易派单状态
     * @param dispatchId
     * @param tyOrderNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/05 08:33:45
     */
    @RequestMapping(value = "findTyGpsDisPatch" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findTyGpsDisPatch(String dispatchId,String tyOrderNo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(gpsDispatchService.findTyGpsDisPatch(dispatchId,tyOrderNo)),
                HttpStatus.OK);
    }

}
