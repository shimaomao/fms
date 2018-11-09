package cn.com.leadu.fms.webclient.postbiz.controller;

import cn.com.leadu.fms.common.util.CommonFeignUtils;
import cn.com.leadu.fms.extend.response.RestResponse;
import cn.com.leadu.fms.pojo.postbiz.vo.monthlyoverdue.MonthlyOverduesVo;

import cn.com.leadu.fms.webclient.postbiz.rpc.MonthlyOverdueRpc;
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
 * @author yangyiquan
 * @ClassName: MonthlyOverdueController
 * @Description: 逾期统计信息controller
 */
@RestController
@RequestMapping("monthly_overdue")
public class MonthlyOverdueController {

    /**
     * @Fields  : 逾期统计信息rpc
     */
    @Autowired
    private MonthlyOverdueRpc monthlyOverdueRpc;

    /**
     * @Title:
     * @Description: 分页查询逾期统计信息
     * @param monthlyOverduesVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @RequestMapping(value = "findMonthlyOverduesVosByPage" ,method = RequestMethod.GET)
    public ResponseEntity<RestResponse> findMonthlyOverduesVosByPage(MonthlyOverduesVo monthlyOverduesVo){
        Map monthlyOverduesVoMap = monthlyOverduesVo == null?null:(Map) JSON.toJSON(monthlyOverduesVo);
        return monthlyOverdueRpc.findMonthlyOverduesVosByPage(monthlyOverduesVoMap);
    }

    /**
     * @Title:
     * @Description: 模板出excel
     * @param:  monthlyOverduesVo 参数集合
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/19 14:59
     */
    @RequestMapping(value = "excelExport" , method = RequestMethod.GET)
    public ResponseEntity excelExport(MonthlyOverduesVo monthlyOverduesVo) throws IOException {
        Map paramsMap = monthlyOverduesVo == null ? null : (Map) JSON.toJSON(monthlyOverduesVo);
        Response response = monthlyOverdueRpc.excelExport(paramsMap);
        return CommonFeignUtils.getResponseEntity(response, MediaType.APPLICATION_OCTET_STREAM);
    }

}
