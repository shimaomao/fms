package cn.com.leadu.fms.webclient.system.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.sysmenuclicks.SysMenuClicksVo;
import cn.com.leadu.fms.webclient.system.rpc.SysMenuClicksRpc;
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
 * @author lijunjun
 * @ClassName: SysMenuClicksController
 * @Description: 利率因子controller
 * @date 2018-05-03
 */
@RestController
@RequestMapping("sys_menu_clicks")
public class SysMenuClicksController {

    /**
     * @Fields  : 利率因子rpc
     */
    @Autowired
    private SysMenuClicksRpc sysMenuClicksRpc;

    /**
     * @Title:
     * @Description: 分页查询利率因子信息
     * @param sysMenuClicksVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    @RequestMapping(value = "findSysMenuClickssByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysMenuClickssByPage(SysMenuClicksVo sysMenuClicksVo){
        Map sysMenuClicksVoMap = sysMenuClicksVo == null?null:(Map) JSON.toJSON(sysMenuClicksVo);
        return sysMenuClicksRpc.findSysMenuClickssByPage(sysMenuClicksVoMap);
    }

    /**
     * @Title:
     * @Description: 分页查询利率因子信息
     * @param sysMenuClicksVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    @RequestMapping(value = "findSysMenuClicksByUser" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysMenuClicksByUser(SysMenuClicksVo sysMenuClicksVo){
        Map sysMenuClicksVoMap = sysMenuClicksVo == null?null:(Map) JSON.toJSON(sysMenuClicksVo);
        return sysMenuClicksRpc.findSysMenuClicksByUser(sysMenuClicksVoMap);
    }

    /**
     * @Title:
     * @Description: 保存利率因子
     * @param sysMenuClicksVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    @RequestMapping(value = "saveSysMenuClicks",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysMenuClicks(@RequestBody SysMenuClicksVo sysMenuClicksVo){
        return sysMenuClicksRpc.saveSysMenuClicks(sysMenuClicksVo);
    }

    /**
     * @Title:
     * @Description:  修改利率因子
     * @param sysMenuClicksVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    @RequestMapping(value = "modifySysMenuClicks",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysMenuClicks(@RequestBody SysMenuClicksVo sysMenuClicksVo){
        return sysMenuClicksRpc.modifySysMenuClicks(sysMenuClicksVo);
    }

    /**
     * @Title:
     * @Description:   根据menuClicksId集合删除利率因子
     * @param menuClicksIds
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    @RequestMapping(value = "deleteSysMenuClickssByMenuClicksIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysMenuClickssByMenuClicksIds(@RequestBody List<String> menuClicksIds){
        SysMenuClicksVo sysMenuClicksVo = new SysMenuClicksVo();
        sysMenuClicksVo.setMenuClicksIds(menuClicksIds);
        return sysMenuClicksRpc.deleteSysMenuClickssByMenuClicksIds(sysMenuClicksVo);
    }

    /**
     * @Title:
     * @Description:  根据menuClicksId获取利率因子
     * @param menuClicksId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 18:09:17
     */
    @RequestMapping(value = "findSysMenuClicksByMenuClicksId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysMenuClicksByMenuClicksId(String menuClicksId){
        return sysMenuClicksRpc.findSysMenuClicksByMenuClicksId(menuClicksId);
    }

}
