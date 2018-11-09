package cn.com.leadu.fms.webclient.system.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.system.vo.systplitem.SysTplItemVo;
import cn.com.leadu.fms.webclient.system.rpc.SysTplItemRpc;
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
 * @ClassName: SysTplItemController
 * @Description: 模板可设项目管理controller
 * @date 2018-03-12
 */
@RestController
@RequestMapping("sys_tpl_item")
public class SysTplItemController {

    /**
     * @Fields  : 模板可设项目管理rpc
     */
    @Autowired
    private SysTplItemRpc sysTplItemRpc;

    /**
     * @Title:
     * @Description:  根据tplTypeKey获取模板可设项目信息
     * @param tplTypeKey
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:53:25
     */
    @RequestMapping(value = "findSysTplItemsByTplTypeKey", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysTplItemsByTplTypeKey(String tplTypeKey){
        return sysTplItemRpc.findSysTplItemsByTplTypeKey(tplTypeKey);
    }

}
