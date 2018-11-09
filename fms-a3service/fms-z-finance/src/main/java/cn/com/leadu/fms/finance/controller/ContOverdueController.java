package cn.com.leadu.fms.finance.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.finance.vo.contoverdue.ContOverdueVo;
import cn.com.leadu.fms.finance.service.ContOverdueService;
import cn.com.leadu.fms.finance.validator.contoverdue.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @author lijunjun
 * @ClassName: ContOverdueController
 * @Description: 还款逾期罚息相关接口
 * @date 2018-05-08
 */
@RestController
@RequestMapping("cont_overdue")
public class ContOverdueController {

    /**
     * @Fields  : 还款逾期罚息service
     */
    @Autowired
    private ContOverdueService contOverdueService;

    /**
     * @Title:
     * @Description: 分页查询还款逾期罚息信息
     * @param contOverdueVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @RequestMapping(value = "findContOverduesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContOverduesByPage(ContOverdueVo contOverdueVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contOverdueService.findContOverduesByPage(contOverdueVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存还款逾期罚息
     * @param contOverdueSaveVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @RequestMapping(value = "saveContOverdue",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContOverdue(@Valid @RequestBody ContOverdueSaveVo contOverdueSaveVo){
        contOverdueService.saveContOverdue(contOverdueSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改还款逾期罚息
     * @param contOverdueModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @RequestMapping(value = "modifyContOverdue",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyContOverdue(@Valid @RequestBody ContOverdueModifyVo contOverdueModifyVo){
        contOverdueService.modifyContOverdue(contOverdueModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除还款逾期罚息
     * @param contOverdueDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @RequestMapping(value = "deleteContOverdue",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteContOverdue(@Valid @RequestBody ContOverdueDeleteVo contOverdueDeleteVo){
        contOverdueService.deleteContOverdue(contOverdueDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据contOverdueId集合删除还款逾期罚息
     * @param contOverdueDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @RequestMapping(value = "deleteContOverduesByContOverdueIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteContOverduesByContOverdueIds(@Valid @RequestBody ContOverdueDeleteListVo contOverdueDeleteListVo){
        contOverdueService.deleteContOverduesByContOverdueIds(contOverdueDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据contOverdueId获取还款逾期罚息
     * @param contOverdueId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @RequestMapping(value = "findContOverdueByContOverdueId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContOverdueByContOverdueId(String contOverdueId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contOverdueService.findContOverdueByContOverdueId(contOverdueId)), HttpStatus.OK);
    }

    /** 
    * @Description: 查询逾期罚息表中，扣款状态<>成功 的剩余罚息金额合计
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/14 14:45
    */ 
    @RequestMapping(value = "findOverdueInterestSum", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueInterestSum(String contNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contOverdueService.findOverdueInterestSum(contNo)), HttpStatus.OK);
    }

    /**
     * @Description: 根据合同号查找总罚息
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/23 14:45
     */
    @RequestMapping(value = "findContOverdueAmountByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContOverdueAmountByContNo(String contNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contOverdueService.findContOverdueAmountByContNo(contNo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据合同号查询逾期罚息表
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "findContOverdueByCont", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContOverdueByCont(String contNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contOverdueService.findContOverdueByCont(contNo)), HttpStatus.OK);
    }
}
