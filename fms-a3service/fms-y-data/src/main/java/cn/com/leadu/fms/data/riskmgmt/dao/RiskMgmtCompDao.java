package cn.com.leadu.fms.data.riskmgmt.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskMgmtComp;
import org.apache.ibatis.annotations.Param;

/**
 * @author liujinge
 * @ClassName: RiskMgmtCompDao
 * @Description: 风控企业信息dao层
 * @date 2018-06-04
 */
public interface RiskMgmtCompDao extends BaseDao<RiskMgmtComp> {
    /**
     * @Title:
     * @Description: 通过certifyNo查询风控企业信息
     * @param certifNo
     * @return RiskMgmtComp
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    RiskMgmtComp selectRiskMgmtCompByMain(@Param("certifNo")String certifNo,@Param("applyNo")String applyNo);
}