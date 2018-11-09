package cn.com.leadu.fms.data.riskmgmt.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditDriver;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditPersonBkcheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditPersonBkcheckDao
 * @Description: 个人银行卡核查dao层
 * @date 2018-06-04
 */
public interface PycreditPersonBkcheckDao extends BaseDao<PycreditPersonBkcheck> {
    List<PycreditPersonBkcheck> selectPycreditPersonBkcheckList(@Param("documentNo") String documentNo, @Param("ceilingNumber") int ceilingNumber);

    /** 
    * @Description: 查询最近一条个人银行卡核查
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/6 11:56
    */ 
    PycreditPersonBkcheck selectLastPycreditPersonBkcheckByDocumentNo(@Param("documentNo") String documentNo);
}