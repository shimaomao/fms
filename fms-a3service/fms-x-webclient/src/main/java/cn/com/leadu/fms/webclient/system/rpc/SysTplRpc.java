package cn.com.leadu.fms.webclient.system.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.systpl.SysTplVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author wubaoliang
 * @ClassName: SysTplController
 * @Description: 模板管理rpc
 * @date 2018-03-12
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface SysTplRpc {

    /**
     * @Title:
     * @Description: 分页查询模板管理信息
     * @param sysTplVo
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    @RequestMapping(value = "api/system/sys_tpl/findSysTplVosByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysTplVosByPage(@RequestParam Map<String, Object> sysTplVoMap);

    /**
     * @Title:
     * @Description: 保存模板管理
     * @param sysTplVo
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    @RequestMapping(value = "api/system/sys_tpl/saveSysTpl",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveSysTpl(@RequestBody SysTplVo sysTplVo);

    /**
     * @Title:
     * @Description:  修改模板管理
     * @param sysOrganizationPropertyVo
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    @RequestMapping(value = "api/system/sys_tpl/modifySysTpl",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifySysTpl(@RequestBody SysTplVo sysTplVo);

    /**
     * @Title:
     * @Description:   根据tplId集合删除模板管理
     * @param tplIds
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    @RequestMapping(value = "api/system/sys_tpl/deleteSysTplsByTplIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteSysTplsByTplIds(@RequestBody SysTplVo sysTplVo);

    /**
     * @Title:
     * @Description:  根据tplId获取模板管理
     * @param tplId
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    @RequestMapping(value = "api/system/sys_tpl/findSysTplVoByTplId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSysTplVoByTplId(@RequestParam("tplId") String tplId);

    @RequestMapping(value = "api/system/sys_tpl/importdatas", method = RequestMethod.GET)
    ResponseEntity<RestResponse> importdatas();
}
