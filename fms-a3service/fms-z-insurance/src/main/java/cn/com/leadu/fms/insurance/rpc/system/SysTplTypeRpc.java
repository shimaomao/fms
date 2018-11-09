package cn.com.leadu.fms.insurance.rpc.system;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.entity.SysTplType;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:  模板rpc
 * @author:ningyangyang
 * @since:2018/5/14
 */
@FeignClient("${fms.feigns.serverNames.fmsSystem}")
public interface SysTplTypeRpc {
    /**
     * @Title:
     * @Description:  根据tplTypeKey获取模板类型管理
     * @param tplTypeKey
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-12 14:38:40
     */
    @RequestMapping(value = "sys_tpl_type/findSysTplTypeByTplTypeKey", method = RequestMethod.GET)
     ResponseEntity<RestResponse<SysTplType>> findSysTplTypeByTplTypeKey(@RequestParam("tplTypeKey") String tplTypeKey);
}
