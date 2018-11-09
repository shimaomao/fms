package cn.com.leadu.fms.common.constant.enums.file;

/**
 * @author qiaomengnan
 * @ClassName: FileTypePathEnums
 * @Description: 文件上传或生成时的文件夹名称
 * @date 2018/6/28
 */
public enum FileTypePathEnums {

    /**
     * @Fields  : 合同模板较为特殊,secondPath 二级目录需要在保存的时候确认
     * @author qiaomengnan
     */
    SYS_TPL("sysTpl",false,false,"合同模板路径"),
    PY_FILES("pyFiles",true,false,"鹏元文件路径"),
    KING_DEE_FILES("kingDeeFiles",true,false,"金蝶文件路径"),
    BIZ_FILES("bizFiles",true,true,"附件路径"),
    UP_LOAD("upLoad",true,true,"上传文件路径"),
    DN_LOAD("dnLoad",true,false,"用户下载文件"),
    GOLDEN_TAX_FILES("goldenTaxFiles",true,false,"金税文件路径");

    /**
     * @Fields  : 文件路径
     * @author qiaomengnan
     */
    private String type;

    /**
     * @Fields  : 是否按照日期分割
     * @author qiaomengnan
     */
    private boolean date;

    /**
     * @Fields  : 是否有二级目录
     * @author qiaomengnan
     */
    private boolean secondPath;

    /**
     * @Fields  : 描述
     * @author qiaomengnan
     */
    private String desc;


    FileTypePathEnums(String type,boolean date,boolean secondPath,String desc){
        this.type = type;
        this.date = date;
        this.secondPath = secondPath;
        this.desc =desc;
    }

    public String getType(){
        return type;
    }

    public boolean getDate(){
        return date;
    }

    public boolean getSecondPath(){
        return secondPath;
    }

    public String getDesc(){
        return desc;
    }

}
