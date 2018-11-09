package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.vo.applyinput.ApplyInputVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.prebiz.service.ApplyInputService;
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
 * @ClassName: ApplyInputController
 * @Description: 申请录入管理相关接口
 * @date 2018-03-24
 */
@RestController
@RequestMapping("apply_input")
public class ApplyInputController {

    /**
     * @Fields  : 申请录入管理Service
     */
    @Autowired
    private ApplyInputService applyInputService;

    /**
     * @Title:
     * @Description: 保存申请录入信息(暂存)
     * @param applyInputVo
     * @return
     * @throws
     * @author wangxue
     * @date 2018-3-24 16:18:12
     */
    @RequestMapping(value = "saveApplyInputVo", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveApplyInputVo(@RequestBody ApplyInputVo applyInputVo, @AuthUserInfo SysUser sysUser) {
        applyInputVo.setUser(sysUser.getUser());
        applyInputVo.setUserGroup(sysUser.getGroupCode());
        //applyInputService.saveApplyInputVo(applyInputVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse( applyInputService.saveApplyInputVo(applyInputVo)), HttpStatus.OK);
    }
    /**
     * @Title:
     * @Description: 提交申请录入信息(保存)
     * @param applyInputVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-3-24 16:18:12
     */
    @RequestMapping(value = "submitApplyInputVo", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> submitApplyInputVo(@Valid @RequestBody ApplyInputVo applyInputVo, @AuthUserInfo SysUser sysUser) {
        applyInputVo.setUser(sysUser.getUser());
        applyInputVo.setUserGroup(sysUser.getGroupCode());
        applyInputService.submitApplyInputVo(applyInputVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据订单编号，获取全部订单的信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author wangxue
     * @date 2018-3-29 20:18:12
     */
    @RequestMapping(value = "findApplyInputVoByApplyNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyInputVoByApplyNo(String applyNo, String contNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(applyInputService.findApplyInputVoByApplyNo(applyNo, contNo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据订单编号，修改融资申请的信息(暂存)
     * @param applyInputVo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author wangxue
     * @date 2018-3-29 20:18:12
     */
    @RequestMapping(value = "modifyApplyInputVoByApplyNo", method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyApplyInputVoByApplyNo(@RequestBody ApplyInputVo applyInputVo, @AuthUserInfo SysUser sysUser){
        applyInputVo.setUser(sysUser.getUser());
        applyInputVo.setUserGroup(sysUser.getGroupCode());
        applyInputService.modifyApplyInputVoByApplyNo(applyInputVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark())), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据订单编号，修改融资申请的信息(提交并保存)
     * @param applyInputVo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author wangxue
     * @date 2018-3-29 20:18:12
     */
    @RequestMapping(value = "subModifyApplyInputVoByApplyNo", method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> subModifyApplyInputVoByApplyNo(@Valid @RequestBody ApplyInputVo applyInputVo, @AuthUserInfo SysUser sysUser){
        applyInputVo.setUser(sysUser.getUser());
        applyInputVo.setUserGroup(sysUser.getGroupCode());
        applyInputService.subModifyApplyInputVoByApplyNo(applyInputVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark())), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据订单编号，获取订单的融资车辆信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author wangxue
     * @date 2018-4-13 17:18:12
     */
    @RequestMapping(value = "findApplyFinanceVehicleByApplyNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyFinanceVehicleByApplyNo(String applyNo, String contNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(applyInputService.findApplyFinanceVehicleByApplyNo(applyNo, contNo)), HttpStatus.OK);
    }
    /**
     * @Title:
     * @Description: 根据订单编号，获取客户基本的信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author ningyangyang
     * @date 2018-3-29 20:18:12
     */
    @RequestMapping(value = "findApplyCstmPersonByApplyNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyCstmPersonByApplyNo(String applyNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(applyInputService.findApplyCstmPersonByApplyNo(applyNo)), HttpStatus.OK);
    }
    /**
     * @Title:
     * @Description: 根据订单编号，获取担保人(公司)的信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author ningyangyang
     * @date 2018-3-29 20:18:12
     */
    @RequestMapping(value = "findApplyGuaranteeByApplyNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyGuaranteeByApplyNo(String applyNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(applyInputService.findApplyGuaranteeByApplyNo(applyNo)), HttpStatus.OK);
    }
    /**
     * @Title:
     * @Description: 根据订单编号，获取附件信息
     * @param applyNo 订单编号
     * @return ApplyInputVo
     * @throws
     * @author ningyangyang
     * @date 2018-3-29 20:18:12
     */
    @RequestMapping(value = "findBizFileByApplyNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBizFileByApplyNo(String applyNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(applyInputService.findBizFileByApplyNo(applyNo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据订单编号，获取风控审批用申请录入信息
     * @param applyNo 订单编号
     * @return ApplyRiskVo
     * @throws
     * @author liujinge
     * @date 2018-3-29 20:18:12
     */
    @RequestMapping(value = "findApplyInputRiskByApplyNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyInputRiskByApplyNo(String applyNo,String flag){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(applyInputService.findApplyInputRiskByApplyNo(applyNo,flag)), HttpStatus.OK);
    }


    /**
     * @Title:
     * @Description: 报价单计算
     * @param applyInputVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-29 20:18:12
     */
    @RequestMapping(value = "saveQuotationDeviceInfo", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveQuotationDeviceInfo(@RequestBody ApplyInputVo applyInputVo ,@AuthUserInfo SysUser sysUser){
        applyInputVo.setUser(sysUser.getUser());
        applyInputVo.setUserGroup(sysUser.getGroupCode());
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(applyInputService.saveQuotationDeviceInfo(applyInputVo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 报价单计算
     * @param applyInputVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-29 20:18:12
     */
    @RequestMapping(value = "printQuotationDeviceInfo", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> printQuotationDeviceInfo(@RequestBody ApplyInputVo applyInputVo,@AuthUserInfo SysUser sysUser){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(applyInputService.printQuotationDeviceInfo(applyInputVo,sysUser)), HttpStatus.OK);
    }
}
