package cn.com.leadu.fms.pojo.system.vo.desk;

import lombok.Data;

/**
 * @author huzongcheng
 * @ClassName: RoleApproveVo
 * @Description: 角色对应审批模块情况
 * @date 2018/1/12
 */
@Data
public class RoleApproveVo {
    /**
     * @Fields  : 模块名称
     */
    private String name;

    /**
     * @Fields  : 模块code,跳转入参用
     */
    private String code;

    /**
     * @Fields  : 图标url
     */
    private String iconUrl;
    /**
     * @Fields  : 对应数量
     */
    private String count;

    /**
     * @Fields  : 跳转url
     */
    private String routerUrl;
}
