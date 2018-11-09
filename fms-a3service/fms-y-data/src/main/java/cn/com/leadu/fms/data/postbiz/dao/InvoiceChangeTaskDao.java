package cn.com.leadu.fms.data.postbiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.postbiz.entity.InvoiceChangeTask;
import cn.com.leadu.fms.pojo.postbiz.vo.invoicechange.HistoryChangeVo;
import cn.com.leadu.fms.pojo.postbiz.vo.invoicechange.InvoiceChangeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lijunjun
 * @ClassName: InvoiceChangeTaskDao
 * @Description: 开票变更任务dao层
 * @date 2018-08-29
 */
public interface InvoiceChangeTaskDao extends BaseDao<InvoiceChangeTask> {

    /**
     * 分页查询开票变更任务
     * @param invoiceChangeVo
     * @return List<InvoiceChangeVo>
     */
    List<InvoiceChangeVo> selectCompanyInvoiceListByPage(@Param("invoiceChangeVo") InvoiceChangeVo invoiceChangeVo);

    /**
     * 分页查询开票变更任务
     * @param invoiceChangeVo
     * @return InvoiceChangeVo
     */
    List<InvoiceChangeVo> selectInvoiceChangeVosByPage(@Param("invoiceChangeVo") InvoiceChangeVo invoiceChangeVo);

    /**
     * 分页查询开票变更历史
     * @param historyChangeVo
     * @return InvoiceChangeVo
     */
    List<HistoryChangeVo> selectHistoryByPage(@Param("historyChangeVo") HistoryChangeVo historyChangeVo);

}