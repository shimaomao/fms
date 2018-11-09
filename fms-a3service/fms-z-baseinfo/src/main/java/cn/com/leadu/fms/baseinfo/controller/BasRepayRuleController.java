package cn.com.leadu.fms.baseinfo.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.baseinfo.vo.basrepayrule.BasRepayRuleVo;
import cn.com.leadu.fms.baseinfo.service.BasRepayRuleService;
import cn.com.leadu.fms.baseinfo.validator.basrepayrule.vo.BasRepayRuleDeleteListVo;
import cn.com.leadu.fms.baseinfo.validator.basrepayrule.vo.BasRepayRuleDeleteVo;
import cn.com.leadu.fms.baseinfo.validator.basrepayrule.vo.BasRepayRuleModifyVo;
import cn.com.leadu.fms.baseinfo.validator.basrepayrule.vo.BasRepayRuleSaveVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import java.util.Date;

/**
 * @author huchenghao
 * @ClassName: BasRepayRuleController
 * @Description: 还款日规则相关接口
 * @date 2018-03-16
 */
@RestController
@RequestMapping("bas_repay_rule")
public class BasRepayRuleController {

    /**
     * @Fields  : 还款日规则service
     */
    @Autowired
    private BasRepayRuleService basRepayRuleService;

    /**
     * @Title:
     * @Description: 分页查询还款日规则信息
     * @param basRepayRuleVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:35
     */
    @RequestMapping(value = "findBasRepayRulesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasRepayRulesByPage(BasRepayRuleVo basRepayRuleVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(basRepayRuleService.findBasRepayRulesByPage(basRepayRuleVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存还款日规则
     * @param basRepayRuleSaveVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:35
     */
    @RequestMapping(value = "saveBasRepayRule",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBasRepayRule(@Valid @RequestBody BasRepayRuleSaveVo basRepayRuleSaveVo){
        basRepayRuleService.saveBasRepayRule(basRepayRuleSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改还款日规则
     * @param basRepayRuleModifyVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:35
     */
    @RequestMapping(value = "modifyBasRepayRule",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyBasRepayRule(@Valid @RequestBody BasRepayRuleModifyVo basRepayRuleModifyVo){
        basRepayRuleService.modifyBasRepayRule(basRepayRuleModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除还款日规则
     * @param basRepayRuleDeleteVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:35
     */
    @RequestMapping(value = "deleteBasRepayRule",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBasRepayRule(@Valid @RequestBody BasRepayRuleDeleteVo basRepayRuleDeleteVo){
        basRepayRuleService.deleteBasRepayRule(basRepayRuleDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据ruleId集合删除还款日规则
     * @param basRepayRuleDeleteListVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:35
     */
    @RequestMapping(value = "deleteBasRepayRulesByRuleIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBasRepayRulesByRuleIds(@Valid @RequestBody BasRepayRuleDeleteListVo basRepayRuleDeleteListVo){
        basRepayRuleService.deleteBasRepayRulesByRuleIds(basRepayRuleDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据ruleId获取还款日规则
     * @param ruleId
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:35
     */
    @RequestMapping(value = "findBasRepayRuleByRuleId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasRepayRuleByRuleId(String ruleId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(basRepayRuleService.findBasRepayRuleByRuleId(ruleId)), HttpStatus.OK);
    }


    /**
     * @Title:
     * @Description:  根据当前日期取得还款日
     * @param
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-16 13:46:35
     */
    @RequestMapping(value = "findRepayDay", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findRepayDay(Date repayDate){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(basRepayRuleService.findRepayDay(repayDate)), HttpStatus.OK);
    }
}
