package cn.com.leadu.fms.system.validator.sysresource.vo;

import cn.com.leadu.fms.common.vo.BaseVo;
import cn.com.leadu.fms.pojo.system.entity.SysResource;
import lombok.Data;
import org.hibernate.validator.constraints.NotBlank;

import javax.validation.constraints.NotNull;

/**
 * @author qiaomengnan
 * @ClassName: SysResourceSaveVo
 * @Description:
 * @date 2018/1/12
 */
@Data
public class SysResourceSaveVo extends BaseVo<SysResource> {

    @NotBlank(message = "英文名称不能为空")
    private String name;

    @NotBlank(message = "资源路径不能为空")
    private String res;

    @NotBlank(message = "中文名称不能为空")
    private String description;

    private Integer sort;

    private String icon;

    @NotBlank(message = "上级菜单不能为空")
    private String parentId;

    @NotNull(message = "菜单类型不能为空")
    private Integer type;

    private Integer resLevel;

}
