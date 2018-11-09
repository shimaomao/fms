package cn.com.leadu.fms.baseinfo.rpc.system;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.sysgroupparent.SysGroupParentVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author wangxue
 * @ClassName: SysGroupController
 * @Description: 用户组管理rpc
 * @date 2018-03-10
 */
@FeignClient("${fms.feigns.serverNames.fmsSystem}")
public interface SysGroupParentRpc {
    /**
     * @Title:
     * @Description: 保存用户组关系
     * @param sysGroupParentVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-29 17:39:58
     */
    @RequestMapping(value = "sys_group_parent/saveSysGroupParent",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveSysGroupParent(@RequestBody SysGroupParentVo sysGroupParentVo);

    /**
     * @Title:
     * @Description: 保存用户组关系
     * @param groupCode
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-29 17:39:58
     */
    @RequestMapping(value = "sys_group_parent/deleteSysGroupParentByGroupCode",method = RequestMethod.POST)
    ResponseEntity<RestResponse> deleteSysGroupParentByGroupCode(String groupCode);
   }
