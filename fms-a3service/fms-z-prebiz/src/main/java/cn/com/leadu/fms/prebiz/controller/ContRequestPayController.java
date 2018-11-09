package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.vo.contrequestpay.ContRequestPayVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.prebiz.service.ContRequestPayService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author huchenghao
 * @ClassName: ProductController
 * @Description:
 * @date 2018-03-23
 */
@RestController
@RequestMapping("cont_request_pay")
public class ContRequestPayController {

    /**
     * @Fields  : 经销商请款service
     */
    @Autowired
    private ContRequestPayService contRequestPayService;


    /**
     * @Title:
     * @Description: 提交产品方案管理
     * @param contRequestPayVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-23 10:18:12
     */
    @RequestMapping(value = "submitContRequestPay",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> submitContRequestPay(@Valid @RequestBody ContRequestPayVo contRequestPayVo, @AuthUserInfo SysUser sysUser){
        contRequestPayVo.setUser(sysUser.getUser());
        contRequestPayService.submitContRequestPay(contRequestPayVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 退回
     * @param contRequestPayVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-23 10:18:12
     */
    @RequestMapping(value = "sendBack",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> sendBack(@Valid @RequestBody ContRequestPayVo contRequestPayVo, @AuthUserInfo SysUser sysUser){
        contRequestPayVo.setUser(sysUser.getUser());
        contRequestPayService.sendBack(contRequestPayVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
    /**
     * @Title:
     * @Description: 暂存产品方案管理
     * @param contRequestPayVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-23 10:18:12
     */
    @RequestMapping(value = "saveContRequestPay",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContRequestPay(@Valid @RequestBody ContRequestPayVo contRequestPayVo){
        contRequestPayService.saveContRequestPay(contRequestPayVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据合同号查询车辆保险信息
     * @param contNo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-3-23 10:18:12
     */
    @RequestMapping(value = "findContRequestPayByContNo",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRequestPayByContNo(String contNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contRequestPayService.findContRequestPayByContNo(contNo)), HttpStatus.OK);
    }

}
