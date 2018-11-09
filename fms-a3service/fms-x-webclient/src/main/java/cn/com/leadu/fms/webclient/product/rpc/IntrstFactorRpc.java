package cn.com.leadu.fms.webclient.product.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.product.vo.intrstfactor.IntrstFactorVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author niehaibing
 * @ClassName: IntrstFactorController
 * @Description: 利率因子rpc
 * @date 2018-03-27
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface IntrstFactorRpc {

    /**
     * @Title:
     * @Description: 分页查询利率因子信息
     * @param intrstFactorVoMap
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    @RequestMapping(value = "api/product/intrst_factor/findIntrstFactorsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findIntrstFactorsByPage(@RequestParam Map<String, Object> intrstFactorVoMap);

    /**
     * @Title:
     * @Description: 保存利率因子
     * @param intrstFactorVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    @RequestMapping(value = "api/product/intrst_factor/saveIntrstFactor",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveIntrstFactor(@RequestBody IntrstFactorVo intrstFactorVo);

    /**
     * @Title:
     * @Description:  修改利率因子
     * @param intrstFactorVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    @RequestMapping(value = "api/product/intrst_factor/modifyIntrstFactor",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyIntrstFactor(@RequestBody IntrstFactorVo intrstFactorVo);

    /**
     * @Title:
     * @Description:   根据intrstFactorId集合删除利率因子
     * @param intrstFactorVo
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    @RequestMapping(value = "api/product/intrst_factor/deleteIntrstFactorsByIntrstFactorIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteIntrstFactorsByIntrstFactorIds(@RequestBody IntrstFactorVo intrstFactorVo);

    /**
     * @Title:
     * @Description:  根据intrstFactorId获取利率因子
     * @param intrstFactorId
     * @return
     * @throws
     * @author niehaibing
     * @date 2018-3-27 20:08:11
     */
    @RequestMapping(value = "api/product/intrst_factor/findIntrstFactorByIntrstFactorId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findIntrstFactorByIntrstFactorId(@RequestParam("intrstFactorId") String intrstFactorId);


    /**
     * @Title:
     * @Description: 取得全部启用的利率因子
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-27 18:07:17
     */
    @RequestMapping(value = "api/product/intrst_factor/findIntrstFactorAllList" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findIntrstFactorAllList();

}
