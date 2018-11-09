package cn.com.leadu.fms.webclient.finance.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import cn.com.leadu.fms.pojo.finance.vo.finrepaysked.FinRepaySkedVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: FinRepaySkedController
 * @Description: 财务还款计划rpc
 * @date 2018-05-12
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface FinRepaySkedRpc {

    /**
     * @Title:
     * @Description: 分页查询财务还款计划信息
     * @param finRepaySkedVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @RequestMapping(value = "api/finance/fin_repay_sked/findFinRepaySkedsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findFinRepaySkedsByPage(@RequestParam Map<String, Object> finRepaySkedVoMap);

    /**
     * @Title:
     * @Description: 保存财务还款计划
     * @param finRepaySkedVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @RequestMapping(value = "api/finance/fin_repay_sked/saveFinRepaySked",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveFinRepaySked(@RequestBody FinRepaySkedVo finRepaySkedVo);

    /**
     * @Title:
     * @Description:  修改财务还款计划
     * @param finRepaySkedVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @RequestMapping(value = "api/finance/fin_repay_sked/modifyFinRepaySked",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyFinRepaySked(@RequestBody FinRepaySkedVo finRepaySkedVo);

    /**
     * @Title:
     * @Description:   根据finRepaySkedId集合删除财务还款计划
     * @param finRepaySkedVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @RequestMapping(value = "api/system/fin_repay_sked/deleteFinRepaySkedsByFinRepaySkedIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteFinRepaySkedsByFinRepaySkedIds(@RequestBody FinRepaySkedVo finRepaySkedVo);

    /**
     * @Title:
     * @Description:  根据finRepaySkedId获取财务还款计划
     * @param finRepaySkedId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    @RequestMapping(value = "api/finance/fin_repay_sked/findFinRepaySkedByFinRepaySkedId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findFinRepaySkedByFinRepaySkedId(@RequestParam("finRepaySkedId") String finRepaySkedId);

    /**
     * @Title:
     * @Description: 开具发票
     * @param contRepaySkedVos
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-8-21 16:40:57
     */
    @RequestMapping(value = "api/finance/fin_repay_sked/finRepaySkedInvoice",method = RequestMethod.POST)
    ResponseEntity<RestResponse> finRepaySkedInvoice(@RequestBody List<ContRepaySkedVo> contRepaySkedVos);

    /**
    * @Description: 批量修改开票属性
    * @param:
    * @return:
    * @Author: yangyiquan
    * @Date: 2018/9/25 11:47
    */
    @RequestMapping(value = "api/finance/fin_repay_sked/editInvoiceProp",method = RequestMethod.POST)
    ResponseEntity<RestResponse> editInvoiceProp(@RequestBody FinRepaySkedVo finRepaySkedVo);

}
