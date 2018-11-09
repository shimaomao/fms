package cn.com.leadu.fms.cost.rpc.postbiz;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecont.OverdueContVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

/**
 * @author yanfengbo
 * @ClassName:
 * @Description: 逾期合同
 * @date
 */
@FeignClient("${fms.feigns.serverNames.fmsPostBiz}")
public interface OverdueContRpc {
    /**
     * @param contNo
     * @return
     * @throws
     * @Title:
     * @Description: 通过contNo取得逾期合同信息
     * @author yanfengbo
     * @date 2018-5-16 14:32:22
     */
    @RequestMapping(value = "overdue_cont/findOverdueContByContNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse<OverdueContVo>> findOverdueContByContNo(@RequestParam("contNo") String contNo);
}
