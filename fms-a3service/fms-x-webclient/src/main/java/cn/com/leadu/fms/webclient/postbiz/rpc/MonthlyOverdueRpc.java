package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceAuto;
import cn.com.leadu.fms.pojo.postbiz.vo.invoice.InvoiceVo;
import cn.com.leadu.fms.pojo.postbiz.vo.monthlyoverdue.MonthlyOverduesVo;
import feign.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author yangyiquan
 * @ClassName: MonthlyOverdueController
 * @Description: 开票信息rpc
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface MonthlyOverdueRpc {
    /**
     * @Title:
     * @Description: 分页查询逾期统计信息
     * @param monthlyOverduesVoMap
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @RequestMapping(value = "api/postbiz/monthly_overdue/findMonthlyOverduesVosByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findMonthlyOverduesVosByPage(@RequestParam Map<String,Object> monthlyOverduesVoMap);

    /**
     * @Title:
     * @Description:  模板出excel
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-11 11:43:20
     */
    @RequestMapping(value = "api/postbiz/monthly_overdue/excelExport", method = RequestMethod.GET)
    Response excelExport(@RequestParam Map<String, Object> paramsMap);

}
