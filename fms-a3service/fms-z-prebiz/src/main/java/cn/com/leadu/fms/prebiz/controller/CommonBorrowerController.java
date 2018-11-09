package cn.com.leadu.fms.prebiz.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.vo.commonborrower.CommonBorrowerVo;
import cn.com.leadu.fms.prebiz.service.CommonBorrowerService;
import cn.com.leadu.fms.prebiz.validator.commonborrower.vo.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import javax.validation.Valid;

/**
 * @author ningyangyang
 * @ClassName: CommonBorrowerController
 * @Description: 共同借款人相关接口
 * @date 2018-05-25
 */
@RestController
@RequestMapping("common_borrower")
public class CommonBorrowerController {

    /**
     * @Fields  : 共同借款人service
     */
    @Autowired
    private CommonBorrowerService commonBorrowerService;

    /**
     * @Title:
     * @Description: 分页查询共同借款人信息
     * @param commonBorrowerVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:14
     */
    @RequestMapping(value = "findCommonBorrowersByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCommonBorrowersByPage(CommonBorrowerVo commonBorrowerVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(commonBorrowerService.findCommonBorrowersByPage(commonBorrowerVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存共同借款人
     * @param commonBorrowerSaveVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:14
     */
    @RequestMapping(value = "saveCommonBorrower",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveCommonBorrower(@Valid @RequestBody CommonBorrowerSaveVo commonBorrowerSaveVo){
        commonBorrowerService.saveCommonBorrower(commonBorrowerSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改共同借款人
     * @param commonBorrowerModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:14
     */
    @RequestMapping(value = "modifyCommonBorrower",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyCommonBorrower(@Valid @RequestBody CommonBorrowerModifyVo commonBorrowerModifyVo){
        commonBorrowerService.modifyCommonBorrower(commonBorrowerModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除共同借款人
     * @param commonBorrowerDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:14
     */
    @RequestMapping(value = "deleteCommonBorrower",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCommonBorrower(@Valid @RequestBody CommonBorrowerDeleteVo commonBorrowerDeleteVo){
        commonBorrowerService.deleteCommonBorrower(commonBorrowerDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据comBorrowerId集合删除共同借款人
     * @param commonBorrowerDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:14
     */
    @RequestMapping(value = "deleteCommonBorrowersByComBorrowerIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteCommonBorrowersByComBorrowerIds(@Valid @RequestBody CommonBorrowerDeleteListVo commonBorrowerDeleteListVo){
        commonBorrowerService.deleteCommonBorrowersByComBorrowerIds(commonBorrowerDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据comBorrowerId获取共同借款人
     * @param comBorrowerId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-25 15:37:14
     */
    @RequestMapping(value = "findCommonBorrowerByComBorrowerId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findCommonBorrowerByComBorrowerId(String comBorrowerId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(commonBorrowerService.findCommonBorrowerByComBorrowerId(comBorrowerId)), HttpStatus.OK);
    }

}
