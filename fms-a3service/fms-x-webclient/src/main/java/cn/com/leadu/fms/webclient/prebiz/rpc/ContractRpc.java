package cn.com.leadu.fms.webclient.prebiz.rpc;/**
 * Created by yyq on 2018/4/28.
 */

import cn.com.leadu.fms.extend.response.RestResponse;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import feign.Response;

import java.util.Map;

/**
 * @program: fms
 * @description: 合同一览分页信息rpc
 * @author: yangyiquan
 * @create: 2018-04-28 11:43
 **/
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ContractRpc {

    /** 
    * @Description:  分页查询合同一览信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018-04-28 11:43
    */ 
    @RequestMapping(value = "api/prebiz/contract/findContractListByPage",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContractListByPage(@RequestParam Map<String, Object> contractListVoMap);

    /**
     * @Description:  当月新增放款车辆明细查询合同一览信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018-04-28 11:43
     */
    @RequestMapping(value = "api/prebiz/contract/findNewLoanByPage",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findNewLoanByPage(@RequestParam Map<String, Object> contractListVoMap);

    /**
     * @Description:  当月新增放款车辆明细导出
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018-04-28 11:43
     */
    @RequestMapping(value = "api/prebiz/contract/findNewLoanExport",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findNewLoanExport(@RequestParam Map<String, Object> contractListVoMap);

    /**
    * @Description: 合同一览信息选择
    * @param: 
    * @return: 
    * @Author: yangyiquan
    * @Date: 2018/9/28 16:55
    */
    @RequestMapping(value = "api/prebiz/contract/findContractSelectListByPage",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContractSelectListByPage(@RequestParam Map<String, Object> contractListVoMap);

    /**
     * @Title:
     * @Description: 分页查询当月提报数据统计报表
     * @return
     * @throws
     * @date 2018-9-26 11:38:16
     */
    @RequestMapping(value = "api/postbiz/report_statistics/findReportStatisticsVoByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findReportStatisticsVoByPage(@RequestParam Map<String, Object> reportStatisticsVoMap);

    /**
     * @Title:
     * @Description: 分页查询融资租赁业务统计报表
     * @return
     * @throws
     * @date 2018-9-28 11:38:16
     */
    @RequestMapping(value = "api/postbiz/report_statistics/findBusinessStatisticsVoByPage" ,method = RequestMethod.GET)
    ResponseEntity<RestResponse> findBusinessStatisticsVoByPage(@RequestParam Map<String, Object> businessStatisticsVoMap);

    /**
     * @Title:
     * @Description:  有模板出excel测试
     * @return
     * @throws
     * @author huchenghao
     * @date 2018-4-11 11:43:20
     */
    @RequestMapping(value = "api/postbiz/report_statistics/reportstatisticsExport", method = RequestMethod.GET)
    Response reportstatisticsExport(@RequestParam("groupDistrict") String groupDistrict, @RequestParam("contractSerachDate") String contractSerachDate);

    /**
     * @Title:
     * @Description: 融资租赁业务统计报表导出
     * @return
     * @throws
     * @date 2018/10/8 13:53
     */
    @RequestMapping(value = "api/postbiz/report_statistics/reportBusinessStatisticsExport", method = RequestMethod.GET)
    Response reportBusinessStatisticsExport(@RequestParam("yearInquiries") String yearInquiries);

    /**
     * @Title:
     * @Description: 融资租赁审批数据统计报表导出
     * @return
     * @throws
     * @date 2018/10/13 11:53
     */
    @RequestMapping(value = "api/postbiz/report_statistics/reportApprovaltatisticsExport", method = RequestMethod.GET)
    Response reportApprovaltatisticsExport(@RequestParam("yearInquiries") String yearInquiries);

    /**
     * @Title:
     * @Description:  根据contNo获取合同详情顶部信息
     * @param contNo
     * @return ApplyBaseInfoVo
     * @throws
     * @author huzongcheng
     */
    @RequestMapping(value = "api/prebiz/contract/findContBaseInfo",method = RequestMethod.GET)
    ResponseEntity<RestResponse> findContBaseInfo(@RequestParam("contNo") String contNo);

}
