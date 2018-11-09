package cn.com.leadu.fms.data.postbiz.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.postbiz.entity.DeferTask;
import cn.com.leadu.fms.pojo.postbiz.vo.defertask.DeferTaskVo;
import org.apache.ibatis.annotations.Param;

/**
 * @author ningyangyang
 * @ClassName: DeferTaskDao
 * @Description: 合同展期dao层
 */
public interface DeferTaskDao extends BaseDao<DeferTask> {
    /**
     * 根据合同号查询合同明细信息
     * @param deferTaskVo
     * @return DeferTaskVo
     */
    DeferTaskVo selectDeferTaskVoByContNo(@Param("deferTaskVo") DeferTaskVo deferTaskVo);
}