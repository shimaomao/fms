package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.lawsuitregister.LawsuitRegisterVo;
import cn.com.leadu.fms.postbiz.service.LawsuitRegisterService;
import cn.com.leadu.fms.postbiz.validator.lawsuitregister.vo.*;
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
 * @ClassName: LawsuitRegisterController
 * @Description: 诉讼登记信息相关接口
 */
@RestController
@RequestMapping("lawsuit_register")
public class LawsuitRegisterController {

    /**
     * @Fields  : 诉讼登记信息service
     */
    @Autowired
    private LawsuitRegisterService lawsuitRegisterService;

    /**
     * @Title:
     * @Description: 分页查询诉讼登记信息信息
     * @param lawsuitRegisterVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @RequestMapping(value = "findLawsuitRegistersByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findLawsuitRegistersByPage(LawsuitRegisterVo lawsuitRegisterVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(lawsuitRegisterService.findLawsuitRegistersByPage(lawsuitRegisterVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存诉讼登记信息
     * @param lawsuitRegisterSaveVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @RequestMapping(value = "saveLawsuitRegister",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveLawsuitRegister(@Valid @RequestBody LawsuitRegisterSaveVo lawsuitRegisterSaveVo){
        lawsuitRegisterService.saveLawsuitRegister(lawsuitRegisterSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改诉讼登记信息
     * @param lawsuitRegisterModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @RequestMapping(value = "modifyLawsuitRegister",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyLawsuitRegister(@Valid @RequestBody LawsuitRegisterModifyVo lawsuitRegisterModifyVo){
        lawsuitRegisterService.modifyLawsuitRegister(lawsuitRegisterModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除诉讼登记信息
     * @param lawsuitRegisterDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @RequestMapping(value = "deleteLawsuitRegister",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteLawsuitRegister(@Valid @RequestBody LawsuitRegisterDeleteVo lawsuitRegisterDeleteVo){
        lawsuitRegisterService.deleteLawsuitRegister(lawsuitRegisterDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据lawsuitRegisterId集合删除诉讼登记信息
     * @param lawsuitRegisterDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @RequestMapping(value = "deleteLawsuitRegistersByLawsuitRegisterIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteLawsuitRegistersByLawsuitRegisterIds(@Valid @RequestBody LawsuitRegisterDeleteListVo lawsuitRegisterDeleteListVo){
        lawsuitRegisterService.deleteLawsuitRegistersByLawsuitRegisterIds(lawsuitRegisterDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据lawsuitRegisterId获取诉讼登记信息
     * @param lawsuitRegisterId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-12 15:55:46
     */
    @RequestMapping(value = "findLawsuitRegisterByLawsuitRegisterId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findLawsuitRegisterByLawsuitRegisterId(String lawsuitRegisterId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(lawsuitRegisterService.findLawsuitRegisterByLawsuitRegisterId(lawsuitRegisterId)), HttpStatus.OK);
    }

}
