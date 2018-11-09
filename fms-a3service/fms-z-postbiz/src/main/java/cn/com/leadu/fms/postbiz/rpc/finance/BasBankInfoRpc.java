package cn.com.leadu.fms.postbiz.rpc.finance;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasBankInfo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

/**
 * @author wangxue
 * @ClassName: BasPartnerRpc
 * @Description: 经销商信息维护rpc
 * @date 2018-03-17
 */
@FeignClient("${fms.feigns.serverNames.fmsBaseInfo}")
public interface BasBankInfoRpc {

    /**
     * @Title:
     * @Description:根据当前日期取得还款日
     * @return
     * @throws
     * @author liujinge
     * @date 2018-4-12 13:35:32
     */
    @RequestMapping(value = "bas_bank_info/findBasBankInfoByOrg", method = RequestMethod.GET)
    ResponseEntity<RestResponse<BasBankInfo>> findBasBankInfoByOrg(@RequestParam("organizationType") String organizationType, @RequestParam("organizationId") String organizationId);

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
