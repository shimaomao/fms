package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.sechandinventory.SecHandInventoryVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.SecHandInventoryRpc;
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
 * @author qinmuqiao
 * @ClassName: SecHandInventoryController
 * @Description: 库存管理controller
 */
@RestController
@RequestMapping("sec_hand_inventory")
public class SecHandInventoryController {

    /**
     * @Fields  : 库存管理rpc
     */
    @Autowired
    private SecHandInventoryRpc secHandInventoryRpc;

    /**
     * @Title:
     * @Description: 分页查询库存管理信息
     * @param secHandInventoryVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-19 14:16:21
     */
    @RequestMapping(value = "findSecHandInventoryVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSecHandInventoryVosByPage(SecHandInventoryVo secHandInventoryVo){
        Map secHandInventoryVoMap = secHandInventoryVo == null?null:(Map) JSON.toJSON(secHandInventoryVo);
        return secHandInventoryRpc.findSecHandInventoryVosByPage(secHandInventoryVoMap);
    }

    /**
     * @Title:
     * @Description: 保存库存管理
     * @param secHandInventoryVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-19 14:16:21
     */
    @RequestMapping(value = "saveSecHandInventory",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveSecHandInventory(@RequestBody SecHandInventoryVo secHandInventoryVo){
        return secHandInventoryRpc.saveSecHandInventory(secHandInventoryVo);
    }

    /**
     * @Title:
     * @Description:  修改库存管理
     * @param secHandInventoryVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-19 14:16:21
     */
    @RequestMapping(value = "modifySecHandInventory",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifySecHandInventory(@RequestBody SecHandInventoryVo secHandInventoryVo){
        return secHandInventoryRpc.modifySecHandInventory(secHandInventoryVo);
    }


    /**
     * @Title:
     * @Description:  根据secHandId获取库存管理
     * @param secHandId
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-19 14:16:21
     */
    @RequestMapping(value = "findSecHandInventoryVoBySecHandId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSecHandInventoryVoBySecHandId(String secHandId){
        return secHandInventoryRpc.findSecHandInventoryVoBySecHandId(secHandId);
    }

}
