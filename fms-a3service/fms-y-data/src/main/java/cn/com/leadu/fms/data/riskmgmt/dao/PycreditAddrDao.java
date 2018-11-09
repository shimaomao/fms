package cn.com.leadu.fms.data.riskmgmt.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditAddr;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditAddrDao
 * @Description: 地址核验dao层
 * @date 2018-06-04
 */
public interface PycreditAddrDao extends BaseDao<PycreditAddr> {
    List<PycreditAddr> selectPycreditAddrList(@Param("documentNo") String documentNo, @Param("ceilingNumber") int ceilingNumber);

    /** 
    * @Description: 查询最近一条查询记录 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/6 11:47
    */ 
    PycreditAddr selectLastPycreditAddrByDocumentNo(@Param("documentNo") String documentNo);
}