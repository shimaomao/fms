package cn.com.leadu.fms.webclient.baseinfo.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.vo.ruleitem.RuleItemVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: RuleItemController
 * @Description: 规则引擎项目管理rpc
 * @date 2018-05-17
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface RuleItemRpc {

    /**
     * @Title:
     * @Description: 分页查询规则引擎项目管理信息
     * @param ruleItemVoMap
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    @RequestMapping(value = "api/baseinfo/rule_item/findRuleItemsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findRuleItemsByPage(@RequestParam Map<String, Object> ruleItemVoMap);

    /**
     * @Title:
     * @Description: 保存规则引擎项目管理
     * @param ruleItemVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    @RequestMapping(value = "api/baseinfo/rule_item/saveRuleItem",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveRuleItem(@RequestBody RuleItemVo ruleItemVo);

    /**
     * @Title:
     * @Description:  修改规则引擎项目管理
     * @param ruleItemVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    @RequestMapping(value = "api/baseinfo/rule_item/modifyRuleItem",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyRuleItem(@RequestBody RuleItemVo ruleItemVo);

    /**
     * @Title:
     * @Description:   根据ruleItemId集合删除规则引擎项目管理
     * @param ruleItemVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    @RequestMapping(value = "api/baseinfo/rule_item/deleteRuleItemsByRuleItemIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteRuleItemsByRuleItemIds(@RequestBody RuleItemVo ruleItemVo);

    /**
     * @Title:
     * @Description:  根据ruleItemId获取规则引擎项目管理
     * @param ruleItemId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    @RequestMapping(value = "api/baseinfo/rule_item/findRuleItemByRuleItemId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findRuleItemByRuleItemId(@RequestParam("ruleItemId") String ruleItemId);

    /**
     * @Title:
     * @Description:   查询出所有项目，通过时间倒序
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/17 05:49:49
     */
    @RequestMapping(value = "api/baseinfo/rule_item/findRuleItemsByAll", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findRuleItemsByAll();

    /**
     * @Title:
     * @Description:   根据规则类型和项目属性查询规则项目
     * @param ruleType
     * @param itemType
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/17 06:36:59
     */
    @RequestMapping(value = "api/baseinfo/rule_item/findRuleItemsByRuleTypeAndItemType", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findRuleItemsByRuleTypeAndItemType(@RequestParam("ruleType") String ruleType , @RequestParam("itemType") String itemType);

}
