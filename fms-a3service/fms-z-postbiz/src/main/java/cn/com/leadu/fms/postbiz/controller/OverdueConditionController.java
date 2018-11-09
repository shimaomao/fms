package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecondition.OverdueConditionVo;
import cn.com.leadu.fms.postbiz.service.OverdueConditionService;
import cn.com.leadu.fms.postbiz.validator.overduecondition.vo.*;
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
 * @ClassName: OverdueConditionController
 * @Description: 逾期状态维护相关接口
 * @date 2018-05-11
 */
@RestController
@RequestMapping("overdue_condition")
public class OverdueConditionController {

    /**
     * @Fields  : 逾期状态维护service
     */
    @Autowired
    private OverdueConditionService overdueConditionService;

    /**
     * @Title:
     * @Description: 分页查询逾期状态维护信息
     * @param overdueConditionVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:16
     */
    @RequestMapping(value = "findOverdueConditionsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueConditionsByPage(OverdueConditionVo overdueConditionVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(overdueConditionService.findOverdueConditionsByPage(overdueConditionVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存逾期状态维护
     * @param overdueConditionSaveVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:16
     */
    @RequestMapping(value = "saveOverdueCondition",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveOverdueCondition(@Valid @RequestBody OverdueConditionSaveVo overdueConditionSaveVo){
        overdueConditionService.saveOverdueCondition(overdueConditionSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改逾期状态维护
     * @param overdueConditionModifyVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:16
     */
    @RequestMapping(value = "modifyOverdueCondition",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyOverdueCondition(@Valid @RequestBody OverdueConditionModifyVo overdueConditionModifyVo){
        overdueConditionService.modifyOverdueCondition(overdueConditionModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除逾期状态维护
     * @param overdueConditionDeleteVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:16
     */
    @RequestMapping(value = "deleteOverdueCondition",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteOverdueCondition(@Valid @RequestBody OverdueConditionDeleteVo overdueConditionDeleteVo){
        overdueConditionService.deleteOverdueCondition(overdueConditionDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据overdueConditionId集合删除逾期状态维护
     * @param overdueConditionDeleteListVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:16
     */
    @RequestMapping(value = "deleteOverdueConditionsByOverdueConditionIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteOverdueConditionsByOverdueConditionIds(@Valid @RequestBody OverdueConditionDeleteListVo overdueConditionDeleteListVo){
        overdueConditionService.deleteOverdueConditionsByOverdueConditionIds(overdueConditionDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据overdueConditionId获取逾期状态维护
     * @param overdueConditionId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:16
     */
    @RequestMapping(value = "findOverdueConditionByOverdueConditionId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueConditionByOverdueConditionId(String overdueConditionId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(overdueConditionService.findOverdueConditionByOverdueConditionId(overdueConditionId)), HttpStatus.OK);
    }

}
