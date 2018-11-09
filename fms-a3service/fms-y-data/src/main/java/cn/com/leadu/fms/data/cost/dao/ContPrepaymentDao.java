package cn.com.leadu.fms.data.cost.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.cost.entity.ContPrepayment;
import cn.com.leadu.fms.pojo.cost.vo.contprepayment.ContPrepaymentVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: ContPrepaymentDao
 * @Description: 提前还款dao层
 * @date 2018-05-10
 */
public interface ContPrepaymentDao extends BaseDao<ContPrepayment> {
    /** 
    * @Description: 关联合同表查询提前还款表
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/10 19:42
    */ 
    List<ContPrepaymentVo> selectContPrepaymentListByPage(@Param("contPrepaymentVo") ContPrepaymentVo contPrepaymentVo);

    /** 
    * @Description: 通过合同号查询提前还款相关信息
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/6/19 20:40
    */ 
    ContPrepaymentVo selectContPrepaymentByContNo(@Param("contPrepaymentVo") ContPrepaymentVo contPrepaymentVo);

    /**
     * @Description: 查找当日>提前还款失效日 且 合同未结清的提前还款
     * @param: uncleared 未结清状态
     * @param: prepaymentInvalid 提前还款作废状态
     * @return:
     * @Author: yangyiquan
     * @Date: 2018/10/24 17:18
     */
    List<ContPrepaymentVo> selectInValidContPrepayment(@Param("uncleared") String uncleared, @Param("prepaymentInvalid") String prepaymentInvalid, @Param("prepaymentValid") String prepaymentValid);
}