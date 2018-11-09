package cn.com.leadu.fms.finance.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.finance.service.FinancialVoucherDataService;
import cn.com.leadu.fms.pojo.finance.vo.financialvoucherdata.FinancialVoucherDataVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherDataController
 * @Description: 财务凭证数据相关接口
 * @date 2018-06-21
 */
@RestController
@RequestMapping("financial_voucher_data")
public class FinancialVoucherDataController {

    /**
     * @Fields  : 财务凭证数据service
     */
    @Autowired
    private FinancialVoucherDataService financialVoucherDataService;

    /**
     * @Title:
     * @Description: 分页查询财务凭证数据信息
     * @param finVouDataVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-6-21 15:34:09
     */
    @RequestMapping(value = "findFinVouDataVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinVouDataVosByPage(FinancialVoucherDataVo finVouDataVo){
        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(financialVoucherDataService.findFinVouDataVosByPage(finVouDataVo)),
                HttpStatus.OK);
    }


    /**
     * @Title:
     * @Description: 根据凭证号查询对应的凭证数据
     * @param:  voucherNo 凭证号
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/7/16 0016 19:37
     */
    @RequestMapping(value = "findFinVouDataVoDetails", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinVouDataVoDetails(String voucherNo){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(financialVoucherDataService.findFinVouDataVoDetails(voucherNo)), HttpStatus.OK);
    }

    /**
     * @Title:
     * @Description:   根据财务凭证id获取财务凭证核算数据
     * @param voucherDataId 财务凭证id
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/11 03:01:10
     */
    @RequestMapping(value = "findFinVouAssisVosByVouDataId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinVouAssisVosByVouDataId(String voucherDataId){
        return new ResponseEntity<RestResponse>(RestResponseGenerator.genSuccessResponse(financialVoucherDataService.findFinVouAssisVosByVouDataId(voucherDataId)), HttpStatus.OK);
    }

}
