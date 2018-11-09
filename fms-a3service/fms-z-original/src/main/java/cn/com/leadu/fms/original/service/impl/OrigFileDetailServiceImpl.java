package cn.com.leadu.fms.original.service.impl;

import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.APPROVAL;
import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.CANCEL;
import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.SENDBACK;
import static cn.com.leadu.fms.common.constant.enums.ActTypeEnums.SUBMIT;

import cn.com.leadu.fms.business.common.constant.enums.activiti.ActProcessInstanceKeyEnums;
import cn.com.leadu.fms.business.common.util.activiti.ActFileBorrowBackTaskUtils;
import cn.com.leadu.fms.business.common.util.activiti.ActFileBorrowTaskUtils;
import cn.com.leadu.fms.business.service.BizFilesService;
import cn.com.leadu.fms.business.service.CommonPdfService;
import cn.com.leadu.fms.business.service.NumGenerateService;
import cn.com.leadu.fms.business.service.WorkflowLogService;
import cn.com.leadu.fms.common.constant.enums.BizStatusEnums;
import cn.com.leadu.fms.common.constant.enums.NumTypeEnums;
import cn.com.leadu.fms.common.constant.enums.YesNoFlagEnums;
import cn.com.leadu.fms.common.constant.enums.baseinfo.BasFileTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.BizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.ChargeStatusEnums;
import cn.com.leadu.fms.common.constant.enums.finance.ExamTypeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.InputModeEnums;
import cn.com.leadu.fms.common.constant.enums.finance.PayFundNameEnums;
import cn.com.leadu.fms.common.constant.enums.finance.PayStatusEnums;
import cn.com.leadu.fms.common.constant.enums.finance.ReceiptBizTypeEnums;
import cn.com.leadu.fms.common.constant.enums.original.BorrowPurposeEnum;
import cn.com.leadu.fms.common.constant.enums.original.FileTypeCodeEnums;
import cn.com.leadu.fms.common.constant.enums.original.OrigFileBizCodeTypeEnum;
import cn.com.leadu.fms.common.constant.enums.original.OrigFileDetailStatusEnums;
import cn.com.leadu.fms.common.constant.enums.system.TplTypeKeyEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.ArrayUtils;
import cn.com.leadu.fms.common.util.DateUtils;
import cn.com.leadu.fms.common.util.EntityUtils;
import cn.com.leadu.fms.common.util.JsonUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.common.util.UUIDUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.ContChargeRepository;
import cn.com.leadu.fms.data.finance.repository.ContReceiptExamRepository;
import cn.com.leadu.fms.data.finance.repository.ContReceiptRepository;
import cn.com.leadu.fms.data.original.repository.BorrowBackTaskRepository;
import cn.com.leadu.fms.data.original.repository.BorrowTaskDetailRepository;
import cn.com.leadu.fms.data.original.repository.BorrowTaskRepository;
import cn.com.leadu.fms.data.original.repository.OrigFileDetailRepository;
import cn.com.leadu.fms.data.original.repository.OrigFileRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContPayRepository;
import cn.com.leadu.fms.extend.common.util.RequestUtils;
import cn.com.leadu.fms.original.service.BorrowBackTaskService;
import cn.com.leadu.fms.original.service.BorrowTaskService;
import cn.com.leadu.fms.original.service.OrigFileDetailService;
import cn.com.leadu.fms.original.validator.origfiledetail.vo.OrigFileDetailDeleteListVo;
import cn.com.leadu.fms.original.validator.origfiledetail.vo.OrigFileDetailDeleteVo;
import cn.com.leadu.fms.original.validator.origfiledetail.vo.OrigFileDetailModifyVo;
import cn.com.leadu.fms.original.validator.origfiledetail.vo.OrigFileDetailSaveVo;
import cn.com.leadu.fms.pojo.activiti.vo.actrutask.ActRuTaskVo;
import cn.com.leadu.fms.pojo.finance.entity.ContCharge;
import cn.com.leadu.fms.pojo.finance.entity.ContReceipt;
import cn.com.leadu.fms.pojo.finance.entity.ContReceiptExam;
import cn.com.leadu.fms.pojo.finance.vo.contreceipt.ContReceiptVo;
import cn.com.leadu.fms.pojo.original.entity.BorrowBackTask;
import cn.com.leadu.fms.pojo.original.entity.BorrowTask;
import cn.com.leadu.fms.pojo.original.entity.BorrowTaskDetail;
import cn.com.leadu.fms.pojo.original.entity.OrigFile;
import cn.com.leadu.fms.pojo.original.entity.OrigFileDetail;
import cn.com.leadu.fms.pojo.original.vo.borrowbacktask.BorrowBackTaskVo;
import cn.com.leadu.fms.pojo.original.vo.borrowtask.BorrowTaskVo;
import cn.com.leadu.fms.pojo.original.vo.origfile.OrigFileVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileBorrowFinanceVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileBorrowTaskVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileDetailVo;
import cn.com.leadu.fms.pojo.original.vo.origfiledetail.OrigFileStatusVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import cn.com.leadu.fms.pojo.prebiz.entity.WorkflowLog;
import cn.com.leadu.fms.pojo.prebiz.vo.bizfiles.CommonBizFilesVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

/**
 * @author ningyangyang
 * @ClassName: OrigFileDetailService
 * @Description: 资料邮寄附件明细业务实现层
 * @date 2018-05-03
 */
@Service
public class OrigFileDetailServiceImpl implements OrigFileDetailService {

    /**
     * 借阅任务信息业务层
     */
    @Autowired
    private BorrowTaskService borrowTaskService;

    /**
     * @Fields  : 借阅任务明细repository
     */
    @Autowired
    private BorrowTaskDetailRepository borrowTaskDetailRepository;

    /**
     * 借阅归还任务信息业务层
     */
    @Autowired
    private BorrowBackTaskService borrowBackTaskService;

    /**
     * @Fields  : 资料邮寄附件明细repository
     */
    @Autowired
    private OrigFileDetailRepository origFileDetailRepository;

    /**
     * @Fields  : 资料邮寄附件明细repository
     */
    @Autowired
    private OrigFileRepository origFileRepository;
    /**
     * @Fields  : 借阅任务表repository
     */
    @Autowired
    private BorrowTaskRepository borrowTaskRepository;

    /**
     * @Fields  : 借阅归还任务表repository
     */
    @Autowired
    private BorrowBackTaskRepository borrowBackTaskRepository;

    /**
     * @Fields  : 财务收款表repository
     */
    @Autowired
    private ContReceiptRepository contReceiptRepository;

    /**
     * @Fields  : 财务付款表repository
     */
    @Autowired
    private ContPayRepository contPayRepository;

    /**
     * @Fields  : 财务待收款表repository
     */
    @Autowired
    private ContChargeRepository contChargeRepository;

    /**
     * @Fields  : 财务勾稽表repository
     */
    @Autowired
    private ContReceiptExamRepository contReceiptExamRepository;

    /**
     * @Fields  : 业务编号管理repository
     */
    @Autowired
    private NumGenerateService numGenerateService;

    /**
     * @Fields  : 通用pdfservice
     * @author yanfengbo
     */
    @Autowired
    private CommonPdfService commonPdfService;

    @Autowired
    private BizFilesService bizFilesService;

    @Autowired
    private WorkflowLogService workflowLogService;

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件明细
     * @param origFileDetailVo
     * @return PageInfoExtend<OrigFileDetail>
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:40
     */
    public List<OrigFileDetailVo> findOrigFileDetailsByPage(OrigFileDetailVo origFileDetailVo){
        if(ArrayUtils.isNotNullAndLengthNotZero(origFileDetailVo.getOrigFileDetailBizCodes())){
            origFileDetailVo.setOrigFileDetailBizCodes(origFileDetailVo.getOrigFileDetailBizCodes());
        }else{
            origFileDetailVo.setOrigFileDetailBizCodes(null);
        }
        if(StringUtils.isTrimBlank(origFileDetailVo.getFileSolveFlag())){
            // 判断从{原件邮寄画面}{原件归档画面}进行调用的处理区分【mail-原件邮寄；sort-原件归档】
            origFileDetailVo.setFileSolveFlag(null);
        }
        return origFileDetailRepository.selectOrigFileDetails(origFileDetailVo);

    }

    /**
     * @Title:
     * @Description: 根据借阅任务号查询资料邮寄附件明细信息
     * @param borrowTaskNo
     * @return List<OrigFileDetailVo>
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @Override
    public List<OrigFileDetailVo> findOrigFileBorrowMailByBorrowTaskNo(String borrowTaskNo) {
        if (borrowTaskNo == null){
            throw new FmsServiceException("参数不正确");
        }
        List<OrigFileDetailVo> origFileDetailVoList = origFileDetailRepository.selectOrigFileBorrowMailByBorrowTaskNo(borrowTaskNo);
        return origFileDetailVoList;
    }

    /**
     * @Title:
     * @Description: 根据借阅任务号查询资料邮寄附件明细信息（借阅归还）
     * @param origFileDetailVo
     * @return List<OrigFileDetailVo>
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @Override
    public List<OrigFileDetailVo> findOrigFileBorrowBackMailByBorrowTaskNo(OrigFileDetailVo origFileDetailVo) {
        if (origFileDetailVo == null || (origFileDetailVo != null && origFileDetailVo.getBorrowTaskNo() == null)){
            throw new FmsServiceException("参数不正确");
        }
        List<OrigFileDetailVo> origFileDetailVoList = origFileDetailRepository.findOrigFileBorrowBackMailByBorrowTaskNo(origFileDetailVo);
        return origFileDetailVoList;
    }

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件明细
     * @param borrowBackTaskNo
     * @return List<OrigFileDetail>
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @Override
    public List<OrigFileDetailVo> findOrigFileBorrowMailByBorrowBackTaskNo(String borrowBackTaskNo) {
        if (borrowBackTaskNo == null){
            throw new FmsServiceException("参数不正确");
        }
        List<OrigFileDetailVo> origFileDetailVoList = origFileDetailRepository.selectOrigFileBorrowMailByBorrowBackTaskNo(borrowBackTaskNo);
        return origFileDetailVoList;
    }

    /**
     * @param origFileDetailVo
     * @return List<OrigFileDetail>
     * @throws
     * @Title:
     * @Description: 分页查询资料邮寄附件明细（借阅归还资管复核明细）
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @Override
    public List<OrigFileDetailVo> findOrigFileBorrowExamineByBorrowBackTaskNo(OrigFileDetailVo origFileDetailVo) {
        if (origFileDetailVo == null || (origFileDetailVo != null && origFileDetailVo.getBorrowBackTaskNo() == null)){
            throw new FmsServiceException("参数不正确");
        }
        List<OrigFileDetailVo> origFileDetailVoList = origFileDetailRepository.selectOrigFileBorrowExamineByBorrowBackTaskNo(origFileDetailVo);
        return origFileDetailVoList;
    }

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件明细(原件归档明细)
     * @param origFileDetailVo
     * @return PageInfoExtend<OrigFileDetail>
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @Override
    public OrigFileBorrowTaskVo findOrigFileBorrowDetails(OrigFileDetailVo origFileDetailVo){
        OrigFileBorrowTaskVo origFileBorrowTaskVo = new OrigFileBorrowTaskVo();
        BorrowTaskVo borrowTask = new BorrowTaskVo();
        if(StringUtils.isTrimBlank(origFileDetailVo.getBizCode())){
            origFileDetailVo.setBizCode(null);
        }
        if(StringUtils.isTrimBlank(origFileDetailVo.getBizCodeType())){
            origFileDetailVo.setBizCodeType(null);
        }
        if(StringUtils.isTrimBlank(origFileDetailVo.getBorrowTaskNo())){
            origFileDetailVo.setBorrowTaskNo(null);
        }else{
            borrowTask = borrowTaskService.findBorrowTaskByBorrowTaskNo(origFileDetailVo.getBorrowTaskNo());
            EntityUtils.getEntity(borrowTask,origFileBorrowTaskVo);
        }
        //附件信息
        if(StringUtils.isNotTrimBlank(origFileDetailVo.getBizCode())){
            // 获取过户状态和合同的结清状态
            OrigFileStatusVo origFileStatusVo = origFileRepository.selectOrigFileStatusVoByContNo(origFileDetailVo.getBizCode());
            if (origFileStatusVo != null){
                origFileBorrowTaskVo.setPaymentSts(origFileStatusVo.getPaymentSts());// 还款状态
                origFileBorrowTaskVo.setTransferSts(origFileStatusVo.getTransferSts());// 过户状态
            }
            origFileBorrowTaskVo.setBizCode(origFileDetailVo.getBizCode()) ;
            origFileBorrowTaskVo.setBizCodeType(origFileDetailVo.getBizCodeType());
            Example example = SqlUtil.newExample(OrigFile.class);
            example.createCriteria().andEqualTo("bizCode",origFileDetailVo.getBizCode()).
                    andEqualTo("bizCodeType", origFileDetailVo.getBizCodeType());
            OrigFile origFile = origFileRepository.selectOneByExample(example);
            origFileBorrowTaskVo.setOrigFileType(origFile.getOrigFileType());
            origFileBorrowTaskVo.setFileRecordNo(origFile.getFileRecordNo());
        }else{
            //根据归档编号取得附件类型
            if(StringUtils.isNotTrimBlank(borrowTask.getFileRecordNo())){
                Example example = SqlUtil.newExample(OrigFile.class);
                example.createCriteria().andEqualTo("fileRecordNo",borrowTask.getFileRecordNo()).
                        andEqualTo("bizCodeType", OrigFileBizCodeTypeEnum.COMPLETE_CONTRACT.getType());
                OrigFile origFile = origFileRepository.selectOneByExample(example);
                origFileBorrowTaskVo.setBizCode(origFile.getBizCode()) ;
                origFileBorrowTaskVo.setBizCodeType(origFile.getBizCodeType());
                origFileBorrowTaskVo.setOrigFileType(origFile.getOrigFileType());
                // 获取过户状态和合同的结清状态
                OrigFileStatusVo origFileStatusVo = origFileRepository.selectOrigFileStatusVoByContNo(origFile.getBizCode());
                if (origFileStatusVo != null){
                    origFileBorrowTaskVo.setPaymentSts(origFileStatusVo.getPaymentSts());// 还款状态
                    origFileBorrowTaskVo.setTransferSts(origFileStatusVo.getTransferSts());// 过户状态
                }
            }
        }


        origFileDetailVo.setOrigFlag(YesNoFlagEnums.YES.getType());
        //显示所有是否需要归档为是的明细
        List<OrigFileDetailVo> origFileDetailVoList =  origFileDetailRepository.selectOrigFileBorrowDetails(origFileDetailVo);
        if (ArrayUtils.isNotNullAndLengthNotZero(origFileDetailVoList)){
            origFileBorrowTaskVo.setOrigFileDetailVoList(origFileDetailVoList);
        }
        origFileBorrowTaskVo.setBizFilesList(bizFilesService.findBizFilesList(origFileBorrowTaskVo.getBizCode(), origFileBorrowTaskVo.getOrigFileType()));

//        CommonBizFilesVo commonBizFilesVo = getContPrintFileList(origFileDetailVo.getBizCode(), origFileDetailVo.getFileType());
//        origFileBorrowTaskVo.setCommonBizFilesVo(commonBizFilesVo);
        return origFileBorrowTaskVo;
    }

    private CommonBizFilesVo getContPrintFileList(String bizCode, String bizCodeType){
        return bizFilesService.findBizFilesByBizCode(bizCode, bizCodeType);
    }

    /**
     * @Title:
     * @Description: 分页查询资料邮寄附件明细
     * @param origFileDetailVo
     * @return PageInfoExtend<OrigFileDetail>
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:40
     */
    public PageInfoExtend<OrigFileDetailVo> findOrigFileDetailByPage(OrigFileDetailVo origFileDetailVo){
        if (StringUtils.isTrimBlank(origFileDetailVo.getBizCode())){
            origFileDetailVo.setBizCode(null);
        }
        if (StringUtils.isTrimBlank(origFileDetailVo.getBizCodeType())){
            origFileDetailVo.setBizCodeType(null);
        }
        if (StringUtils.isTrimBlank(origFileDetailVo.getOrigFileDetailStatus())){
            origFileDetailVo.setOrigFileDetailStatus(null);
        }
        return origFileDetailRepository.selectListVoByPage("selectOrigFileDetailVosByPage", origFileDetailVo,origFileDetailVo.getPageQuery());
    }

    /**
     * @Title:
     * @Description: 保存资料邮寄附件明细
     * @param origFileDetailSaveVo
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:40
     */
    public void saveOrigFileDetail(OrigFileDetailSaveVo origFileDetailSaveVo){
        origFileDetailRepository.insertData(origFileDetailSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改资料邮寄附件明细
     * @param origFileDetailModifyVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:40
     */
    public void modifyOrigFileDetail(OrigFileDetailModifyVo origFileDetailModifyVo){
        origFileDetailRepository.updateByPrimaryKeySelectiveData(origFileDetailModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过origFileDetailId删除资料邮寄附件明细
     * @param origFileDetailDeleteVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:40
     */
    public void deleteOrigFileDetail(OrigFileDetailDeleteVo origFileDetailDeleteVo){
        origFileDetailRepository.deleteData(origFileDetailDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过origFileDetailId集合删除资料邮寄附件明细
     * @param origFileDetailDeleteListVo
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:40
     */
    public void deleteOrigFileDetailsByOrigFileDetailIds(OrigFileDetailDeleteListVo origFileDetailDeleteListVo){
        origFileDetailRepository.deleteDataList(origFileDetailDeleteListVo.getOrigFileDetailIds(),origFileDetailDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据origFileDetailId获取资料邮寄附件明细
     * @param origFileDetailId
     * @return OrigFileDetail
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:40
     */
    public OrigFileDetail findOrigFileDetailByOrigFileDetailId(String origFileDetailId){
        return origFileDetailRepository.selectByPrimaryKey(origFileDetailId);
    }

    /**
     * @Title:
     * @Description: 根据借阅归还任务号获取财务制单初始化信息
     * @param borrowBackTaskNo
     * @return BorrowBackTaskVo
     * @throws
     * @author ningyangyang
     * @date 2018-5-3 11:26:40
     */
    @Override
    public BorrowBackTaskVo getBorrowTaskMakeVoucherByBorrowBackTaskNo(String borrowBackTaskNo) {
        if (StringUtils.isTrimBlank(borrowBackTaskNo)){
            throw new FmsServiceException("参数不正确");
        }
        BorrowBackTaskVo borrowBackTaskVo = origFileDetailRepository.selectBorrowTaskMakeVoucherByBorrowBackTaskNo(borrowBackTaskNo);
        return borrowBackTaskVo;
    }

    /**
     * @Description: 根据资料邮寄业务号,资料邮寄业务类型查询所有邮寄附件明细信息
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/5/22 15:59
     */
    @Override
    public List<OrigFileDetail> findOrigFileDetailByExample(String bizCode,String bizCodeType) {
        Example example = SqlUtil.newExample(OrigFileDetail.class);
        Example.Criteria criteriaDetail = example.createCriteria();
        criteriaDetail.andEqualTo("bizCode",bizCode);
        criteriaDetail.andEqualTo("bizCodeType", bizCodeType);
        return origFileDetailRepository.selectListByExample(example);
    }

    /**
     * @Description: 获取资料回寄信息一览
     * @param: origFileVo
     * @return:
     * @Author: lijunjun
     * @Date: 2018/5/22 15:59
     */
    @Override
    public PageInfoExtend<OrigFileVo> findOrigFileBorrowBackSendByPage(OrigFileVo origFileVo) {
        //合同成交类
        origFileVo.setBizCodeType(OrigFileBizCodeTypeEnum.COMPLETE_CONTRACT.getType());
        origFileVo.setBorrowTaskStatus(BizStatusEnums.BORROWED.getType());
        origFileVo.setBorrowPurpose(BorrowPurposeEnum.TRANSFER.getType());
        if (StringUtils.isNotTrimBlank(origFileVo.getFileRecordNo())){
            origFileVo.setFileRecordNo(SqlUtil.likePattern(origFileVo.getFileRecordNo()));
        } else {
            origFileVo.setFileRecordNo(null);
        }

        if (StringUtils.isNotTrimBlank(origFileVo.getBizCode())){
            origFileVo.setBizCode(SqlUtil.likePattern(origFileVo.getBizCode()));
        } else {
            origFileVo.setBizCode(null);
        }

        if (StringUtils.isNotTrimBlank(origFileVo.getBorrowUser())){
            origFileVo.setBorrowUser(SqlUtil.likePattern(origFileVo.getBorrowUser()));
        } else {
            origFileVo.setBorrowUser(null);
        }

        //承租人
        if(StringUtils.isTrimBlank(origFileVo.getCstmName()))
            origFileVo.setCstmName(null);
        else
            origFileVo.setCstmName(SqlUtil.likePattern(origFileVo.getCstmName()));

        //车架号
        if(StringUtils.isTrimBlank(origFileVo.getVinNo()))
            origFileVo.setVinNo(null);
        else
            origFileVo.setVinNo(SqlUtil.likePattern(origFileVo.getVinNo()));
        // 借阅资料查询处理
        if (StringUtils.isNotTrimBlank(origFileVo.getOrigFileDetailNames()))
            origFileVo.setOrigFileDetailNames(SqlUtil.likePattern(origFileVo.getOrigFileDetailNames()));
        else
            origFileVo.setOrigFileDetailNames(null);
        //业务类型，只查出成交合同类型
        origFileVo.setBizCodeType(OrigFileBizCodeTypeEnum.COMPLETE_CONTRACT.getType());
        return origFileDetailRepository.selectListVoByPage("selectOrigFileBorrowBackSendByPage", origFileVo,origFileVo.getPageQuery());
    }

    /**
     * @Description: 原件借阅申请提交
     * @param:
     * @return:
     * @Author: lijunjun
     * @Date: 2018/5/22 15:59
     */
    @Transactional
    @Override
    public void borrowTask(OrigFileBorrowTaskVo origFileBorrowTaskVo, SysUser sysUser) {

        //录入借阅任务表
        BorrowTask borrowTask = EntityUtils.getEntity(origFileBorrowTaskVo,new BorrowTask());
        if(StringUtils.isTrimBlank(origFileBorrowTaskVo.getTaskId())){//第一次启动工作流
            borrowTask.setBorrowTaskNo(numGenerateService.getNumGenerateByNumType(NumTypeEnums.BORROW_TASK_NUM_TYPE.getType()));
        }

        boolean flag = false;//是否有车钥匙标记
        List<OrigFileDetail> origFileDetailList = new ArrayList<>();
        List<BorrowTaskDetail> borrowTaskDetailList = new ArrayList<>();//借阅任务明细表
        for (OrigFileDetailVo origFileDetailVo : origFileBorrowTaskVo.getOrigFileDetailVoList()){
            OrigFileDetail origFileDetail = origFileDetailVo.getEntity();
            origFileDetail.setOrigFileDetailStatus(OrigFileDetailStatusEnums.BE_BORROW.getType());//5-借阅中
            origFileDetail.setBorrowTaskNo(borrowTask.getBorrowTaskNo());//借阅任务号
            origFileDetailList.add(origFileDetail);
            if (StringUtils.isNotTrimBlank(origFileDetailVo.getFileType()) && origFileDetailVo.getFileType().startsWith(BasFileTypeEnums.CAR_KEY.getType())){
                flag = true;
            }
            //借阅任务明细
            BorrowTaskDetail borrowTaskDetail = new BorrowTaskDetail();
            borrowTaskDetail.setBorrowTaskNo(borrowTask.getBorrowTaskNo());
            borrowTaskDetail.setOrigFileDetailId(origFileDetailVo.getOrigFileDetailId());
            borrowTaskDetailList.add(borrowTaskDetail);
        }
        //更新原件归档明细表
        origFileDetailRepository.updateByPrimaryKeySelectiveDataList(origFileDetailList, true);

        if (YesNoFlagEnums.YES.getType().equals(origFileBorrowTaskVo.getDepositFlag())){
            //是否交押金为"是"的场合
            ContCharge contCharge = new ContCharge();
            contCharge.setChargeBizType(BizTypeEnums.BORROWED_DEPOSIT.getType());//业务类型 1-借阅押金
            contCharge.setChargeBizId(borrowTask.getBorrowTaskNo());//业务号
            contCharge.setChargeFund(PayFundNameEnums.BORROW_TASK_COST.getType());//款项名称
            contCharge.setChargeAmount(origFileBorrowTaskVo.getDepositAmount());//应收款金额
            contCharge.setChargeStatus(ChargeStatusEnums.TO_BE_COLLECTION.getType());//收款状态 0-待收款
            //登录财务待收款表
            contChargeRepository.insertData(contCharge);
        }
        ActRuTaskVo actRuTaskVo ;
        Map<String, Object> map = new HashMap<>();
        map.put("bizCode", origFileBorrowTaskVo.getBizCode());
        map.put("bizCodeType", origFileBorrowTaskVo.getBizCodeType());
        map.put("fileRecordNo", origFileBorrowTaskVo.getFileRecordNo());
        map.put("origFileType", origFileBorrowTaskVo.getOrigFileType());
        if (StringUtils.isNotTrimBlank(origFileBorrowTaskVo.getTaskId())){
            if (flag){
                //如果是车钥匙的场合
                if (YesNoFlagEnums.YES.getType().equals(origFileBorrowTaskVo.getDepositFlag())){
                    //如果是否交押金为"是"的场合 1：fileTypeCode
                    actRuTaskVo = ActFileBorrowTaskUtils.applyAgree(origFileBorrowTaskVo.getTaskId(), FileTypeCodeEnums.CARKEY_DEPOSIT_FLAG_YES.getType());
                }else{
                    //如果是否交押金为"否"的场合 2：fileTypeCode
                    actRuTaskVo = ActFileBorrowTaskUtils.applyAgree(origFileBorrowTaskVo.getTaskId(), FileTypeCodeEnums.CARKEY_DEPOSIT_FLAG_NO.getType());
                }
            }else{
                //其他资料的场合 0：fileTypeCode
                actRuTaskVo = ActFileBorrowTaskUtils.applyAgree(origFileBorrowTaskVo.getTaskId(),FileTypeCodeEnums.NOT_CARKEY.getType());
            }
        } else {
            //开启工作流
            if (flag){
                //如果是车钥匙的场合
                if (YesNoFlagEnums.YES.getType().equals(origFileBorrowTaskVo.getDepositFlag())){
                    //如果是否交押金为"是"的场合 1：fileTypeCode
                    actRuTaskVo = ActFileBorrowTaskUtils.startFileBorrowTask(borrowTask.getBorrowTaskNo(), ActProcessInstanceKeyEnums.FILE_BORROW_TASK.getKey(), origFileBorrowTaskVo.getFileRecordNo(), FileTypeCodeEnums.CARKEY_DEPOSIT_FLAG_YES.getType(), map);
                }else{
                    //如果是否交押金为"否"的场合 2：fileTypeCode
                    actRuTaskVo = ActFileBorrowTaskUtils.startFileBorrowTask(borrowTask.getBorrowTaskNo(), ActProcessInstanceKeyEnums.FILE_BORROW_TASK.getKey(), origFileBorrowTaskVo.getFileRecordNo(), FileTypeCodeEnums.CARKEY_DEPOSIT_FLAG_NO.getType(), map);
                }
            }else{
                //其他资料的场合 0：fileTypeCode
                actRuTaskVo = ActFileBorrowTaskUtils.startFileBorrowTask(borrowTask.getBorrowTaskNo(), ActProcessInstanceKeyEnums.FILE_BORROW_TASK.getKey(), origFileBorrowTaskVo.getFileRecordNo(), FileTypeCodeEnums.NOT_CARKEY.getType(), map);
            }
        }
        borrowTask.setPresentUser(actRuTaskVo.getNextAssignee());//下一节点审批人
        borrowTask.setBorrowTaskStatus(actRuTaskVo.getTaskCode());//借阅任务状态

        if(StringUtils.isTrimBlank(origFileBorrowTaskVo.getTaskId())){
            borrowTaskRepository.insertData(borrowTask);//插入借阅任务主表
            borrowTaskDetailRepository.insertDataList(borrowTaskDetailList);//插入借阅任务明细表
        }else{//更新借阅任务表
            BorrowTaskVo oldBorrowTask = borrowTaskService.findBorrowTaskByBorrowTaskNo(origFileBorrowTaskVo.getBorrowTaskNo());
            if(oldBorrowTask == null){
                throw new FmsServiceException("借阅任务不存在！");
            }
            borrowTask.setBorrowTaskId(oldBorrowTask.getBorrowTaskId());
            borrowTaskRepository.updateByPrimaryKeySelectiveData(borrowTask);
        }

        //审批日志登录
        this.workFlowCommon(sysUser.getUser(),borrowTask.getBorrowTaskNo(),BizTypeEnums.BORROWED_DEPOSIT.getType(),origFileBorrowTaskVo.getRemark(),
                SUBMIT.getType(),actRuTaskVo);
//        throw new FmsServiceException("ceshi");
    }

    /**
     * @Title:
     * @Description: 原件借阅取消
     * @param: origFileBorrowTaskVo
     * @param: sysUser
     * @return:
     * @Author: lijunjun
     * @Date: 2018/5/22 15:59
     */
    @Transactional
    @Override
    public void cancelOrigFileBorrow(OrigFileBorrowTaskVo origFileBorrowTaskVo, SysUser sysUser) {

        //工作流
        ActRuTaskVo actRuTaskVo = ActFileBorrowTaskUtils.borrowTaskOverComplete(origFileBorrowTaskVo.getTaskId());
        List<OrigFileDetail> origFileDetailList = new ArrayList<>();
        if (ArrayUtils.isNotNullAndLengthNotZero(origFileBorrowTaskVo.getOrigFileDetailVoList())){
            for (OrigFileDetailVo origFileDetailVo : origFileBorrowTaskVo.getOrigFileDetailVoList()){
                origFileDetailVo.setOrigFileDetailStatus(OrigFileDetailStatusEnums.BE_SORTED.getType());//文件状态 已归档
                origFileDetailVo.setBorrowTaskNo("");//清空借阅任务号
                origFileDetailList.add(origFileDetailVo.getEntity());
            }
        }
        //更新邮寄附件明细表
        if (ArrayUtils.isNotNullAndLengthNotZero(origFileDetailList)){
            origFileDetailRepository.updateByPrimaryKeySelectiveDataList(origFileDetailList, true);
        }

        BorrowTaskVo borrowTask = borrowTaskService.findBorrowTaskByBorrowTaskNo(origFileBorrowTaskVo.getBorrowTaskNo());
        if(borrowTask == null){
            throw new FmsServiceException("借阅任务不存在");
        }
        borrowTask.setBorrowTaskStatus(BizStatusEnums.BORROW_CANCEL.getType());//当前状态
        borrowTask.setPresentUser("");//当前审批人
        borrowTaskRepository.updateByPrimaryKeySelectiveData(borrowTask.getEntity());

        //审批日志登录
        this.workFlowCommon(sysUser.getUser(),origFileBorrowTaskVo.getBorrowTaskNo(),BizTypeEnums.BORROWED_DEPOSIT.getType(),origFileBorrowTaskVo.getRemark(),
                CANCEL.getType(),actRuTaskVo);
    }

    /**
     * @Description: 根据borrowTaskId获取借阅任务信息
     * @param: borrowTaskId
     * @return: BorrowTaskVo
     * @Author: lijunjun
     * @Date: 2018/5/22 15:59
     */
    @Override
    public BorrowBackTaskVo findOrigFileBorrowTaskInfo(String borrowTaskNo, String borrowBackTaskNo) {
        BorrowBackTaskVo borrowBackTaskVo = new BorrowBackTaskVo();
        OrigFileDetailVo origFileDetailVo = new OrigFileDetailVo();
        BorrowTaskVo borrowTask = new BorrowTaskVo();
        //退回再提交处理
        if(StringUtils.isExits(borrowBackTaskNo)){
            origFileDetailVo.setBorrowBackTaskNo(borrowBackTaskNo);
            //根据归还任务号取得借阅任务号(用来取得借阅明细)
            borrowBackTaskVo = borrowBackTaskService.findBorrowBackTaskByBorrowBackTaskNo(borrowBackTaskNo);
            if(borrowBackTaskVo != null){
                borrowTaskNo = borrowBackTaskVo.getBorrowTaskNo();
            }else{
                throw new FmsServiceException("借阅归还任务不存在");
            }
        }

        if (StringUtils.isTrimBlank(borrowTaskNo)){
            throw new FmsServiceException("借阅任务号不能为空");
        }
        origFileDetailVo.setBorrowTaskNo(borrowTaskNo);
        borrowTask = borrowTaskService.findBorrowTaskByBorrowTaskNo(borrowTaskNo);
        if (borrowTask != null) {
            borrowBackTaskVo.setBorrowTaskNo(borrowTask.getBorrowTaskNo());
            borrowBackTaskVo.setDepositFlag(borrowTask.getDepositFlag());
            borrowBackTaskVo.setDepositAmount(borrowTask.getDepositAmount());
            borrowBackTaskVo.setFileRecordNo(borrowTask.getFileRecordNo());
        }


        //根据借阅任务号查找
        List<OrigFileDetailVo> origFileDetailVoList =  origFileDetailRepository.selectOrigFileBorrowDetails(origFileDetailVo);
//        for(OrigFileDetailVo origFileDetail:origFileDetailVoList){
//            origFileDetail.setOrigFileDetailStatus(OrigFileDetailStatusEnums.BE_BORROWED.getType());
//        }
        borrowBackTaskVo.setOrigFileDetailVoList(origFileDetailVoList);

        return borrowBackTaskVo;
    }

    /**
     * @Description: 借阅审批
     * @param: borrowTaskId
     * @return: BorrowTaskVo
     * @Author: lijunjun
     * @Date: 2018/5/22 15:59
     */
    @Transactional
    @Override
    public void borrowTaskExamine(BorrowTaskVo borrowTaskVo, SysUser sysUser) {

        //借阅审批工作流
        ActRuTaskVo actRuTaskVo = ActFileBorrowTaskUtils.borrowTaskExamineAgree(borrowTaskVo.getTaskId());
        Example example = SqlUtil.newExample(BorrowTask.class);
        example.createCriteria().andEqualTo("borrowTaskNo", borrowTaskVo.getBorrowTaskNo());
        BorrowTask borrowTask = borrowTaskRepository.selectOneByExample(example);
        if (borrowTask == null){
            throw new FmsServiceException("当前借阅信息不存在");
        }
        borrowTask.setPresentUser(actRuTaskVo.getNextAssignee());//下一节点审批人
        borrowTask.setBorrowTaskStatus(actRuTaskVo.getTaskCode());//借阅任务状态
        borrowTaskRepository.updateByPrimaryKeySelectiveData(borrowTask, true);

        //审批日志登录
        this.workFlowCommon(sysUser.getUser(),borrowTaskVo.getBorrowTaskNo(),BizTypeEnums.BORROWED_DEPOSIT.getType(),borrowTaskVo.getRemark(),
                APPROVAL.getType(),actRuTaskVo);
    }

    /**
     * @Title:
     * @Description: 借阅审批-退回
     * @param borrowTaskVo
     * @param sysUser
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @Transactional
    @Override
    public void borrowTaskExamineBack(BorrowTaskVo borrowTaskVo, SysUser sysUser) {

        ActRuTaskVo actRuTaskVo = ActFileBorrowTaskUtils.approvalReturnSuperior(borrowTaskVo.getTaskId());
        approvalReturnSuperior(actRuTaskVo, borrowTaskVo.getBorrowTaskNo(), sysUser, borrowTaskVo.getRemark());
    }

    /** 
    * @Description:  借阅审批-退回
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/17 16:38
    */ 
    private void approvalReturnSuperior(ActRuTaskVo actRuTaskVo, String borrowTaskNo, SysUser sysUser, String remark){
        Example example = SqlUtil.newExample(BorrowTask.class);
        example.createCriteria().andEqualTo("borrowTaskNo", borrowTaskNo);
        BorrowTask borrowTask = borrowTaskRepository.selectOneByExample(example);
        if (borrowTask == null){
            throw new FmsServiceException("借阅信息不存在");
        }
        borrowTask.setPresentUser(actRuTaskVo.getNextAssignee());//下一节点审批人
        borrowTask.setBorrowTaskStatus(actRuTaskVo.getTaskCode());
        //更新借阅任务表
        borrowTaskRepository.updateByPrimaryKeySelectiveData(borrowTask, true);
        //审批日志登录
        this.workFlowCommon(sysUser.getUser(),borrowTaskNo,BizTypeEnums.BORROWED_DEPOSIT.getType(),
                remark, SENDBACK.getType(),actRuTaskVo);
    }

    /** 
    * @Description: 归还资管审核退回
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/17 15:54
    */ 
    private void borrowBackTaskApprovalReturnSuperior(ActRuTaskVo actRuTaskVo, String borrowBackTaskNo, SysUser sysUser, String remark){
        BorrowBackTask borrowBackTask = borrowBackTaskService.findBorrowBackEntityByBorrowBackTaskNo(borrowBackTaskNo);
        if (borrowBackTask == null){
            throw new FmsServiceException("借阅归还信息不存在");
        }
        borrowBackTask.setPresentUser(actRuTaskVo.getNextAssignee());//下一节点审批人
        borrowBackTask.setBorrowBackTaskStatus(actRuTaskVo.getTaskCode());
        //更新借阅归还任务表
        borrowBackTaskRepository.updateByPrimaryKeySelectiveData(borrowBackTask, true);
        //审批日志登录
        this.workFlowCommon(sysUser.getUser(),borrowBackTaskNo,BizTypeEnums.ORIG_BORROWED_BACK.getType(),
                remark, SENDBACK.getType(),actRuTaskVo);
    }

    /**
     *  @Title:
     * @Description: 归还资管审核通过
     * @param borrowBackTaskVo
     * @param sysUser
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @Transactional
    @Override
    public void borrowBackTaskExamine(BorrowBackTaskVo borrowBackTaskVo, SysUser sysUser) {
        if(StringUtils.isNotExits(borrowBackTaskVo.getBorrowBackTaskNo())){
            throw new FmsServiceException("借阅归还任务信息不存在");
        }
        BorrowBackTask borrowBackTask = borrowBackTaskService.findBorrowBackEntityByBorrowBackTaskNo(borrowBackTaskVo.getBorrowBackTaskNo());
        if (borrowBackTask == null){
            throw new FmsServiceException("借阅归还任务信息不存在");
        }
        ActRuTaskVo actRuTaskVo ;
        if (YesNoFlagEnums.NO.getType().equals(borrowBackTaskVo.getDepositFlag())//是否交押金为否的场合
                || borrowBackTaskVo.getDepositAmount()==null || new BigDecimal("0").compareTo(borrowBackTaskVo.getDepositAmount())==0){//或者押金金额为空或0
            //结束流程
            actRuTaskVo = ActFileBorrowBackTaskUtils.reviewComplete(borrowBackTaskVo.getTaskId());
        }else {
            if (YesNoFlagEnums.YES.getType().equals(borrowBackTaskVo.getDeductFlag())){
                //是否交押金为是且 是否抵扣租金为是的场合 录入财务收款表 结束流程
                ContReceipt contReceipt = new ContReceipt();
                contReceipt.setInputMode(InputModeEnums.INTER.getType());//数据来源 2-借阅抵扣押金
                contReceipt.setReceiptAmount(borrowBackTaskVo.getDepositAmount());//到账金额
                contReceipt.setRestAmount(borrowBackTaskVo.getDepositAmount());//剩余金额
                String memo = "借阅押金,任务号："+borrowBackTaskVo.getBorrowBackTaskNo()+",合同号："+borrowBackTaskVo.getBizCode();
                contReceipt.setMemo(memo);//备注
                //登录财务收款表
                contReceiptRepository.insertData(contReceipt);
                //工作流
                actRuTaskVo = ActFileBorrowBackTaskUtils.reviewComplete(borrowBackTaskVo.getTaskId());
            }else {
                Example example = SqlUtil.newExample(ContPay.class);
                example.createCriteria().andEqualTo("bizCode", borrowBackTaskVo.getBorrowBackTaskNo())
                        .andEqualTo("paymentType",BizTypeEnums.ORIG_BORROWED_BACK.getType());
                //删除原先财务付款表数据
                contPayRepository.deleteExampleData(example,new ContPay());
                //是否交押金为是且 是否抵扣租金为否的场合 录入财务付款表
                ContPay contPay = new ContPay();
                contPay.setPaymentType(BizTypeEnums.ORIG_BORROWED_BACK.getType());//业务类型 2-借阅押金
//                contPay.setBizCode(borrowBackTaskVo.getBizCode());//业务关联号
                contPay.setBizCode(borrowBackTaskVo.getBorrowBackTaskNo());//业务关联号
                contPay.setPayStatus(PayStatusEnums.TO_BE_WITHHELD.getType());//付款状态
                contPay.setPayFund(PayFundNameEnums.BORROW_DEP.getType());//款项名称 借阅押金
                contPay.setPayAmount(borrowBackTaskVo.getDepositAmount());//付款金额
                contPay.setRecAccBank(borrowBackTaskVo.getRecAccBank());//收款银行
                contPay.setRecAccBranch(borrowBackTaskVo.getRecAccBranch());//收款银行
                contPay.setRecAccountName(borrowBackTaskVo.getRecAccountName());//收款户名
                contPay.setRecAccountNo(borrowBackTaskVo.getRecAccountNo());//收款账号
                contPay.setRecEleBankNo(borrowBackTaskVo.getRecEleBankNo());//电子联行号
                //登录财务付款表
                contPayRepository.insertData(contPay);
                //工作流
                actRuTaskVo = ActFileBorrowBackTaskUtils.reviewAgree(borrowBackTaskVo.getTaskId());
            }
        }

        //更新借阅归还任务表状态
        //是否抵扣租金
        BorrowBackTask borrowBackTaskUpd = borrowBackTaskVo.getEntity();
        borrowBackTaskUpd.setPresentUser(actRuTaskVo.getNextAssignee());//下一节点审批人
        borrowBackTaskUpd.setBorrowBackTaskStatus(actRuTaskVo.getTaskCode());//借阅归还任务状态
        borrowBackTaskRepository.updateByPrimaryKeySelectiveData(borrowBackTaskUpd);
        if(actRuTaskVo.getEndFlag()){//工作流结束
            //流程结束时更新资料邮寄附件明细状态，清空借阅号，归还任务号
            this.updateOrigFileDetail(borrowBackTask.getBorrowTaskNo(),borrowBackTask.getBorrowBackTaskNo());
        }

        //审批日志登录
        this.workFlowCommon(sysUser.getUser(),borrowBackTaskVo.getBorrowBackTaskNo(),BizTypeEnums.ORIG_BORROWED_BACK.getType(),
                borrowBackTaskVo.getRemark(), APPROVAL.getType(),actRuTaskVo);

//        throw new FmsServiceException("111");
    }


    /**
     * @Title:
     * @Description: 回寄资管复核-退回
     * @param borrowBackTaskVo
     * @param sysUser
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @Transactional
    @Override
    public void borrowBackTaskExamineBack(BorrowBackTaskVo borrowBackTaskVo, SysUser sysUser) {
        ActRuTaskVo actRuTaskVo = ActFileBorrowBackTaskUtils.approvalReturnSuperior(borrowBackTaskVo.getTaskId());
        borrowBackTaskApprovalReturnSuperior(actRuTaskVo, borrowBackTaskVo.getBorrowBackTaskNo(), sysUser, borrowBackTaskVo.getRemark());
    }

    /**
     * @Description: 借阅资管复核--通过
     * @param: borrowTaskId
     * @return: BorrowTaskVo
     * @Author: lijunjun
     * @Date: 2018/5/22 15:59
     */
    @Transactional
    @Override
    public void borrowTaskReExamine(BorrowTaskVo borrowTaskVo, SysUser sysUser) {
        //资管复核工作流
        ActRuTaskVo actRuTaskVo = ActFileBorrowTaskUtils.borrowTaskReExamineAgree(borrowTaskVo.getTaskId());
        Example example = SqlUtil.newExample(BorrowTask.class);
        example.createCriteria().andEqualTo("borrowTaskNo", borrowTaskVo.getBorrowTaskNo());
        BorrowTask borrowTask = borrowTaskRepository.selectOneByExample(example);
        if (borrowTask == null){
            throw new FmsServiceException("当前借阅信息不存在");
        }
        borrowTaskVo.setPresentUser(actRuTaskVo.getNextAssignee());//下一节点审批人
        borrowTaskVo.setBorrowTaskStatus(actRuTaskVo.getTaskCode());//借阅任务状态

        List<OrigFileDetail> origFileDetailList = new ArrayList<>();
        if (ArrayUtils.isNotNullAndLengthNotZero(borrowTaskVo.getOrigFileDetailVoList())){
            for (OrigFileDetailVo origFileDetailVo : borrowTaskVo.getOrigFileDetailVoList()){
                //资管复核通过节点移动到邮寄节点之后
                origFileDetailVo.setOrigFileDetailStatus(OrigFileDetailStatusEnums.BE_BORROW.getType());//文件状态 借阅中
                origFileDetailList.add(origFileDetailVo.getEntity());
            }
        }
        //更新借阅信息表
        borrowTaskRepository.updateByPrimaryKeySelectiveData(borrowTaskVo.getEntity(), true);
        //更新归档明细表
        if (ArrayUtils.isNotNullAndLengthNotZero(origFileDetailList)){
            origFileDetailRepository.updateByPrimaryKeySelectiveDataList(origFileDetailList, true);
        }

        //审批日志登录
        this.workFlowCommon(sysUser.getUser(),borrowTaskVo.getBorrowTaskNo(),BizTypeEnums.BORROWED_DEPOSIT.getType(),
                borrowTaskVo.getRemark(), APPROVAL.getType(),actRuTaskVo);
    }

    /**
     * @Title:
     * @Description: 借阅资管复核-退回
     * @param borrowTaskVo
     * @param sysUser
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @Transactional
    @Override
    public void borrowTaskReExamineBack(BorrowTaskVo borrowTaskVo, SysUser sysUser) {
        ActRuTaskVo actRuTaskVo = ActFileBorrowTaskUtils.approvalReturnSuperior(borrowTaskVo.getTaskId());
        approvalReturnSuperior(actRuTaskVo, borrowTaskVo.getBorrowTaskNo(), sysUser, borrowTaskVo.getRemark());
    }

    /**
     * @Description: 资料邮寄
     * @param: borrowTaskVo
     * @Author: lijunjun
     * @Date: 2018/5/22 15:59
     */
    @Transactional
    @Override
    public void borrowTaskMail(BorrowTaskVo borrowTaskVo, SysUser sysUser) {
        Example example = SqlUtil.newExample(BorrowTask.class);
        example.createCriteria().andEqualTo("borrowTaskNo", borrowTaskVo.getBorrowTaskNo());
        BorrowTask borrowTask = borrowTaskRepository.selectOneByExample(example);
        if (borrowTask == null){
            throw new FmsServiceException("借阅任务信息不存在");
        }
        borrowTask.setPostComp(borrowTaskVo.getPostComp());//快递公司
        borrowTask.setPostDate(borrowTaskVo.getPostDate());//邮寄日期
        borrowTask.setPostNo(borrowTaskVo.getPostNo());//快递编号
        //资管邮寄资料工作流
        ActRuTaskVo actRuTaskVo = ActFileBorrowTaskUtils.borrowTaskMailAgree(borrowTaskVo.getTaskId());
        borrowTask.setPresentUser(actRuTaskVo.getNextAssignee());//下一节点审批人
        borrowTask.setBorrowTaskStatus(actRuTaskVo.getTaskCode());//借阅任务状态

        List<OrigFileDetail> origFileDetailList = new ArrayList<>();
        if (ArrayUtils.isNotNullAndLengthNotZero(borrowTaskVo.getOrigFileDetailVoList())){
            for (OrigFileDetailVo origFileDetailVo : borrowTaskVo.getOrigFileDetailVoList()){
                origFileDetailVo.setOrigFileDetailStatus(OrigFileDetailStatusEnums.BE_BORROWED.getType());//文件状态 已借出
//                origFileDetailVo.setDelFlag(DeleteFlags.EXIST.getFlag());
                origFileDetailList.add(origFileDetailVo.getEntity());
            }
        }
        //更新借阅任务表
        borrowTaskRepository.updateByPrimaryKeySelectiveData(borrowTask, true);
        //更新邮寄附件明细表
        if (ArrayUtils.isNotNullAndLengthNotZero(origFileDetailList)){
            origFileDetailRepository.updateByPrimaryKeySelectiveDataList(origFileDetailList, true);
        }

        //审批日志登录
        this.workFlowCommon(sysUser.getUser(),borrowTaskVo.getBorrowTaskNo(),BizTypeEnums.BORROWED_DEPOSIT.getType(),
                borrowTaskVo.getRemark(), SUBMIT.getType(),actRuTaskVo);

    }

    /**
     * @Description: 归还申请提交
     * @param: origFileBorrowTaskVo
     * @param: sysUser
     * @Author: lijunjun
     * @Date: 2018/5/22 15:59
     */
    @Transactional
    @Override
    public void borrowTaskMailConfirm(OrigFileBorrowTaskVo origFileBorrowTaskVo, SysUser sysUser) {
        if (StringUtils.isTrimBlank(origFileBorrowTaskVo.getBorrowTaskNo())){
            throw new FmsServiceException("借阅任务号不存在");
        }
        BorrowTaskVo borrowTask = borrowTaskService.findBorrowTaskByBorrowTaskNo(origFileBorrowTaskVo.getBorrowTaskNo());
        if (borrowTask == null){
            throw new FmsServiceException("借阅任务信息不存在");
        }
        BorrowBackTask borrowBackTask = new BorrowBackTask();
        if(StringUtils.isTrimBlank(origFileBorrowTaskVo.getTaskId())){
            borrowBackTask.setBorrowBackTaskNo(numGenerateService.getNumGenerateByNumType(NumTypeEnums.BORROW_BACK_TASK_NUM_TYPE.getType()));//借阅归还任务编号
        }else{
            borrowBackTask.setBorrowBackTaskNo(origFileBorrowTaskVo.getBorrowBackTaskNo());
        }
        borrowBackTask.setBorrowTaskNo(borrowTask.getBorrowTaskNo());//保存借阅任务号
        borrowBackTask.setDepositAmount(borrowTask.getDepositAmount());//押金金额
        borrowBackTask.setDepositFlag(borrowTask.getDepositFlag());//是否交押金
        borrowBackTask.setPostComp(origFileBorrowTaskVo.getPostComp());//快递公司
        borrowBackTask.setPostNo(origFileBorrowTaskVo.getPostNo());//快递编号
        borrowBackTask.setPostDate(origFileBorrowTaskVo.getPostDate());//邮寄日期
        borrowBackTask.setRemark(origFileBorrowTaskVo.getRemark());//备注

        List<OrigFileDetail> origFileDetailList = new ArrayList<>();
        for (OrigFileDetailVo origFileDetailVo : origFileBorrowTaskVo.getOrigFileDetailVoList()){
            origFileDetailVo.setOrigFileDetailStatus(OrigFileDetailStatusEnums.BACKING.getType());//文件状态 设定为归还中
            origFileDetailVo.setBorrowBackTaskNo(borrowBackTask.getBorrowBackTaskNo());//借阅归还任务号
            origFileDetailList.add(origFileDetailVo.getEntity());
        }
        //更新原件归档明细表
        origFileDetailRepository.updateByPrimaryKeySelectiveDataList(origFileDetailList, true);

        //更新借阅明细表
        BorrowTaskDetail borrowTaskDetail = new BorrowTaskDetail();
        borrowTaskDetail.setBorrowBackTaskNo(borrowBackTask.getBorrowBackTaskNo());
        Example example = SqlUtil.newExample(BorrowTaskDetail.class);
        example.createCriteria().andEqualTo("borrowTaskNo", borrowTask.getBorrowTaskNo());
        borrowTaskDetailRepository.updateByExampleSelectiveData(borrowTaskDetail, example);

        ActRuTaskVo actRuTaskVo;
        Map<String, Object> map = new HashMap<>();
        map.put("borrowTaskNo", origFileBorrowTaskVo.getBorrowTaskNo());
        map.put("borrowBackTaskNo", borrowBackTask.getBorrowBackTaskNo());
        if (StringUtils.isTrimBlank(origFileBorrowTaskVo.getTaskId())){
            //开启工作流
            actRuTaskVo = ActFileBorrowBackTaskUtils.startFileBorrowBackTask(borrowBackTask.getBorrowBackTaskNo(),
                    ActProcessInstanceKeyEnums.FILE_BORROW_BACK_TASK.getKey(), origFileBorrowTaskVo.getFileRecordNo(), map);
        }else{
            actRuTaskVo = ActFileBorrowBackTaskUtils.reviewAgree(origFileBorrowTaskVo.getTaskId());
        }
        //更新状态和下一步审批人
        borrowBackTask.setBorrowBackTaskStatus(actRuTaskVo.getTaskCode());
        borrowBackTask.setPresentUser(actRuTaskVo.getNextAssignee());
        if (StringUtils.isTrimBlank(origFileBorrowTaskVo.getTaskId())){
            //登陆借阅归还任务表
            borrowBackTaskRepository.insertData(borrowBackTask);
        }else{
            BorrowBackTask oldBorrowBackTask = borrowBackTaskService.findBorrowBackEntityByBorrowBackTaskNo(borrowBackTask.getBorrowBackTaskNo());
            if(oldBorrowBackTask == null){
                throw new FmsServiceException("归还任务不存在");
            }
            borrowBackTask.setBorrowBackTaskId(oldBorrowBackTask.getBorrowBackTaskId());
            borrowBackTaskRepository.updateByPrimaryKeySelectiveData(borrowBackTask);
        }
        if (!(YesNoFlagEnums.NO.getType().equals(origFileBorrowTaskVo.getDepositFlag())//是否交押金为否的场合
                || origFileBorrowTaskVo.getDepositAmount()==null || new BigDecimal("0").compareTo(origFileBorrowTaskVo.getDepositAmount())==0)){//或者押金金额为空或0
            if (YesNoFlagEnums.NO.getType().equals(origFileBorrowTaskVo.getDeductFlag())){
                //收款信息录入
                Example example1 = SqlUtil.newExample(ContPay.class);
                example1.createCriteria().andEqualTo("bizCode", borrowBackTask.getBorrowBackTaskNo())
                        .andEqualTo("paymentType",BizTypeEnums.ORIG_BORROWED_BACK.getType());
                //删除原先财务付款表数据
                contPayRepository.deleteExampleData(example1,new ContPay());
                //录入财务付款表
                ContPay contPay = new ContPay();
                contPay.setPaymentType(BizTypeEnums.ORIG_BORROWED_BACK.getType());//业务类型 2-借阅押金
//                contPay.setBizCode(borrowBackTaskVo.getBizCode());//业务关联号
                contPay.setBizCode(borrowBackTask.getBorrowBackTaskNo());//业务关联号
                contPay.setPayStatus(PayStatusEnums.TO_BE_WITHHELD.getType());//付款状态
                contPay.setPayFund(PayFundNameEnums.BORROW_DEP.getType());//款项名称 借阅押金
                contPay.setPayAmount(origFileBorrowTaskVo.getDepositAmount());//付款金额
                contPay.setRecAccBank(origFileBorrowTaskVo.getRecAccBank());//收款银行
                contPay.setRecAccBranch(origFileBorrowTaskVo.getRecAccBranch());//收款银行
                contPay.setRecAccountName(origFileBorrowTaskVo.getRecAccountName());//收款户名
                contPay.setRecAccountNo(origFileBorrowTaskVo.getRecAccountNo());//收款账号
                //contPay.setRecEleBankNo(origFileBorrowTaskVo.getRecEleBankNo());//电子联行号
                    //登录财务付款表
                    contPayRepository.insertData(contPay);
            }
        }

        //审批日志登录
        this.workFlowCommon(sysUser.getUser(),borrowBackTask.getBorrowBackTaskNo(),BizTypeEnums.ORIG_BORROWED_BACK.getType(),
                origFileBorrowTaskVo.getRemark(), SUBMIT.getType(),actRuTaskVo);
    }

    /**
     * @Title:
     * @Description: 财务收款确认
     * @param origFileBorrowFinanceVo
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     * @throws
     */
    @Transactional
    @Override
    public void receiptConfirm(OrigFileBorrowFinanceVo origFileBorrowFinanceVo, SysUser sysUser) {

        if (ArrayUtils.isNullOrLengthZero(origFileBorrowFinanceVo.getContReceiptVoList())){
            throw new FmsServiceException("请至少选一条收款银行信息");
        }

        if (StringUtils.isTrimBlank(origFileBorrowFinanceVo.getBorrowTaskNo())){
            throw new FmsServiceException("参数不正确");
        }
        //财务收款确认工作流
        ActRuTaskVo actRuTaskVo = ActFileBorrowTaskUtils.financeConfirmAgree(origFileBorrowFinanceVo.getTaskId());

        BorrowTaskVo borrowTask = borrowTaskService.findBorrowTaskByBorrowTaskNo(origFileBorrowFinanceVo.getBorrowTaskNo());
        if (borrowTask == null){
            throw new FmsServiceException("借阅信息不存在");
        }
        borrowTask.setPresentUser(actRuTaskVo.getNextAssignee());//下一节点审批人
        borrowTask.setBorrowTaskStatus(actRuTaskVo.getTaskCode());

        Example example1 = SqlUtil.newExample(ContCharge.class);
        example1.createCriteria().andEqualTo("chargeBizId", origFileBorrowFinanceVo.getBorrowTaskNo())
            .andEqualTo("chargeBizType",BizTypeEnums.BORROWED_DEPOSIT.getType());
        ContCharge contCharge = contChargeRepository.selectOneByExample(example1);
        if (contCharge == null){
            throw new FmsServiceException("财务待收款数据不存在");
        }
        contCharge.setChargeStatus(ChargeStatusEnums.COLLECTION.getType());//收款状态 1-已收款

        List<ContReceipt> contReceiptList = new ArrayList<>();
        List<ContReceiptExam> contReceiptExamList = new ArrayList<>();
        for (ContReceiptVo contReceiptVo : origFileBorrowFinanceVo.getContReceiptVoList()){
            ContReceipt contReceipt = new ContReceipt();
            contReceipt.setContReceiptId(UUIDUtils.getUUID());
            contReceipt.setInputMode(InputModeEnums.INPUT.getType());//数据来源 1-借阅收款录入
            contReceipt.setReceiptAmount(contReceiptVo.getReceiptAmount());//到账金额
            contReceipt.setRecAccBank(contReceiptVo.getRecAccBank());//收款银行
            contReceipt.setRecAccBranch(contReceiptVo.getRecAccBranch());//收款银行
            contReceipt.setRecAccountName(contReceiptVo.getRecAccountName());//收款户名
            contReceipt.setRecAccountNo(contReceiptVo.getRecAccountNo());//收款账号
            contReceipt.setRestAmount(BigDecimal.ZERO);//剩余金额
            contReceipt.setMemo(contReceiptVo.getMemo());//备注
            contReceipt.setReceiptDate(contReceiptVo.getReceiptDate());//到账日期
            contReceiptList.add(contReceipt);

            ContReceiptExam contReceiptExam = new ContReceiptExam();
            contReceiptExam.setReceiptBizType(ReceiptBizTypeEnums.TO_BE_FIN_RECEIPT.getType());//款项类型 3-财务代收款
            contReceiptExam.setReceiptBizId(contCharge.getContChargeId());//款项业务ID
            contReceiptExam.setContReceiptId(contReceipt.getContReceiptId());//财务收款ID
            contReceiptExam.setExamType(ExamTypeEnums.FIN_RECEIPT.getType());//勾稽状态 3-财务收款
            contReceiptExamList.add(contReceiptExam);
        }

        //更新借阅任务表
        borrowTaskRepository.updateByPrimaryKeySelectiveData(borrowTask.getEntity(), true);
        //更新财务待收款表
        contChargeRepository.updateByPrimaryKeySelectiveData(contCharge, true);
        if (ArrayUtils.isNotNullAndLengthNotZero(contReceiptList)){
            //登录财务收款表
            contReceiptRepository.insertDataList(contReceiptList);
        }
        if (ArrayUtils.isNotNullAndLengthNotZero(contReceiptExamList)){
            //登录财务勾稽表
            contReceiptExamRepository.insertDataList(contReceiptExamList);
        }

        //审批日志登录
        this.workFlowCommon(sysUser.getUser(),origFileBorrowFinanceVo.getBorrowTaskNo(),BizTypeEnums.BORROWED_DEPOSIT.getType(),
                origFileBorrowFinanceVo.getRemark(), APPROVAL.getType(),actRuTaskVo);
    }

    /**
     * @param origFileBorrowFinanceVo
     * @param sysUser
     * @throws
     * @Title:
     * @Description: 财务收款确认退回
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @Transactional
    @Override
    public void receiptConfirmBack(OrigFileBorrowFinanceVo origFileBorrowFinanceVo, SysUser sysUser) {
        ActRuTaskVo actRuTaskVo = ActFileBorrowTaskUtils.approvalReturnSuperior(origFileBorrowFinanceVo.getTaskId());
        approvalReturnSuperior(actRuTaskVo, origFileBorrowFinanceVo.getBorrowTaskNo(), sysUser, origFileBorrowFinanceVo.getRemark());
    }

    /**
     * @Title:
     * @Description: 归还财务制单
     * @param borrowBackTaskVo
     * @param sysUser
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @Transactional
    @Override
    public void borrowMakeVoucher(BorrowBackTaskVo borrowBackTaskVo, SysUser sysUser) {
        if (StringUtils.isTrimBlank(borrowBackTaskVo.getBorrowBackTaskNo())){
            throw new FmsServiceException("参数不正确");
        }
        Example example = SqlUtil.newExample(ContPay.class);
        example.createCriteria().andEqualTo("bizCode", borrowBackTaskVo.getBorrowBackTaskNo()).andEqualTo("paymentType", BizTypeEnums.ORIG_BORROWED_BACK.getType());
        ContPay contPay = contPayRepository.selectOneByExample(example);
        if (contPay == null){
            throw new FmsServiceException("财务付款信息不存在");
        }
        //工作流
        ActRuTaskVo actRuTaskVo = ActFileBorrowBackTaskUtils.reviewAgree(borrowBackTaskVo.getTaskId());
        contPay.setPayAccBank(borrowBackTaskVo.getPayAccBank());//付款银行
        contPay.setPayAccBranch(borrowBackTaskVo.getPayAccBranch());//付款银行
        contPay.setPayAccountName(borrowBackTaskVo.getPayAccountName());//付款银行户名
        contPay.setPayAccountNo(borrowBackTaskVo.getPayAccountNo());//付款账号
        contPay.setPayEleBankNo(borrowBackTaskVo.getPayEleBankNo());//电子联行号
        //更新财务付款表
        contPayRepository.updateByPrimaryKeySelectiveData(contPay);

        BorrowBackTask borrowBackTask = borrowBackTaskService.findBorrowBackEntityByBorrowBackTaskNo(borrowBackTaskVo.getBorrowBackTaskNo());
        if (borrowBackTask == null){
            throw new FmsServiceException("借阅归还任务信息不存在");
        }
        borrowBackTask.setPresentUser(actRuTaskVo.getNextAssignee());//下一节点审批人
        borrowBackTask.setBorrowBackTaskStatus(actRuTaskVo.getTaskCode());//归还任务状态
        //更新借阅归还任务表
        borrowBackTaskRepository.updateByPrimaryKeySelectiveData(borrowBackTask, true);

        //审批日志登录
        this.workFlowCommon(sysUser.getUser(),borrowBackTaskVo.getBorrowBackTaskNo(),BizTypeEnums.ORIG_BORROWED_BACK.getType(),
                borrowBackTaskVo.getRemark(), APPROVAL.getType(),actRuTaskVo);
    }

    /**
     * @Title:
     * @Description: 归还财务制单退回
     * @param borrowBackTaskVo
     * @param sysUser
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @Transactional
    @Override
    public void borrowMakeVoucherBack(BorrowBackTaskVo borrowBackTaskVo, SysUser sysUser) {
        ActRuTaskVo actRuTaskVo = ActFileBorrowBackTaskUtils.approvalReturnSuperior(borrowBackTaskVo.getTaskId());
        /*Example example = SqlUtil.newExample(ContPay.class);
        example.createCriteria().andEqualTo("bizCode", borrowBackTaskVo.getBizCode()).andEqualTo("paymentType",BizTypeEnums.BORROWED_DEPOSIT.getType());
        ContPay contPay = contPayRepository.selectOneByExample(example);
        //删除财务付款表数据
        contPayRepository.deleteData(contPay);*/
        borrowBackTaskApprovalReturnSuperior(actRuTaskVo, borrowBackTaskVo.getBorrowBackTaskNo(), sysUser, borrowBackTaskVo.getRemark());
    }

    /**
     * @Title:
     * @Description: 财务付款
     * @param borrowBackTaskVo
     * @param sysUser
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @Transactional
    @Override
    public void borrowPayment(BorrowBackTaskVo borrowBackTaskVo, SysUser sysUser) {
        ActRuTaskVo actRuTaskVo = ActFileBorrowBackTaskUtils.reviewAgree(borrowBackTaskVo.getTaskId());
        if (StringUtils.isTrimBlank(borrowBackTaskVo.getBorrowBackTaskNo())){
            throw new FmsServiceException("参数不正确");
        }
        Example example = SqlUtil.newExample(ContPay.class);
        example.createCriteria().andEqualTo("bizCode", borrowBackTaskVo.getBorrowBackTaskNo()).andEqualTo("paymentType", BizTypeEnums.ORIG_BORROWED_BACK.getType());
        ContPay contPay = contPayRepository.selectOneByExample(example);
        if (contPay == null){
            throw new FmsServiceException("财务付款信息不存在");
        }
        contPay.setPayStatus(PayStatusEnums.WITHDRAWING.getType());//付款状态
        contPayRepository.updateByPrimaryKeySelectiveData(contPay);

        BorrowBackTask borrowBackTask = borrowBackTaskService.findBorrowBackEntityByBorrowBackTaskNo(borrowBackTaskVo.getBorrowBackTaskNo());
        if (borrowBackTask == null){
            throw new FmsServiceException("借阅归还任务信息不存在");
        }

        if(actRuTaskVo.getEndFlag()){//工作流结束
            //流程结束时更新资料邮寄附件明细状态，清空借阅号，归还任务号
            this.updateOrigFileDetail(borrowBackTask.getBorrowTaskNo(),borrowBackTask.getBorrowBackTaskNo());
        }

        borrowBackTask.setPresentUser(actRuTaskVo.getNextAssignee());//下一节点审批人
        borrowBackTask.setBorrowBackTaskStatus(actRuTaskVo.getTaskCode());//归还任务状态
        //更新借阅归还任务表
        borrowBackTaskRepository.updateByPrimaryKeySelectiveData(borrowBackTask, true);

        //审批日志登录
        this.workFlowCommon(sysUser.getUser(),borrowBackTaskVo.getBorrowBackTaskNo(),BizTypeEnums.ORIG_BORROWED_BACK.getType(),
                borrowBackTaskVo.getRemark(), APPROVAL.getType(),actRuTaskVo);
    }

    /**
     * @Title:
     * @Description: 财务付款退回
     * @param borrowBackTaskVo
     * @param sysUser
     * @throws
     * @author lijunjun
     * @date 2018-5-3 11:26:40
     */
    @Transactional
    @Override
    public void borrowPaymentBack(BorrowBackTaskVo borrowBackTaskVo, SysUser sysUser) {
        ActRuTaskVo actRuTaskVo = ActFileBorrowBackTaskUtils.approvalReturnSuperior(borrowBackTaskVo.getTaskId());
        borrowBackTaskApprovalReturnSuperior(actRuTaskVo, borrowBackTaskVo.getBorrowBackTaskNo(), sysUser, borrowBackTaskVo.getRemark());
    }

    /**
     * @Title:
     * @Description: 借阅申请归还资管确认
     * @param borrowBackTaskVo
     * @param sysUser
     * @return
     * @throws
     * @author ningyangyang
     * @date 2018-8-6 11:26:39
     */
    @Override
    public void borrowBackTaskConfirm(BorrowBackTaskVo borrowBackTaskVo, SysUser sysUser) {
        ActRuTaskVo actRuTaskVo = ActFileBorrowBackTaskUtils.reviewAgree(borrowBackTaskVo.getTaskId());
        BorrowBackTask borrowBackTask = borrowBackTaskService.findBorrowBackEntityByBorrowBackTaskNo(borrowBackTaskVo.getBorrowBackTaskNo());
        if (borrowBackTask == null){
            throw new FmsServiceException("借阅归还任务信息不存在");
        }

        if(actRuTaskVo.getEndFlag()){//工作流结束
            //流程结束时更新资料邮寄附件明细状态，清空借阅号，归还任务号
            this.updateOrigFileDetail(borrowBackTask.getBorrowTaskNo(),borrowBackTask.getBorrowBackTaskNo());
        }

        borrowBackTask.setPresentUser(actRuTaskVo.getNextAssignee());//下一节点审批人
        borrowBackTask.setBorrowBackTaskStatus(actRuTaskVo.getTaskCode());//归还任务状态
        //更新借阅归还任务表
        borrowBackTaskRepository.updateByPrimaryKeySelectiveData(borrowBackTask, true);

        //审批日志登录
        this.workFlowCommon(sysUser.getUser(),borrowBackTaskVo.getBorrowBackTaskNo(),BizTypeEnums.ORIG_BORROWED_BACK.getType(),
                borrowBackTaskVo.getRemark(), APPROVAL.getType(),actRuTaskVo);
    }

    /** 
    * @Description: 审批日志录入
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/17 16:44
    */ 
    private void workFlowCommon(String user,String wflogNo,String type,String remark,String act,ActRuTaskVo actRuTaskVo){
        //审批日志登录
        WorkflowLog workflowLog = new WorkflowLog();
        workflowLog.setUser(user);
        workflowLog.setWfLogNo(wflogNo);
        workflowLog.setActWidgetId(RequestUtils.getRequestUri());
        workflowLog.setWfLogType(type);
        workflowLog.setRemark1(remark);
        workflowLog.setStatus(actRuTaskVo.getTaskCode());
        workflowLog.setActType(act);
        workflowLogService.insertWorkFlowLog(workflowLog);
    }

    /** 
    * @Description: 流程结束时更新资料邮寄附件明细
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/18 17:24
    */ 
    private void updateOrigFileDetail(String borrowTaskNo, String borrowBackTaskNo) {
        if(StringUtils.isTrimBlank(borrowTaskNo))
            throw new FmsServiceException("借阅号不能为空");
        if(StringUtils.isTrimBlank(borrowBackTaskNo))
            throw new FmsServiceException("归还任务号不能为空");
        OrigFileDetail origFileDetail = new OrigFileDetail();
        origFileDetail.setOrigFileDetailStatus(OrigFileDetailStatusEnums.BE_SORTED.getType());//已归档
        origFileDetail.setBorrowTaskNo("");
        origFileDetail.setBorrowBackTaskNo("");

        Example example = SqlUtil.newExample(OrigFileDetail.class);
        example.createCriteria().andEqualTo("borrowTaskNo", borrowTaskNo).andEqualTo("borrowBackTaskNo",borrowBackTaskNo);
        origFileDetailRepository.updateByExampleSelectiveData(origFileDetail,example);

    }

    /**
     * @Title:
     * @Description: 借阅归还付款单打印
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    @Transactional
    public String printBorrowTask(BorrowBackTaskVo borrowBackTaskVo){
        if(StringUtils.isNotTrimBlank(borrowBackTaskVo.getBorrowBackTaskNo())){
            //取待打印客户信息(不是续保业务类的数据)
            BorrowBackTaskVo borrowBackTaskVoForCstm = origFileDetailRepository.selectCustomerInformationByBorrowBackTaskNo(borrowBackTaskVo.getBorrowBackTaskNo(), OrigFileBizCodeTypeEnum.INSURANCE_TYPE.getType());
            //封装
            if(borrowBackTaskVoForCstm != null && borrowBackTaskVo != null){
                //承租人
                borrowBackTaskVo.setCstmName(borrowBackTaskVoForCstm.getCstmName());
                //出租人
                borrowBackTaskVo.setGroupName(borrowBackTaskVoForCstm.getGroupName());
                //车架号
                borrowBackTaskVo.setVinNo(borrowBackTaskVoForCstm.getVinNo());
            }else {
                throw new FmsServiceException("无法获取相关数据!");
            }
            //pdf的参数
            Map<String,String> pdfVariables = JsonUtils.objectToMap(borrowBackTaskVo);
            pdfVariables.put("nowDate", DateUtils.dateToStr(new Date(),DateUtils.formatStr_yyyyMMddChinese));
            if(borrowBackTaskVo.getDepositAmount()!=null){
                pdfVariables.put("depositAmount", StringUtils.defaultString(borrowBackTaskVo.getDepositAmount().toString()));
            }
            pdfVariables.put("recAccountName", StringUtils.defaultString(borrowBackTaskVo.getRecAccountName()));
            pdfVariables.put("recAccBranch", borrowBackTaskVo.getRecAccBank()+" "+borrowBackTaskVo.getRecAccBranch());
            pdfVariables.put("recAccountNo", borrowBackTaskVo.getRecAccountNo());
            pdfVariables.put("payAccountName", borrowBackTaskVo.getPayAccountName());
            if(borrowBackTaskVo.getPayAccBank()!= null && borrowBackTaskVo.getPayAccBranch()!=null){
                pdfVariables.put("payAccBranch", borrowBackTaskVo.getPayAccBank()+" "+borrowBackTaskVo.getPayAccBranch());
            }
            pdfVariables.put("payAccountNo", borrowBackTaskVo.getPayAccountNo());
            pdfVariables.put("groupName", borrowBackTaskVo.getGroupName());
            pdfVariables.put("cstmName", borrowBackTaskVo.getCstmName());
            pdfVariables.put("vinNo", borrowBackTaskVo.getVinNo());
            //输出pdf
            String filePath = commonPdfService.create(pdfVariables, TplTypeKeyEnums.WL_PAYMENT_BILL_BORROW_TASK.getType());
            return filePath;
        }else {
            throw new FmsServiceException("无法获取借阅归还任务号!");
        }
    }
}
