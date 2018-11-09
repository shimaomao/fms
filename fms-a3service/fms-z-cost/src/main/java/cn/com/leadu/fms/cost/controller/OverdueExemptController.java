package cn.com.leadu.fms.cost.controller;

import cn.com.leadu.fms.cost.service.OverdueExemptService;
import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.cost.vo.overdueexempt.OverdueExemptVo;
import cn.com.leadu.fms.pojo.finance.vo.contoverdue.ContOverdueVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecont.OverdueContVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
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
 * @ClassName: OverdueContController
 * @Description: 逾期合同信息相关接口
 * @date 2018-05-16
 */
@RestController
@RequestMapping("overdue_exempt")
public class OverdueExemptController {

    /**
     * @Fields  : 逾期合同信息service
     */
    @Autowired
    private OverdueExemptService overdueExemptService;

    /**
     * @Title:
     * @Description: 分页查询罚息免除任务表信息
     * @param overdueExemptVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:08:30
     */
    @RequestMapping(value = "findOverdueExemptsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findOverdueExemptsByPage(OverdueExemptVo overdueExemptVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(overdueExemptService.findOverdueExemptsByPage(overdueExemptVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 取得罚息免除一览
     * @param contOverdueVo
     * @return
     * @throws
     * @author yanfengbo
     */
    @RequestMapping(value = "findContOverdueVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContOverdueVosByPage(ContOverdueVo contOverdueVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(overdueExemptService.findContOverdueVosByPage(contOverdueVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据contNo获取逾期罚息信息和合同信息(初次提交页面回显)
     * @param contNo
     * @return
     * @throws
     * @author yanfengbo
     */
    @RequestMapping(value = "findDetailBycontNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findDetailBycontNo(String contNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(overdueExemptService.findDetailBycontNo(contNo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据serviceId获取逾期合同信息(退回)(二次提交页面回显)
     * @param serviceId
     * @return
     * @throws
     * @author yanfengbo
     */
    @RequestMapping(value = "findDetailByServiceId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findDetailByServiceId(String serviceId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(overdueExemptService.findDetailByServiceId(serviceId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据serviceId获取审批详情
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
//    @RequestMapping(value = "findDetailByServiceId", method = RequestMethod.GET)
//    public ResponseEntity<RestResponse> findDetailByServiceId(String serviceId){
//        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(overdueExemptService.findDetailByServiceId(serviceId)), HttpStatus.OK);
//    }

    /**
     * @Title:
     * @Description: 罚息免除
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "entryOverdueCont",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> entryOverdueCont(@Valid @RequestBody OverdueExemptVo overdueExemptVo,@AuthUserInfo SysUser sysUser){
        overdueExemptService.entryOverdueCont(overdueExemptVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 罚息免除审核通过
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "approval",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> approval(@RequestBody OverdueExemptVo overdueExemptVo, @AuthUserInfo SysUser sysUser){
        //basBankInfoVo.setPresentUser(sysUser.getUser());
        overdueExemptService.approval(overdueExemptVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 罚息免除退回
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "sendBack",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> sendBack(@RequestBody OverdueExemptVo overdueExemptVo, @AuthUserInfo SysUser sysUser){
        //basBankInfoVo.setPresentUser(sysUser.getUser());
        overdueExemptService.sendBack(overdueExemptVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
}
