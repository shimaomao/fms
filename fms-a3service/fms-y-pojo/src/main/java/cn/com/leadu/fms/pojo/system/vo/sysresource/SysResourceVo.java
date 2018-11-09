package cn.com.leadu.fms.pojo.system.vo.sysresource;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.entity.SysResource;
import lombok.Data;

import java.util.ArrayList;
import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysResourceVo
 * @Description: 菜单信息载体
 * @date 2018/1/12
 */
@Data
public class SysResourceVo extends PageQuery<SysResource> {

    private String id;

    private String name;

    private String res;

    private String description;

    private Integer sort;

    private String icon;

    private String parentId;

    private Integer type;

    private Integer resLevel;

    private List<SysResourceVo> children = new ArrayList<>();

    private List<String> ids;

}
