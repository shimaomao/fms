package cn.com.leadu.fms.webclient.system.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.vo.sysparam.SysParamVo;
import cn.com.leadu.fms.webclient.system.rpc.SysParamRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * @author yanfengbo
 * @ClassName: SysParamController
 * @Description: 系统常量表controller
 * @date 2018-03-09
 */
@RestController
@RequestMapping("sys_param")
public class SysParamController {

    @Autowired
    private SysParamRpc sysParamRpc;

    /**
     * @Title:
     * @Description: 分页查询系统常量表信息
     * @param sysParamVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @RequestMapping(value = "findSysParamByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysParamByPage(SysParamVo sysParamVo){
        Map sysParamVoMap = sysParamVo == null?null:(Map) JSON.toJSON(sysParamVo);
        return sysParamRpc.findSysParamByPage(sysParamVoMap);
    }

    /**
     * @Title:
     * @Description: 保存系统常量表
     * @param sysParamVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @RequestMapping(value = "saveSysParam",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysParam(@RequestBody SysParamVo sysParamVo){
        return sysParamRpc.saveSysParam(sysParamVo);
    }

    /**
     * @Title:
     * @Description:  修改系统常量表
     * @param sysParamVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @RequestMapping(value = "modifySysParam",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysParam(@RequestBody SysParamVo sysParamVo){
        return sysParamRpc.modifySysParam(sysParamVo);
    }

    /**
     * @Title:
     * @Description:  根据paramKeyId获取系统常量表
     * @param paramKeyId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @RequestMapping(value = "findSysParamByParamKeyId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysParamByParamKeyId(String paramKeyId){
        return sysParamRpc.findSysParamByParamKeyId(paramKeyId);
    }

    /**
     * @Title:
     * @Description:   根据paramKeyId集合删除系统常量表
     * @param paramKeyIds
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @RequestMapping(value = "deleteSysParamByParamKeyIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysParamByParamKeyIds(@RequestBody List<String> paramKeyIds){
        SysParamVo sysParamVo = new SysParamVo();
        sysParamVo.setParamKeyIds(paramKeyIds);
        return sysParamRpc.deleteSysParamByParamKeyIds(sysParamVo);
    }

    /**
     * @Title:
     * @Description:   初始化系统常量值
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 09:19:43
     */
    @RequestMapping(value = "initSysParamsValue", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> initSysParamsValue(){
        return sysParamRpc.initSysParamsValue();
    }

    /**
     * @Title:
     * @Description:   获取系统常量
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 09:31:03
     */
    @RequestMapping(value = "findSysParamsValue", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysParamsValue(){
        return sysParamRpc.findSysParamsValue();
    }

    /**
     * @Title:
     * @Description:   返回常量版本值
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 09:49:12
     */
    @RequestMapping(value = "findSysParamsValueVersion", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysParamsValueVersion(){
        return sysParamRpc.findSysParamsValueVersion();
    }

}
