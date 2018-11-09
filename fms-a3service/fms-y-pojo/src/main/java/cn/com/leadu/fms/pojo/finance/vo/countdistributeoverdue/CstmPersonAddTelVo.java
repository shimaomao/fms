package cn.com.leadu.fms.pojo.finance.vo.countdistributeoverdue;

import lombok.Data;

/**
 * @Title: 客户的地址信息和电话信息
 * @Description:
 * @author: wangxue
 * @date 2018/9/5 10:15
 */
@Data
public class CstmPersonAddTelVo {

    /**
     * @Fields  : 申请编号
     * @author wangxue
     */
    private String applyNo;

    /**
     * @Fields  : 主贷人证件号
     * @author wangxue
     */
    private String certifNo;

    /**
     * @Fields  : 主贷人姓名
     * @author wangxue
     */
    private String name;

    /**
     * @Fields  : 主贷人手机号码
     * @author ningyangyang
     */
    private String mobileNo;

    /**
     * @Fields  : 主贷人单位所在详细地址
     * @author ningyangyang
     */
    private String compAddr;

    /**
     * @Fields  : 主贷人居住详细地址
     * @author ningyangyang
     */
    private String resideAddr;

    /**
     * @Fields  : 主贷人户籍详细地址
     * @author ningyangyang
     */
    private String censusAddr;

    /**
     * @Fields  : 主贷人房产详细地址
     * @author ningyangyang
     */
    private String propertyAddr;

    /**
     * @Fields  : 实际用车人姓名
     * @author ningyangyang
     */
    private String driver;

    /**
     * @Fields  : 实际用车人电话
     * @author ningyangyang
     */
    private String driverMobno;

    /**
     * @Fields  : 配偶姓名
     * @author ningyangyang
     */
    private String mateName;

    /**
     * @Fields  : 配偶电话
     * @author ningyangyang
     */
    private String mateMobile;

    /**
     * @Fields  : 配偶工作地址
     * @author ningyangyang
     */
    private String mateCompAddr;

}
