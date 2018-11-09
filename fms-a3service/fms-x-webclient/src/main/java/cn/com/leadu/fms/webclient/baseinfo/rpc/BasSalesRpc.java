package cn.com.leadu.fms.webclient.baseinfo.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.bassales.BasSalesVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author yanfengbo
 * @ClassName: BasSalesController
 * @Description: 实际销售方rpc
 * @date 2018-05-03
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface BasSalesRpc {

    /**
     * @Title:
     * @Description: 分页查询实际销售方信息
     * @param basSalesVoMap
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @RequestMapping(value = "api/baseinfo/bas_sales/findBasSalessByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasSalessByPage(@RequestParam Map<String, Object> basSalesVoMap);

    /**
     * @Title:
     * @Description: 保存实际销售方
     * @param basSalesVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @RequestMapping(value = "api/baseinfo/bas_sales/saveBasSales",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveBasSales(@RequestBody BasSalesVo basSalesVo);

    /**
     * @Title:
     * @Description:  修改实际销售方
     * @param basSalesVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @RequestMapping(value = "api/baseinfo/bas_sales/modifyBasSales",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyBasSales(@RequestBody BasSalesVo basSalesVo);

    /**
     * @Title:
     * @Description:   根据salesId集合删除实际销售方
     * @param basSalesVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @RequestMapping(value = "api/baseinfo/bas_sales/deleteBasSalessBySalesIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteBasSalessBySalesIds(@RequestBody BasSalesVo basSalesVo);

    /**
     * @Title:
     * @Description:  根据salesId获取实际销售方
     * @param salesId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-3 11:23:02
     */
    @RequestMapping(value = "api/baseinfo/bas_sales/findBasSalesBySalesId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasSalesBySalesId(@RequestParam("salesId") String salesId,@RequestParam("serviceId") String serviceId);

    /**
     * @Title:
     * @Description: 实际销售方审核通过
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/baseinfo/bas_sales/approval" ,method = RequestMethod.PUT)
    ResponseEntity<RestResponse> approval(@RequestBody BasSalesVo basSalesVo);

    /**
     * @Title:
     * @Description: 实际销售方审核退回
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/baseinfo/bas_sales/sendBack" ,method = RequestMethod.PUT)
    ResponseEntity<RestResponse> sendBack(@RequestBody BasSalesVo basSalesVo);

}
