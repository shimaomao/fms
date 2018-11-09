package cn.com.leadu.fms.data.system.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.system.entity.SysTpl;
import cn.com.leadu.fms.pojo.system.vo.systpl.SysTplVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wubaoliang
 * @ClassName: SysTplDao
 * @Description: 模板管理dao层
 * @date 2018-03-12
 */
public interface SysTplDao extends BaseDao<SysTpl> {

    /**
     * @Title:
     * @Description: 根据查询条件 分页取得模板信息
     * @param sysTplVo 查询条件
     * @return List<SysTplVo>
     * @throws
     * @author wangxue
     * @date 2018-3-15 12:39:58
     */
    List<SysTplVo> selectSysTplVosByPages(@Param("sysTplVo") SysTplVo sysTplVo);

    /**
     * @Title:
     * @Description: 根据模板ID 获取获取模板信息
     * @param tplId 模板ID
     * @return SysTplVo
     * @throws
     * @author wangxue
     * @date 2018-3-15 12:39:58
     */
    SysTplVo selectSysTplVoByTplId(@Param("tplId") String tplId);

}