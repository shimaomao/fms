package cn.com.leadu.fms.cost.controller;

import cn.com.leadu.fms.common.constant.enums.sql.PageFlags;
import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.cost.vo.pilferinsurance.PilferInsuranceVo;
import cn.com.leadu.fms.cost.service.PilferInsuranceService;
import cn.com.leadu.fms.cost.validator.pilferinsurance.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @author yangyiquan
 * @ClassName: PilferInsuranceController
 * @Description: 盗抢险信息相关接口
 * @date 2018-05-31
 */
@RestController
@RequestMapping("pilfer_insurance")
public class PilferInsuranceController {

    /**
     * @Fields  : 盗抢险信息service
     */
    @Autowired
    private PilferInsuranceService pilferInsuranceService;

    /**
     * @Title:
     * @Description: 分页查询盗抢险信息信息
     * @param pilferInsuranceVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @RequestMapping(value = "findPilferInsurancesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findPilferInsurancesByPage(PilferInsuranceVo pilferInsuranceVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(pilferInsuranceService.findPilferInsurancesByPage(pilferInsuranceVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存盗抢险信息
     * @param pilferInsuranceSaveVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @RequestMapping(value = "savePilferInsurance",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> savePilferInsurance(@Valid @RequestBody PilferInsuranceSaveVo pilferInsuranceSaveVo){
        pilferInsuranceService.savePilferInsurance(pilferInsuranceSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改盗抢险信息
     * @param pilferInsuranceModifyVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @RequestMapping(value = "modifyPilferInsurance",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyPilferInsurance(@Valid @RequestBody PilferInsuranceModifyVo pilferInsuranceModifyVo){
        pilferInsuranceService.modifyPilferInsurance(pilferInsuranceModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除盗抢险信息
     * @param pilferInsuranceDeleteVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @RequestMapping(value = "deletePilferInsurance",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deletePilferInsurance(@Valid @RequestBody PilferInsuranceDeleteVo pilferInsuranceDeleteVo){
        pilferInsuranceService.deletePilferInsurance(pilferInsuranceDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据pilferInsuranceId集合删除盗抢险信息
     * @param pilferInsuranceDeleteListVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @RequestMapping(value = "deletePilferInsurancesByPilferInsuranceIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deletePilferInsurancesByPilferInsuranceIds(@Valid @RequestBody PilferInsuranceDeleteListVo pilferInsuranceDeleteListVo){
        pilferInsuranceService.deletePilferInsurancesByPilferInsuranceIds(pilferInsuranceDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据pilferInsuranceId获取盗抢险信息
     * @param pilferInsuranceId
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:34:24
     */
    @RequestMapping(value = "findPilferInsuranceByPilferInsuranceId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findPilferInsuranceByPilferInsuranceId(String pilferInsuranceId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(pilferInsuranceService.findPilferInsuranceByPilferInsuranceId(pilferInsuranceId)), HttpStatus.OK);
    }

    /** 
    * @Description: 查询盗抢险月结一览信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/31 18:29
    */ 
    @RequestMapping(value = "findPilferInsuranceMonthlysVosListByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findPilferInsuranceMonthlysVosListByPage(PilferInsuranceVo pilferInsuranceVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(pilferInsuranceService.findPilferInsuranceMonthlysVosListByPage(pilferInsuranceVo)),
                HttpStatus.OK);
    }

    /** 
    * @Description: 查询盗抢险月结信息 ,不分页 ,POST请求
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/31 18:29
    */ 
    @RequestMapping(value = "findPilferInsuranceMonthlysVos" ,method = RequestMethod.POST)
    public ResponseEntity<RestResponse> findPilferInsuranceMonthlysVos(@Valid @RequestBody PilferInsuranceVo pilferInsuranceVo){
        pilferInsuranceVo.setPageFlag(PageFlags.NOT_PAGE.getFlag());//不分页标识
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(pilferInsuranceService.findPilferInsuranceMonthlysVos(pilferInsuranceVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 根据合同号获取盗抢险信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "findPilferInsuranceVoByContNo", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findPilferInsuranceVoByContNo(String contNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(pilferInsuranceService.findPilferInsuranceVoByContNo(contNo)), HttpStatus.OK);
    }

}
