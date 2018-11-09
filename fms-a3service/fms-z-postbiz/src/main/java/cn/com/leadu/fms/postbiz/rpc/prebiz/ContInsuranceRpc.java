package cn.com.leadu.fms.postbiz.rpc.prebiz;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.entity.ContInsurance;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;
import java.util.Map;

/**
 * @description:  车辆保险信息rpc
 * @author:ningyangyang
 * @since:2018/5/14
 */
@FeignClient("${fms.feigns.serverNames.fmsPreBiz}")
public interface ContInsuranceRpc {
    /**
     * @Title:
     * @Description: 查询车辆保险信息
     * @param
     * @return
     * @throws
     * @author liujinge
     * @date 2018-3-26 10:14:21
     */
    @RequestMapping(value = "cont_insurance/findContInsurance" ,method = RequestMethod.GET)
      ResponseEntity<RestResponse<List<ContInsurance>>> findContInsurance(@RequestParam Map<String, Object> contInsuranceMap);

    /**
     * @Title:
     * @Description: 通过contVehinsId查询合同车辆保险信息
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "cont_insurance/findContInsuranceByPrimaryKey", method = RequestMethod.GET)
    ResponseEntity<RestResponse<ContInsurance>> findContInsuranceByPrimaryKey(@RequestParam("contVehinsId") String contVehinsId);
}
