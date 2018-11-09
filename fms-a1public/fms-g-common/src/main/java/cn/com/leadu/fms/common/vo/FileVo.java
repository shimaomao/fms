package cn.com.leadu.fms.common.vo;

import cn.com.leadu.fms.common.util.StringUtils;
import lombok.Data;

/**
 * @author qiaomengnan
 * @ClassName: FileVo
 * @Description: 文件信息
 * @date 2018/3/26
 */
@Data
public class FileVo {
    private String fileId;

    private String fileName;

    private String fileSuffix;

    private String filePath;

    private String fileCompletePath;

    private String fileOriginalName;

    public FileVo(){}

    public FileVo(String fileName,String fileSuffix,String filePath,String fileOriginalName){
        this.fileName = fileName;
        this.fileSuffix = fileSuffix;
        this.filePath = filePath;
        if(StringUtils.isNotTrimBlank(filePath)){
            if((filePath.lastIndexOf("/")+1)  != filePath.length()){
                fileCompletePath = filePath + "/" + fileName;
            }else{
                fileCompletePath = filePath + fileName;
            }
        }
        this.fileOriginalName = fileOriginalName;
    }

}
