package cn.com.leadu.fms.system.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.vo.systpl.SysTplVo;
import cn.com.leadu.fms.system.service.SysTplService;
import cn.com.leadu.fms.system.validator.systpl.vo.SysTplDeleteListVo;
import cn.com.leadu.fms.system.validator.systpl.vo.SysTplModifyVo;
import cn.com.leadu.fms.system.validator.systpl.vo.SysTplSaveVo;
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
 * @ClassName: SysTplController
 * @Description: 模板管理相关接口
 * @date 2018-03-12
 */
@RestController
@RequestMapping("sys_tpl")
public class SysTplController {

    /**
     * @Fields  : 模板管理service
     */
    @Autowired
    private SysTplService sysTplService;

    /**
     * @Title:
     * @Description: 分页查询模板管理信息
     * @param sysTplVo
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:18
     */
    @RequestMapping(value = "findSysTplVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysTplVosByPage(SysTplVo sysTplVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(sysTplService.findSysTplVosByPage(sysTplVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存模板管理
     * @param sysTplSaveVo
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:18
     */
    @RequestMapping(value = "saveSysTpl",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysTpl(@Valid @RequestBody SysTplSaveVo sysTplSaveVo){
        sysTplService.saveSysTpl(sysTplSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改模板管理
     * @param sysTplModifyVo
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:18
     */
    @RequestMapping(value = "modifySysTpl",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysTpl(@Valid @RequestBody SysTplModifyVo sysTplModifyVo){
        sysTplService.modifySysTpl(sysTplModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据tplId集合删除模板管理
     * @param sysTplDeleteListVo
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:18
     */
    @RequestMapping(value = "deleteSysTplsByTplIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysTplsByTplIds(@Valid @RequestBody SysTplDeleteListVo sysTplDeleteListVo){
        sysTplService.deleteSysTplsByTplIds(sysTplDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据tplId获取模板管理
     * @param tplId
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:18
     */
    @RequestMapping(value = "findSysTplVoByTplId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysTplVoByTplId(String tplId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysTplService.findSysTplVoByTplId(tplId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据tplId获取模板管理
     * @param sysTplVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-12 15:16:18
     */
    @RequestMapping(value = "findSysTplListByBasFileTypeList", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> findSysTplListByBasFileTypeList(@RequestBody SysTplVo sysTplVo){
        System.out.println(sysTplVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysTplService.findSysTplListByBasFileTypeList(sysTplVo)), HttpStatus.OK);
    }

    @RequestMapping(value = "importdatas", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> importdatas(){
        sysTplService.importdatas();
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(), HttpStatus.OK);
    }

}
