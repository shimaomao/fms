package cn.com.leadu.fms.webclient.activiti.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.activiti.vo.actuserleave.ActUserLeaveVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: ActUserLeaveController
 * @Description: 用户请假rpc
 * @date 2018-03-14
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ActUserLeaveRpc {

    /**
     * @Title:
     * @Description: 分页查询用户请假信息
     * @param actUserLeaveVoMap
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    @RequestMapping(value = "api/activiti/act_user_leave/findActUserLeavesByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findActUserLeavesByPage(@RequestParam Map<String, Object> actUserLeaveVoMap);

    /**
     * @Title:
     * @Description: 保存用户请假
     * @param actUserLeaveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    @RequestMapping(value = "api/activiti/act_user_leave/saveActUserLeave",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveActUserLeave(@RequestBody ActUserLeaveVo actUserLeaveVo);

    /**
     * @Title:
     * @Description:  修改用户请假
     * @param sysOrganizationPropertyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    @RequestMapping(value = "api/activiti/act_user_leave/modifyActUserLeave",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyActUserLeave(@RequestBody ActUserLeaveVo actUserLeaveVo);

    /**
     * @Title:
     * @Description:   根据leaveId集合删除用户请假
     * @param actUserLeaveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    @RequestMapping(value = "api/activiti/act_user_leave/deleteActUserLeavesByLeaveIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteActUserLeavesByLeaveIds(@RequestBody ActUserLeaveVo actUserLeaveVo);

    /**
     * @Title:
     * @Description:  根据leaveId获取用户请假
     * @param leaveId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    @RequestMapping(value = "api/activiti/act_user_leave/findActUserLeaveByLeaveId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findActUserLeaveByLeaveId(@RequestParam("leaveId") String leaveId);

    /**
     * @Title:
     * @Description:  根据leaveId获取用户请假
     * @param taskId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:51
     */
    @RequestMapping(value = "api/activiti/act_user_leave/adopt", method = RequestMethod.POST)
    ResponseEntity<RestResponse> adopt(@RequestParam("taskId") String taskId);

}
