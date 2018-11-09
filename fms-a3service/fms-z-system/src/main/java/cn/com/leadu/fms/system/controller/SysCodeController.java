package cn.com.leadu.fms.system.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.vo.syscode.SysCodeVo;
import cn.com.leadu.fms.system.service.SysCodeService;
import cn.com.leadu.fms.system.validator.syscode.vo.SysCodeDeleteListVo;
import cn.com.leadu.fms.system.validator.syscode.vo.SysCodeDeleteVo;
import cn.com.leadu.fms.system.validator.syscode.vo.SysCodeModifyVo;
import cn.com.leadu.fms.system.validator.syscode.vo.SysCodeSaveVo;
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
 * @ClassName: SysCodeController
 * @Description: 字典数数值相关接口
 * @date 2018-03-09
 */
@RestController
@RequestMapping("sys_code")
public class SysCodeController {

    @Autowired
    private SysCodeService sysCodeService;

    /**
     * @Title:
     * @Description: 分页查询字典数数值信息
     * @param sysCodeVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-9 14:17:24
     */
    @RequestMapping(value = "findSysCodesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysCodesByPage(SysCodeVo sysCodeVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(sysCodeService.findSysCodesWithTypeNameByPage(sysCodeVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存字典数数值
     * @param sysCodeSaveVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-9 14:17:24
     */
    @RequestMapping(value = "saveSysCode",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysCode(@Valid @RequestBody SysCodeSaveVo sysCodeSaveVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysCodeService.saveSysCode(sysCodeSaveVo)), HttpStatus.OK);
    }
    /**
     * @Title:
     * @Description:  根据codeValueId获取字典数数值
     * @param codeValueId
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-9 14:17:24
     */
    @RequestMapping(value = "findSysCodeByCodeValueId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysCodeByCodeValueId(String codeValueId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysCodeService.findSysCodeByCodeValueId(codeValueId)), HttpStatus.OK);
    }


    /**
     * @Title:
     * @Description:  修改字典数数值
     * @param sysCodeModifyVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-9 14:17:24
     */
    @RequestMapping(value = "modifySysCode",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysCode(@Valid @RequestBody SysCodeModifyVo sysCodeModifyVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysCodeService.modifySysCode(sysCodeModifyVo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除字典数数值
     * @param sysCodeDeleteVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-9 14:17:24
     */
    @RequestMapping(value = "deleteSysCode",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysCode(@Valid @RequestBody SysCodeDeleteVo sysCodeDeleteVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysCodeService.deleteSysCode(sysCodeDeleteVo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据codeValueId集合删除字典数数值
     * @param sysCodeDeleteListVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-9 14:17:24
     */
    @RequestMapping(value = "deleteSysCodeByCodeValueIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysCodeByCodeValueIds(@Valid @RequestBody SysCodeDeleteListVo sysCodeDeleteListVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysCodeService.deleteSysCodeByCodeValueIds(sysCodeDeleteListVo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据codeValue和codeType查询
     * @param sysCodeVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-9 14:17:24
     */
    @RequestMapping(value = "findSysCodeByCodeValue", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> findSysCodeByCodeValue(@RequestBody SysCodeVo sysCodeVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysCodeService.findSysCodeByCodeValue(sysCodeVo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 查询所有数据字典与值,并按照顺序排序
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/27 02:09:55
     */
    @RequestMapping(value = "findSysCodesByAll", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysCodesByAll(){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysCodeService.findSysCodesByAll()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   获取共通数据字典版本
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/27 04:10:56
     */
    @RequestMapping(value = "findCommonCodeValueVersion", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCommonCodeValueVersion(){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysCodeService.getCommonCodeValueVersion()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   获取共通数据字典的所有值
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/27 04:16:54
     */
    @RequestMapping(value = "findCommonCodeValuesAll", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCommonCodeValuesAll(){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysCodeService.getCommonCodeValuesAll()), HttpStatus.OK);
    }
    
    /**
     * @Title:  
     * @Description:   刷新数据字典
     * @return
     * @throws 
     * @author qiaomengnan 
     * @date 2018/04/03 10:36:59
     */
    @RequestMapping(value = "initCommonCodeValue", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> initCommonCodeValue(){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysCodeService.initCommonCodeValue()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   获取所有数据字典,key以codeType_codeValue拼接
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/27 04:16:54
     */
    @RequestMapping(value = "findCommonCodeValues", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCommonCodeValues(){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysCodeService.getCommonCodeValues()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   获取所有的数据字典,key为codeType,值为该codeType下的集合
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/03/27 03:53:30
     */
    @RequestMapping(value = "findCommonCodeValuesTree", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCommonCodeValuesTree(){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysCodeService.getCommonCodeValuesTree()), HttpStatus.OK);
    }

}
