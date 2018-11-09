package cn.com.leadu.fms.riskmgmt.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.riskmgmt.vo.applyrisk.ApplyRiskVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditlist.PycreditListVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.riskmgmt.service.ApplyRiskService;
import cn.com.leadu.fms.riskmgmt.service.PycreditRiskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author wangxue
 * @ClassName: ApplyInputController
 * @Description: 申请录入管理相关接口
 * @date 2018-03-24
 */
@RestController
@RequestMapping("apply_risk")
public class ApplyRiskController {

    /**
     * @Fields  : 风控审批管理Service
     */
    @Autowired
    private ApplyRiskService applyRiskService;
    /**
     * @Fields  : 鹏元征信Service
     */
    @Autowired
    private PycreditRiskService pycreditRiskService;
    /**
     * @Title:
     * @Description: 取得风控初始数据
     * @param applyNo
     * @return
     * @throws
     * @author liujinge
     * @date 2018-6-5 16:18:12
     */
    @RequestMapping(value = "findApplyRiskInit", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyRiskInit(String applyNo,String flag){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(applyRiskService.findApplyRiskInit(applyNo,flag)), HttpStatus.OK);
    }

    /** 
    * @Description: 保存风控数据
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/6 15:33
    */ 
    @RequestMapping(value = "saveApplyRisk",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveApplyRisk(@Valid @RequestBody ApplyRiskVo applyRiskVo, @AuthUserInfo SysUser sysUser){
        applyRiskVo.setUser(sysUser.getUser());
        applyRiskService.saveApplyRiskInit(applyRiskVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /** 
    * @Description: 退回上一级
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/23 14:14
    */ 
    @RequestMapping(value = "backApplyRisk",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> backApplyRisk(@Valid @RequestBody ApplyRiskVo applyRiskVo, @AuthUserInfo SysUser sysUser){
        applyRiskVo.setUser(sysUser.getUser());
        applyRiskService.backApplyRisk(applyRiskVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
    * @Description: 退回到业务员
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/24 10:35
    */
    @RequestMapping(value = "backToApply",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> backToApply(@Valid @RequestBody ApplyRiskVo applyRiskVo, @AuthUserInfo SysUser sysUser){
        applyRiskVo.setUser(sysUser.getUser());
        applyRiskService.backToApply(applyRiskVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Description: 保存风控数据
     * @param:
     * @return:
     * @Author: yanggang
     * @Date: 2018/6/8 15:33
     */
    @RequestMapping(value = "saveApplyRiskPyCredit", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveApplyRiskPyCredit(@Valid @RequestBody PycreditListVo pycreditListVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(pycreditRiskService.saveApplyRiskPyCredit(pycreditListVo)), HttpStatus.OK);
    }
}
