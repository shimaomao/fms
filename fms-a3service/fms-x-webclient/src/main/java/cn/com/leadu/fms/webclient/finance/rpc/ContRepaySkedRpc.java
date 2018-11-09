package cn.com.leadu.fms.webclient.finance.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: ContRepaySkedController
 * @Description: 黑名单rpc
 * @date 2018-05-08
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ContRepaySkedRpc {

    /**
     * @Title:
     * @Description: 分页查询黑名单信息
     * @param contRepaySkedVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "api/finance/cont_repay_sked/findContRepaySkedsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContRepaySkedsByPage(@RequestParam Map<String, Object> contRepaySkedVoMap);

    /**
     * @Title:
     * @Description: 分页查询勾稽明细信息
     * @param contRepaySkedVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "api/finance/cont_repay_sked/findContReceiptDetailsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContReceiptDetailsByPage(@RequestParam Map<String, Object> contRepaySkedVoMap);

    /**
     * @Title:
     * @Description: 分页查询已认领详情
     * @param contRepaySkedVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "api/finance/cont_repay_sked/findContRepaySkedClaimeByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContRepaySkedClaimeByPage(@RequestParam Map<String, Object> contRepaySkedVoMap);

    /**
     * @Title:
     * @Description: 保存黑名单
     * @param contRepaySkedVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "api/finance/cont_repay_sked/saveContRepaySked",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveContRepaySked(@RequestBody ContRepaySkedVo contRepaySkedVo);

    /**
     * @Title:
     * @Description: 取消认领
     * @param contRepaySkedVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "api/finance/cont_repay_sked/cancelClaime",method = RequestMethod.POST)
    ResponseEntity<RestResponse> cancelClaime(@RequestBody ContRepaySkedVo contRepaySkedVo);

    /**
     * @Title:
     * @Description:  修改黑名单
     * @param contRepaySkedVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "api/finance/cont_repay_sked/modifyContRepaySked",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyContRepaySked(@RequestBody ContRepaySkedVo contRepaySkedVo);

    /**
     * @Title:
     * @Description:   根据repaySkedId集合删除黑名单
     * @param contRepaySkedVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "api/system/cont_repay_sked/deleteContRepaySkedsByRepaySkedIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteContRepaySkedsByRepaySkedIds(@RequestBody ContRepaySkedVo contRepaySkedVo);

    /**
     * @Title:
     * @Description:  根据repaySkedId获取黑名单
     * @param repaySkedId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 11:11:36
     */
    @RequestMapping(value = "api/finance/cont_repay_sked/findContRepaySkedByRepaySkedId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContRepaySkedByRepaySkedId(@RequestParam("repaySkedId") String repaySkedId);

    @RequestMapping(value = "api/finance/cont_repay_sked/checkContRepaySked", method = RequestMethod.GET)
    ResponseEntity<RestResponse> checkContRepaySked();


    /**
     * @Title:
     * @Description: 还款短信发送
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-14 11:52:38
     */
    @RequestMapping(value = "api/postbiz/repay_msg_send/messageSend" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> messageSend();


    /**
     * @Title:
     * @Description: 分页合同还款计划信息
     * @param contRepaySkedVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-17 11:11:36
     */
    @RequestMapping(value = "api/finance/cont_repay_sked/findContRepaySkedDetailByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContRepaySkedDetailByPage(@RequestParam Map<String, Object> contRepaySkedVoMap);


    /**
     * @Title:
     * @Description: 分页合同还款计划信息(导出用)
     * @param contRepaySkedVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-17 11:11:36
     */
    @RequestMapping(value = "api/finance/cont_repay_sked/findContRepaySkedDetailExport" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContRepaySkedDetailExport(@RequestParam Map<String, Object> contRepaySkedVoMap);

    /**
     * @Title:
     * @Description: 未结清车辆租金明细表(导出用)
     * @param contRepaySkedVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-17 11:11:36
     */
    @RequestMapping(value = "api/finance/cont_repay_sked/findContRepaySkedSettleExport" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContRepaySkedSettleExport(@RequestParam Map<String, Object> contRepaySkedVoMap);

    /**
     * @Title:
     * @Description: 结清车辆租金明细表(导出用)
     * @param contRepaySkedVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-17 11:11:36
     */
    @RequestMapping(value = "api/finance/cont_repay_sked/findContRepaySkedSettleEndExport" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContRepaySkedSettleEndExport(@RequestParam Map<String, Object> contRepaySkedVoMap);

    /**
     * @Title:
     * @Description: 未收租金明细表(导出用)
     * @param contRepaySkedVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-17 11:11:36
     */
    @RequestMapping(value = "api/finance/cont_repay_sked/findContRepaySkedUnpaidRentExport" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContRepaySkedUnpaidRentExport(@RequestParam Map<String, Object> contRepaySkedVoMap);

    /**
     * @Title:
     * @Description: 实收租金明细表(导出用)
     * @param contRepaySkedVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-17 11:11:36
     */
    @RequestMapping(value = "api/finance/cont_repay_sked/findContRepaySkedPaidRentExport" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContRepaySkedPaidRentExport(@RequestParam Map<String, Object> contRepaySkedVoMap);

    /**
     * @Title:  
     * @Description: 根据contReceiptExamId获取ContRepaySkedVo
     * @param 
     * @return 
     * @throws 
     * @author yanfengbo 
     * @date 
     */
    @RequestMapping(value = "api/finance/cont_repay_sked/findContReceiptDetailByContReceiptExamId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContReceiptDetailByContReceiptExamId(@RequestParam("contReceiptExamId") String contReceiptExamId);

    /**
    * @Description: 勾稽页面手动生成凭证
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/11/2 16:07
    */
    @RequestMapping(value = "api/finance/cont_repay_sked/makeVoucher",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> makeVoucher(@RequestBody List<String> contReceiptExamIdList);

    /**
     * @Title:
     * @Description: 开具发票
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/finance/cont_repay_sked/contReceiptDetailInvoice",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> contReceiptDetailInvoice(@RequestBody ContRepaySkedVo contRepaySkedVo);
}
