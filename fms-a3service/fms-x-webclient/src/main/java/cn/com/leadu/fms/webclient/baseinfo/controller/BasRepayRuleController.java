package cn.com.leadu.fms.webclient.baseinfo.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.basrepayrule.BasRepayRuleVo;
import cn.com.leadu.fms.webclient.baseinfo.rpc.BasRepayRuleRpc;
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
 * @author huchenghao
 * @ClassName: BasRepayRuleController
 * @Description: 还款日规则controller
 * @date 2018-03-16
 */
@RestController
@RequestMapping("bas_repay_rule")
public class BasRepayRuleController {

    /**
     * @Fields  : 还款日规则rpc
     */
    @Autowired
    private BasRepayRuleRpc basRepayRuleRpc;

    /**1
     * @Title:
     * @Description: 分页查询还款日规则信息
     * @param basRepayRuleVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    @RequestMapping(value = "findBasRepayRulesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasRepayRulesByPage(BasRepayRuleVo basRepayRuleVo){
        Map basRepayRuleVoMap = basRepayRuleVo == null?null:(Map) JSON.toJSON(basRepayRuleVo);
        return basRepayRuleRpc.findBasRepayRulesByPage(basRepayRuleVoMap);
    }

    /**
     * @Title:
     * @Description: 保存还款日规则
     * @param basRepayRuleVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    @RequestMapping(value = "saveBasRepayRule",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBasRepayRule(@RequestBody BasRepayRuleVo basRepayRuleVo){
        return basRepayRuleRpc.saveBasRepayRule(basRepayRuleVo);
    }

    /**
     * @Title:
     * @Description:  修改还款日规则
     * @param basRepayRuleVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    @RequestMapping(value = "modifyBasRepayRule",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyBasRepayRule(@RequestBody BasRepayRuleVo basRepayRuleVo){
        return basRepayRuleRpc.modifyBasRepayRule(basRepayRuleVo);
    }

    /**
     * @Title:
     * @Description:   根据ruleId集合删除还款日规则
     * @param ruleIds
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    @RequestMapping(value = "deleteBasRepayRulesByRuleIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBasRepayRulesByRuleIds(@RequestBody List<String> ruleIds){
        BasRepayRuleVo basRepayRuleVo = new BasRepayRuleVo();
        basRepayRuleVo.setRuleIds(ruleIds);
        return basRepayRuleRpc.deleteBasRepayRulesByRuleIds(basRepayRuleVo);
    }

    /**
     * @Title:
     * @Description:  根据ruleId获取还款日规则
     * @param ruleId
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    @RequestMapping(value = "findBasRepayRuleByRuleId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasRepayRuleByRuleId(String ruleId){
        return basRepayRuleRpc.findBasRepayRuleByRuleId(ruleId);
    }

}
