package cn.com.leadu.fms.webclient.postbiz.controller;


import cn.com.leadu.fms.common.util.CommonFeignUtils;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.monthlyrent.MonthlyRentVo;
import cn.com.leadu.fms.webclient.postbiz.rpc.MonthlyRentRpc;
import com.alibaba.fastjson.JSON;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

/**
 * @author qinmuqiao
 * @ClassName: AnnualInspectionController
 * @Description: 月租到账率controller
 */
@RestController
@RequestMapping("monthly_rent")
public class MonthlyRentController {


    /**
     * @Fields  : 月租到账率rpc
     */
    @Autowired
    private MonthlyRentRpc monthlyRentRpc;

    /**
     * @Title:
     * @Description: 分页查询月租到账率
     * @param monthlyRentVo
     * @return
     * @throws
     * @author qinmuqiao
     * @date 2018-9-8 15:31:09
     */
    @RequestMapping(value = "findMonthlyRentsByPage",method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findMonthlyRentsByPage(MonthlyRentVo monthlyRentVo){
        Map annualInspectionVoMap = monthlyRentVo == null?null:(Map) JSON.toJSON(monthlyRentVo);
        return monthlyRentRpc.findMonthlyRentsByPage(annualInspectionVoMap);
    }

    /**
     * @Title:
     * @Description: 模板出excel
     * @param:  params 参数集合
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/19 14:59
     */
    @RequestMapping(value = "excelExport" , method = RequestMethod.GET)
    public ResponseEntity excelExport(String monthlyRentId) throws IOException {
//        Map monthlyRentVoMap = monthlyRentVo == null?null:(Map) JSON.toJSON(monthlyRentVo);
        Response response = monthlyRentRpc.excelExport(monthlyRentId);
        return CommonFeignUtils.getResponseEntity(response, MediaType.APPLICATION_OCTET_STREAM);
    }
}
