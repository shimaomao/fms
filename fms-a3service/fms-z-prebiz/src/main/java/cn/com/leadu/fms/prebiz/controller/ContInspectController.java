package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.vo.continspect.ContInspectVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.prebiz.service.ContInspectService;
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
@RequestMapping("cont_inspect")
public class ContInspectController {

    /**
     * @Fields  : 合同生成前确认service
     */
    @Autowired
    private ContInspectService contInspectService;

    /**
     * @Title:
     * @Description: 合同生成前确认
     * @param contInspectVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "approval",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> approval(@Valid @RequestBody ContInspectVo contInspectVo, @AuthUserInfo SysUser sysUser){
        contInspectVo.setUser(sysUser.getUser());
        contInspectService.approval(contInspectVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
    /**
     * @Title:
     * @Description: 合同生成前确认
     * @param contInspectVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "sendBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> sendBack(@Valid @RequestBody ContInspectVo contInspectVo, @AuthUserInfo SysUser sysUser){
        contInspectVo.setUser(sysUser.getUser());
        contInspectService.sendBack(contInspectVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
    /**
     * @Title:
     * @Description: 合同生成前确认
     * @param contInspectVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "sendBackTop",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> sendBackTop(@Valid @RequestBody ContInspectVo contInspectVo, @AuthUserInfo SysUser sysUser){
        contInspectVo.setUser(sysUser.getUser());
        contInspectService.sendBackTop(contInspectVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
}
