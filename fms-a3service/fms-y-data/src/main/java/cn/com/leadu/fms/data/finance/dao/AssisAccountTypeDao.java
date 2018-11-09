package cn.com.leadu.fms.data.finance.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.finance.entity.AssisAccountType;
import cn.com.leadu.fms.pojo.finance.vo.assisaccounttype.AssisAccountTypeVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author ningyangyang
 * @ClassName: AssisAccountTypeDao
 * @Description: 辅助核算类型管理dao层
 * @date 2018-06-23
 */
public interface AssisAccountTypeDao extends BaseDao<AssisAccountType> {
    /**
     * @Title:
     * @Description: 分页查询辅助核算类型管理弹出框
     * @param
     * @return
     * @throws
     * @author yanfengbo
     * @date
     */
    List<AssisAccountTypeVo> selectAssisAccountTypesByPage2(@Param("assisAccountTypeVo")AssisAccountTypeVo assisAccountTypeVo);
}