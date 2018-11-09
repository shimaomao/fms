package cn.com.leadu.fms.baseinfo.rpc.system;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.sysgroup.SysGroupVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * @author huchenghao
 * @ClassName: SysGroupController
 * @Description: 用户组管理rpc
 * @date 2018-03-10
 */
@FeignClient("${fms.feigns.serverNames.fmsSystem}")
public interface SysGroupRpc {

    /**
     * @Title:
     * @Description: 得到经销商保存情况
     * @param sysGroupVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-3 17:39:58
     */
    @RequestMapping(value = "sys_group/getBasPartnerStatus" ,method = RequestMethod.PUT)
    ResponseEntity<RestResponse<String>> getBasPartnerStatus(@RequestBody SysGroupVo sysGroupVo);

    /**
     * @Title:
     * @Description:  修改用户组管理
     * @param sysGroupVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-29 17:39:58
     */
    @RequestMapping(value = "sys_group/modifySysGroup",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifySysGroup(@RequestBody SysGroupVo sysGroupVo);


    /**
     * @Title:
     * @Description: 保存用户组管理
     * @param sysGroupVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-29 17:39:58
     */
    @RequestMapping(value = "sys_group/saveSysGroup",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveSysGroup(@RequestBody SysGroupVo sysGroupVo);

}
