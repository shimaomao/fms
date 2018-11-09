package cn.com.leadu.fms.webclient.baseinfo.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.ruleconsequence.RuleConsequenceVo;
import cn.com.leadu.fms.webclient.baseinfo.rpc.RuleConsequenceRpc;
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
 * @ClassName: RuleConsequenceController
 * @Description: 规则引擎结果controller
 * @date 2018-05-17
 */
@RestController
@RequestMapping("rule_consequence")
public class RuleConsequenceController {

    /**
     * @Fields  : 规则引擎结果rpc
     */
    @Autowired
    private RuleConsequenceRpc ruleConsequenceRpc;

    /**
     * @Title:
     * @Description: 分页查询规则引擎结果信息
     * @param ruleConsequenceVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:10
     */
    @RequestMapping(value = "findRuleConsequencesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRuleConsequencesByPage(RuleConsequenceVo ruleConsequenceVo){
        Map ruleConsequenceVoMap = ruleConsequenceVo == null?null:(Map) JSON.toJSON(ruleConsequenceVo);
        return ruleConsequenceRpc.findRuleConsequencesByPage(ruleConsequenceVoMap);
    }

    /**
     * @Title:
     * @Description: 保存规则引擎结果
     * @param ruleConsequenceVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:10
     */
    @RequestMapping(value = "saveRuleConsequence",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveRuleConsequence(@RequestBody RuleConsequenceVo ruleConsequenceVo){
        return ruleConsequenceRpc.saveRuleConsequence(ruleConsequenceVo);
    }

    /**
     * @Title:
     * @Description:  修改规则引擎结果
     * @param ruleConsequenceVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:10
     */
    @RequestMapping(value = "modifyRuleConsequence",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyRuleConsequence(@RequestBody RuleConsequenceVo ruleConsequenceVo){
        return ruleConsequenceRpc.modifyRuleConsequence(ruleConsequenceVo);
    }

    /**
     * @Title:
     * @Description:   根据ruleConseqId集合删除规则引擎结果
     * @param ruleConseqIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:10
     */
    @RequestMapping(value = "deleteRuleConsequencesByRuleConseqIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteRuleConsequencesByRuleConseqIds(@RequestBody List<String> ruleConseqIds){
        RuleConsequenceVo ruleConsequenceVo = new RuleConsequenceVo();
        ruleConsequenceVo.setRuleConseqIds(ruleConseqIds);
        return ruleConsequenceRpc.deleteRuleConsequencesByRuleConseqIds(ruleConsequenceVo);
    }

    /**
     * @Title:
     * @Description:  根据ruleConseqId获取规则引擎结果
     * @param ruleConseqId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:10
     */
    @RequestMapping(value = "findRuleConsequenceByRuleConseqId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRuleConsequenceByRuleConseqId(String ruleConseqId){
        return ruleConsequenceRpc.findRuleConsequenceByRuleConseqId(ruleConseqId);
    }

}
