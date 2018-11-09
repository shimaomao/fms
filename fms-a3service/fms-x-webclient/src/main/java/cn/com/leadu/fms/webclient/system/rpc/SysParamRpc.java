package cn.com.leadu.fms.webclient.system.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.sysparam.SysParamVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author yanfengbo
 * @ClassName: SysParamController
 * @Description: 系统常量表rpc
 * @date 2018-03-09
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface SysParamRpc {

    /**
     * @Title:
     * @Description: 分页查询系统常量表信息
     * @param sysParamVoMap
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @RequestMapping(value = "api/system/sys_param/findSysParamByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysParamByPage(@RequestParam Map<String, Object> sysParamVoMap);

    /**
     * @Title:
     * @Description: 保存系统常量表
     * @param sysParamVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @RequestMapping(value = "api/system/sys_param/saveSysParam",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveSysParam(@RequestBody SysParamVo sysParamVo);

    /**
     * @Title:
     * @Description:  修改系统常量表
     * @param sysParamVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @RequestMapping(value = "api/system/sys_param/modifySysParam",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifySysParam(@RequestBody SysParamVo sysParamVo);

    /**
     * @Title:
     * @Description:  根据paramKeyId获取系统常量表
     * @param paramKeyId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @RequestMapping(value = "api/system/sys_param/findSysParamByParamKeyId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysParamByParamKeyId(@RequestParam("paramKeyId") String paramKeyId);

    /**
     * @Title:
     * @Description:   根据paramKeyId集合删除系统常量表
     * @param sysParamVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-9 11:03:53
     */
    @RequestMapping(value = "api/system/sys_param/deleteSysParamByParamKeyIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteSysParamByParamKeyIds(@RequestBody SysParamVo sysParamVo);

    /**
     * @Title:
     * @Description:   初始化系统常量值到redis中
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 09:19:43
     */
    @RequestMapping(value = "api/system/sys_param/initSysParamsValue", method = RequestMethod.GET)
    ResponseEntity<RestResponse> initSysParamsValue();

    /**
     * @Title:
     * @Description:   获取系统常量
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 09:31:03
     */
    @RequestMapping(value = "api/system/sys_param/findSysParamsValue", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysParamsValue();

    /**
     * @Title:
     * @Description:   返回常量版本值
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/20 09:49:12
     */
    @RequestMapping(value = "api/system/sys_param/findSysParamsValueVersion", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysParamsValueVersion();

}
