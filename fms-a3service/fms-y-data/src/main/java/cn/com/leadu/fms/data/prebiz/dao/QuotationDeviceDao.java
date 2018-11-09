package cn.com.leadu.fms.data.prebiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.prebiz.entity.QuotationDevice;
import cn.com.leadu.fms.pojo.prebiz.vo.quotationdevice.QuotationDeviceVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author lijunjun
 * @ClassName: QuotationDeviceDao
 * @Description: 报价器信息dao层
 * @date 2018-05-23
 */
public interface QuotationDeviceDao extends BaseDao<QuotationDevice> {

    /**
     * 分页获取报价器列表信息
     * @param quotationDeviceVo
     * @return List<QuotationDeviceVo>
     */
    List<QuotationDeviceVo> selectQuotationDevicesByPage(@Param("quotationDeviceVo") QuotationDeviceVo quotationDeviceVo);

    /**
     * 通过quotationDeviceId查询报价器信息
     * @param quotationDeviceId
     * @return QuotationDeviceVo
     */
    QuotationDeviceVo selectQuotationDeviceByQuotationDeviceId(@Param("quotationDeviceId") String quotationDeviceId);
}