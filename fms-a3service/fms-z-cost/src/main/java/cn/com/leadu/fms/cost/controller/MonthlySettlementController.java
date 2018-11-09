package cn.com.leadu.fms.cost.controller;

import cn.com.leadu.fms.cost.service.MonthlySettlementService;
import cn.com.leadu.fms.cost.validator.monthlysettlement.vo.MonthlySettlementDeleteListVo;
import cn.com.leadu.fms.cost.validator.monthlysettlement.vo.MonthlySettlementDeleteVo;
import cn.com.leadu.fms.cost.validator.monthlysettlement.vo.MonthlySettlementModifyVo;
import cn.com.leadu.fms.cost.validator.monthlysettlement.vo.MonthlySettlementSaveVo;
import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.cost.vo.monthlysettlement.MonthlySettlementVo;
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
 * @ClassName: MonthlySettlementController
 * @Description: gps月结任务表相关接口
 * @date 2018-05-28
 */
@RestController
@RequestMapping("monthly_settlement")
public class MonthlySettlementController {

    /**
     * @Fields  : gps月结任务表service
     */
    @Autowired
    private MonthlySettlementService monthlySettlementService;

    /**
     * @Title:
     * @Description: 分页查询gps月结任务表信息
     * @param monthlySettlementVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @RequestMapping(value = "findMonthlySettlementsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findMonthlySettlementsByPage(MonthlySettlementVo monthlySettlementVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(monthlySettlementService.findMonthlySettlementsByPage(monthlySettlementVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存gps月结任务表
     * @param monthlySettlementSaveVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @RequestMapping(value = "saveMonthlySettlement",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveMonthlySettlement(@Valid @RequestBody MonthlySettlementSaveVo monthlySettlementSaveVo){
        monthlySettlementService.saveMonthlySettlement(monthlySettlementSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /** 
    * @Description: 月结申请
    * @param:  
     @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/29 10:15
    */ 
    @RequestMapping(value = "saveMonthlySettlementWithGps",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveMonthlySettlementWithGps(@Valid @RequestBody MonthlySettlementVo monthlySettlementVo, @AuthUserInfo SysUser sysUser){
        monthlySettlementVo.setPresentUser(sysUser.getUser());
        monthlySettlementService.saveMonthlySettlementWithGps(monthlySettlementVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改gps月结任务表
     * @param monthlySettlementModifyVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @RequestMapping(value = "modifyMonthlySettlement",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyMonthlySettlement(@Valid @RequestBody MonthlySettlementModifyVo monthlySettlementModifyVo){
        monthlySettlementService.modifyMonthlySettlement(monthlySettlementModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除gps月结任务表
     * @param monthlySettlementDeleteVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @RequestMapping(value = "deleteMonthlySettlement",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteMonthlySettlement(@Valid @RequestBody MonthlySettlementDeleteVo monthlySettlementDeleteVo){
        monthlySettlementService.deleteMonthlySettlement(monthlySettlementDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据monthlySettlementId集合删除gps月结任务表
     * @param monthlySettlementDeleteListVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @RequestMapping(value = "deleteMonthlySettlementsByMonthlySettlementIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteMonthlySettlementsByMonthlySettlementIds(@Valid @RequestBody MonthlySettlementDeleteListVo monthlySettlementDeleteListVo){
        monthlySettlementService.deleteMonthlySettlementsByMonthlySettlementIds(monthlySettlementDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据monthlySettlementId获取gps月结任务表
     * @param monthlySettlementId
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @RequestMapping(value = "findMonthlySettlementByMonthlySettlementId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findMonthlySettlementByMonthlySettlementId(String monthlySettlementId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(monthlySettlementService.findMonthlySettlementByMonthlySettlementId(monthlySettlementId)), HttpStatus.OK);
    }

    /** 
    * @Description:  根据monthlySettlementNo获取gps月结任务表
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/30 17:16
    */ 
    @RequestMapping(value = "findMonthlySettlementBySettlementNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findMonthlySettlementBySettlementNo(String monthlySettlementNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(monthlySettlementService.findMonthlySettlementBySettlementNo(monthlySettlementNo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据monthlySettlementNo获取gps月结任务表(含附件)
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "findMonthlySettlementVoBySettlementNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findMonthlySettlementVoBySettlementNo(String monthlySettlementNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(monthlySettlementService.findMonthlySettlementVoBySettlementNo(monthlySettlementNo)), HttpStatus.OK);
    }
}
