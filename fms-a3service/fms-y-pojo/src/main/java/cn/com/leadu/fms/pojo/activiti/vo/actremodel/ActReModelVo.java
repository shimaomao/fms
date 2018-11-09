package cn.com.leadu.fms.pojo.activiti.vo.actremodel;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;

/**
 * @author qiaomengnan
 * @ClassName: ActModelVo
 * @Description: 模型Vo
 * @date 2018/3/12
 */
@Data
public class ActReModelVo extends PageQuery<ActReModelVo> {

    private String id;

    private String name;

    private String key;

    private String category;

    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMddHHmmss)
    private Date createTime;

    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMddHHmmss)
    private Date lastUpdateTime;

    private Integer version;

    private String metaInfo;

    private String deploymentId;

    private String tenantId;

    private boolean hasEditorSource;

    private boolean hasEditorSourceExtra;

    private String description;

    private String modelXml;

}
