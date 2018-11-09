package cn.com.leadu.fms.webclient.original.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.original.vo.borrowbacktask.BorrowBackTaskVo;
import cn.com.leadu.fms.pojo.original.vo.borrowtask.BorrowTaskVo;
import cn.com.leadu.fms.pojo.original.vo.origfile.OrigFileVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileBorrowFinanceVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileBorrowTaskVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileDetailVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: OrigFileDetailController
 * @Description: 资料邮寄附件明细rpc
 * @date 2018-05-03
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface OrigFileDetailRpc {

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件明细信息
     * @param origFileDetailVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/findOrigFileDetailsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOrigFileDetailsByPage(@RequestParam Map<String, Object> origFileDetailVoMap);

    /**
     * @Title:
     * @Description: 根据借阅任务号查询资料邮寄附件明细信息
     * @param borrowTaskNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/findOrigFileBorrowMailByBorrowTaskNo" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOrigFileBorrowMailByBorrowTaskNo(@RequestParam("borrowTaskNo") String borrowTaskNo);

    /**
     * @Title:
     * @Description: 根据借阅任务号查询资料邮寄附件明细信息(借阅归还)
     * @param borrowTaskNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/findOrigFileBorrowBackMailByBorrowTaskNo" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOrigFileBorrowBackMailByBorrowTaskNo(@RequestParam("borrowTaskNo") String borrowTaskNo);

    /**
     * @Title:
     * @Description: 根据借阅归还任务号查询资料邮寄附件明细信息
     * @param borrowBackTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/findOrigFileBorrowMailByBorrowBackTaskNo" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOrigFileBorrowMailByBorrowBackTaskNo(@RequestParam("borrowBackTaskNo") String borrowBackTaskNo);

    /**
     * @Title:
     * @Description: 根据借阅归还任务号查询资料邮寄附件明细信息(借阅归还资管复核明细)
     * @param borrowBackTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/findOrigFileBorrowExamineByBorrowBackTaskNo" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOrigFileBorrowExamineByBorrowBackTaskNo(@RequestParam("borrowBackTaskNo") String borrowBackTaskNo);

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件明细信息
     * @param origFileDetailVoMap
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/findOrigFileDetailByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOrigFileDetailByPage(@RequestParam Map<String, Object> origFileDetailVoMap);

    /**
     * @Title:
     * @Description: 查询资料邮寄附件明细信息(原件借阅)
     * @param origFileDetailVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/findOrigFileBorrowDetails" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOrigFileBorrowDetails(@RequestParam Map<String, Object> origFileDetailVoMap);

    /**
     * @Description: 根据资料邮寄业务号,资料邮寄业务类型查询所有邮寄附件明细信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/22 15:56
     */
    @RequestMapping(value = "api/original/orig_file_detail/findOrigFileDetailByExample" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOrigFileDetailByExample(@RequestParam("bizCode")String bizCode,@RequestParam("bizCodeType")String bizCodeType);

    /**
     * @Description: 查询资料回寄信息一览
     * @param: origFileVo
     * @return:
     * @Author: lijunjun
     * @Date: 2018/5/22 15:56
     */
    @RequestMapping(value = "api/original/orig_file_detail/findOrigFileBorrowBackSendByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOrigFileBorrowBackSendByPage(@RequestParam("origFileVo") Map<String, Object> origFileVoMap);

    /**
     * @Title:
     * @Description: 保存资料邮寄附件明细
     * @param origFileDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/saveOrigFileDetail",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveOrigFileDetail(@RequestBody OrigFileDetailVo origFileDetailVo);

    /**
     * @Title:
     * @Description: 借阅提交
     * @param origFileBorrowTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/borrowTask",method = RequestMethod.POST)
    ResponseEntity<RestResponse> borrowTask(@RequestBody OrigFileBorrowTaskVo origFileBorrowTaskVo);

    /**
     * @Title:
     * @Description: 借阅提交取消
     * @param origFileBorrowTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/cancelOrigFileBorrow",method = RequestMethod.POST)
    ResponseEntity<RestResponse> cancelOrigFileBorrow(@RequestBody OrigFileBorrowTaskVo origFileBorrowTaskVo);

    /**
     * @Title:
     * @Description: 确认邮寄
     * @param origFileBorrowTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/borrowTaskMailConfirm",method = RequestMethod.POST)
    ResponseEntity<RestResponse> borrowTaskMailConfirm(@RequestBody OrigFileBorrowTaskVo origFileBorrowTaskVo);

    /**
     * @Title:
     * @Description: 借阅审批-通过
     * @param borrowTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/borrowTaskExamine",method = RequestMethod.POST)
    ResponseEntity<RestResponse> borrowTaskExamine(@RequestBody BorrowTaskVo borrowTaskVo);

    /**
     * @Title:
     * @Description: 借阅审批-退回
     * @param borrowTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/borrowTaskExamineBack",method = RequestMethod.POST)
    ResponseEntity<RestResponse> borrowTaskExamineBack(@RequestBody BorrowTaskVo borrowTaskVo);

    /**
     * @Title:
     * @Description: 回寄资管复核
     * @param borrowBackTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/borrowBackTaskExamine",method = RequestMethod.POST)
    ResponseEntity<RestResponse> borrowBackTaskExamine(@RequestBody BorrowBackTaskVo borrowBackTaskVo);

    /**
     * @Title:
     * @Description: 回寄资管复核
     * @param borrowBackTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/borrowBackTaskConfirm",method = RequestMethod.POST)
    ResponseEntity<RestResponse> borrowBackTaskConfirm(@RequestBody BorrowBackTaskVo borrowBackTaskVo);

    /**
     * @Title:
     * @Description: 回寄资管复核-退回
     * @param borrowBackTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/borrowBackTaskExamineBack",method = RequestMethod.POST)
    ResponseEntity<RestResponse> borrowBackTaskExamineBack(@RequestBody BorrowBackTaskVo borrowBackTaskVo);

    /**
     * @Title:
     * @Description: 资管复核-通过
     * @param borrowTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/borrowTaskReExamine",method = RequestMethod.POST)
    ResponseEntity<RestResponse> borrowTaskReExamine(@RequestBody BorrowTaskVo borrowTaskVo);

    /**
     * @Title:
     * @Description: 资管复核-退回
     * @param borrowTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/borrowTaskReExamineBack",method = RequestMethod.POST)
    ResponseEntity<RestResponse> borrowTaskReExamineBack(@RequestBody BorrowTaskVo borrowTaskVo);

    /**
     * @Title:
     * @Description: 借阅审批
     * @param borrowTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/borrowTaskMail",method = RequestMethod.POST)
    ResponseEntity<RestResponse> borrowTaskMail(@RequestBody BorrowTaskVo borrowTaskVo);

    /**
     * @Title:
     * @Description: 财务收款确认
     * @param origFileBorrowFinanceVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/receiptConfirm",method = RequestMethod.POST)
    ResponseEntity<RestResponse> receiptConfirm(@RequestBody OrigFileBorrowFinanceVo origFileBorrowFinanceVo);

    /**
     * @Title:
     * @Description: 财务收款确认退回
     * @param origFileBorrowFinanceVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/receiptConfirmBack",method = RequestMethod.POST)
    ResponseEntity<RestResponse> receiptConfirmBack(@RequestBody OrigFileBorrowFinanceVo origFileBorrowFinanceVo);

    /**
     * @Title:
     * @Description: 财务制单
     * @param borrowBackTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/borrowMakeVoucher",method = RequestMethod.POST)
    ResponseEntity<RestResponse> borrowMakeVoucher(@RequestBody BorrowBackTaskVo borrowBackTaskVo);

    /**
     * @Title:
     * @Description: 财务制单退回
     * @param borrowBackTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/borrowMakeVoucherBack",method = RequestMethod.POST)
    ResponseEntity<RestResponse> borrowMakeVoucherBack(@RequestBody BorrowBackTaskVo borrowBackTaskVo);

    /**
     * @Title:
     * @Description: 财务付款
     * @param borrowBackTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/borrowPayment",method = RequestMethod.POST)
    ResponseEntity<RestResponse> borrowPayment(@RequestBody BorrowBackTaskVo borrowBackTaskVo);

    /**
     * @Title:
     * @Description: 财务付款退回
     * @param borrowBackTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/borrowPaymentBack",method = RequestMethod.POST)
    ResponseEntity<RestResponse> borrowPaymentBack(@RequestBody BorrowBackTaskVo borrowBackTaskVo);

    /**
     * @Title:
     * @Description:  修改资料邮寄附件明细
     * @param origFileDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/modifyOrigFileDetail",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyOrigFileDetail(@RequestBody OrigFileDetailVo origFileDetailVo);

    /**
     * @Title:
     * @Description:   根据origFileDetailId集合删除资料邮寄附件明细
     * @param origFileDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/deleteOrigFileDetailsByOrigFileDetailIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteOrigFileDetailsByOrigFileDetailIds(@RequestBody OrigFileDetailVo origFileDetailVo);

    /**
     * @Title:
     * @Description:  根据origFileDetailId获取资料邮寄附件明细
     * @param origFileDetailId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/findOrigFileDetailByOrigFileDetailId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOrigFileDetailByOrigFileDetailId(@RequestParam("origFileDetailId") String origFileDetailId);

    /**
     * @Title:
     * @Description:  根据借阅归还任务号获取财务制单初始化信息
     * @param borrowBackTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/getBorrowTaskMakeVoucherByBorrowBackTaskNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> getBorrowTaskMakeVoucherByBorrowBackTaskNo(@RequestParam("borrowBackTaskNo") String borrowBackTaskNo);

    /**
     * @Title:
     * @Description:  根据borrowTaskNo获取借阅任务信息
     * @param borrowTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @RequestMapping(value = "api/original/orig_file_detail/findOrigFileBorrowTaskInfo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOrigFileBorrowTaskInfo(@RequestParam("borrowTaskNo") String borrowTaskNo , @RequestParam("borrowBackTaskNo") String borrowBackTaskNo);

    /**
     * @Title:
     * @Description: 付款单打印
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/original/orig_file_detail/printBorrowTask",method = RequestMethod.POST)
    ResponseEntity<RestResponse> printBorrowTask(BorrowBackTaskVo borrowBackTaskVo);

}
