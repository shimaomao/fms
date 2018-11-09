package cn.com.leadu.fms.data.riskmgmt.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCardCheck;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpBkcheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditCorpBkcheckDao
 * @Description: 企业银行卡核查dao层
 * @date 2018-06-04
 */
public interface PycreditCorpBkcheckDao extends BaseDao<PycreditCorpBkcheck> {
    List<PycreditCorpBkcheck> selectPycreditCorpBkcheckList(@Param("name") String name, @Param("ceilingNumber") int ceilingNumber);

    /** 
    * @Description: 查询最近一条企业银行卡核查 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/6 14:29
    */ 
    PycreditCorpBkcheck selectLastPycreditCorpBkcheckByDocumentNo(@Param("name") String name);
}