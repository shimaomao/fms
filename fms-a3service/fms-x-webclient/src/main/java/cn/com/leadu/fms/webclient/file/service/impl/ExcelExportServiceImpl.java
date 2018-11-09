package cn.com.leadu.fms.webclient.file.service.impl;

import cn.com.leadu.fms.webclient.file.service.ExcelExportService;
import org.springframework.stereotype.Service;

/**
 * @author qiaomengnan
 * @ClassName: ExcelExportServiceImpl
 * @Description: 对远程请求excel文件处理做操作
 * @date 2018/1/31
 */
@Service
public class ExcelExportServiceImpl implements ExcelExportService {

//    @Autowired
//    private CmsWebClientProperties cmsWebClientProperties;
//
//    @Autowired
//    private ExcelRpc excelExportRpc;
//
//    private Map<String,String> getExcelExportInfo(String excelType){
//        if(StringUtil.isNotTrimBlank(excelType)) {
//            String[] excelExportKeys = excelType.split(".");
//            if(excelExportKeys != null && excelExportKeys.length == 2 ) {
//               Map<String,String> result = cmsWebClientProperties.getExcelExportUrls().get(excelExportKeys[0])
//                .get(excelExportKeys[1]);
//               return result;
//            }
//        }
//        return null;
//    }

//    /**
//     * @Title:
//     * @Description:  根据excelType导出excel
//     * @param excelType
//     * @return
//     * @throws
//     * @author qiaomengnan
//     * @date 2018/01/31 04:42:00
//     */
//    public void excelExport(String excelType) throws CmsRpcException{
//        Map<String,String> result = getExcelExportInfo(excelType);
//        if(StringUtil.isNotTrimBlank(result,result.get("url"),result.get("returnType"))){
//             String filePath = ResponseEntityUtil.getRestResponseData(excelExportRpc.excelExport(result));
//        }
//
//
//
//    }
//



}
