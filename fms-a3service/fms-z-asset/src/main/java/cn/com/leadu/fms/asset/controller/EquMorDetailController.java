package cn.com.leadu.fms.asset.controller;

import cn.com.leadu.fms.asset.service.EquMorDetailService;
import cn.com.leadu.fms.asset.validator.equmordetail.vo.EquMorDetailSaveVo;
import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.asset.vo.equmordetail.EquMorDetailVo;
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
 * @author qiaomengnan
 * @ClassName: EquMorDetailController
 * @Description: 资方抵押明细相关接口
 * @date 2018-05-30
 */
@RestController
@RequestMapping("equ_mor_detail")
public class EquMorDetailController {

    /**
     * @Fields  : 资方抵押明细service
     */
    @Autowired
    private EquMorDetailService equMorDetailService;

    /**
     * @Title:
     * @Description: 查询资方抵押明细信息(申请)
     * @param equMorDetailVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "findEquMorDetailVos" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findEquMorDetailVos(EquMorDetailVo equMorDetailVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(equMorDetailService.findEquMorDetailVos(equMorDetailVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 查询资方抵押明细信息(审核)
     * @param equMorDetailVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "findEquMorDetailVoList" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findEquMorDetailVoList(EquMorDetailVo equMorDetailVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(equMorDetailService.findEquMorDetailVoList(equMorDetailVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存资方抵押明细
     * @param equMorDetailSaveVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "saveEquMorDetail",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveEquMorDetail(@Valid @RequestBody EquMorDetailSaveVo equMorDetailSaveVo){
        equMorDetailService.saveEquMorDetail(equMorDetailSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  资方解抵押申请(初次提交)
     * @param equMorDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "applyEquMorDetail",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> applyEquMorDetail(@Valid @RequestBody EquMorDetailVo equMorDetailVo,@AuthUserInfo SysUser sysUser){
        equMorDetailService.applyEquMorDetail(equMorDetailVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  资方解抵押申请(二次提交)
     * @param equMorDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "modifyEquMorDetail",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyEquMorDetail(@Valid @RequestBody EquMorDetailVo equMorDetailVo,@AuthUserInfo SysUser sysUser){
        equMorDetailService.modifyEquMorDetail(equMorDetailVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 资方抵押明细信息一览
     * @param equMorDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "findEquMorDetailVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findEquMorDetailVosByPage(EquMorDetailVo equMorDetailVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(equMorDetailService.findEquMorDetailVosByPage(equMorDetailVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 资方解押审核通过到制单或确认收款
     * @param equMorDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "approvalToVoucher" ,method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> approvalToVoucher(@Valid @RequestBody EquMorDetailVo equMorDetailVo,@AuthUserInfo SysUser sysUser){
        equMorDetailService.approvalToVoucher(equMorDetailVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 制单
     * @param equMorDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "approvalVoucher" ,method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> approvalVoucher(@Valid @RequestBody EquMorDetailVo equMorDetailVo,@AuthUserInfo SysUser sysUser){
        equMorDetailService.approvalVoucher(equMorDetailVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 财务付款
     * @param equMorDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "approvalFinance" ,method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> approvalFinance(@Valid @RequestBody EquMorDetailVo equMorDetailVo,@AuthUserInfo SysUser sysUser){
        equMorDetailService.approvalFinance(equMorDetailVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
    /**
     * @Title:
     * @Description: 财务确认收款
     * @param equMorDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "approvalReceipt" ,method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> approvalReceipt(@Valid @RequestBody EquMorDetailVo equMorDetailVo,@AuthUserInfo SysUser sysUser){
        equMorDetailService.approvalReceipt(equMorDetailVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
    /**
     * @Title:
     * @Description: 解抵押确认
     * @param equMorDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "approvalConfirm" ,method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> approvalConfirm(@Valid @RequestBody EquMorDetailVo equMorDetailVo,@AuthUserInfo SysUser sysUser){
        equMorDetailService.approvalConfirm(equMorDetailVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }
    /**
     * @Title:
     * @Description: 退回上一级
     * @param equMorDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-30 17:02:05
     */
    @RequestMapping(value = "sendBack" ,method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> sendBack(@Valid @RequestBody EquMorDetailVo equMorDetailVo,@AuthUserInfo SysUser sysUser){
        equMorDetailService.sendBack(equMorDetailVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 付款单打印
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "printEquRel",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> printEquRel(@Valid @RequestBody EquMorDetailVo equMorDetailVo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(equMorDetailService.printEquRel(equMorDetailVo)), HttpStatus.OK);
    }

}
