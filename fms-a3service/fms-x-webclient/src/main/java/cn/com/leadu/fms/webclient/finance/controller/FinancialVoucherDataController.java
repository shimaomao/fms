package cn.com.leadu.fms.webclient.finance.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.finance.vo.financialvoucherdata.FinancialVoucherDataVo;
import cn.com.leadu.fms.webclient.finance.rpc.FinancialVoucherDataRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: FinancialVoucherDataController
 * @Description: 财务凭证数据controller
 * @date 2018-06-21
 */
@RestController
@RequestMapping("financial_voucher_data")
public class FinancialVoucherDataController {

    /**
     * @Fields  : 财务凭证数据rpc
     */
    @Autowired
    private FinancialVoucherDataRpc financialVoucherDataRpc;

    /**
     * @Title:
     * @Description: 分页查询财务凭证数据信息
     * @param financialVoucherDataVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018-6-21 15:34:09
     */
    @RequestMapping(value = "findFinVouDataVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinVouDataVosByPage(FinancialVoucherDataVo financialVoucherDataVo){
        Map financialVoucherDataVoMap = financialVoucherDataVo == null?null:(Map) JSON.toJSON(financialVoucherDataVo);
        return financialVoucherDataRpc.findFinVouDataVosByPage(financialVoucherDataVoMap);
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
        return financialVoucherDataRpc.findFinVouDataVoDetails(voucherNo);
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
        return financialVoucherDataRpc.findFinVouAssisVosByVouDataId(voucherDataId);
    }

}
