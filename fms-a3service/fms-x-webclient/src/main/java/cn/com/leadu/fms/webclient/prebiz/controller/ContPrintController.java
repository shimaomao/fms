package cn.com.leadu.fms.webclient.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.contprint.ContPrintVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.ContPrintRpc;
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
@RequestMapping("cont_print")
public class ContPrintController {

    /**
     * @Fields  : 订单风控审批rpc
     */
    @Autowired
    private ContPrintRpc contPrintRpc;

    /**
     * @Title:
     * @Description: 订单风控审批同意
     * @param contPrintVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "print",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> approval(@RequestBody ContPrintVo contPrintVo){
        return contPrintRpc.print(contPrintVo);
    }

    /**
     * @Title:
     * @Description: 订单风控审批同意
     * @param contPrintVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "sendBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> sendBack(@RequestBody ContPrintVo contPrintVo){
        return contPrintRpc.sendBack(contPrintVo);
    }

    /**
     * @Title:
     * @Description: 合同打印初始化加载文件列表
     * @param contNo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "getContPrintFileList",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> getContPrintFileList(String contNo){
        return contPrintRpc.getContPrintFileList(contNo);
    }
}
