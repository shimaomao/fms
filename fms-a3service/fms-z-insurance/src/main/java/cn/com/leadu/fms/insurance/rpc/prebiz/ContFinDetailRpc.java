package cn.com.leadu.fms.insurance.rpc.prebiz;/**
 * Created by ningyangyang on 2018/6/8.
 */

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.entity.ContFinDetail;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @Title: fms
 * @Description:
 * @author: ningyangyang
 * @date 2018/6/8 14:14
 */
@FeignClient("${fms.feigns.serverNames.fmsPreBiz}")
public interface ContFinDetailRpc {

    /**
     * @Title:
     * @Description: 根据合同号查询合同费用融资明细
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 10:14:21
     */
    @RequestMapping(value = "cont_fin_detail/findContFinDetailsByContNo" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse<List<ContFinDetail>>> findContFinDetailsByContNo(@RequestParam("contNo") String contNo);


}
