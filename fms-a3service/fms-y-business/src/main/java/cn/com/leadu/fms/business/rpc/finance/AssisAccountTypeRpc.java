package cn.com.leadu.fms.business.rpc.finance;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.finance.entity.AssisAccountType;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: AssisAccountTypeRpc
 * @Description:
 * @date 2018/6/26
 */
@FeignClient(name = "${fms.feigns.serverNames.fmsFinance}")
public interface AssisAccountTypeRpc {

    /**
     * @Title:
     * @Description:   根据types集合获取辅助核算类型管理
     * @param assisAccountTypes
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/26 10:49:32
     */
    @RequestMapping(value = "assis_account_type/findAssisAccountTypesByAccTypes", method = RequestMethod.GET)
    ResponseEntity<RestResponse<List<AssisAccountType>>> findAssisAccountTypesByAccTypes(@RequestParam("assisAccountTypes") List<String> assisAccountTypes);

}
