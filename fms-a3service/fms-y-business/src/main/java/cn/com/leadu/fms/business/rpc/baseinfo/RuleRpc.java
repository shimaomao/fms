package cn.com.leadu.fms.business.rpc.baseinfo;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.rule.RuleVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author qiaomengnan
 * @ClassName: RuleRpc
 * @Description: 规则引擎rpc
 * @date 2018/5/24
 */
@FeignClient("${fms.feigns.serverNames.fmsBaseInfo}")
public interface RuleRpc {

    /**
     * @Title:
     * @Description: 根据ruleType ruleKey查询一条完整的规则数据
     * @param ruleType
     * @param ruleKey
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/24 11:12:31
     */
    @RequestMapping(value = "rule/findRuleVo", method = RequestMethod.GET)
    ResponseEntity<RestResponse<RuleVo>> findRuleVo(@RequestParam("ruleType") String ruleType,@RequestParam("ruleKey") String ruleKey);

}
