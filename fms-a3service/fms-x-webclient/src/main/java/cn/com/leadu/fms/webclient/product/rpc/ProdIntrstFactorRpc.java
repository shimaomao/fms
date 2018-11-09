package cn.com.leadu.fms.webclient.product.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.product.vo.prodintrstfactor.ProdIntrstFactorVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author niehaibing
 * @ClassName: ProdIntrstFactorController
 * @Description: 产品利率rpc
 * @date 2018-03-27
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ProdIntrstFactorRpc {

    /**
     * @Title:
     * @Description: 分页查询产品利率信息
     * @param prodIntrstFactorVoMap
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:28
     */
    @RequestMapping(value = "api/product/prod_intrst_factor/findProdIntrstFactorsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findProdIntrstFactorsByPage(@RequestParam Map<String, Object> prodIntrstFactorVoMap);

    /**
     * @Title:
     * @Description: 保存产品利率
     * @param prodIntrstFactorVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:28
     */
    @RequestMapping(value = "api/product/prod_intrst_factor/saveProdIntrstFactor",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveProdIntrstFactor(@RequestBody ProdIntrstFactorVo prodIntrstFactorVo);

    /**
     * @Title:
     * @Description:  修改产品利率
     * @param sysOrganizationPropertyVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:28
     */
    @RequestMapping(value = "api/product/prod_intrst_factor/modifyProdIntrstFactor",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyProdIntrstFactor(@RequestBody ProdIntrstFactorVo prodIntrstFactorVo);

    /**
     * @Title:
     * @Description:   根据prodIntrstFactorId集合删除产品利率
     * @param prodIntrstFactorIds
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:28
     */
    @RequestMapping(value = "api/system/prod_intrst_factor/deleteProdIntrstFactorsByProdIntrstFactorIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteProdIntrstFactorsByProdIntrstFactorIds(@RequestBody ProdIntrstFactorVo prodIntrstFactorVo);

    /**
     * @Title:
     * @Description:  根据prodIntrstFactorId获取产品利率
     * @param prodIntrstFactorId
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 11:45:28
     */
    @RequestMapping(value = "api/product/prod_intrst_factor/findProdIntrstFactorByProdIntrstFactorId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findProdIntrstFactorByProdIntrstFactorId(@RequestParam("prodIntrstFactorId") String prodIntrstFactorId);

}
