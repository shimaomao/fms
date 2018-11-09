package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.OverdueCstmPostVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecstm.OverdueCstmVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.postbiz.service.OverdueCstmService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

/**
 * @author lijunjun
 * @ClassName: OverdueCstmController
 * @Description: 逾期客户信息相关接口
 * @date 2018-05-16
 */
@RestController
@RequestMapping("overdue_cstm")
public class OverdueCstmController {

    /**
     * @Fields  : 逾期客户信息service
     */
    @Autowired
    private OverdueCstmService overdueCstmService;

    /**
     * @Title:
     * @Description: 分页查询逾期客户信息信息
     * @param overdueCstmVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "findOverdueCstmsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueCstmsByPage(OverdueCstmVo overdueCstmVo, @AuthUserInfo SysUser sysUser){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(overdueCstmService.findOverdueCstmsByPage(overdueCstmVo, sysUser)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存逾期客户信息
     * @param overdueCstmPostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "saveOverdueCstmInfo",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveOverdueCstmInfo(@Valid @RequestBody OverdueCstmPostVo overdueCstmPostVo, @AuthUserInfo SysUser sysUser){
        overdueCstmService.saveOverdueCstmInfo(overdueCstmPostVo, sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 催收函生成
     * @param overdueCstmPostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "collectionLetterDownload",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> collectionLetterDownload(@Valid @RequestBody OverdueCstmPostVo overdueCstmPostVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(overdueCstmService.collectionLetterDownload(overdueCstmPostVo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 律师函生成
     * @param overdueCstmPostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "lawyerLetterDownload",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> lawyerLetterDownload(@Valid @RequestBody OverdueCstmPostVo overdueCstmPostVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(overdueCstmService.lawyerLetterDownload(overdueCstmPostVo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据overdueCstmId获取逾期客户信息
     * @param overdueCstmId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "findOverdueCstmByOverdueCstmId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueCstmByOverdueCstmId(String overdueCstmId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(overdueCstmService.findOverdueCstmByOverdueCstmId(overdueCstmId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据overdueCstmId获取逾期客户信息
     * @param overdueCstmId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "findOverdueCstmVoByOverdueCstmId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueCstmVoByOverdueCstmId(String overdueCstmId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(overdueCstmService.findOverdueCstmVoByOverdueCstmId(overdueCstmId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据overdueCstmId获取还款信息和逾期信息
     * @param overdueCstmVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "findContRepaySkedAndOverduByoverdueCstmId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepaySkedAndOverduByoverdueCstmId(OverdueCstmVo overdueCstmVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(overdueCstmService
                .findContRepaySkedAndOverduByoverdueCstmId(overdueCstmVo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根当前销售未还剩余本金 -->打开 合同还款计划表
     * @param overdueCstmVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "findContRepaySkedVoByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContRepaySkedVoByContNo(OverdueCstmVo overdueCstmVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(overdueCstmService
                .findContRepaySkedVoByContNo(overdueCstmVo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  当前财务未还剩余本金 -->打开【财务还款计划表】*关联合同还款计划表取得扣款状态
     * @param overdueCstmVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "findContOverdueVoByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContOverdueVoByContNo(OverdueCstmVo overdueCstmVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(overdueCstmService
                .findContOverdueVoByContNo(overdueCstmVo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  获取登记电话、地址等基础信息
     * @param overdueCstmPostVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "findOverdueRegisterInfo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueRegisterInfo(OverdueCstmPostVo overdueCstmPostVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(overdueCstmService
                .findOverdueRegisterInfo(overdueCstmPostVo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 获取分配人员信息
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 10:23:04
     */
    @RequestMapping(value = "findAssignUsers", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findAssignUsers(){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(overdueCstmService.findAssignUsers()), HttpStatus.OK);
    }
}
