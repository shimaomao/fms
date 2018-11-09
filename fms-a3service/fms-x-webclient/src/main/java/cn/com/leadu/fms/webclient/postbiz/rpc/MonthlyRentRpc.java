package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import feign.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;


/**
 * @author qinmuqiao
 * @ClassName: AnnualInspectionController
 * @Description: 月租到账率rpc
 */

@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface MonthlyRentRpc {


    /**
     * @Title:
     * @Description: 分页查询月租到账率
     * @param monthlyRentVoMap
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @RequestMapping(value = "api/postbiz/monthly_rent/findMonthlyRentsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findMonthlyRentsByPage(@RequestParam Map<String,Object> monthlyRentVoMap);


    /**
     * @Title:
     * @Description:  模板出excel
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-11 11:43:20
     */
    @RequestMapping(value = "api/postbiz/monthly_rent/excelExport", method = RequestMethod.GET)
    Response excelExport(@RequestParam("monthlyRentId") String monthlyRentId);
}
