package cn.com.leadu.fms.pojo.prebiz.vo.crmperson;/**
 * Created by ningyangyang on 2018/6/2.
 */

import lombok.Data;

import java.math.BigDecimal;

/**
 * @Title: fms
 * @Description:
 * @author: ningyangyang
 * @date 2018/6/2 16:15
 */
@Data
public class GuaranteeMate {

    /**
     * @Fields  : 配偶姓名
     */
    private String mateName;

    /**
     * @Fields  : 配偶证件类型
     */
    private String mateCertifType;

    /**
     * @Fields  : 配偶证件号码
     */
    private String mateCertifNo;

    /**
     * @Fields  :配偶手机号码
     */
    private String mateMobileNo;

    /**
     * @Fields  :配偶企业名称
     */
    private String mateCompName;

    /**
     * @Fields  :配偶企业电话
     */
    private String mateCompTel;

    /**
     * @Fields  :配偶职位
     */
    private String matePosition;

    /**
     * @Fields  : 配偶薪资
     */
    private BigDecimal mateSalary;

    /**
     * @Fields  :配偶单位所在省份
     */
    private String mateCompProv;

    /**
     * @Fields  :配偶单位所在城市
     */
    private String mateCompCity;

    /**
     * @Fields  :配偶单位所在区县
     */
    private String mateCompCounty;

    /**
     * @Fields  :配偶单位详细地址
     */
    private String mateCompAddr;
}
