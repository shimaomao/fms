package cn.com.leadu.fms.original.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.original.vo.borrowtaskdetail.BorrowTaskDetailVo;
import cn.com.leadu.fms.original.service.BorrowTaskDetailService;
import cn.com.leadu.fms.original.validator.borrowtaskdetail.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @author yebangqiang
 * @ClassName: BorrowTaskDetailController
 * @Description: 借阅任务明细相关接口
 * @date 2018-07-16
 */
@RestController
@RequestMapping("borrow_task_detail")
public class BorrowTaskDetailController {

    /**
     * @Fields  : 借阅任务明细service
     */
    @Autowired
    private BorrowTaskDetailService borrowTaskDetailService;

    /**
     * @Title:
     * @Description: 分页查询借阅任务明细信息
     * @param borrowTaskDetailVo
     * @return
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:53
     */
    @RequestMapping(value = "findBorrowTaskDetailsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBorrowTaskDetailsByPage(BorrowTaskDetailVo borrowTaskDetailVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(borrowTaskDetailService.findBorrowTaskDetailsByPage(borrowTaskDetailVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存借阅任务明细
     * @param borrowTaskDetailSaveVo
     * @return
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:53
     */
    @RequestMapping(value = "saveBorrowTaskDetail",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBorrowTaskDetail(@Valid @RequestBody BorrowTaskDetailSaveVo borrowTaskDetailSaveVo){
        borrowTaskDetailService.saveBorrowTaskDetail(borrowTaskDetailSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改借阅任务明细
     * @param borrowTaskDetailModifyVo
     * @return
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:53
     */
    @RequestMapping(value = "modifyBorrowTaskDetail",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyBorrowTaskDetail(@Valid @RequestBody BorrowTaskDetailModifyVo borrowTaskDetailModifyVo){
        borrowTaskDetailService.modifyBorrowTaskDetail(borrowTaskDetailModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除借阅任务明细
     * @param borrowTaskDetailDeleteVo
     * @return
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:53
     */
    @RequestMapping(value = "deleteBorrowTaskDetail",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBorrowTaskDetail(@Valid @RequestBody BorrowTaskDetailDeleteVo borrowTaskDetailDeleteVo){
        borrowTaskDetailService.deleteBorrowTaskDetail(borrowTaskDetailDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据borrowTaskDetailId集合删除借阅任务明细
     * @param borrowTaskDetailDeleteListVo
     * @return
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:53
     */
    @RequestMapping(value = "deleteBorrowTaskDetailsByBorrowTaskDetailIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBorrowTaskDetailsByBorrowTaskDetailIds(@Valid @RequestBody BorrowTaskDetailDeleteListVo borrowTaskDetailDeleteListVo){
        borrowTaskDetailService.deleteBorrowTaskDetailsByBorrowTaskDetailIds(borrowTaskDetailDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据borrowTaskDetailId获取借阅任务明细
     * @param borrowTaskDetailId
     * @return
     * @throws
     * @author yebangqiang
     * @date 2018-7-16 17:28:53
     */
    @RequestMapping(value = "findBorrowTaskDetailByBorrowTaskDetailId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBorrowTaskDetailByBorrowTaskDetailId(String borrowTaskDetailId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(borrowTaskDetailService.findBorrowTaskDetailByBorrowTaskDetailId(borrowTaskDetailId)), HttpStatus.OK);
    }

}
