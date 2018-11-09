package cn.com.leadu.fms.webclient.baseinfo.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.basrepayrule.BasRepayRuleVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author huchenghao
 * @ClassName: BasRepayRuleController
 * @Description: 还款日规则rpc
 * @date 2018-03-16
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface BasRepayRuleRpc {

    /**
     * @Title:
     * @Description: 分页查询还款日规则信息
     * @param basRepayRuleVoMap
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    @RequestMapping(value = "api/baseinfo/bas_repay_rule/findBasRepayRulesByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasRepayRulesByPage(@RequestParam Map<String, Object> basRepayRuleVoMap);

    /**
     * @Title:
     * @Description: 保存还款日规则
     * @param basRepayRuleVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    @RequestMapping(value = "api/baseinfo/bas_repay_rule/saveBasRepayRule",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveBasRepayRule(@RequestBody BasRepayRuleVo basRepayRuleVo);

    /**
     * @Title:
     * @Description:  修改还款日规则
     * @param basRepayRuleVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    @RequestMapping(value = "api/baseinfo/bas_repay_rule/modifyBasRepayRule",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyBasRepayRule(@RequestBody BasRepayRuleVo basRepayRuleVo);

    /**
     * @Title:
     * @Description:   根据ruleId集合删除还款日规则
     * @param basRepayRuleVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    @RequestMapping(value = "api/baseinfo/bas_repay_rule/deleteBasRepayRulesByRuleIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteBasRepayRulesByRuleIds(@RequestBody BasRepayRuleVo basRepayRuleVo);

    /**
     * @Title:
     * @Description:  根据ruleId获取还款日规则
     * @param ruleId
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:36
     */
    @RequestMapping(value = "api/baseinfo/bas_repay_rule/findBasRepayRuleByRuleId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBasRepayRuleByRuleId(@RequestParam("ruleId") String ruleId);

}
