package cn.com.leadu.fms.original.rpc.system;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.vo.sysgroup.SysGroupVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * @description: 用户管理rpc
 * @author:ningyangyang
 * @since:2018/5/3
 */
@FeignClient("${fms.feigns.serverNames.fmsSystem}")
public interface SysGroupRpc {
    /**
     * @Title:
     * @Description: 分页查询用户组管理信息Vo
     * @param
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:57
     */
    @RequestMapping(value = "sys_group/findSysGroupVosByPage" ,method = RequestMethod.GET)
     ResponseEntity<RestResponse<PageInfoExtend<SysGroupVo>>> findSysGroupVosByPage();
}
