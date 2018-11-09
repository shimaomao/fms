package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.common.constant.enums.postbiz.VehMaintainEnums;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.vehmaintain.VehMaintainVo;
import cn.com.leadu.fms.postbiz.service.VehMaintainService;
import cn.com.leadu.fms.postbiz.validator.vehmaintain.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

/**
 * @author qinmuqiao
 * @ClassName: VehMaintainController
 * @Description: 车辆维修记录相关接口
 */
@RestController
@RequestMapping("veh_maintain")
public class VehMaintainController {

    /**
     * @Fields  : 车辆维修记录service
     */
    @Autowired
    private VehMaintainService vehMaintainService;

    /**
     * @Title:
     * @Description: 分页查询车辆维修记录信息
     * @param vehMaintainVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @RequestMapping(value = "findVehMaintainsVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findVehMaintainsVosByPage(VehMaintainVo vehMaintainVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(vehMaintainService.findVehMaintainsVosByPage(vehMaintainVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存车辆维修记录
     * @param vehMaintainSaveVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @RequestMapping(value = "saveVehMaintain",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveVehMaintain(@Valid @RequestBody VehMaintainSaveVo vehMaintainSaveVo){
        vehMaintainSaveVo.setMaintainFlag(VehMaintainEnums.MAINTAINIMPOR.getType());
        vehMaintainService.saveVehMaintain(vehMaintainSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }


    /**
     * @Title:
     * @Description: 修改车辆维修记录
     * @param vehMaintainModifyVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @RequestMapping(value = "modifyVehMaintain",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyVehMaintain(@Valid @RequestBody VehMaintainModifyVo vehMaintainModifyVo){
        vehMaintainService.modifyVehMaintain(vehMaintainModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }



    /**
     * @Title:
     * @Description:  根据vehMaintainId获取车辆维修记录
     * @param vehMaintainId
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-15 9:53:06
     */
    @RequestMapping(value = "findVehMaintainVoByVehMaintainId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findVehMaintainVoByVehMaintainId(String vehMaintainId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(vehMaintainService.findVehMaintainVoByVehMaintainId(vehMaintainId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   导入维修记录
     * @param filePath
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/11 11:51:40
     */
    @RequestMapping(value = "importVehMaintainsByExcel", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> importVehMaintainsByExcel(String filePath){
        vehMaintainService.importVehMaintainsByExcel(filePath);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   下载维修记录模版
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/11 11:51:40
     */
    @RequestMapping(value = "exportVehMaintainModalExcel", method = RequestMethod.GET)
    public void exportVehMaintainModalExcel(HttpServletResponse httpServletResponse){
        vehMaintainService.exportVehMaintainModalExcel(httpServletResponse);
    }
}
