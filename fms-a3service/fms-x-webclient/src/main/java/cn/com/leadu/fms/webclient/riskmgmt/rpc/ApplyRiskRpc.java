package cn.com.leadu.fms.webclient.riskmgmt.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.riskmgmt.vo.applyrisk.ApplyRiskVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditlist.PycreditListVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author liujinge
 * @ClassName: ApplyRiskRpc
 * @Description: 风控审批Rpc
 * @date 2018-06-4
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ApplyRiskRpc {

    /**
     * @Title:
     * @Description: 根据订单编号，获取初期风控数据
     * @param applyNo 订单编号
     * @return ApplyRiskVo
     * @throws
     * @author lijinge
     * @date 2018-6-4 20:18:12
     */
    @RequestMapping(value = "api/riskmgmt/apply_risk/findApplyRiskInit",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findApplyRiskInit(@RequestParam("applyNo") String applyNo,@RequestParam("flag") String flag);

    /** 
    * @Description: 保存风控数据
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/7 20:16
    */ 
    @RequestMapping(value = "api/riskmgmt/apply_risk/saveApplyRisk",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveApplyRisk(@RequestBody ApplyRiskVo applyRiskVo);

    /** 
    * @Description: 风控退回
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/23 14:19
    */ 
    @RequestMapping(value = "api/riskmgmt/apply_risk/backApplyRisk",method = RequestMethod.POST)
    ResponseEntity<RestResponse> backApplyRisk(@RequestBody ApplyRiskVo applyRiskVo);

    /**
     * @Description: 退回到业务员
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/23 14:19
     */
    @RequestMapping(value = "api/riskmgmt/apply_risk/backToApply",method = RequestMethod.POST)
    ResponseEntity<RestResponse> backToApply(ApplyRiskVo applyRiskVo);

    /**
     * @Description: 保存风控数据
     * @param:
     * @return:
     * @Author: yanggang
     * @Date: 2018/6/8 20:16
     */
    @RequestMapping(value = "api/riskmgmt/apply_risk/saveApplyRiskPyCredit",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveApplyRiskPyCredit(@RequestBody PycreditListVo pycreditListVo);

}
