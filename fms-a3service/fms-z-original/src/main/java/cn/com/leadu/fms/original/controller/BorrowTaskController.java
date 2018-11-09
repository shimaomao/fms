package cn.com.leadu.fms.original.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.original.vo.borrowtask.BorrowTaskVo;
import cn.com.leadu.fms.original.service.BorrowTaskService;
import cn.com.leadu.fms.original.validator.borrowtask.vo.*;
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
 * @ClassName: BorrowTaskController
 * @Description: 借阅任务信息相关接口
 * @date 2018-05-30
 */
@RestController
@RequestMapping("borrow_task")
public class BorrowTaskController {

    /**
     * @Fields  : 借阅任务信息service
     */
    @Autowired
    private BorrowTaskService borrowTaskService;

    /**
     * @Title:
     * @Description: 分页查询借阅任务信息信息
     * @param borrowTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-30 16:21:18
     */
    @RequestMapping(value = "findBorrowTasksByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBorrowTasksByPage(BorrowTaskVo borrowTaskVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(borrowTaskService.findBorrowTasksByPage(borrowTaskVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存借阅任务信息
     * @param borrowTaskSaveVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-30 16:21:18
     */
    @RequestMapping(value = "saveBorrowTask",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBorrowTask(@Valid @RequestBody BorrowTaskSaveVo borrowTaskSaveVo){
        borrowTaskService.saveBorrowTask(borrowTaskSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改借阅任务信息
     * @param borrowTaskModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-30 16:21:18
     */
    @RequestMapping(value = "modifyBorrowTask",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyBorrowTask(@Valid @RequestBody BorrowTaskModifyVo borrowTaskModifyVo){
        borrowTaskService.modifyBorrowTask(borrowTaskModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除借阅任务信息
     * @param borrowTaskDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-30 16:21:18
     */
    @RequestMapping(value = "deleteBorrowTask",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBorrowTask(@Valid @RequestBody BorrowTaskDeleteVo borrowTaskDeleteVo){
        borrowTaskService.deleteBorrowTask(borrowTaskDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据borrowTaskId集合删除借阅任务信息
     * @param borrowTaskDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-30 16:21:18
     */
    @RequestMapping(value = "deleteBorrowTasksByBorrowTaskIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBorrowTasksByBorrowTaskIds(@Valid @RequestBody BorrowTaskDeleteListVo borrowTaskDeleteListVo){
        borrowTaskService.deleteBorrowTasksByBorrowTaskIds(borrowTaskDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据borrowTaskId获取借阅任务信息
     * @param borrowTaskId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-30 16:21:18
     */
    @RequestMapping(value = "findBorrowTaskByBorrowTaskId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBorrowTaskByBorrowTaskId(String borrowTaskId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(borrowTaskService.findBorrowTaskByBorrowTaskId(borrowTaskId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据borrowTaskNo获取借阅任务信息
     * @param borrowTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-30 16:21:18
     */
    @RequestMapping(value = "findBorrowTaskByBorrowTaskNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBorrowTaskByBorrowTaskNo(String borrowTaskNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(borrowTaskService.findBorrowTaskByBorrowTaskNo(borrowTaskNo)), HttpStatus.OK);
    }

}
