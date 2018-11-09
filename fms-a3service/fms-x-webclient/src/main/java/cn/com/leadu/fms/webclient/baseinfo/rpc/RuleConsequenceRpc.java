package cn.com.leadu.fms.webclient.baseinfo.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.ruleconsequence.RuleConsequenceVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: RuleConsequenceController
 * @Description: 规则引擎结果rpc
 * @date 2018-05-17
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface RuleConsequenceRpc {

    /**
     * @Title:
     * @Description: 分页查询规则引擎结果信息
     * @param ruleConsequenceVoMap
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:10
     */
    @RequestMapping(value = "api/baseinfo/rule_consequence/findRuleConsequencesByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findRuleConsequencesByPage(@RequestParam Map<String, Object> ruleConsequenceVoMap);

    /**
     * @Title:
     * @Description: 保存规则引擎结果
     * @param ruleConsequenceVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:10
     */
    @RequestMapping(value = "api/baseinfo/rule_consequence/saveRuleConsequence",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveRuleConsequence(@RequestBody RuleConsequenceVo ruleConsequenceVo);

    /**
     * @Title:
     * @Description:  修改规则引擎结果
     * @param ruleConsequenceVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:10
     */
    @RequestMapping(value = "api/baseinfo/rule_consequence/modifyRuleConsequence",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyRuleConsequence(@RequestBody RuleConsequenceVo ruleConsequenceVo);

    /**
     * @Title:
     * @Description:   根据ruleConseqId集合删除规则引擎结果
     * @param ruleConsequenceVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:10
     */
    @RequestMapping(value = "api/system/rule_consequence/deleteRuleConsequencesByRuleConseqIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteRuleConsequencesByRuleConseqIds(@RequestBody RuleConsequenceVo ruleConsequenceVo);

    /**
     * @Title:
     * @Description:  根据ruleConseqId获取规则引擎结果
     * @param ruleConseqId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:10
     */
    @RequestMapping(value = "api/baseinfo/rule_consequence/findRuleConsequenceByRuleConseqId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findRuleConsequenceByRuleConseqId(@RequestParam("ruleConseqId") String ruleConseqId);

}
