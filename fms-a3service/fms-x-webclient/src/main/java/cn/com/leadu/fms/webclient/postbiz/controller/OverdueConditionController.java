package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecondition.OverdueConditionVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.OverdueConditionRpc;
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
 * @author yanfengbo
 * @ClassName: OverdueConditionController
 * @Description: 逾期状态维护controller
 * @date 2018-05-11
 */
@RestController
@RequestMapping("overdue_condition")
public class OverdueConditionController {

    /**
     * @Fields  : 逾期状态维护rpc
     */
    @Autowired
    private OverdueConditionRpc overdueConditionRpc;

    /**
     * @Title:
     * @Description: 分页查询逾期状态维护信息
     * @param overdueConditionVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    @RequestMapping(value = "findOverdueConditionsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueConditionsByPage(OverdueConditionVo overdueConditionVo){
        Map overdueConditionVoMap = overdueConditionVo == null?null:(Map) JSON.toJSON(overdueConditionVo);
        return overdueConditionRpc.findOverdueConditionsByPage(overdueConditionVoMap);
    }

    /**
     * @Title:
     * @Description: 保存逾期状态维护
     * @param overdueConditionVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    @RequestMapping(value = "saveOverdueCondition",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveOverdueCondition(@RequestBody OverdueConditionVo overdueConditionVo){
        return overdueConditionRpc.saveOverdueCondition(overdueConditionVo);
    }

    /**
     * @Title:
     * @Description:  修改逾期状态维护
     * @param overdueConditionVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    @RequestMapping(value = "modifyOverdueCondition",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyOverdueCondition(@RequestBody OverdueConditionVo overdueConditionVo){
        return overdueConditionRpc.modifyOverdueCondition(overdueConditionVo);
    }

    /**
     * @Title:
     * @Description:   根据overdueConditionId集合删除逾期状态维护
     * @param overdueConditionIds
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    @RequestMapping(value = "deleteOverdueConditionsByOverdueConditionIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteOverdueConditionsByOverdueConditionIds(@RequestBody List<String> overdueConditionIds){
        OverdueConditionVo overdueConditionVo = new OverdueConditionVo();
        overdueConditionVo.setOverdueConditionIds(overdueConditionIds);
        return overdueConditionRpc.deleteOverdueConditionsByOverdueConditionIds(overdueConditionVo);
    }

    /**
     * @Title:
     * @Description:  根据overdueConditionId获取逾期状态维护
     * @param overdueConditionId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    @RequestMapping(value = "findOverdueConditionByOverdueConditionId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueConditionByOverdueConditionId(String overdueConditionId){
        return overdueConditionRpc.findOverdueConditionByOverdueConditionId(overdueConditionId);
    }

}
