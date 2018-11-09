package cn.com.leadu.fms.webclient.baseinfo.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.rulecondition.RuleConditionVo;
import cn.com.leadu.fms.webclient.baseinfo.rpc.RuleConditionRpc;
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
 * @ClassName: RuleConditionController
 * @Description: 规则引擎条件controller
 * @date 2018-05-17
 */
@RestController
@RequestMapping("rule_condition")
public class RuleConditionController {

    /**
     * @Fields  : 规则引擎条件rpc
     */
    @Autowired
    private RuleConditionRpc ruleConditionRpc;

    /**
     * @Title:
     * @Description: 分页查询规则引擎条件信息
     * @param ruleConditionVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    @RequestMapping(value = "findRuleConditionsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRuleConditionsByPage(RuleConditionVo ruleConditionVo){
        Map ruleConditionVoMap = ruleConditionVo == null?null:(Map) JSON.toJSON(ruleConditionVo);
        return ruleConditionRpc.findRuleConditionsByPage(ruleConditionVoMap);
    }

    /**
     * @Title:
     * @Description: 保存规则引擎条件
     * @param ruleConditionVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    @RequestMapping(value = "saveRuleCondition",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveRuleCondition(@RequestBody RuleConditionVo ruleConditionVo){
        return ruleConditionRpc.saveRuleCondition(ruleConditionVo);
    }

    /**
     * @Title:
     * @Description:  修改规则引擎条件
     * @param ruleConditionVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    @RequestMapping(value = "modifyRuleCondition",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyRuleCondition(@RequestBody RuleConditionVo ruleConditionVo){
        return ruleConditionRpc.modifyRuleCondition(ruleConditionVo);
    }

    /**
     * @Title:
     * @Description:   根据ruleCondId集合删除规则引擎条件
     * @param ruleCondIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    @RequestMapping(value = "deleteRuleConditionsByRuleCondIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteRuleConditionsByRuleCondIds(@RequestBody List<String> ruleCondIds){
        RuleConditionVo ruleConditionVo = new RuleConditionVo();
        ruleConditionVo.setRuleCondIds(ruleCondIds);
        return ruleConditionRpc.deleteRuleConditionsByRuleCondIds(ruleConditionVo);
    }

    /**
     * @Title:
     * @Description:  根据ruleCondId获取规则引擎条件
     * @param ruleCondId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    @RequestMapping(value = "findRuleConditionByRuleCondId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRuleConditionByRuleCondId(String ruleCondId){
        return ruleConditionRpc.findRuleConditionByRuleCondId(ruleCondId);
    }

}
