package cn.com.leadu.fms.pojo.system.vo.desk;/**
 * Created by yyq on 2018/5/3.
 */

import lombok.Data;

import java.util.List;

/**
 * @program: fms
 * @description: 主页工作台相关内容查询vo
 * @author: huzongcheng
 **/
@Data
public class DeskSearchVo {
    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 查询类型 "1":最近30天、"2":本月
     */
    private String searchType;

    /**
     * @Fields  : 当前用户
     */
    private String sysUser;

    /**
     * @Fields  : 当前用户所属机构
     */
    private List<String> sysUserGroup;

    /**
     * @Fields  : 申请编号集合
     */
    private List<String> applyNoList;

    /**
     * @Fields  : 合同状态
     */
    private String contractStatus;

    /**
     * @Fields  : 归档状态
     */
    private String origStatus;

}
