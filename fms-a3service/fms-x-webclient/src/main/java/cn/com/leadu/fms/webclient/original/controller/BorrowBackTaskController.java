package cn.com.leadu.fms.webclient.original.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.original.vo.borrowbacktask.BorrowBackTaskVo;
import cn.com.leadu.fms.webclient.original.rpc.BorrowBackTaskRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: BorrowBackTaskController
 * @Description: 借阅归还任务信息controller
 * @date 2018-06-04
 */
@RestController
@RequestMapping("borrow_back_task")
public class BorrowBackTaskController {

    /**
     * @Fields  : 借阅归还任务信息rpc
     */
    @Autowired
    private BorrowBackTaskRpc borrowBackTaskRpc;

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
        Map borrowBackTaskVoMap = borrowBackTaskVo == null?null:(Map) JSON.toJSON(borrowBackTaskVo);
        return borrowBackTaskRpc.findBorrowBackTasksByPage(borrowBackTaskVoMap);
    }

    /**
     * @Title:
     * @Description: 保存借阅归还任务信息
     * @param borrowBackTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @RequestMapping(value = "saveBorrowBackTask",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBorrowBackTask(@RequestBody BorrowBackTaskVo borrowBackTaskVo){
        return borrowBackTaskRpc.saveBorrowBackTask(borrowBackTaskVo);
    }

    /**
     * @Title:
     * @Description:  修改借阅归还任务信息
     * @param borrowBackTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @RequestMapping(value = "modifyBorrowBackTask",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyBorrowBackTask(@RequestBody BorrowBackTaskVo borrowBackTaskVo){
        return borrowBackTaskRpc.modifyBorrowBackTask(borrowBackTaskVo);
    }

    /**
     * @Title:
     * @Description:   根据borrowBackTaskId集合删除借阅归还任务信息
     * @param borrowBackTaskIds
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @RequestMapping(value = "deleteBorrowBackTasksByBorrowBackTaskIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBorrowBackTasksByBorrowBackTaskIds(@RequestBody List<String> borrowBackTaskIds){
        BorrowBackTaskVo borrowBackTaskVo = new BorrowBackTaskVo();
        borrowBackTaskVo.setBorrowBackTaskIds(borrowBackTaskIds);
        return borrowBackTaskRpc.deleteBorrowBackTasksByBorrowBackTaskIds(borrowBackTaskVo);
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
        return borrowBackTaskRpc.findBorrowBackTaskByBorrowBackTaskId(borrowBackTaskId);
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
        return borrowBackTaskRpc.findBorrowBackTaskByBorrowBackTaskNo(borrowBackTaskNo);
    }

}
