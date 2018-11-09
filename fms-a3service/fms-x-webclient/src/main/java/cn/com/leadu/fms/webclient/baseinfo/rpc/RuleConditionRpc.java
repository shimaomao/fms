package cn.com.leadu.fms.webclient.baseinfo.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.rulecondition.RuleConditionVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: RuleConditionController
 * @Description: 规则引擎条件rpc
 * @date 2018-05-17
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface RuleConditionRpc {

    /**
     * @Title:
     * @Description: 分页查询规则引擎条件信息
     * @param ruleConditionVoMap
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    @RequestMapping(value = "api/baseinfo/rule_condition/findRuleConditionsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findRuleConditionsByPage(@RequestParam Map<String, Object> ruleConditionVoMap);

    /**
     * @Title:
     * @Description: 保存规则引擎条件
     * @param ruleConditionVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    @RequestMapping(value = "api/baseinfo/rule_condition/saveRuleCondition",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveRuleCondition(@RequestBody RuleConditionVo ruleConditionVo);

    /**
     * @Title:
     * @Description:  修改规则引擎条件
     * @param ruleConditionVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    @RequestMapping(value = "api/baseinfo/rule_condition/modifyRuleCondition",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyRuleCondition(@RequestBody RuleConditionVo ruleConditionVo);

    /**
     * @Title:
     * @Description:   根据ruleCondId集合删除规则引擎条件
     * @param ruleConditionVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    @RequestMapping(value = "api/system/rule_condition/deleteRuleConditionsByRuleCondIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteRuleConditionsByRuleCondIds(@RequestBody RuleConditionVo ruleConditionVo);

    /**
     * @Title:
     * @Description:  根据ruleCondId获取规则引擎条件
     * @param ruleCondId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    @RequestMapping(value = "api/baseinfo/rule_condition/findRuleConditionByRuleCondId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findRuleConditionByRuleCondId(@RequestParam("ruleCondId") String ruleCondId);

}
