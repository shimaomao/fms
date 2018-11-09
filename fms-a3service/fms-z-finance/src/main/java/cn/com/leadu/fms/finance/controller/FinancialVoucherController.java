package cn.com.leadu.fms.finance.controller;

import cn.com.leadu.fms.extend.response.ResponseEnums;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.finance.vo.financialvoucher.FinancialVoucherVo;
import cn.com.leadu.fms.finance.service.FinancialVoucherService;
import cn.com.leadu.fms.finance.validator.financialvoucher.vo.*;
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
 * @ClassName: FinancialVoucherController
 * @Description: 凭证类型管理相关接口
 * @date 2018-06-20
 */
@RestController
@RequestMapping("financial_voucher")
public class FinancialVoucherController {

    /**
     * @Fields  : 凭证类型管理service
     */
    @Autowired
    private FinancialVoucherService financialVoucherService;

    /**
     * @Title:
     * @Description: 分页查询凭证类型管理信息
     * @param financialVoucherVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @RequestMapping(value = "findFinancialVouchersByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinancialVouchersByPage(FinancialVoucherVo financialVoucherVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(financialVoucherService.findFinancialVouchersByPage(financialVoucherVo)),
                HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description: 保存凭证类型管理
     * @param financialVoucherSaveVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @RequestMapping(value = "saveFinancialVoucher",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveFinancialVoucher(@Valid @RequestBody FinancialVoucherSaveVo financialVoucherSaveVo){
        financialVoucherService.saveFinancialVoucher(financialVoucherSaveVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  修改凭证类型管理
     * @param financialVoucherModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @RequestMapping(value = "modifyFinancialVoucher",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyFinancialVoucher(@Valid @RequestBody FinancialVoucherModifyVo financialVoucherModifyVo){
        financialVoucherService.modifyFinancialVoucher(financialVoucherModifyVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  删除凭证类型管理
     * @param financialVoucherDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @RequestMapping(value = "deleteFinancialVoucher",method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteFinancialVoucher(@Valid @RequestBody FinancialVoucherDeleteVo financialVoucherDeleteVo){
        financialVoucherService.deleteFinancialVoucher(financialVoucherDeleteVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据voucherId集合删除凭证类型管理
     * @param financialVoucherVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @RequestMapping(value = "deleteFinancialVouchersByVoucherIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteFinancialVouchersByVoucherIds(@Valid @RequestBody FinancialVoucherVo financialVoucherVo){
        financialVoucherService.deleteFinancialVouchersByVoucherIds(financialVoucherVo);
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(ResponseEnums.SUCCESS.getMark()), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:  根据voucherId获取凭证类型管理
     * @param voucherId
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @RequestMapping(value = "findFinancialVoucherByVoucherId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinancialVoucherByVoucherId(String voucherId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(financialVoucherService.findFinancialVoucherByVoucherId(voucherId)), HttpStatus.OK);
    }


    /**
     * @Title:
     * @Description: 查询凭证信息树形结构
     * @param
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @RequestMapping(value = "findFinancialVouchersByTree" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinancialVouchersByTree(){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(financialVoucherService.findFinancialVouchersByTree()),
                HttpStatus.OK);
    }

}
