package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.vo.applycancel.ApplyCancelVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.prebiz.service.ApplyCancelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * Created by yanfengbo on 2018/3/28.
 * 融资申请取消
 */
@RestController
@RequestMapping("apply_cancel")
public class ApplyCancelController {
    /*
        融资申请取消Service
     */
    @Autowired
    private ApplyCancelService applyCancelService;

    @RequestMapping(value = "findApplyCancelsByPage", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyCancelsByPage(ApplyCancelVo applyCancelVo,@AuthUserInfo SysUser sysUser) {
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(applyCancelService.findApplyCancelsByPage(applyCancelVo,sysUser)),
                HttpStatus.OK);
    }

     /*public void controller(@AuthUserInfo SysUser sysUser){

     }*/


    /**
     * @Title:
     * @Description:  根据applyNo获取融资申请取消
     * @param applyNo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "findApplyCancelVoByApplyNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyCancelVoByApplyNo(String applyNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(applyCancelService.findApplyCancelVoByApplyNo(applyNo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  融资申请取消
     * @param applyCancelVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "modifyApplyCancel",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyApplyCancel(@Valid @RequestBody ApplyCancelVo applyCancelVo,@AuthUserInfo SysUser sysUser){
        applyCancelService.modifyApplyCancel(applyCancelVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
}
