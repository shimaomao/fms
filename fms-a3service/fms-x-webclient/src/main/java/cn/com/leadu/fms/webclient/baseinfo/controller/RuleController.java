package cn.com.leadu.fms.webclient.baseinfo.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.rule.RuleVo;
import cn.com.leadu.fms.webclient.baseinfo.rpc.RuleRpc;
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
 * @ClassName: RuleController
 * @Description: 规则引擎controller
 * @date 2018-05-17
 */
@RestController
@RequestMapping("rule")
public class RuleController {

    /**
     * @Fields  : 规则引擎rpc
     */
    @Autowired
    private RuleRpc ruleRpc;

    /**
     * @Title:
     * @Description: 分页查询规则引擎信息
     * @param ruleVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:17:30
     */
    @RequestMapping(value = "findRulesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRulesByPage(RuleVo ruleVo){
        Map ruleVoMap = ruleVo == null?null:(Map) JSON.toJSON(ruleVo);
        return ruleRpc.findRulesByPage(ruleVoMap);
    }

    /**
     * @Title:
     * @Description: 保存规则引擎
     * @param ruleVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:17:30
     */
    @RequestMapping(value = "saveRule",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveRule(@RequestBody RuleVo ruleVo){
        return ruleRpc.saveRule(ruleVo);
    }

    /**
     * @Title:
     * @Description:  修改规则引擎
     * @param ruleVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:17:30
     */
    @RequestMapping(value = "modifyRule",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyRule(@RequestBody RuleVo ruleVo){
        return ruleRpc.modifyRule(ruleVo);
    }

    /**
     * @Title:
     * @Description:   根据ruleId集合删除规则引擎
     * @param ruleIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:17:30
     */
    @RequestMapping(value = "deleteRulesByRuleIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteRulesByRuleIds(@RequestBody List<String> ruleIds){
        RuleVo ruleVo = new RuleVo();
        ruleVo.setRuleIds(ruleIds);
        return ruleRpc.deleteRulesByRuleIds(ruleVo);
    }

    /**
     * @Title:
     * @Description:  根据ruleId获取规则引擎
     * @param ruleId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:17:30
     */
    @RequestMapping(value = "findRuleByRuleId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRuleByRuleId(String ruleId){
        return ruleRpc.findRuleByRuleId(ruleId);
    }

    /**
     * @Title:
     * @Description:   根据ruleId获取规则引擎vo
     * @param ruleId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/21 10:14:12
     */
    @RequestMapping(value = "findRuleVoByRuleId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRuleVoByRuleId(String ruleId){
        return ruleRpc.findRuleVoByRuleId(ruleId);
    }

}
