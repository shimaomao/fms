package cn.com.leadu.fms.webclient.finance.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import cn.com.leadu.fms.webclient.finance.rpc.ContRepaySkedRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: ContRepaySkedController
 * @Description: 黑名单controller
 * @date 2018-05-08
 */
@RestController
@RequestMapping("cont_repay_sked")
public class ContRepaySkedController {

    /**
     * @Fields  : 黑名单rpc
     */
    @Autowired
    private ContRepaySkedRpc contRepaySkedRpc;

    /**
     * @Title:
     * @Description: 分页查询黑名单信息
     * @param contRepaySkedVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "findContRepaySkedsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepaySkedsByPage(ContRepaySkedVo contRepaySkedVo){
        Map contRepaySkedVoMap = contRepaySkedVo == null?null:(Map) JSON.toJSON(contRepaySkedVo);
        return contRepaySkedRpc.findContRepaySkedsByPage(contRepaySkedVoMap);
    }

    /**
     * @Title:
     * @Description: 分页查询勾稽明细信息
     * @param contRepaySkedVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "findContReceiptDetailsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContReceiptDetailsByPage(ContRepaySkedVo contRepaySkedVo){
        Map contRepaySkedVoMap = contRepaySkedVo == null?null:(Map) JSON.toJSON(contRepaySkedVo);
        return contRepaySkedRpc.findContReceiptDetailsByPage(contRepaySkedVoMap);
    }

    /**
     * @Title:
     * @Description: 分页查询已认领详情
     * @param contRepaySkedVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "findContRepaySkedClaimeByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepaySkedClaimeByPage(ContRepaySkedVo contRepaySkedVo){
        Map contRepaySkedVoMap = contRepaySkedVo == null?null:(Map) JSON.toJSON(contRepaySkedVo);
        return contRepaySkedRpc.findContRepaySkedClaimeByPage(contRepaySkedVoMap);
    }

    /**
     * @Title:
     * @Description: 保存黑名单
     * @param contRepaySkedVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "saveContRepaySked",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContRepaySked(@RequestBody ContRepaySkedVo contRepaySkedVo){
        return contRepaySkedRpc.saveContRepaySked(contRepaySkedVo);
    }

    /**
     * @Title:
     * @Description: 取消认领
     * @param contRepaySkedVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "cancelClaime",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> cancelClaime(@RequestBody ContRepaySkedVo contRepaySkedVo){
        return contRepaySkedRpc.cancelClaime(contRepaySkedVo);
    }

    /**
     * @Title:
     * @Description:  修改黑名单
     * @param contRepaySkedVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "modifyContRepaySked",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyContRepaySked(@RequestBody ContRepaySkedVo contRepaySkedVo){
        return contRepaySkedRpc.modifyContRepaySked(contRepaySkedVo);
    }

    /**
     * @Title:
     * @Description:   根据repaySkedId集合删除黑名单
     * @param repaySkedIds
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "deleteContRepaySkedsByRepaySkedIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteContRepaySkedsByRepaySkedIds(@RequestBody List<String> repaySkedIds){
        ContRepaySkedVo contRepaySkedVo = new ContRepaySkedVo();
        contRepaySkedVo.setRepaySkedIds(repaySkedIds);
        return contRepaySkedRpc.deleteContRepaySkedsByRepaySkedIds(contRepaySkedVo);
    }

    /**
     * @Title:
     * @Description:  根据repaySkedId获取黑名单
     * @param repaySkedId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "findContRepaySkedByRepaySkedId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepaySkedByRepaySkedId(String repaySkedId){
        return contRepaySkedRpc.findContRepaySkedByRepaySkedId(repaySkedId);
    }
    /**
     * @Title:
     * @Description:  测试逾期合同
     * @param
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "checkContRepaySked", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> checkContRepaySked(){
        return contRepaySkedRpc.checkContRepaySked();
    }

    /**
     * @Title:
     * @Description:  测试还款短信
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-14 11:11:36
     */
    @RequestMapping(value = "messageSend", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> messageSend(){
        return contRepaySkedRpc.messageSend();
    }


    /**
     * @Title:
     * @Description: 分页合同还款计划信息
     * @param contRepaySkedVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "findContRepaySkedDetailByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepaySkedDetailByPage(ContRepaySkedVo contRepaySkedVo){
        Map contRepaySkedVoMap = contRepaySkedVo == null?null:(Map) JSON.toJSON(contRepaySkedVo);
        return contRepaySkedRpc.findContRepaySkedDetailByPage(contRepaySkedVoMap);
    }

    /**
     * @Title:
     * @Description: 分页合同还款计划信息(导出用)
     * @param contRepaySkedVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "findContRepaySkedDetailExport" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepaySkedDetailExport(ContRepaySkedVo contRepaySkedVo){
        Map contRepaySkedVoMap = contRepaySkedVo == null?null:(Map) JSON.toJSON(contRepaySkedVo);
        return contRepaySkedRpc.findContRepaySkedDetailExport(contRepaySkedVoMap);
    }

    /**
     * @Title:
     * @Description: 未结清车辆租金明细表(导出用)
     * @param contRepaySkedVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "findContRepaySkedSettleExport" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepaySkedSettleExport(ContRepaySkedVo contRepaySkedVo){
        Map contRepaySkedVoMap = contRepaySkedVo == null?null:(Map) JSON.toJSON(contRepaySkedVo);
        return contRepaySkedRpc.findContRepaySkedSettleExport(contRepaySkedVoMap);
    }

    /**
     * @Title:
     * @Description: 结清车辆租金明细表(导出用)
     * @param contRepaySkedVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "findContRepaySkedSettleEndExport" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepaySkedSettleEndExport(ContRepaySkedVo contRepaySkedVo){
        Map contRepaySkedVoMap = contRepaySkedVo == null?null:(Map) JSON.toJSON(contRepaySkedVo);
        return contRepaySkedRpc.findContRepaySkedSettleEndExport(contRepaySkedVoMap);
    }

    /**
     * @Title:
     * @Description: 未收租金明细表(导出用)
     * @param contRepaySkedVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "findContRepaySkedUnpaidRentExport" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepaySkedUnpaidRentExport(ContRepaySkedVo contRepaySkedVo){
        Map contRepaySkedVoMap = contRepaySkedVo == null?null:(Map) JSON.toJSON(contRepaySkedVo);
        return contRepaySkedRpc.findContRepaySkedUnpaidRentExport(contRepaySkedVoMap);
    }

    /**
     * @Title:
     * @Description: 实收租金明细表(导出用)
     * @param contRepaySkedVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "findContRepaySkedPaidRentExport" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepaySkedPaidRentExport(ContRepaySkedVo contRepaySkedVo){
        Map contRepaySkedVoMap = contRepaySkedVo == null?null:(Map) JSON.toJSON(contRepaySkedVo);
        return contRepaySkedRpc.findContRepaySkedPaidRentExport(contRepaySkedVoMap);
    }

    /**
     * @Title:
     * @Description: 根据contReceiptExamId获取ContRepaySkedVo
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "findContReceiptDetailByContReceiptExamId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContReceiptDetailByContReceiptExamId(String contReceiptExamId){
        return contRepaySkedRpc.findContReceiptDetailByContReceiptExamId(contReceiptExamId);
    }

    /**
    * @Description: 勾稽页面手动生成凭证
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/11/2 16:00
    */
    @RequestMapping(value = "makeVoucher",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> makeVoucher(@RequestBody List<String> contReceiptExamIdList){
        return contRepaySkedRpc.makeVoucher(contReceiptExamIdList);
    }

    /**
     * @Title:
     * @Description: 开具发票
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "contReceiptDetailInvoice",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> contReceiptDetailInvoice(@RequestBody ContRepaySkedVo contRepaySkedVo){
        return contRepaySkedRpc.contReceiptDetailInvoice(contRepaySkedVo);
    }
}
