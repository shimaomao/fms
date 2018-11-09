package cn.com.leadu.fms.webclient.cost.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.cost.vo.overdueexempt.OverdueExemptVo;
import cn.com.leadu.fms.pojo.postbiz.vo.overduecont.OverdueContVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author yanfengbo
 * @ClassName: OverdueContController
 * @Description: 逾期罚息信息rpc
 * @date 2018-05-16
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface OverdueExemptRpc {

    /**
     * @Title:
     * @Description: 分页查询罚息免除任务表信息
     * @param overdueExemptVoMap
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-30 19:08:30
     */
    @RequestMapping(value = "api/cost/overdue_exempt/findOverdueExemptsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findOverdueExemptsByPage(@RequestParam Map<String,Object> overdueExemptVoMap);

    /**
     * @Title:
     * @Description: 分页查询逾期罚息信息
     * @param contOverdueVoMap
     * @return
     * @throws
     * @author yanfengbo
     * @date 2018-5-16 14:32:22
     */
    @RequestMapping(value = "api/cost/overdue_exempt/findContOverdueVosByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContOverdueVosByPage(@RequestParam Map<String, Object> contOverdueVoMap);

    /**
     * @Title:
     * @Description:  根据contNo获取逾期罚息信息和合同信息(初次提交页面回显)
     * @param contNo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @RequestMapping(value = "api/cost/overdue_exempt/findDetailBycontNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findDetailBycontNo(@RequestParam("contNo") String contNo);

    /**
     * @Title:
     * @Description:  根据serviceId获取逾期合同信息
     * @param serviceId
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-16 14:32:22
     */
    @RequestMapping(value = "api/cost/overdue_exempt/findDetailByServiceId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findDetailByServiceId(@RequestParam("serviceId") String serviceId);

    /**
     * @Title:
     * @Description: 根据serviceId获取审批详情
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
   /* @RequestMapping(value = "api/cost/overdue_exempt/findDetailByServiceId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findDetailByServiceId(@RequestParam("serviceId") String serviceId);*/

    /**
     * @Title:
     * @Description: 罚息免除
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/cost/overdue_exempt/entryOverdueCont",method = RequestMethod.POST)
    ResponseEntity<RestResponse> entryOverdueCont(@RequestBody OverdueExemptVo overdueExemptVo);

    /**
     * @Title:
     * @Description: 罚息免除审核通过
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/cost/overdue_exempt/approval" ,method = RequestMethod.PUT)
    ResponseEntity<RestResponse> approval(@RequestBody OverdueExemptVo overdueExemptVo);

    /**
     * @Title:
     * @Description: 罚息免除审核退回
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/cost/overdue_exempt/sendBack" ,method = RequestMethod.PUT)
    ResponseEntity<RestResponse> sendBack(@RequestBody OverdueExemptVo overdueExemptVo);
}
