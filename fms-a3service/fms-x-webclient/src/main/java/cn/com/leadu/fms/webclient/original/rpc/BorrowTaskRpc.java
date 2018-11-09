package cn.com.leadu.fms.webclient.original.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.original.vo.borrowtask.BorrowTaskVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: BorrowTaskController
 * @Description: 借阅任务信息rpc
 * @date 2018-05-30
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface BorrowTaskRpc {

    /**
     * @Title:
     * @Description: 分页查询借阅任务信息信息
     * @param borrowTaskVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-30 16:21:19
     */
    @RequestMapping(value = "api/original/borrow_task/findBorrowTasksByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBorrowTasksByPage(@RequestParam Map<String, Object> borrowTaskVoMap);

    /**
     * @Title:
     * @Description: 保存借阅任务信息
     * @param borrowTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-30 16:21:19
     */
    @RequestMapping(value = "api/original/borrow_task/saveBorrowTask",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveBorrowTask(@RequestBody BorrowTaskVo borrowTaskVo);

    /**
     * @Title:
     * @Description:  修改借阅任务信息
     * @param borrowTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-30 16:21:19
     */
    @RequestMapping(value = "api/original/borrow_task/modifyBorrowTask",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyBorrowTask(@RequestBody BorrowTaskVo borrowTaskVo);

    /**
     * @Title:
     * @Description:   根据borrowTaskId集合删除借阅任务信息
     * @param borrowTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-30 16:21:19
     */
    @RequestMapping(value = "api/original/borrow_task/deleteBorrowTasksByBorrowTaskIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteBorrowTasksByBorrowTaskIds(@RequestBody BorrowTaskVo borrowTaskVo);

    /**
     * @Title:
     * @Description:  根据borrowTaskId获取借阅任务信息
     * @param borrowTaskId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-30 16:21:19
     */
    @RequestMapping(value = "api/original/borrow_task/findBorrowTaskByBorrowTaskId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBorrowTaskByBorrowTaskId(@RequestParam("borrowTaskId") String borrowTaskId);

    /**
     * @Title:
     * @Description:  根据borrowTaskNo获取借阅任务信息
     * @param borrowTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-30 16:21:19
     */
    @RequestMapping(value = "api/original/borrow_task/findBorrowTaskByBorrowTaskNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBorrowTaskByBorrowTaskNo(@RequestParam("borrowTaskNo") String borrowTaskNo);

}
