package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.continsurance.ContInsuranceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contrequestpay.ContRequestPayVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author huchenghao
 * @ClassName: ContInsurance
 * @Description: rpc
 * @date 2018-03-15
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ContRequestPayRpc {

    /**
     * @Title:
     * @Description: 提交
     * @param contRequestPayVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-15 16:20:27
     */
    @RequestMapping(value = "api/prebiz/cont_request_pay/submitContRequestPay",method = RequestMethod.POST)
    ResponseEntity<RestResponse> submitContRequestPay(@RequestBody ContRequestPayVo contRequestPayVo);
    /**
     * @Title:
     * @Description: 退回
     * @param contRequestPayVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-15 16:20:27
     */
    @RequestMapping(value = "api/prebiz/cont_request_pay/sendBack",method = RequestMethod.POST)
    ResponseEntity<RestResponse> sendBack(@RequestBody ContRequestPayVo contRequestPayVo);

    /**
     * @Title:
     * @Description: 暂存
     * @param contRequestPayVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-15 16:20:27
     */
    @RequestMapping(value = "api/prebiz/cont_request_pay/saveContRequestPay",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveContRequestPay(@RequestBody ContRequestPayVo contRequestPayVo);
    /**
     * @Title:
     * @Description: 保存
     * @param contNo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-15 16:20:27
     */
    @RequestMapping(value = "api/prebiz/cont_request_pay/findWorkflowLogList",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findWorkflowLogList(@RequestParam("contNo")String contNo);

    /**
     * @Title:
     * @Description: 根据合同号查询车辆保险信息
     * @param contNo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-15 16:20:27
     */
    @RequestMapping(value = "api/prebiz/cont_request_pay/findContRequestPayByContNo",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContRequestPayByContNo(@RequestParam("contNo")String contNo);
    /**
     * @Title:
     * @Description: 查询请款附件类型tree
     * @param
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-28 16:20:27
     */
    @RequestMapping(value = "api/prebiz/cont_request_pay/applicationFilesTree",method = RequestMethod.GET)
    ResponseEntity<RestResponse> applicationFilesTree();




}
