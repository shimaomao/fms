package cn.com.leadu.fms.webclient.system.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.sysgrouplevel.SysGroupLevelVo;
import cn.com.leadu.fms.webclient.system.rpc.SysGroupLevelRpc;
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
 * @ClassName: SysGroupLevelController
 * @Description: 用户组层级controller
 * @date 2018-03-08
 */
@RestController
@RequestMapping("sys_group_level")
public class SysGroupLevelController {

    @Autowired
    private SysGroupLevelRpc sysGroupLevelRpc;

    /**
     * @Title:
     * @Description: 分页查询用户组层级信息
     * @param sysGroupLevelVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    @RequestMapping(value = "findSysGroupLevelsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysGroupLevelsByPage(SysGroupLevelVo sysGroupLevelVo){
        Map sysGroupLevelVoMap = sysGroupLevelVo == null?null:(Map) JSON.toJSON(sysGroupLevelVo);
        return sysGroupLevelRpc.findSysGroupLevelsByPage(sysGroupLevelVoMap);
    }

    /**
     * @Title:
     * @Description: 保存用户组层级
     * @param sysGroupLevelVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    @RequestMapping(value = "saveSysGroupLevel",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysGroupLevel(@RequestBody SysGroupLevelVo sysGroupLevelVo){
        return sysGroupLevelRpc.saveSysGroupLevel(sysGroupLevelVo);
    }

    /**
     * @Title:
     * @Description:  修改用户组层级
     * @param sysGroupLevelVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    @RequestMapping(value = "modifySysGroupLevel",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysGroupLevel(@RequestBody SysGroupLevelVo sysGroupLevelVo){
        return sysGroupLevelRpc.modifySysGroupLevel(sysGroupLevelVo);
    }

    /**
     * @Title:
     * @Description:  根据层级id，获取用户组层级
     * @param groupLevId
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    @RequestMapping(value = "findSysGroupLevelById", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysGroupLevelById(String groupLevId){
        return sysGroupLevelRpc.findSysGroupLevelById(groupLevId);
    }

    /**
     * @Title:
     * @Description:   根据层级id集合，删除用户组层级
     * @param groupLevIds
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-8 14:36:07
     */
    @RequestMapping(value = "deleteSysGroupLevelsByIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysGroupLevelsByIds(@RequestBody List<String> groupLevIds){
        SysGroupLevelVo sysGroupLevelVo = new SysGroupLevelVo();
        sysGroupLevelVo.setGroupLevIds(groupLevIds);
        return sysGroupLevelRpc.deleteSysGroupLevelsByIds(sysGroupLevelVo);
    }

}
