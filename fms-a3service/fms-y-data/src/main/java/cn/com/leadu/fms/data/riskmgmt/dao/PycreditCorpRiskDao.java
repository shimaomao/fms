package cn.com.leadu.fms.data.riskmgmt.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpDebt;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpRisk;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditCorpRiskDao
 * @Description: 企业风险dao层
 * @date 2018-06-04
 */
public interface PycreditCorpRiskDao extends BaseDao<PycreditCorpRisk> {
    List<PycreditCorpRisk> selectPycreditCorpRiskList(@Param("name") String name, @Param("ceilingNumber") int ceilingNumber);

    /** 
    * @Description: 查询最近一条企业风险实体
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/6 15:05
    */ 
    PycreditCorpRisk selectLastPycreditCorpRiskByDocumentNo(@Param("name") String name);
}