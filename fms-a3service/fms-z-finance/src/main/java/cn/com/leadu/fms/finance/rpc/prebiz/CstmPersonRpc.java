package cn.com.leadu.fms.finance.rpc.prebiz;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmPerson;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description: 个人客户信息rpc
 * @author:ningyangyang
 * @since:2018/5/14
 */
@FeignClient("${fms.feigns.serverNames.fmsPreBiz}")
public interface CstmPersonRpc {


    /**
     * @Title:
     * @Description:  根据applyNo获取客户个人基本信息
     * @param applyNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-14 11:27:21
     */
    @RequestMapping(value = "cstm_person/findCstmPersonByApplyNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse<CstmPerson>> findCstmPersonByApplyNo(@RequestParam("applyNo") String applyNo);
}
