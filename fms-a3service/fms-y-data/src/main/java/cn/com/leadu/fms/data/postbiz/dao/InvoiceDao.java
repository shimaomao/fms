package cn.com.leadu.fms.data.postbiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.postbiz.entity.Invoice;
import cn.com.leadu.fms.pojo.postbiz.vo.invoice.InvoiceVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: InvoiceDao
 * @Description: 开票信息dao层
 */
public interface InvoiceDao extends BaseDao<Invoice> {

    /**
     * @Title:
     * @Description:   查询开票信息vo列表
     * @param invoiceVo
     * @return
     * @throws
     * @author qiaomengnan
     * @date 2018/09/12 09:57:48
     */
    List<InvoiceVo> selectInvoiceVos(@Param("invoiceVo") InvoiceVo invoiceVo);

}