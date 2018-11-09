package cn.com.leadu.fms.original.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.original.vo.borrowbacktask.BorrowBackTaskVo;
import cn.com.leadu.fms.original.service.BorrowBackTaskService;
import cn.com.leadu.fms.original.validator.borrowbacktask.vo.*;
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
 * @ClassName: BorrowBackTaskController
 * @Description: 借阅归还任务信息相关接口
 * @date 2018-06-04
 */
@RestController
@RequestMapping("borrow_back_task")
public class BorrowBackTaskController {

    /**
     * @Fields  : 借阅归还任务信息service
     */
    @Autowired
    private BorrowBackTaskService borrowBackTaskService;

    /**
     * @Title:
     * @Description: 分页查询借阅归还任务信息信息
     * @param borrowBackTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @RequestMapping(value = "findBorrowBackTasksByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBorrowBackTasksByPage(BorrowBackTaskVo borrowBackTaskVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(borrowBackTaskService.findBorrowBackTasksByPage(borrowBackTaskVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存借阅归还任务信息
     * @param borrowBackTaskSaveVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @RequestMapping(value = "saveBorrowBackTask",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBorrowBackTask(@Valid @RequestBody BorrowBackTaskSaveVo borrowBackTaskSaveVo){
        borrowBackTaskService.saveBorrowBackTask(borrowBackTaskSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改借阅归还任务信息
     * @param borrowBackTaskModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @RequestMapping(value = "modifyBorrowBackTask",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyBorrowBackTask(@Valid @RequestBody BorrowBackTaskModifyVo borrowBackTaskModifyVo){
        borrowBackTaskService.modifyBorrowBackTask(borrowBackTaskModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除借阅归还任务信息
     * @param borrowBackTaskDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @RequestMapping(value = "deleteBorrowBackTask",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBorrowBackTask(@Valid @RequestBody BorrowBackTaskDeleteVo borrowBackTaskDeleteVo){
        borrowBackTaskService.deleteBorrowBackTask(borrowBackTaskDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据borrowBackTaskId集合删除借阅归还任务信息
     * @param borrowBackTaskDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @RequestMapping(value = "deleteBorrowBackTasksByBorrowBackTaskIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBorrowBackTasksByBorrowBackTaskIds(@Valid @RequestBody BorrowBackTaskDeleteListVo borrowBackTaskDeleteListVo){
        borrowBackTaskService.deleteBorrowBackTasksByBorrowBackTaskIds(borrowBackTaskDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据borrowBackTaskId获取借阅归还任务信息
     * @param borrowBackTaskId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @RequestMapping(value = "findBorrowBackTaskByBorrowBackTaskId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBorrowBackTaskByBorrowBackTaskId(String borrowBackTaskId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(borrowBackTaskService.findBorrowBackTaskByBorrowBackTaskId(borrowBackTaskId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据borrowBackTaskNo获取借阅归还任务信息
     * @param borrowBackTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @RequestMapping(value = "findBorrowBackTaskByBorrowBackTaskNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBorrowBackTaskByBorrowBackTaskNo(String borrowBackTaskNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(borrowBackTaskService.findBorrowBackTaskByBorrowBackTaskNo(borrowBackTaskNo)), HttpStatus.OK);
    }

}
