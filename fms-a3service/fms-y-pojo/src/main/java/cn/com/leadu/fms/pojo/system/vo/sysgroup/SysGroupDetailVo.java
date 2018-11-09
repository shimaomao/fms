package cn.com.leadu.fms.pojo.system.vo.sysgroup;

import lombok.Data;

/**
 * @author wangxue
 * @ClassName: SysGroupDetailVo
 * @Description: 用户组信息Vo
 * @date 2018-03-10
 */
@Data
public class SysGroupDetailVo {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 用户组ID
     */
    private String groupId;

    /**
     * @Fields  : 用户组代码
     */
    private String groupCode;

    /**
     * @Fields  : 用户组全称
     */
    private String groupName;

    /**
     * @Fields  : 用户组简称
     */
    private String groupNameShort;

    /**
     * @Fields  : 用户组英文简称
     */
    private String groupNameEng;

    /**
     * @Fields  : 层级代码
     */
    private String groupLev;

    /**
     * @Fields  : 层级名称
     */
    private String groupLevName;

    /**
     * @Fields  : 统一社会信用代码
     */
    private String socialCertifNo;

    /**
     * @Fields  : 注册地址
     */
    private String registeredAddr;

    /**
     * @Fields  : 负责人
     */
    private String head;

    /**
     * @Fields  : 区域
     */
    private String groupDistrict;

    /**
     * @Fields  : 启用标志
     */
    private String enableFlag;

    /**
     * @Fields  : 上级用户组代码(行政)
     */
    private String adminParentGroup;

    /**
     * @Fields  : 上级用户组名称(行政)
     */
    private String adminParentGroupName;

    /**
     * @Fields  : 上级用户组代码(财务)
     */
    private String financeParentGroup;

    /**
     * @Fields  : 上级用户组名称(财务)
     */
    private String financeParentGroupName;

    /**
     * @Fields  : 上级用户组代码(销售)
     */
    private String sellParentGroup;

    /**
     * @Fields  : 上级用户组名称(销售)
     */
    private String sellParentGroupName;

    /**
     * @Fields  : 上级用户组代码(运营)
     */
    private String operateParentGroup;

    /**
     * @Fields  : 上级用户组名称(运营)
     */
    private String operateParentGroupName;

    /**
     * @Fields  : 财务辅助核算代码
     */
    private String finassGroupCode;
}
