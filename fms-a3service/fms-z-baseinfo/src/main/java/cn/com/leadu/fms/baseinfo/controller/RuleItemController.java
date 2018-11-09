package cn.com.leadu.fms.baseinfo.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.baseinfo.vo.ruleitem.RuleItemVo;
import cn.com.leadu.fms.baseinfo.service.RuleItemService;
import cn.com.leadu.fms.baseinfo.validator.ruleitem.vo.*;
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
 * @ClassName: RuleItemController
 * @Description: 规则引擎项目管理相关接口
 * @date 2018-05-17
 */
@RestController
@RequestMapping("rule_item")
public class RuleItemController {

    /**
     * @Fields  : 规则引擎项目管理service
     */
    @Autowired
    private RuleItemService ruleItemService;

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
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(ruleItemService.findRuleItemsByPage(ruleItemVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存规则引擎项目管理
     * @param ruleItemSaveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    @RequestMapping(value = "saveRuleItem",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveRuleItem(@Valid @RequestBody RuleItemSaveVo ruleItemSaveVo){
        ruleItemService.saveRuleItem(ruleItemSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改规则引擎项目管理
     * @param ruleItemModifyVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    @RequestMapping(value = "modifyRuleItem",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyRuleItem(@Valid @RequestBody RuleItemModifyVo ruleItemModifyVo){
        ruleItemService.modifyRuleItem(ruleItemModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除规则引擎项目管理
     * @param ruleItemDeleteVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    @RequestMapping(value = "deleteRuleItem",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteRuleItem(@Valid @RequestBody RuleItemDeleteVo ruleItemDeleteVo){
        ruleItemService.deleteRuleItem(ruleItemDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据ruleItemId集合删除规则引擎项目管理
     * @param ruleItemDeleteListVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-17 10:37:22
     */
    @RequestMapping(value = "deleteRuleItemsByRuleItemIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteRuleItemsByRuleItemIds(@Valid @RequestBody RuleItemDeleteListVo ruleItemDeleteListVo){
        ruleItemService.deleteRuleItemsByRuleItemIds(ruleItemDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
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
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ruleItemService.findRuleItemByRuleItemId(ruleItemId)), HttpStatus.OK);
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
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                ruleItemService.findRuleItemsByAll()
        ), HttpStatus.OK);
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
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                ruleItemService.findRuleItemsByRuleTypeAndItemType(ruleType, itemType)
        ), HttpStatus.OK);
    }

}
