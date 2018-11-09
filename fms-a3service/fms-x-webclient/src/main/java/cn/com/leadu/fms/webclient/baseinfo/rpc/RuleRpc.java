package cn.com.leadu.fms.webclient.baseinfo.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.rule.RuleVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: RuleController
 * @Description: 规则引擎rpc
 * @date 2018-05-17
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface RuleRpc {

    /**
     * @Title:
     * @Description: 分页查询规则引擎信息
     * @param ruleVoMap
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:17:30
     */
    @RequestMapping(value = "api/baseinfo/rule/findRulesByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findRulesByPage(@RequestParam Map<String, Object> ruleVoMap);

    /**
     * @Title:
     * @Description: 保存规则引擎
     * @param ruleVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:17:30
     */
    @RequestMapping(value = "api/baseinfo/rule/saveRule",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveRule(@RequestBody RuleVo ruleVo);

    /**
     * @Title:
     * @Description:  修改规则引擎
     * @param ruleVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:17:30
     */
    @RequestMapping(value = "api/baseinfo/rule/modifyRule",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyRule(@RequestBody RuleVo ruleVo);

    /**
     * @Title:
     * @Description:   根据ruleId集合删除规则引擎
     * @param ruleVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:17:30
     */
    @RequestMapping(value = "api/baseinfo/rule/deleteRulesByRuleIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteRulesByRuleIds(@RequestBody RuleVo ruleVo);

    /**
     * @Title:
     * @Description:  根据ruleId获取规则引擎
     * @param ruleId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:17:30
     */
    @RequestMapping(value = "api/baseinfo/rule/findRuleByRuleId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findRuleByRuleId(@RequestParam("ruleId") String ruleId);

    /**
     * @Title:
     * @Description:   根据ruleId获取规则引擎vo
     * @param ruleId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/21 10:14:12
     */
    @RequestMapping(value = "api/baseinfo/rule/findRuleVoByRuleId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findRuleVoByRuleId(@RequestParam("ruleId") String ruleId);

}
