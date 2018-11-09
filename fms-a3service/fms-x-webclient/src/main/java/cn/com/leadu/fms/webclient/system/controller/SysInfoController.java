package cn.com.leadu.fms.webclient.system.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.sysinfo.SysInfoVo;
import cn.com.leadu.fms.webclient.system.rpc.SysInfoRpc;
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
 * @author qiaomengnan
 * @ClassName: SysInfoController
 * @Description: 消息管理controller
 * @date 2018-04-25
 */
@RestController
@RequestMapping("sys_info")
public class SysInfoController {

    /**
     * @Fields  : 消息管理rpc
     */
    @Autowired
    private SysInfoRpc sysInfoRpc;

    /**
     * @Title:
     * @Description: 分页查询消息管理信息
     * @param sysInfoVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @RequestMapping(value = "findSysInfosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysInfosByPage(SysInfoVo sysInfoVo){
        Map sysInfoVoMap = sysInfoVo == null?null:(Map) JSON.toJSON(sysInfoVo);
        return sysInfoRpc.findSysInfosByPage(sysInfoVoMap);
    }

    /**
     * @Title:
     * @Description: 保存消息管理
     * @param sysInfoVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @RequestMapping(value = "saveSysInfo",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysInfo(@RequestBody SysInfoVo sysInfoVo){
        return sysInfoRpc.saveSysInfo(sysInfoVo);
    }

    /**
     * @Title:
     * @Description:  修改消息管理
     * @param sysInfoVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @RequestMapping(value = "modifySysInfo",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysInfo(@RequestBody SysInfoVo sysInfoVo){
        return sysInfoRpc.modifySysInfo(sysInfoVo);
    }

    /**
     * @Title:
     * @Description:   根据infoId集合删除消息管理
     * @param infoIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @RequestMapping(value = "deleteSysInfosByInfoIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysInfosByInfoIds(@RequestBody List<String> infoIds){
        SysInfoVo sysInfoVo = new SysInfoVo();
        sysInfoVo.setInfoIds(infoIds);
        return sysInfoRpc.deleteSysInfosByInfoIds(sysInfoVo);
    }

    /**
     * @Title:
     * @Description:  根据infoId获取消息管理
     * @param infoId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-4-25 14:01:54
     */
    @RequestMapping(value = "findSysInfoByInfoId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysInfoByInfoId(String infoId){
        return sysInfoRpc.findSysInfoByInfoId(infoId);
    }

}
