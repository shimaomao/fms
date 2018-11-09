package cn.com.leadu.fms.finance.service.impl;

import cn.com.leadu.fms.business.service.CommonConstantService;
import cn.com.leadu.fms.common.constant.CommonParamConstants;
import cn.com.leadu.fms.common.constant.enums.YesNoFlagEnums;
import cn.com.leadu.fms.common.constant.enums.finance.LicenseAttrEnums;
import cn.com.leadu.fms.common.constant.enums.finance.RepayTypeEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.InvoiceFlagEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.InvoiceStatusEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.InvoiceTypeEnums;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.BigDecimalUtils;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.finance.repository.FinRepaySkedRepository;
import cn.com.leadu.fms.data.postbiz.repository.InvoiceRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContRepaySkedRepository;
import cn.com.leadu.fms.finance.service.ContReceiptService;
import cn.com.leadu.fms.finance.service.FinRepaySkedService;
import cn.com.leadu.fms.finance.validator.finrepaysked.vo.FinRepaySkedDeleteListVo;
import cn.com.leadu.fms.finance.validator.finrepaysked.vo.FinRepaySkedDeleteVo;
import cn.com.leadu.fms.finance.validator.finrepaysked.vo.FinRepaySkedModifyVo;
import cn.com.leadu.fms.finance.validator.finrepaysked.vo.FinRepaySkedSaveVo;
import cn.com.leadu.fms.pojo.finance.entity.FinRepaySked;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import cn.com.leadu.fms.pojo.finance.vo.finrepaysked.FinRepaySkedVo;
import cn.com.leadu.fms.pojo.postbiz.entity.Invoice;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: FinRepaySkedService
 * @Description: 财务还款计划业务实现层
 * @date 2018-05-12
 */
@Service
public class FinRepaySkedServiceImpl implements FinRepaySkedService {

    /**
     * @Fields  : 财务还款计划repository
     */
    @Autowired
    private FinRepaySkedRepository finRepaySkedRepository;

    /**
     * @Fields  : 合同还款计划repository
     */
    @Autowired
    private ContRepaySkedRepository contRepaySkedRepository;

    /**
     * @Fields  : 开票信息Repository层
     */
    @Autowired
    private InvoiceRepository invoiceRepository;

    /**
     * @Fields  : 融资合同还款计划信息业务层
     */
    @Autowired
    private ContReceiptService contReceiptService;

    /**
     * CommonConstantService
     */
    @Autowired
    private CommonConstantService commonConstantService;

    /**
     * @Title:
     * @Description: 分页查询财务还款计划
     * @param finRepaySkedVo
     * @return PageInfoExtend<FinRepaySked>
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    public PageInfoExtend<ContRepaySkedVo> findFinRepaySkedsByPage(FinRepaySkedVo finRepaySkedVo){
//        Example example = SqlUtil.newExample(FinRepaySked.class);
//        Example.Criteria criteria = example.createCriteria();
//        if(StringUtils.isNotTrimBlank(finRepaySkedVo.getContNo())){
//            criteria.andLike("contNo",finRepaySkedVo.getContNo());
//        }
//        if(StringUtils.isNotTrimBlank(finRepaySkedVo.getStartTime())  && StringUtils.isNotTrimBlank(finRepaySkedVo.getEndTime())){
//            criteria.andBetween("repayDate",finRepaySkedVo.getStartTime(),finRepaySkedVo.getEndTime());
//        }else if(StringUtils.isNotTrimBlank(finRepaySkedVo.getStartTime()) && StringUtils.isTrimBlank(finRepaySkedVo.getEndTime())){
//            criteria.andGreaterThanOrEqualTo("repayDate",finRepaySkedVo.getStartTime());
//        }else if(StringUtils.isTrimBlank(finRepaySkedVo.getStartTime()) && StringUtils.isNotTrimBlank(finRepaySkedVo.getEndTime())){
//            criteria.andLessThanOrEqualTo("repayDate",finRepaySkedVo.getEndTime());
//        }
//        SqlUtil.setOrderByCreateTimeDesc(example);
//        SqlUtil.setOrderByColumnAsc(example,"cont_no","period");
        //业务类型
        if(StringUtils.isNotTrimBlank(finRepaySkedVo.getLicenseAttr())){
            finRepaySkedVo.setLicenseAttr(finRepaySkedVo.getLicenseAttr());
        }else{
            finRepaySkedVo.setLicenseAttr(null);
        }
        //应还款开始时间
        if(StringUtils.isNotTrimBlank(finRepaySkedVo.getStartTime())){
            finRepaySkedVo.setStartTime(finRepaySkedVo.getStartTime());
        }else{
            finRepaySkedVo.setStartTime(null);
        }
        //应还款结束时间
        if(StringUtils.isNotTrimBlank(finRepaySkedVo.getEndTime())){
            finRepaySkedVo.setEndTime(finRepaySkedVo.getEndTime());
        }else{
            finRepaySkedVo.setEndTime(null);
        }
        //实际还款日开始时间
        if(StringUtils.isNotTrimBlank(finRepaySkedVo.getStartTimeReceiptDate()))
            finRepaySkedVo.setStartTimeReceiptDate(finRepaySkedVo.getStartTimeReceiptDate());
        else
            finRepaySkedVo.setStartTimeReceiptDate(null);
        //实际还款日结束时间
        if(StringUtils.isNotTrimBlank(finRepaySkedVo.getEndTimeReceiptDate()))
            finRepaySkedVo.setEndTimeReceiptDate(finRepaySkedVo.getEndTimeReceiptDate());
        else
            finRepaySkedVo.setEndTimeReceiptDate(null);
        //地区
        if(StringUtils.isNotTrimBlank(finRepaySkedVo.getGroupDistrict())){
            finRepaySkedVo.setGroupDistrict(SqlUtil.likePattern(finRepaySkedVo.getGroupDistrict()));
        }else{
            finRepaySkedVo.setGroupDistrict(null);
        }
        //客户姓名
        if(StringUtils.isNotTrimBlank(finRepaySkedVo.getName())){
            finRepaySkedVo.setName(SqlUtil.likePattern(finRepaySkedVo.getName()));
        }else{
            finRepaySkedVo.setName(null);
        }
        //扣款状态
        if(StringUtils.isNotTrimBlank(finRepaySkedVo.getRepayStatus())){
            finRepaySkedVo.setRepayStatus(finRepaySkedVo.getRepayStatus());
        }else{
            finRepaySkedVo.setRepayStatus(null);
        }
        //还款状态
        if(StringUtils.isNotTrimBlank(finRepaySkedVo.getPaymentSts()))
            finRepaySkedVo.setPaymentSts(finRepaySkedVo.getPaymentSts());
        else
            finRepaySkedVo.setPaymentSts(null);
        //逾期状态
        if(StringUtils.isNotTrimBlank(finRepaySkedVo.getOverdueStatus()))
            finRepaySkedVo.setOverdueStatus(finRepaySkedVo.getOverdueStatus());
        else
            finRepaySkedVo.setOverdueStatus(null);
        //开票状态
        if(StringUtils.isNotTrimBlank(finRepaySkedVo.getInvoiceStatus()))
            finRepaySkedVo.setInvoiceStatus(finRepaySkedVo.getInvoiceStatus());
        else
            finRepaySkedVo.setInvoiceStatus(null);
        //应还款日
        if(StringUtils.isNotTrimBlank(finRepaySkedVo.getReceDate())){
            finRepaySkedVo.setReceDate(finRepaySkedVo.getReceDate());
        }else{
            finRepaySkedVo.setReceDate(null);
        }
        //开票日期
        if(StringUtils.isNotTrimBlank(finRepaySkedVo.getInvoDate())){
            finRepaySkedVo.setInvoDate(finRepaySkedVo.getInvoDate());
        }else{
            finRepaySkedVo.setInvoDate(null);
        }
        //备注
        if(StringUtils.isNotTrimBlank(finRepaySkedVo.getMemo())){
            finRepaySkedVo.setMemo(SqlUtil.likePattern(finRepaySkedVo.getMemo()));
        }else{
            finRepaySkedVo.setMemo(null);
        }
        //合同编号
        if(StringUtils.isNotTrimBlank(finRepaySkedVo.getContNo())){
            finRepaySkedVo.setContNo(SqlUtil.likePattern(finRepaySkedVo.getContNo()));
        }else{
            finRepaySkedVo.setContNo(null);
        }
        //车架号
        if(StringUtils.isNotTrimBlank(finRepaySkedVo.getVinNo())){
            finRepaySkedVo.setVinNo(SqlUtil.likePattern(finRepaySkedVo.getVinNo()));
        }else{
            finRepaySkedVo.setVinNo(null);
        }
        //是否先开票
        if(StringUtils.isNotTrimBlank(finRepaySkedVo.getInvoiceProp()))
            finRepaySkedVo.setInvoiceProp(finRepaySkedVo.getInvoiceProp());
        else
            finRepaySkedVo.setInvoiceProp(null);
        finRepaySkedVo.setApplyType(ApplyTypeEnums.PERSON.getType());
        PageInfoExtend<ContRepaySkedVo> pageInfo = finRepaySkedRepository.selectListVoByPage("selectFinRepaySkedsByPage",finRepaySkedVo,finRepaySkedVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 保存财务还款计划
     * @param finRepaySkedSaveVo
     * @return java.lang.String
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    public void saveFinRepaySked(FinRepaySkedSaveVo finRepaySkedSaveVo){
        finRepaySkedRepository.insertData(finRepaySkedSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改财务还款计划
     * @param finRepaySkedModifyVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    public void modifyFinRepaySked(FinRepaySkedModifyVo finRepaySkedModifyVo){
        finRepaySkedRepository.updateByPrimaryKeySelectiveData(finRepaySkedModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过finRepaySkedId删除财务还款计划
     * @param finRepaySkedDeleteVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    public void deleteFinRepaySked(FinRepaySkedDeleteVo finRepaySkedDeleteVo){
        finRepaySkedRepository.deleteData(finRepaySkedDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过finRepaySkedId集合删除财务还款计划
     * @param finRepaySkedDeleteListVo
     * @return
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    public void deleteFinRepaySkedsByFinRepaySkedIds(FinRepaySkedDeleteListVo finRepaySkedDeleteListVo){
        finRepaySkedRepository.deleteDataList(finRepaySkedDeleteListVo.getFinRepaySkedIds(),finRepaySkedDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据finRepaySkedId获取财务还款计划
     * @param finRepaySkedId
     * @return FinRepaySked
     * @throws
     * @author lijunjun
     * @date 2018-5-12 16:40:57
     */
    public FinRepaySked findFinRepaySkedByFinRepaySkedId(String finRepaySkedId){
        return finRepaySkedRepository.selectByPrimaryKey(finRepaySkedId);
    }

    /**
     * @Title:
     * @Description: 开具发票
     * @param contRepaySkedVos
     * @return java.lang.String
     * @throws
     * @author ningyangyang
     * @date 2018-8-21 16:40:57
     */
    public void finRepaySkedInvoice(List<ContRepaySkedVo> contRepaySkedVos){
        BigDecimal invoiceTax6;
        BigDecimal invoiceTax16;
        //获取税率
        try {
            //税率16
            invoiceTax16 = new BigDecimal(commonConstantService.findSysParamValue(CommonParamConstants.INVOICE_TAX_16));
            //税率6
            invoiceTax6 = new BigDecimal(commonConstantService.findSysParamValue(CommonParamConstants.INVOICE_TAX_6));
        } catch (Exception e) {
            throw new FmsServiceException("获取开票税率失败");
        }
        //待插入的开票信息
        List<Invoice> addInvoice = new ArrayList<>();
        //待更新的开票信息
        List<Invoice> updateInvoice = new ArrayList<>();
        for (ContRepaySkedVo contrepaySkedVo : contRepaySkedVos) {
            //开票类型，默认是租金
            String invoiceType = InvoiceTypeEnums.RENT.getType();
            if(RepayTypeEnums.INIT_AMOUNT.getType().equals(contrepaySkedVo.getRepayType())){
                invoiceType = InvoiceTypeEnums.INIT_AMOUNT.getType();
            } else if (RepayTypeEnums.FINAL_AMOUNT.getType().equals(contrepaySkedVo.getRepayType())) {
                invoiceType = InvoiceTypeEnums.FINAL_AMOUNT.getType();
            }
//            Invoice invoice  = new Invoice();
            //查询开票信息
            Invoice invoice = contReceiptService.findInvoice(invoiceType,contrepaySkedVo.getContNo(),contrepaySkedVo.getPeriod()+"");
            invoice.setInvoiceDataType(invoiceType);
            invoice.setContNo(contrepaySkedVo.getContNo());
            invoice.setDetailNo(contrepaySkedVo.getPeriod()+"");
            invoice.setInvoiceMemo(contrepaySkedVo.getInvoiceMemo());//开票备注
            invoice.setInvoiceDate(contrepaySkedVo.getInvoiceDate());//开票日期
            invoice.setReceiveDate(contrepaySkedVo.getReceiptDate());//收款日期
            invoice.setInvoiceAmount(contrepaySkedVo.getInvoiceAmount());//开票金额
            if (StringUtils.isTrimBlank(invoice.getInvoiceVoucherStatus())) {
                invoice.setInvoiceVoucherStatus(YesNoFlagEnums.NO.getType());//未生成凭证
            }
            //回租赁税率6
            if (LicenseAttrEnums.LEASE_BACK.getType().equals(contrepaySkedVo.getLicenseAttr())) {
                invoice.setInvoiceTax(invoiceTax6);
                invoice.setReceiveAccount(contrepaySkedVo.getRentActual());//应收金额=实际租金
                invoice.setReceiveActualAccount(contrepaySkedVo.getReceiptAmount());//实收金额=实收金额
            }else{
                invoice.setInvoiceTax(invoiceTax16);
                invoice.setReceiveAccount(contrepaySkedVo.getRentActual());//应收金额=实际租金
                invoice.setReceiveActualAccount(contrepaySkedVo.getReceiptAmount());//实收金额
            }
            //开票金额大于0时才做处理
            if (BigDecimalUtils.getNotNullBigDecimal(invoice.getInvoiceAmount()).compareTo(BigDecimal.ZERO) > 0) {
                invoice.setInvoiceStatus(InvoiceStatusEnums.INVOICE.getStatus());//已开票
                invoice.setInvoiceFlag(InvoiceFlagEnums.MANUAL.getStatus());//手动开票
            }
            if (StringUtils.isTrimBlank(invoice.getInvoiceId())) {
                addInvoice.add(invoice);
            }else{
                updateInvoice.add(invoice);
            }
        }
        //插入开票信息
        invoiceRepository.insertDataList(addInvoice);
        //更新开票信息
        invoiceRepository.updateByPrimaryKeySelectiveDataList(updateInvoice);
    }

    /**
    * @Description: 批量修改开票属性
    * @param:
    * @return:
    * @Author: yangyiquan
    * @Date: 2018/9/25 11:49
    */
    @Override
    public void editInvoiceProp(FinRepaySkedVo finRepaySkedVo) {
        contRepaySkedRepository.updateByPrimaryKeySelectiveDataList(finRepaySkedVo.getContRepaySkedList());
    }

}
