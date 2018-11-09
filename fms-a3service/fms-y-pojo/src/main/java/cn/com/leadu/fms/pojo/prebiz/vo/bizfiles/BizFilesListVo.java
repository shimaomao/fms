package cn.com.leadu.fms.pojo.prebiz.vo.bizfiles;

import cn.com.leadu.fms.common.vo.FileVo;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.Size;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: BizFilesListVo
 * @Description: 用于接收上传附件的vo
 * @date 2018/4/13 0013
 */
@Data
public class BizFilesListVo {

    /**
     * @Fields  : 附件类型
     * @author qiaomengnan
     */
    private String basFileTypeValue;

    /**
     * @Fields  : 文件集合
     * @author qiaomengnan
     */
    private List<FileVo> fileVos;

}
