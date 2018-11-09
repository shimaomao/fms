package cn.com.leadu.fms.webclient.activiti.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.activiti.vo.actuserleave.ActUserLeaveVo;
import cn.com.leadu.fms.webclient.activiti.rpc.ActUserLeaveRpc;
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
 * @author qiaomengnan
 * @ClassName: ActUserLeaveController
 * @Description: 用户请假controller
 * @date 2018-03-14
 */
@RestController
@RequestMapping("act_user_leave")
public class ActUserLeaveController {

    /**
     * @Fields  : 用户请假rpc
     */
    @Autowired
    private ActUserLeaveRpc actUserLeaveRpc;

    /**
     * @Title:
     * @Description: 分页查询用户请假信息
     * @param actUserLeaveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    @RequestMapping(value = "findActUserLeavesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findActUserLeavesByPage(ActUserLeaveVo actUserLeaveVo){
        Map actUserLeaveVoMap = actUserLeaveVo == null?null:(Map) JSON.toJSON(actUserLeaveVo);
        return actUserLeaveRpc.findActUserLeavesByPage(actUserLeaveVoMap);
    }

    /**
     * @Title:
     * @Description: 保存用户请假
     * @param actUserLeaveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    @RequestMapping(value = "saveActUserLeave",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveActUserLeave(@RequestBody ActUserLeaveVo actUserLeaveVo){
        return actUserLeaveRpc.saveActUserLeave(actUserLeaveVo);
    }

    /**
     * @Title:
     * @Description:  修改用户请假
     * @param actUserLeaveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    @RequestMapping(value = "modifyActUserLeave",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyActUserLeave(@RequestBody ActUserLeaveVo actUserLeaveVo){
        return actUserLeaveRpc.modifyActUserLeave(actUserLeaveVo);
    }

    /**
     * @Title:
     * @Description:   根据leaveId集合删除用户请假
     * @param leaveIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    @RequestMapping(value = "deleteActUserLeavesByLeaveIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteActUserLeavesByLeaveIds(@RequestBody List<String> leaveIds){
        ActUserLeaveVo actUserLeaveVo = new ActUserLeaveVo();
        actUserLeaveVo.setLeaveIds(leaveIds);
        return actUserLeaveRpc.deleteActUserLeavesByLeaveIds(actUserLeaveVo);
    }

    /**
     * @Title:
     * @Description:  根据leaveId获取用户请假
     * @param leaveId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:52
     */
    @RequestMapping(value = "findActUserLeaveByLeaveId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findActUserLeaveByLeaveId(String leaveId){
        return actUserLeaveRpc.findActUserLeaveByLeaveId(leaveId);
    }

    /**
     * @Title:
     * @Description:  根据leaveId获取用户请假
     * @param taskId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-3-14 14:35:51
     */
    @RequestMapping(value = "adopt", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> adopt(String taskId){
        return actUserLeaveRpc.adopt(taskId);
    }

}
