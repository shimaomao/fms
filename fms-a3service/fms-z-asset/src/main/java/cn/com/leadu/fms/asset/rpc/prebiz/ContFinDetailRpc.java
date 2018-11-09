package cn.com.leadu.fms.asset.rpc.prebiz;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.vo.contfindetail.ContFinDetailVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: ContractRpc
 * @Description: 合同rpc
 * @date 2018/5/31
 */
@FeignClient("${fms.feigns.serverNames.fmsPreBiz}")
public interface ContFinDetailRpc {

    /**
     * @Title:
     * @Description:   根据合同号 查询合同明细
     * @param contNo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/01 10:20:05
     */
    @RequestMapping(value = "cont_fin_detail/findContFinDetailVosByContNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse<List<ContFinDetailVo>>> findContFinDetailVosByContNo(@RequestParam("contNo") String contNo);

}
