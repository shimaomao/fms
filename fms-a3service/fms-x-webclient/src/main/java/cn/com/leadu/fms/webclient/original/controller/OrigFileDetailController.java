package cn.com.leadu.fms.webclient.original.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.original.vo.borrowbacktask.BorrowBackTaskVo;
import cn.com.leadu.fms.pojo.original.vo.borrowtask.BorrowTaskVo;
import cn.com.leadu.fms.pojo.original.vo.origfile.OrigFileVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileBorrowFinanceVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileBorrowTaskVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileDetailVo;
import cn.com.leadu.fms.webclient.original.rpc.OrigFileDetailRpc;
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
 * @author ningyangyang
 * @ClassName: OrigFileDetailController
 * @Description: 资料邮寄附件明细controller
 * @date 2018-05-03
 */
@RestController
@RequestMapping("orig_file_detail")
public class OrigFileDetailController {

    /**
     * @Fields  : 资料邮寄附件明细rpc
     */
    @Autowired
    private OrigFileDetailRpc origFileDetailRpc;

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件明细信息
     * @param origFileDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "findOrigFileDetailsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileDetailsByPage(OrigFileDetailVo origFileDetailVo) {
        Map origFileDetailVoMap = origFileDetailVo == null ? null : (Map) JSON.toJSON(origFileDetailVo);
        return origFileDetailRpc.findOrigFileDetailsByPage(origFileDetailVoMap);
    }

    /**
     * @Title:
     * @Description: 根据借阅任务号查询资料邮寄附件明细信息
     * @param borrowTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "findOrigFileBorrowMailByBorrowTaskNo" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileBorrowMailByBorrowTaskNo(String borrowTaskNo) {
        return origFileDetailRpc.findOrigFileBorrowMailByBorrowTaskNo(borrowTaskNo);
    }

    /**
     * @Title:
     * @Description: 根据借阅任务号查询资料邮寄附件明细信息（借阅归还）
     * @param borrowTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "findOrigFileBorrowBackMailByBorrowTaskNo" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileBorrowBackMailByBorrowTaskNo(String borrowTaskNo) {
        return origFileDetailRpc.findOrigFileBorrowBackMailByBorrowTaskNo(borrowTaskNo);
    }

    /**
     * @Title:
     * @Description: 根据借阅归还任务号查询资料邮寄附件明细信息
     * @param borrowBackTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "findOrigFileBorrowMailByBorrowBackTaskNo" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileBorrowMailByBorrowBackTaskNo(String borrowBackTaskNo) {
        return origFileDetailRpc.findOrigFileBorrowMailByBorrowBackTaskNo(borrowBackTaskNo);
    }

    /**
     * @Title:
     * @Description: 根据借阅归还任务号查询资料邮寄附件明细信息（借阅归还资管复核明细）
     * @param borrowBackTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "findOrigFileBorrowExamineByBorrowBackTaskNo" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileBorrowExamineByBorrowBackTaskNo(String borrowBackTaskNo) {
        return origFileDetailRpc.findOrigFileBorrowExamineByBorrowBackTaskNo(borrowBackTaskNo);
    }

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件明细信息
     * @param origFileDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "findOrigFileDetailByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileDetailByPage(OrigFileDetailVo origFileDetailVo) {
        Map origFileDetailVoMap = origFileDetailVo == null ? null : (Map) JSON.toJSON(origFileDetailVo);
        return origFileDetailRpc.findOrigFileDetailByPage(origFileDetailVoMap);
    }

    /**
     * @Title:
     * @Description: 查询资料邮寄附件明细信息（原件借阅）
     * @param origFileDetailVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "findOrigFileBorrowDetails" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileBorrowDetails(OrigFileDetailVo origFileDetailVo) {
        Map origFileDetailVoMap = origFileDetailVo == null ? null : (Map) JSON.toJSON(origFileDetailVo);
        return origFileDetailRpc.findOrigFileBorrowDetails(origFileDetailVoMap);
    }

    /** 
    * @Description: 根据资料邮寄业务号,资料邮寄业务类型查询所有邮寄附件明细信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/22 15:57
    */ 
    @RequestMapping(value = "findOrigFileDetailByExample" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileDetailByExample(String bizCode,String bizCodeType) {
        return origFileDetailRpc.findOrigFileDetailByExample(bizCode,bizCodeType);
    }

    /**
    * @Description: 查询资料回寄信息一览
    * @param: origFileVo
    * @return:
    * @Author: lijunjun
    * @Date: 2018/5/22 15:57
    */
    @RequestMapping(value = "findOrigFileBorrowBackSendByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileBorrowBackSendByPage(OrigFileVo origFileVo) {
        Map origFileVoMap = origFileVo == null ? null : (Map) JSON.toJSON(origFileVo);
        return origFileDetailRpc.findOrigFileBorrowBackSendByPage(origFileVoMap);
    }

    /**
     * @Title:
     * @Description: 保存资料邮寄附件明细
     * @param origFileDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "saveOrigFileDetail",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveOrigFileDetail(@RequestBody OrigFileDetailVo origFileDetailVo){
        return origFileDetailRpc.saveOrigFileDetail(origFileDetailVo);
    }

    /**
     * @Title:
     * @Description: 借阅提交
     * @param origFileBorrowTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "borrowTask",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> borrowTask(@RequestBody OrigFileBorrowTaskVo origFileBorrowTaskVo){
        return origFileDetailRpc.borrowTask(origFileBorrowTaskVo);
    }

    /**
     * @Title:
     * @Description: 借阅提交取消
     * @param origFileBorrowTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "cancelOrigFileBorrow",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> cancelOrigFileBorrow(@RequestBody OrigFileBorrowTaskVo origFileBorrowTaskVo){
        return origFileDetailRpc.cancelOrigFileBorrow(origFileBorrowTaskVo);
    }

    /**
     * @Title:
     * @Description: 确认邮寄
     * @param origFileBorrowTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "borrowTaskMailConfirm",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> borrowTaskMailConfirm(@RequestBody OrigFileBorrowTaskVo origFileBorrowTaskVo){
        return origFileDetailRpc.borrowTaskMailConfirm(origFileBorrowTaskVo);
    }

    /**
     * @Title:
     * @Description: 借阅审批-通过
     * @param borrowTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "borrowTaskExamine",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> borrowTaskExamine(@RequestBody BorrowTaskVo borrowTaskVo){
        return origFileDetailRpc.borrowTaskExamine(borrowTaskVo);
    }

    /**
     * @Title:
     * @Description: 借阅审批-退回
     * @param borrowTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "borrowTaskExamineBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> borrowTaskExamineBack(@RequestBody BorrowTaskVo borrowTaskVo){
        return origFileDetailRpc.borrowTaskExamineBack(borrowTaskVo);
    }

    /**
     * @Title:
     * @Description: 回寄资管复核
     * @param borrowBackTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "borrowBackTaskExamine",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> borrowBackTaskExamine(@RequestBody BorrowBackTaskVo borrowBackTaskVo){
        return origFileDetailRpc.borrowBackTaskExamine(borrowBackTaskVo);
    }

    /**
     * @Title:
     * @Description: 借阅归还资管确认
     * @param borrowBackTaskVo
     * @retur
     * @throws
     * @author ningyangyang
     * @date 2018-8-6 11:26:39
     */
    @RequestMapping(value = "borrowBackTaskConfirm",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> borrowBackTaskConfirm(@RequestBody BorrowBackTaskVo borrowBackTaskVo){
        return origFileDetailRpc.borrowBackTaskConfirm(borrowBackTaskVo);
    }

    /**
     * @Title:
     * @Description: 回寄资管复核-退回
     * @param borrowBackTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "borrowBackTaskExamineBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> borrowBackTaskExamineBack(@RequestBody BorrowBackTaskVo borrowBackTaskVo){
        return origFileDetailRpc.borrowBackTaskExamineBack(borrowBackTaskVo);
    }

    /**
     * @Title:
     * @Description: 资管复核-通过
     * @param borrowTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "borrowTaskReExamine",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> borrowTaskReExamine(@RequestBody BorrowTaskVo borrowTaskVo){
        return origFileDetailRpc.borrowTaskReExamine(borrowTaskVo);
    }

    /**
     * @Title:
     * @Description: 资管复核-退回
     * @param borrowTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "borrowTaskReExamineBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> borrowTaskReExamineBack(@RequestBody BorrowTaskVo borrowTaskVo){
        return origFileDetailRpc.borrowTaskReExamineBack(borrowTaskVo);
    }

    /**
     * @Title:
     * @Description: 资料邮寄
     * @param borrowTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "borrowTaskMail",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> borrowTaskMail(@RequestBody BorrowTaskVo borrowTaskVo){
        return origFileDetailRpc.borrowTaskMail(borrowTaskVo);
    }

    /**
     * @Title:
     * @Description: 财务收款确认
     * @param origFileBorrowFinanceVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "receiptConfirm",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> receiptConfirm(@RequestBody OrigFileBorrowFinanceVo origFileBorrowFinanceVo){
        return origFileDetailRpc.receiptConfirm(origFileBorrowFinanceVo);
    }

    /**
     * @Title:
     * @Description: 财务收款确认退回
     * @param origFileBorrowFinanceVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "receiptConfirmBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> receiptConfirmBack(@RequestBody OrigFileBorrowFinanceVo origFileBorrowFinanceVo){
        return origFileDetailRpc.receiptConfirmBack(origFileBorrowFinanceVo);
    }

    /**
     * @Title:
     * @Description: 财务制单
     * @param borrowBackTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "borrowMakeVoucher",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> borrowMakeVoucher(@RequestBody BorrowBackTaskVo borrowBackTaskVo){
        return origFileDetailRpc.borrowMakeVoucher(borrowBackTaskVo);
    }

    /**
     * @Title:
     * @Description: 财务制单退回
     * @param borrowBackTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "borrowMakeVoucherBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> borrowMakeVoucherBack(@RequestBody BorrowBackTaskVo borrowBackTaskVo){
        return origFileDetailRpc.borrowMakeVoucherBack(borrowBackTaskVo);
    }

    /**
     * @Title:
     * @Description: 财务付款
     * @param borrowBackTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "borrowPayment",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> borrowPayment(@RequestBody BorrowBackTaskVo borrowBackTaskVo){
        return origFileDetailRpc.borrowPayment(borrowBackTaskVo);
    }

    /**
     * @Title:
     * @Description: 财务付款退回
     * @param borrowBackTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "borrowPaymentBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> borrowPaymentBack(@RequestBody BorrowBackTaskVo borrowBackTaskVo){
        return origFileDetailRpc.borrowPaymentBack(borrowBackTaskVo);
    }

    /**
     * @Title:
     * @Description:  修改资料邮寄附件明细
     * @param origFileDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "modifyOrigFileDetail",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyOrigFileDetail(@RequestBody OrigFileDetailVo origFileDetailVo){
        return origFileDetailRpc.modifyOrigFileDetail(origFileDetailVo);
    }

    /**
     * @Title:
     * @Description:   根据origFileDetailId集合删除资料邮寄附件明细
     * @param origFileDetailIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "deleteOrigFileDetailsByOrigFileDetailIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteOrigFileDetailsByOrigFileDetailIds(@RequestBody List<String> origFileDetailIds){
        OrigFileDetailVo origFileDetailVo = new OrigFileDetailVo();
        origFileDetailVo.setOrigFileDetailIds(origFileDetailIds);
        return origFileDetailRpc.deleteOrigFileDetailsByOrigFileDetailIds(origFileDetailVo);
    }

    /**
     * @Title:
     * @Description:  根据origFileDetailId获取资料邮寄附件明细
     * @param origFileDetailId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "findOrigFileDetailByOrigFileDetailId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileDetailByOrigFileDetailId(String origFileDetailId){
        return origFileDetailRpc.findOrigFileDetailByOrigFileDetailId(origFileDetailId);
    }

    /**
     * @Title:
     * @Description:  根据借阅归还任务号获取财务制单初始化信息
     * @param borrowBackTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "getBorrowTaskMakeVoucherByBorrowBackTaskNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> getBorrowTaskMakeVoucherByBorrowBackTaskNo(String borrowBackTaskNo){
        return origFileDetailRpc.getBorrowTaskMakeVoucherByBorrowBackTaskNo(borrowBackTaskNo);
    }

    /**
     * @Title:
     * @Description:  根据borrowTaskNo获取借阅任务表
     * @param borrowTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "findOrigFileBorrowTaskInfo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileBorrowTaskInfo(String borrowTaskNo, String borrowBackTaskNo){
        return origFileDetailRpc.findOrigFileBorrowTaskInfo(borrowTaskNo, borrowBackTaskNo);
    }

    /**
     * @Title:
     * @Description: 付款单打印
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "printBorrowTask",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> printBorrowTask(@RequestBody BorrowBackTaskVo borrowBackTaskVo){
        return origFileDetailRpc.printBorrowTask(borrowBackTaskVo);
    }

}
