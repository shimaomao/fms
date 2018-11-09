package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.sechandinventory.SecHandInventoryVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author qinmuqiao
 * @ClassName: SecHandInventoryController
 * @Description: 库存管理rpc
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface SecHandInventoryRpc {

    /**
     * @Title:
     * @Description: 分页查询库存管理信息
     * @param secHandInventoryVoMap
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-19 14:16:21
     */
    @RequestMapping(value = "api/postbiz/sec_hand_inventory/findSecHandInventoryVosByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSecHandInventoryVosByPage(@RequestParam Map<String,Object> secHandInventoryVoMap);

    /**
     * @Title:
     * @Description: 保存库存管理
     * @param secHandInventoryVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-19 14:16:21
     */
    @RequestMapping(value = "api/postbiz/sec_hand_inventory/saveSecHandInventory",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveSecHandInventory(@RequestBody SecHandInventoryVo secHandInventoryVo);

    /**
     * @Title:
     * @Description:  修改库存管理
     * @param secHandInventoryVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-19 14:16:21
     */
    @RequestMapping(value = "api/postbiz/sec_hand_inventory/modifySecHandInventory",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifySecHandInventory(@RequestBody SecHandInventoryVo secHandInventoryVo);

    /**
     * @Title:
     * @Description:  根据secHandId获取库存管理
     * @param secHandId
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-19 14:16:21
     */
    @RequestMapping(value = "api/postbiz/sec_hand_inventory/findSecHandInventoryVoBySecHandId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findSecHandInventoryVoBySecHandId(@RequestParam("secHandId") String secHandId);

}
