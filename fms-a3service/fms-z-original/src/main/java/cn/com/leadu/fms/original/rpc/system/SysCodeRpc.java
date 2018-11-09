package cn.com.leadu.fms.original.rpc.system;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.entity.SysCode;
import cn.com.leadu.fms.pojo.system.vo.syscode.SysCodeVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @description:  数据字典rpc
 * @author:ningyangyang
 * @since:2018/5/10
 */
@FeignClient("${fms.feigns.serverNames.fmsSystem}")
public interface SysCodeRpc {
    /**
     * @Title:
     * @Description: 根据codeValue和codeType查询
     * @param sysCodeVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-9 13:46:54
     */
    @RequestMapping(value = "sys_code/findSysCodesByPage" ,method = RequestMethod.GET)
     ResponseEntity<RestResponse<PageInfoExtend<SysCode>>> findSysCodesByPage(@RequestParam Map<String, Object> sysCodeVoMap);
}
