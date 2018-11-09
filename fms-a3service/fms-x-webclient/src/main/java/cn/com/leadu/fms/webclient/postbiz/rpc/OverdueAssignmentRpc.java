package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.overdueassignment.OverdueAssignmentVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.OverdueCstmSaveVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: OverdueAssignmentController
 * @Description: 当日逾期任务信息rpc
 * @date 2018-05-16
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface OverdueAssignmentRpc {

    /**
     * @Title:
     * @Description: 分页查询当日逾期任务信息信息
     * @param overdueAssignmentVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @RequestMapping(value = "api/postbiz/overdue_assignment/findOverdueAssignmentsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOverdueAssignmentsByPage(@RequestParam Map<String, Object> overdueAssignmentVoMap);

    /**
     * @Title:
     * @Description: 保存当日逾期任务信息
     * @param overdueAssignmentVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @RequestMapping(value = "api/postbiz/overdue_assignment/saveOverdueAssignment",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveOverdueAssignment(@RequestBody OverdueAssignmentVo overdueAssignmentVo);

    /**
     * @Title:
     * @Description: 催收任务分配，更新当日逾期任务信息
     * @param overdueCstmSaveVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @RequestMapping(value = "api/postbiz/overdue_assignment/saveAssignment",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveAssignment(@RequestBody OverdueCstmSaveVo overdueCstmSaveVo);

    /**
     * @Title:
     * @Description:  修改当日逾期任务信息
     * @param overdueAssignmentVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @RequestMapping(value = "api/postbiz/overdue_assignment/modifyOverdueAssignment",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyOverdueAssignment(@RequestBody OverdueAssignmentVo overdueAssignmentVo);

    /**
     * @Title:
     * @Description:   根据overdueAssignmentId集合删除当日逾期任务信息
     * @param overdueAssignmentVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @RequestMapping(value = "api/system/overdue_assignment/deleteOverdueAssignmentsByOverdueAssignmentIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteOverdueAssignmentsByOverdueAssignmentIds(@RequestBody OverdueAssignmentVo overdueAssignmentVo);

    /**
     * @Title:
     * @Description:  根据overdueAssignmentId获取当日逾期任务信息
     * @param overdueAssignmentId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @RequestMapping(value = "api/postbiz/overdue_assignment/findOverdueAssignmentByOverdueAssignmentId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOverdueAssignmentByOverdueAssignmentId(@RequestParam("overdueAssignmentId") String overdueAssignmentId);

}
