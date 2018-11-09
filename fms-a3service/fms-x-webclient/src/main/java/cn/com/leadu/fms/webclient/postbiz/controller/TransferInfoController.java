package cn.com.leadu.fms.webclient.postbiz.controller;

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
import cn.com.leadu.fms.webclient.postbiz.rpc.TransferInfoRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * @author wangxue
 * @ClassName: TransferInfoController
 * @Description: 过户流程controller
 * @date 2018-08-30
 */
@RestController
@RequestMapping("transfer_info")
public class TransferInfoController {

    /**
     * @Fields  : 过户流程rpc
     */
    @Autowired
    private TransferInfoRpc transferInfoRpc;

    /**
     * @Title:
     * @Description: 分页查询过户信息一览数据
     * @param transferInfoVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:01
     */
    @RequestMapping(value = "findTransferInfosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findTransferInfosByPage(TransferInfoVo transferInfoVo){
        Map transferInfoVoMap = transferInfoVo == null?null:(Map) JSON.toJSON(transferInfoVo);
        return transferInfoRpc.findTransferInfosByPage(transferInfoVoMap);
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
        return transferInfoRpc.findTransferDetailByContNo(contNo);
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
        return transferInfoRpc.findTransferDetailByTransferNo(transferNo);
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
    public ResponseEntity<RestResponse> saveTransferApply(@RequestBody TransferInfoVo transferInfoVo) {
        return transferInfoRpc.saveTransferApply(transferInfoVo);
    }

    /**
     * @Title:
     * @Description: 保存过户流程
     * @param transferInfoVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:01
     */
    @RequestMapping(value = "submitTransferApply",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> submitTransferApply(@RequestBody TransferInfoVo transferInfoVo){
        return transferInfoRpc.submitTransferApply(transferInfoVo);
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
    public ResponseEntity<RestResponse> transferApproval(@RequestBody TransferApproveVo transferApproveVo) {
        return transferInfoRpc.transferApproval(transferApproveVo);
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
    public ResponseEntity<RestResponse> transferSendBack(@RequestBody TransferApproveVo transferApproveVo) {
        return transferInfoRpc.transferSendBack(transferApproveVo);
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
    public ResponseEntity<RestResponse> saveTransferSettlement(@RequestBody TransferInfoVo transferInfoVo) {
        return transferInfoRpc.saveTransferSettlement(transferInfoVo);
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
    public ResponseEntity<RestResponse> submitTransferSettlement(@RequestBody TransferInfoVo transferInfoVo) {
        return transferInfoRpc.submitTransferSettlement(transferInfoVo);
    }

    /**
     * @Title:
     * @Description: 过户财务确认收款
     * @param transferApproveVo 确认收款信息
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-9-7 14:15:00
     */
    @RequestMapping(value = "transferReceipt", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> transferReceipt(@RequestBody TransferApproveVo transferApproveVo) {
        return transferInfoRpc.transferReceipt(transferApproveVo);
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
        return transferInfoRpc.printPaymentForm(transferApproveVo);
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
        return transferInfoRpc.findTransferInfoByContNo(contNo);
    }

    /**
     * @Title:
     * @Description: 获取合同的车辆登记证状态
     * @param contNo 合同编号
     * @param bizCodeType 归档业务类型
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-8-31 17:15:00
     */
    @RequestMapping(value = "findOrigFileDetailStatusByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOrigFileDetailStatusByContNo(String contNo, String bizCodeType) {
        return transferInfoRpc.findOrigFileDetailStatusByContNo(contNo, bizCodeType);
    }

    /**
     * @Title:
     * @Description: 确认书下载
     * @param transferInfoLetterVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "downLoadLetter",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> downLoadLetter(@RequestBody TransferInfoLetterVo transferInfoLetterVo){
        return transferInfoRpc.downLoadLetter(transferInfoLetterVo);
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
        Map transferInfoRetreatsVoMap = transferInfoRetreatsVo == null?null:(Map) JSON.toJSON(transferInfoRetreatsVo);
        return transferInfoRpc.findTransferInfoRetreatsVosByPage(transferInfoRetreatsVoMap);
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
        return transferInfoRpc.findTransferInfoRetreatsByVo(contNo);
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
    public ResponseEntity<RestResponse> submitTransferInfoRetreatsApply(@RequestBody TransferInfoRetreatsVo transferInfoRetreatsVo) {
        return transferInfoRpc.submitTransferInfoRetreatsApply(transferInfoRetreatsVo);
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
        return transferInfoRpc.findTransferInfoRetreatVoByRetreatsNo(retreatsNo);
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
    public ResponseEntity<RestResponse> approval(@RequestBody TransferInfoRetreatsVo transferInfoRetreatsVo){
        return transferInfoRpc.approval(transferInfoRetreatsVo);
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
    public ResponseEntity<RestResponse> sendBack(@RequestBody TransferInfoRetreatsVo transferInfoRetreatsVo){
        return transferInfoRpc.sendBack(transferInfoRetreatsVo);
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
    public ResponseEntity<RestResponse> Receivables(@RequestBody TransferInfoRetreatsVo transferInfoRetreatsVo){
        return transferInfoRpc.Receivables(transferInfoRetreatsVo);
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
    public ResponseEntity<RestResponse> refunds(@RequestBody TransferInfoRetreatsVo transferInfoRetreatsVo){
        return transferInfoRpc.refunds(transferInfoRetreatsVo);
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
    public ResponseEntity<RestResponse> makeVoucher(@RequestBody TransferInfoRetreatsVo transferInfoRetreatsVo){
        return transferInfoRpc.makeVoucher(transferInfoRetreatsVo);
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
    public ResponseEntity<RestResponse> payment(@RequestBody TransferInfoRetreatsVo transferInfoRetreatsVo){
        return transferInfoRpc.payment(transferInfoRetreatsVo);
    }
}
