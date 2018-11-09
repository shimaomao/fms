package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.vo.applyapprove.ApplyApproveVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.prebiz.service.ApplyApproveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author liujinge
 * @ClassName: ApplyApproveController
 * @Description: 区域经理审核
 * @date 2018-03-23
 */
@RestController
@RequestMapping("apply_approve")
public class ApplyApproveController {

    /**
     * @Fields  : 合同生成前确认service
     */
    @Autowired
    private ApplyApproveService applyApproveService;

    /**
     * @Title:
     * @Description: 区域经理审批通过
     * @param applyApproveVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "approval",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> approval(@Valid @RequestBody ApplyApproveVo applyApproveVo, @AuthUserInfo SysUser sysUser){
        applyApproveVo.setUser(sysUser.getUser());
        applyApproveService.approval(applyApproveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 合同生成前确认
     * @param applyApproveVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "refuse",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> refuse(@Valid @RequestBody ApplyApproveVo applyApproveVo, @AuthUserInfo SysUser sysUser){
        applyApproveVo.setUser(sysUser.getUser());
        applyApproveService.refuse(applyApproveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
    /**
     * @Title:
     * @Description: 区域经理审批退回
     * @param applyApproveVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "sendBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> sendBack(@Valid @RequestBody ApplyApproveVo applyApproveVo, @AuthUserInfo SysUser sysUser){
        applyApproveVo.setUser(sysUser.getUser());
        applyApproveService.sendBack(applyApproveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 合同生成前确认
     * @param applyApproveVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "sendBackTop",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> sendBackTop(@Valid @RequestBody ApplyApproveVo applyApproveVo, @AuthUserInfo SysUser sysUser){
        applyApproveVo.setUser(sysUser.getUser());
        applyApproveService.sendBackTop(applyApproveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据订单编号，获取附件信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author qiaomengnan
     * @date 2018-3-29 20:18:12
     */
    @RequestMapping(value = "findBizFileByApplyNo",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBizFileByApplyNo(String applyNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                applyApproveService.findBizFileByApplyNo(applyNo)
        ), HttpStatus.OK);
    }

}
