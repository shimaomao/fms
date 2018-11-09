package cn.com.leadu.fms.webclient.finance.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import java.util.Map;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;


/**
 * @author yebangqiang
 * @ClassName: FinancialPrebizContPayDetailRpc
 * @Description:
 * @date 2018-07-19
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface FinancialPrebizContPayDetailRpc {

    /**
     * @Title:
     * @Description: 分页查询贷前财务付款清单一览信息
     * @param contPayVoMap
     * @return
     * @throws
     * @author yebangqiang
     * @date
     */
    @RequestMapping(value = "api/finance/prebiz_cont_pay_detail/findFinancialPrebizContPayDetailByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findFinancialPrebizContPayDetailByPage(@RequestParam Map<String, Object> contPayVoMap);

    /**
     * @Title:
     * @Description: 分页查询贷前财务付款清单汇总一览信息
     * @param contPayVoMap
     * @return
     * @throws
     * @author yebangqiang
     * @date
     */
    @RequestMapping(value = "api/finance/prebiz_cont_pay_detail/findContPayInfoByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContPayInfoByPage(@RequestParam Map<String, Object> contPayVoMap);

}
