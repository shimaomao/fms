package cn.com.leadu.fms.data.riskmgmt.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.riskmgmt.entity.RiskMgmtPerson;
import org.apache.ibatis.annotations.Param;

/**
 * @author liujinge
 * @ClassName: RiskMgmtPersonDao
 * @Description: 风控个人信息dao层
 * @date 2018-06-04
 */
public interface RiskMgmtPersonDao extends BaseDao<RiskMgmtPerson> {

    /**
     * @Title:
     * @Description: 通过certifyNo查询风控个人信息
     * @param certifNo
     * @return RiskMgmtPerson
     * @throws
     * @author liujinge
     * @date 2018-6-4 15:04:07
     */
    RiskMgmtPerson selectRiskMgmtPersonByMain(@Param("certifNo")String certifNo,@Param("applyNo")String applyNo);
}