package cn.com.leadu.fms.cost.rpc.finance;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepaySked;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @description:  合同融资还款计划
 * @author:ningyangyang
 * @since:2018/5/11
 */
@FeignClient("${fms.feigns.serverNames.fmsFinance}")
public interface ContRepaySkedRpc {

    /**
     * @Title:
     * @Description: 分页查询黑名单信息
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "cont_repay_sked/findContRepaySkedByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse<List<ContRepaySked>>> findContRepaySkedsByPage(@RequestParam Map<String, Object> contRepaySkedVoMap);

    /**
     * @Description: 根据合同编号查询融资合同还款信息 ，还款时间小于当前时间且倒序排序的第一个
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/11 17:07
     */
    @RequestMapping(value = "cont_repay_sked/findContRepaySkedByContNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse<ContRepaySked>> findContRepaySkedByContNo(@RequestParam("contNo") String contNo);

    /**
    * @Description: 查询逾期租金合计
    * @param:
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/14 10:33
    */ 
    @RequestMapping(value = "cont_repay_sked/findContRepaySkedOverdueRentSum", method = RequestMethod.GET)
    ResponseEntity<RestResponse<BigDecimal>> findContRepaySkedOverdueRentSum(@RequestParam("contNo") String contNo);

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
