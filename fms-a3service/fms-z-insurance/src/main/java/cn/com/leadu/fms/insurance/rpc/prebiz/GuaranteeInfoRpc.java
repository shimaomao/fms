package cn.com.leadu.fms.insurance.rpc.prebiz;/**
 * Created by ningyangyang on 2018/6/8.
 */

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.entity.GuaranteeComp;
import cn.com.leadu.fms.pojo.prebiz.entity.GuaranteePers;
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
 * @date 2018/6/8 14:00
 */
@FeignClient("${fms.feigns.serverNames.fmsPreBiz}")
public interface GuaranteeInfoRpc {

    /**
     * @Title:
     * @Description: 根据申请编号查询担保人信息
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 10:14:21
     */
    @RequestMapping(value = "guarantee_pers/findGuaranteePersByApplyNo" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse<List<GuaranteePers>>> findGuaranteePersByApplyNo(@RequestParam("applyNo") String applyNo);

    /**
     * @Title:
     * @Description: 根据申请编号查询担保企业信息
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-26 10:14:21
     */
    @RequestMapping(value = "guarantee_comp/findGuaranteeCompByApplyNo" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse<List<GuaranteeComp>>> findGuaranteeCompByApplyNo(@RequestParam("applyNo") String applyNo);

}
