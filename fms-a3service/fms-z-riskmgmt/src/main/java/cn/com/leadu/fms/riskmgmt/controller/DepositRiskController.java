package cn.com.leadu.fms.riskmgmt.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.riskmgmt.vo.depositrisk.DepositRiskVo;
import cn.com.leadu.fms.pojo.riskmgmt.vo.pycreditlist.PycreditListVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.riskmgmt.service.DepositRiskService;
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
 * @Description: 保证金变更风控审批相关接口
 * @date 2018-03-24
 */
@RestController
@RequestMapping("deposit_risk")
public class DepositRiskController {

    /**
     * @Fields : 保证金变更风控审批Service
     */
    @Autowired
    private DepositRiskService depositRiskService;
    /**
     * @Fields : 鹏元征信Service
     */
    @Autowired
    private PycreditRiskService pycreditRiskService;

    /**
     * @param depositTaskNo 变更任务号
     * @return
     * @throws
     * @Title:
     * @Description: 取得风控初始数据
     * @author liujinge
     * @date 2018-6-5 16:18:12
     */
    @RequestMapping(value = "findApplyRiskInit", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findApplyRiskInit(String depositTaskNo) {
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(depositRiskService.findApplyRiskInit(depositTaskNo)), HttpStatus.OK);
    }

    /**
     * @Description: 保存风控数据
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/6/6 15:33
     */
    @RequestMapping(value = "saveApplyRisk", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveApplyRisk(@Valid @RequestBody DepositRiskVo depositRiskVo, @AuthUserInfo SysUser sysUser) {
        depositRiskService.saveApplyRiskInit(depositRiskVo, sysUser);
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
    public ResponseEntity<RestResponse> saveApplyRiskPyCredit(@Valid @RequestBody PycreditListVo pycreditListVo) {
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(pycreditRiskService.saveApplyRiskPyCredit(pycreditListVo)), HttpStatus.OK);
    }

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @Title:
     * @Description: 复审退回操作
     * @author huzongcheng
     * @date
     */
    @RequestMapping(value = "sendBack", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> sendBack(@RequestBody DepositRiskVo vo, @AuthUserInfo SysUser sysUser) {
        depositRiskService.sendBack(vo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @param vo      入参实体类
     * @param sysUser 当前登录用户
     * @Title:
     * @Description: 复审拒绝操作
     * @author huzongcheng
     * @date
     */
    @RequestMapping(value = "refuse", method = RequestMethod.POST)
    public ResponseEntity<RestResponse> refuse(@RequestBody DepositRiskVo vo, @AuthUserInfo SysUser sysUser) {
        depositRiskService.refuse(vo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
}
