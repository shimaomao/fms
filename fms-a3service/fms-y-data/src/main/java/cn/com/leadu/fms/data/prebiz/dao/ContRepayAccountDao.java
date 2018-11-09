package cn.com.leadu.fms.data.prebiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.prebiz.entity.ContRepayAccount;
import cn.com.leadu.fms.pojo.prebiz.vo.contrepayaccount.ContRepayAccountListVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: ContRepayAccountDao
 * @Description: 合同还款信息dao层
 * @date 2018-03-23
 */
public interface ContRepayAccountDao extends BaseDao<ContRepayAccount> {
    /** 
    * @Description: 分页查询客户信息一览
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/5/9 10:47
    */ 
    List<ContRepayAccountListVo> selectContRepayAccountListByPage(@Param("contRepayAccountListVo") ContRepayAccountListVo contRepayAccountListVo);

}