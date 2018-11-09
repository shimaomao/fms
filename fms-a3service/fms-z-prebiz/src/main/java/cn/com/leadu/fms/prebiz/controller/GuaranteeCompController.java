package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.vo.guaranteecomp.GuaranteeCompVo;
import cn.com.leadu.fms.prebiz.service.GuaranteeCompService;
import cn.com.leadu.fms.prebiz.validator.guaranteecomp.vo.*;
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
 * @ClassName: GuaranteeCompController
 * @Description: 担保企业信息相关接口
 * @date 2018-03-30
 */
@RestController
@RequestMapping("guarantee_comp")
public class GuaranteeCompController {

    /**
     * @Fields  : 担保企业信息service
     */
    @Autowired
    private GuaranteeCompService guaranteeCompService;

    /**
     * @Title:
     * @Description: 分页查询担保企业信息信息
     * @param guaranteeCompVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @RequestMapping(value = "findGuaranteeCompsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findGuaranteeCompsByPage(GuaranteeCompVo guaranteeCompVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(guaranteeCompService.findGuaranteeCompsByPage(guaranteeCompVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存担保企业信息
     * @param guaranteeCompSaveVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @RequestMapping(value = "saveGuaranteeComp",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveGuaranteeComp(@Valid @RequestBody GuaranteeCompSaveVo guaranteeCompSaveVo){
        guaranteeCompService.saveGuaranteeComp(guaranteeCompSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改担保企业信息
     * @param guaranteeCompModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @RequestMapping(value = "modifyGuaranteeComp",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyGuaranteeComp(@Valid @RequestBody GuaranteeCompModifyVo guaranteeCompModifyVo){
        guaranteeCompService.modifyGuaranteeComp(guaranteeCompModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除担保企业信息
     * @param guaranteeCompDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @RequestMapping(value = "deleteGuaranteeComp",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteGuaranteeComp(@Valid @RequestBody GuaranteeCompDeleteVo guaranteeCompDeleteVo){
        guaranteeCompService.deleteGuaranteeComp(guaranteeCompDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据guarCompId集合删除担保企业信息
     * @param guaranteeCompDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @RequestMapping(value = "deleteGuaranteeCompsByGuarCompIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteGuaranteeCompsByGuarCompIds(@Valid @RequestBody GuaranteeCompDeleteListVo guaranteeCompDeleteListVo){
        guaranteeCompService.deleteGuaranteeCompsByGuarCompIds(guaranteeCompDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据guarCompId获取担保企业信息
     * @param guarCompId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @RequestMapping(value = "findGuaranteeCompByGuarCompId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findGuaranteeCompByGuarCompId(String guarCompId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(guaranteeCompService.findGuaranteeCompByGuarCompId(guarCompId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据applyNo获取担保企业信息
     * @param applyNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-30 14:22:35
     */
    @RequestMapping(value = "findGuaranteeCompByApplyNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findGuaranteeCompByApplyNo(String applyNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(guaranteeCompService.findGuaranteeCompsByApplyNo(applyNo)), HttpStatus.OK);
    }

}
