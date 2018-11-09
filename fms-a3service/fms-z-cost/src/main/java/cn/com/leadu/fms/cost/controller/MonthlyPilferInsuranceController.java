package cn.com.leadu.fms.cost.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.cost.vo.monthlypilferinsurance.MonthlyPilferInsuranceVo;
import cn.com.leadu.fms.cost.service.MonthlyPilferInsuranceService;
import cn.com.leadu.fms.cost.validator.monthlypilferinsurance.vo.*;
import cn.com.leadu.fms.pojo.cost.vo.monthlypilferinsurance.PilferInsuranceApproveVo;
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
 * @ClassName: MonthlyPilferInsuranceController
 * @Description: 盗抢险月结任务信息相关接口
 * @date 2018-05-31
 */
@RestController
@RequestMapping("monthly_pilfer_insurance")
public class MonthlyPilferInsuranceController {

    /**
     * @Fields  : 盗抢险月结任务信息service
     */
    @Autowired
    private MonthlyPilferInsuranceService monthlyPilferInsuranceService;

    /**
     * @Title:
     * @Description: 分页查询盗抢险月结任务信息信息
     * @param monthlyPilferInsuranceVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @RequestMapping(value = "findMonthlyPilferInsurancesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findMonthlyPilferInsurancesByPage(MonthlyPilferInsuranceVo monthlyPilferInsuranceVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(monthlyPilferInsuranceService.findMonthlyPilferInsurancesByPage(monthlyPilferInsuranceVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存盗抢险月结任务信息
     * @param monthlyPilferInsuranceSaveVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @RequestMapping(value = "saveMonthlyPilferInsurance",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveMonthlyPilferInsurance(@Valid @RequestBody MonthlyPilferInsuranceSaveVo monthlyPilferInsuranceSaveVo){
        monthlyPilferInsuranceService.saveMonthlyPilferInsurance(monthlyPilferInsuranceSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /** 
    * @Description: 保存盗抢险月结任务信息，包括盗抢险信息 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/31 21:34
    */ 
    @RequestMapping(value = "saveMonthlyPilferInsuranceWithPI",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveMonthlyPilferInsuranceWithPI(@Valid @RequestBody MonthlyPilferInsuranceVo monthlyPilferInsuranceVo, @AuthUserInfo SysUser sysUser){
        monthlyPilferInsuranceVo.setPresentUser(sysUser.getUser());
        monthlyPilferInsuranceService.saveMonthlyPilferInsuranceWithPI(monthlyPilferInsuranceVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改盗抢险月结任务信息
     * @param monthlyPilferInsuranceModifyVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @RequestMapping(value = "modifyMonthlyPilferInsurance",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyMonthlyPilferInsurance(@Valid @RequestBody MonthlyPilferInsuranceModifyVo monthlyPilferInsuranceModifyVo){
        monthlyPilferInsuranceService.modifyMonthlyPilferInsurance(monthlyPilferInsuranceModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除盗抢险月结任务信息
     * @param monthlyPilferInsuranceDeleteVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @RequestMapping(value = "deleteMonthlyPilferInsurance",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteMonthlyPilferInsurance(@Valid @RequestBody MonthlyPilferInsuranceDeleteVo monthlyPilferInsuranceDeleteVo){
        monthlyPilferInsuranceService.deleteMonthlyPilferInsurance(monthlyPilferInsuranceDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据monthlyPilferInsuranceId集合删除盗抢险月结任务信息
     * @param monthlyPilferInsuranceDeleteListVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @RequestMapping(value = "deleteMonthlyPilferInsurancesByMonthlyPilferInsuranceIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteMonthlyPilferInsurancesByMonthlyPilferInsuranceIds(@Valid @RequestBody MonthlyPilferInsuranceDeleteListVo monthlyPilferInsuranceDeleteListVo){
        monthlyPilferInsuranceService.deleteMonthlyPilferInsurancesByMonthlyPilferInsuranceIds(monthlyPilferInsuranceDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据monthlyPilferInsuranceId获取盗抢险月结任务信息
     * @param monthlyPilferInsuranceId
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @RequestMapping(value = "findMonthlyPilferInsuranceByMonthlyPilferInsuranceId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findMonthlyPilferInsuranceByMonthlyPilferInsuranceId(String monthlyPilferInsuranceId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(monthlyPilferInsuranceService.findMonthlyPilferInsuranceByMonthlyPilferInsuranceId(monthlyPilferInsuranceId)), HttpStatus.OK);
    }

    /** 
    * @Description: 根据monthlyPilferInsuranceNo获取盗抢险月结任务信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/1 11:50
    */ 
    @RequestMapping(value = "findMonthlyPilferInsuranceByPilferInsuranceNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findMonthlyPilferInsuranceByPilferInsuranceNo(String monthlyPilferInsuranceNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(monthlyPilferInsuranceService.findMonthlyPilferInsuranceByPilferInsuranceNo(monthlyPilferInsuranceNo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据monthlyPilferInsuranceNo获取盗抢险月结任务信息(含附件)
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "findMonthlyPilferInsuranceVoByPilferInsuranceNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findMonthlyPilferInsuranceVoByPilferInsuranceNo(String monthlyPilferInsuranceNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(monthlyPilferInsuranceService.findMonthlyPilferInsuranceVoByPilferInsuranceNo(monthlyPilferInsuranceNo)), HttpStatus.OK);
    }

    /** 
    * @Description: 月结审批操作
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/1 11:53
    */ 
    @RequestMapping(value = "approval",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> approval(@Valid @RequestBody PilferInsuranceApproveVo pilferInsuranceApproveVo, @AuthUserInfo SysUser sysUser){
        pilferInsuranceApproveVo.setUser(sysUser.getUser());
        monthlyPilferInsuranceService.approval(pilferInsuranceApproveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

}
