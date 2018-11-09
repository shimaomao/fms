package cn.com.leadu.fms.postbiz.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.postbiz.vo.annualinspection.AnnualInspectionVo;
import cn.com.leadu.fms.postbiz.service.AnnualInspectionService;
import cn.com.leadu.fms.postbiz.validator.annualinspection.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;


/**
 * @author qinmuqiao
 * @ClassName: AnnualInspectionController
 * @Description: 年检提醒相关接口
 */
@RestController
@RequestMapping("annual_inspection")
public class AnnualInspectionController {

    /**
     * @Fields  : 年检提醒service
     */
    @Autowired
    private AnnualInspectionService annualInspectionService;

    /**
     * @Title:
     * @Description: 分页查询年检提醒信息
     * @param annualInspectionVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:08
     */
    @RequestMapping(value = "findAnnualInspectionVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findAnnualInspectionVosByPage(AnnualInspectionVo annualInspectionVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(annualInspectionService.findAnnualInspectionVosByPage(annualInspectionVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改年检提醒
     * @param annualInspectionModifyVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:08
     */
    @RequestMapping(value = "modifyAnnualInspection",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyAnnualInspection(@Valid @RequestBody AnnualInspectionModifyVo annualInspectionModifyVo){
        annualInspectionService.modifyAnnualInspection(annualInspectionModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据annualInspectionId获取年检提醒
     * @param annualInspectionId
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:08
     */
    @RequestMapping(value = "findAnnualInspectionVoByAnnualInspectionId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findAnnualInspectionVoByAnnualInspectionId(String annualInspectionId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(annualInspectionService.findAnnualInspectionVoByAnnualInspectionId(annualInspectionId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  获取合同信息表里面符合的数据
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:08
     */
    @RequestMapping(value = "findInfomationFromContract", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findInfomationFromContract(){
        annualInspectionService.findInfomationFromContract();
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

}
