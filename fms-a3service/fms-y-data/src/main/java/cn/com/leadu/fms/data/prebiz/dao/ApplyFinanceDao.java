package cn.com.leadu.fms.data.prebiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.prebiz.entity.ApplyFinance;
import cn.com.leadu.fms.pojo.prebiz.vo.applyfinance.ApplyFinanceVo;
import org.apache.ibatis.annotations.Param;

/**
 * @author wangxue
 * @ClassName: ApplyFinanceDao
 * @Description: 融资信息dao层
 * @date 2018-03-24
 */
public interface ApplyFinanceDao extends BaseDao<ApplyFinance> {

    /**
     * @Title:
     * @Description: 根据订单编号 获取融资信息
     * @param applyNo 订单编号
     * @return ApplyFinanceVo
     * @throws
     * @author wangxue
     * @date 2018-3-29 17:39:58
     */
    ApplyFinanceVo selectApplyFinanceVoByApplyNo(@Param("applyNo")String applyNo);

}