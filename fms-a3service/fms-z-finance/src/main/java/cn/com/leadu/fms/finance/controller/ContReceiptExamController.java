package cn.com.leadu.fms.finance.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.finance.vo.contreceiptexam.ContReceiptExamVo;
import cn.com.leadu.fms.finance.service.ContReceiptExamService;
import cn.com.leadu.fms.finance.validator.contreceiptexam.vo.*;
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
 * @ClassName: ContReceiptExamController
 * @Description: 财务勾稽相关接口
 * @date 2018-05-09
 */
@RestController
@RequestMapping("cont_receipt_exam")
public class ContReceiptExamController {

    /**
     * @Fields  : 财务勾稽service
     */
    @Autowired
    private ContReceiptExamService contReceiptExamService;

    /**
     * @Title:
     * @Description: 分页查询财务勾稽信息
     * @param contReceiptExamVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-9 11:52:37
     */
    @RequestMapping(value = "findContReceiptExamsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContReceiptExamsByPage(ContReceiptExamVo contReceiptExamVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(contReceiptExamService.findContReceiptExamsByPage(contReceiptExamVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存财务勾稽
     * @param contReceiptExamSaveVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-9 11:52:37
     */
    @RequestMapping(value = "saveContReceiptExam",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContReceiptExam(@Valid @RequestBody ContReceiptExamSaveVo contReceiptExamSaveVo){
        contReceiptExamService.saveContReceiptExam(contReceiptExamSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改财务勾稽
     * @param contReceiptExamModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-9 11:52:37
     */
    @RequestMapping(value = "modifyContReceiptExam",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyContReceiptExam(@Valid @RequestBody ContReceiptExamModifyVo contReceiptExamModifyVo){
        contReceiptExamService.modifyContReceiptExam(contReceiptExamModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除财务勾稽
     * @param contReceiptExamDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-9 11:52:37
     */
    @RequestMapping(value = "deleteContReceiptExam",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteContReceiptExam(@Valid @RequestBody ContReceiptExamDeleteVo contReceiptExamDeleteVo){
        contReceiptExamService.deleteContReceiptExam(contReceiptExamDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据contReceiptExamId集合删除财务勾稽
     * @param contReceiptExamDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-9 11:52:37
     */
    @RequestMapping(value = "deleteContReceiptExamsByContReceiptExamIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteContReceiptExamsByContReceiptExamIds(@Valid @RequestBody ContReceiptExamDeleteListVo contReceiptExamDeleteListVo){
        contReceiptExamService.deleteContReceiptExamsByContReceiptExamIds(contReceiptExamDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据contReceiptExamId获取财务勾稽
     * @param contReceiptExamId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-9 11:52:37
     */
    @RequestMapping(value = "findContReceiptExamByContReceiptExamId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContReceiptExamByContReceiptExamId(String contReceiptExamId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(contReceiptExamService.findContReceiptExamByContReceiptExamId(contReceiptExamId)), HttpStatus.OK);
    }

}
