package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.common.util.CommonFeignUtils;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.BusinessStatisticsVo;
import cn.com.leadu.fms.pojo.postbiz.vo.licenseidx.ReportStatisticsVo;
import cn.com.leadu.fms.webclient.prebiz.rpc.ContractRpc;
import com.alibaba.fastjson.JSON;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * Created by admin on 2018/9/27.
 */
@RestController
@RequestMapping("report_statistics")
public class ReportStatisticsController {

    /**
     * @Fields: 合同信息一览rpc
     */
    @Autowired
    private ContractRpc contractRpc;
    /**
     * @Title:
     * @Description: 分页查询当月提报数据统计报表
     * @param reportStatisticsVo
     * @return
     * @throws
     * @date 2018-9-26 11:38:16
     */
    @RequestMapping(value = "findReportStatisticsVoByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findReportStatisticsVoByPage(ReportStatisticsVo reportStatisticsVo){
        Map reportStatisticsVoMap = reportStatisticsVo == null?null:(Map) JSON.toJSON(reportStatisticsVo);
        return contractRpc.findReportStatisticsVoByPage(reportStatisticsVoMap);
    }

    /**
     * @Title:
     * @Description: 分页查询融资租赁业务统计报表
     * @param businessStatisticsVo
     * @return
     * @throws
     * @date 2018-9-28 11:38:16
     */
    @RequestMapping(value = "findBusinessStatisticsVoByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findBusinessStatisticsVoByPage(BusinessStatisticsVo businessStatisticsVo){
        Map businessStatisticsVoMap = businessStatisticsVo == null?null:(Map) JSON.toJSON(businessStatisticsVo);
        return contractRpc.findBusinessStatisticsVoByPage(businessStatisticsVoMap);
    }

    /**
     * @Title:
     * @Description: 当月提报数据统计导出
     * @return
     * @throws
     * @date 2018/9/29 14:59
     */
    @RequestMapping(value = "reportstatisticsExport" ,method = RequestMethod.GET)
    public ResponseEntity reportstatisticsExport(String groupDistrict,String contractSerachDate){
        Response response = contractRpc.reportstatisticsExport(groupDistrict,contractSerachDate);
        return CommonFeignUtils.getResponseEntity(response, MediaType.APPLICATION_OCTET_STREAM);
    }

    /**
     * @Title:
     * @Description: 融资租赁业务统计报表导出
     * @return
     * @throws
     * @date 2018/10/8 13:53
     */
    @RequestMapping(value = "reportBusinessStatisticsExport" ,method = RequestMethod.GET)
    public ResponseEntity reportBusinessStatisticsExport(String yearInquiries){
        Response response = contractRpc.reportBusinessStatisticsExport(yearInquiries);
        return CommonFeignUtils.getResponseEntity(response, MediaType.APPLICATION_OCTET_STREAM);
    }

    /**
     * @Title:
     * @Description: 融资租赁审批数据统计报表导出
     * @return
     * @throws
     * @date 2018/10/13 11:53
     */
    @RequestMapping(value = "reportApprovaltatisticsExport" ,method = RequestMethod.GET)
    public ResponseEntity reportApprovaltatisticsExport(String yearInquiries){
        Response response = contractRpc.reportApprovaltatisticsExport(yearInquiries);
        return CommonFeignUtils.getResponseEntity(response, MediaType.APPLICATION_OCTET_STREAM);
    }
}
