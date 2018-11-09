package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.collectiontask.CollectionTaskLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.transferinfo.TransferApproveVo;
import cn.com.leadu.fms.pojo.postbiz.vo.transferinfo.TransferInfoLetterVo;
import cn.com.leadu.fms.pojo.postbiz.vo.transferinfo.TransferInfoRetreatsVo;
import cn.com.leadu.fms.pojo.postbiz.vo.transferinfo.TransferInfoVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author wangxue
 * @ClassName: TransferInfoController
 * @Description: 过户流程rpc
 * @date 2018-08-30
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface TransferInfoRpc {

    /**
     * @Title:
     * @Description: 分页查询过户信息一览数据
     * @param transferInfoVoMap
     * @return
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:01
     */
    @RequestMapping(value = "api/postbiz/transfer_info/findTransferInfosByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findTransferInfosByPage(@RequestParam Map<String, Object> transferInfoVoMap);

    /**
     * @Title:
     * @Description: 获取过户流程的页面显示的信息
     * @param contNo 合同编号
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-8-30 15:15:00
     */
    @RequestMapping(value = "api/postbiz/transfer_info/findTransferDetailByContNo" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findTransferDetailByContNo(@RequestParam("contNo") String contNo);

    /**
     * @Title:
     * @Description: 根据过户任务号 获取过户任务信息
     * @param transferNo 过户任务号
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-9-1 15:15:00
     */
    @RequestMapping(value = "api/postbiz/transfer_info/findTransferDetailByTransferNo" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findTransferDetailByTransferNo(@RequestParam("transferNo") String transferNo);

    /**
     * @Title:
     * @Description: 过户申请暂存处理
     * @param transferInfoVo 需要保存的数据
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-8-31 17:15:00
     */
    @RequestMapping(value = "api/postbiz/transfer_info/saveTransferApply",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveTransferApply(@RequestBody TransferInfoVo transferInfoVo);

    /**
     * @Title:
     * @Description: 过户申请提交处理
     * @param transferInfoVo 需要保存的数据
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-8-31 17:15:00
     */
    @RequestMapping(value = "api/postbiz/transfer_info/submitTransferApply",method = RequestMethod.POST)
    ResponseEntity<RestResponse> submitTransferApply(@RequestBody TransferInfoVo transferInfoVo);

    /**
     * @Title:
     * @Description: 过户流程审批提交
     * @param transferApproveVo 审批信息
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-9-5 17:15:00
     */
    @RequestMapping(value = "api/postbiz/transfer_info/transferApproval",method = RequestMethod.POST)
    ResponseEntity<RestResponse> transferApproval(@RequestBody TransferApproveVo transferApproveVo);

    /**
     * @Title:
     * @Description: 过户流程审批退回
     * @param transferApproveVo 审批信息
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-9-5 17:15:00
     */
    @RequestMapping(value = "api/postbiz/transfer_info/transferSendBack",method = RequestMethod.POST)
    ResponseEntity<RestResponse> transferSendBack(@RequestBody TransferApproveVo transferApproveVo);

    /**
     * @Title:
     * @Description: 过户费用结算暂存
     * @param transferInfoVo 过户费用信息
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-9-7 14:15:00
     */
    @RequestMapping(value = "api/postbiz/transfer_info/saveTransferSettlement",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveTransferSettlement(@RequestBody TransferInfoVo transferInfoVo);

    /**
     * @Title:
     * @Description: 过户费用结算提交
     * @param transferInfoVo 过户费用信息
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-9-7 14:15:00
     */
    @RequestMapping(value = "api/postbiz/transfer_info/submitTransferSettlement",method = RequestMethod.POST)
    ResponseEntity<RestResponse> submitTransferSettlement(@RequestBody TransferInfoVo transferInfoVo);

    /**
     * @Title:
     * @Description: 过户财务确认收款
     * @param transferApproveVo 确认收款信息
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-9-7 14:15:00
     */
    @RequestMapping(value = "api/postbiz/transfer_info/transferReceipt",method = RequestMethod.POST)
    ResponseEntity<RestResponse> transferReceipt(@RequestBody TransferApproveVo transferApproveVo);

    /**
     * @Title:
     * @Description: 过户任务，打印付款单
     * @param transferApproveVo 确认收款信息
     * @return 返回结果
     * @throws
     * @author wangxue
     * @date 2018-9-7 14:15:00
     */
    @RequestMapping(value = "api/postbiz/transfer_info/printPaymentForm",method = RequestMethod.POST)
    ResponseEntity<RestResponse> printPaymentForm(@RequestBody TransferApproveVo transferApproveVo);

    /**
     * @Title:
     * @Description: 根据合同编号，获取过户任务信息
     * @param contNo 合同编号
     * @return
     * @throws
     * @author wangxue
     * @date 2018-9-7 14:15:00
     */
    @RequestMapping(value = "api/postbiz/transfer_info/findTransferInfoByContNo",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findTransferInfoByContNo(@RequestParam("contNo") String contNo);

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
    @RequestMapping(value = "api/postbiz/transfer_info/findOrigFileDetailStatusByContNo",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOrigFileDetailStatusByContNo(@RequestParam("contNo") String contNo, @RequestParam("bizCodeType") String bizCodeType);

    /**
     * @Title:
     * @Description: 确认书下载
     * @param transferInfoLetterVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-9-1 17:46:36
     */
    @RequestMapping(value = "api/postbiz/transfer_info/downLoadLetter",method = RequestMethod.POST)
    ResponseEntity<RestResponse> downLoadLetter(@RequestBody TransferInfoLetterVo transferInfoLetterVo);

    /**
     * @Title:
     * @Description: 分页查询过户退保一览
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/postbiz/transfer_info/findTransferInfoRetreatsVosByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findTransferInfoRetreatsVosByPage(@RequestParam Map<String, Object> transferInfoRetreatsVoMap);

    /**
     * @Title:
     * @Description: 根据合同号获取过户退保详情
     * @param
     * @return
     * @throws
     * @author fangshaofeng
     * @date 2018-10-29 17:15:00
     */
    @RequestMapping(value = "api/postbiz/transfer_info/findTransferInfoRetreatsByVo",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findTransferInfoRetreatsByVo(@RequestParam("contNo") String contNo);

    /**
     * @Title:
     * @Description: 过户退保申请提交处理
     * @param transferInfoRetreatsVo 需要保存的数据
     * @return 返回结果
     * @throws
     * @author fangshaofeng
     * @date 2018-10-30 10:15:00
     */
    @RequestMapping(value = "api/postbiz/transfer_info/submitTransferInfoRetreatsApply",method = RequestMethod.POST)
    ResponseEntity<RestResponse> submitTransferInfoRetreatsApply(@RequestBody TransferInfoRetreatsVo transferInfoRetreatsVo);

    /**
     * @Title:
     * @Description: 根据退保任务号查询过户退保信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/postbiz/transfer_info/findTransferInfoRetreatVoByRetreatsNo",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findTransferInfoRetreatVoByRetreatsNo(@RequestParam("retreatsNo") String retreatsNo);

    /**
     * @Title:
     * @Description: 过户退保申请资管复核审核通过
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/postbiz/transfer_info/approval" ,method = RequestMethod.PUT)
    ResponseEntity<RestResponse> approval(@RequestBody TransferInfoRetreatsVo transferInfoRetreatsVo);

    /**
     * @Title:
     * @Description: 过户退保申请资管复核审核退回
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/postbiz/transfer_info/sendBack" ,method = RequestMethod.PUT)
    ResponseEntity<RestResponse> sendBack(@RequestBody TransferInfoRetreatsVo transferInfoRetreatsVo);

    /**
     * @Title:
     * @Description: 过户退保流程财务确认收款同意
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/postbiz/transfer_info/Receivables" ,method = RequestMethod.PUT)
    ResponseEntity<RestResponse> Receivables(@RequestBody TransferInfoRetreatsVo transferInfoRetreatsVo);

    /**
     * @Title:
     * @Description: 过户退保流程财务确认收款退回上一级
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/postbiz/transfer_info/refunds" ,method = RequestMethod.PUT)
    ResponseEntity<RestResponse> refunds(@RequestBody TransferInfoRetreatsVo transferInfoRetreatsVo);

    /**
     * @Description: 过户退保流程财务制单
     * @param:
     * @return:
     * @Author: yanfengbo
     */
    @RequestMapping(value = "api/postbiz/transfer_info/makeVoucher",method = RequestMethod.POST)
    ResponseEntity<RestResponse> makeVoucher(TransferInfoRetreatsVo transferInfoRetreatsVo);

    /**
     * @Description: 过户退保流程财务付款
     * @param:
     * @return:
     * @Author: yanfengbo
     */
    @RequestMapping(value = "api/postbiz/transfer_info/payment",method = RequestMethod.POST)
    ResponseEntity<RestResponse> payment(TransferInfoRetreatsVo transferInfoRetreatsVo);
}
