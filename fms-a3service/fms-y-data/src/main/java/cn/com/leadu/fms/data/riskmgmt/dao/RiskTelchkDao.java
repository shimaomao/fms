package cn.com.leadu.fms.data.riskmgmt.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskTelchk;
import cn.com.leadu.fms.pojo.riskmgmt.vo.risktelchk.RiskTelchkVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: RiskTelchkDao
 * @Description: 风控电核信息dao层
 * @date 2018-06-04
 */
public interface RiskTelchkDao extends BaseDao<RiskTelchk> {
    /**
     * @Title:
     * @Description: 根据订单编号 获取电核信息
     * @param applyNo 订单编号
     * @return List<RiskTelchkVo>
     * @throws
     * @author liujinge
     * @date 2018-6-4 17:39:58
     */
    List<RiskTelchkVo> selectRiskTelchkByApplyNo(@Param("applyNo")String applyNo);
}