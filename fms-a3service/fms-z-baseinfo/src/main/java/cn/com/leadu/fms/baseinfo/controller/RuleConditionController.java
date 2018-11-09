package cn.com.leadu.fms.baseinfo.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.baseinfo.vo.rulecondition.RuleConditionVo;
import cn.com.leadu.fms.baseinfo.service.RuleConditionService;
import cn.com.leadu.fms.baseinfo.validator.rulecondition.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @author qiaomengnan
 * @ClassName: RuleConditionController
 * @Description: 规则引擎条件相关接口
 * @date 2018-05-17
 */
@RestController
@RequestMapping("rule_condition")
public class RuleConditionController {

    /**
     * @Fields  : 规则引擎条件service
     */
    @Autowired
    private RuleConditionService ruleConditionService;

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
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(ruleConditionService.findRuleConditionsByPage(ruleConditionVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存规则引擎条件
     * @param ruleConditionSaveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    @RequestMapping(value = "saveRuleCondition",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveRuleCondition(@Valid @RequestBody RuleConditionSaveVo ruleConditionSaveVo){
        ruleConditionService.saveRuleCondition(ruleConditionSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改规则引擎条件
     * @param ruleConditionModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    @RequestMapping(value = "modifyRuleCondition",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyRuleCondition(@Valid @RequestBody RuleConditionModifyVo ruleConditionModifyVo){
        ruleConditionService.modifyRuleCondition(ruleConditionModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除规则引擎条件
     * @param ruleConditionDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    @RequestMapping(value = "deleteRuleCondition",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteRuleCondition(@Valid @RequestBody RuleConditionDeleteVo ruleConditionDeleteVo){
        ruleConditionService.deleteRuleCondition(ruleConditionDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据ruleCondId集合删除规则引擎条件
     * @param ruleConditionDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:20:14
     */
    @RequestMapping(value = "deleteRuleConditionsByRuleCondIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteRuleConditionsByRuleCondIds(@Valid @RequestBody RuleConditionDeleteListVo ruleConditionDeleteListVo){
        ruleConditionService.deleteRuleConditionsByRuleCondIds(ruleConditionDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
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
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ruleConditionService.findRuleConditionByRuleCondId(ruleCondId)), HttpStatus.OK);
    }

}
