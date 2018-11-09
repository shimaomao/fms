package cn.com.leadu.fms.webclient.original.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.original.vo.borrowtask.BorrowTaskVo;
import cn.com.leadu.fms.webclient.original.rpc.BorrowTaskRpc;
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
 * @ClassName: BorrowTaskController
 * @Description: 借阅任务信息controller
 * @date 2018-05-30
 */
@RestController
@RequestMapping("borrow_task")
public class BorrowTaskController {

    /**
     * @Fields  : 借阅任务信息rpc
     */
    @Autowired
    private BorrowTaskRpc borrowTaskRpc;

    /**
     * @Title:
     * @Description: 分页查询借阅任务信息信息
     * @param borrowTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-30 16:21:19
     */
    @RequestMapping(value = "findBorrowTasksByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBorrowTasksByPage(BorrowTaskVo borrowTaskVo){
        Map borrowTaskVoMap = borrowTaskVo == null?null:(Map) JSON.toJSON(borrowTaskVo);
        return borrowTaskRpc.findBorrowTasksByPage(borrowTaskVoMap);
    }

    /**
     * @Title:
     * @Description: 保存借阅任务信息
     * @param borrowTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-30 16:21:19
     */
    @RequestMapping(value = "saveBorrowTask",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBorrowTask(@RequestBody BorrowTaskVo borrowTaskVo){
        return borrowTaskRpc.saveBorrowTask(borrowTaskVo);
    }

    /**
     * @Title:
     * @Description:  修改借阅任务信息
     * @param borrowTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-30 16:21:19
     */
    @RequestMapping(value = "modifyBorrowTask",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyBorrowTask(@RequestBody BorrowTaskVo borrowTaskVo){
        return borrowTaskRpc.modifyBorrowTask(borrowTaskVo);
    }

    /**
     * @Title:
     * @Description:   根据borrowTaskId集合删除借阅任务信息
     * @param borrowTaskIds
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-30 16:21:19
     */
    @RequestMapping(value = "deleteBorrowTasksByBorrowTaskIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBorrowTasksByBorrowTaskIds(@RequestBody List<String> borrowTaskIds){
        BorrowTaskVo borrowTaskVo = new BorrowTaskVo();
        borrowTaskVo.setBorrowTaskIds(borrowTaskIds);
        return borrowTaskRpc.deleteBorrowTasksByBorrowTaskIds(borrowTaskVo);
    }

    /**
     * @Title:
     * @Description:  根据borrowTaskId获取借阅任务信息
     * @param borrowTaskId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-30 16:21:19
     */
    @RequestMapping(value = "findBorrowTaskByBorrowTaskId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBorrowTaskByBorrowTaskId(String borrowTaskId){
        return borrowTaskRpc.findBorrowTaskByBorrowTaskId(borrowTaskId);
    }

    /**
     * @Title:
     * @Description:  根据borrowTaskNo获取借阅任务信息
     * @param borrowTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-30 16:21:19
     */
    @RequestMapping(value = "findBorrowTaskByBorrowTaskNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBorrowTaskByBorrowTaskNo(String borrowTaskNo){
        return borrowTaskRpc.findBorrowTaskByBorrowTaskNo(borrowTaskNo);
    }

}
