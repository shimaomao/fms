package cn.com.leadu.fms.webclient.file.controller;

import cn.com.leadu.fms.common.util.CommonFeignUtils;
import cn.com.leadu.fms.webclient.file.rpc.ExcelRpc;
import feign.Response;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.io.IOException;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: ExcelController
 * @Description: excel文件处理
 * @date 2018/4/19
 */
@RestController
@RequestMapping("excel")
public class ExcelController {

    @Autowired
    private ExcelRpc excelRpc;

    /**
     * @Title:
     * @Description: 导出excel
     * @param:  params 参数集合
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/4/19 14:59
     */
    @RequestMapping(value = "exportExcel" , method = RequestMethod.GET)
    public ResponseEntity exportExcel(@RequestParam Map<String,Object> params) throws IOException {
        Response response = excelRpc.exportExcel(params);
        return CommonFeignUtils.getResponseEntity(response, MediaType.APPLICATION_OCTET_STREAM);
    }

}
