package cn.com.leadu.fms.webclient.finance.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.finance.vo.financialvoucherdetail.FinancialVoucherDetailVo;
import cn.com.leadu.fms.webclient.finance.rpc.FinancialVoucherDetailRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;
import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: FinancialVoucherDetailController
 * @Description: 凭证类型明细管理controller
 * @date 2018-06-20
 */
@RestController
@RequestMapping("financial_voucher_detail")
public class FinancialVoucherDetailController {

    /**
     * @Fields  : 凭证类型明细管理rpc
     */
    @Autowired
    private FinancialVoucherDetailRpc financialVoucherDetailRpc;

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
        Map financialVoucherDetailVoMap = financialVoucherDetailVo == null?null:(Map) JSON.toJSON(financialVoucherDetailVo);
        return financialVoucherDetailRpc.findFinancialVoucherDetailsByPage(financialVoucherDetailVoMap);
    }

    /**
     * @Title:
     * @Description: 保存凭证类型明细管理
     * @param financialVoucherDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @RequestMapping(value = "saveFinancialVoucherDetail",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveFinancialVoucherDetail(@RequestBody FinancialVoucherDetailVo financialVoucherDetailVo){
        return financialVoucherDetailRpc.saveFinancialVoucherDetail(financialVoucherDetailVo);
    }

    /**
     * @Title:
     * @Description:  修改凭证类型明细管理
     * @param financialVoucherDetailVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @RequestMapping(value = "modifyFinancialVoucherDetail",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyFinancialVoucherDetail(@RequestBody FinancialVoucherDetailVo financialVoucherDetailVo){
        return financialVoucherDetailRpc.modifyFinancialVoucherDetail(financialVoucherDetailVo);
    }

    /**
     * @Title:
     * @Description:   根据voucherDetailId集合删除凭证类型明细管理
     * @param voucherDetailIds
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:39:31
     */
    @RequestMapping(value = "deleteFinancialVoucherDetailsByVoucherDetailIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteFinancialVoucherDetailsByVoucherDetailIds(@RequestBody List<String> voucherDetailIds){
        FinancialVoucherDetailVo financialVoucherDetailVo = new FinancialVoucherDetailVo();
        financialVoucherDetailVo.setVoucherDetailIds(voucherDetailIds);
        return financialVoucherDetailRpc.deleteFinancialVoucherDetailsByVoucherDetailIds(financialVoucherDetailVo);
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
        return financialVoucherDetailRpc.findFinancialVoucherDetailByVoucherDetailId(voucherDetailId);
    }

}
