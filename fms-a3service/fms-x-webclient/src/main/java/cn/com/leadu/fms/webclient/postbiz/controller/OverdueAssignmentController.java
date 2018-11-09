package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.overdueassignment.OverdueAssignmentVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.OverdueCstmSaveVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.OverdueAssignmentRpc;
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
 * @ClassName: OverdueAssignmentController
 * @Description: 当日逾期任务信息controller
 * @date 2018-05-16
 */
@RestController
@RequestMapping("overdue_assignment")
public class OverdueAssignmentController {

    /**
     * @Fields  : 当日逾期任务信息rpc
     */
    @Autowired
    private OverdueAssignmentRpc overdueAssignmentRpc;

    /**
     * @Title:
     * @Description: 分页查询当日逾期任务信息信息
     * @param overdueAssignmentVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @RequestMapping(value = "findOverdueAssignmentsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueAssignmentsByPage(OverdueAssignmentVo overdueAssignmentVo){
        Map overdueAssignmentVoMap = overdueAssignmentVo == null?null:(Map) JSON.toJSON(overdueAssignmentVo);
        return overdueAssignmentRpc.findOverdueAssignmentsByPage(overdueAssignmentVoMap);
    }

    /**
     * @Title:
     * @Description: 保存当日逾期任务信息
     * @param overdueAssignmentVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @RequestMapping(value = "saveOverdueAssignment",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveOverdueAssignment(@RequestBody OverdueAssignmentVo overdueAssignmentVo){
        return overdueAssignmentRpc.saveOverdueAssignment(overdueAssignmentVo);
    }

    /**
     * @Title:
     * @Description: 催收任务分配，更新当日逾期任务信息
     * @param overdueCstmSaveVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @RequestMapping(value = "saveAssignment",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveAssignment(@RequestBody OverdueCstmSaveVo overdueCstmSaveVo){
        return overdueAssignmentRpc.saveAssignment(overdueCstmSaveVo);
    }

    /**
     * @Title:
     * @Description:  修改当日逾期任务信息
     * @param overdueAssignmentVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @RequestMapping(value = "modifyOverdueAssignment",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyOverdueAssignment(@RequestBody OverdueAssignmentVo overdueAssignmentVo){
        return overdueAssignmentRpc.modifyOverdueAssignment(overdueAssignmentVo);
    }

    /**
     * @Title:
     * @Description:   根据overdueAssignmentId集合删除当日逾期任务信息
     * @param overdueAssignmentIds
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @RequestMapping(value = "deleteOverdueAssignmentsByOverdueAssignmentIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteOverdueAssignmentsByOverdueAssignmentIds(@RequestBody List<String> overdueAssignmentIds){
        OverdueAssignmentVo overdueAssignmentVo = new OverdueAssignmentVo();
        overdueAssignmentVo.setOverdueAssignmentIds(overdueAssignmentIds);
        return overdueAssignmentRpc.deleteOverdueAssignmentsByOverdueAssignmentIds(overdueAssignmentVo);
    }

    /**
     * @Title:
     * @Description:  根据overdueAssignmentId获取当日逾期任务信息
     * @param overdueAssignmentId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:12:03
     */
    @RequestMapping(value = "findOverdueAssignmentByOverdueAssignmentId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueAssignmentByOverdueAssignmentId(String overdueAssignmentId){
        return overdueAssignmentRpc.findOverdueAssignmentByOverdueAssignmentId(overdueAssignmentId);
    }

}
