package cn.com.leadu.fms.original.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.original.service.OrigFileDetailService;
import cn.com.leadu.fms.original.validator.origfiledetail.vo.OrigFileDetailDeleteListVo;
import cn.com.leadu.fms.original.validator.origfiledetail.vo.OrigFileDetailDeleteVo;
import cn.com.leadu.fms.original.validator.origfiledetail.vo.OrigFileDetailModifyVo;
import cn.com.leadu.fms.original.validator.origfiledetail.vo.OrigFileDetailSaveVo;
import cn.com.leadu.fms.pojo.original.vo.borrowbacktask.BorrowBackTaskVo;
import cn.com.leadu.fms.pojo.original.vo.borrowtask.BorrowTaskVo;
import cn.com.leadu.fms.pojo.original.vo.origfile.OrigFileVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileBorrowFinanceVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileBorrowTaskVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileDetailVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author ningyangyang
 * @ClassName: OrigFileDetailController
 * @Description: 资料邮寄附件明细相关接口
 * @date 2018-05-03
 */
@RestController
@RequestMapping("orig_file_detail")
public class OrigFileDetailController {

    /**
     * @Fields  : 资料邮寄附件明细service
     */
    @Autowired
    private OrigFileDetailService origFileDetailService;

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
    public ResponseEntity<RestResponse> findOrigFileDetailsByPage(OrigFileDetailVo origFileDetailVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(origFileDetailService.findOrigFileDetailsByPage(origFileDetailVo)),
                HttpStatus.OK);
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
    public ResponseEntity<RestResponse> findOrigFileBorrowMailByBorrowTaskNo(String borrowTaskNo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(origFileDetailService.findOrigFileBorrowMailByBorrowTaskNo(borrowTaskNo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据借阅任务号查询资料邮寄附件明细信息（借阅归还）
     * @param origFileDetailVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "findOrigFileBorrowBackMailByBorrowTaskNo" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileBorrowBackMailByBorrowTaskNo(OrigFileDetailVo origFileDetailVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(origFileDetailService.findOrigFileBorrowBackMailByBorrowTaskNo(origFileDetailVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据借阅任务号查询资料邮寄附件明细信息
     * @param borrowBackTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "findOrigFileBorrowMailByBorrowBackTaskNo" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileBorrowMailByBorrowBackTaskNo(String borrowBackTaskNo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(origFileDetailService.findOrigFileBorrowMailByBorrowBackTaskNo(borrowBackTaskNo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据借阅任务号查询资料邮寄附件明细信息
     * @param origFileDetailVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "findOrigFileBorrowExamineByBorrowBackTaskNo" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileBorrowExamineByBorrowBackTaskNo(OrigFileDetailVo origFileDetailVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(origFileDetailService.findOrigFileBorrowExamineByBorrowBackTaskNo(origFileDetailVo)),
                HttpStatus.OK);
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
    public ResponseEntity<RestResponse> findOrigFileDetailByPage(OrigFileDetailVo origFileDetailVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(origFileDetailService.findOrigFileDetailByPage(origFileDetailVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 查询资料邮寄附件明细信息（原件借阅）
     * @param origFileDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "findOrigFileBorrowDetails" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileBorrowDetails(OrigFileDetailVo origFileDetailVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(origFileDetailService.findOrigFileBorrowDetails(origFileDetailVo)),
                HttpStatus.OK);
    }

    /**
     * @Description: 根据资料邮寄业务号,资料邮寄业务类型查询所有邮寄附件明细信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/22 15:56
     */
    @RequestMapping(value = "findOrigFileDetailByExample" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileDetailByExample(String bizCode,String bizCodeType){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(origFileDetailService.findOrigFileDetailByExample(bizCode,bizCodeType)),
                HttpStatus.OK);
    }

    /**
     * @Description: 获取资料回寄一览信息
     * @param: origFileVo
     * @return:
     * @Author: lijunjun
     * @Date: 2018/5/22 15:56
     */
    @RequestMapping(value = "findOrigFileBorrowBackSendByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileBorrowBackSendByPage(OrigFileVo origFileVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(origFileDetailService.findOrigFileBorrowBackSendByPage(origFileVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存资料邮寄附件明细
     * @param origFileDetailSaveVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "saveOrigFileDetail",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveOrigFileDetail(@Valid @RequestBody OrigFileDetailSaveVo origFileDetailSaveVo){
        origFileDetailService.saveOrigFileDetail(origFileDetailSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 借阅提交
     * @param origFileBorrowTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "borrowTask",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> borrowTask(@Valid @RequestBody OrigFileBorrowTaskVo origFileBorrowTaskVo, @AuthUserInfo SysUser sysUser){
        origFileDetailService.borrowTask(origFileBorrowTaskVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
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
    public ResponseEntity<RestResponse> cancelOrigFileBorrow(@Valid @RequestBody OrigFileBorrowTaskVo origFileBorrowTaskVo, @AuthUserInfo SysUser sysUser){
        origFileDetailService.cancelOrigFileBorrow(origFileBorrowTaskVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 邮寄确认
     * @param origFileBorrowTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "borrowTaskMailConfirm",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> borrowTaskMailConfirm(@Valid @RequestBody OrigFileBorrowTaskVo origFileBorrowTaskVo, @AuthUserInfo SysUser sysUser){
        origFileDetailService.borrowTaskMailConfirm(origFileBorrowTaskVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 借阅审核-通过
     * @param borrowTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "borrowTaskExamine",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> borrowTaskExamine(@Valid @RequestBody BorrowTaskVo borrowTaskVo, @AuthUserInfo SysUser sysUser){
        origFileDetailService.borrowTaskExamine(borrowTaskVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 借阅审核-退回
     * @param borrowTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "borrowTaskExamineBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> borrowTaskExamineBack(@Valid @RequestBody BorrowTaskVo borrowTaskVo, @AuthUserInfo SysUser sysUser){
        origFileDetailService.borrowTaskExamineBack(borrowTaskVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 回寄资管复核
     * @param borrowBackTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "borrowBackTaskExamine",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> borrowBackTaskExamine(@Valid @RequestBody BorrowBackTaskVo borrowBackTaskVo, @AuthUserInfo SysUser sysUser){
        origFileDetailService.borrowBackTaskExamine(borrowBackTaskVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 借阅申请归还资管确认
     * @param borrowBackTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-8-6 11:26:39
     */
    @RequestMapping(value = "borrowBackTaskConfirm",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> borrowBackTaskConfirm(@Valid @RequestBody BorrowBackTaskVo borrowBackTaskVo, @AuthUserInfo SysUser sysUser){
        origFileDetailService.borrowBackTaskConfirm(borrowBackTaskVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 回寄资管复核-退回
     * @param borrowBackTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "borrowBackTaskExamineBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> borrowBackTaskExamineBack(@Valid @RequestBody BorrowBackTaskVo borrowBackTaskVo, @AuthUserInfo SysUser sysUser){
        origFileDetailService.borrowBackTaskExamineBack(borrowBackTaskVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
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
    public ResponseEntity<RestResponse> borrowTaskReExamine(@Valid @RequestBody BorrowTaskVo borrowTaskVo, @AuthUserInfo SysUser sysUser){
        origFileDetailService.borrowTaskReExamine(borrowTaskVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
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
    public ResponseEntity<RestResponse> borrowTaskReExamineBack(@Valid @RequestBody BorrowTaskVo borrowTaskVo, @AuthUserInfo SysUser sysUser){
        origFileDetailService.borrowTaskReExamineBack(borrowTaskVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 资料邮寄
     * @param borrowTaskVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "borrowTaskMail",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> borrowTaskMail(@Valid @RequestBody BorrowTaskVo borrowTaskVo, @AuthUserInfo SysUser sysUser){
        origFileDetailService.borrowTaskMail(borrowTaskVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
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
    public ResponseEntity<RestResponse> receiptConfirm(@Valid @RequestBody OrigFileBorrowFinanceVo origFileBorrowFinanceVo, @AuthUserInfo SysUser sysUser){
        origFileDetailService.receiptConfirm(origFileBorrowFinanceVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
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
    public ResponseEntity<RestResponse> receiptConfirmBack(@Valid @RequestBody OrigFileBorrowFinanceVo origFileBorrowFinanceVo, @AuthUserInfo SysUser sysUser){
        origFileDetailService.receiptConfirmBack(origFileBorrowFinanceVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 财务制单
     * @param borrowBackTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "borrowMakeVoucher",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> borrowMakeVoucher(@Valid @RequestBody BorrowBackTaskVo borrowBackTaskVo, @AuthUserInfo SysUser sysUser){
        origFileDetailService.borrowMakeVoucher(borrowBackTaskVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 财务制单退回
     * @param borrowBackTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "borrowMakeVoucherBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> borrowMakeVoucherBack(@Valid @RequestBody BorrowBackTaskVo borrowBackTaskVo, @AuthUserInfo SysUser sysUser){
        origFileDetailService.borrowMakeVoucherBack(borrowBackTaskVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 财务付款
     * @param borrowBackTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "borrowPayment",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> borrowPayment(@Valid @RequestBody BorrowBackTaskVo borrowBackTaskVo, @AuthUserInfo SysUser sysUser){
        origFileDetailService.borrowPayment(borrowBackTaskVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 财务付款退回
     * @param borrowBackTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "borrowPaymentBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> borrowPaymentBack(@Valid @RequestBody BorrowBackTaskVo borrowBackTaskVo, @AuthUserInfo SysUser sysUser){
        origFileDetailService.borrowPaymentBack(borrowBackTaskVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改资料邮寄附件明细
     * @param origFileDetailModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "modifyOrigFileDetail",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyOrigFileDetail(@Valid @RequestBody OrigFileDetailModifyVo origFileDetailModifyVo){
        origFileDetailService.modifyOrigFileDetail(origFileDetailModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除资料邮寄附件明细
     * @param origFileDetailDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "deleteOrigFileDetail",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteOrigFileDetail(@Valid @RequestBody OrigFileDetailDeleteVo origFileDetailDeleteVo){
        origFileDetailService.deleteOrigFileDetail(origFileDetailDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据origFileDetailId集合删除资料邮寄附件明细
     * @param origFileDetailDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "deleteOrigFileDetailsByOrigFileDetailIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteOrigFileDetailsByOrigFileDetailIds(@Valid @RequestBody OrigFileDetailDeleteListVo origFileDetailDeleteListVo){
        origFileDetailService.deleteOrigFileDetailsByOrigFileDetailIds(origFileDetailDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
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
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(origFileDetailService.findOrigFileDetailByOrigFileDetailId(origFileDetailId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据借阅归还任务号获取财务制单初始化信息
     * @param borrowBackTaskNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "getBorrowTaskMakeVoucherByBorrowBackTaskNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> getBorrowTaskMakeVoucherByBorrowBackTaskNo(String borrowBackTaskNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(origFileDetailService.getBorrowTaskMakeVoucherByBorrowBackTaskNo(borrowBackTaskNo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据borrowTaskId获取借阅任务信息
     * @param borrowTaskNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:39
     */
    @RequestMapping(value = "findOrigFileBorrowTaskInfo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileBorrowTaskInfo(String borrowTaskNo, String borrowBackTaskNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(origFileDetailService.findOrigFileBorrowTaskInfo(borrowTaskNo, borrowBackTaskNo)), HttpStatus.OK);
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
    public ResponseEntity<RestResponse> printBorrowTask(@Valid @RequestBody BorrowBackTaskVo borrowBackTaskVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(origFileDetailService.printBorrowTask(borrowBackTaskVo)), HttpStatus.OK);
    }

}
