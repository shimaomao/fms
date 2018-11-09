package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.prebiz.service.ContractAutoCancelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yanfengbo
 * @ClassName: ApplyAutoCancelController
 * @Description: 未生效合同自动取消
 * @date
 */
@RestController
@RequestMapping("contract_auto_cancel")
public class ContractAutoCancelController {
    @Autowired
    private ContractAutoCancelService contractAutoCancelService;

    @RequestMapping(value = "contractAutoCancel",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> contractAutoCancel(@AuthUserInfo SysUser sysUser){
        contractAutoCancelService.contractAutoCancel(sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
}
