package cn.com.leadu.fms.pojo.prebiz.vo.applyinput;

import cn.com.leadu.fms.pojo.baseinfo.vo.baspartner.BasPartnerVo;
import cn.com.leadu.fms.pojo.postbiz.entity.ChangeLesseeTask;
import cn.com.leadu.fms.pojo.postbiz.vo.changelesseetask.ChangeLesseeTaskVo;
import cn.com.leadu.fms.pojo.prebiz.entity.*;
import cn.com.leadu.fms.pojo.prebiz.vo.applyfinance.ApplyFinanceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.applyvehicle.ApplyVehicleVo;
import cn.com.leadu.fms.pojo.prebiz.vo.applyvisit.ApplyVisitVo;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import lombok.Data;
import org.hibernate.validator.constraints.NotEmpty;

import javax.validation.Valid;
import java.math.BigDecimal;
import java.util.List;
import java.util.Map;

/**
 * @author wangxue
 * @ClassName: ApplyInputVo
 * @Description: 申请录入信息载体
 * @date 2018-03-24
 */
@Data
public class ApplyInputVo {

    private static final long serialVersionUID = 1L;

    /**
     * @Fields  : 融资信息
     */
    @Valid
    private ApplyFinanceVo applyFinanceVo;

    /**
     * @Fields  : 车辆及融资明细信息
     */
    @Valid
    private List<ApplyVehicleVo> applyVehicleVoList;

    /**
     * @Fields : 客户基本信息
     */
    private CstmPerson cstmPerson;
    /**
     * @Fields : 客户职业信息
     */
    private CstmPersJob cstmPersJob;
    /**
     * @Fields : 客户配偶信息
     */
    private CstmPersMate cstmPersMate;
    /**
     * @Fields : 客户地址信息
     */
    private CstmPersAddr cstmPersAddr;
    /**
     * @Fields : 客户联系人信息
     */
    private List<CstmContact> cstmContactList;
    /**
     * @Fields : 企业客户基本信息
     */
    private CstmCompany cstmCompany;
    /**
     * 担保人信息
     */
    private List<GuaranteePers> guaranteePersList;
    /**
     * 担保企业信息
     */
    private List<GuaranteeComp> guaranteeCompList;

    /**
     *  共同借款人
     */
    List<CommonBorrower> commonBorrowerList;

    /**
     * 客户类型：1-个人；2-企业
     */
    private String applyType;

    /**
     * 订单编号
     */
    private String applyNo;

    /**
     * @Fields  : 附件
     */
    private CommonBizFilesVo bizfilesVo;

    /**
     * @Fields  : 申请机构经销商信息
     */
    private BasPartnerVo basPartnerVo;

    /**
     * @Fields  : 用户
     */
    private String user;
    /**
     * @Fields  : 用户所属组织机构
     */
    private String userGroup;

    /**
     * @Fields  : 任务id
     * @author qiaomengnan
     */
    private String taskId;

    /**
     * @Fields  : 车辆累加的指导价
     * @author qiaomengnan
     */
    private BigDecimal vehiclesGuidePriceCount;

    /**
     * @Fields  : 模型评分
     * @author qiaomengnan
     */
    private String creditGrade;

    /**
     * @Fields  : 模型关系
     * @author qiaomengnan
     */
    private Map<String,Object> echartsMap;

    /**
     * @Fields  : 企业类型1
     * @author ningyangyang
     */
    private String companyType1;

    /**
     * @Fields  : 企业类型2
     * @author ningyangyang
     */
    private String companyType2;

    /**
     * @Fields  : 购车合理性对象
     * @author ningyangyang
     */
    private RationalityPurchase rationalityPurchase;

    /**
     * @Fields  : 股东信息
     * @author ningyangyang
     */
    private List<StockAssets> stockAssetsList;

    /**
     * @Fields  : crm股东信息
     * @author ningyangyang
     */
    private List<CrmStockAssets> crmStockAssetsList;

    /**
     * @Fields  : 是否家访
     * @author ningyangyang
     */
    private String visitFlag;

    /**
     * @Fields  : 家访信息
     * @author ningyangyang
     */
    private ApplyVisitVo applyVisitVo;

    /**
     * @Fields  : 不家访理由
     * @author ningyangyang
     */
    private String novisitReason;

    /**
     * @Fields  : 客户姓名
     * @author
     */
    private String cstmName;

    /**
     * @Fields  : 备注
     * @author
     */
    private String remark;

    /**
     * @Fields  : 销售顾问
     * @author
     */
    private SysUser sysUser;

    /**
     * @Fields  : 变更承租人任务号
     * @author
     */
    private String taskNo;

    /**
     * @Fields  : 变更承租人附件
     * @author
     */
    private List<BizFiles> bizFilesList;

    /**
     * @Fields  : 变更承租人合同生成附件
     * @author
     */
    private List<BizFiles> contGenerateFilesList;

    /**
     * @Fields  : 变更承租人合同打印附件
     * @author
     */
    private List<BizFiles> contPrintFilesList;

    /**
     * @Fields  : 变更原因说明
     * @author
     */
    private String changeReason;
    /**
     * @Fields  : 合同号
     * @author
     */
    private String contNo;

    /**
     * @Fields  : 变更承租人对象
     * @author
     */
    private ChangeLesseeTaskVo changeLesseeTask;

    /**
     * @Fields  : 变更承租人对象
     * @author
     */
    private Apply apply;

    /**
     * @Fields  : 旧的applyNo
     * @author
     */
    private String oldApplyNo;

    /**
     * @Fields  : 合同附件类型
     * @author
     */
    private String contractFileType;
    /**
     * @Fields  : 车架号
     * @author  ningyangyang
     */
    private String vinNo;

    /**
     * @Fields  : 出租人
     * @author  ningyangyang
     */
    private String groupName;

}
