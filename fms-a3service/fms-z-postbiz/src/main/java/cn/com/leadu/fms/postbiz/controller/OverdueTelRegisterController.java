package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.overduetelregister.OverdueTelRegisterVo;
import cn.com.leadu.fms.postbiz.service.OverdueTelRegisterService;
import cn.com.leadu.fms.postbiz.validator.overduetelregister.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @author lijunjun
 * @ClassName: OverdueTelRegisterController
 * @Description: 电话催收登记信息相关接口
 * @date 2018-05-17
 */
@RestController
@RequestMapping("overdue_tel_register")
public class OverdueTelRegisterController {

    /**
     * @Fields  : 电话催收登记信息service
     */
    @Autowired
    private OverdueTelRegisterService overdueTelRegisterService;

    /**
     * @Title:
     * @Description: 分页查询电话催收登记信息信息
     * @param overdueTelRegisterVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @RequestMapping(value = "findOverdueTelRegistersByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueTelRegistersByPage(OverdueTelRegisterVo overdueTelRegisterVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(overdueTelRegisterService.findOverdueTelRegistersByPage(overdueTelRegisterVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存电话催收登记信息
     * @param overdueTelRegisterSaveVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @RequestMapping(value = "saveOverdueTelRegister",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveOverdueTelRegister(@Valid @RequestBody OverdueTelRegisterSaveVo overdueTelRegisterSaveVo){
        overdueTelRegisterService.saveOverdueTelRegister(overdueTelRegisterSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改电话催收登记信息
     * @param overdueTelRegisterModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @RequestMapping(value = "modifyOverdueTelRegister",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyOverdueTelRegister(@Valid @RequestBody OverdueTelRegisterModifyVo overdueTelRegisterModifyVo){
        overdueTelRegisterService.modifyOverdueTelRegister(overdueTelRegisterModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除电话催收登记信息
     * @param overdueTelRegisterDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @RequestMapping(value = "deleteOverdueTelRegister",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteOverdueTelRegister(@Valid @RequestBody OverdueTelRegisterDeleteVo overdueTelRegisterDeleteVo){
        overdueTelRegisterService.deleteOverdueTelRegister(overdueTelRegisterDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据overdueTelRegisterId集合删除电话催收登记信息
     * @param overdueTelRegisterDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @RequestMapping(value = "deleteOverdueTelRegistersByOverdueTelRegisterIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteOverdueTelRegistersByOverdueTelRegisterIds(@Valid @RequestBody OverdueTelRegisterDeleteListVo overdueTelRegisterDeleteListVo){
        overdueTelRegisterService.deleteOverdueTelRegistersByOverdueTelRegisterIds(overdueTelRegisterDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据overdueTelRegisterId获取电话催收登记信息
     * @param overdueTelRegisterId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-17 11:01:07
     */
    @RequestMapping(value = "findOverdueTelRegisterByOverdueTelRegisterId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueTelRegisterByOverdueTelRegisterId(String overdueTelRegisterId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(overdueTelRegisterService.findOverdueTelRegisterByOverdueTelRegisterId(overdueTelRegisterId)), HttpStatus.OK);
    }

}
