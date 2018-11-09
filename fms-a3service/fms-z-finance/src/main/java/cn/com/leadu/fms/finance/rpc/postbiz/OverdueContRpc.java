package cn.com.leadu.fms.finance.rpc.postbiz;/**
 * Created by ningyangyang on 2018/5/22.
 */

import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.entity.OverdueCont;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @Title: fms
 * @Description: 逾期合同rpc
 * @author: ningyangyang
 * @date 2018/5/22 17:10
 */
@FeignClient("${fms.feigns.serverNames.fmsPostBiz}")
public interface OverdueContRpc {

    @RequestMapping(value = "overdue_cont/findOverdueContsByPage", method = RequestMethod.GET)
    ResponseEntity<RestResponse<PageInfoExtend<OverdueCont>>> findOverdueContsByPage(@RequestParam Map<String, Object> overdueContMap);
}
