package cn.com.leadu.fms.webclient.cost.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.cost.vo.monthlysettlement.MonthlySettlementVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author yangyiquan
 * @ClassName: MonthlySettlementController
 * @Description: gps月结任务表rpc
 * @date 2018-05-28
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface MonthlySettlementRpc {

    /**
     * @Title:
     * @Description: 分页查询gps月结任务表信息
     * @param monthlySettlementVoMap
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @RequestMapping(value = "api/cost/monthly_settlement/findMonthlySettlementsByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findMonthlySettlementsByPage(@RequestParam Map<String,Object> monthlySettlementVoMap);

    /**
     * @Title:
     * @Description: 保存gps月结任务表
     * @param monthlySettlementVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @RequestMapping(value = "api/cost/monthly_settlement/saveMonthlySettlement",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveMonthlySettlement(@RequestBody MonthlySettlementVo monthlySettlementVo);

    /** 
    * @Description: 保存月结申请
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/29 10:37
    */ 
    @RequestMapping(value = "api/cost/monthly_settlement/saveMonthlySettlementWithGps",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveMonthlySettlementWithGps(@RequestBody MonthlySettlementVo monthlySettlementVo);

    /**
     * @Title:
     * @Description:  修改gps月结任务表
     * @param monthlySettlementVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @RequestMapping(value = "api/cost/monthly_settlement/modifyMonthlySettlement",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyMonthlySettlement(@RequestBody MonthlySettlementVo monthlySettlementVo);

    /**
     * @Title:
     * @Description:   根据monthlySettlementId集合删除gps月结任务表
     * @param monthlySettlementVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @RequestMapping(value = "api/cost/monthly_settlement/deleteMonthlySettlementsByMonthlySettlementIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteMonthlySettlementsByMonthlySettlementIds(@RequestBody MonthlySettlementVo monthlySettlementVo);

    /**
     * @Title:
     * @Description:  根据monthlySettlementId获取gps月结任务表
     * @param monthlySettlementId
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-28 14:25:41
     */
    @RequestMapping(value = "api/cost/monthly_settlement/findMonthlySettlementByMonthlySettlementId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findMonthlySettlementByMonthlySettlementId(@RequestParam("monthlySettlementId") String monthlySettlementId);

    /** 
    * @Description:  根据monthlySettlementNo获取gps月结任务表
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/30 17:37
    */ 
    @RequestMapping(value = "api/cost/monthly_settlement/findMonthlySettlementBySettlementNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findMonthlySettlementBySettlementNo(@RequestParam("monthlySettlementNo") String monthlySettlementNo);

    /**
     * @Title:
     * @Description: 根据monthlySettlementNo获取gps月结任务表(含附件)
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/cost/monthly_settlement/findMonthlySettlementVoBySettlementNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findMonthlySettlementVoBySettlementNo(@RequestParam("monthlySettlementNo") String monthlySettlementNo);
}
