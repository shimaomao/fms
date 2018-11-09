package cn.com.leadu.fms.webclient.prebiz.controller;

import cn.com.leadu.fms.common.util.CommonFeignUtils;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.contractfinance.ContractFinanceVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.ContractFinanceRpc;
import com.alibaba.fastjson.JSON;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.List;
import java.util.Map;

/**
 * @author huchenghao
 * @ClassName: ContractFinanceController
 * @Description: 合同信息controller
 * @date 2018-04-11
 */
@RestController
@RequestMapping("contract_finance")
public class ContractFinanceController {

    /**
     * @Fields  : 合同信息rpc
     */
    @Autowired
    private ContractFinanceRpc contractFinanceRpc;

    /**
     * @Title:
     * @Description: 分页查询合同信息信息
     * @param contractFinanceVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-11 11:43:20
     */
    @RequestMapping(value = "findContractFinancesByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContractFinancesByPage(ContractFinanceVo contractFinanceVo){
        Map contractFinanceVoMap = contractFinanceVo == null?null:(Map) JSON.toJSON(contractFinanceVo);
        return contractFinanceRpc.findContractFinancesByPage(contractFinanceVoMap);
    }

    /**
     * @Title:
     * @Description: 保存合同信息
     * @param contractFinanceVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-11 11:43:20
     */
    @RequestMapping(value = "saveContractFinance",method = RequestMethod.POST)
    public ResponseEntity<RestResponse> saveContractFinance(@RequestBody ContractFinanceVo contractFinanceVo){
        return contractFinanceRpc.saveContractFinance(contractFinanceVo);
    }

    /**
     * @Title:
     * @Description:  修改合同信息
     * @param contractFinanceVo
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-11 11:43:20
     */
    @RequestMapping(value = "modifyContractFinance",method = RequestMethod.PUT)
    public ResponseEntity<RestResponse> modifyContractFinance(@RequestBody ContractFinanceVo contractFinanceVo){
        return contractFinanceRpc.modifyContractFinance(contractFinanceVo);
    }

    /**
     * @Title:
     * @Description:   根据contFinId集合删除合同信息
     * @param contFinIds
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-11 11:43:20
     */
    @RequestMapping(value = "deleteContractFinancesByContFinIds" , method = RequestMethod.DELETE)
    public ResponseEntity<RestResponse> deleteContractFinancesByContFinIds(@RequestBody List<String> contFinIds){
        ContractFinanceVo contractFinanceVo = new ContractFinanceVo();
        contractFinanceVo.setContFinIds(contFinIds);
        return contractFinanceRpc.deleteContractFinancesByContFinIds(contractFinanceVo);
    }

    /**
     * @Title:
     * @Description:  根据contFinId获取合同信息
     * @param contFinId
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-11 11:43:20
     */
    @RequestMapping(value = "findContractFinanceByContFinId", method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findContractFinanceByContFinId(String contFinId){
        return contractFinanceRpc.findContractFinanceByContFinId(contFinId);
    }

    /**
     * @Title:
     * @Description: 有模板出excel测试
     * @param:  params 参数集合
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/19 14:59
     */
    @RequestMapping(value = "testExport" , method = RequestMethod.GET)
    public ResponseEntity testExport() throws IOException {
        Response response = contractFinanceRpc.testExport();
        return CommonFeignUtils.getResponseEntity(response, MediaType.APPLICATION_OCTET_STREAM);
    }

}
