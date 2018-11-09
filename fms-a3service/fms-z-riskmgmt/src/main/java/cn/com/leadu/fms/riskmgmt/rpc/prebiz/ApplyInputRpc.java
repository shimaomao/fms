package cn.com.leadu.fms.riskmgmt.rpc.prebiz;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.riskmgmt.vo.applyrisk.ApplyRiskVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author niehaibing
 * @ClassName: ProductController
 * @Description: 产品方案管理rpc
 * @date 2018-03-23
 */
@FeignClient("${fms.feigns.serverNames.fmsPreBiz}")
public interface ApplyInputRpc {

    /**
     * @Title:
     * @Description:  根据applyNo取得申请录入信息
     * @param applyNo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 16:18:12
     */
    @RequestMapping(value = "apply_input/findApplyInputRiskByApplyNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse<ApplyRiskVo>> findApplyInputRiskByApplyNo(@RequestParam("applyNo") String applyNo,@RequestParam("flag") String flag);

    /**
     * @Title:
     * @Description:  根据applyNo取得承租人变更信息
     * @param applyNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-9-13 16:18:12
     */
    @RequestMapping(value = "change_lessee_task/findApplyInputRiskByTaskNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse<ApplyRiskVo>> findApplyInputRiskByTaskNo(@RequestParam("applyNo") String applyNo);
}
