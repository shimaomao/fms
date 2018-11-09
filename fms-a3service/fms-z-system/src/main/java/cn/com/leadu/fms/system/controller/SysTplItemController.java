package cn.com.leadu.fms.system.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.system.service.SysTplItemService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author wubaoliang
 * @ClassName: SysTplItemController
 * @Description: 模板可设项目管理相关接口
 * @date 2018-03-12
 */
@RestController
@RequestMapping("sys_tpl_item")
public class SysTplItemController {

    /**
     * @Fields  : 模板可设项目管理service
     */
    @Autowired
    private SysTplItemService sysTplItemService;

    /**
     * @Title:
     * @Description:  根据tplTypeKey获取模板类型的可设置项目
     * @param tplTypeKey
     * @return
     * @throws
     * @author wubaoliang
     * @date 2018-3-12 14:53:25
     */
    @RequestMapping(value = "findSysTplItemsByTplTypeKey", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysTplItemsByTplTypeKey(String tplTypeKey){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(sysTplItemService.findSysTplItemListByTplTypeKey(tplTypeKey)), HttpStatus.OK);
    }

}
