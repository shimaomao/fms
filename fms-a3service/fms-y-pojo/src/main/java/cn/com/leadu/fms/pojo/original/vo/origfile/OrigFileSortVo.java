package cn.com.leadu.fms.pojo.original.vo.origfile;

import cn.com.leadu.fms.pojo.insurance.vo.renewalregister.RenewalRegisterVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileDetailVo;
import cn.com.leadu.fms.pojo.prebiz.entity.BizFiles;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import cn.com.leadu.fms.pojo.prebiz.vo.continsurance.ContInsuranceVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContractVo;
import lombok.Data;

import java.util.List;

/**
 * @ClassName: OrigFileSortVo
 * @Description: 贷前归档Vo
 * @author lijunjun
 * @date 2018-05-03
 */
@Data
public class OrigFileSortVo {

    /**
     * @Fields  : 资料ID
     * @author ningyangyang
     */
    private String origFileId;

    /**
     * @Fields  : 资料邮寄业务号
     * @author ningyangyang
     */
    private String bizCode;

    /**
     * @Fields  : 资料邮寄业务类型
     * @author ningyangyang
     */
    private String bizCodeType;

    /**
     * @Fields  : 归档附件大类
     * @author yangyiquan
     */
    private String origFileType;

    /**
     * @Fields  : 资料邮寄附件明细
     * @author lijunjun
     */
    private List<OrigFileDetailVo> origFileDetailVoList;

    /**
     * @Fields  : 合同车辆保险信息
     * @author lijunjun
     */
    private ContInsuranceVo contInsuranceVo;

    /**
     * @Fields  : 合同信息
     * @author lijunjun
     */
    private ContractVo contractVo;

    /**
     * @Fields  : 续保信息
     * @author lijunjun
     */
    private RenewalRegisterVo renewalRegisterVo;

    /**
     * @Fields  : 附件信息
     * @author lijunjun
     */
    private CommonBizFilesVo commonBizFilesVo;

    /**
     * @Fields  : 附件集合用于返回详情使用
     * @author qiaomengnan
     */
    private List<BizFiles> bizFilesList;

    /**
     * @Fields  : 备注
     * @author lijunjun
     */
    private String remark;

    /**
     * @Fields  : 归档编号
     * @author lijunjun
     */
    private String fileRecordNo;

    /**
     * @Fields  : 任务ID
     * @author lijunjun
     */
    private String taskId;

    /**
     * @Fields  : 客户姓名
     * @author ningyangyang
     */
    private String cstmName;

    /**
     * @Fields  : 车架号
     * @author ningyangyang
     */
    private String vinNo;


    /**
     * @Fields  : 归档状态
     * @author ningyangyang
     */
    private String origFileStatus;

    /**
     * @Fields  : 归档车架号
     * @author yanfengbo
     */
    private String origVinNo;

    /**
     * @Fields  : 归档发动机号
     * @author yanfengbo
     */
    private String origEngineeNo;

    /**
     * @Fields  : 归档备注
     * @author yanfengbo
     */
    private String origMemo;
}
