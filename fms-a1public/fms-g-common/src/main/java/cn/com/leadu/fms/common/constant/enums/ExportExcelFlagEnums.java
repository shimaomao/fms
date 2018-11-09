package cn.com.leadu.fms.common.constant.enums;

/**
 * @author qiaomengnan
 * @ClassName: ExportExcelFlagEnums
 * @Description:  导出excel时的参数
 * @date 2018/4/19
 */
public enum ExportExcelFlagEnums {

    SERVICE_FLAG("serviceFlag","服务所对应的标识"),
    REQUEST_URL("requestUrl","请求excel数据的url"),
    EXCEL_DATA_MAX("excelDataMax","导出excel最大数量标识");

    private String flag;

    private String desc;

    ExportExcelFlagEnums(String flag, String desc){
        this.flag = flag;
        this.desc = desc;
    }

    public String getFlag(){
        return flag;
    }

}
