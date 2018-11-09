package cn.com.leadu.fms.webclient.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.continspect.ContInspectVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.ContInspectRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liujinge
 * @ClassName: ApplyApproveController
 * @Description: 订单风控审批controller
 * @date 2018-03-23
 */
@RestController
@RequestMapping("cont_inspect")
public class ContInspectController {

    /**
     * @Fields  : 订单风控审批rpc
     */
    @Autowired
    private ContInspectRpc contInspectRpc;

    /**
     * @Title:
     * @Description: 订单风控审批同意
     * @param contInspectVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "approval",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> approval(@RequestBody ContInspectVo contInspectVo){
        return contInspectRpc.approval(contInspectVo);
    }

    /**
     * @Title:
     * @Description: 退回
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "sendBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> sendBack(@RequestBody ContInspectVo contInspectVo){
        return contInspectRpc.sendBack(contInspectVo);
    }
}
