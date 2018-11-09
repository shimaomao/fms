package cn.com.leadu.fms.pojo.prebiz.vo.bizfiles;

import lombok.Data;

import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;
import java.util.List;
import java.util.Map;

@Data
public class CommonBizFilesVo {
    /**
     * @Fields  : 附件详情显示
     * @author qiaomengnan
     */
    private Map<String, BizFilesListVo> bizFilesInfo;

    /**
     * @Fields  : 附件录入
     * @author qiaomengnan
     */
    @NotNull(message = "请上传附件")
    @Size(min = 1 , message = "请上传附件")
    private List<BizFilesListVo> bizFilesListVos;

    /**
     * @Fields: 附件类型
     * @Author: yangyiquan
     */
    String fileType;

}