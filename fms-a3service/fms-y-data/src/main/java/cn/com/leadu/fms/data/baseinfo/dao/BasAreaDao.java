package cn.com.leadu.fms.data.baseinfo.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.baseinfo.entity.BasArea;
import cn.com.leadu.fms.pojo.baseinfo.vo.basarea.BasAreaVo;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author niehaibing
 * @ClassName: BasAreaDao
 * @Description: 省市县信息维护dao层
 * @date 2018-03-15
 */
public interface BasAreaDao extends BaseDao<BasArea> {
    BasAreaVo selectBaseAreaVoById(Object id);

    /**
     * @Title:
     * @Description: 分页取得省市县信息
     * @param basAreaVo 查询参数
     * @return list
     * @throws
     * @author liujinge
     * @date 2018-3-10 17:39:58
     */
    List<BasAreaVo> selectBasAreaVosByPage(@Param("basAreaVo")BasAreaVo basAreaVo);
    /**
     * @Title:
     * @Description: 根据区域ID，取得区域信息
     * @param areaId 区域Id
     * @return BasAreaVo
     * @throws
     * @author liujinge
     * @date 2018-3-14 14:39:58
     */
    BasAreaVo selectBasAreaVosByAreaId(@Param("areaId")String areaId);
}