package cn.com.leadu.fms.data.prebiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.prebiz.entity.ContPay;
import cn.com.leadu.fms.pojo.prebiz.vo.contpay.ContPayVo;
import java.util.List;
import org.apache.ibatis.annotations.Param;

/**
 * @author liujinge
 * @ClassName: ContPayDao
 * @Description: 财务付款表dao层
 * @date 2018-04-11
 */
public interface ContPayDao extends BaseDao<ContPay> {

    /**
     * @Title:
     * @Description:  分页获取收款明细一览
     * @param contPayVo
     * @return List<contPayVo>
     * @throws
     * @author yebangqiang
     * @date 2018-7-21
     */
    List<ContPayVo> selectFinancialPrebizContPayDetailListByPage(@Param("contPayVo") ContPayVo contPayVo);

    /**
     * @Title:
     * @Description:  分页获取收款明细一览
     * @param contPayVo
     * @return List<contPayVo>
     * @throws
     * @author yebangqiang
     * @date 2018-7-21
     */
    List<ContPayVo> selectContPayListByPage(@Param("contPayVo") ContPayVo contPayVo);
}