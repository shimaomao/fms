package cn.com.leadu.fms.data.finance.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.finance.entity.ContCharge;
import cn.com.leadu.fms.pojo.finance.vo.contcharge.ContChargeReceiptVo;
import cn.com.leadu.fms.pojo.finance.vo.contcharge.ContChargeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: ContChargeDao
 * @Description: 财务待收款dao层
 * @date 2018-06-01
 */
public interface ContChargeDao extends BaseDao<ContCharge> {

    /** 
    * @Description: 根据业务类型和业务号查询待收款数据和收款数据
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/28 11:24
    */ 
    List<ContChargeReceiptVo> selectContChargeAndReceiptByBizIdAndBizType(@Param("chargeBizId") String chargeBizId
            , @Param("chargeBizType") String chargeBizType, @Param("chargeFund") String chargeFund);
}