package cn.com.leadu.fms.webclient.finance.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.finance.vo.contoverdue.ContOverdueVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author lijunjun
 * @ClassName: ContOverdueController
 * @Description: 还款逾期罚息rpc
 * @date 2018-05-08
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ContOverdueRpc {

    /**
     * @Title:
     * @Description: 分页查询还款逾期罚息信息
     * @param contOverdueVoMap
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @RequestMapping(value = "api/finance/cont_overdue/findContOverduesByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContOverduesByPage(@RequestParam Map<String, Object> contOverdueVoMap);

    /**
     * @Title:
     * @Description: 保存还款逾期罚息
     * @param contOverdueVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @RequestMapping(value = "api/finance/cont_overdue/saveContOverdue",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveContOverdue(@RequestBody ContOverdueVo contOverdueVo);

    /**
     * @Title:
     * @Description:  修改还款逾期罚息
     * @param contOverdueVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @RequestMapping(value = "api/finance/cont_overdue/modifyContOverdue",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyContOverdue(@RequestBody ContOverdueVo contOverdueVo);

    /**
     * @Title:
     * @Description:   根据contOverdueId集合删除还款逾期罚息
     * @param contOverdueVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @RequestMapping(value = "api/system/cont_overdue/deleteContOverduesByContOverdueIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteContOverduesByContOverdueIds(@RequestBody ContOverdueVo contOverdueVo);

    /**
     * @Title:
     * @Description:  根据contOverdueId获取还款逾期罚息
     * @param contOverdueId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-8 14:55:31
     */
    @RequestMapping(value = "api/finance/cont_overdue/findContOverdueByContOverdueId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContOverdueByContOverdueId(@RequestParam("contOverdueId") String contOverdueId);

}
