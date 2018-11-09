package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.vo.quotationdevice.QuotationDeviceVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.pojo.system.vo.sysuser.SysUserVo;
import cn.com.leadu.fms.prebiz.service.QuotationDeviceService;
import cn.com.leadu.fms.prebiz.validator.quotationdevice.vo.*;
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
 * @ClassName: QuotationDeviceController
 * @Description: 报价器信息相关接口
 * @date 2018-05-23
 */
@RestController
@RequestMapping("quotation_device")
public class QuotationDeviceController {

    /**
     * @Fields  : 报价器信息service
     */
    @Autowired
    private QuotationDeviceService quotationDeviceService;

    /**
     * @Title:
     * @Description: 分页查询报价器信息信息
     * @param quotationDeviceVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    @RequestMapping(value = "findQuotationDevicesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findQuotationDevicesByPage(QuotationDeviceVo quotationDeviceVo,@AuthUserInfo SysUserVo sysUser){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(quotationDeviceService.findQuotationDevicesByPage(quotationDeviceVo,sysUser)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 打印报价器信息信息
     * @param quotationDeviceVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    @RequestMapping(value = "printQuotationDevice" ,method = RequestMethod.POST)
    public ResponseEntity<RestResponse> printQuotationDevice(@Valid @RequestBody QuotationDeviceVo quotationDeviceVo,@AuthUserInfo SysUser sysUser){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(quotationDeviceService.printQuotationDevice(quotationDeviceVo, "",sysUser)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存报价器信息
     * @param quotationDeviceSaveVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    @RequestMapping(value = "saveQuotationDevice",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveQuotationDevice(@Valid @RequestBody QuotationDeviceSaveVo quotationDeviceSaveVo){
        quotationDeviceService.saveQuotationDevice(quotationDeviceSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改报价器信息
     * @param quotationDeviceModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    @RequestMapping(value = "modifyQuotationDevice",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyQuotationDevice(@Valid @RequestBody QuotationDeviceModifyVo quotationDeviceModifyVo){
        quotationDeviceService.modifyQuotationDevice(quotationDeviceModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除报价器信息
     * @param quotationDeviceDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    @RequestMapping(value = "deleteQuotationDevice",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteQuotationDevice(@Valid @RequestBody QuotationDeviceDeleteVo quotationDeviceDeleteVo){
        quotationDeviceService.deleteQuotationDevice(quotationDeviceDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据quotationDeviceId集合删除报价器信息
     * @param quotationDeviceDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    @RequestMapping(value = "deleteQuotationDevicesByQuotationDeviceIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteQuotationDevicesByQuotationDeviceIds(@Valid @RequestBody QuotationDeviceDeleteListVo quotationDeviceDeleteListVo){
        quotationDeviceService.deleteQuotationDevicesByQuotationDeviceIds(quotationDeviceDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据quotationDeviceId获取报价器信息
     * @param quotationDeviceId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    @RequestMapping(value = "findQuotationDeviceByQuotationDeviceId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findQuotationDeviceByQuotationDeviceId(String quotationDeviceId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(quotationDeviceService.findQuotationDeviceByQuotationDeviceId(quotationDeviceId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  获取计算所需参数
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    @RequestMapping(value = "findSysParam", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findSysParam(){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(quotationDeviceService.findSysParam()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存报价器信息
     * @param quotationDeviceVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    @RequestMapping(value = "saveQuotationDeviceInfo",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveQuotationDeviceInfo(@Valid @RequestBody QuotationDeviceVo quotationDeviceVo,@AuthUserInfo SysUser sysUser){
        //订单提出用户和订单提出机构代码
        quotationDeviceVo.setApplyUserContr(sysUser.getUser());
        quotationDeviceVo.setApplyGroupContr(sysUser.getGroupCode());
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                quotationDeviceService.saveQuotationDeviceInfo(quotationDeviceVo, "")), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 计算报价器信息
     * @param quotationDeviceVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-23 17:02:03
     */
    @RequestMapping(value = "calculateQuotationDeviceInfo",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> calculateQuotationDeviceInfo(@Valid @RequestBody QuotationDeviceVo quotationDeviceVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                quotationDeviceService.saveQuotationDeviceInfo(quotationDeviceVo, "2")), HttpStatus.OK);
    }

}
