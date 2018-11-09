package cn.com.leadu.fms.webclient.baseinfo.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.baseinfo.vo.ruleitem.RuleItemVo;
import cn.com.leadu.fms.webclient.baseinfo.rpc.RuleItemRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: RuleItemController
 * @Description: 规则引擎项目管理controller
 * @date 2018-05-17
 */
@RestController
@RequestMapping("rule_item")
public class RuleItemController {

    /**
     * @Fields  : 规则引擎项目管理rpc
     */
    @Autowired
    private RuleItemRpc ruleItemRpc;

    /**
     * @Title:
     * @Description: 分页查询规则引擎项目管理信息
     * @param ruleItemVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    @RequestMapping(value = "findRuleItemsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRuleItemsByPage(RuleItemVo ruleItemVo){
        Map ruleItemVoMap = ruleItemVo == null?null:(Map) JSON.toJSON(ruleItemVo);
        return ruleItemRpc.findRuleItemsByPage(ruleItemVoMap);
    }

    /**
     * @Title:
     * @Description: 保存规则引擎项目管理
     * @param ruleItemVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    @RequestMapping(value = "saveRuleItem",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveRuleItem(@RequestBody RuleItemVo ruleItemVo){
        return ruleItemRpc.saveRuleItem(ruleItemVo);
    }

    /**
     * @Title:
     * @Description:  修改规则引擎项目管理
     * @param ruleItemVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    @RequestMapping(value = "modifyRuleItem",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyRuleItem(@RequestBody RuleItemVo ruleItemVo){
        return ruleItemRpc.modifyRuleItem(ruleItemVo);
    }

    /**
     * @Title:
     * @Description:   根据ruleItemId集合删除规则引擎项目管理
     * @param ruleItemIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    @RequestMapping(value = "deleteRuleItemsByRuleItemIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteRuleItemsByRuleItemIds(@RequestBody List<String> ruleItemIds){
        RuleItemVo ruleItemVo = new RuleItemVo();
        ruleItemVo.setRuleItemIds(ruleItemIds);
        return ruleItemRpc.deleteRuleItemsByRuleItemIds(ruleItemVo);
    }

    /**
     * @Title:
     * @Description:  根据ruleItemId获取规则引擎项目管理
     * @param ruleItemId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    @RequestMapping(value = "findRuleItemByRuleItemId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRuleItemByRuleItemId(String ruleItemId){
        return ruleItemRpc.findRuleItemByRuleItemId(ruleItemId);
    }

    /**
     * @Title:
     * @Description:   查询出所有项目，通过时间倒序
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/05/17 05:49:49
     */
    @RequestMapping(value = "findRuleItemsByAll", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRuleItemsByAll(){
        return ruleItemRpc.findRuleItemsByAll();
    }

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
    @RequestMapping(value = "findRuleItemsByRuleTypeAndItemType", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRuleItemsByRuleTypeAndItemType(String ruleType ,String itemType){
        return ruleItemRpc.findRuleItemsByRuleTypeAndItemType(ruleType, itemType);
    }

}
