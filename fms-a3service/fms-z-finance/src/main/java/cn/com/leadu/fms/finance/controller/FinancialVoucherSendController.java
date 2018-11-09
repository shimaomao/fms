package cn.com.leadu.fms.finance.controller;

import cn.com.leadu.fms.extend.common.annotation.AuthUserInfo;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.finance.service.FinancialVoucherSendService;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherSendController
 * @Description: 财务凭证发送
 * @date 2018/7/24
 */
@RestController
@RequestMapping("financial_voucher_send")
public class FinancialVoucherSendController {

    /**
     * @Fields  : 财务凭证发送service
     * @author qiaomengnan
     */
    @Autowired
    private FinancialVoucherSendService financialVoucherSendService;

    /**
     * @Title:
     * @Description:  发送财务凭证数据
     * @param voucherSummaryIds 凭证管理id集合
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/07/23 04:21:03
     */
    @RequestMapping(value = "sendFinancialVoucher" ,method = RequestMethod.POST)
    public ResponseEntity<RestResponse> sendFinancialVoucher(@RequestBody List<String> voucherSummaryIds, @AuthUserInfo SysUser sysUser){

        return new ResponseEntity<RestResponse>(
                RestResponseGenerator.genSuccessResponse(financialVoucherSendService.sendFinancialVoucher(voucherSummaryIds,sysUser)),
                HttpStatus.OK);
    }

}

