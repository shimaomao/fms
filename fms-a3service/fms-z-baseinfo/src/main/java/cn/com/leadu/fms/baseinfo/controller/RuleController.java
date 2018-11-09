package cn.com.leadu.fms.baseinfo.controller;

import cn.com.leadu.fms.business.service.CommonRuleService;
import cn.com.leadu.fms.common.constant.enums.baseinfo.RuleTypeEnums;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.baseinfo.vo.rule.RuleContractTemplateVo;
import cn.com.leadu.fms.pojo.baseinfo.vo.rule.RuleVo;
import cn.com.leadu.fms.baseinfo.service.RuleService;
import cn.com.leadu.fms.baseinfo.validator.rule.vo.*;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueAssignment;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCstm;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;
import java.math.BigDecimal;

/**
 * @author qiaomengnan
 * @ClassName: RuleController
 * @Description: 规则引擎相关接口
 * @date 2018-05-17
 */
@RestController
@RequestMapping("rule")
public class RuleController {

    /**
     * @Fields  : 规则引擎service
     */
    @Autowired
    private RuleService ruleService;

    /**
     * @Title:
     * @Description: 分页查询规则引擎信息
     * @param ruleVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:26
     */
    @RequestMapping(value = "findRulesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRulesByPage(RuleVo ruleVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(ruleService.findRulesByPage(ruleVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存规则引擎
     * @param ruleSaveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:26
     */
    @RequestMapping(value = "saveRule",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveRule(@Valid @RequestBody RuleSaveVo ruleSaveVo){
        ruleService.saveRule(ruleSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改规则引擎
     * @param ruleModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:26
     */
    @RequestMapping(value = "modifyRule",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyRule(@Valid @RequestBody RuleModifyVo ruleModifyVo){
        ruleService.modifyRule(ruleModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除规则引擎
     * @param ruleDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:26
     */
    @RequestMapping(value = "deleteRule",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteRule(@Valid @RequestBody RuleDeleteVo ruleDeleteVo){
        ruleService.deleteRule(ruleDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据ruleId集合删除规则引擎
     * @param ruleDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:26
     */
    @RequestMapping(value = "deleteRulesByRuleIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteRulesByRuleIds(@Valid @RequestBody RuleDeleteListVo ruleDeleteListVo){
        ruleService.deleteRulesByRuleIds(ruleDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据ruleId获取规则引擎
     * @param ruleId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 9:57:26
     */
    @RequestMapping(value = "findRuleByRuleId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRuleByRuleId(String ruleId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ruleService.findRuleByRuleId(ruleId)), HttpStatus.OK);
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
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ruleService.findRuleVoByRuleId(ruleId)), HttpStatus.OK);
    }

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
    @RequestMapping(value = "findRuleVo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRuleVo(String ruleType,String ruleKey){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                ruleService.findRuleVo(ruleType,ruleKey)
        ), HttpStatus.OK);
    }

//    @RequestMapping(value = "test", method = RequestMethod.GET)
//    public ResponseEntity<RestResponse> test(){
//        ruleService.initRule();
//        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(), HttpStatus.OK);
//    }

    @Autowired
    private CommonRuleService commonRuleService;

    @RequestMapping(value = "test", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> test(){
        RuleContractTemplateVo ruleContractTemplateVo = new RuleContractTemplateVo();
        ruleContractTemplateVo.setVehicleType2("0222");
        ruleContractTemplateVo.setWithinGroup("chfsCommm");
        ruleContractTemplateVo.setLicenseAttr("1");
        commonRuleService.get(ruleContractTemplateVo, RuleTypeEnums.CONTRACT.getType(),RuleTypeEnums.CONTRACT.getKey());
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ruleContractTemplateVo), HttpStatus.OK);
    }
    
}
