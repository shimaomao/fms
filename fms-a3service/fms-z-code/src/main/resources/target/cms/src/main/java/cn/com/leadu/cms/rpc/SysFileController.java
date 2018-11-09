package cn.com.leadu.fms.webclient.system.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.sysfile.SysFileVo;
import cn.com.leadu.fms.webclient.system.rpc.SysFileRpc;
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
 * @ClassName: SysFileController
 * @Description: 菜单controller
 * @date 2018-03-05
 */
@RestController
@RequestMapping("sys_file")
public class SysFileController {

    @Autowired
    private SysFileRpc sysFileRpc;

    /**
     * @Title:
     * @Description: 分页查询菜单信息
     * @param sysFileVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    @RequestMapping(value = "findSysFileByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysOrganizationPropertyByPage(SysFileVo sysFileVo){
        Map sysFileVoMap = sysFileVo == null?null:(Map) JSON.toJSON(sysFileVo);
        return sysFileRpc.findSysFileByPage(sysFileVoMap);
    }

    /**
     * @Title:
     * @Description: 保存菜单
     * @param sysFileVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    @RequestMapping(value = "saveSysFile",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysFile(@RequestBody SysFileVo sysFileVo){
        return sysFileRpc.saveSysFile(sysFileVo);
    }

    /**
     * @Title:
     * @Description:  修改菜单
     * @param sysOrganizationPropertyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    @RequestMapping(value = "modifySysFile",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysFile(@RequestBody SysFileVo sysFileVo){
        return sysFileRpc.modifySysFile(sysFileVo);
    }

    /**
     * @Title:
     * @Description:  根据id获取菜单
     * @param id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    @RequestMapping(value = "findSysFileById", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysFileById(String id){
        return sysFileRpc.findSysFileById(id);
    }

    /**
     * @Title:
     * @Description:   根据id集合删除菜单
     * @param ids
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-5 15:17:52
     */
    @RequestMapping(value = "deleteSysFileByIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysFileByIds(@RequestBody List<String> ids){
        SysFileVo sysFileVo = new SysFileVo();
        sysFileVo.setIds(ids);
        return sysFileRpc.deleteSysFileByIds(sysFileVo);
    }

}
