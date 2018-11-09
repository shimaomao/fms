package cn.com.leadu.fms.webclient.product.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.product.vo.finitem.FinItemVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author niehaibing
 * @ClassName: FinItemController
 * @Description: 融资项目管理rpc
 * @date 2018-03-19
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface FinItemRpc {

    /**
     * @Title:
     * @Description: 分页查询融资项目管理信息
     * @param finItemVoMap
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @RequestMapping(value = "api/product/fin_item/findFinItemsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findFinItemsByPage(@RequestParam Map<String, Object> finItemVoMap);

    /**
     * @Title:
     * @Description: 保存融资项目管理
     * @param finItemVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @RequestMapping(value = "api/product/fin_item/saveFinItem",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveFinItem(@RequestBody FinItemVo finItemVo);

    /**
     * @Title:
     * @Description:  修改融资项目管理
     * @param finItemVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @RequestMapping(value = "api/product/fin_item/modifyFinItem",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyFinItem(@RequestBody FinItemVo finItemVo);

    /**
     * @Title:
     * @Description:   根据finItemId集合删除融资项目管理
     * @param finItemVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @RequestMapping(value = "api/product/fin_item/deleteFinItemsByFinItemIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteFinItemsByFinItemIds(@RequestBody FinItemVo finItemVo);

    /**
     * @Title:
     * @Description:  根据finItemId获取融资项目管理
     * @param finItemId
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @RequestMapping(value = "api/product/fin_item/findFinItemByFinItemId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findFinItemByFinItemId(@RequestParam("finItemId") String finItemId);

    /**
     * @Title:
     * @Description:  根据finItemId获取融资项目管理
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-19 11:03:18
     */
    @RequestMapping(value = "api/product/fin_item/findAllFinItemList", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findAllFinItemList();

}
