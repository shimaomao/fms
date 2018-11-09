package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.depositchange.DepositApproveVo;
import cn.com.leadu.fms.pojo.postbiz.vo.depositchange.DepositChangeApplyVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.service.DepositChangeTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author huzongcheng
 * @ClassName: DepositChangeTaskController
 * @Description: 保证金变更任务相关接口
 */
@RestController
@RequestMapping("deposit_change_task")
public class DepositChangeTaskController {

    /**
     * @Fields : 保证金变更任务service
     */
    @Autowired
    private DepositChangeTaskService depositChangeTaskService;


    /**
     * @param vo 参数实体类
     * @Title:
     * @Description: 根据contNo或者depositTaskNo获取申请页需要展示的基本信息
     * @author huzongcheng
     */
    @RequestMapping(value = "findApplyInfoByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyInfoByContNo(DepositChangeApplyVo vo) {
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(depositChangeTaskService.findApplyInfoByContNo(vo)), HttpStatus.OK);
    }

    /**
     * @param vo      参数实体类
     * @param sysUser 当前登录用户
     * @Title:
     * @Description: 增加保证金申请提交
     * @author huzongcheng
     */
    @RequestMapping(value = "saveDepositChange", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveDepositChange(@RequestBody DepositChangeApplyVo vo, @AuthUserInfo SysUser sysUser) {
        depositChangeTaskService.saveDepositChange(vo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @Title:
     * @Description: 复审通过操作
     * @author huzongcheng
     */
    @RequestMapping(value = "approval", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> approval(@RequestBody DepositApproveVo vo, @AuthUserInfo SysUser sysUser) {
        depositChangeTaskService.approval(vo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @Title:
     * @Description: 复审退回操作
     * @author huzongcheng
     */
    @RequestMapping(value = "sendBack", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> sendBack(@RequestBody DepositApproveVo vo, @AuthUserInfo SysUser sysUser) {
        depositChangeTaskService.sendBack(vo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @Title:
     * @Description: 复审拒绝操作
     * @author huzongcheng
     * @date
     */
    @RequestMapping(value = "refuse", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> refuse(@RequestBody DepositApproveVo vo, @AuthUserInfo SysUser sysUser) {
        depositChangeTaskService.refuse(vo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }


    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 合同生成
     * @author huzongcheng
     */
    @RequestMapping(value = "contractCreate", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> contractCreate(@RequestBody DepositApproveVo vo, @AuthUserInfo SysUser sysUser) {
        depositChangeTaskService.contractCreate(vo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 退回到申请
     * @author huzongcheng
     */
    @RequestMapping(value = "sendToApply", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> sendToApply(@RequestBody DepositApproveVo vo, @AuthUserInfo SysUser sysUser) {
        depositChangeTaskService.sendToApply(vo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @param depositTaskNo 任务变更号
     * @param bizCodeType   业务类型
     * @return ResponseEntity<RestResponse> 附件信息
     * @throws
     * @Title:
     * @Description: 获取合同附件
     * @author huzongcheng
     */
    @RequestMapping(value = "findBizFileByDepositTaskNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBizFileByDepositTaskNo(String depositTaskNo, String bizCodeType) {
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(depositChangeTaskService.findBizFileByDepositTaskNo(depositTaskNo, bizCodeType)), HttpStatus.OK);
    }

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 增加保证金签订合同
     * @author huzongcheng
     */
    @RequestMapping(value = "suppleUpload", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> suppleUpload(@RequestBody DepositApproveVo vo, @AuthUserInfo SysUser sysUser) {
        depositChangeTaskService.suppleUpload(vo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 增加保证金签订合同退回
     * @author huzongcheng
     */
    @RequestMapping(value = "suppleSendBack", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> suppleSendBack(@RequestBody DepositApproveVo vo, @AuthUserInfo SysUser sysUser) {
        depositChangeTaskService.suppleSendBack(vo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @Title:
     * @Description: 合同复核通过操作
     * @author huzongcheng
     */
    @RequestMapping(value = "contractApproval", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> contractApproval(@RequestBody DepositApproveVo vo, @AuthUserInfo SysUser sysUser) {
        depositChangeTaskService.contractApproval(vo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @Title:
     * @Description: 合同复核退回操作
     * @author huzongcheng
     */
    @RequestMapping(value = "contractSendBack", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> contractSendBack(@RequestBody DepositApproveVo vo, @AuthUserInfo SysUser sysUser) {
        depositChangeTaskService.contractSendBack(vo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @Title:
     * @Description: 财务确认收款通过操作
     * @author huzongcheng
     */
    @RequestMapping(value = "financeReceipt", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> financeReceipt(@RequestBody DepositApproveVo vo, @AuthUserInfo SysUser sysUser) {
        depositChangeTaskService.financeReceipt(vo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @Title:
     * @Description: 财务收款退回操作
     * @author huzongcheng
     */
    @RequestMapping(value = "financeSendBack", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> financeSendBack(@RequestBody DepositApproveVo vo, @AuthUserInfo SysUser sysUser) {
        depositChangeTaskService.financeSendBack(vo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 出库操作
     * @author huzongcheng
     */
    @RequestMapping(value = "export", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> export(@RequestBody DepositApproveVo vo, @AuthUserInfo SysUser sysUser) {
        depositChangeTaskService.export(vo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @param contNo 合同编号
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 根据contNo查询是否有正在进行中的保证金变更申请
     * @author huzongcheng
     * @date
     */
    @RequestMapping(value = "findDepositChangeTaskByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findDepositChangeTaskByContNo(String contNo) {
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(depositChangeTaskService.findDepositChangeTaskByContNo(contNo)), HttpStatus.OK);
    }

    /**
     * @param certifNo 证件号或者社会信用号
     * @return DepositChangeApplyVo
     * @Title:
     * @Description: 根据证件号或者社会信用号查询逾期客户id
     * @author huzongcheng
     */
    @RequestMapping(value = "findOverdueCstmId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueCstmId(String certifNo) {
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(depositChangeTaskService.findOverdueCstmId(certifNo)), HttpStatus.OK);
    }
}
