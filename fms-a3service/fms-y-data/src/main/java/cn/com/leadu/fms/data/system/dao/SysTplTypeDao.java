package cn.com.leadu.fms.data.system.dao;

import cn.com.leadu.fms.data.base.config.BaseDao;
import cn.com.leadu.fms.pojo.system.entity.SysTplType;
import org.apache.ibatis.annotations.Param;

import java.util.List;

/**
 * @author wubaoliang
 * @ClassName: SysTplTypeDao
 * @Description: 模板类型管理dao层
 * @date 2018-03-12
 */
public interface SysTplTypeDao extends BaseDao<SysTplType> {

    /**
     * @Title:
     * @Description: 根据模板类型ID集合,获取使用这些模板类型的模板的件数
     * @param tplTypeIds 用户组Id
     * @return Long
     * @throws
     * @author wangxue
     * @date 2018-3-15 12:39:58
     */
    Long selectSysTplCountByTplTypeIds(@Param("tplTypeIds") List<String> tplTypeIds);

    /**
     * @Title:
     * @Description: 根据模板类型ID集合,获取模板类型的可设置项目集合
     * @param tplTypeIds 用户组Id
     * @return List<String>
     * @throws
     * @author wangxue
     * @date 2018-3-15 12:39:58
     */
    List<String> selectSysTplItemIdsByTplTypeIds(@Param("tplTypeIds") List<String> tplTypeIds);

}