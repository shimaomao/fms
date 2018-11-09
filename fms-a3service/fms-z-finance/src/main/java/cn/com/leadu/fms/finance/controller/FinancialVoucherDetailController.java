package cn.com.leadu.fms.finance.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.finance.vo.financialvoucherdetail.FinancialVoucherDetailVo;
import cn.com.leadu.fms.finance.service.FinancialVoucherDetailService;
import cn.com.leadu.fms.finance.validator.financialvoucherdetail.vo.*;
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
 * @ClassName: FinancialVoucherDetailController
 * @Description: 凭证类型明细管理相关接口
 * @date 2018-06-20
 */
@RestController
@RequestMapping("financial_voucher_detail")
public class FinancialVoucherDetailController {

    /**
     * @Fields  : 凭证类型明细管理service
     */
    @Autowired
    private FinancialVoucherDetailService financialVoucherDetailService;

    /**
     * @Title:
     * @Description: 分页查询凭证类型明细管理信息
     * @param financialVoucherDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @RequestMapping(value = "findFinancialVoucherDetailsByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinancialVoucherDetailsByPage(FinancialVoucherDetailVo financialVoucherDetailVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(financialVoucherDetailService.findFinancialVoucherDetailsByPage(financialVoucherDetailVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存凭证类型明细管理
     * @param financialVoucherDetailSaveVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @RequestMapping(value = "saveFinancialVoucherDetail",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveFinancialVoucherDetail(@Valid @RequestBody FinancialVoucherDetailSaveVo financialVoucherDetailSaveVo){
        financialVoucherDetailService.saveFinancialVoucherDetail(financialVoucherDetailSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改凭证类型明细管理
     * @param financialVoucherDetailModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @RequestMapping(value = "modifyFinancialVoucherDetail",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyFinancialVoucherDetail(@Valid @RequestBody FinancialVoucherDetailModifyVo financialVoucherDetailModifyVo){
        financialVoucherDetailService.modifyFinancialVoucherDetail(financialVoucherDetailModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除凭证类型明细管理
     * @param financialVoucherDetailDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @RequestMapping(value = "deleteFinancialVoucherDetail",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteFinancialVoucherDetail(@Valid @RequestBody FinancialVoucherDetailDeleteVo financialVoucherDetailDeleteVo){
        financialVoucherDetailService.deleteFinancialVoucherDetail(financialVoucherDetailDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据voucherDetailId集合删除凭证类型明细管理
     * @param financialVoucherDetailDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @RequestMapping(value = "deleteFinancialVoucherDetailsByVoucherDetailIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteFinancialVoucherDetailsByVoucherDetailIds(@Valid @RequestBody FinancialVoucherDetailDeleteListVo financialVoucherDetailDeleteListVo){
        financialVoucherDetailService.deleteFinancialVoucherDetailsByVoucherDetailIds(financialVoucherDetailDeleteListVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据voucherDetailId获取凭证类型明细管理
     * @param voucherDetailId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @RequestMapping(value = "findFinancialVoucherDetailByVoucherDetailId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinancialVoucherDetailByVoucherDetailId(String voucherDetailId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(financialVoucherDetailService.findFinancialVoucherDetailByVoucherDetailId(voucherDetailId)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据凭证类型取得凭证类型明细列表
     * @param voucherType
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/21 06:07:42
     */
    @RequestMapping(value = "findFinancialVoucherDetailsByVoucherType", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinancialVoucherDetailsByVoucherType(String voucherType){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(
                financialVoucherDetailService.findFinancialVoucherDetailsByVoucherType(voucherType)
        ), HttpStatus.OK);
    }

}
