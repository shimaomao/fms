package cn.com.leadu.fms.pojo.asset.vo.mortgageregister;/**
 * Created by yyq on 2018/5/22.
 */

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.asset.entity.MortgageRegister;
import cn.com.leadu.fms.pojo.original.entity.OrigFileDetail;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * @program: fms
 * @description: 解抵押邮寄Vo
 * @author: yangyiquan
 * @create: 2018-05-22 16:26
 **/
@Data
public class MortgagePostVo extends PageQuery<MortgageRegister> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 解除抵押ID
     * @author yangyiquan
     */
    private String mortgageRegisterId;

    /**
     * @Fields  : 合同编号
     * @author yangyiquan
     */
    private String contNo;

    /**
     * @Fields  : 结清日期
     * @author yangyiquan
     */
    private Date settleDate;

    /**
     * @Fields  : 牌照属性
     * @author yangyiquan
     */
    private String licenseAttr;

    /**
     * @Fields  : 解抵押状态
     * @author yangyiquan
     */
    private String mortgateSts;

    /**
     * @Fields  : 登记账号
     * @author yangyiquan
     */
    private String registerUser;

    /**
     * @Fields  : 保险公司
     * @author yangyiquan
     */
    private String insCompName;

    /**
     * @Fields  : 商业险保单号
     * @author yangyiquan
     */
    private String insPolicyNo;

    /**
     * @Fields  : 抵押日期
     * @author yangyiquan
     */
    private Date mortgageDate;

    /**
     * @Fields  : 车管所
     * @author yangyiquan
     */
    private String dmvName;

    /**
     * @Fields  : 解除抵押原因
     * @author yangyiquan
     */
    private String mortgageReason;

    /**
     * @Fields  : 邮寄资料地址属性
     * @author yangyiquan
     */
    private String postAddrType;

    /**
     * @Fields  : 邮寄地址
     * @author yangyiquan
     */
    private String postAddr;

    /**
     * @Fields  : 邮寄备注/情况说明
     * @author yangyiquan
     */
    private String postMemo;

    /**
     * @Fields  : 资料邮寄ID
     * @author yangyiquan
     */
    private String filePostId;

    /**
     * @Fields  : 解除抵押ID
     * @author yangyiquan
     */
    private List<String> mortgageRegisterIds;

    /**
     * @Fields  : 申请姓名
     * @author yanfengbo
     */
    private String name;

    /**
     * @Fields  : 订单提出机构
     * @author yanfengbo
     */
    private String groupName;

    /**
     * @Fields  : 车牌号
     * @author yanfengbo
     */
    private String vehicleLicenseNo;

    /**
     * @Fields  : 车架号
     * @author yanfengbo
     */
    private String vinNo;

    /**
     * @Fields  : 发动机号
     * @author yanfengbo
     */
    private String engineNo;

    /************** 邮寄资料信息 ***************/
    /**
     * @Fields  : 快递公司
     * @author ningyangyang
     */
    private String postComp;
    /**
     * @Fields  : 快递编号
     * @author ningyangyang
     */
    private String postNo;
    /**
     * @Fields  : 快递日期
     * @author ningyangyang
     */
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    private Date postDate;
    /**
     * @Fields  : 邮寄快递人员
     * @author ningyangyang
     */
    private String postMember;

    /**
     * @Fields  : 联系电话
     * @author ningyangyang
     */
    private String postMemberTel;

    /************** 邮寄明细信息 ***************/
    private List<OrigFileDetail> origFileDetailList;
}
