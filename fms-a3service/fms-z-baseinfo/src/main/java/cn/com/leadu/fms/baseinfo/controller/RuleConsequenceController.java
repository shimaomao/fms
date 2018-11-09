package cn.com.leadu.fms.baseinfo.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.baseinfo.vo.ruleconsequence.RuleConsequenceVo;
import cn.com.leadu.fms.baseinfo.service.RuleConsequenceService;
import cn.com.leadu.fms.baseinfo.validator.ruleconsequence.vo.*;
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
 * @ClassName: RuleConsequenceController
 * @Description: 规则引擎结果相关接口
 * @date 2018-05-17
 */
@RestController
@RequestMapping("rule_consequence")
public class RuleConsequenceController {

    /**
     * @Fields  : 规则引擎结果service
     */
    @Autowired
    private RuleConsequenceService ruleConsequenceService;

    /**
     * @Title:
     * @Description: 分页查询规则引擎结果信息
     * @param ruleConsequenceVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:09
     */
    @RequestMapping(value = "findRuleConsequencesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRuleConsequencesByPage(RuleConsequenceVo ruleConsequenceVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(ruleConsequenceService.findRuleConsequencesByPage(ruleConsequenceVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存规则引擎结果
     * @param ruleConsequenceSaveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:09
     */
    @RequestMapping(value = "saveRuleConsequence",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveRuleConsequence(@Valid @RequestBody RuleConsequenceSaveVo ruleConsequenceSaveVo){
        ruleConsequenceService.saveRuleConsequence(ruleConsequenceSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改规则引擎结果
     * @param ruleConsequenceModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:09
     */
    @RequestMapping(value = "modifyRuleConsequence",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyRuleConsequence(@Valid @RequestBody RuleConsequenceModifyVo ruleConsequenceModifyVo){
        ruleConsequenceService.modifyRuleConsequence(ruleConsequenceModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除规则引擎结果
     * @param ruleConsequenceDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:09
     */
    @RequestMapping(value = "deleteRuleConsequence",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteRuleConsequence(@Valid @RequestBody RuleConsequenceDeleteVo ruleConsequenceDeleteVo){
        ruleConsequenceService.deleteRuleConsequence(ruleConsequenceDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据ruleConseqId集合删除规则引擎结果
     * @param ruleConsequenceDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:09
     */
    @RequestMapping(value = "deleteRuleConsequencesByRuleConseqIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteRuleConsequencesByRuleConseqIds(@Valid @RequestBody RuleConsequenceDeleteListVo ruleConsequenceDeleteListVo){
        ruleConsequenceService.deleteRuleConsequencesByRuleConseqIds(ruleConsequenceDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据ruleConseqId获取规则引擎结果
     * @param ruleConseqId
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:36:09
     */
    @RequestMapping(value = "findRuleConsequenceByRuleConseqId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRuleConsequenceByRuleConseqId(String ruleConseqId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ruleConsequenceService.findRuleConsequenceByRuleConseqId(ruleConseqId)), HttpStatus.OK);
    }

}
