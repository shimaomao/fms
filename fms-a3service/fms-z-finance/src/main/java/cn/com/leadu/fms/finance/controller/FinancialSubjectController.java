package cn.com.leadu.fms.finance.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.finance.vo.financialsubject.FinancialSubjectVo;
import cn.com.leadu.fms.finance.service.FinancialSubjectService;
import cn.com.leadu.fms.finance.validator.financialsubject.vo.*;
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
 * @ClassName: FinancialSubjectController
 * @Description: 财务科目管理相关接口
 * @date 2018-06-20
 */
@RestController
@RequestMapping("financial_subject")
public class FinancialSubjectController {

    /**
     * @Fields  : 财务科目管理service
     */
    @Autowired
    private FinancialSubjectService financialSubjectService;

    /**
     * @Title:
     * @Description: 分页查询财务科目管理信息
     * @param financialSubjectVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @RequestMapping(value = "findFinancialSubjectsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinancialSubjectsByPage(FinancialSubjectVo financialSubjectVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(financialSubjectService.findFinancialSubjectsByPage(financialSubjectVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存财务科目管理
     * @param financialSubjectSaveVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @RequestMapping(value = "saveFinancialSubject",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveFinancialSubject(@Valid @RequestBody FinancialSubjectSaveVo financialSubjectSaveVo){
        financialSubjectService.saveFinancialSubject(financialSubjectSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改财务科目管理
     * @param financialSubjectModifyVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @RequestMapping(value = "modifyFinancialSubject",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyFinancialSubject(@Valid @RequestBody FinancialSubjectModifyVo financialSubjectModifyVo){
        financialSubjectService.modifyFinancialSubject(financialSubjectModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除财务科目管理
     * @param financialSubjectDeleteVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @RequestMapping(value = "deleteFinancialSubject",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteFinancialSubject(@Valid @RequestBody FinancialSubjectDeleteVo financialSubjectDeleteVo){
        financialSubjectService.deleteFinancialSubject(financialSubjectDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据subjectId集合删除财务科目管理
     * @param financialSubjectDeleteListVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @RequestMapping(value = "deleteFinancialSubjectsBySubjectIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteFinancialSubjectsBySubjectIds(@Valid @RequestBody FinancialSubjectDeleteListVo financialSubjectDeleteListVo){
        financialSubjectService.deleteFinancialSubjectsBySubjectIds(financialSubjectDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据subjectId获取财务科目管理
     * @param subjectId
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-6-20 11:24:39
     */
    @RequestMapping(value = "findFinancialSubjectBySubjectId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinancialSubjectBySubjectId(String subjectId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(financialSubjectService.findFinancialSubjectBySubjectId(subjectId)), HttpStatus.OK);
    }

}
