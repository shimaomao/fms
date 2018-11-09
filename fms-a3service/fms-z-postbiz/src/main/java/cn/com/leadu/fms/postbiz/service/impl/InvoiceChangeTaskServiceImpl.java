package cn.com.leadu.fms.postbiz.service.impl;

import cn.com.leadu.fms.common.constant.enums.postbiz.SolveTypeEnums;
import cn.com.leadu.fms.common.util.StringUtils;
import cn.com.leadu.fms.data.base.vo.PageInfoExtend;
import cn.com.leadu.fms.data.common.util.SqlUtil;
import cn.com.leadu.fms.data.postbiz.repository.InvoiceChangeTaskRepository;
import cn.com.leadu.fms.pojo.postbiz.vo.invoicechange.HistoryChangeVo;
import cn.com.leadu.fms.pojo.postbiz.vo.invoicechange.InvoiceChangeVo;
import cn.com.leadu.fms.postbiz.service.InvoiceChangeTaskService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * @author lijunjun
 * @ClassName: InvoiceChangeTaskService
 * @Description: 开票变更任务业务实现层
 * @date 2018-08-29
 */
@Service
public class InvoiceChangeTaskServiceImpl implements InvoiceChangeTaskService {

    /**
     * @Fields  : 开票变更任务repository
     */
    @Autowired
    private InvoiceChangeTaskRepository invoiceChangeTaskRepository;

    /**
     * @param invoiceChangeVo
     * @return PageInfoExtend<InvoiceChangeVo>
     * @throws
     * @Title:
     * @Description: 分页查询开票变更任务
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @Override
    public PageInfoExtend<InvoiceChangeVo> findCompanyInvoiceListByPage(InvoiceChangeVo invoiceChangeVo) {
        //承租人检索处理
        if (StringUtils.isNotTrimBlank(invoiceChangeVo.getName())){
            invoiceChangeVo.setName(SqlUtil.likePattern(invoiceChangeVo.getName()));
        } else {
            invoiceChangeVo.setName(null);
        }
        //统一社会信用代码检索处理
        if (StringUtils.isNotTrimBlank(invoiceChangeVo.getSocialCertifNo())){
            invoiceChangeVo.setSocialCertifNo(SqlUtil.likePattern(invoiceChangeVo.getSocialCertifNo()));
        } else {
            invoiceChangeVo.setSocialCertifNo(null);
        }
        PageInfoExtend<InvoiceChangeVo> pageInfo = invoiceChangeTaskRepository.selectListVoByPage("selectCompanyInvoiceListByPage",invoiceChangeVo,invoiceChangeVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 分页查询开票变更任务
     * @param invoiceChangeVo
     * @return PageInfoExtend<InvoiceChangeVo>
     * @throws
     * @author lijunjun
     * @date 2018-8-29 9:36:36
     */
    @Override
    public PageInfoExtend<InvoiceChangeVo> findInvoiceChangeVosByPage(InvoiceChangeVo invoiceChangeVo) {
        //承租人检索处理
        if (StringUtils.isNotTrimBlank(invoiceChangeVo.getName())){
            invoiceChangeVo.setName(SqlUtil.likePattern(invoiceChangeVo.getName()));
        } else {
            invoiceChangeVo.setName(null);
        }
        //出租人检索处理
        if (StringUtils.isNotTrimBlank(invoiceChangeVo.getSocialCertifNo())){
            invoiceChangeVo.setSocialCertifNo(SqlUtil.likePattern(invoiceChangeVo.getSocialCertifNo()));
        } else {
            invoiceChangeVo.setSocialCertifNo(null);
        }
        // 任务状态
        if (StringUtils.isTrimBlank(invoiceChangeVo.getBizStatus())){
            invoiceChangeVo.setBizStatus(null);
        }
        // 任务发起开始时间
        if (StringUtils.isTrimBlank(invoiceChangeVo.getSubmitDateStartSearch())){
            invoiceChangeVo.setSubmitDateStartSearch(null);
        }
        // 任务发起结束时间
        if (StringUtils.isTrimBlank(invoiceChangeVo.getSubmitDateEndSearch())){
            invoiceChangeVo.setSubmitDateEndSearch(null);
        }
        // 地区查询处理
        if (StringUtils.isNotTrimBlank(invoiceChangeVo.getGroupDistrict())){
            invoiceChangeVo.setGroupDistrict(SqlUtil.likePattern(invoiceChangeVo.getGroupDistrict()));
        } else {
            invoiceChangeVo.setGroupDistrict(null);
        }
        invoiceChangeVo.setSolveType(SolveTypeEnums.AFTER_MODIFY.getType());
        PageInfoExtend<InvoiceChangeVo> pageInfo = invoiceChangeTaskRepository.selectListVoByPage("selectInvoiceChangeVosByPage",invoiceChangeVo,invoiceChangeVo.getPageQuery());
        return pageInfo;
    }

    /**
     * @Title:
     * @Description: 分页查询制定社会统一信用号的开票变更历史任务
     * @param vo 参数
     * @return PageInfoExtend<InvoiceChangeVo>
     * @throws
     * @author huzongcheng
     */
    @Override
    public PageInfoExtend<HistoryChangeVo> findInvoiceChangeHistory(HistoryChangeVo vo) {
        //设定查询条件
        PageInfoExtend<HistoryChangeVo> pageInfo = invoiceChangeTaskRepository.selectListVoByPage("selectHistoryByPage",vo,vo.getPageQuery());
        return pageInfo;
    }

}
