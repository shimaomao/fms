package cn.com.leadu.fms.system.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.vo.systpltype.SysTplTypeVo;
import cn.com.leadu.fms.system.service.SysTplTypeService;
import cn.com.leadu.fms.system.validator.systpltype.vo.SysTplTypeDeleteListVo;
import cn.com.leadu.fms.system.validator.systpltype.vo.SysTplTypeModifyVo;
import cn.com.leadu.fms.system.validator.systpltype.vo.SysTplTypeSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author wubaoliang
 * @ClassName: SysTplTypeController
 * @Description: 模板类型管理相关接口
 * @date 2018-03-12
 */
@RestController
@RequestMapping("sys_tpl_type")
public class SysTplTypeController {

    /**
     * @Fields  : 模板类型管理service
     */
    @Autowired
    private SysTplTypeService sysTplTypeService;

    /**
     * @Title:
     * @Description: 分页查询模板类型管理信息
     * @param sysTplTypeVo
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:40
     */
    @RequestMapping(value = "findSysTplTypesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysTplTypesByPage(SysTplTypeVo sysTplTypeVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(sysTplTypeService.findSysTplTypesByPage(sysTplTypeVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存模板类型管理
     * @param sysTplTypeSaveVo
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:40
     */
    @RequestMapping(value = "saveSysTplType",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysTplType(@Valid @RequestBody SysTplTypeSaveVo sysTplTypeSaveVo){
        sysTplTypeService.saveSysTplType(sysTplTypeSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改模板类型管理
     * @param sysTplTypeModifyVo
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:40
     */
    @RequestMapping(value = "modifySysTplType",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysTplType(@Valid @RequestBody SysTplTypeModifyVo sysTplTypeModifyVo){
        sysTplTypeService.modifySysTplType(sysTplTypeModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据tplTypeId集合删除模板类型管理
     * @param sysTplTypeDeleteListVo
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:40
     */
    @RequestMapping(value = "deleteSysTplTypesByTplTypeIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysTplTypesByTplTypeIds(@Valid @RequestBody SysTplTypeDeleteListVo sysTplTypeDeleteListVo){
        return sysTplTypeService.deleteSysTplTypesByTplTypeIds(sysTplTypeDeleteListVo);
    }

    /**
     * @Title:
     * @Description:  根据tplTypeId获取模板类型管理
     * @param tplTypeId
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:40
     */
    @RequestMapping(value = "findSysTplTypeVoByTplTypeId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysTplTypeVoByTplTypeId(String tplTypeId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysTplTypeService.findSysTplTypeVoByTplTypeId(tplTypeId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据sysTplTypeVo获取模板管理
     * @param sysTplTypeVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-12 15:16:18
     */
    @RequestMapping(value = "findSysTplTypeListByBasFileTypeList", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> findSysTplTypeListByBasFileTypeList(@RequestBody SysTplTypeVo sysTplTypeVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysTplTypeService.findSysTplTypeListByBasFileTypeList(sysTplTypeVo)), HttpStatus.OK);
    }


    /**
     * @Title:
     * @Description:  根据tplTypeKey获取模板类型管理
     * @param tplTypeKey
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:40
     */
    @RequestMapping(value = "findSysTplTypeByTplTypeKey", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysTplTypeByTplTypeKey(String tplTypeKey){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysTplTypeService.findSysTplTypeByTplTypeKey(tplTypeKey)), HttpStatus.OK);
    }
}
