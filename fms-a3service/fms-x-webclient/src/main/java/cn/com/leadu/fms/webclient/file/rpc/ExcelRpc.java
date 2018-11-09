package cn.com.leadu.fms.webclient.file.rpc;

import feign.Response;
import org.springframework.cloud.netflix.feign.FeignClient;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: ExcelRpc
 * @Description: excel远程调用
 * @date 2018/1/31
 */
@FeignClient("${fms.feigns.serverNames.fmsAgent}")
public interface ExcelRpc {

    /**
     * @Title:
     * @Description: 导出excel
     * @param:  params 参数集合
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/19 14:59
     */
    @RequestMapping(value = "api/file/excel/exportExcel" , method = RequestMethod.GET)
    Response exportExcel(@RequestParam Map<String,Object> params);

}
