package cn.com.leadu.fms.pojo.postbiz.vo.depositchange;

import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.entity.GuaranteeComp;
import cn.com.leadu.fms.pojo.prebiz.entity.GuaranteePers;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import lombok.Data;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author huzongcheng
 * @ClassName: DepositChangeApplyVo
 * @Description: 增加保证金申请载体
 */
@Data
public class DepositChangeApplyVo extends PageQuery<DepositChangeApplyVo> {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields :
     */
    private String taskId;

    /**
     * @Fields : 变更任务号
     * @author huzongcheng
     */
    private String depositTaskNo;

    /**
     * @Fields : 出租人
     * @author huzongcheng
     */
    private String lessor;

    /**
     * @Fields : 承租人
     * @author huzongcheng
     */
    private String lessee;

    /**
     * @Fields : 承租人证件号
     * @author huzongcheng
     */
    private String certifNo;

    /**
     * @Fields : 合同编号
     * @author huzongcheng
     */
    private String contNo;

    /**
     * @Fields : 申请类型
     * @author huzongcheng
     */
    private String applyType;

    /**
     * @Fields : 区域
     * @author huzongcheng
     */
    private String groupDistrict;

    /**
     * @Fields : 车架号
     * @author huzongcheng
     */
    private String vinNo;

    /**
     * @Fields : 车牌号
     * @author huzongcheng
     */
    private String vehicleLicenseNo;

    /**
     * @Fields : 融资金额
     * @author huzongcheng
     */
    private BigDecimal finTotal;

    /**
     * @Fields : 融资期限
     * @author huzongcheng
     */
    private String finPeriodType;

    /**
     * @Fields : 已还期限
     * @author huzongcheng
     */
    private Integer alreadyRepayNper;

    /**
     * @Fields : 已还金额
     * @author yangyiquan
     */
    private BigDecimal alreadyRepayAmount;

    /**
     * @Fields : 剩余租金
     * @author huzongcheng
     */
    private BigDecimal residueAmount;

    /**
     * @Fields : 保证金
     * @author huzongcheng
     */
    private BigDecimal deposit;

    /**
     * @Fields : 补充保证金
     * @author huzongcheng
     */
    private BigDecimal supplementDeposit;

    /**
     * 担保人信息
     */
    private List<GuaranteePers> guaranteePersList;
    /**
     * 担保企业信息
     */
    private List<GuaranteeComp> guaranteeCompList;

    /**
     * @Fields : 读取上传后的附件
     */
    private CommonBizFilesVo bizfilesVo;

    /**
     * @Fields : 需要上传的附件信息
     * @author yanfengbo
     */
    private List<BizFiles> bizFilesList;

    /**
     * @Fields : 申请备注
     * @author huzongcheng
     */
    private String applyRemark;

}