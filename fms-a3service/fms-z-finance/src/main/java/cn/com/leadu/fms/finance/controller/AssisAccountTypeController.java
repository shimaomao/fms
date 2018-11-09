package cn.com.leadu.fms.finance.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.finance.vo.assisaccounttype.AssisAccountTypeVo;
import cn.com.leadu.fms.finance.service.AssisAccountTypeService;
import cn.com.leadu.fms.finance.validator.assisaccounttype.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: AssisAccountTypeController
 * @Description: 辅助核算类型管理相关接口
 * @date 2018-06-23
 */
@RestController
@RequestMapping("assis_account_type")
public class AssisAccountTypeController {

    /**
     * @Fields  : 辅助核算类型管理service
     */
    @Autowired
    private AssisAccountTypeService assisAccountTypeService;

    /**
     * @Title:
     * @Description: 分页查询辅助核算类型管理信息
     * @param assisAccountTypeVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:16
     */
    @RequestMapping(value = "findAssisAccountTypesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findAssisAccountTypesByPage(AssisAccountTypeVo assisAccountTypeVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(assisAccountTypeService.findAssisAccountTypesByPage(assisAccountTypeVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存辅助核算类型管理
     * @param assisAccountTypeSaveVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:16
     */
    @RequestMapping(value = "saveAssisAccountType",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveAssisAccountType(@Valid @RequestBody AssisAccountTypeSaveVo assisAccountTypeSaveVo){
        assisAccountTypeService.saveAssisAccountType(assisAccountTypeSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改辅助核算类型管理
     * @param assisAccountTypeModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:16
     */
    @RequestMapping(value = "modifyAssisAccountType",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyAssisAccountType(@Valid @RequestBody AssisAccountTypeModifyVo assisAccountTypeModifyVo){
        assisAccountTypeService.modifyAssisAccountType(assisAccountTypeModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除辅助核算类型管理
     * @param assisAccountTypeDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:16
     */
    @RequestMapping(value = "deleteAssisAccountType",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteAssisAccountType(@Valid @RequestBody AssisAccountTypeDeleteVo assisAccountTypeDeleteVo){
        assisAccountTypeService.deleteAssisAccountType(assisAccountTypeDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据assisAccountTypeId集合删除辅助核算类型管理
     * @param assisAccountTypeDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:16
     */
    @RequestMapping(value = "deleteAssisAccountTypesByAssisAccountTypeIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteAssisAccountTypesByAssisAccountTypeIds(@Valid @RequestBody AssisAccountTypeDeleteListVo assisAccountTypeDeleteListVo){
        assisAccountTypeService.deleteAssisAccountTypesByAssisAccountTypeIds(assisAccountTypeDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据assisAccountTypeId获取辅助核算类型管理
     * @param assisAccountTypeId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-23 13:46:16
     */
    @RequestMapping(value = "findAssisAccountTypeByAssisAccountTypeId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findAssisAccountTypeByAssisAccountTypeId(String assisAccountTypeId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(assisAccountTypeService.findAssisAccountTypeByAssisAccountTypeId(assisAccountTypeId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据types集合获取辅助核算类型管理
     * @param assisAccountTypes
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/26 10:49:32
     */
    @RequestMapping(value = "findAssisAccountTypesByAccTypes", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findAssisAccountTypesByAccTypes(@RequestParam List<String> assisAccountTypes){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                assisAccountTypeService.findAssisAccountTypesByAccTypes(assisAccountTypes)
        ), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 分页查询辅助核算类型管理信息弹出框
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "findAssisAccountTypesByPage2" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findAssisAccountTypesByPage2(AssisAccountTypeVo assisAccountTypeVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(assisAccountTypeService.findAssisAccountTypesByPage2(assisAccountTypeVo)),
                HttpStatus.OK);
    }

}
