package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.vo.contprint.ContPrintVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.prebiz.service.ContPrintService;
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
@RequestMapping("cont_print")
public class ContPrintController {

    /**
     * @Fields  : 合同打印service
     */
    @Autowired
    private ContPrintService contPrintService;

    /**
     * @Title:
     * @Description: 合同打印
     * @param contPrintVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "print",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> print(@Valid @RequestBody ContPrintVo contPrintVo, @AuthUserInfo SysUser sysUser){
        contPrintVo.setUser(sysUser.getUser());
        contPrintService.print(contPrintVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 合同打印退回
     * @param contPrintVo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "sendBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> sendBack(@Valid @RequestBody ContPrintVo contPrintVo, @AuthUserInfo SysUser sysUser){
        contPrintVo.setUser(sysUser.getUser());
        contPrintService.sendBack(contPrintVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 获取附件List
     * @param contNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-3-23 18:48:00
     */
    @RequestMapping(value = "getContPrintFileList",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> getContPrintFileList(String contNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                contPrintService.getContPrintFileList(contNo)), HttpStatus.OK);
    }


}
