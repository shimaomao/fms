package cn.com.leadu.fms.webclient.original.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.original.vo.borrowbacktask.BorrowBackTaskVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: BorrowBackTaskController
 * @Description: 借阅归还任务信息rpc
 * @date 2018-06-04
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface BorrowBackTaskRpc {

    /**
     * @Title:
     * @Description: 分页查询借阅归还任务信息信息
     * @param borrowBackTaskVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @RequestMapping(value = "api/original/borrow_back_task/findBorrowBackTasksByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBorrowBackTasksByPage(@RequestParam Map<String, Object> borrowBackTaskVoMap);

    /**
     * @Title:
     * @Description: 保存借阅归还任务信息
     * @param borrowBackTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @RequestMapping(value = "api/original/borrow_back_task/saveBorrowBackTask",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveBorrowBackTask(@RequestBody BorrowBackTaskVo borrowBackTaskVo);

    /**
     * @Title:
     * @Description:  修改借阅归还任务信息
     * @param borrowBackTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @RequestMapping(value = "api/original/borrow_back_task/modifyBorrowBackTask",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyBorrowBackTask(@RequestBody BorrowBackTaskVo borrowBackTaskVo);

    /**
     * @Title:
     * @Description:   根据borrowBackTaskId集合删除借阅归还任务信息
     * @param borrowBackTaskVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @RequestMapping(value = "api/original/borrow_back_task/deleteBorrowBackTasksByBorrowBackTaskIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteBorrowBackTasksByBorrowBackTaskIds(@RequestBody BorrowBackTaskVo borrowBackTaskVo);

    /**
     * @Title:
     * @Description:  根据borrowBackTaskId获取借阅归还任务信息
     * @param borrowBackTaskId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @RequestMapping(value = "api/original/borrow_back_task/findBorrowBackTaskByBorrowBackTaskId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBorrowBackTaskByBorrowBackTaskId(@RequestParam("borrowBackTaskId") String borrowBackTaskId);

    /**
     * @Title:
     * @Description:  根据borrowBackTaskNo获取借阅归还任务信息
     * @param borrowBackTaskNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-6-4 10:42:26
     */
    @RequestMapping(value = "api/original/borrow_back_task/findBorrowBackTaskByBorrowBackTaskNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBorrowBackTaskByBorrowBackTaskNo(@RequestParam("borrowBackTaskNo") String borrowBackTaskNo);

}
