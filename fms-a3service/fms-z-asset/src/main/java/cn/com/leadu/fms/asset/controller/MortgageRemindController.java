package cn.com.leadu.fms.asset.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.asset.vo.mortgageremind.MortgageRemindVo;
import cn.com.leadu.fms.asset.service.MortgageRemindService;
import cn.com.leadu.fms.asset.validator.mortgageremind.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @author ningyangyang
 * @ClassName: MortgageRemindController
 * @Description: 抵押提醒相关接口
 * @date 2018-07-27
 */
@RestController
@RequestMapping("mortgage_remind")
public class MortgageRemindController {

    /**
     * @Fields  : 抵押提醒service
     */
    @Autowired
    private MortgageRemindService mortgageRemindService;

    /**
     * @Title:
     * @Description: 分页查询抵押提醒信息
     * @param mortgageRemindVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:57
     */
    @RequestMapping(value = "findMortgageRemindsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findMortgageRemindsByPage(MortgageRemindVo mortgageRemindVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(mortgageRemindService.findMortgageRemindsByPage(mortgageRemindVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存抵押提醒
     * @param mortgageRemindSaveVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:57
     */
    @RequestMapping(value = "saveMortgageRemind",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveMortgageRemind(@Valid @RequestBody MortgageRemindSaveVo mortgageRemindSaveVo){
        mortgageRemindService.saveMortgageRemind(mortgageRemindSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改抵押提醒
     * @param mortgageRemindModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:57
     */
    @RequestMapping(value = "modifyMortgageRemind",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyMortgageRemind(@Valid @RequestBody MortgageRemindModifyVo mortgageRemindModifyVo){
        mortgageRemindService.modifyMortgageRemind(mortgageRemindModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除抵押提醒
     * @param mortgageRemindDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:57
     */
    @RequestMapping(value = "deleteMortgageRemind",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteMortgageRemind(@Valid @RequestBody MortgageRemindDeleteVo mortgageRemindDeleteVo){
        mortgageRemindService.deleteMortgageRemind(mortgageRemindDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据morRemindId集合删除抵押提醒
     * @param mortgageRemindDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:57
     */
    @RequestMapping(value = "deleteMortgageRemindsByMorRemindIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteMortgageRemindsByMorRemindIds(@Valid @RequestBody MortgageRemindDeleteListVo mortgageRemindDeleteListVo){
        mortgageRemindService.deleteMortgageRemindsByMorRemindIds(mortgageRemindDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据morRemindId获取抵押提醒
     * @param morRemindId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-7-27 11:05:57
     */
    @RequestMapping(value = "findMortgageRemindByMorRemindId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findMortgageRemindByMorRemindId(String morRemindId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(mortgageRemindService.findMortgageRemindByMorRemindId(morRemindId)), HttpStatus.OK);
    }


    /**
     * @Title:
     * @Description: 根据ID获取数据信息
     * @return int
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @RequestMapping(value = "selectMortgageRemindVosBymorRemindId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> selectMortgageRemindVosBymorRemindId(String morRemindId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(mortgageRemindService.selectMortgageRemindVosBymorRemindId(morRemindId)), HttpStatus.OK);
    }
}
