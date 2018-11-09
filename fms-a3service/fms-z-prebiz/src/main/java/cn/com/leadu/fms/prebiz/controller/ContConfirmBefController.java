package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.vo.contconfirmbef.ContConfirmBefVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.prebiz.service.ContConfirmBefService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author liujinge
 * @ClassName: ContConfirmBefController
 * @Description: 合同生成前确认相关接口
 * @date 2018-03-23
 */
@RestController
@RequestMapping("cont_confirm_bef")
public class ContConfirmBefController {

    /**
     * @Fields  : 合同生成前确认service
     */
    @Autowired
    private ContConfirmBefService contConfirmBefService;

    /**
     * @Title:
     * @Description: 合同生成前确认
     * @param contConfirmBefVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "confirm",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> confirm(@Valid @RequestBody ContConfirmBefVo contConfirmBefVo, @AuthUserInfo SysUser sysUser){
        contConfirmBefVo.setUser(sysUser.getUser());
        contConfirmBefService.confirm(contConfirmBefVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
    * @Description: 退回到申请
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/9/15 14:52
    */
    @RequestMapping(value = "returnDealer",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> returnDealer(@Valid @RequestBody ContConfirmBefVo contConfirmBefVo, @AuthUserInfo SysUser sysUser){
        contConfirmBefVo.setUser(sysUser.getUser());
        contConfirmBefService.returnDealer(contConfirmBefVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

}
