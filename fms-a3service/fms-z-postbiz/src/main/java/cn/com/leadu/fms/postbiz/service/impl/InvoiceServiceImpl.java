package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.business.service.CommonConstantService;
import cn.com.leadu.fms.business.service.CommonFinancialVoucherDataService;
import cn.com.leadu.fms.business.vo.CommonFinVouData;
import cn.com.leadu.fms.common.constant.CommonCodeTypeConstants;
import cn.com.leadu.fms.common.constant.CommonParamConstants;
import cn.com.leadu.fms.common.constant.FinVouDetailValueConstants;
import cn.com.leadu.fms.common.constant.enums.YesNoFlagEnums;
import cn.com.leadu.fms.common.constant.enums.finance.LicenseAttrEnums;
import cn.com.leadu.fms.common.constant.enums.finance.VoucherTypeEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.InvoiceFlagEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.InvoiceStatusEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.InvoiceTypeEnums;
import cn.com.leadu.fms.common.constant.enums.prebiz.ApplyTypeEnums;
import cn.com.leadu.fms.common.constant.enums.thirdinterface.GoldenTaxInvoiceTypeEnums;
import cn.com.leadu.fms.common.constant.enums.thirdinterface.GoldenTaxResultEnums;
import cn.com.leadu.fms.common.exception.FmsRpcException;
import cn.com.leadu.fms.common.exception.FmsServiceException;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.InvoiceAutoRepository;
import cn.com.leadu.fms.data.postbiz.repository.InvoiceRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContRepaySkedRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContractFinanceRepository;
import cn.com.leadu.fms.data.prebiz.repository.ContractRepository;
import cn.com.leadu.fms.extend.common.util.ResponseEntityUtils;
import cn.com.leadu.fms.pojo.postbiz.entity.Invoice;
import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceAuto;
import cn.com.leadu.fms.pojo.postbiz.vo.invoice.InvoicePrintinvResultVo;
import cn.com.leadu.fms.pojo.postbiz.vo.invoice.InvoiceResultVo;
import cn.com.leadu.fms.pojo.postbiz.vo.invoice.InvoiceVo;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepaySked;
import cn.com.leadu.fms.pojo.prebiz.vo.contract.ContractVo;
import cn.com.leadu.fms.pojo.prebiz.vo.contrequestpay.ContRequestPayVo;
import cn.com.leadu.fms.pojo.system.entity.SysUser;
import cn.com.leadu.fms.pojo.thirdinterface.vo.goldentax.*;
import cn.com.leadu.fms.postbiz.rpc.system.SysParamRpc;
import cn.com.leadu.fms.postbiz.rpc.thirdinterface.GoldenTaxRpc;
import cn.com.leadu.fms.postbiz.service.InvoiceAutoService;
import cn.com.leadu.fms.postbiz.service.InvoiceService;
import cn.com.leadu.fms.postbiz.validator.invoice.vo.InvoiceDeleteListVo;
import cn.com.leadu.fms.postbiz.validator.invoice.vo.InvoiceDeleteVo;
import cn.com.leadu.fms.postbiz.validator.invoice.vo.InvoiceModifyVo;
import cn.com.leadu.fms.postbiz.validator.invoice.vo.InvoiceSaveVo;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.math.BigDecimal;
import java.util.*;

/**
 * @author yangyiquan
 * @ClassName: InvoiceService
 * @Description: 开票信息业务实现层
 */
@Slf4j
@Service
public class InvoiceServiceImpl implements InvoiceService {

    /**
     * @Fields  : 开票信息repository
     */
    @Autowired
    private InvoiceRepository invoiceRepository;

    /**
     * @Fields  : 金税rpc
     * @author qiaomengnan
     */
    @Autowired
    private GoldenTaxRpc goldenTaxRpc;

    /**
     * @Fields  : 常量值
     * @author qiaomengnan
     */
    @Autowired
    private CommonConstantService commonConstantService;

    /**
     * @Fields  : 自动开票service
     * @author qiaomengnan
     */
    @Autowired
    private InvoiceAutoService invoiceAutoService;

    /**
     * @Fields  : 合同融资信息repository
     */
    @Autowired
    private ContractFinanceRepository contractFinanceRepository;

    /**
     * @Fields  : 财务凭证明细共通
     * @author qiaomengnan
     */
    @Autowired
    private CommonFinancialVoucherDataService commonFinancialVoucherDataService;

    /**
     * @Fields  : 合同信息repository
     */
    @Autowired
    private ContractRepository contractRepository;

    /**
     * @Fields  : 客户还款计划表Repository层
     */
    @Autowired
    private ContRepaySkedRepository contRepaySkedRepository;

    /**
     * @Fields  : 系统常量rpc接口
     */
    @Autowired
    private SysParamRpc sysParamRpc;

    /**
     * @Fields  : 自动开票repository
     */
    @Autowired
    private InvoiceAutoRepository invoiceAutoRepository;

    /**
     * @Title:
     * @Description: 分页查询开票信息
     * @param invoiceVo
     * @return PageInfoExtend<Invoice>
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    public PageInfoExtend<InvoiceVo> findInvoiceVosByPage(InvoiceVo invoiceVo){
        //设置个人申请类型
        invoiceVo.setApplyTypePerson(ApplyTypeEnums.PERSON.getType());
        //设置发票类型为普票
        invoiceVo.setCstmInvoiceType(InvoiceTypeEnums.UNIVERSAL_TICKET.getType());
        //开票区分
        invoiceVo.setJugInvoiceFlag(InvoiceFlagEnums.AUTO.getStatus());
        //合同号
        if(StringUtils.isTrimBlank(invoiceVo.getContNo()))
            invoiceVo.setContNo(null);
        else
            invoiceVo.setContNo(SqlUtil.likePattern(invoiceVo.getContNo()));
        //车架号
        if(StringUtils.isTrimBlank(invoiceVo.getVinNo()))
            invoiceVo.setVinNo(null);
        else
            invoiceVo.setVinNo(SqlUtil.likePattern(invoiceVo.getVinNo()));
        //开票类型
        if(StringUtils.isTrimBlank(invoiceVo.getInvoiceDataType()))
            invoiceVo.setInvoiceDataType(null);
        //承租人
        if(StringUtils.isTrimBlank(invoiceVo.getLessee()))
            invoiceVo.setLessee(null);
        else
            invoiceVo.setLessee(SqlUtil.likePattern(invoiceVo.getLessee()));
        //出租人
        if(StringUtils.isTrimBlank(invoiceVo.getLessor()))
            invoiceVo.setLessor(null);
        else
            invoiceVo.setLessor(SqlUtil.likePattern(invoiceVo.getLessor()));
        //出租人区域
        if(StringUtils.isTrimBlank(invoiceVo.getGroupDistrict()))
            invoiceVo.setGroupDistrict(null);
        else
            invoiceVo.setGroupDistrict(SqlUtil.likePattern(invoiceVo.getGroupDistrict()));
        //业务类型
        if(StringUtils.isTrimBlank(invoiceVo.getLicenseAttr()))
            invoiceVo.setLicenseAttr(null);
        else
            invoiceVo.setLicenseAttr(invoiceVo.getLicenseAttr());
        //收款日期开始
        if(StringUtils.isTrimBlank(invoiceVo.getBeginReceiveDate()))
            invoiceVo.setBeginReceiveDate(null);
        //收款日期结束
        if(StringUtils.isTrimBlank(invoiceVo.getEndReceiveDate()))
            invoiceVo.setEndReceiveDate(null);
        //开票状态
        if(StringUtils.isTrimBlank(invoiceVo.getInvoiceStatus()))
            invoiceVo.setInvoiceStatus(null);
        //开票状态
        if(StringUtils.isTrimBlank(invoiceVo.getInvoiceType()))
            invoiceVo.setInvoiceType(null);
        //是否打印
        if(StringUtils.isTrimBlank(invoiceVo.getPrintStatus()))
            invoiceVo.setPrintStatus(null);
        //开票区分
        if(StringUtils.isTrimBlank(invoiceVo.getInvoiceFlag()))
            invoiceVo.setInvoiceFlag(null);
        //开票日期开始时间
        if(StringUtils.isTrimBlank(invoiceVo.getStartTime2()))
            invoiceVo.setStartTime2(null);
        //开票日期结束时间
        if(StringUtils.isTrimBlank(invoiceVo.getEndTime2()))
            invoiceVo.setEndTime2(null);
        return invoiceRepository.selectListVoByPage("selectInvoiceVos",invoiceVo,invoiceVo.getPageQuery());
    }

    /**
     * @Title:
     * @Description:   手动开票
     * @param invoiceVos
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/12 12:41:48
     */
    @Transactional
    public void invoiceManual(List<InvoiceVo> invoiceVos){
        //验证值
        invoiceVos = checkInvoiceManual(invoiceVos);
        //保存开票信息
        invoiceRepository.updateByPrimaryKeySelectiveDataList(EntityUtils.getEntitys(invoiceVos,Invoice.class),true);
    }

    /**
     * @Title:
     * @Description:   检查手动开票的值
     * @param invoiceVos
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/12 12:42:24
     */
    private List<InvoiceVo> checkInvoiceManual(List<InvoiceVo> invoiceVos){
        List<InvoiceVo> newInvoiceVos = new ArrayList<>();
        for(InvoiceVo invoiceVo : invoiceVos){
            String msg = String.format("合同号: %s , ",invoiceVo.getContNo());
            if(StringUtils.isTrimBlank(invoiceVo.getInvoiceId()))
                throw new FmsServiceException(String.format("%s未获取到ID信息",msg));

            if((invoiceVo.getInvoiceDate() == null && BigDecimalUtils.getNotNullBigDecimal(invoiceVo.getInvoiceAmount()).compareTo(BigDecimal.ZERO)>0)
                    || (invoiceVo.getInvoiceDate() != null && BigDecimalUtils.getNotNullBigDecimal(invoiceVo.getInvoiceAmount()).compareTo(BigDecimal.ZERO)<=0))
                throw new FmsServiceException(String.format("%s开票日期和金额必须同时存在",msg));

            if(StringUtils.isNotTrimBlank(invoiceVo.getInvoiceStatus()) && !InvoiceStatusEnums.NO_INVOICE.getStatus().equals(invoiceVo.getInvoiceStatus()))
                throw new FmsServiceException(String.format("%s已经开票,不能重复开票",msg));
            //重新放入对象,只更新需要更新的值
            InvoiceVo newInvoiceVo = new InvoiceVo();
            newInvoiceVo.setInvoiceId(invoiceVo.getInvoiceId());
            newInvoiceVo.setInvoiceDate(invoiceVo.getInvoiceDate());
            newInvoiceVo.setInvoiceAmount(invoiceVo.getInvoiceAmount());
            newInvoiceVo.setInvoiceMemo(invoiceVo.getInvoiceMemo());
            newInvoiceVo.setUpdateTime(invoiceVo.getUpdateTime());
            //开票金额大于0时才做处理
            if (BigDecimalUtils.getNotNullBigDecimal(invoiceVo.getInvoiceAmount()).compareTo(BigDecimal.ZERO) > 0) {
                newInvoiceVo.setInvoiceStatus(InvoiceStatusEnums.INVOICE.getStatus());
                newInvoiceVo.setInvoiceFlag(InvoiceFlagEnums.MANUAL.getStatus());
            }
            newInvoiceVos.add(newInvoiceVo);
        }
        return newInvoiceVos;
    }

    /**
     * @Title:
     * @Description:   发票作废
     * @param invoiceIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/12 01:38:20
     */
    @Transactional
    public void cancelInvoice(List<String> invoiceIds){
        //验证是否传入了开票id
        if(ArrayUtils.isNullOrLengthZero(invoiceIds)) {
            throw new FmsServiceException("请传入需要作废的开票ID");
        }
        //查出开票信息
        Example example = SqlUtil.newExample(Invoice.class);
        example.createCriteria().andIn("invoiceId",invoiceIds);
        List<Invoice> invoices = invoiceRepository.selectListByExample(example);
        //存在数据
        if(ArrayUtils.isNotNullAndLengthNotZero(invoices)){
            //开票号码集合
            List<String> invoiceNos = new ArrayList<>();
            //check开票信息是否有未开票的状态
            for(Invoice invoice : invoices) {
                if(invoice != null) {
                    String msg = String.format("合同号: %s , ",invoice.getContNo());
                    //如果包含未开票的，抛错通知
                    if(StringUtils.isTrimBlank(invoice.getInvoiceStatus()) || InvoiceStatusEnums.NO_INVOICE.getStatus().equals(invoice.getInvoiceStatus())){
                        throw new FmsServiceException(String.format("%s还未开票,无法作废",msg));
                    }else{
                        //记录开票号码
                        List<String> tmpInvoiceNos = StringUtils.splitCommaToList(invoice.getInvoiceNo());
                        if(ArrayUtils.isNotNullAndLengthNotZero(tmpInvoiceNos))
                            invoiceNos.addAll(tmpInvoiceNos);

                    }
                }
            }
            // 更新勾选的发票信息
            updateInvoice(invoices);
            if(ArrayUtils.isNotNullAndLengthNotZero(invoiceNos)){
                //将包含开票号的数据全部查询出来
                example = SqlUtil.newExample(Invoice.class);
                Example.Criteria criteria = example.createCriteria();
                for(String invoiceNo : invoiceNos) {
                    criteria.orLike("invoiceNo",SqlUtil.likePattern(invoiceNo));
                }
                invoices = invoiceRepository.selectListByExample(example);
                //开票号码的所有开票信息
                updateInvoice(invoices);
            }
        }
    }



    /**
     * @Title:
     * @Description:   自动开票
     * @param invoiceIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/12 02:42:21
     */
    public InvoiceResultVo autoManual(List<String> invoiceIds,SysUser sysUser) {
        //check数据
        List<InvoiceVo> invoiceVos = checkAutoManual(invoiceIds);
        //超过指定金额的数据
        List<InvoiceVo> maxInvoiceVos = new ArrayList<>();
        //返回发票信息
        List<GoldenTaxInvoiceSendVo> invoiceSendVos = getGoldenTaxInvoiceSendVos(invoiceVos,maxInvoiceVos);
        //记录发送成功的信息
        List<GoldenTaxInvoiceSendVo> successSendVos = new ArrayList<>();
        //组合发送是否发送成功
        boolean sendErrorRes = false;
        //返回结果
        InvoiceResultVo invoiceResultVo = new InvoiceResultVo();
        if(ArrayUtils.isNotNullAndLengthNotZero(invoiceSendVos)){
            for(GoldenTaxInvoiceSendVo sendVo : invoiceSendVos){
                if(sendVo != null && sendVo.getOrder() != null && ArrayUtils.isNotNullAndLengthNotZero(sendVo.getOrder().getDetail())){
                    try{
                        //构建数据并发送
                        GoldenTaxInvoiceResultVo resultVo = ResponseEntityUtils.getRestResponseData(goldenTaxRpc.invoice(sendVo));
                        //判断是否成功,成功后保存到成功记录中
                        if(GoldenTaxResultEnums.INVOICE_SUCCESS.getResult().equals(resultVo.getCode())){
                            sendVo.setGoldenTaxInvoiceResultVo(resultVo);
                            successSendVos.add(sendVo);
                        }else{
                            //失败
                            sendErrorRes = true;
                            invoiceResultVo.setErrorCode(resultVo.getCode());
                            invoiceResultVo.setErrorMsg(resultVo.getMessage());
                        }
                    }catch (Exception ex){
                        //如果失败了的话 退出继续发送
                        ex.printStackTrace();
                        log.error(ex.getMessage());
                        sendErrorRes = true;
                        invoiceResultVo.setErrorMsg(ex.getMessage());
                    }
                    if(sendErrorRes){
                        //记录发送失败的开票信息
                        List<InvoiceVo> errorInvoiceVos = getInvoiceVos(sendVo);
                        if(ArrayUtils.isNotNullAndLengthNotZero(errorInvoiceVos))
                            invoiceResultVo.getErrorInvoiceVos().addAll(errorInvoiceVos);
                        //失败,退出继续发送
                        break;
                    }else{
                        //记录发送成功的开票信息
                        List<InvoiceVo> successInvoiceVos = getInvoiceVos(sendVo);
                        if(ArrayUtils.isNotNullAndLengthNotZero(successInvoiceVos))
                            invoiceResultVo.getSuccessInvoiceVos().addAll(successInvoiceVos);
                    }
                }
            }
        }

        //保存发送成功的组合信息
        List<InvoiceAuto> res = invoiceRepository.saveSendAutoManual(successSendVos,sysUser.getUser());
        if(ArrayUtils.isNotNullAndLengthNotZero(res))
            invoiceResultVo.getInvoiceAutos().addAll(res);

        //存在发送失败
        if(sendErrorRes){
            List<InvoiceVo> notSendInvoiceVos = getInvoiceVos(invoiceSendVos);
            //记录没有发送的开票信息
            if(ArrayUtils.isNotNullAndLengthNotZero(invoiceResultVo.getSuccessInvoiceVos()))
                notSendInvoiceVos.removeAll(invoiceResultVo.getSuccessInvoiceVos());
            if(ArrayUtils.isNotNullAndLengthNotZero(invoiceResultVo.getErrorInvoiceVos()))
                notSendInvoiceVos.removeAll(invoiceResultVo.getErrorInvoiceVos());
            //剔除发送成功的 和 失败的,剩下的就是没有发送的 //并且添加超过指定金额的数据
            notSendInvoiceVos.addAll(maxInvoiceVos);
            invoiceResultVo.setNotSendInvoiceVos(notSendInvoiceVos);

        }else{
            //处理超过指定金额的数据
            sendSuccessMaxInvoiceVoMaps(maxInvoiceVos,invoiceResultVo,sysUser);
        }
        //返回可以打印的信息
        return invoiceResultVo;
    }

    /**
     * @Title:
     * @Description:   处理超过指定金额的数据
     * @param maxInvoiceVos
     * @param invoiceResultVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/18 12:13:56
     */
    private void sendSuccessMaxInvoiceVoMaps(List<InvoiceVo> maxInvoiceVos,InvoiceResultVo invoiceResultVo,SysUser sysUser){
        //处理超过指定金额的数据
        if(ArrayUtils.isNotNullAndLengthNotZero(maxInvoiceVos)){
            //拆票
            Map<InvoiceVo,List<GoldenTaxInvoiceSendVo>> maxInvoiceVoMaps = new LinkedHashMap<>();
            for(InvoiceVo invoiceVo : maxInvoiceVos){
                //根据不同的开票类型 获取最大金额
                BigDecimal maxInvoiceAmount = getMaxInvoiceAmount(invoiceVo);
                //循环生成票,当前票的金额
                BigDecimal invoiceAmount = invoiceVo.getInvoiceAmount();
                List<GoldenTaxInvoiceSendVo> sendVos = new ArrayList<>();
                do{
                    GoldenTaxInvoiceSendVo sendVo =  getGoldenTaxInvoiceSendVo(invoiceVo);
                    if(BigDecimalUtils.gt(invoiceAmount,maxInvoiceAmount)){
                        invoiceAmount = invoiceAmount.subtract(maxInvoiceAmount);
                        sendVo.getOrder().getDetail().get(0).setListamount(maxInvoiceAmount);
                        sendVo.getOrder().getDetail().get(0).setListprice(maxInvoiceAmount);
                    }else{
                        sendVo.getOrder().getDetail().get(0).setListamount(invoiceAmount);
                        sendVo.getOrder().getDetail().get(0).setListprice(invoiceAmount);
                        invoiceAmount = invoiceAmount.subtract(maxInvoiceAmount);
                    }
                    sendVos.add(sendVo);
                }while (BigDecimalUtils.gt(invoiceAmount,BigDecimalUtils.getZero()));
                maxInvoiceVoMaps.put(invoiceVo,sendVos);
            }
            //保存已经发送成功的票
            Map<InvoiceVo,List<GoldenTaxInvoiceSendVo>> successMaxInvoiceVoMaps = new LinkedHashMap<>();
            //是否发送成功
            boolean sendErrorRes = false;
            for(InvoiceVo invoiceVo : maxInvoiceVoMaps.keySet()){
                List<GoldenTaxInvoiceSendVo>  invoiceSendVos = maxInvoiceVoMaps.get(invoiceVo);
                //当前开票信息的所有发票都发送成功，才可以算开票成功
                boolean res = true;
                for(GoldenTaxInvoiceSendVo sendVo : invoiceSendVos){
                    try{
                        //构建数据并发送
                        GoldenTaxInvoiceResultVo resultVo = ResponseEntityUtils.getRestResponseData(goldenTaxRpc.invoice(sendVo));
                        //判断是否成功,成功后保存到结果
                        if(GoldenTaxResultEnums.INVOICE_SUCCESS.getResult().equals(resultVo.getCode())){
                            sendVo.setGoldenTaxInvoiceResultVo(resultVo);
                        }else{
                            res = false;
                            invoiceResultVo.setErrorCode(resultVo.getCode());
                            invoiceResultVo.setErrorMsg(resultVo.getMessage());
                            //失败,退出继续发送
                            break;
                        }
                    }catch (Exception ex){
                        //如果失败了的话 退出继续发送
                        ex.printStackTrace();
                        log.error(ex.getMessage());
                        invoiceResultVo.setErrorMsg(ex.getMessage());
                        res = false;
                        break;
                    }
                }
                //所有票都发送成功
                if(res) {
                    invoiceResultVo.getSuccessInvoiceVos().add(invoiceVo);
                    successMaxInvoiceVoMaps.put(invoiceVo, invoiceSendVos);
                } else{
                    //没有发送成功,则进行退出继续开票
                    invoiceResultVo.getErrorInvoiceVos().add(invoiceVo);
                    sendErrorRes = true;
                    break;
                }
            }
            //保存发送成功的超额信息
            List<InvoiceAuto> res = invoiceRepository.saveMaxAutoManual(successMaxInvoiceVoMaps,sysUser.getUser());
            if(ArrayUtils.isNotNullAndLengthNotZero(res))
                invoiceResultVo.getInvoiceAutos().addAll(res);
            if(sendErrorRes){
                //存在发送失败,记录没有发送的开票信息
                List<InvoiceVo> invoiceVos = new ArrayList<>(maxInvoiceVoMaps.keySet());
                if(ArrayUtils.isNotNullAndLengthNotZero(invoiceResultVo.getSuccessInvoiceVos()))
                    invoiceVos.removeAll(invoiceResultVo.getSuccessInvoiceVos());
                if(ArrayUtils.isNotNullAndLengthNotZero(invoiceResultVo.getErrorInvoiceVos()))
                    invoiceVos.removeAll(invoiceResultVo.getErrorInvoiceVos());
                //剔除成功和失败的,剩下的就是没有发送的
                invoiceResultVo.setNotSendInvoiceVos(invoiceVos);
            }
        }
    }

    /**
     * @Title:
     * @Description:   验证自动开票的数据
     * @param invoiceIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/13 10:52:35
     */
    private List<InvoiceVo> checkAutoManual(List<String> invoiceIds){
        //验证是否传入了开票id
        if(ArrayUtils.isNullOrLengthZero(invoiceIds))
            throw new FmsServiceException("请传入需要开票的ID");
        InvoiceVo params = new InvoiceVo();
        //设置个人申请类型
        params.setApplyTypePerson(ApplyTypeEnums.PERSON.getType());
        //设置发票类型为普票
        params.setCstmInvoiceType(InvoiceTypeEnums.UNIVERSAL_TICKET.getType());
        //设置id集合
        params.setInvoiceIds(invoiceIds);
        List<InvoiceVo> invoiceVos = invoiceRepository.selectInvoiceVos(params);
        if(ArrayUtils.isNotNullAndLengthNotZero(invoiceVos)){
            for(InvoiceVo invoiceVo : invoiceVos) {
                String msg = String.format("合同号: %s , ",invoiceVo.getContNo());
                if(StringUtils.isNotTrimBlank(invoiceVo.getInvoiceStatus()) && !InvoiceStatusEnums.NO_INVOICE.getStatus().equals(invoiceVo.getInvoiceStatus()))
                    throw new FmsServiceException(String.format("%s已经开票,不能重复开票",msg));
            }
            return invoiceVos;
        }else
            throw new FmsServiceException("未查询到相关的开票信息");
    }

    /**
     * @Title:
     * @Description:  返回发票信息
     * @param invoiceVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/13 10:53:35
     */
    private GoldenTaxInvoiceVo getGoldenTaxInvoiceVo(InvoiceVo invoiceVo){
        GoldenTaxInvoiceVo goldenTaxInvoiceVo = new GoldenTaxInvoiceVo();
        //要开具的发票种类（0： 专用发票 1：废旧物资发票 2：普通发票）
        if(InvoiceTypeEnums.SPECIAL_TICKET.getType().equals(invoiceVo.getCstmInvoiceType()))
            goldenTaxInvoiceVo.setInfokind(GoldenTaxInvoiceTypeEnums.SPECIAL_TICKET.getType());
        else if (InvoiceTypeEnums.UNIVERSAL_TICKET.getType().equals(invoiceVo.getCstmInvoiceType()))
            goldenTaxInvoiceVo.setInfokind(GoldenTaxInvoiceTypeEnums.UNIVERSAL_TICKET.getType());
        else
            throw new FmsServiceException(String.format("合同号：%s,发票类型不存在,%s",invoiceVo.getContNo(),invoiceVo.getCstmInvoiceType()));
        //购方名称
        goldenTaxInvoiceVo.setInfoclientname(invoiceVo.getLessee());
        //开户行和账号
        goldenTaxInvoiceVo.setInfoclientbankaccount(StringUtils.isNotTrimBlank(invoiceVo.getBankName()) ? invoiceVo.getBankName() : ""
                + " " + (StringUtils.isNotTrimBlank(invoiceVo.getAccountNumber()) ? invoiceVo.getAccountNumber() : ""));
        //地址和电话
        goldenTaxInvoiceVo.setInfoclientaddressphone(invoiceVo.getInvoiceAddr());
        //购方名称
        goldenTaxInvoiceVo.setInfoclientname(invoiceVo.getLessee());
        //开票人
        goldenTaxInvoiceVo.setInfoinvoicer(commonConstantService.findSysParamValue(CommonParamConstants.GT_INFO_INVOICER));
        //购方税号
        goldenTaxInvoiceVo.setInfoclienttaxcode(invoiceVo.getDutyParagraph());
        //复核人
        goldenTaxInvoiceVo.setInfochecker(commonConstantService.findSysParamValue(CommonParamConstants.GT_INFO_CHECKER));
        //收款人
        goldenTaxInvoiceVo.setInfocashier(commonConstantService.findSysParamValue(CommonParamConstants.GT_INFO_CASHIER));
        //备注
        goldenTaxInvoiceVo.setInfonotes(invoiceVo.getInfonotes());
        return goldenTaxInvoiceVo;
    }

    /**
     * @Title:
     * @Description:   返回发票明细信息
     * @param invoiceVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/13 10:53:39
     */
    private GoldenTaxInvoiceDetailVo getGoldenTaxInvoiceDetailVo(InvoiceVo invoiceVo){
        GoldenTaxInvoiceDetailVo detail = new GoldenTaxInvoiceDetailVo();
        //商品或劳务名称
        detail.setListgoodsname(commonConstantService.findSysParamValue(CommonParamConstants.GT_LIST_GOODS_NAME));
        //单位
        detail.setListunit(commonConstantService.findSysParamValue(CommonParamConstants.GT_LIST_UNIT));
        //数量
        detail.setListnumber(commonConstantService.findSysParamValue(CommonParamConstants.GT_LIST_NUMBER));
        //单价
        detail.setListprice(invoiceVo.getInvoiceAmount() == null ? new BigDecimal("0"):invoiceVo.getInvoiceAmount());
        //金额
        detail.setListamount(invoiceVo.getInvoiceAmount() == null ? new BigDecimal("0"):invoiceVo.getInvoiceAmount());
        //含税价标志，单价和金额的种类，0 为不含税价，1 为含税价
        detail.setListpricekind(null);
        //税率，17、13、6、4 等
        detail.setInfotaxrate(invoiceVo.getInvoiceTax() == null ? "0":StringUtils.getValue(invoiceVo.getInvoiceTax().intValue()));
        //存放对应的开票信息
        detail.setInvoiceVo(invoiceVo);
        //编码版本号
        detail.setGoodsnover(commonConstantService.findSysParamValue(CommonParamConstants.GT_GOODS_NOVER));
        //税收分类编码
        detail.setGoodstaxno(commonConstantService.findSysParamValue(CommonParamConstants.GT_GOODS_TAXNO));
        return detail;
    }

    /**
     * @Title:
     * @Description:   返回一张发票
     * @param invoiceVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/13 04:45:54
     */
    private GoldenTaxInvoiceSendVo getGoldenTaxInvoiceSendVo(InvoiceVo invoiceVo){
        GoldenTaxInvoiceSendVo sendVo = new GoldenTaxInvoiceSendVo();
        sendVo.setOrder(getGoldenTaxInvoiceVo(invoiceVo));
        sendVo.getOrder().getDetail().add(getGoldenTaxInvoiceDetailVo(invoiceVo));
        return sendVo;
    }

    /**
     * @Title:
     * @Description:   返回需要发送的发票
     * @param invoiceVos
     * @param maxInvoiceVos
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/13 04:48:29
     */
    private List<GoldenTaxInvoiceSendVo> getGoldenTaxInvoiceSendVos(List<InvoiceVo> invoiceVos,List<InvoiceVo> maxInvoiceVos){
        String maxNumber;
        //获取每张发票明细的最大条数
        try {
            maxNumber =  ResponseEntityUtils.getRestResponseData(sysParamRpc.findParamValueByParamKey(CommonParamConstants.MAX_DETAIL_NUMBER));
        } catch (FmsRpcException ex) {
            log.error(ex.getMessage());
            ex.printStackTrace();
            throw new FmsServiceException("获取系统常量失败");
        }
        if(ArrayUtils.isNotNullAndLengthNotZero(invoiceVos)){
            //构建开票信息 开票类型 承租人 发票类型 相同的为一张发票  每组金额加起来不能超过设定的总经额
            Map<String,List<GoldenTaxInvoiceSendVo>> invoiceSendVosMap = new HashMap<>();
            //构建备注信息  开票类型、承租人、发票类型为key,value为开票类型、承租人、合同号、明细
            Map<String,HashSet<String>> infoNoteList = new HashMap<>();
            for(InvoiceVo invoiceVo : invoiceVos) {
                if(invoiceVo != null) {
                    //key
                    String key = String.format("%s_%s_%s",invoiceVo.getInvoiceDataType(),invoiceVo.getCertifNo(),invoiceVo.getCstmInvoiceType());
                    HashSet<String> infoNotes = infoNoteList.get(key);
                    //备注信息
                    String dataType = StringUtils.isTrimBlank(invoiceVo.getInvoiceDataType()) ? "" : commonConstantService.findSysCodeValueName(CommonCodeTypeConstants.INVOICE_DATA_TYPE,invoiceVo.getInvoiceDataType()); //开票数据类型
                    String lessee = StringUtils.isTrimBlank(invoiceVo.getLessee()) ? "" : invoiceVo.getLessee(); //承租人
                    String contNo = StringUtils.isTrimBlank(invoiceVo.getContNo()) ? "" : invoiceVo.getContNo(); //合同号
                    String detailNo = StringUtils.isTrimBlank(invoiceVo.getDetailNo()) ? "" : invoiceVo.getDetailNo(); //明细信息
                    String note;
                    if(StringUtils.isTrimBlank(detailNo)){
                        note = String.format("%s_%s:%s;",dataType,lessee,contNo);
                    } else {
                        note = String.format("%s_%s:%s_%s;",dataType,lessee,contNo,detailNo);
                    }
                    if(infoNotes == null || infoNotes.size() == 0){
                        infoNotes = new HashSet();
                        infoNotes.add(note);
                        infoNoteList.put(key,infoNotes);
                    } else {
                        infoNotes.add(note);
                        infoNoteList.put(key,infoNotes);
                    }
                    //需要根据不同的类型获取对应的最大金额
                    BigDecimal maxInvoiceAmount = getMaxInvoiceAmount(invoiceVo);
                    //此开票信息超过指定金额,做特殊处理
                    if(BigDecimalUtils.gt(invoiceVo.getInvoiceAmount(),maxInvoiceAmount)){
                        maxInvoiceVos.add(invoiceVo);
                    }else{
                        List<GoldenTaxInvoiceSendVo> goldenTaxInvoiceSendVos = invoiceSendVosMap.get(key);
                        //如果不存在该key,则创建,并默认将当前信息放入到发票中
                        if(ArrayUtils.isNullOrLengthZero(goldenTaxInvoiceSendVos)){
                            //保存相同key的发票集合
                            goldenTaxInvoiceSendVos = new ArrayList<>();
                            goldenTaxInvoiceSendVos.add(getGoldenTaxInvoiceSendVo(invoiceVo));
                            invoiceSendVosMap.put(key,goldenTaxInvoiceSendVos);
                        }else{
                            //累加发票明细,如果超过设定值,则新开一张
                            boolean res = true;
                            for(GoldenTaxInvoiceSendVo sendVo : goldenTaxInvoiceSendVos){
                                //拿到当前的总金额
                                BigDecimal invoiceAmount = sendVo.getInvoiceAmount();
                                //当前总金额再加上本次的金额 得到发票最终的金额
                                invoiceAmount = invoiceAmount.add(invoiceVo.getInvoiceAmount());
                                //判断是否超过设定的最大金额或者明细数量是否大于指定数值
                                if(BigDecimalUtils.gt(invoiceAmount,maxInvoiceAmount) || (sendVo.getOrder().getDetail().size()>= IntegerUtils.getValue(maxNumber))){
                                    //超过最大金额 进行下一张
                                    continue;
                                }else{
                                    //没有超过设定的最大金额,本次累加进来,之后跳出循环
                                    sendVo.getOrder().getDetail().add(getGoldenTaxInvoiceDetailVo(invoiceVo));
                                    res = false;
                                    break;
                                }
                            }
                            //说明无法继续累加需要重开一张发票
                            if(res){
                                goldenTaxInvoiceSendVos.add(getGoldenTaxInvoiceSendVo(invoiceVo));
                            }
                        }
                    }
                }
            }
            List<GoldenTaxInvoiceSendVo> results = new ArrayList<>();
            for(String key : invoiceSendVosMap.keySet()){
                List<GoldenTaxInvoiceSendVo> sendVos = invoiceSendVosMap.get(key);
                //获取该key对应的备注集合
                HashSet<String> infoNoteSet = infoNoteList.get(key);
                if(ArrayUtils.isNotNullAndLengthNotZero(sendVos))
                    if(infoNoteSet != null && !infoNoteSet.isEmpty()){ //如果备注集合不为空
                        //拼接备注信息
                        String infoNote = "";
                        for(String note : infoNoteSet){
                            infoNote = infoNote + note;
                        }
                        //循环重新赋值备注信息
                        for(GoldenTaxInvoiceSendVo item : sendVos){
                            item.getOrder().setInfonotes(infoNote); //备注
                        }
                    }
                    results.addAll(sendVos);
            }
            for(InvoiceVo item : maxInvoiceVos){
                //key
                String key = String.format("%s_%s_%s",item.getInvoiceDataType(),item.getCertifNo(),item.getCstmInvoiceType());
                if(infoNoteList.get(key) != null && !infoNoteList.get(key).isEmpty()){
                    //拼接备注信息
                    String infoNote = "";
                    for(String note : infoNoteList.get(key)){
                        infoNote = infoNote + note;
                    }
                    item.setInfonotes(infoNote);
                }
            }
            return results;
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   获取开票信息
     * @param sendVos
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/18 01:11:20
     */
    private List<InvoiceVo> getInvoiceVos(List<GoldenTaxInvoiceSendVo> sendVos){
        if(ArrayUtils.isNotNullAndLengthNotZero(sendVos)){
            List<InvoiceVo> invoiceVos = new ArrayList<>();
            for(GoldenTaxInvoiceSendVo sendVo : sendVos){
                List<InvoiceVo> tmps  = getInvoiceVos(sendVo);
                if(ArrayUtils.isNotNullAndLengthNotZero(tmps))
                    invoiceVos.addAll(tmps);
            }
            return invoiceVos;
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   获取开票信息
     * @param sendVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/18 01:11:30
     */
    private List<InvoiceVo> getInvoiceVos(GoldenTaxInvoiceSendVo sendVo){
        if(sendVo != null && sendVo.getOrder() != null && ArrayUtils.isNotNullAndLengthNotZero(sendVo.getOrder().getDetail())){
            List<InvoiceVo> invoiceVos = new ArrayList<>();
            List<GoldenTaxInvoiceDetailVo> detailVos = sendVo.getOrder().getDetail();
            for(GoldenTaxInvoiceDetailVo detailVo : detailVos) {
                if(detailVo != null)
                    invoiceVos.add(detailVo.getInvoiceVo());
            }
            return invoiceVos;
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   获取最大金额
     * @param invoiceVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/20 11:36:59
     */
    private BigDecimal getMaxInvoiceAmount(InvoiceVo invoiceVo){
        if(invoiceVo == null)
            throw new FmsServiceException(String.format("开票信息不能为空"));
        if(StringUtils.isTrimBlank(invoiceVo.getInvoiceDataType()))
            throw new FmsServiceException(String.format("合同号：%s,开票类型不能为空",invoiceVo.getContNo()));
        //要开具的发票种类（0： 专用发票 1：废旧物资发票 2：普通发票）
        if(InvoiceTypeEnums.SPECIAL_TICKET.getType().equals(invoiceVo.getCstmInvoiceType())){
            //专票最大发票金额值
            BigDecimal maxInvoiceAmount = new BigDecimal(commonConstantService.findSysParamValue(CommonParamConstants.TICKET_MAX_INVOICE_AMOUNT));
            return maxInvoiceAmount;
        } else if (InvoiceTypeEnums.UNIVERSAL_TICKET.getType().equals(invoiceVo.getCstmInvoiceType())){
            //普票最大发票金额值
            BigDecimal maxInvoiceAmount = new BigDecimal(commonConstantService.findSysParamValue(CommonParamConstants.MAX_INVOICE_AMOUNT));
            return maxInvoiceAmount;
        } else
            throw new FmsServiceException(String.format("合同号：%s,发票类型不存在,%s",invoiceVo.getContNo(),invoiceVo.getCstmInvoiceType()));
    }

    /**
     * @Title:
     * @Description: 开票完成后的打印
     * @param invoiceAutos
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/13 09:39:40
     */
    public InvoicePrintinvResultVo printinv(List<InvoiceAuto> invoiceAutos, SysUser sysUser) {
        if(ArrayUtils.isNotNullAndLengthNotZero(invoiceAutos)){
            //发票排序
            Collections.sort(invoiceAutos, new Comparator<InvoiceAuto>() {
                @Override
                public int compare(InvoiceAuto o1, InvoiceAuto o2) {
                    if(o1 != null && o2 != null && StringUtils.isNotTrimBlank(o1.getInfonumber(),o2.getInfonumber())){
                        if(BigDecimalUtils.gt(new BigDecimal(o1.getInfonumber()),new BigDecimal(o2.getInfonumber())))
                            return 1;
                        else
                            return -1;
                    }
                    return 1;
                }
            });
            //保存打印成功的开票信息
            List<InvoiceAuto> successInvoiceAutos = new ArrayList<>();
            InvoicePrintinvResultVo printinvResultVo = new InvoicePrintinvResultVo();
            //发送结果
            boolean sendErrorResult = false;
            for(InvoiceAuto invoiceAuto : invoiceAutos){
                try{
                    if(invoiceAuto != null){
                        //循环开票,如果有错误就中止继续打印
                        GoldenTaxPrintinvVo printinvVo = EntityUtils.getEntity(invoiceAuto,new GoldenTaxPrintinvVo());
                        printinvVo.setInfoshowprtdlg("0");
                        GoldenTaxInvoiceResultVo resultVo = ResponseEntityUtils.getRestResponseData(goldenTaxRpc.printinv(printinvVo));
                        //打印成功
                        if(resultVo != null && GoldenTaxResultEnums.PRINTINV_SUCCESS.getResult().equals(resultVo.getCode())) {
                            invoiceAuto.setInvSendXml(resultVo.getSendFile());
                            invoiceAuto.setInvBackXml(resultVo.getReturnFile());
                            successInvoiceAutos.add(invoiceAuto);
                        } else {
                            printinvResultVo.getErrorInvoiceAutos().add(invoiceAuto);
                            printinvResultVo.setErrorCode(resultVo.getCode());
                            printinvResultVo.setErrorMsg(resultVo.getMessage());
                            sendErrorResult = true;
                            break;
                        }
                    }
                }catch (Exception ex){
                    ex.printStackTrace();
                    log.error(ex.getMessage());
                    sendErrorResult = true;
                    printinvResultVo.getErrorInvoiceAutos().add(invoiceAuto);
                    printinvResultVo.setErrorMsg(ex.getMessage());
                    //跳出继续打印
                    break;
                }
            }
            //保存发送成功的
            if(ArrayUtils.isNotNullAndLengthNotZero(successInvoiceAutos)) {
                printinvResultVo.setSuccessInvoiceAutos(successInvoiceAutos);
                invoiceRepository.savePrintinvResults(successInvoiceAutos,sysUser.getUser());
            }
            //有发送失败的
            if(sendErrorResult){
                if(ArrayUtils.isNotNullAndLengthNotZero(successInvoiceAutos))
                    invoiceAutos.removeAll(successInvoiceAutos);
                if(ArrayUtils.isNotNullAndLengthNotZero(printinvResultVo.getErrorInvoiceAutos()))
                    invoiceAutos.removeAll(printinvResultVo.getErrorInvoiceAutos());
                //剔除失败和成功的 剩下的就是未发送的
                printinvResultVo.setNotSendInvoiceAutos(invoiceAutos);
            }
            return printinvResultVo;
        }else
            throw new FmsServiceException("未接收到需要打印的发票信息");
    }

    /**
     * @Title:
     * @Description:   手动打印
     * @param invoiceIds
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/15 04:51:32
     */
    public InvoicePrintinvResultVo manualPrintinv(List<String> invoiceIds,SysUser sysUser){
        if(ArrayUtils.isNotNullAndLengthNotZero(invoiceIds)){
            Example example = SqlUtil.newExample(Invoice.class);
            example.createCriteria().andIn("invoiceId",invoiceIds);
            List<Invoice> invoices =  invoiceRepository.selectListByExample(example);
            if(ArrayUtils.isNotNullAndLengthNotZero(invoices)){
                List<String> invoiceNos = new ArrayList<>();
                invoices.forEach(invoice -> {
                    if(invoice != null ) {
                        if(InvoiceStatusEnums.NO_PRINT.getStatus().equals(invoice.getInvoiceStatus())){
                            if(StringUtils.isTrimBlank(invoice.getInvoiceNo())){
                                throw new FmsServiceException(String.format("合同号: %s,发票号码为空,无法打印",invoice.getContNo()));
                            }else
                                invoiceNos.add(invoice.getInvoiceNo());
                        }else if(InvoiceStatusEnums.NO_INVOICE.getStatus().equals(invoice.getInvoiceStatus()))
                            throw new FmsServiceException(String.format("合同号: %s,还未开票,无法打印",invoice.getContNo()));
                        else if(InvoiceStatusEnums.INVOICE.getStatus().equals(invoice.getInvoiceStatus()))
                            throw new FmsServiceException(String.format("合同号: %s,已经打印,不能重复打印",invoice.getContNo()));
                    }
                });
                if(ArrayUtils.isNotNullAndLengthNotZero(invoiceNos)){
                    List<InvoiceAuto> invoiceAutos = invoiceAutoService.findInvoiceAutosByInfoNumbers(invoiceNos);
                    return printinv(invoiceAutos,sysUser);
                }
            }
            throw new FmsServiceException("未查询到需要打印开票信息");
        }else
            throw new FmsServiceException("未接收到需要打印开票信息");
    }

    /**
     * 发票作废更新发票信息表
     * @param invoices
     */
    @Transactional
    private void updateInvoice(List<Invoice> invoices) {
        if(ArrayUtils.isNotNullAndLengthNotZero(invoices)){
            for(Invoice invoice : invoices){
                //重置为未开票
                invoice.setInvoiceStatus(InvoiceStatusEnums.NO_INVOICE.getStatus());
                //发票号码放入作废中
                if(StringUtils.isTrimBlank(invoice.getInvoiceNo())){
                    invoice.setInvoiceDelNo(invoice.getInvoiceNo());
                }else{
                    invoice.setInvoiceDelNo(String.format("%s,%s",invoice.getInvoiceDelNo(),invoice.getInvoiceNo()));
                }
                //清空发票号码
                invoice.setInvoiceNo(null);
                //开票日期
                invoice.setInvoiceDate(null);
                //重置为未开票
                invoice.setInvoiceStatus(InvoiceStatusEnums.NO_INVOICE.getStatus());
                //更新开票区分
                invoice.setInvoiceFlag(null);
            }
            //更新数据
            invoiceRepository.updateByPrimaryKeyDataList(invoices,true);
        }
    }

    /**
     * @Description: 生成凭证
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/10/13 18:06
     */
    @Override
    public void makeVoucher(List<String> invoiceIds, SysUser sysUser) {
        //存放已查询过的合同
        Map<String, ContRequestPayVo> contRequestPayVoMap = new HashMap<>();
        ContRequestPayVo contRequestPayVo = null;
        //验证是否传入了开票id
        if(ArrayUtils.isNullOrLengthZero(invoiceIds)) {
            throw new FmsServiceException("请传入需要生成凭证的开票ID");
        }
        //查出开票信息
        Example example = SqlUtil.newExample(Invoice.class);
        example.createCriteria().andIn("invoiceId",invoiceIds);
        List<Invoice> invoices = invoiceRepository.selectListByExample(example);
        //存在数据
        if(ArrayUtils.isNotNullAndLengthNotZero(invoices)){
            //凭证类型
            String voucherType = "";
            for (Invoice invoice : invoices) {
                //获取税率
                BigDecimal rentTax = BigDecimalUtils.dividePercent(invoice.getInvoiceTax());
                //生成合同签约凭证数据
                Map<String, Object> dataMap = new HashMap<>();
                //查询合同融资信息
                contRequestPayVo = contRequestPayVoMap.get(invoice.getContNo());
                if(contRequestPayVo == null){
                    contRequestPayVoMap.put(invoice.getContNo(), contractFinanceRepository.selectContractRequestFinanceByContNo(invoice.getContNo()));
                    contRequestPayVo = contRequestPayVoMap.get(invoice.getContNo());
                }
                //设置区域
                dataMap.put(FinVouDetailValueConstants.VOUCHER_GROUP, contRequestPayVo.getVoucherGroup());
                if (cn.com.leadu.fms.common.constant.enums.prebiz.InvoiceTypeEnums.INIT_AMOUNT.getType().equals(invoice.getInvoiceDataType())) {
                    //首付款
                    voucherType = getVoucherType(VoucherTypeEnums.INIT.getType(),contRequestPayVo.getLicenseAttr());
                    setInitDataMap(invoice, rentTax, dataMap,voucherType);

                } else if (cn.com.leadu.fms.common.constant.enums.prebiz.InvoiceTypeEnums.CHARGE.getType().equals(invoice.getInvoiceDataType())
                        || cn.com.leadu.fms.common.constant.enums.prebiz.InvoiceTypeEnums.SALES_CHARGE.getType().equals(invoice.getInvoiceDataType())) {
                    //手续费,代收手续费
                    voucherType = getVoucherType(VoucherTypeEnums.CHARGE.getType(),contRequestPayVo.getLicenseAttr());
                    setChargeDataMap(invoice, rentTax, dataMap,voucherType);

                } else if (cn.com.leadu.fms.common.constant.enums.prebiz.InvoiceTypeEnums.FINAL_AMOUNT.getType().equals(invoice.getInvoiceDataType())
                        || cn.com.leadu.fms.common.constant.enums.prebiz.InvoiceTypeEnums.PREPAYMENT.getType().equals(invoice.getInvoiceDataType())
                        || cn.com.leadu.fms.common.constant.enums.prebiz.InvoiceTypeEnums.RENT.getType().equals(invoice.getInvoiceDataType())) {
                    //尾款及结清款，租金
                    voucherType = getVoucherType(VoucherTypeEnums.RENT.getType(),contRequestPayVo.getLicenseAttr());
                    setRentDataMap(invoice, rentTax, dataMap,voucherType);
                }else{
                    throw new FmsServiceException("只有租金，首付，尾付，手续费，代收手续费和提前结清能生成凭证");
                }
                invoice.setInvoiceVoucherStatus(YesNoFlagEnums.YES.getType());
                //生成凭证
                saveFinVouDatas(dataMap,contRequestPayVo.getVinNo(),contRequestPayVo.getApplyNo(),invoice.getContNo(),voucherType);
            }
            //更新发票凭证生成状态
            invoiceRepository.updateByPrimaryKeyDataList(invoices);
        }
    }

    /**
     * @Title:
     * @Description: 根据发票号查找要打印的信息
     * @param invoiceNoList
     * @return
     * @throws
     * @author nignyangyang
     * @date 2018-10-24 16:01:33
     */
    @Override
    public List<InvoiceAuto> findInvoiceAutos(List<String> invoiceNoList) {
        Set infonumberSet = new HashSet();
        if(ArrayUtils.isNotNullAndLengthNotZero(invoiceNoList)){
            for(String invoiceNo:invoiceNoList){
                String infonumbers[] = invoiceNo.split(",");
                for(String infonumber:infonumbers){
                    infonumberSet.add(infonumber);
                }
            }
        }
        Example example  = SqlUtil.newExample(InvoiceAuto.class);
        Example.Criteria criteria = example.createCriteria();
        criteria.andIn("infonumber",infonumberSet);
        example.orderBy("infonumber").asc();
        return invoiceAutoRepository.selectListByExample(example);
    }

    private void saveFinVouDatas(Map<String,Object> dataMap,String vinNo,String applyNo,String contNo,String voucherType){
        //车架号后6位
        dataMap.put(FinVouDetailValueConstants.VIN_NO_6, StringUtils.subStringLater(vinNo,6));
        //获取财务核算代码
        ContractVo contractVo = new ContractVo();
        contractVo.setApplyTypePerson(ApplyTypeEnums.PERSON.getType());
        contractVo.setApplyNo(applyNo);
        contractVo.setContNo(contNo);
        contractVo = contractRepository.selectContractVoFinassCodes(contractVo);
        if(contractVo != null) {
            //取到订单申请人的财务核算代码
            dataMap.put(FinVouDetailValueConstants.FINASS_CSTM_CODE, contractVo.getFinassCstmCode());
            //申请人姓名
            dataMap.put(FinVouDetailValueConstants.APPLY_PERSON_NAME, contractVo.getApplyPersonName());
            //实际销售方的财务核算代码
            dataMap.put(FinVouDetailValueConstants.FINASS_SALES_CODE, contractVo.getFinassSalesCode());
            //出租人的财务核算代码
            dataMap.put(FinVouDetailValueConstants.FINASS_GROUP_CODE, contractVo.getFinassGroupCode());
        }
        //获取凭证明细数据
        CommonFinVouData commonFinVouData = commonFinancialVoucherDataService.getFinVoucherData(voucherType,dataMap,contNo);
        //保存凭证明细数据
        commonFinancialVoucherDataService.saveCommonFinVouData(commonFinVouData);
    }

    /**
     * @Description: 设置首付款数据
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/10/15 11:30
     */
    private void setInitDataMap(Invoice invoice, BigDecimal rentTax, Map<String, Object> dataMap, String voucherType) {
        if (VoucherTypeEnums.INIT_0.getType().equals(voucherType)) {//融资租赁
            //首付/1.17
            dataMap.put(FinVouDetailValueConstants.INIT_AMOUNT, BigDecimalUtils.getNotNullBigDecimal(invoice.getInvoiceAmount()).divide(BigDecimal.ONE.add(rentTax),2, BigDecimal.ROUND_HALF_UP));
            //首付/1.17*0.17
            dataMap.put(FinVouDetailValueConstants.INIT_AMOUNT_TAX, BigDecimalUtils.getNotNullBigDecimal(invoice.getInvoiceAmount()).divide(BigDecimal.ONE.add(rentTax),2, BigDecimal.ROUND_HALF_UP).multiply(rentTax));
        }else if (VoucherTypeEnums.INIT_1.getType().equals(voucherType)) {//经营租赁
            //首付
            dataMap.put(FinVouDetailValueConstants.INIT_AMOUNT_RENT, invoice.getInvoiceAmount());
            //首付/1.17
            dataMap.put(FinVouDetailValueConstants.INIT_AMOUNT, BigDecimalUtils.getNotNullBigDecimal(invoice.getInvoiceAmount()).divide(BigDecimal.ONE.add(rentTax),2, BigDecimal.ROUND_HALF_UP));
            //首付/1.17*0.17
            dataMap.put(FinVouDetailValueConstants.INIT_AMOUNT_TAX, BigDecimalUtils.getNotNullBigDecimal(invoice.getInvoiceAmount()).divide(BigDecimal.ONE.add(rentTax),2, BigDecimal.ROUND_HALF_UP).multiply(rentTax));
        }else if (VoucherTypeEnums.INIT_2.getType().equals(voucherType)) {//回租赁
            throw new FmsServiceException("回租赁首付款不能财务凭证");
        }

    }

    /**
     * @Description: 设置手续费数据
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/10/15 11:46
     */
    private void setChargeDataMap(Invoice invoice, BigDecimal rentTax, Map<String, Object> dataMap, String voucherType) {
        //手续费
        dataMap.put(FinVouDetailValueConstants.CHARGE_FEE, invoice.getInvoiceAmount());
        //手续费1=手续费/1.06
        dataMap.put(FinVouDetailValueConstants.CHARGE_FEE_1, BigDecimalUtils.getNotNullBigDecimal(invoice.getInvoiceAmount()).divide(BigDecimal.ONE.add(rentTax),2, BigDecimal.ROUND_HALF_UP));
        //手续费2=手续费/1.06*0.06
        dataMap.put(FinVouDetailValueConstants.CHARGE_FEE_2, BigDecimalUtils.getNotNullBigDecimal(invoice.getInvoiceAmount()).divide(BigDecimal.ONE.add(rentTax),2, BigDecimal.ROUND_HALF_UP).multiply(rentTax));
    }

    /**
     * @Description: 设置提前结清及尾款
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/10/15 13:57
     */
    private void setRentDataMap(Invoice invoice, BigDecimal rentTax, Map<String, Object> dataMap, String voucherType) {
        Example example = SqlUtil.newExample(ContRepaySked.class);
        example.createCriteria().andEqualTo("contNo",invoice.getContNo()).andEqualTo("period",invoice.getDetailNo());
        ContRepaySked contRepaySked = contRepaySkedRepository.selectOneByExample(example);
        if (contRepaySked == null) {
            throw new FmsServiceException("未获取到合同号"+invoice.getContNo()+"对应的还款计划表信息");
        }
        if (VoucherTypeEnums.RENT_0.getType().equals(voucherType)) {
            //本金
            BigDecimal principal = BigDecimalUtils.getNotNullBigDecimal(contRepaySked.getPrincipal()).divide(BigDecimal.ONE.add(rentTax), 2, BigDecimal.ROUND_HALF_UP);
            dataMap.put(FinVouDetailValueConstants.PRINCIPAL, principal);
            //利息
            BigDecimal interest = BigDecimalUtils.getNotNullBigDecimal(contRepaySked.getInterest()).divide(BigDecimal.ONE.add(rentTax), 2, BigDecimal.ROUND_HALF_UP);
            dataMap.put(FinVouDetailValueConstants.INTEREST, interest);
            //税
            dataMap.put(FinVouDetailValueConstants.RENT_TAX, principal.add(interest).multiply(rentTax));
        }else if (VoucherTypeEnums.RENT_1.getType().equals(voucherType)) {
            //租金
            dataMap.put(FinVouDetailValueConstants.PRINCIPAL, contRepaySked.getRentActual());
            //租金/1.17
            dataMap.put(FinVouDetailValueConstants.INTEREST, BigDecimalUtils.getNotNullBigDecimal(contRepaySked.getRentActual()).divide(BigDecimal.ONE.add(rentTax), 2, BigDecimal.ROUND_HALF_UP));
            //租金/1.17*0.17
            dataMap.put(FinVouDetailValueConstants.RENT_TAX, BigDecimalUtils.getNotNullBigDecimal(contRepaySked.getRentActual()).divide(BigDecimal.ONE.add(rentTax), 2, BigDecimal.ROUND_HALF_UP).multiply(rentTax));
        }else if (VoucherTypeEnums.RENT_2.getType().equals(voucherType)) {
            //利息
            dataMap.put(FinVouDetailValueConstants.INTEREST, contRepaySked.getInterest());
            //租金/1.17
            dataMap.put(FinVouDetailValueConstants.INTEREST_1, BigDecimalUtils.getNotNullBigDecimal(contRepaySked.getInterest()).divide(BigDecimal.ONE.add(rentTax), 2, BigDecimal.ROUND_HALF_UP));
            //租金/1.17*0.17
            dataMap.put(FinVouDetailValueConstants.INTEREST_2, BigDecimalUtils.getNotNullBigDecimal(contRepaySked.getInterest()).divide(BigDecimal.ONE.add(rentTax), 2, BigDecimal.ROUND_HALF_UP).multiply(rentTax));
        }
    }

    /**
     * @Description: 获取财务凭证类型通用方法
     * @param:
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/10/15 10:05
     */
    private String getVoucherType(String type, String licenseAttr) {
        String voucherType = "";
        if(LicenseAttrEnums.FINANCE_LEASE.getType().equals(licenseAttr)){
            voucherType = type.concat("0");
        }else if(LicenseAttrEnums.LEASE_DIRECT.getType().equals(licenseAttr)){
            voucherType = type.concat("1");
        }else if(LicenseAttrEnums.LEASE_BACK.getType().equals(licenseAttr)){
            voucherType = type.concat("2");
        }
        if(StringUtils.isTrimBlank(voucherType)){
            throw new FmsServiceException("获取财务凭证类型失败");
        }
        return voucherType;
    }

    /**
     * @Title:
     * @Description: 保存开票信息
     * @param invoiceSaveVo
     * @return java.lang.String
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    public void saveInvoice(InvoiceSaveVo invoiceSaveVo){
        invoiceRepository.insertData(invoiceSaveVo.getEntity());
    }

    /**
     * @Title:
     * @Description: 修改开票信息
     * @param invoiceModifyVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    public void modifyInvoice(InvoiceModifyVo invoiceModifyVo){
        invoiceRepository.updateByPrimaryKeySelectiveData(invoiceModifyVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过invoiceId删除开票信息
     * @param invoiceDeleteVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    public void deleteInvoice(InvoiceDeleteVo invoiceDeleteVo){
        invoiceRepository.deleteData(invoiceDeleteVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  通过invoiceId集合删除开票信息
     * @param invoiceDeleteListVo
     * @return
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    public void deleteInvoicesByInvoiceIds(InvoiceDeleteListVo invoiceDeleteListVo){
        invoiceRepository.deleteDataList(invoiceDeleteListVo.getInvoiceIds(),invoiceDeleteListVo.getEntity());
    }

    /**
     * @Title:
     * @Description:  根据invoiceId获取开票信息
     * @param invoiceId
     * @return Invoice
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    public Invoice findInvoiceByInvoiceId(String invoiceId){
        return invoiceRepository.selectByPrimaryKey(invoiceId);
    }


}
