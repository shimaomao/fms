package cn.com.leadu.fms.data.riskmgmt.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.riskmgmt.entity.PycreditCardCheck;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author yangyiquan
 * @ClassName: PycreditCardCheckDao
 * @Description: 卡核查及交易dao层
 * @date 2018-06-14
 */
public interface PycreditCardCheckDao extends BaseDao<PycreditCardCheck> {
    List<PycreditCardCheck> selectPycreditCardCheckList(@Param("documentNo") String documentNo, @Param("ceilingNumber") int ceilingNumber);

}