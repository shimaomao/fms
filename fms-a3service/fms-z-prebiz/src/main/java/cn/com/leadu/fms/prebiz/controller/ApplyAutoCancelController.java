package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.prebiz.service.ApplyAutoCancelService;
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
 * @ClassName: ApplyAutoCancelService
 * @Description: 申请订单自动取消
 * @date
 */
@RestController
@RequestMapping("apply_auto_cancel")
public class ApplyAutoCancelController {
    @Autowired
    private ApplyAutoCancelService applyAutoCancelService;
    
    @RequestMapping(value = "applyAutoCancel",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> applyAutoCancel(@AuthUserInfo SysUser sysUser){
        applyAutoCancelService.applyAutoCancel(sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
}
