package cn.com.leadu.fms.data.riskmgmt.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpBkcheck;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpDebt;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditCorpDebtDao
 * @Description: 企业债务dao层
 * @date 2018-06-04
 */
public interface PycreditCorpDebtDao extends BaseDao<PycreditCorpDebt> {
    List<PycreditCorpDebt> selectPycreditCorpDebtList(@Param("name") String name, @Param("ceilingNumber") int ceilingNumber);

    /** 
    * @Description: 查尊最近企业债务查询
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/6 15:20
    */ 
    PycreditCorpDebt selectLastPycreditCorpDebtByDocumentNo(@Param("name") String name);
}