package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.collectiontask.CollectionTaskLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.transferinfo.TransferApproveVo;
import cn.com.leadu.fms.pojo.postbiz.vo.transferinfo.TransferInfoLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.transferinfo.TransferInfoRetreatsVo;
import cn.com.leadu.fms.pojo.postbiz.vo.transferinfo.TransferInfoVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.service.TransferInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author wangxue
 * @ClassName: TransferInfoController
 * @Description: 过户流程相关接口
 * @date 2018-08-30
 */
@RestController
@RequestMapping("transfer_info")
public class TransferInfoController {

    /**
     * @Fields  : 过户流程service
     */
    @Autowired
    private TransferInfoService transferInfoService;

    /**
     * @Title:
     * @Description: 分页查询过户信息一览数据
     * @param transferInfoVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:00
     */
    @RequestMapping(value = "findTransferInfosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findTransferInfosByPage(TransferInfoVo transferInfoVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(transferInfoService.findTransferInfosByPage(transferInfoVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据合同编号 获取过户流程的页面显示的信息
     * @param contNo 合同编号
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:00
     */
    @RequestMapping(value = "findTransferDetailByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findTransferDetailByContNo(String contNo) {
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(transferInfoService.findTransferDetailByContNo(contNo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据过户任务号 获取过户任务信息
     * @param transferNo 过户任务号
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-9-1 15:15:00
     */
    @RequestMapping(value = "findTransferDetailByTransferNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findTransferDetailByTransferNo(String transferNo) {
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(transferInfoService.findTransferDetailByTransferNo(transferNo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 过户申请暂存处理
     * @param transferInfoVo 需要保存的数据
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-8-31 17:15:00
     */
    @RequestMapping(value = "saveTransferApply", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveTransferApply(@RequestBody TransferInfoVo transferInfoVo, @AuthUserInfo SysUser sysUser) {
        transferInfoVo.setUser(sysUser.getUser());
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(transferInfoService.saveTransferApply(transferInfoVo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 过户申请提交处理
     * @param transferInfoVo 需要保存的数据
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-8-31 17:15:00
     */
    @RequestMapping(value = "submitTransferApply", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> submitTransferApply(@RequestBody TransferInfoVo transferInfoVo, @AuthUserInfo SysUser sysUser) {
        transferInfoVo.setUser(sysUser.getUser());
        transferInfoService.submitTransferApply(transferInfoVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 过户流程审批通过
     * @param transferApproveVo 审批信息
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-9-5 17:15:00
     */
    @RequestMapping(value = "transferApproval", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> transferApproval(@RequestBody TransferApproveVo transferApproveVo, @AuthUserInfo SysUser sysUser) {
        transferApproveVo.setUser(sysUser.getUser());
        transferInfoService.transferApproval(transferApproveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 过户流程审批退回
     * @param transferApproveVo 审批信息
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-9-5 17:15:00
     */
    @RequestMapping(value = "transferSendBack", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> transferSendBack(@RequestBody TransferApproveVo transferApproveVo, @AuthUserInfo SysUser sysUser) {
        transferApproveVo.setUser(sysUser.getUser());
        transferInfoService.transferSendBack(transferApproveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 过户费用结算暂存
     * @param transferInfoVo 过户费用信息
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-9-7 14:15:00
     */
    @RequestMapping(value = "saveTransferSettlement", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveTransferSettlement(@RequestBody TransferInfoVo transferInfoVo, @AuthUserInfo SysUser sysUser) {
        transferInfoVo.setUser(sysUser.getUser());
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(transferInfoService.saveTransferSettlement(transferInfoVo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 过户费用结算提交
     * @param transferInfoVo 过户费用信息
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-9-7 14:15:00
     */
    @RequestMapping(value = "submitTransferSettlement", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> submitTransferSettlement(@RequestBody TransferInfoVo transferInfoVo, @AuthUserInfo SysUser sysUser) {
        transferInfoVo.setUser(sysUser.getUser());
        transferInfoService.submitTransferSettlement(transferInfoVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 过户财务确认收款
     * @param transferApproveVo 确认收款信息
     * @param sysUser 当前用户
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-9-7 14:15:00
     */
    @RequestMapping(value = "transferReceipt", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> transferReceipt(@RequestBody TransferApproveVo transferApproveVo, @AuthUserInfo SysUser sysUser) {
        transferApproveVo.setUser(sysUser.getUser());
        transferInfoService.transferReceipt(transferApproveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 过户任务，打印付款单
     * @param transferApproveVo 确认收款信息
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-9-7 14:15:00
     */
    @RequestMapping(value = "printPaymentForm", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> printPaymentForm(@RequestBody TransferApproveVo transferApproveVo) {
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(transferInfoService.printPaymentForm(transferApproveVo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据合同编号，获取过户任务信息
     * @param contNo 合同编号
     * @return
     * @throws
     * @author wangxue
     * @date 2018-9-7 14:15:00
     */
    @RequestMapping(value = "findTransferInfoByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findTransferInfoByContNo(String contNo) {
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(transferInfoService.findTransferInfoByContNo(contNo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 获取合同的车辆登记证状态
     * @param transferInfoVo 查询参数
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-8-31 17:15:00
     */
    @RequestMapping(value = "findOrigFileDetailStatusByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileDetailStatusByContNo(TransferInfoVo transferInfoVo) {
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(transferInfoService.findOrigFileDetailStatusByContNo(transferInfoVo.getContNo(),transferInfoVo.getBizCodeType())), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 确认书下载
     * @param transferInfoLetterVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:35
     */
    @RequestMapping(value = "downLoadLetter",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> downLoadLetter(@RequestBody TransferInfoLetterVo transferInfoLetterVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(transferInfoService.downLoadLetter(transferInfoLetterVo.getContNo())), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 分页查询过户退保一览
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "findTransferInfoRetreatsVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findTransferInfoRetreatsVosByPage(TransferInfoRetreatsVo transferInfoRetreatsVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(transferInfoService.findTransferInfoRetreatsVosByPage(transferInfoRetreatsVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据合同号获取过户退保详情
     * @param
     * @return
     * @throws
     * @author fangshaofeng
     * @date 2018-10-29 17:15:00
     */
    @RequestMapping(value = "findTransferInfoRetreatsByVo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findTransferInfoRetreatsByVo(String contNo) {
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(transferInfoService.findTransferInfoRetreatsByVo(contNo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 过户退保申请提交处理
     * @param transferInfoRetreatsVo 需要保存的数据
     * @return 返回结果
     * @throws
     * @author fangshaofeng
     * @date 2018-10-30 10:15:00
     */
    @RequestMapping(value = "submitTransferInfoRetreatsApply", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> submitTransferInfoRetreatsApply(@RequestBody TransferInfoRetreatsVo transferInfoRetreatsVo, @AuthUserInfo SysUser sysUser) {
        transferInfoService.submitTransferInfoRetreatsApply(transferInfoRetreatsVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据退保任务号查询过户退保信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "findTransferInfoRetreatVoByRetreatsNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findTransferInfoRetreatVoByRetreatsNo(String retreatsNo) {
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(transferInfoService.findTransferInfoRetreatVoByRetreatsNo(retreatsNo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 过户退保申请资管复核审核通过
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "approval",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> approval(@RequestBody TransferInfoRetreatsVo transferInfoRetreatsVo, @AuthUserInfo SysUser sysUser){
        transferInfoService.approval(transferInfoRetreatsVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 过户退保申请资管复核审核退回
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "sendBack",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> sendBack(@RequestBody TransferInfoRetreatsVo transferInfoRetreatsVo, @AuthUserInfo SysUser sysUser){
        transferInfoService.sendBack(transferInfoRetreatsVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 过户退保流程财务确认收款同意
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "Receivables",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> Receivables(@RequestBody TransferInfoRetreatsVo transferInfoRetreatsVo, @AuthUserInfo SysUser sysUser){
        transferInfoService.Receivables(transferInfoRetreatsVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 过户退保流程财务确认收款退回上一级
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "refunds",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> refunds(@RequestBody TransferInfoRetreatsVo transferInfoRetreatsVo, @AuthUserInfo SysUser sysUser){
        transferInfoService.sendBack(transferInfoRetreatsVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 过户退保流程财务制单
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "makeVoucher",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> makeVoucher(@Valid @RequestBody TransferInfoRetreatsVo transferInfoRetreatsVo, @AuthUserInfo SysUser sysUser){
        transferInfoService.makeVoucher(transferInfoRetreatsVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 过户退保流程财务付款
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "payment",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> payment(@Valid @RequestBody TransferInfoRetreatsVo transferInfoRetreatsVo, @AuthUserInfo SysUser sysUser){
        transferInfoService.payment(transferInfoRetreatsVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }


}
