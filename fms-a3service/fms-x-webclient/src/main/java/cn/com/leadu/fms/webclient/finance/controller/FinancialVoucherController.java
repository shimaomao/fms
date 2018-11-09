package cn.com.leadu.fms.webclient.finance.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.finance.vo.financialvoucher.FinancialVoucherVo;
import cn.com.leadu.fms.webclient.finance.rpc.FinancialVoucherRpc;
import com.alibaba.fastjson.JSON;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * @author ningyangyang
 * @ClassName: FinancialVoucherController
 * @Description: 凭证类型管理controller
 * @date 2018-06-20
 */
@RestController
@RequestMapping("financial_voucher")
public class FinancialVoucherController {

    /**
     * @Fields  : 凭证类型管理rpc
     */
    @Autowired
    private FinancialVoucherRpc financialVoucherRpc;

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
        Map financialVoucherVoMap = financialVoucherVo == null?null:(Map) JSON.toJSON(financialVoucherVo);
        return financialVoucherRpc.findFinancialVouchersByPage(financialVoucherVoMap);
    }

    /**
     * @Title:
     * @Description: 保存凭证类型管理
     * @param financialVoucherVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @RequestMapping(value = "saveFinancialVoucher",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveFinancialVoucher(@RequestBody FinancialVoucherVo financialVoucherVo){
        return financialVoucherRpc.saveFinancialVoucher(financialVoucherVo);
    }

    /**
     * @Title:
     * @Description:  修改凭证类型管理
     * @param financialVoucherVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @RequestMapping(value = "modifyFinancialVoucher",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyFinancialVoucher(@RequestBody FinancialVoucherVo financialVoucherVo){
        return financialVoucherRpc.modifyFinancialVoucher(financialVoucherVo);
    }

    /**
     * @Title:
     * @Description:   根据voucherId集合删除凭证类型管理
     * @param voucherType
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @RequestMapping(value = "deleteFinancialVouchersByVoucherIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteFinancialVouchersByVoucherIds(@RequestParam("voucherType") String voucherType){
        FinancialVoucherVo financialVoucherVo = new FinancialVoucherVo();
        financialVoucherVo.setVoucherType(voucherType);
        return financialVoucherRpc.deleteFinancialVouchersByVoucherIds(financialVoucherVo);
    }

    /**
     * @Title:
     * @Description:  根据voucherId获取凭证类型管理
     * @param voucherType
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-6-20 10:21:55
     */
    @RequestMapping(value = "findFinancialVoucherByVoucherId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinancialVoucherByVoucherId(@RequestParam("voucherType") String voucherType){
        return financialVoucherRpc.findFinancialVoucherByVoucherId(voucherType);
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
        return financialVoucherRpc.findFinancialVouchersByTree();
    }
}
