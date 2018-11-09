package cn.com.leadu.fms.finance.rpc.baseinfo;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasBankInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author yangyiquan
 * @ClassName: BasBankInfoRpc
 * @Description: 银行信息维护rpc
 * @date 2018-08-10
 */
@FeignClient("${fms.feigns.serverNames.fmsBaseInfo}")
public interface BasBankInfoRpc {

    /**
     * @Description: 根据银行账号获取财务科目代码
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/8/1 11:40
     */
    @RequestMapping(value = "bas_bank_info/findFinassSubjectCd", method = RequestMethod.GET)
    ResponseEntity<RestResponse<String>> findFinassSubjectCd(@RequestParam("accountNo") String accountNo);
}
