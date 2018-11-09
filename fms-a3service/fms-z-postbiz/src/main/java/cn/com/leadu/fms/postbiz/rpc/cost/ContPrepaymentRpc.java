package cn.com.leadu.fms.postbiz.rpc.cost;/**
 * Created by ningyangyang on 2018/9/27.
 */

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.cost.vo.contprepayment.ContPrepaymentVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @Title: fms
 * @Description:  提前还款rpc
 * @author: ningyangyang
 * @date 2018/9/27 16:41
 */
@FeignClient("${fms.feigns.serverNames.fmsCost}")
public interface ContPrepaymentRpc {
    /**
     * @Title:
     * @Description:根据合同编号查询提前还款和提前还款明细信息
     * @return
     * @throws
     * @author liujinge
     * @date 2018-4-12 13:35:32
     */
    @RequestMapping(value = "cont_prepayment/findContPrepaymentWithDetailByContNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse<ContPrepaymentVo>> findContPrepaymentWithDetailByContNo(@RequestParam("contNo") String contNo);

}
