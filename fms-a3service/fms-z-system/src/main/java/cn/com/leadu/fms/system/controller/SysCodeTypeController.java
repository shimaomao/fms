package cn.com.leadu.fms.system.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.vo.syscodetype.SysCodeTypeVo;
import cn.com.leadu.fms.system.service.SysCodeTypeService;
import cn.com.leadu.fms.system.validator.syscodetype.vo.SysCodeTypeDeleteListVo;
import cn.com.leadu.fms.system.validator.syscodetype.vo.SysCodeTypeDeleteVo;
import cn.com.leadu.fms.system.validator.syscodetype.vo.SysCodeTypeModifyVo;
import cn.com.leadu.fms.system.validator.syscodetype.vo.SysCodeTypeSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author huchenghao
 * @ClassName: SysCodeTypeController
 * @Description: 字典数据类型相关接口
 * @date 2018-03-08
 */
@RestController
@RequestMapping("sys_code_type")
public class SysCodeTypeController {

    @Autowired
    private SysCodeTypeService sysCodeTypeService;

    /**
     * @Title:
     * @Description: 分页查询字典数据类型信息
     * @param sysCodeTypeVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:56
     */
    @RequestMapping(value = "findSysCodeTypesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysCodeTypesByPage(SysCodeTypeVo sysCodeTypeVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(sysCodeTypeService.findSysCodeTypesByPage(sysCodeTypeVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存字典数据类型
     * @param sysCodeTypeSaveVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:56
     */
    @RequestMapping(value = "saveSysCodeType",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysCodeType(@Valid @RequestBody SysCodeTypeSaveVo sysCodeTypeSaveVo){
        sysCodeTypeService.saveSysCodeType(sysCodeTypeSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改字典数据类型
     * @param sysCodeTypeModifyVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:56
     */
    @RequestMapping(value = "modifySysCodeType",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysCodeType(@Valid @RequestBody SysCodeTypeModifyVo sysCodeTypeModifyVo){
        sysCodeTypeService.modifySysCodeType(sysCodeTypeModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除字典数据类型
     * @param sysCodeTypeDeleteVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:56
     */
    @RequestMapping(value = "deleteSysCodeType",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysCodeType(@Valid @RequestBody SysCodeTypeDeleteVo sysCodeTypeDeleteVo){
        sysCodeTypeService.deleteSysCodeType(sysCodeTypeDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据id集合删除字典数据类型
     * @param sysCodeTypeDeleteListVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:56
     */
    @RequestMapping(value = "deleteSysCodeTypeByIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysCodeTypeByIds(@Valid @RequestBody SysCodeTypeDeleteListVo sysCodeTypeDeleteListVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysCodeTypeService.deleteSysCodeTypeByIds(sysCodeTypeDeleteListVo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据id获取字典数据类型
     * @param codeTypeId
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:56
     */
    @RequestMapping(value = "findSysCodeTypeById", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysCodeTypeById(String codeTypeId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysCodeTypeService.findSysCodeTypeById(codeTypeId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据id获取字典数据类型
     * @param codeType
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-8 15:35:56
     */
    @RequestMapping(value = "findSysCodeTypeByCodeType", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysCodeTypeByCodeType(String codeType){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysCodeTypeService.findSysCodeTypeByCodeType(codeType)), HttpStatus.OK);
    }

}
