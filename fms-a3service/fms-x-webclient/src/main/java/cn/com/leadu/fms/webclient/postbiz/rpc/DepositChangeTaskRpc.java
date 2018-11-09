package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.depositchange.DepositApproveVo;
import cn.com.leadu.fms.pojo.postbiz.vo.depositchange.DepositChangeApplyVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author huzongcheng
 * @ClassName: DepositChangeTaskController
 * @Description: 保证金变更任务rpc
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface DepositChangeTaskRpc {

    /**
     * @param paramsMap 参数集合
     * @return ResponseEntity<RestResponse>
     * @Title:
     * @Description: 根据contNo或者depositTaskNo获取申请页需要展示的基本信息
     * @author huzongcheng
     */
    @RequestMapping(value = "api/postbiz/deposit_change_task/findApplyInfoByContNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findApplyInfoByContNo(@RequestParam Map<String, Object> paramsMap);

    /**
     * @param vo 参数实体类
     * @return ResponseEntity<RestResponse>
     * @Title:
     * @Description: 增加保证金申请提交
     * @author huzongcheng
     */
    @RequestMapping(value = "api/postbiz/deposit_change_task/saveDepositChange", method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveDepositChange(@RequestBody DepositChangeApplyVo vo);

    /**
     * @param vo 参数实体类
     * @return ResponseEntity<RestResponse>
     * @Title:
     * @Description: 复审通过操作
     * @author huzongcheng
     */
    @RequestMapping(value = "api/postbiz/deposit_change_task/approval", method = RequestMethod.POST)
    ResponseEntity<RestResponse> approval(@RequestBody DepositApproveVo vo);

    /**
     * @param vo 参数实体类
     * @return ResponseEntity<RestResponse>
     * @Title:
     * @Description: 复审退回操作
     * @author huzongcheng
     */
    @RequestMapping(value = "api/postbiz/deposit_change_task/sendBack", method = RequestMethod.POST)
    ResponseEntity<RestResponse> sendBack(@RequestBody DepositApproveVo vo);

    /**
     * @param vo 参数实体类
     * @return ResponseEntity<RestResponse>
     * @Title:
     * @Description: 复审拒绝操作
     * @author huzongcheng
     */
    @RequestMapping(value = "api/postbiz/deposit_change_task/refuse", method = RequestMethod.POST)
    ResponseEntity<RestResponse> refuse(@RequestBody DepositApproveVo vo);

    /**
     * @param vo 参数实体类
     * @return ResponseEntity<RestResponse>
     * @Title:
     * @Description: 合同生成
     * @author huzongcheng
     */
    @RequestMapping(value = "api/postbiz/deposit_change_task/contractCreate", method = RequestMethod.POST)
    ResponseEntity<RestResponse> contractCreate(@RequestBody DepositApproveVo vo);

    /**
     * @param vo 参数实体类
     * @return ResponseEntity<RestResponse>
     * @Title:
     * @Description: 退回到申请
     * @author huzongcheng
     */
    @RequestMapping(value = "api/postbiz/deposit_change_task/sendToApply", method = RequestMethod.POST)
    ResponseEntity<RestResponse> sendToApply(@RequestBody DepositApproveVo vo);

    /**
     * @param depositTaskNo 任务变更号
     * @param bizCodeType   业务类型
     * @return ResponseEntity<RestResponse> 附件信息
     * @throws
     * @Title:
     * @Description: 获取合同附件
     * @author huzongcheng
     */
    @RequestMapping(value = "api/postbiz/deposit_change_task/findBizFileByDepositTaskNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBizFileByDepositTaskNo(@RequestParam("depositTaskNo") String depositTaskNo,
                                                            @RequestParam("bizCodeType") String bizCodeType);

    /**
     * @param vo 参数实体类
     * @return ResponseEntity<RestResponse>
     * @Title:
     * @Description: 增加保证金签订合同
     * @author huzongcheng
     */
    @RequestMapping(value = "api/postbiz/deposit_change_task/suppleUpload", method = RequestMethod.POST)
    ResponseEntity<RestResponse> suppleUpload(@RequestBody DepositApproveVo vo);

    /**
     * @param vo 参数实体类
     * @return ResponseEntity<RestResponse>
     * @Title:
     * @Description: 增加保证金签订合同退回
     * @author huzongcheng
     */
    @RequestMapping(value = "api/postbiz/deposit_change_task/suppleSendBack", method = RequestMethod.POST)
    ResponseEntity<RestResponse> suppleSendBack(@RequestBody DepositApproveVo vo);

    /**
     * @param vo 参数实体类
     * @return ResponseEntity<RestResponse>
     * @Title:
     * @Description: 合同复核通过操作
     * @author huzongcheng
     */
    @RequestMapping(value = "api/postbiz/deposit_change_task/contractApproval", method = RequestMethod.POST)
    ResponseEntity<RestResponse> contractApproval(@RequestBody DepositApproveVo vo);

    /**
     * @param vo 参数实体类
     * @return ResponseEntity<RestResponse>
     * @Title:
     * @Description: 合同复核退回操作
     * @author huzongcheng
     */
    @RequestMapping(value = "api/postbiz/deposit_change_task/contractSendBack", method = RequestMethod.POST)
    ResponseEntity<RestResponse> contractSendBack(@RequestBody DepositApproveVo vo);

    /**
     * @param vo 参数实体类
     * @return ResponseEntity<RestResponse>
     * @Title:
     * @Description: 财务确认收款通过操作
     * @author huzongcheng
     */
    @RequestMapping(value = "api/postbiz/deposit_change_task/financeReceipt", method = RequestMethod.POST)
    ResponseEntity<RestResponse> financeReceipt(@RequestBody DepositApproveVo vo);

    /**
     * @param vo 参数实体类
     * @return ResponseEntity<RestResponse>
     * @Title:
     * @Description: 财务收款退回操作
     * @author huzongcheng
     */
    @RequestMapping(value = "api/postbiz/deposit_change_task/financeSendBack", method = RequestMethod.POST)
    ResponseEntity<RestResponse> financeSendBack(@RequestBody DepositApproveVo vo);

    /**
     * @param vo      入参实体类
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 出库操作
     * @author huzongcheng
     */
    @RequestMapping(value = "api/postbiz/deposit_change_task/export", method = RequestMethod.POST)
    ResponseEntity<RestResponse> export(@RequestBody DepositApproveVo vo);

    /**
     * @param contNo 合同编号
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 根据contNo查询是否有正在进行中的保证金变更申请
     * @author huzongcheng
     */
    @RequestMapping(value = "api/postbiz/deposit_change_task/findDepositChangeTaskByContNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findDepositChangeTaskByContNo(@RequestParam("contNo") String contNo);

    /**
     * @param certifNo 证件号或者社会信用号
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 根据证件号或者社会信用号查询逾期客户id
     * @author huzongcheng
     * @date
     */
    @RequestMapping(value = "api/postbiz/deposit_change_task/findOverdueCstmId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOverdueCstmId(@RequestParam("certifNo") String certifNo);

}
