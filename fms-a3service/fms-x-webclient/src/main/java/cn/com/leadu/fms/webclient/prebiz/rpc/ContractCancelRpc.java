package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.applycancel.ApplyCancelVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contractcancel.ContractCancelVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * Created by yanfengbo on 2018/3/28.
 * 融资申请取消rpc
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ContractCancelRpc {
    @RequestMapping(value = "api/prebiz/contract_cancel/findContractCancelsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContractCancelsByPage(@RequestParam Map<String, Object> contractCancelVoMap);


    /**
     * @Title:
     * @Description:  根据contNo获取融资合同取消
     * @param contNo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "api/prebiz/contract_cancel/findContractCancelVoByContNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContractCancelVoByContNo(@RequestParam("contNo") String contNo);


    /**
     * @Title:
     * @Description:  修改银行账号维护
     * @param contractCancelVo
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-3-26 13:51:12
     */
    @RequestMapping(value = "api/prebiz/contract_cancel/modifyContractCancel",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyContractCancel(@RequestBody ContractCancelVo contractCancelVo);
}
