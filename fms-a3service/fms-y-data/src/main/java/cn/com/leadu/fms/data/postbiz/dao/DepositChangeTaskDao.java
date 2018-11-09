package cn.com.leadu.fms.data.postbiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.postbiz.entity.DepositChangeTask;
import cn.com.leadu.fms.pojo.postbiz.vo.depositchange.DepositChangeApplyVo;
import cn.com.leadu.fms.pojo.postbiz.vo.depositchange.DepositVehicleTypeVo;
import org.apache.ibatis.annotations.Param;

/**
 * @author huzongcheng
 * @ClassName: DepositChangeTaskDao
 * @Description: 保证金变更任务dao层
 */
public interface DepositChangeTaskDao extends BaseDao<DepositChangeTask> {
    /**
     * @Title:
     * @Description: 根据contNo获取申请页需要展示的基本信息
     * @param contNo 合同编号
     * @return DepositChangeApplyVo
     * @author huzongcheng
     * @date
     */
    DepositChangeApplyVo selectApplyInfoByContNo(@Param("contNo")String contNo);

    /**
     * @Title:
     * @Description: 根据contNo获取品牌车型
     * @param contNo 合同编号
     * @return DepositChangeApplyVo
     * @author huzongcheng
     * @date
     */
    DepositVehicleTypeVo selectVehicleType(@Param("contNo")String contNo);

}