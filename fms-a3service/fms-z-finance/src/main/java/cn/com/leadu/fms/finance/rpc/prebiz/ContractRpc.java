package cn.com.leadu.fms.finance.rpc.prebiz;

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.entity.Contract;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContractListVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContractVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @description:  合同信息rpc
 * @author:ningyangyang
 * @since:2018/5/11
 */
@FeignClient("${fms.feigns.serverNames.fmsPreBiz}")
public interface ContractRpc {

    /**
     * @Description:  分页查询合同一览信息
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018-05-11 11:43
     */
    @RequestMapping(value = "contract/findContractListByPage",method = RequestMethod.GET)
    ResponseEntity<RestResponse<PageInfoExtend<ContractListVo>>> findContractListByPage(@RequestParam Map<String, Object> contractListVoMap);

    /**
     * @Description: 根据状态查找合同
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/14 11:31
     */
    @RequestMapping(value="contract/findContractsByContractStatus",method = RequestMethod.GET)
    ResponseEntity<RestResponse<List<Contract>>> findContractsByContractStatus(@RequestParam Map<String, Object> contractMap);

    /**
     * @Description: 根据合同号查找合同
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/22 11:31
     */
    @RequestMapping(value="contract/findContractByContractNo",method = RequestMethod.GET)
    ResponseEntity<RestResponse<Contract>> findContractByContractNo(@RequestParam("contNo") String contNo);


    /**
    * @Description: 获取财务核算代码
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/8/10 16:17
    */
    @RequestMapping(value="contract/findContractVoFinassCodes",method = RequestMethod.GET)
    ResponseEntity<RestResponse<ContractVo>> findContractVoFinassCodes(@RequestParam("applyNo") String applyNo, @RequestParam("contNo") String contNo);

}
