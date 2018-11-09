package cn.com.leadu.fms.webclient.system.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.systpltype.SysTplTypeVo;
import cn.com.leadu.fms.webclient.system.rpc.SysTplTypeRpc;
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
 * @ClassName: SysTplTypeController
 * @Description: 模板类型管理controller
 * @date 2018-03-12
 */
@RestController
@RequestMapping("sys_tpl_type")
public class SysTplTypeController {

    /**
     * @Fields  : 模板类型管理rpc
     */
    @Autowired
    private SysTplTypeRpc sysTplTypeRpc;

    /**
     * @Title:
     * @Description: 分页查询模板类型管理信息
     * @param sysTplTypeVo
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    @RequestMapping(value = "findSysTplTypesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysTplTypesByPage(SysTplTypeVo sysTplTypeVo){
        Map sysTplTypeVoMap = sysTplTypeVo == null?null:(Map) JSON.toJSON(sysTplTypeVo);
        return sysTplTypeRpc.findSysTplTypesByPage(sysTplTypeVoMap);
    }

    /**
     * @Title:
     * @Description: 保存模板类型管理
     * @param sysTplTypeVo
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    @RequestMapping(value = "saveSysTplType",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSysTplType(@RequestBody SysTplTypeVo sysTplTypeVo){
        return sysTplTypeRpc.saveSysTplType(sysTplTypeVo);
    }

    /**
     * @Title:
     * @Description:  修改模板类型管理
     * @param sysTplTypeVo
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    @RequestMapping(value = "modifySysTplType",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySysTplType(@RequestBody SysTplTypeVo sysTplTypeVo){
        return sysTplTypeRpc.modifySysTplType(sysTplTypeVo);
    }

    /**
     * @Title:
     * @Description:   根据tplTypeId集合删除模板类型管理
     * @param tplTypeIds
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    @RequestMapping(value = "deleteSysTplTypesByTplTypeIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteSysTplTypesByTplTypeIds(@RequestBody List<String> tplTypeIds){
        SysTplTypeVo sysTplTypeVo = new SysTplTypeVo();
        sysTplTypeVo.setTplTypeIds(tplTypeIds);
        return sysTplTypeRpc.deleteSysTplTypesByTplTypeIds(sysTplTypeVo);
    }

    /**
     * @Title:
     * @Description:  根据tplTypeId获取模板类型管理
     * @param tplTypeId
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:38:41
     */
    @RequestMapping(value = "findSysTplTypeVoByTplTypeId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysTplTypeVoByTplTypeId(String tplTypeId){
        return sysTplTypeRpc.findSysTplTypeVoByTplTypeId(tplTypeId);
    }

}
