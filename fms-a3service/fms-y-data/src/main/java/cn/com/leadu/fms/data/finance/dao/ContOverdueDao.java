package cn.com.leadu.fms.data.finance.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.finance.entity.ContOverdue;
import cn.com.leadu.fms.pojo.finance.vo.contoverdue.ContOverdueVo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: ContOverdueDao
 * @Description: 还款逾期罚息dao层
 * @date 2018-05-08
 */
public interface ContOverdueDao extends BaseDao<ContOverdue> {

    /** 
    * @Description:  查询逾期罚息表中，扣款状态<>成功 的剩余罚息金额合计
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/14 14:54
    */ 
    BigDecimal selectOverdueInterestSum(@Param("contOverdueVo") ContOverdueVo contOverdueVo);

    /**
     * @Description:  查询罚息表中未还款数量
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/15 14:54
     */
    Integer selectCountOverDueByContNo(@Param("contNo") String contNo);

    /**
     * @Description:  根据合同号查找总罚息
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/15 14:54
     */
    BigDecimal selectContOverdueAmountByContNo(@Param("contNo") String contNo);

    /**
     * @Description:  根据申请号查找总罚息
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/15 14:54
     */
    BigDecimal selectContOverdueAmountByApplyNo(@Param("applyNo") String applyNo);

    /**
     * @Title:
     * @Description: 根据合同号关联查询逾期罚息表和还款计划表
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    List<ContOverdueVo> selectContOverdueByCont(@Param("contNo") String contNo);
}