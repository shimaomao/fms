package cn.com.leadu.fms.insurance.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.insurance.service.ContInsurClaimService;
import cn.com.leadu.fms.insurance.validator.continsurclaim.vo.ContInsurClaimDeleteListVo;
import cn.com.leadu.fms.insurance.validator.continsurclaim.vo.ContInsurClaimDeleteVo;
import cn.com.leadu.fms.insurance.validator.continsurclaim.vo.ContInsurClaimModifyVo;
import cn.com.leadu.fms.insurance.validator.continsurclaim.vo.ContInsurClaimSaveVo;
import cn.com.leadu.fms.pojo.insurance.vo.continsurclaim.ContInsurClaimVo;
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
 * @author yanfengbo
 * @ClassName: ContInsurClaimController
 * @Description: 保险理赔相关接口
 * @date 2018-05-14
 */
@RestController
@RequestMapping("cont_insur_claim")
public class ContInsurClaimController {

    /**
     * @Fields  : 保险理赔service
     */
    @Autowired
    private ContInsurClaimService contInsurClaimService;

    /**
     * @Title:
     * @Description: 分页查询保险理赔信息一览
     * @param contInsurClaimVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:20
     */
    @RequestMapping(value = "findContInsurClaimsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContInsurClaimsByPage(ContInsurClaimVo contInsurClaimVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contInsurClaimService.findContInsurClaimsByPage(contInsurClaimVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 分页查询保险理赔查询页面
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "findContInsurClaimsByPageSelect" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContInsurClaimsByPageSelect(ContInsurClaimVo contInsurClaimVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contInsurClaimService.findContInsurClaimsByPageSelect(contInsurClaimVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存保险理赔
     * @param contInsurClaimVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:20
     */
    @RequestMapping(value = "saveContInsurClaim",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContInsurClaim(@Valid @RequestBody ContInsurClaimVo contInsurClaimVo,@AuthUserInfo SysUser sysUser){
        contInsurClaimService.saveContInsurClaim(contInsurClaimVo,sysUser);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改保险理赔
     * @param contInsurClaimModifyVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:20
     */
    @RequestMapping(value = "modifyContInsurClaim",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyContInsurClaim(@Valid @RequestBody ContInsurClaimModifyVo contInsurClaimModifyVo){
        contInsurClaimService.modifyContInsurClaim(contInsurClaimModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除保险理赔
     * @param contInsurClaimDeleteVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:20
     */
    @RequestMapping(value = "deleteContInsurClaim",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteContInsurClaim(@Valid @RequestBody ContInsurClaimDeleteVo contInsurClaimDeleteVo){
        contInsurClaimService.deleteContInsurClaim(contInsurClaimDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据contInsurClaimId集合删除保险理赔
     * @param contInsurClaimDeleteListVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:20
     */
    @RequestMapping(value = "deleteContInsurClaimsByContInsurClaimIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteContInsurClaimsByContInsurClaimIds(@Valid @RequestBody ContInsurClaimDeleteListVo contInsurClaimDeleteListVo){
        contInsurClaimService.deleteContInsurClaimsByContInsurClaimIds(contInsurClaimDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据contInsurClaimId获取保险理赔
     * @param contInsurClaimId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-14 10:35:20
     */
    @RequestMapping(value = "findContInsurClaimByContInsurClaimId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContInsurClaimByContInsurClaimId(String contInsurClaimId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contInsurClaimService.findContInsurClaimByContInsurClaimId(contInsurClaimId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据合同编号和保险信息id查询一条明细
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "findDetailedByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findDetailedByContNo(String contVehinsId,String contInsurClaimId,String serviceId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contInsurClaimService.findDetailedByContNo(contVehinsId,contInsurClaimId,serviceId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 取保险理赔详情
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "findDetailContInsurClaim", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findDetailContInsurClaim(String serviceId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contInsurClaimService.findDetailContInsurClaim(serviceId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保险理赔excel导出
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "findContInsurClaimsByPageSelect2" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContInsurClaimsByPageSelect2(ContInsurClaimVo contInsurClaimVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contInsurClaimService.findContInsurClaimsByPageSelect2(contInsurClaimVo)),
                HttpStatus.OK);
    }

}
