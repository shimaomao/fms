package cn.com.leadu.fms.common.constant.enums.file;

/**
 * @author qiaomengnan
 * @ClassName: FileTypeEnums
 * @Description:
 * @date 2018/6/19
 */
public enum  FileTypeEnums {

    PENG_YUAN("peng_yuan","鹏元附件","peng_yuan");

    private String type;

    private String desc;

    private String filePath;

    FileTypeEnums(String type,String desc,String filePath){
        type = type;
        desc = desc;
        filePath = filePath;
    }

    public String getType(){
        return type;
    }

    public String getDesc(){
        return desc;
    }

    public String getFilePath(){
        return filePath;
    }

}
