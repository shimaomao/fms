package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.overdueassignment.OverdueAssignmentVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.OverdueCstmSaveVo;
import cn.com.leadu.fms.postbiz.service.OverdueAssignmentService;
import cn.com.leadu.fms.postbiz.validator.overdueassignment.vo.*;
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
 * @ClassName: OverdueAssignmentController
 * @Description: 当日逾期任务信息相关接口
 * @date 2018-05-16
 */
@RestController
@RequestMapping("overdue_assignment")
public class OverdueAssignmentController {

    /**
     * @Fields  : 当日逾期任务信息service
     */
    @Autowired
    private OverdueAssignmentService overdueAssignmentService;

    /**
     * @Title:
     * @Description: 分页查询当日逾期任务信息信息
     * @param overdueAssignmentVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @RequestMapping(value = "findOverdueAssignmentsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueAssignmentsByPage(OverdueAssignmentVo overdueAssignmentVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(overdueAssignmentService.findOverdueAssignmentsByPage(overdueAssignmentVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存当日逾期任务信息
     * @param overdueAssignmentSaveVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @RequestMapping(value = "saveOverdueAssignment",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveOverdueAssignment(@Valid @RequestBody OverdueAssignmentSaveVo overdueAssignmentSaveVo){
        overdueAssignmentService.saveOverdueAssignment(overdueAssignmentSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 催收任务分配，更新当日逾期任务信息
     * @param overdueCstmSaveVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @RequestMapping(value = "saveAssignment",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveAssignment(@Valid @RequestBody OverdueCstmSaveVo overdueCstmSaveVo){
        overdueAssignmentService.saveAssignment(overdueCstmSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改当日逾期任务信息
     * @param overdueAssignmentModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @RequestMapping(value = "modifyOverdueAssignment",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyOverdueAssignment(@Valid @RequestBody OverdueAssignmentModifyVo overdueAssignmentModifyVo){
        overdueAssignmentService.modifyOverdueAssignment(overdueAssignmentModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除当日逾期任务信息
     * @param overdueAssignmentDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @RequestMapping(value = "deleteOverdueAssignment",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteOverdueAssignment(@Valid @RequestBody OverdueAssignmentDeleteVo overdueAssignmentDeleteVo){
        overdueAssignmentService.deleteOverdueAssignment(overdueAssignmentDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据overdueAssignmentId集合删除当日逾期任务信息
     * @param overdueAssignmentDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @RequestMapping(value = "deleteOverdueAssignmentsByOverdueAssignmentIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteOverdueAssignmentsByOverdueAssignmentIds(@Valid @RequestBody OverdueAssignmentDeleteListVo overdueAssignmentDeleteListVo){
        overdueAssignmentService.deleteOverdueAssignmentsByOverdueAssignmentIds(overdueAssignmentDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据overdueAssignmentId获取当日逾期任务信息
     * @param overdueAssignmentId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @RequestMapping(value = "findOverdueAssignmentByOverdueAssignmentId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueAssignmentByOverdueAssignmentId(String overdueAssignmentId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(overdueAssignmentService.findOverdueAssignmentByOverdueAssignmentId(overdueAssignmentId)), HttpStatus.OK);
    }

}
