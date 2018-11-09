package cn.com.leadu.fms.webclient.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.applyapprove.ApplyApproveVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.ApplyApproveRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liujinge
 * @ClassName: ApplyApproveController
 * @Description: 区域经理审核controller
 * @date 2018-03-23
 */
@RestController
@RequestMapping("apply_approve")
public class ApplyApproveController {

    /**
     * @Fields  : 订单风控审批rpc
     */
    @Autowired
    private ApplyApproveRpc applyApproveRpc;

    /**
     * @Title:
     * @Description: 区域经理审批通过
     * @param applyApproveVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "approval",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> approval(@RequestBody ApplyApproveVo applyApproveVo){
        return applyApproveRpc.approval(applyApproveVo);
    }


    /**
     * @Title:
     * @Description: 合同生成前确认
     * @param applyApproveVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "refuse",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> refuse(@RequestBody ApplyApproveVo applyApproveVo){
        return applyApproveRpc.refuse(applyApproveVo);
    }

    /**
     * @Title:
     * @Description: 区域经理审批退回
     * @param applyApproveVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "sendBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> sendBack(@RequestBody ApplyApproveVo applyApproveVo){
        return applyApproveRpc.sendBack(applyApproveVo);
    }

    /**
     * @Title:
     * @Description: 合同生成前确认
     * @param applyApproveVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "sendBackTop",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> sendBackTop(@RequestBody ApplyApproveVo applyApproveVo){
        return applyApproveRpc.sendBackTop(applyApproveVo);
    }

    /**
     * @Title:
     * @Description: 根据订单编号，获取附件信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author qiaomengnan
     * @date 2018-3-29 20:18:12
     */
    @RequestMapping(value = "findBizFileByApplyNo",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBizFileByApplyNo(String applyNo){
        return applyApproveRpc.findBizFileByApplyNo(applyNo);
    }

}
