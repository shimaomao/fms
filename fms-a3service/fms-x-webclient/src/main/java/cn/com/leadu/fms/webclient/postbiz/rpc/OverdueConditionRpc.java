package cn.com.leadu.fms.webclient.postbiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecondition.OverdueConditionVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author yanfengbo
 * @ClassName: OverdueConditionController
 * @Description: 逾期状态维护rpc
 * @date 2018-05-11
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface OverdueConditionRpc {

    /**
     * @Title:
     * @Description: 分页查询逾期状态维护信息
     * @param overdueConditionVoMap
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    @RequestMapping(value = "api/postbiz/overdue_condition/findOverdueConditionsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOverdueConditionsByPage(@RequestParam Map<String,Object> overdueConditionVoMap);

    /**
     * @Title:
     * @Description: 保存逾期状态维护
     * @param overdueConditionVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    @RequestMapping(value = "api/postbiz/overdue_condition/saveOverdueCondition",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveOverdueCondition(@RequestBody OverdueConditionVo overdueConditionVo);

    /**
     * @Title:
     * @Description:  修改逾期状态维护
     * @param overdueConditionVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    @RequestMapping(value = "api/postbiz/overdue_condition/modifyOverdueCondition",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyOverdueCondition(@RequestBody OverdueConditionVo overdueConditionVo);

    /**
     * @Title:
     * @Description:   根据overdueConditionId集合删除逾期状态维护
     * @param overdueConditionVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    @RequestMapping(value = "api/postbiz/overdue_condition/deleteOverdueConditionsByOverdueConditionIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteOverdueConditionsByOverdueConditionIds(@RequestBody OverdueConditionVo overdueConditionVo);

    /**
     * @Title:
     * @Description:  根据overdueConditionId获取逾期状态维护
     * @param overdueConditionId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-11 10:10:17
     */
    @RequestMapping(value = "api/postbiz/overdue_condition/findOverdueConditionByOverdueConditionId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOverdueConditionByOverdueConditionId(@RequestParam("overdueConditionId") String overdueConditionId);

}
