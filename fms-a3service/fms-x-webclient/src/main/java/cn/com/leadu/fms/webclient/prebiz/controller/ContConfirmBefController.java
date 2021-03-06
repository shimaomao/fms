package cn.com.leadu.fms.webclient.prebiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.contconfirmbef.ContConfirmBefVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.ContConfirmBefRpc;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author liujinge
 * @ClassName: ContractController
 * @Description: 合同生成前确认controller
 * @date 2018-03-23
 */
@RestController
@RequestMapping("cont_confirm_bef")
public class ContConfirmBefController {

    /**
     * @Fields  : 合同生成前确认rpc
     */
    @Autowired
    private ContConfirmBefRpc contConfirmBefRpc;

    /**
     * @Title:
     * @Description: 合同生成前确认
     * @param contConfirmBefVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "confirm",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> confirm(@RequestBody ContConfirmBefVo contConfirmBefVo){
        return contConfirmBefRpc.confirm(contConfirmBefVo);
    }

    /**
    * @Description: 退回到申请
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/9/15 14:50
    */
    @RequestMapping(value = "returnDealer",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> returnDealer(@RequestBody ContConfirmBefVo contConfirmBefVo){
        return contConfirmBefRpc.returnDealer(contConfirmBefVo);
    }

}
