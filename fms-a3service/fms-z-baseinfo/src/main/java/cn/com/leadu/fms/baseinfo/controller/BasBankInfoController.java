package cn.com.leadu.fms.baseinfo.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.baseinfo.vo.basbankinfo.BasBankInfoVo;
import cn.com.leadu.fms.baseinfo.service.BasBankInfoService;
import cn.com.leadu.fms.baseinfo.validator.basbankinfo.vo.*;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @author yanfengbo
 * @ClassName: BasBankInfoController
 * @Description: 银行账号维护相关接口
 * @date 2018-03-26
 */
@RestController
@RequestMapping("bas_bank_info")
public class BasBankInfoController {

    /**
     * @Fields  : 银行账号维护service
     */
    @Autowired
    private BasBankInfoService basBankInfoService;

    /**
     * @Title:
     * @Description: 分页查询银行账号维护信息
     * @param basBankInfoVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "findBasBankInfosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasBankInfosByPage(BasBankInfoVo basBankInfoVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(basBankInfoService.findBasBankInfosByPage(basBankInfoVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存银行账号维护
     * @param basBankInfoSaveVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "saveBasBankInfo",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveBasBankInfo(@Valid @RequestBody BasBankInfoSaveVo basBankInfoSaveVo,@AuthUserInfo SysUser sysUser){
        basBankInfoService.saveBasBankInfo(basBankInfoSaveVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改银行账号维护
     * @param basBankInfoModifyVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "modifyBasBankInfo",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyBasBankInfo(@Valid @RequestBody BasBankInfoModifyVo basBankInfoModifyVo,@AuthUserInfo SysUser sysUser){
        basBankInfoService.modifyBasBankInfo(basBankInfoModifyVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除银行账号维护
     * @param basBankInfoDeleteVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "deleteBasBankInfo",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBasBankInfo(@Valid @RequestBody BasBankInfoDeleteVo basBankInfoDeleteVo){
        basBankInfoService.deleteBasBankInfo(basBankInfoDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据bankId集合删除银行账号维护
     * @param basBankInfoDeleteListVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "deleteBasBankInfosByBankIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteBasBankInfosByBankIds(@Valid @RequestBody BasBankInfoDeleteListVo basBankInfoDeleteListVo){
        basBankInfoService.deleteBasBankInfosByBankIds(basBankInfoDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据bankId获取银行账号维护
     * @param bankId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "findBasBankInfoByBankId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasBankInfoByBankId(String bankId,String serviceId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(basBankInfoService.findBasBankInfoByBankId(bankId,serviceId)), HttpStatus.OK);
    }

    /**
     * @Title:  
     * @Description: 银行账号维护审核通过
     * @param 
     * @return 
     * @throws 
     * @author yanfengbo 
     * @date 
     */
    @RequestMapping(value = "approval",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> approval(@RequestBody BasBankInfoVo basBankInfoVo, @AuthUserInfo SysUser sysUser){
        //basBankInfoVo.setPresentUser(sysUser.getUser());
        basBankInfoService.approval(basBankInfoVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
    
    /**
     * @Title:  
     * @Description: 银行账号维护退回
     * @param 
     * @return 
     * @throws 
     * @author yanfengbo 
     * @date 
     */
    @RequestMapping(value = "sendBack",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> sendBack(@RequestBody BasBankInfoVo basBankInfoVo, @AuthUserInfo SysUser sysUser){
        //basBankInfoVo.setPresentUser(sysUser.getUser());
        basBankInfoService.sendBack(basBankInfoVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据机构获取银行账号维护
     * @param organizationId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "findBasBankInfoByOrg", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasBankInfoByOrg(String organizationType ,String organizationId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(basBankInfoService.findBasBankInfoByOrg(organizationType,organizationId)), HttpStatus.OK);
    }

    /**
    * @Description: 根据银行账号获取财务科目代码
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/1 11:57
    */
    @RequestMapping(value = "findFinassSubjectCd", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinassSubjectCd(String accountNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(basBankInfoService.findFinassSubjectCd(accountNo)), HttpStatus.OK);
    }

    /**
    * @Description: 根据银行账号获取银行信息
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/10/10 13:57
    */
    @RequestMapping(value = "findBasBankInfoByAccountNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBasBankInfoByAccountNo(String accountNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(basBankInfoService.findBasBankInfoByAccountNo(accountNo)), HttpStatus.OK);
    }

}
