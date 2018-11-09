package cn.com.leadu.fms.prebiz.rpc.finance;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepaySked;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;

/**
 * @description:  合同融资还款计划
 * @author: yangyiquan
 * @since: 2018/6/15
 */
@FeignClient("${fms.feigns.serverNames.fmsFinance}")
public interface ContRepaySkedRpc {

    /**
     * @Description: 查询逾期租金合计
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/15 14:46
     */
    @RequestMapping(value = "cont_repay_sked/findContRepaySkedRentSum", method = RequestMethod.GET)
    ResponseEntity<RestResponse<BigDecimal>> findContRepaySkedRentSum(@RequestParam("contNo") String contNo);

    /**
     * @Description: 根据合同号查询所有还款计划表，按期数由小到大排序
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/28 20:36
     */
    @RequestMapping(value = "cont_repay_sked/findAllContRepaySkedByContNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse<List<ContRepaySked>>> findAllContRepaySkedByContNo(@RequestParam("contNo") String contNo);
}
