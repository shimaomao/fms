package cn.com.leadu.fms.business.rpc.finance;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.finance.entity.SubjectAssisAccount;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SubjectAssisAccountRpc
 * @Description:
 * @date 2018/6/26
 */
@FeignClient(name = "${fms.feigns.serverNames.fmsFinance}")
public interface SubjectAssisAccountRpc {

    /**
     * @Title:
     * @Description:   根据科目代码查询科目核算管理
     * @param subjectCds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/06/25 08:21:23
     */
    @RequestMapping(value = "subject_assis_account/findSubjectAssisAccountsBySubjectCd" , method = RequestMethod.GET)
    ResponseEntity<RestResponse<List<SubjectAssisAccount>>> findSubjectAssisAccountsBySubjectCds(@RequestParam("subjectCds") List<String> subjectCds);

}
