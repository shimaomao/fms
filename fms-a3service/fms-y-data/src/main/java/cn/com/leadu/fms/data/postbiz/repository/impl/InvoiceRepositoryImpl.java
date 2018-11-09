package cn.com.leadu.fms.data.postbiz.repository.impl;

import cn.com.leadu.fms.common.constant.enums.postbiz.InvoiceFlagEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.InvoiceStatusEnums;
import cn.com.leadu.fms.common.constant.enums.postbiz.PrintStatusEnums;
import cn.com.leadu.fms.common.util.*;
import cn.com.leadu.fms.common.vo.PageQuery;
import cn.com.leadu.fms.data.base.repository.AbstractBaseRepository;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.dao.InvoiceDao;
import cn.com.leadu.fms.data.postbiz.repository.InvoiceAutoRepository;
import cn.com.leadu.fms.data.postbiz.repository.InvoiceRepository;
import cn.com.leadu.fms.pojo.postbiz.entity.Invoice;
import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceAuto;
import cn.com.leadu.fms.pojo.postbiz.vo.invoice.InvoiceVo;
import cn.com.leadu.fms.pojo.thirdinterface.vo.goldentax.GoldenTaxInvoiceDetailVo;
import cn.com.leadu.fms.pojo.thirdinterface.vo.goldentax.GoldenTaxInvoiceSendVo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Propagation;
import org.springframework.transaction.annotation.Transactional;
import tk.mybatis.mapper.entity.Example;

import java.util.*;

/**
 * @author yangyiquan
 * @ClassName: InvoiceRepositoryImpl
 * @Description: 开票信息Repository 实现层
 */
@Repository
public class InvoiceRepositoryImpl extends AbstractBaseRepository<InvoiceDao, Invoice> implements InvoiceRepository {


    @Autowired
    private InvoiceAutoRepository invoiceAutoRepository;

    /**
     * @Title:
     * @Description: 新增开票信息
     * @param invoice
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @Override
    public int insertData(Invoice invoice) {
        return super.insert(invoice);
    }

    /**
     * @Title:
     * @Description: 批量保存开票信息
     * @param invoices
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @Override
    public int insertDataList(List<Invoice> invoices){
        return super.insertListByJdbcTemplate(invoices);
    }

    /**
     * @Title:
     * @Description: 修改开票信息
     * @param invoice
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @Override
    public int updateByPrimaryKeyData(Invoice invoice) {
        return super.updateByPrimaryKey(invoice);
    }

    /**
     * @Title:
     * @Description: 批量修改开票信息
     * @param invoices
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @Override
    public int updateByPrimaryKeyDataList(List<Invoice> invoices){
        return super.updateListByPrimaryKey(invoices);
    }

    /**
     * @Title:
     * @Description: 动态修改开票信息
     * @param invoice
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @Override
    public int updateByPrimaryKeySelectiveData(Invoice invoice) {
        return super.updateByPrimaryKeySelective(invoice);
    }

    /**
     * @Title:
     * @Description: 批量动态修改开票信息
     * @param invoices
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<Invoice> invoices) {
        return super.updateListByPrimaryKeySelective(invoices);
    }

    /**
     * @Title:
     * @Description: 根据条件修改开票信息
     * @param invoice
     * @param example
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @Override
    public int updateByExampleData(Invoice invoice, Example example) {
        return super.updateByExample(invoice,example);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改开票信息
     * @param invoice
     * @param example
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @Override
    public int updateByExampleSelectiveData(Invoice invoice, Example example){
        return super.updateByExampleSelective(invoice,example);
    }

    /**
     * @Title:
     * @Description: 根据invoiceId删除开票信息
     * @param invoice
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @Override
    public int deleteData(Invoice invoice) {
        return super.delete(invoice);
    }

    /**
     * @Title:
     * @Description: 根据invoiceId集合批量删除开票信息
     * @param invoice
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @Override
    public int deleteDataList(List invoiceIds,Invoice invoice){
        return super.deleteByIds(invoiceIds,invoice);
    }

    /**
     * @Title:
     * @Description: 根据自定义条件删除开票信息
     * @param example
     * @param invoice
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @Override
    public int deleteExampleData(Example example,Invoice invoice){
        return super.deleteByExample(example,invoice);
    }

    /**
     * @Title:
     * @Description: 查询全部开票信息
     * @return List<Invoice>
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @Override
    public List<Invoice> selectAll() {
        return super.selectAll();
    }

    /**
     * @Title:
     * @Description: 通过条件查询一个开票信息
     * @param example
     * @return Invoice
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @Override
    public Invoice selectOneByExample(Example example) {
        return super.selectOneByExample(example);
    }

    /**
     * @Title:
     * @Description: 通过条件批量查询开票信息
     * @param example
     * @return List<Invoice>
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @Override
    public List<Invoice> selectListByExample(Example example) {
        return super.selectListByExample(example);
    }

    /**
     * @Title:
     * @Description: 通过invoiceId查询开票信息
     * @param invoiceId
     * @return Invoice
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @Override
    public Invoice selectByPrimaryKey(Object invoiceId) {
        return super.selectByPrimaryKey(invoiceId);
    }

    /**
     * @Title:
     * @Description: 分页查询开票信息
     * @param example
     * @param pageQuery
     * @return PageInfoExtend<Invoice>
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @Override
    public PageInfoExtend<Invoice> selectListByExamplePage(Example example, PageQuery pageQuery){
        return super.selectListByExamplePage(example,pageQuery);
    }

    /**
     * @Title:
     * @Description: 分页查询开票信息vo
     * @param methodName
     * @param param
     * @param pageQuery
     * @return PageInfoExtend
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    public PageInfoExtend selectListVoByPage(String methodName,Object param,PageQuery pageQuery){
        return super.selectListVoByPage(methodName,param,pageQuery);
    }

    /**
     * @Title:
     * @Description: 修改开票信息
     * @param invoice,并进行排他
     * @param exclusive
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @Override
    public int updateByPrimaryKeyData(Invoice invoice,boolean exclusive) {
        return super.updateByPrimaryKey(invoice,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量修改开票信息,并进行排他
     * @param invoices
     * @param exclusive
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @Override
    public int updateByPrimaryKeyDataList(List<Invoice> invoices,boolean exclusive){
        return super.updateListByPrimaryKey(invoices,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据主键动态修改开票信息,并进行排他
     * @param invoice
     * @param exclusive
     * @return int
     * @throws
     * @author qiaomengnan
     * @date 2018-5-25 11:13:59
     */
    @Override
    public int updateByPrimaryKeySelectiveData(Invoice invoice,boolean exclusive) {
        return super.updateByPrimaryKeySelective(invoice,exclusive);
    }

    /**
     * @Title:
     * @Description: 批量动态修改开票信息,并进行排他
     * @param invoices
     * @param exclusive
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @Override
    public int updateByPrimaryKeySelectiveDataList(List<Invoice> invoices,boolean exclusive) {
        return super.updateListByPrimaryKeySelective(invoices,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件修改开票信息,并进行排他
     * @param invoice
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @Override
    public int updateByExampleData(Invoice invoice, Example example,boolean exclusive) {
        return super.updateByExample(invoice,example,exclusive);
    }

    /**
     * @Title:
     * @Description: 根据条件动态修改开票信息,并进行排他
     * @param invoice
     * @param example
     * @param exclusive
     * @return int
     * @throws
     * @author yangyiquan
     * @date 2018-9-10 16:01:34
     */
    @Override
    public int updateByExampleSelectiveData(Invoice invoice, Example example,boolean exclusive){
        return super.updateByExampleSelective(invoice,example,exclusive);
    }

    /**
     * @Title:
     * @Description:   查询开票信息vo列表
     * @param invoiceVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/12 09:57:48
     */
    public List<InvoiceVo> selectInvoiceVos(InvoiceVo invoiceVo){
        return baseDao.selectInvoiceVos(invoiceVo);
    }

    /**
     * @Title:
     * @Description:   发票打印成功，开票信息的发票号匹配上本次发票打印成功的号码，则将其状态改为已打印
     * @param invoiceAutos
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/14 09:47:54
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public void savePrintinvResults(List<InvoiceAuto> invoiceAutos,String user){
        if(ArrayUtils.isNotNullAndLengthNotZero(invoiceAutos)){
            //拿到发票号
            List<String> infoNumbers = new ArrayList<>();
            Map<String,String> infoNumbersMap = new HashMap<>();
            for(InvoiceAuto invoiceAuto : invoiceAutos){
                if(invoiceAuto != null && StringUtils.isNotTrimBlank(invoiceAuto.getInfonumber())){
                    infoNumbers.add(invoiceAuto.getInfonumber());
                    infoNumbersMap.put(invoiceAuto.getInfonumber(),invoiceAuto.getInfonumber());
                    //状态改为已打印
                    invoiceAuto.setPrintStatus(PrintStatusEnums.PRINT.getStatus());
                }
            }
            //取出发票号对应的开票信息
            Example example = SqlUtil.newExample(Invoice.class);
            Example.Criteria criteria = example.createCriteria();
            for(String infoNumber : infoNumbers) {
                criteria.orLike("invoiceNo",SqlUtil.likePattern(infoNumber));
            }
            //List<Invoice> invoices = this.selectListByExample(example);
            //List<Invoice> successInvoices = new ArrayList<>();
//            if(ArrayUtils.isNotNullAndLengthNotZero(invoices)){
//                for(Invoice invoice : invoices){
//                    if(invoice != null && StringUtils.isNotTrimBlank(invoice.getInvoiceNo())){
//                        String [] invoiceNos = invoice.getInvoiceNo().split(StringUtils.COMMA);
//                        if(ArrayUtils.isNotNullAndLengthNotZero(invoiceNos)){
//                            //所拥有的发票号都打印成功了 才可以将状态更新成为已打印
//                            boolean res = true;
//                            for(String invoiceNo : invoiceNos){
//                                if(StringUtils.isTrimBlank(infoNumbersMap.get(invoiceNo))) {
//                                    res = false;
//                                    break;
//                                }
//                            }
//                            //设置状态
//                            if(res) {
//                                invoice.setUpdater(user);
//                                invoice.setUpdateLastTime(invoice.getUpdateTime());
//                                invoice.setUpdateTime(new Date());
//                                invoice.setInvoiceStatus(InvoiceStatusEnums.INVOICE.getStatus());
//                                successInvoices.add(invoice);
//                            }
//                        }
//                    }
//                }
//                //更新为已开票
//                this.updateByPrimaryKeySelectiveDataList(successInvoices,true);
//
//            }
            invoiceAutoRepository.updateByPrimaryKeySelectiveDataList(invoiceAutos,true);
        }
    }

    /**
     * @Title:
     * @Description:   保存超过最大设定额度的自动开票信息
     * @param maxInvoiceVoMaps
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/13 08:54:37
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<InvoiceAuto> saveMaxAutoManual(Map<InvoiceVo,List<GoldenTaxInvoiceSendVo>> maxInvoiceVoMaps,String user){
        if(maxInvoiceVoMaps != null && maxInvoiceVoMaps.size() > 0){
            List<InvoiceVo> allInvoiceVos = new ArrayList<>();
            List<InvoiceAuto> invoiceAutos = new ArrayList<>();
            for(InvoiceVo invoiceVo : maxInvoiceVoMaps.keySet()){
                //拼接成功的发票号
                List<GoldenTaxInvoiceSendVo> sendVos = maxInvoiceVoMaps.get(invoiceVo);
                if(ArrayUtils.isNotNullAndLengthNotZero(sendVos)){
                    StringBuffer invoiceNos = new StringBuffer();
                    for(GoldenTaxInvoiceSendVo sendVo : sendVos){
                        if(sendVo != null && sendVo.getGoldenTaxInvoiceResultVo() != null){
                            //追加发票号
                            invoiceNos.append(String.format("%s,",sendVo.getGoldenTaxInvoiceResultVo().getInfonumber()));
                            //设置开票日期
                            invoiceVo.setInvoiceDate(DateUtils.strToDate(sendVo.getGoldenTaxInvoiceResultVo().getInfoinvdate(),DateUtils.formatStr_yyyyMMdd));
                            //设置成已开票未打印
                            invoiceVo.setInvoiceStatus(InvoiceStatusEnums.INVOICE.getStatus());
                            //生成发送成功的数据
                            InvoiceAuto invoiceAuto = getInvoiceAuto(sendVo);
                            if(invoiceAuto != null)
                                invoiceAutos.add(invoiceAuto);
                        }
                    }
                    if(invoiceNos.length() > 0)
                        invoiceNos = invoiceNos.deleteCharAt(invoiceNos.length() - 1);
                    invoiceVo.setInvoiceNo(invoiceNos.toString());
                    invoiceVo.setInvoiceFlag(InvoiceFlagEnums.AUTO.getStatus());
                    invoiceVo.setUpdater(user);
                    invoiceVo.setUpdateLastTime(invoiceVo.getUpdateTime());
                    invoiceVo.setUpdateTime(new Date());
                    allInvoiceVos.add(invoiceVo);
                }
            }
            //更新开票信息
            this.updateByPrimaryKeySelectiveDataList(EntityUtils.getEntitys(allInvoiceVos,Invoice.class),true);
            //保存自动开票信息
            invoiceAutoRepository.insertDataList(invoiceAutos);
            return invoiceAutos;
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   保存发送成功的信息
     * @param successSendVos
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/13 05:23:07
     */
    @Transactional(propagation = Propagation.REQUIRES_NEW)
    public List<InvoiceAuto> saveSendAutoManual(List<GoldenTaxInvoiceSendVo> successSendVos,String user){
        if(ArrayUtils.isNotNullAndLengthNotZero(successSendVos)){
            List<InvoiceVo> allInvoiceVos = new ArrayList<>();
            List<InvoiceAuto> invoiceAutos = new ArrayList<>();
            for(GoldenTaxInvoiceSendVo sendVo : successSendVos){
                if(sendVo != null && sendVo.getOrder() != null && ArrayUtils.isNotNullAndLengthNotZero(sendVo.getOrder().getDetail())){
                    //抽出发送成功的开票信息
                    List<InvoiceVo> invoiceVos = new ArrayList<>();
                    for(GoldenTaxInvoiceDetailVo detailVo : sendVo.getOrder().getDetail()){
                        if(detailVo != null && detailVo.getInvoiceVo() != null){
                            detailVo.getInvoiceVo().setUpdater(user);
                            detailVo.getInvoiceVo().setUpdateLastTime(detailVo.getInvoiceVo().getUpdateTime());
                            detailVo.getInvoiceVo().setUpdateTime(new Date());
                            detailVo.getInvoiceVo().setInvoiceFlag(InvoiceFlagEnums.AUTO.getStatus());
                            invoiceVos.add(detailVo.getInvoiceVo());
                        }
                    }
                    allInvoiceVos.addAll(invoiceVos);
                    //生成发送成功的数据
                    InvoiceAuto invoiceAuto = getInvoiceAutos(invoiceVos,sendVo);
                    if(invoiceAuto != null)
                        invoiceAutos.add(invoiceAuto);
                }
            }
            //保存自动开票信息
            invoiceAutoRepository.insertDataList(invoiceAutos);
            //更新开票信息
            this.updateByPrimaryKeySelectiveDataList(EntityUtils.getEntitys(allInvoiceVos,Invoice.class),true);
            return invoiceAutos;
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   构建自动开票信息
     * @param sendVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/13 08:35:51
     */
    private InvoiceAuto getInvoiceAuto(GoldenTaxInvoiceSendVo sendVo){
        if(sendVo != null && sendVo.getGoldenTaxInvoiceResultVo() != null && sendVo.getOrder() != null ) {
            InvoiceAuto invoiceAuto = new InvoiceAuto();
            invoiceAuto.setInvoiceAutoId(UUIDUtils.getUUID());
            invoiceAuto.setInfokind(sendVo.getOrder().getInfokind());
            invoiceAuto.setInfoclientname(sendVo.getOrder().getInfoclientname());
            invoiceAuto.setInfoclienttaxcode(sendVo.getOrder().getInfoclienttaxcode());
            invoiceAuto.setInfoclientbankaccount(sendVo.getOrder().getInfoclientbankaccount());
            invoiceAuto.setInfoclientaddressphone(sendVo.getOrder().getInfoclientaddressphone());
            invoiceAuto.setInfotypecode(sendVo.getGoldenTaxInvoiceResultVo().getInfotypecode());
            invoiceAuto.setInfonumber(sendVo.getGoldenTaxInvoiceResultVo().getInfonumber());
            invoiceAuto.setGoodslistflag(sendVo.getGoldenTaxInvoiceResultVo().getGoodslistflag());
            invoiceAuto.setInfoinvdate(sendVo.getGoldenTaxInvoiceResultVo().getInfoinvdate());
            invoiceAuto.setInfmonth(sendVo.getGoldenTaxInvoiceResultVo().getInfmonth());
            invoiceAuto.setInfoamount(sendVo.getGoldenTaxInvoiceResultVo().getInfoamount());
            invoiceAuto.setInfotaxamount(sendVo.getGoldenTaxInvoiceResultVo().getInfotaxamount());
            invoiceAuto.setInvSendXml(sendVo.getGoldenTaxInvoiceResultVo().getSendFile());
            invoiceAuto.setInvBackXml(sendVo.getGoldenTaxInvoiceResultVo().getReturnFile());
            invoiceAuto.setPrintStatus(PrintStatusEnums.NOT_PRINT.getStatus());
            invoiceAuto.setInfonotes(sendVo.getOrder().getInfonotes());
            return invoiceAuto;
        }
        return null;
    }

    /**
     * @Title:
     * @Description:   构建返回数据
     * @param invoiceVos
     * @param invoiceVos
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/13 07:54:56
     */
    private InvoiceAuto getInvoiceAutos(List<InvoiceVo> invoiceVos,GoldenTaxInvoiceSendVo sendVo){
        if(sendVo != null && sendVo.getGoldenTaxInvoiceResultVo() != null){
            if(ArrayUtils.isNotNullAndLengthNotZero(invoiceVos)){
                for(InvoiceVo invoiceVo : invoiceVos){
                    if(invoiceVo != null){
                        //设置发票号码和开票日期
                        invoiceVo.setInvoiceNo(sendVo.getGoldenTaxInvoiceResultVo().getInfonumber());
                        //设置开票日期
                        if(StringUtils.isNotTrimBlank(sendVo.getGoldenTaxInvoiceResultVo().getInfoinvdate()))
                            invoiceVo.setInvoiceDate(DateUtils.strToDate(sendVo.getGoldenTaxInvoiceResultVo().getInfoinvdate(),DateUtils.formatStr_yyyyMMdd));
                        //设置成已开票未打印
                        invoiceVo.setInvoiceStatus(InvoiceStatusEnums.INVOICE.getStatus());
                    }
                }
            }
            //返回自动开票信息
            InvoiceAuto invoiceAuto = getInvoiceAuto(sendVo);
            return invoiceAuto;
        }
        return null;
    }

}
