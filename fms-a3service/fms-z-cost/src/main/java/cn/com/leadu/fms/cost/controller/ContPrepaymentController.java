package cn.com.leadu.fms.cost.controller;

import cn.com.leadu.fms.cost.service.ContPrepaymentService;
import cn.com.leadu.fms.cost.validator.contprepayment.vo.ContPrepaymentDeleteListVo;
import cn.com.leadu.fms.cost.validator.contprepayment.vo.ContPrepaymentDeleteVo;
import cn.com.leadu.fms.cost.validator.contprepayment.vo.ContPrepaymentModifyVo;
import cn.com.leadu.fms.cost.validator.contprepayment.vo.ContPrepaymentSaveVo;
import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.cost.vo.contprepayment.ContPrepaymentVo;
import cn.com.leadu.fms.pojo.cost.vo.contprepaymentApprove.ContPrepaymentApproveVo;
import cn.com.leadu.fms.pojo.finance.vo.contreceipt.ContReceiptVo;
import cn.com.leadu.fms.pojo.postbiz.vo.vehicledisposal.VehicleDisposalVo;
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
 * @author yangyiquan
 * @ClassName: ContPrepaymentController
 * @Description: 提前还款相关接口
 * @date 2018-05-10
 */
@RestController
@RequestMapping("cont_prepayment")
public class ContPrepaymentController {

    /**
     * @Fields  : 提前还款service
     */
    @Autowired
    private ContPrepaymentService contPrepaymentService;

    /**
     * @Title:
     * @Description: 分页查询提前还款信息entity
     * @param contPrepaymentVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @RequestMapping(value = "findContPrepaymentsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContPrepaymentsByPage(ContPrepaymentVo contPrepaymentVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contPrepaymentService.findContPrepaymentsByPage(contPrepaymentVo)),
                HttpStatus.OK);
    }

    /** 
    * @Description: 分页查询提前还款vo
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/10 20:14
    */ 
    @RequestMapping(value = "findContPrepaymentListByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContPrepaymentListByPage(ContPrepaymentVo contPrepaymentVo) {
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contPrepaymentService.findContPrepaymentListByPage(contPrepaymentVo)),
                HttpStatus.OK );
    }

    /**
     * @Title:
     * @Description: 保存提前还款
     * @param contPrepaymentSaveVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @RequestMapping(value = "saveContPrepayment",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContPrepayment(@Valid @RequestBody ContPrepaymentSaveVo contPrepaymentSaveVo){
        contPrepaymentService.saveContPrepayment(contPrepaymentSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改提前还款
     * @param contPrepaymentModifyVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @RequestMapping(value = "modifyContPrepayment",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyContPrepayment(@Valid @RequestBody ContPrepaymentModifyVo contPrepaymentModifyVo){
        contPrepaymentService.modifyContPrepayment(contPrepaymentModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除提前还款
     * @param contPrepaymentDeleteVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @RequestMapping(value = "deleteContPrepayment",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteContPrepayment(@Valid @RequestBody ContPrepaymentDeleteVo contPrepaymentDeleteVo){
        contPrepaymentService.deleteContPrepayment(contPrepaymentDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据contPrepaymentId集合删除提前还款
     * @param contPrepaymentDeleteListVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @RequestMapping(value = "deleteContPrepaymentsByContPrepaymentIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteContPrepaymentsByContPrepaymentIds(@Valid @RequestBody ContPrepaymentDeleteListVo contPrepaymentDeleteListVo){
        contPrepaymentService.deleteContPrepaymentsByContPrepaymentIds(contPrepaymentDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据contPrepaymentId获取提前还款
     * @param contPrepaymentId
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-10 17:47:06
     */
    @RequestMapping(value = "findContPrepaymentByContPrepaymentId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContPrepaymentByContPrepaymentId(String contPrepaymentId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contPrepaymentService.findContPrepaymentByContPrepaymentId(contPrepaymentId)), HttpStatus.OK);
    }

    /** 
    * @Description: 根据合同编号获取提前还款信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/11 14:56
    */ 
    @RequestMapping(value = "findContPrepaymentByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContPrepaymentByContNo(String contNo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contPrepaymentService.findContPrepaymentByContNo(contNo)),
                HttpStatus.OK);
    }

    /** 
    * @Description: 根据合同编号构造提前还款和提前还款明细信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/11 16:00
    */ 
    @RequestMapping(value = "findContPrepaymentWithDetailByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContPrepaymentWithDetailByContNo(String contNo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contPrepaymentService.findContPrepaymentWithDetailByContNo(contNo)),
                HttpStatus.OK);
    }

    /**
     * @Description: 根据业务号查询提前还款和提前还款明细信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/20 16:56
     */
    @RequestMapping(value = "findContPrepaymentWithDetailByContPrepaymentNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContPrepaymentWithDetailByContPrepaymentNo(String contPrepaymentNo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contPrepaymentService.findContPrepaymentWithDetailByContPrepaymentNo(contPrepaymentNo)),
                HttpStatus.OK);
    }

    /** 
    * @Description: 保存提前还款和明细
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/14 18:57
    */ 
    @RequestMapping(value = "saveContPrepaymentWithDetail",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContPrepaymentWithDetail(@Valid @RequestBody ContPrepaymentVo contPrepaymentVo, @AuthUserInfo SysUser sysUser){
        contPrepaymentVo.setUser(sysUser.getUser());
        contPrepaymentService.saveContPrepaymentWithDetail(contPrepaymentVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
    * @Description: 财务确认
    * @param:
    * @return:
    * @Author: lijunjun
    * @Date: 2018/5/14 18:57
    */
    @RequestMapping(value = "financeConfirm",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> financeConfirm(@Valid @RequestBody ContReceiptVo contReceiptVo, @AuthUserInfo SysUser sysUser){
        contReceiptVo.setUser(sysUser.getUser());
        contPrepaymentService.financeConfirm(contReceiptVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /** 
    * @Description: 打印提前还款测算单
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/29 15:36
    */ 
    @RequestMapping(value = "printPrepayment",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> printPrepayment(@Valid @RequestBody ContPrepaymentVo contPrepaymentVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contPrepaymentService.printPrepayment(contPrepaymentVo)), HttpStatus.OK);
    }

    /** 
    * @Description: 打印提前还款结清证明
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/29 18:40
    */ 
    @RequestMapping(value = "printPrepaymentJQZM",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> printPrepaymentJQZM(String contPrepaymentNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contPrepaymentService.printPrepaymentJQZM(contPrepaymentNo)), HttpStatus.OK);
    }

    /**
     * @Description: 打印付款单
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/8/27 15:36
     */
    @RequestMapping(value = "printPaymentOrder",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> printPaymentOrder(@Valid @RequestBody ContPrepaymentApproveVo contPrepaymentApproveVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contPrepaymentService.printPaymentOrder(contPrepaymentApproveVo)), HttpStatus.OK);
    }

    /**
     * @Description: 车辆出库(赎回)
     * @param: vehicleDisposalVo 车辆出库信息
     * @param: sysUser 当前用户信息
     * @return:
     * @Author: wangxue
     * @Date: 2018/5/14 18:57
     */
    @RequestMapping(value = "prePayVehicleShipment",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> prePayVehicleShipment(@Valid @RequestBody VehicleDisposalVo vehicleDisposalVo, @AuthUserInfo SysUser sysUser){
        vehicleDisposalVo.setUser(sysUser.getUser());
        contPrepaymentService.prePayVehicleShipment(vehicleDisposalVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
}
