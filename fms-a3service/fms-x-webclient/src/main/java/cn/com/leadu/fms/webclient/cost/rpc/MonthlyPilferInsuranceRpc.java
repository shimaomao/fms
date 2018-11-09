package cn.com.leadu.fms.webclient.cost.rpc;

import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.cost.vo.monthlypilferinsurance.MonthlyPilferInsuranceVo;
import cn.com.leadu.fms.pojo.cost.vo.monthlypilferinsurance.PilferInsuranceApproveVo;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author yangyiquan
 * @ClassName: MonthlyPilferInsuranceController
 * @Description: 盗抢险月结任务信息rpc
 * @date 2018-05-31
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface MonthlyPilferInsuranceRpc {

    /**
     * @Title:
     * @Description: 分页查询盗抢险月结任务信息信息
     * @param monthlyPilferInsuranceVoMap
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @RequestMapping(value = "api/cost/monthly_pilfer_insurance/findMonthlyPilferInsurancesByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findMonthlyPilferInsurancesByPage(@RequestParam Map<String,Object> monthlyPilferInsuranceVoMap);

    /**
     * @Title:
     * @Description: 保存盗抢险月结任务信息
     * @param monthlyPilferInsuranceVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @RequestMapping(value = "api/cost/monthly_pilfer_insurance/saveMonthlyPilferInsurance",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveMonthlyPilferInsurance(@RequestBody MonthlyPilferInsuranceVo monthlyPilferInsuranceVo);

    /** 
    * @Description: 保存盗抢险月结任务信息，包括盗抢险信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/31 21:04
    */ 
    @RequestMapping(value = "api/cost/monthly_pilfer_insurance/saveMonthlyPilferInsuranceWithPI",method = RequestMethod.POST)
    ResponseEntity<RestResponse> saveMonthlyPilferInsuranceWithPI(@RequestBody MonthlyPilferInsuranceVo monthlyPilferInsuranceVo);

    /**
     * @Title:
     * @Description:  修改盗抢险月结任务信息
     * @param monthlyPilferInsuranceVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @RequestMapping(value = "api/cost/monthly_pilfer_insurance/modifyMonthlyPilferInsurance",method = RequestMethod.PUT)
    ResponseEntity<RestResponse> modifyMonthlyPilferInsurance(@RequestBody MonthlyPilferInsuranceVo monthlyPilferInsuranceVo);

    /**
     * @Title:
     * @Description:   根据monthlyPilferInsuranceId集合删除盗抢险月结任务信息
     * @param monthlyPilferInsuranceVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @RequestMapping(value = "api/cost/monthly_pilfer_insurance/deleteMonthlyPilferInsurancesByMonthlyPilferInsuranceIds" , method = RequestMethod.DELETE)
    ResponseEntity<RestResponse> deleteMonthlyPilferInsurancesByMonthlyPilferInsuranceIds(@RequestBody MonthlyPilferInsuranceVo monthlyPilferInsuranceVo);

    /**
     * @Title:
     * @Description:  根据monthlyPilferInsuranceId获取盗抢险月结任务信息
     * @param monthlyPilferInsuranceId
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-5-31 15:47:58
     */
    @RequestMapping(value = "api/cost/monthly_pilfer_insurance/findMonthlyPilferInsuranceByMonthlyPilferInsuranceId", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findMonthlyPilferInsuranceByMonthlyPilferInsuranceId(@RequestParam("monthlyPilferInsuranceId") String monthlyPilferInsuranceId);

    /** 
    * @Description: 根据monthlyPilferInsuranceNo获取盗抢险月结任务信息 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/1 11:43
    */ 
    @RequestMapping(value = "api/cost/monthly_pilfer_insurance/findMonthlyPilferInsuranceByPilferInsuranceNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findMonthlyPilferInsuranceByPilferInsuranceNo(@RequestParam("monthlyPilferInsuranceNo") String monthlyPilferInsuranceNo);

    /**
     * @Title:
     * @Description: 根据monthlyPilferInsuranceNo获取盗抢险月结任务信息(含附件)
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @RequestMapping(value = "api/cost/monthly_pilfer_insurance/findMonthlyPilferInsuranceVoByPilferInsuranceNo", method = RequestMethod.GET)
    ResponseEntity<RestResponse> findMonthlyPilferInsuranceVoByPilferInsuranceNo(@RequestParam("monthlyPilferInsuranceNo") String monthlyPilferInsuranceNo);

    /** 
    * @Description: 月结审批操作
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/1 11:52
    */ 
    @RequestMapping(value = "api/cost/monthly_pilfer_insurance/approval",method = RequestMethod.POST)
    ResponseEntity<RestResponse> approval(@RequestBody PilferInsuranceApproveVo pilferInsuranceApproveVo);
}
