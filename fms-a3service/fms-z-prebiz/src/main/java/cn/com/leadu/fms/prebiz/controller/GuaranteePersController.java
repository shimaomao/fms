package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.vo.guaranteepers.GuaranteePersVo;
import cn.com.leadu.fms.prebiz.service.GuaranteePersService;
import cn.com.leadu.fms.prebiz.validator.guaranteepers.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @author ningyangyang
 * @ClassName: GuaranteePersController
 * @Description: 担保个人信息相关接口
 * @date 2018-03-30
 */
@RestController
@RequestMapping("guarantee_pers")
public class GuaranteePersController {

    /**
     * @Fields  : 担保个人信息service
     */
    @Autowired
    private GuaranteePersService guaranteePersService;

    /**
     * @Title:
     * @Description: 分页查询担保个人信息信息
     * @param guaranteePersVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:12
     */
    @RequestMapping(value = "findGuaranteePerssByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findGuaranteePerssByPage(GuaranteePersVo guaranteePersVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(guaranteePersService.findGuaranteePerssByPage(guaranteePersVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存担保个人信息
     * @param guaranteePersSaveVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:12
     */
    @RequestMapping(value = "saveGuaranteePers",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveGuaranteePers(@Valid @RequestBody GuaranteePersSaveVo guaranteePersSaveVo){
        guaranteePersService.saveGuaranteePers(guaranteePersSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改担保个人信息
     * @param guaranteePersModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:12
     */
    @RequestMapping(value = "modifyGuaranteePers",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyGuaranteePers(@Valid @RequestBody GuaranteePersModifyVo guaranteePersModifyVo){
        guaranteePersService.modifyGuaranteePers(guaranteePersModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除担保个人信息
     * @param guaranteePersDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:12
     */
    @RequestMapping(value = "deleteGuaranteePers",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteGuaranteePers(@Valid @RequestBody GuaranteePersDeleteVo guaranteePersDeleteVo){
        guaranteePersService.deleteGuaranteePers(guaranteePersDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据guarPersId集合删除担保个人信息
     * @param guaranteePersDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:12
     */
    @RequestMapping(value = "deleteGuaranteePerssByGuarPersIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteGuaranteePerssByGuarPersIds(@Valid @RequestBody GuaranteePersDeleteListVo guaranteePersDeleteListVo){
        guaranteePersService.deleteGuaranteePerssByGuarPersIds(guaranteePersDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据guarPersId获取担保个人信息
     * @param guarPersId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 10:55:12
     */
    @RequestMapping(value = "findGuaranteePersByGuarPersId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findGuaranteePersByGuarPersId(String guarPersId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(guaranteePersService.findGuaranteePersByGuarPersId(guarPersId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据applyNo获取担保个人信息
     * @param applyNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-8 10:55:12
     */
    @RequestMapping(value = "findGuaranteePersByApplyNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findGuaranteePersByApplyNo(String applyNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(guaranteePersService.findGuaranteePersByApplyNo(applyNo)), HttpStatus.OK);
    }

}
