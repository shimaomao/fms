package cn.com.leadu.fms.postbiz.rpc.prebiz;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.extend.response.RestResponseGenerator;
import cn.com.leadu.fms.pojo.prebiz.entity.CstmCompany;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @description:  企业客户信息rpc
 * @author:ningyangyang
 * @since:2018/5/14
 */
@FeignClient("${fms.feigns.serverNames.fmsPreBiz}")
public interface CstmCompanyRpc {
    /**
     * @Title:
     * @Description:  根据applyNo获取客户企业基本信息
     * @param applyNo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-14 11:11:47
     */
    @RequestMapping(value = "findCstmCompanyByApplyNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse<CstmCompany>> findCstmCompanyByApplyNo(@RequestParam("applyNo") String applyNo);
}
