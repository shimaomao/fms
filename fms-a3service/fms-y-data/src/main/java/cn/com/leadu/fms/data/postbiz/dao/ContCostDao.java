package cn.com.leadu.fms.data.postbiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.postbiz.entity.ContCost;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;

/**
 * @author wangxue
 * @ClassName: ContCostDao
 * @Description: 客户费用dao层
 */
public interface ContCostDao extends BaseDao<ContCost> {

    /**
     * @Title:
     * @Description:  根据合同号,获取对应款项的金额合计
     * @param contNo 合同编号
     * @param costItem 款项
     * @throws
     * @author wangxue
     * @date 2018-9-18 16:12:19
     */
    BigDecimal selectSumCostAmountByContNo(@Param("contNo") String contNo, @Param("costItem") String costItem);

}