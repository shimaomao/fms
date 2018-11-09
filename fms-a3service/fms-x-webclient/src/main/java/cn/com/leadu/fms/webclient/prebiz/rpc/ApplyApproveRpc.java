package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.applyapprove.ApplyApproveVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liujinge
 * @ClassName: ApplyApproveRpc
 * @Description: 区域经理审核rpc
 * @date 2018-03-23
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ApplyApproveRpc {

    /**
     * @Title:
     * @Description: 区域经理审批通过
     * @param applyApproveVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "api/prebiz/apply_approve/approval",method = RequestMethod.POST)
    ResponseEntity<RestResponse> approval(@RequestBody ApplyApproveVo applyApproveVo);

    /**
     * @Title:
     * @Description: 合同生成前确认
     * @param applyApproveVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "api/prebiz/apply_approve/refuse",method = RequestMethod.POST)
    ResponseEntity<RestResponse> refuse(@RequestBody ApplyApproveVo applyApproveVo);

    /**
     * @Title:
     * @Description: 区域经理审批退回
     * @param applyApproveVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "api/prebiz/apply_approve/sendBack",method = RequestMethod.POST)
    ResponseEntity<RestResponse> sendBack(@RequestBody ApplyApproveVo applyApproveVo);

    /**
     * @Title:
     * @Description: 合同生成前确认
     * @param applyApproveVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "api/prebiz/apply_approve/sendBackTop",method = RequestMethod.POST)
    ResponseEntity<RestResponse> sendBackTop(@RequestBody ApplyApproveVo applyApproveVo);

    /**
     * @Title:
     * @Description: 根据订单编号，获取附件信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author qiaomengnan
     * @date 2018-3-29 20:18:12
     */
    @RequestMapping(value = "api/prebiz/apply_approve/findBizFileByApplyNo",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBizFileByApplyNo(@RequestParam("applyNo") String applyNo);

}
