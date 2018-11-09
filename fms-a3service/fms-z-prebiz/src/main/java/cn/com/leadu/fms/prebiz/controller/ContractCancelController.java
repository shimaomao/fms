package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.vo.applycancel.ApplyCancelVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractcancel.ContractCancelVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.prebiz.service.ApplyCancelService;
import cn.com.leadu.fms.prebiz.service.ContractCancelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by yanfengbo
 * 融资合同取消
 */
@RestController
@RequestMapping("contract_cancel")
public class ContractCancelController {
    /*
        融资合同取消Service
     */
    @Autowired
    private ContractCancelService contractCancelService;

    @RequestMapping(value = "findContractCancelsByPage", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContractCancelsByPage(ContractCancelVo contractCancelVo, @AuthUserInfo SysUser sysUser) {
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contractCancelService.findContractCancelsByPage(contractCancelVo,sysUser)),
                HttpStatus.OK);
    }

     /*public void controller(@AuthUserInfo SysUser sysUser){

     }*/


    /**
     * @Title:
     * @Description:  根据contNo获取融资合同取消
     * @param contNo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "findContractCancelVoByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContractCancelVoByContNo(String contNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contractCancelService.findContractCancelVoByContNo(contNo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  融资申请取消
     * @param contractCancelVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "modifyContractCancel",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyContractCancel(@Valid @RequestBody ContractCancelVo contractCancelVo,@AuthUserInfo SysUser sysUser){
        contractCancelService.modifyContractCancel(contractCancelVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
}
