package cn.com.leadu.fms.webclient.finance.controller;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.contpay.ContPayVo;
import cn.com.leadu.fms.webclient.finance.rpc.FinancialPrebizContPayDetailRpc;
import com.alibaba.fastjson.JSON;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

/**
 * @author yebangqiang
 * @ClassName: FinancialPrebizContPayDetailController
 * @Description: 贷前财务付款清单明细controller
 * @date 2018-07-19
 */
@RestController
@RequestMapping("prebiz_cont_pay_detail")
public class FinancialPrebizContPayDetailController {

    /**
     * @Fields  : 贷前财务付款清单明细service
     */
    @Autowired
    private FinancialPrebizContPayDetailRpc financialPrebizContPayDetailRpc;

    /**
     * @Title:
     * @Description: 分页贷前财务付款清单明细信息
     * @param contPayVo
     * @return
     * @throws
     * @author yebangqiang
     * @date
     */
    @RequestMapping(value = "findFinancialPrebizContPayDetailByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findFinancialPrebizContPayDetailByPage(ContPayVo contPayVo){
        Map contPayVoMap = contPayVo == null?null:(Map) JSON.toJSON(contPayVo);
        return financialPrebizContPayDetailRpc.findFinancialPrebizContPayDetailByPage(contPayVoMap);
    }

    /**
     * @Title:
     * @Description: 分页贷前财务付款清单明细信息
     * @param contPayVo
     * @return
     * @throws
     * @author yebangqiang
     * @date
     */
    @RequestMapping(value = "findContPayInfoByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContPayInfoByPage(ContPayVo contPayVo){
        Map contPayVoMap = contPayVo == null?null:(Map) JSON.toJSON(contPayVo);
        return financialPrebizContPayDetailRpc.findContPayInfoByPage(contPayVoMap);
    }


}
