package cn.com.leadu.fms.pojo.original.vo.origfiledetail;

import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.original.entity.OrigFileDetail;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import com.fasterxml.jackson.annotation.JsonFormat;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * Created by lijunjun on 2018/5/30.
 */
@Data
public class OrigFileBorrowTaskVo extends PageQuery<OrigFileDetail> {

    /**
     * @Fields  : 业务号
     * @author lijunjun
     */
    private String bizCode;

    /**
     * @Fields  : 业务类型
     * @author lijunjun
     */
    private String bizCodeType;

    /**
     * @Fields  : 归档编号
     * @author lijunjun
     */
    private String fileRecordNo;

    /**
     * @Fields  : 借阅任务号
     * @author lijunjun
     */
    private String borrowTaskNo;

    /**
     * @Fields  : 归还任务号
     * @author yangyiquan
     */
    private String borrowBackTaskNo;

    /**
     * @Fields  : 申请人
     * @author lijunjun
     */
    private String borrowUser;

    /**
     * @Fields  : 申请人联系方式
     * @author lijunjun
     */
    private String borrowUserTel;

    /**
     * @Fields  : 邮寄详细地址
     * @author lijunjun
     */
    private String postDetailAddress;

    /**
     * @Fields  : 是否交押金
     * @author lijunjun
     */
    private String depositFlag;

    /**
     * @Fields  : 押金金额
     * @author lijunjun
     */
    private BigDecimal depositAmount;

    /**
     * @Fields  : 快递公司
     * @author lijunjun
     */
    private String postComp;

    /**
     * @Fields  : 快递编号
     * @author lijunjun
     */
    private String postNo;

    /**
     * @Fields  : 邮寄日期
     * @author lijunjun
     */
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    private Date postDate;

    /**
     * @Fields  : 备注
     * @author lijunjun
     */
    private String remark;

    /**
     * @Fields  : 任务号
     * @author lijunjun
     */
    private String taskId;

    /**
     * @Fields  : 归档附件大类
     * @author yangyiquan
     */
    private String origFileType;

    /**
     * @Fields  : 归档附件大类
     * @author yangyiquan
     */
    private String fileQtyLimit;

    /**
     * @Fields  : 原件归档明细List
     * @author lijunjun
     */
    private List<OrigFileDetailVo> origFileDetailVoList;

    /**
     * @Fields  : 附件集合用于返回详情使用
     * @author qiaomengnan
     */
    private List<BizFiles> bizFilesList;

    /**
     * @Fields  : 领取方式
     * @author : yangyiquan
     */
    private String borrowGetWay;

    /**
     * @Fields  : 预计归还时间
     * @author : ningyangyang
     */
    @JsonFormat(pattern = DateUtils.formatStr_yyyyMMdd)
    private Date expectedReturnDate;

    /**
     * @Fields  : 收款银行
     * @author ningyangyang
     */
    private String recAccBank;
    /**
     * @Fields  : 收款银行分行
     * @author ningyangyang
     */
    private String recAccBranch;
    /**
     * @Fields  : 收款账号
     * @author ningyangyang
     */
    private String recAccountNo;

    /**
     * @Fields  : 收款户名
     * @author ningyangyang
     */
    private String recAccountName;

    /**
     * @Fields  : 是否抵扣租金
     * @author ningyangyang
     */
    private String deductFlag;

    /**
     * @Fields  : 借阅用途
     * @author : yangyiquan
     */
    private String borrowPurpose;

    /**
     * 收款状态
     */
    private String paymentSts;

    /**
     * 过户状态
     */
    private String transferSts;

}
