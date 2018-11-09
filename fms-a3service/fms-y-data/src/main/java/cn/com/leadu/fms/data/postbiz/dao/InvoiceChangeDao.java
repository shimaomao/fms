package cn.com.leadu.fms.data.postbiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceChange;
import cn.com.leadu.fms.pojo.postbiz.vo.invoicechange.InvoiceChangeSearchVo;
import cn.com.leadu.fms.pojo.postbiz.vo.invoicechange.InvoiceChangeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lijunjun
 * @ClassName: InvoiceChangeDao
 * @Description: 开票信息变更dao层
 * @date 2018-08-29
 */
public interface InvoiceChangeDao extends BaseDao<InvoiceChange> {

    /**
     * 分页查询开票变更任务
     * @param invoiceChangeVo
     * @return List<InvoiceChangeVo>
     */
    List<InvoiceChangeVo> selectCompanyInvoiceListByPage(@Param("invoiceChangeVo") InvoiceChangeVo invoiceChangeVo);

    /**
     * 分页查询开票变更任务
     * @param socialCertifNo
     * @return InvoiceChangeVo
     */
    InvoiceChangeVo selectApplyInvoiceVosBySocialCertifNo(@Param("socialCertifNo") String socialCertifNo);

    /**
     * 分页查询开票变更任务
     * @param invoiceTaskNo
     * @return InvoiceChangeVo
     */
    List<InvoiceChangeVo> selectInvoiceChangeVosByInvoiceTaskNo(@Param("invoiceTaskNo") String invoiceTaskNo);

    /**
     * 更新企业基本信息
     * @param invoiceChangeSearchVo
     */
    void updateCstmCompany(@Param("invoiceChangeSearchVo") InvoiceChangeSearchVo invoiceChangeSearchVo);

    /**
     * 根据统一社会信用编号获取applyNo
     * @param invoiceChangeVo
     * @return
     */
//    List<String> selectApplyNoListBySocialCertifNo(@Param("invoiceChangeVo") InvoiceChangeVo invoiceChangeVo);
}