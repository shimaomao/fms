package cn.com.leadu.fms.webclient.product.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.product.vo.prodintrst.ProdIntrstVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author niehaibing
 * @ClassName: ProdIntrstController
 * @Description: 产品利率rpc
 * @date 2018-03-27
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ProdIntrstRpc {

    /**
     * @Title:
     * @Description: 分页查询产品利率信息
     * @param prodIntrstVoMap
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @RequestMapping(value = "api/product/prod_intrst/findProdIntrstsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findProdIntrstsByPage(@RequestParam Map<String, Object> prodIntrstVoMap);

    /**
     * @Title:
     * @Description: 保存产品利率
     * @param prodIntrstVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @RequestMapping(value = "api/product/prod_intrst/saveProdIntrst",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveProdIntrst(@RequestBody ProdIntrstVo prodIntrstVo);

    /**
     * @Title:
     * @Description:  修改产品利率
     * @param sysOrganizationPropertyVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @RequestMapping(value = "api/product/prod_intrst/modifyProdIntrst",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyProdIntrst(@RequestBody ProdIntrstVo prodIntrstVo);

    /**
     * @Title:
     * @Description:   根据prodIntrstId集合删除产品利率
     * @param prodIntrstIds
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @RequestMapping(value = "api/system/prod_intrst/deleteProdIntrstsByProdIntrstIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteProdIntrstsByProdIntrstIds(@RequestBody ProdIntrstVo prodIntrstVo);

    /**
     * @Title:
     * @Description:  根据prodIntrstId获取产品利率
     * @param prodIntrstId
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:46:27
     */
    @RequestMapping(value = "api/product/prod_intrst/findProdIntrstByProdIntrstId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findProdIntrstByProdIntrstId(@RequestParam("prodIntrstId") String prodIntrstId);

}
