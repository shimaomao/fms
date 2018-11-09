package cn.com.leadu.fms.webclient.system.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.systpltype.SysTplTypeVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author wubaoliang
 * @ClassName: SysTplTypeController
 * @Description: 模板类型管理rpc
 * @date 2018-03-12
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface SysTplTypeRpc {

    /**
     * @Title:
     * @Description: 分页查询模板类型管理信息
     * @param sysTplTypeVoMap
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    @RequestMapping(value = "api/system/sys_tpl_type/findSysTplTypesByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysTplTypesByPage(@RequestParam Map<String, Object> sysTplTypeVoMap);

    /**
     * @Title:
     * @Description: 保存模板类型管理
     * @param sysTplTypeVo
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    @RequestMapping(value = "api/system/sys_tpl_type/saveSysTplType",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveSysTplType(@RequestBody SysTplTypeVo sysTplTypeVo);

    /**
     * @Title:
     * @Description:  修改模板类型管理
     * @param sysTplTypeVo
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    @RequestMapping(value = "api/system/sys_tpl_type/modifySysTplType",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifySysTplType(@RequestBody SysTplTypeVo sysTplTypeVo);

    /**
     * @Title:
     * @Description:   根据tplTypeId集合删除模板类型管理
     * @param sysTplTypeVo
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    @RequestMapping(value = "api/system/sys_tpl_type/deleteSysTplTypesByTplTypeIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteSysTplTypesByTplTypeIds(@RequestBody SysTplTypeVo sysTplTypeVo);

    /**
     * @Title:
     * @Description:  根据tplTypeId获取模板类型管理
     * @param tplTypeId
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    @RequestMapping(value = "api/system/sys_tpl_type/findSysTplTypeVoByTplTypeId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysTplTypeVoByTplTypeId(@RequestParam("tplTypeId") String tplTypeId);

}
