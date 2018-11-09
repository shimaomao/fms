package cn.com.leadu.fms.webclient.prebiz.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.contractfinance.ContractFinanceVo;
import feign.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author huchenghao
 * @ClassName: ContractFinanceController
 * @Description: 合同信息rpc
 * @date 2018-04-11
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ContractFinanceRpc {

    /**
     * @Title:
     * @Description: 分页查询合同信息信息
     * @param contractFinanceVoMap
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-11 11:43:20
     */
    @RequestMapping(value = "api/prebiz/contract_finance/findContractFinancesByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContractFinancesByPage(@RequestParam Map<String, Object> contractFinanceVoMap);

    /**
     * @Title:
     * @Description: 保存合同信息
     * @param contractFinanceVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-11 11:43:20
     */
    @RequestMapping(value = "api/prebiz/contract_finance/saveContractFinance",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveContractFinance(@RequestBody ContractFinanceVo contractFinanceVo);

    /**
     * @Title:
     * @Description:  修改合同信息
     * @param sysOrganizationPropertyVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-11 11:43:20
     */
    @RequestMapping(value = "api/prebiz/contract_finance/modifyContractFinance",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyContractFinance(@RequestBody ContractFinanceVo contractFinanceVo);

    /**
     * @Title:
     * @Description:   根据contFinId集合删除合同信息
     * @param contFinIds
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-11 11:43:20
     */
    @RequestMapping(value = "api/system/contract_finance/deleteContractFinancesByContFinIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteContractFinancesByContFinIds(@RequestBody ContractFinanceVo contractFinanceVo);

    /**
     * @Title:
     * @Description:  根据contFinId获取合同信息
     * @param contFinId
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-11 11:43:20
     */
    @RequestMapping(value = "api/prebiz/contract_finance/findContractFinanceByContFinId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContractFinanceByContFinId(@RequestParam("contFinId") String contFinId);

    /**
     * @Title:
     * @Description:  有模板出excel测试
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-11 11:43:20
     */
    @RequestMapping(value = "api/prebiz/contract_finance/testExport", method = RequestMethod.GET)
    Response testExport();

}
