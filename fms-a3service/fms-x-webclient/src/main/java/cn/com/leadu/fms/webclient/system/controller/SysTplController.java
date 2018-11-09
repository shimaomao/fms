package cn.com.leadu.fms.webclient.system.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.systpl.SysTplVo;
import cn.com.leadu.fms.webclient.system.rpc.SysTplRpc;
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
 * @author wubaoliang
 * @ClassName: SysTplController
 * @Description: 模板管理controller
 * @date 2018-03-12
 */
@RestController
@RequestMapping("sys_tpl")
public class SysTplController {

    /**
     * @Fields  : 模板管理rpc
     */
    @Autowired
    private SysTplRpc sysTplRpc;

    /**
     * @Title:
     * @Description: 分页查询模板管理信息
     * @param sysTplVo
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    @RequestMapping(value = "findSysTplVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysTplVosByPage(SysTplVo sysTplVo){
        Map sysTplVoMap = sysTplVo == null?null:(Map) JSON.toJSON(sysTplVo);
        return sysTplRpc.findSysTplVosByPage(sysTplVoMap);
    }

    /**
     * @Title:
     * @Description: 保存模板管理
     * @param sysTplVo
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    @RequestMapping(value = "saveSysTpl",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysTpl(@RequestBody SysTplVo sysTplVo){
        return sysTplRpc.saveSysTpl(sysTplVo);
    }

    /**
     * @Title:
     * @Description:  修改模板管理
     * @param sysTplVo
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    @RequestMapping(value = "modifySysTpl",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysTpl(@RequestBody SysTplVo sysTplVo){
        return sysTplRpc.modifySysTpl(sysTplVo);
    }

    /**
     * @Title:
     * @Description:   根据tplId集合删除模板管理
     * @param tplIds
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    @RequestMapping(value = "deleteSysTplsByTplIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysTplsByTplIds(@RequestBody List<String> tplIds){
        SysTplVo sysTplVo = new SysTplVo();
        sysTplVo.setTplIds(tplIds);
        return sysTplRpc.deleteSysTplsByTplIds(sysTplVo);
    }

    /**
     * @Title:
     * @Description:  根据tplId获取模板管理
     * @param tplId
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 15:16:19
     */
    @RequestMapping(value = "findSysTplVoByTplId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysTplVoByTplId(String tplId){
        return sysTplRpc.findSysTplVoByTplId(tplId);
    }

    /**
     * @Title:
     * @Description:   导入收款明细
     * @param
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/11 11:51:40
     */
    @RequestMapping(value = "importdatas", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> importdatas(){
        return sysTplRpc.importdatas();
    }

}
