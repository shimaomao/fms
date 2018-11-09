package cn.com.leadu.fms.data.finance.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.finance.entity.FinRepaySked;
import cn.com.leadu.fms.pojo.finance.vo.contrepaysked.ContRepaySkedVo;
import cn.com.leadu.fms.pojo.finance.vo.finrepaysked.FinRepaySkedVo;
import org.apache.ibatis.annotations.Param;

import java.math.BigDecimal;
import java.util.List;

/**
 * @author lijunjun
 * @ClassName: FinRepaySkedDao
 * @Description: 财务还款计划dao层
 * @date 2018-05-12
 */
public interface FinRepaySkedDao extends BaseDao<FinRepaySked> {

    /**
     * @Description: 查找财务还款计划表未还款剩余本金
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/22 11:05
     * @param
     */
    BigDecimal selectRestPrincipalAmountByContNo(@Param("contNo") String contNo);

    /**
     * @Description: 根据申请编号查找财务还款计划表未还款剩余本金
     * @param:
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/5/22 11:05
     * @param
     */
    BigDecimal selectRestPrincipalAmountByApplyNo(@Param("applyNo") String applyNo);


    /**
     * @Description: 分页查找财务合同还款明细
     * @param: finRepaySkedVo
     * @return:
     * @Author: ningyangyang
     * @Date: 2018/8/14 11:05
     * @param
     */
    List<ContRepaySkedVo> selectFinRepaySkedsByPage(@Param("finRepaySkedVo") FinRepaySkedVo finRepaySkedVo);
}