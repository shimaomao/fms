package cn.com.leadu.fms.insurance.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.insurance.service.RenewalRegisterService;
import cn.com.leadu.fms.insurance.validator.renewalregister.vo.RenewalRegisterDeleteListVo;
import cn.com.leadu.fms.insurance.validator.renewalregister.vo.RenewalRegisterDeleteVo;
import cn.com.leadu.fms.insurance.validator.renewalregister.vo.RenewalRegisterModifyVo;
import cn.com.leadu.fms.insurance.validator.renewalregister.vo.RenewalRegisterSaveVo;
import cn.com.leadu.fms.pojo.insurance.vo.renewalregister.RenewalRegisterVo;
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
 * @author yanfengbo
 * @ClassName: RenewalRegisterController
 * @Description: 续保任务一览相关接口
 * @date 2018-05-17
 */
@RestController
@RequestMapping("renewal_register")
public class RenewalRegisterController {

    /**
     * @Fields  : 续保任务一览service
     */
    @Autowired
    private RenewalRegisterService renewalRegisterService;

    /**
     * @Title:
     * @Description: 分页查询续保任务一览信息
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-17 15:28:42
     */
    @RequestMapping(value = "findRenewalRegistersByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRenewalRegistersByPage(RenewalRegisterVo renewalRegisterVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(renewalRegisterService.findRenewalRegistersByPage(renewalRegisterVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据taskNo获取一条续保任务明细
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 15:28:42
     */
    @RequestMapping(value = "findRenewalRegistersByTaskNo" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRenewalRegistersByTaskNo(RenewalRegisterVo renewalRegisterVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(renewalRegisterService.findRenewalRegistersByTaskNo(renewalRegisterVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 更新续保任务登记表并启动流程
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date
     */
    @RequestMapping(value = "saveContInsuranceFromRenewalRegister",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContInsuranceFromRenewalRegister(@Valid @RequestBody RenewalRegisterVo renewalRegisterVo, @AuthUserInfo SysUser sysUser){
        renewalRegisterService.saveContInsuranceFromRenewalRegister(renewalRegisterVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 再次资管确认提交
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date
     */
    @RequestMapping(value = "reSaveContInsuranceFromRenewalRegister",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> reSaveContInsuranceFromRenewalRegister(@Valid @RequestBody RenewalRegisterVo renewalRegisterVo, @AuthUserInfo SysUser sysUser){
        renewalRegisterService.reSaveContInsuranceFromRenewalRegister(renewalRegisterVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 续保财务确认收款
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-17 15:28:42
     */
    @RequestMapping(value = "renewalRegisterReceipt",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> renewalRegisterReceipt(@Valid @RequestBody RenewalRegisterVo renewalRegisterVo,@AuthUserInfo SysUser sysUser){
        renewalRegisterService.renewalRegisterReceipt(renewalRegisterVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 续保请款
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-10 15:28:42
     */
    @RequestMapping(value = "renewalRegisterWithdraw",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> renewalRegisterWithdraw(@Valid @RequestBody RenewalRegisterVo renewalRegisterVo,@AuthUserInfo SysUser sysUser){
        renewalRegisterService.renewalRegisterWithdraw(renewalRegisterVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 资管复核
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-10 15:28:42
     */
    @RequestMapping(value = "renewalRegisterReview",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> renewalRegisterReview(@Valid @RequestBody RenewalRegisterVo renewalRegisterVo,@AuthUserInfo SysUser sysUser){
        renewalRegisterService.renewalRegisterReview(renewalRegisterVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 财务制单
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-10 15:28:42
     */
    @RequestMapping(value = "renewalRegisterVoucher",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> renewalRegisterVoucher(@Valid @RequestBody RenewalRegisterVo renewalRegisterVo,@AuthUserInfo SysUser sysUser){
        renewalRegisterService.renewalRegisterVoucher(renewalRegisterVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 财务付款
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-10 15:28:42
     */
    @RequestMapping(value = "renewalRegisterPayment",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> renewalRegisterPayment(@Valid @RequestBody RenewalRegisterVo renewalRegisterVo,@AuthUserInfo SysUser sysUser){
        renewalRegisterService.renewalRegisterPayment(renewalRegisterVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 退回上一级
     * @param renewalRegisterVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-10 15:28:42
     */
    @RequestMapping(value = "renewalRegisterSendBack",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> renewalRegisterSendBack(@Valid @RequestBody RenewalRegisterVo renewalRegisterVo,@AuthUserInfo SysUser sysUser){
        renewalRegisterService.renewalRegisterSendBack(renewalRegisterVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
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
    @RequestMapping(value = "printRenewalRegister",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> printRenewalRegister(@Valid @RequestBody RenewalRegisterVo renewalRegisterVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(renewalRegisterService.printRenewalRegister(renewalRegisterVo)), HttpStatus.OK);
    }
}
