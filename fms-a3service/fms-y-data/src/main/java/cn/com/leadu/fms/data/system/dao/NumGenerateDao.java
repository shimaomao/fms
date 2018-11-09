package cn.com.leadu.fms.data.system.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.system.entity.NumGenerate;
import org.apache.ibatis.annotations.Param;

/**
 * @author liujinge
 * @ClassName: NumGenerateDao
 * @Description: 业务编号管理dao层
 * @date 2018-03-26
 */
public interface NumGenerateDao extends BaseDao<NumGenerate> {
    /**
     * @Title:
     * @Description: 取得当前号并Lock该行
     * @param numType
     * @return NumGenerate
     * @throws
     * @author liujinge
     * @date 2018-3-26 14:53:41
     */
    NumGenerate selectByNumTypeLock(@Param("numType") String numType, @Param("generateDate") String generateDate);
}