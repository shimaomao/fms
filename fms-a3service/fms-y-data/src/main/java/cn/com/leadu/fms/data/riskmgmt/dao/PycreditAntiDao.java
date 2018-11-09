package cn.com.leadu.fms.data.riskmgmt.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditAnti;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author liujinge
 * @ClassName: PycreditAntiDao
 * @Description: 反欺诈分析dao层
 * @date 2018-06-04
 */
public interface PycreditAntiDao extends BaseDao<PycreditAnti> {

   List<PycreditAnti> selectPycreditAntiList(@Param("documentNo") String documentNo,@Param("ceilingNumber") int ceilingNumber);

    /** 
    * @Description: 查询最近一条查询记录 
    * @param:  
    * @return:  
    * @Author: yangyiquan
    * @Date: 2018/7/3 15:29
    */ 
    PycreditAnti selectLastPycreditAntiByDocumentNo(@Param("documentNo") String documentNo);
}