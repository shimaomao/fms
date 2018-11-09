package cn.com.leadu.fms.data.riskmgmt.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCorpRisk;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditDriver;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditDriverDao
 * @Description: 驾驶证核查dao层
 * @date 2018-06-04
 */
public interface PycreditDriverDao extends BaseDao<PycreditDriver> {
    List<PycreditDriver> selectPycreditDriverList(@Param("documentNo") String documentNo, @Param("ceilingNumber") int ceilingNumber);

    /** 
    * @Description: 查询最近一条驾驶证核查实体 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/6 14:35
    */ 
    PycreditDriver selectLastPycreditDriverByDocumentNo(@Param("documentNo") String documentNo);
}