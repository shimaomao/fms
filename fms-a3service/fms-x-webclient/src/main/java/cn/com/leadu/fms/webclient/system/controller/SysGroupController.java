package cn.com.leadu.fms.webclient.system.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.sysgroup.SysGroupVo;
import cn.com.leadu.fms.webclient.system.rpc.SysGroupRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * @author wangxue
 * @ClassName: SysGroupController
 * @Description: 用户组管理controller
 * @date 2018-03-10
 */
@RestController
@RequestMapping("sys_group")
public class SysGroupController {

    /**
     * @Fields  : 用户组管理rpc
     */
    @Autowired
    private SysGroupRpc sysGroupRpc;

    /**
     * @Title:
     * @Description: 分页查询用户组管理信息
     * @param sysGroupVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @RequestMapping(value = "findSysGroupVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysGroupVosByPage(SysGroupVo sysGroupVo){
        Map sysGroupVoMap = sysGroupVo == null?null:(Map) JSON.toJSON(sysGroupVo);
        return sysGroupRpc.findSysGroupVosByPage(sysGroupVoMap);
    }

    /**
     * @Title:
     * @Description: 分页查询用户组管理信息
     * @param sysGroupVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @RequestMapping(value = "findSysGroupVoListByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysGroupVoListByPage(SysGroupVo sysGroupVo){
        Map sysGroupVoMap = sysGroupVo == null?null:(Map) JSON.toJSON(sysGroupVo);
        return sysGroupRpc.findSysGroupVoListByPage(sysGroupVoMap);
    }
    /**
     * @Title:
     * @Description: 保存用户组管理
     * @param sysGroupVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @RequestMapping(value = "saveSysGroup",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysGroup(@RequestBody SysGroupVo sysGroupVo){
        return sysGroupRpc.saveSysGroup(sysGroupVo);
    }

    /**
     * @Title:
     * @Description:  修改用户组管理
     * @param sysGroupVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @RequestMapping(value = "modifySysGroup",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysGroup(@RequestBody SysGroupVo sysGroupVo){
        return sysGroupRpc.modifySysGroup(sysGroupVo);
    }

    /**
     * @Title:
     * @Description:   根据groupId集合删除用户组管理
     * @param groupIds
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @RequestMapping(value = "deleteSysGroupsByGroupIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysGroupsByGroupIds(@RequestBody List<String> groupIds){
        SysGroupVo sysGroupVo = new SysGroupVo();
        sysGroupVo.setGroupIds(groupIds);
        return sysGroupRpc.deleteSysGroupsByGroupIds(sysGroupVo);
    }

    /**
     * @Title:
     * @Description:  根据groupId获取用户组管理
     * @param groupId
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @RequestMapping(value = "findSysGroupVoByGroupId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysGroupVoByGroupId(String groupId){
        return sysGroupRpc.findSysGroupVoByGroupId(groupId);
    }

    /**
     * @Title:
     * @Description:  查询用户组信息树
     * @param parentType
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @RequestMapping(value = "findSysGroupByTree", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysGroupByTree(String parentType, String groupCode){
        return sysGroupRpc.findSysGroupByTree(parentType, groupCode);
    }

    /**
     * @Title:
     * @Description:  查询用户组信息树
     * @param groupCode
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-10 17:39:58
     */
    @RequestMapping(value = "selectSysGroupVoByGroupCode", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> selectSysGroupVoByGroupCode(String groupCode){
        return sysGroupRpc.selectSysGroupVoByGroupCode(groupCode);
    }

}
