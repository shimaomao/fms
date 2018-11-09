package cn.com.leadu.fms.pojo.system.vo.sysrole;

import cn.com.leadu.fms.common.annotation.ExcelTitle;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.system.entity.SysRole;
import cn.com.leadu.fms.pojo.system.vo.sysresource.SysResourceVo;
import lombok.Data;

import java.util.List;

/**
 * @author qiaomengnan
 * @ClassName: SysRoleVo
 * @Description: 角色信息载体
 * @date 2018/1/12
 */
@ExcelTitle(value = "角色信息")
@Data
public class SysRoleVo extends PageQuery<SysRole> {
    /**
     * @Fields  : 角色id
     */
    private String roleId;
    /**
     * @Fields  : 角色名称
     */
    private String roleName;
    /**
     * @Fields  : 角色代码
     */
    private String role;
    /**
     * @Fields  : 启用标识
     */
    private String enableFlag;
    /**
     * @Fields  : 排序
     */
    private String orderNo;
    /**
     * @Fields  : 角色id集合
     */
    private List<String> ids;

    @ExcelTitle(value = "角色代码",sort = 1)
    public String getRole() {
        return role;
    }
    @ExcelTitle(value = "角色名称",sort = 2)
    public String getRoleName() {
        return roleName;
    }
    @ExcelTitle(value = "启用标识",sort = 3,codeType = CommonCodeTypeConstants.COMMON_STATUS)
    public String getEnableFlag() {
        return enableFlag;
    }
    @ExcelTitle(value = "排序",sort = 4)
    public String getOrderNo() {
        return orderNo;
    }
}
