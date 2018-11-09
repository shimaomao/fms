package cn.com.leadu.fms.file.controller;

import cn.com.leadu.fms.extend.config.WebServiceNames;
import cn.com.leadu.fms.file.service.ExcelService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
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
    private ExcelService excelService;

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
    public void exportExcel(@RequestParam Map<String,Object> params, HttpServletResponse httpServletResponse){
        excelService.excelExport(params,httpServletResponse);
    }

}
