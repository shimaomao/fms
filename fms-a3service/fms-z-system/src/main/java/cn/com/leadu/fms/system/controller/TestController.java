package cn.com.leadu.fms.system.controller;

import cn.com.leadu.fms.common.util.OpenOfficeUtils;
import cn.com.leadu.fms.common.util.WordPoiUtils;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

/**
 * @author qiaomengnan
 * @ClassName: TestController
 * @Description:
 * @date 2018/4/2
 */
@RestController
@RequestMapping("/test")
public class TestController {

    @RequestMapping("/pdf")
    public String test(){
        String filepath = "/data/word_pdf/鲁诺.docx";
        String outpath = "/data/word_pdf/鲁诺.pdf";
        try {
            OpenOfficeUtils.outPdf(filepath,outpath);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

    @RequestMapping("/replacePdf")
    public String replacePdf(){
        Map<String,String> map = new HashMap<>();
        map.put("NAME","乔梦楠");
        WordPoiUtils.replaceAndGenerateWord("/data/word_pdf/name.docx",
                "/data/word_pdf/name_20180402.docx",map);
        try {
            OpenOfficeUtils.outPdf("/data/word_pdf/name_20180402.docx","/data/word_pdf/name_20180402.pdf");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return "success";
    }

//    public static void main(String[] args) {

//    }




}
