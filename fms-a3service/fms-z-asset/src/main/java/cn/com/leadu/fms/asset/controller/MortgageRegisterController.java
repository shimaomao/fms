package cn.com.leadu.fms.asset.controller;

import cn.com.leadu.fms.asset.rpc.prebiz.BizFilesRpc;
import cn.com.leadu.fms.asset.service.MortgageRegisterService;
import cn.com.leadu.fms.asset.validator.mortgageregister.vo.MortgageRegisterDeleteListVo;
import cn.com.leadu.fms.asset.validator.mortgageregister.vo.MortgageRegisterDeleteVo;
import cn.com.leadu.fms.asset.validator.mortgageregister.vo.MortgageRegisterModifyVo;
import cn.com.leadu.fms.asset.validator.mortgageregister.vo.MortgageRegisterSaveVo;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.asset.vo.mortgageregister.MortgagePostVo;
import cn.com.leadu.fms.pojo.asset.vo.mortgageregister.MortgageRegisterVo;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author yangyiquan
 * @ClassName: MortgageRegisterController
 * @Description: 解抵押过户信息相关接口
 * @date 2018-05-18
 */
@Slf4j
@RestController
@RequestMapping("mortgage_register")
public class MortgageRegisterController {

    /**
     * @Fields  : 解抵押过户信息service
     */
    @Autowired
    private MortgageRegisterService mortgageRegisterService;

    /**
     * @Fields  : 附件信息rpc
     */
    @Autowired
    private BizFilesRpc bizFilesRpc;

    /**
     * @Title:
     * @Description: 分页查询解抵押过户信息信息
     * @param mortgageRegisterVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @RequestMapping(value = "findMortgageRegistersByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findMortgageRegistersByPage(MortgageRegisterVo mortgageRegisterVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(mortgageRegisterService.findMortgageRegistersByPage(mortgageRegisterVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存解抵押过户信息
     * @param mortgageRegisterSaveVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @RequestMapping(value = "saveMortgageRegister",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveMortgageRegister(@Valid @RequestBody MortgageRegisterSaveVo mortgageRegisterSaveVo, @AuthUserInfo SysUser sysUser){
        mortgageRegisterSaveVo.setRegisterUser(sysUser.getUser());
        mortgageRegisterService.saveMortgageRegister(mortgageRegisterSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /** 
    * @Description: 保存解抵押资料邮寄信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/22 16:56
    */ 
    @RequestMapping(value = "saveMortgagePost",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveMortgagePost(@Valid @RequestBody MortgagePostVo mortgagePostVo, @AuthUserInfo SysUser sysUser){
        mortgageRegisterService.saveMortgagePost(mortgagePostVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改解抵押过户信息
     * @param mortgageRegisterModifyVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @RequestMapping(value = "modifyMortgageRegister",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyMortgageRegister(@Valid @RequestBody MortgageRegisterModifyVo mortgageRegisterModifyVo){
        mortgageRegisterService.modifyMortgageRegister(mortgageRegisterModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除解抵押过户信息
     * @param mortgageRegisterDeleteVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @RequestMapping(value = "deleteMortgageRegister",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteMortgageRegister(@Valid @RequestBody MortgageRegisterDeleteVo mortgageRegisterDeleteVo){
        mortgageRegisterService.deleteMortgageRegister(mortgageRegisterDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据mortgageRegisterId集合删除解抵押过户信息
     * @param mortgageRegisterDeleteListVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @RequestMapping(value = "deleteMortgageRegistersByMortgageRegisterIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteMortgageRegistersByMortgageRegisterIds(@Valid @RequestBody MortgageRegisterDeleteListVo mortgageRegisterDeleteListVo){
        mortgageRegisterService.deleteMortgageRegistersByMortgageRegisterIds(mortgageRegisterDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据mortgageRegisterId获取解抵押过户信息
     * @param mortgageRegisterId
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-18 19:12:45
     */
    @RequestMapping(value = "findMortgageRegisterByMortgageRegisterId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findMortgageRegisterByMortgageRegisterId(String mortgageRegisterId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(mortgageRegisterService.findMortgageRegisterByMortgageRegisterId(mortgageRegisterId)), HttpStatus.OK);
    }

    /** 
    * @Description: 获取解抵押附件
    * @param:
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/23 10:55
    */ 
    @RequestMapping(value = "findBizFilesMortgageRegister", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBizFilesMortgageRegister(String bizCode){
        CommonBizFilesVo bizFilesVo = null;
        try {
            bizFilesVo= ResponseEntityUtils.getRestResponseData(bizFilesRpc.findBizFilesMortgageRegister(bizCode));
        }catch (FmsRpcException ex){
            log.error(ex.getMessage());
            ex.printStackTrace();
        }
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(bizFilesVo), HttpStatus.OK);
    }

}
